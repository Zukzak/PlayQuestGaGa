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

public class Location6_4 extends AppCompatActivity {

    boolean shouldPlay = false;
    boolean offVolume;
    boolean radioAnother;
    boolean drus;
    boolean group2;
    int coffee;
    int game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Метод для сохранения состояний
        SharedPreferences save = getSharedPreferences("save",MODE_PRIVATE);
        offVolume = save.getBoolean("offVolume", offVolume);
        radioAnother = save.getBoolean("radio", radioAnother);
        drus = save.getBoolean("drus", drus);
        group2 = save.getBoolean("group2", group2);
        coffee = save.getInt("coffee", coffee);
        game = save.getInt("game", game);
        final SharedPreferences.Editor editor = save.edit();
        editor.putInt("location", 30);
        editor.apply();

        if (group2) {
            setContentView(R.layout.location6_5);
        } else {
            setContentView(R.layout.location6_4);
        }
        //Разворачивает приложение на весь экран
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);




        final Button answer1 = findViewById(R.id.answer1);

        answer1.setOnClickListener(new View.OnClickListener() {
                       @SuppressLint("SetTextI18n")
                       @Override
                       public void onClick(View view) {
                           final View main = findViewById(R.id.main);
                           main.setBackgroundResource(R.drawable.location6_1_2);
                           final TextView text = findViewById(R.id.textView);
                           text.setVisibility(View.VISIBLE);
                           answer1.setText("Где вы все были в это время?");
                           answer1.setOnClickListener(new View.OnClickListener() {
                               @Override
                               public void onClick(View view) {
                                   main.setBackgroundResource(R.drawable.location6_1);
                                   text.setText("Мы играли!\n Никто не уходил!\n Каждый готов подтвердить!");
                                   if(drus) {
                                       answer1.setText("Гость видел, \nкак девушка выходила из Зала...");
                                       answer1.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View view) {
                                               main.setBackgroundResource(R.drawable.location6_12);
                                               text.setText("Да... наша подруга\n ходила за печеньем,\n мы боялись сказать...");
                                               answer1.setText("Далее");
                                               answer1.setOnClickListener(new View.OnClickListener() {
                                                                              @Override
                                                                              public void onClick(View view) {
                                                                                  main.setBackgroundResource(R.drawable.location6_11);
                                                                                  text.setText("Но к ресепшн\n она не подходила и видела\n там лишь сотрудников!");
                                                                                  answer1.setText("Я вам верю.");
                                                                                  answer1.setOnClickListener(new View.OnClickListener() {
                                                                                      @Override
                                                                                      public void onClick(View view) {
                                                                                          editor.putBoolean("group3", true);
                                                                                          editor.apply();
                                                                                          exitFromLocation();
                                                                                      }
                                                                                  });
                                                                              }
                                                                          });
                                           }
                                       });
                                   } else {
                                       answer1.setText("Ясно...");
                                       answer1.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                                   editor.putBoolean("group2", true);
                                                   editor.apply();
                                                   exitFromLocation();
                                       }
                                       });
                                   }
                               }
                           });
                       }
                   });
       }

       public void exitFromLocation() {
           try {
               Intent intent = new Intent(Location6_4.this, Location6.class);
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
            Intent intent = new Intent(Location6_4.this, MainActivity.class);
            shouldPlay=true;
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        } catch (Exception ignored){
        }
    }
}