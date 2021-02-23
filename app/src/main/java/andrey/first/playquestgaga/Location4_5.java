package andrey.first.playquestgaga;

import android.annotation.SuppressLint;
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


public class Location4_5 extends AppCompatActivity {

    boolean shouldPlay = false;
    boolean offVolume;
    boolean radioAnother;
    int coffee;
    int game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Метод для сохранения состояний
        SharedPreferences save = getSharedPreferences("save", MODE_PRIVATE);
        offVolume = save.getBoolean("offVolume", offVolume);
        radioAnother = save.getBoolean("radio", radioAnother);
        coffee = save.getInt("coffee", coffee);
        game = save.getInt("game", game);
        final SharedPreferences.Editor editor = save.edit();
        editor.putInt("location", 24);
        editor.apply();

     switch (game) {
         case 1:   {
             setContentView(R.layout.location4_5);
            View main = findViewById(R.id.main);
            main.setBackgroundResource(R.drawable.game1);
         }break;
         case 2:   {
             setContentView(R.layout.location4_5);
             View main = findViewById(R.id.main);
             main.setBackgroundResource(R.drawable.game3);
         }break;
         case 3:   {
             setContentView(R.layout.location4_5);
             View main = findViewById(R.id.main);
             main.setBackgroundResource(R.drawable.game2);
         }break;
       }

        //Разворачивает приложение на весь экран
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

       final Button answer1 = findViewById(R.id.answer1);

            answer1.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onClick(View view) {
                    answer1.setText("Надо проверить, что случилось");
                    TextView text = findViewById(R.id.textView);
                    text.setVisibility(View.VISIBLE);

                    answer1.setOnClickListener(new View.OnClickListener() {
                        @SuppressLint("SetTextI18n")
                        @Override
                        public void onClick(View view) {
                            try {
                                editor.putInt("game", 0);
                                editor.putInt("coffee", 0);
                                editor.putBoolean("crime", true);
                                editor.apply();
                                Intent intent = new Intent(Location4_5.this, Location7.class);
                                startActivity(intent);
                                shouldPlay = true;
                                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                                finish();
                            } catch (Exception ignored) {
                            }
                        }
                    });
                }
            });

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
    protected void onDestroy() {
        if(!shouldPlay) {
            stopService(new Intent(this, MyService2.class));
            stopService(new Intent(this, MyService.class));
        }
        super.onDestroy();
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
            Intent intent = new Intent(Location4_5.this, MainActivity.class);
            shouldPlay=true;
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        } catch (Exception ignored){
        }
    }
}