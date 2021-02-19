package andrey.first.playquestgaga;

import androidx.appcompat.app.AppCompatActivity;

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

public class MainActivity extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;
    boolean shouldPlay = false;
    boolean offVolume;
    boolean radioAnother;
    boolean speed;
    int location;
    int coffee;
    int game;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Разворачивает приложение на весь экран
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        shouldPlay = false;
        SharedPreferences save = getSharedPreferences("save",MODE_PRIVATE);
        offVolume = save.getBoolean("offVolume", offVolume);
        radioAnother = save.getBoolean("radio", radioAnother);
        location = save.getInt("location",0);
        coffee = save.getInt("coffee",0);
        game = save.getInt("game",0);


         final Button btnProceed = findViewById(R.id.proceed);

         Button btnPlay = findViewById(R.id.play);
         Button btnSettings = findViewById(R.id.settings);
         Button btnAchievement = findViewById(R.id.achievement);

        if(!offVolume&!radioAnother) {
            startService(new Intent(this, MyService.class));
        }
        if(!offVolume&radioAnother) {
            startService(new Intent(this, MyService2.class));
        }

       if(!(location ==0)) {
           btnProceed.setEnabled(true);
           btnProceed.setBackgroundResource(R.drawable.button_pressed);

           btnProceed.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   switch (location) {
                       case 1: exitFromLocation(Location1.class); break;
                       case 2: exitFromLocation(Location1_1.class);break;
                       case 3: exitFromLocation(Location1_2.class);break;
                       case 4: exitFromLocation(Location1_3.class);break;
                       case 5: exitFromLocation(Location1_4.class);break;
                       case 6: exitFromLocation(Location2.class);break;
                       case 7: exitFromLocation(Location2_1.class);break;
                       case 8: exitFromLocation(Location2_2.class);break;
                       case 9: exitFromLocation(Location3.class);break;
                       case 10: exitFromLocation(Location4_1.class);break;
                       case 11: exitFromLocation(Location4_2.class);break;
                       case 12: exitFromLocation(Location4_3.class);break;
                       case 13: exitFromLocation(Location4_4.class);break;
                       case 14: exitFromLocation(Location5_1.class);break;
                       case 15: exitFromLocation(Location5_2.class);break;
                       case 16: exitFromLocation(Location5_3.class);break;
                       case 17: exitFromLocation(Location5_4.class);break;
                       case 18: exitFromLocation(Location6.class);break;
                       case 19: exitFromLocation(Location6_1.class);break;
                       case 20: exitFromLocation(Location6_1_1.class);break;
                       case 21: exitFromLocation(Location6_2.class);break;
                       case 22: exitFromLocation(Location5_5.class);break;
                       case 23: exitFromLocation(Location6_3.class);break;
                       case 24: exitFromLocation(Location4_5.class);break;
                       case 25: exitFromLocation(Location7.class);break;
                       case 26: exitFromLocation(Location4_6.class);break;
                       case 27: exitFromLocation(Location4_7.class);break;
                       case 28: exitFromLocation(Location5_6.class);break;
                       case 29: exitFromLocation(Location5_7.class);break;
                   }
                   }

           });
       } else {
           btnProceed.setEnabled(false);
       }

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnProceed.setEnabled(false);
                btnProceed.setBackgroundResource(R.drawable.button_background_off);

                try {
                    SharedPreferences save = getSharedPreferences("save",MODE_PRIVATE);
                    final SharedPreferences.Editor editor = save.edit();
                    editor.putInt("location", 0);
                    editor.putInt("coffee", 0);
                    editor.putInt("game", 0);
                    editor.putInt("cup", 0);
                    editor.putBoolean("alone", false);
                    editor.putBoolean("alone2", false);
                    editor.putBoolean("alone3", false);
                    editor.putBoolean("group", false);
                    editor.putBoolean("sasha", false);
                    editor.putBoolean("drus", false);
                    editor.putBoolean("sashadrus", false);
                    editor.putBoolean("answer", false);
                    editor.putBoolean("crime", false);
                    editor.apply();
                    Intent intent = new Intent(MainActivity.this,Location1.class);
                    shouldPlay = true;
                    startActivity(intent);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                } catch (Exception ignored){
                }
            }
        });

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    Intent intent = new Intent(MainActivity.this,Settings.class);
                    shouldPlay = true;
                    startActivity(intent);
                    overridePendingTransition(R.anim.right_in, R.anim.left_out);
                    finish();
                } catch (Exception ignored){
                }

            }
        });


        btnAchievement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(MainActivity.this,Achievement.class);
                    shouldPlay = true;
                    startActivity(intent);
                    overridePendingTransition(R.anim.right_in, R.anim.left_out);
                    finish();
                } catch (Exception ignored){
                }

            }
        });

}

    public void exitFromLocation(Class n) {
        try {
            Intent intent = new Intent(MainActivity.this, n);
           // intent.putExtra("offVolume", offVolume);
           // intent.putExtra("radio", radioAnother);
           // intent.putExtra("coffee", coffee);
           // intent.putExtra("game", game);
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


    //Системная кнопка назад
    public void onBackPressed() {
        //Выход из приложения при повторном нажитии
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();
           stopService(new Intent(this, MyService.class));
            stopService(new Intent(this, MyService2.class));
            return;
        } else {
            backToast = Toast.makeText(getBaseContext(),"Нажмите еще раз, чтобы выйти", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }

}
