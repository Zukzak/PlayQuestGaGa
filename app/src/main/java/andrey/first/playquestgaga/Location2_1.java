package andrey.first.playquestgaga;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Location2_1 extends AppCompatActivity {

    boolean shouldPlay = false;
    boolean offVolume;
    boolean radioAnother;
    boolean capuch;
    boolean amer;
    boolean kak;
    boolean cofemaniac;
    boolean crime;
    int coffee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Метод для сохранения состояний
        SharedPreferences save = getSharedPreferences("save",MODE_PRIVATE);
        offVolume = save.getBoolean("offVolume", offVolume);
        radioAnother = save.getBoolean("radio", radioAnother);
        capuch = save.getBoolean("capuchino",capuch);
        amer = save.getBoolean("amer",amer);
        kak = save.getBoolean("kak",kak);
        crime = save.getBoolean("crime",crime);
        cofemaniac = save.getBoolean("cofemaniac",cofemaniac);
        coffee = save.getInt("coffee", coffee);
        final SharedPreferences.Editor editor = save.edit();
        editor.putInt("location", 7);
        editor.apply();

        if(crime){
            setContentView(R.layout.location2_6);
        } else {
            setContentView(R.layout.location2_1);
        }
        //Разворачивает приложение на весь экран
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        final Button capuchino = findViewById(R.id.capuchino);
        Button americano = findViewById(R.id.americano);
        Button kakao = findViewById(R.id.kakao);
        Button back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exitFromLocation();
            }
        });

       if(coffee==1) {
           capuchino.setEnabled(false);
           capuchino.setBackgroundResource(R.drawable.button_background_off);
       } else {
           capuchino.setEnabled(true);
           capuchino.setBackgroundResource(R.drawable.button_pressed);
           capuchino.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   Toast.makeText(getApplication(), "Теплый капучино греет руки!", Toast.LENGTH_SHORT).show();
                   if(!capuch) {
                       capuch=true;
                       editor.putBoolean("capuchino", true);
                   }
                   if(capuch&kak&amer&!cofemaniac) {
                       Achieve achive = new Achieve();
                       achive.achievement("Кофенатор",getApplicationContext(),R.drawable.coffeemaniac1);
                       cofemaniac=true;
                       editor.putBoolean("cofemaniac", true);
                   }
                   exitFromLocation();
                   editor.putInt("coffee", 1);
                   editor.apply();
               }
           });
       }

        if(coffee==2) {
            americano.setEnabled(false);
            americano.setBackgroundResource(R.drawable.button_background_off);
        } else {
            americano.setEnabled(true);
            americano.setBackgroundResource(R.drawable.button_pressed);
            americano.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplication(), "Теплый американо греет руки!", Toast.LENGTH_SHORT).show();
                    if(!amer) {
                        amer=true;
                        editor.putBoolean("amer", true);
                    }
                    if(capuch&kak&amer&!cofemaniac) {
                        Achieve achive = new Achieve();
                        achive.achievement("Кофенатор",getApplicationContext(),R.drawable.coffeemaniac1);
                        cofemaniac=true;
                        editor.putBoolean("cofemaniac", true);
                    }
                    exitFromLocation();
                    editor.putInt("coffee", 2);
                    editor.apply();
                }
            });
        }

        if(coffee==3) {
            kakao.setEnabled(false);
            kakao.setBackgroundResource(R.drawable.button_background_off);
        } else {
            kakao.setEnabled(true);
            kakao.setBackgroundResource(R.drawable.button_pressed);
            kakao.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplication(), "Теплый какао греет руки!", Toast.LENGTH_SHORT).show();
                    if(!kak) {
                        kak=true;
                        editor.putBoolean("amer", true);
                    }
                    if(capuch&kak&amer&!cofemaniac) {
                        Achieve achive = new Achieve();
                        achive.achievement("Кофенатор",getApplicationContext(),R.drawable.coffeemaniac1);
                        cofemaniac=true;
                        editor.putBoolean("cofemaniac", true);
                    }
                    exitFromLocation();
                    editor.putInt("coffee", 3);
                    editor.apply();
                }
            });
        }

    }

    public void exitFromLocation() {
        try {
            Intent intent = new Intent(Location2_1.this, Location2.class);
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
            Intent intent = new Intent(Location2_1.this, MainActivity.class);
            shouldPlay=true;
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        } catch (Exception ignored){
        }
    }
}