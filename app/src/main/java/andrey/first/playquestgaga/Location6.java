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

public class Location6 extends AppCompatActivity {

    boolean shouldPlay = false;
    boolean offVolume;
    boolean radioAnother;
    boolean group;
    boolean answer;
    int coffee;
    int game;
    int cup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location6);
        //Разворачивает приложение на весь экран
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Метод для сохранения состояний
        SharedPreferences save = getSharedPreferences("save",MODE_PRIVATE);
        offVolume = save.getBoolean("offVolume", offVolume);
        radioAnother = save.getBoolean("radio", radioAnother);
        coffee = save.getInt("coffee", coffee);
        game = save.getInt("game", game);
        cup = save.getInt("game", cup);
        group = save.getBoolean("group", false);
        answer = save.getBoolean("answer", false);
        final SharedPreferences.Editor editor = save.edit();
        editor.putInt("location", 18);
        editor.apply();

        Button location5_2 = findViewById(R.id.location5_2);
        Button location4_2 = findViewById(R.id.location4_2);
        Button location6_1 = findViewById(R.id.location6_1);
        Button location6_2 = findViewById(R.id.location6_2);

        location5_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exitFromLocation(Location5_2.class);
            }
        });

        location4_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exitFromLocation(Location4_2.class);
            }
        });

        location6_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if (group) {
                   Toast.makeText(getApplication(), "Пусть уже доиграют свою интересную игру...", Toast.LENGTH_SHORT).show();
               } else {
                   if(!answer) {
                       exitFromLocation(Location6_1.class);
                   } else {
                       exitFromLocation(Location6_1_1.class);
                   }
                }
            }
        });

        location6_2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if ((coffee==0)&(game==0)) {
                Toast.makeText(getApplication(), "Просто за пустым столом сидеть как то скучно", Toast.LENGTH_SHORT).show();
            } else { if(game==0) {
                exitFromLocation(Location6_2.class);
            } else {
                exitFromLocation(Location6_3.class);
            }
            }
        }
    });

}

    public void exitFromLocation(Class n) {
        try {
            Intent intent = new Intent(Location6.this, n);
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
            Intent intent = new Intent(Location6.this, MainActivity.class);
            shouldPlay=true;
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        } catch (Exception ignored){
        }
    }
}