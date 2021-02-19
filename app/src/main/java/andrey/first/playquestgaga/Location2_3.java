package andrey.first.playquestgaga;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Location2_3 extends AppCompatActivity {

    boolean shouldPlay = false;
    boolean offVolume;
    boolean radioAnother;
    int coffee;
    int game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location2_3);
        //Разворачивает приложение на весь экран
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Метод для сохранения состояний
        SharedPreferences save = getSharedPreferences("save", MODE_PRIVATE);
        offVolume = save.getBoolean("offVolume", offVolume);
        radioAnother = save.getBoolean("radio", radioAnother);
        coffee = save.getInt("coffee", coffee);
        game = save.getInt("game", game);
        final SharedPreferences.Editor editor = save.edit();
        editor.putInt("location", 8);
        editor.apply();

        final Button coffee = findViewById(R.id.coffee);
        final Button game = findViewById(R.id.game);
        final Button back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exitFromLocation();
            }
        });

        coffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView text = findViewById(R.id.textView);
                text.setText("Нам только сегодня\n привезли новые зерна,\n как раз собираем мнения!");
                text.setVisibility(View.VISIBLE);
                game.setVisibility(View.INVISIBLE);
                coffee.setVisibility(View.INVISIBLE);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        exitFromLocation();
                    }
                });
            }
        });

        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView text = findViewById(R.id.textView);
                text.setText("Могу посоветовать Таймлайн!");
                text.setVisibility(View.VISIBLE);
                game.setVisibility(View.INVISIBLE);
                coffee.setVisibility(View.INVISIBLE);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        exitFromLocation();
                    }
                });
            }
        });
    }

    public void exitFromLocation() {
        try {
            Intent intent = new Intent(Location2_3.this, Location2.class);
            startActivity(intent);
            shouldPlay = true;
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        } catch (Exception ignored) {
        }
    }

    @Override
    protected void onPause() {
        if(!shouldPlay) {
            stopService(new Intent(this, MyService.class));
            stopService(new Intent(this, MyService2.class));
        }
        super.onPause();
    }


    @Override
    protected void onResume() {
        if(isMyServiceRunning() &!offVolume&!radioAnother)
            startService(new Intent(this, MyService.class));
        if(isMyServiceRunning() &!offVolume&radioAnother)
            startService(new Intent(this, MyService2.class));
        super.onResume();
    }

    private boolean isMyServiceRunning() {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if ((MyService.class.getName().equals(service.service.getClassName()))&&(MyService2.class.getName().equals(service.service.getClassName()))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(Location2_3.this, MainActivity.class);
            shouldPlay=true;
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        } catch (Exception ignored){
        }
    }
}