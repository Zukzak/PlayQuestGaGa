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

public class Location5_1 extends AppCompatActivity {

    boolean shouldPlay = false;
    boolean offVolume;
    boolean radioAnother;
    boolean sashadrus;
    boolean sasha;
    boolean crime;
    int coffee;
    int game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location5_1);
        //Разворачивает приложение на весь экран
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Метод для сохранения состояний
        SharedPreferences save = getSharedPreferences("save",MODE_PRIVATE);
        offVolume = save.getBoolean("offVolume", offVolume);
        radioAnother = save.getBoolean("radio", radioAnother);
        coffee = save.getInt("coffee", coffee);
        game = save.getInt("game", game);
        crime = save.getBoolean("crime", crime);
        sashadrus = save.getBoolean("sashadrus", false);
        sasha = save.getBoolean("sasha", false);
        final SharedPreferences.Editor editor = save.edit();
        editor.putInt("location", 14);
        editor.apply();

        Button location3 = findViewById(R.id.location3);
        Button location6 = findViewById(R.id.location6);
        Button location5_3 = findViewById(R.id.location5_3);
        Button location5_4 = findViewById(R.id.location5_4);

        location3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exitFromLocation(Location3.class);
            }
        });

        location6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exitFromLocation(Location6.class);
            }
        });

        location5_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(crime){
                   if (sasha) {
                       Toast.makeText(getApplication(), "Все еще бормочит про волосы...", Toast.LENGTH_SHORT).show();
                   }
                   else {
                       exitFromLocation(Location5_6.class);
                   }
               }
               else {
                   if (sashadrus) {
                       Toast.makeText(getApplication(), "Похоже они обсуждают уже что-то другое...", Toast.LENGTH_SHORT).show();
                   } else {
                       exitFromLocation(Location5_3.class);
                   }
               }
            }
        });

        location5_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((coffee==0)&(game==0)) {
                    Toast.makeText(getApplication(), "Просто за пустым столом сидеть как то скучно", Toast.LENGTH_SHORT).show();
                } else { if(game==0) {
                    exitFromLocation(Location5_4.class);
                } else {
                    exitFromLocation(Location5_5.class);
                }
                }
            }
        });


    }

    public void exitFromLocation(Class n) {
        try {
            Intent intent = new Intent(Location5_1.this, n);
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
            Intent intent = new Intent(Location5_1.this, MainActivity.class);
            shouldPlay=true;
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        } catch (Exception ignored){
        }
    }
}