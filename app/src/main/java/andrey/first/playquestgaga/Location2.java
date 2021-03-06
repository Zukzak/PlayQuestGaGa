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
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Location2 extends AppCompatActivity {

    boolean shouldPlay = false;
    boolean offVolume;
    boolean radioAnother;
    boolean crime;
    int coffee;
    int game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Метод для сохранения состояний
        SharedPreferences save = getSharedPreferences("save",MODE_PRIVATE);
        offVolume = save.getBoolean("offVolume", offVolume);
        radioAnother = save.getBoolean("radio", radioAnother);
        crime = save.getBoolean("crime", crime);
        coffee = save.getInt("coffee", coffee);
        game = save.getInt("game", game);
        final SharedPreferences.Editor editor = save.edit();
        editor.putInt("location", 6);
        editor.apply();

        if(crime){
            setContentView(R.layout.location21);
        } else {
            setContentView(R.layout.location2);
        }
        //Разворачивает приложение на весь экран
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        Button location2_1 = findViewById(R.id.location2_1);
        Button location2_2 = findViewById(R.id.location2_2);
        Button location2_3 = findViewById(R.id.location2_3);
        Button location3 = findViewById(R.id.location3);

        location2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(crime) {
                    exitFromLocation(Location2_1.class);
                } else {
                    exitFromLocation(Location2_1.class);
                }
            }
        });

        location2_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              if(crime) {
                  Toast.makeText(getApplication(), "Наверное, лучше ее сейчас не трогать...", Toast.LENGTH_SHORT).show();
              } else {
                  exitFromLocation(Location2_2.class);
              }
            }
        });

        location2_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (crime) {
                    exitFromLocation(Location2_4.class);
                } else {
                    exitFromLocation(Location2_3.class);
                }
            }
        });

        location3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exitFromLocation(Location3.class);
            }
        });

    }

    public void exitFromLocation(Class n) {
        try {
            Intent intent = new Intent(Location2.this, n);
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
            Intent intent = new Intent(Location2.this, MainActivity.class);
            shouldPlay=true;
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        } catch (Exception ignored){
        }
    }
}