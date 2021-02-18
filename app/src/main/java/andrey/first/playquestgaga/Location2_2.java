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

import androidx.appcompat.app.AppCompatActivity;

public class Location2_2 extends AppCompatActivity {

    boolean shouldPlay = false;
    boolean offVolume;
    boolean radioAnother;
    int coffee;
    int game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location2_2);
        //Разворачивает приложение на весь экран
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Метод для сохранения состояний
        SharedPreferences save = getSharedPreferences("save",MODE_PRIVATE);
        offVolume = save.getBoolean("offVolume", offVolume);
        radioAnother = save.getBoolean("radio", radioAnother);
        coffee = save.getInt("coffee", coffee);
        game = save.getInt("game", game);
        final SharedPreferences.Editor editor = save.edit();
        editor.putInt("location", 8);
        editor.apply();

        Button party = findViewById(R.id.party);
        Button classic = findViewById(R.id.classic);
        Button hard = findViewById(R.id.hard);
        Button back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exitFromLocation();
            }
        });

       if(game==1) {
           party.setEnabled(false);
           party.setBackgroundResource(R.drawable.button_background_off);
       } else {
           party.setEnabled(true);
           party.setBackgroundResource(R.drawable.button_pressed);
           party.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   exitFromLocation();
                   editor.putInt("game", 1);
                   editor.apply();
               }
           });
       }

        if(game==2) {
            classic.setEnabled(false);
            classic.setBackgroundResource(R.drawable.button_background_off);
        } else {
            classic.setEnabled(true);
            classic.setBackgroundResource(R.drawable.button_pressed);
            classic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    exitFromLocation();
                    editor.putInt("game", 2);
                    editor.apply();
                }
            });

        }

        if(game==3) {
            hard.setEnabled(false);
            hard.setBackgroundResource(R.drawable.button_background_off);
        } else {
            hard.setEnabled(true);
            hard.setBackgroundResource(R.drawable.button_pressed);
            hard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    exitFromLocation();
                    editor.putInt("game", 3);
                    editor.apply();
                }
            });

        }

    }

    public void exitFromLocation() {
        try {
            Intent intent = new Intent(Location2_2.this, Location2.class);
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
            Intent intent = new Intent(Location2_2.this, MainActivity.class);
            shouldPlay=true;
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        } catch (Exception ignored){
        }
    }
}