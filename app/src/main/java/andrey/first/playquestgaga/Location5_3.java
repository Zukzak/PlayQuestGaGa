package andrey.first.playquestgaga;

import android.annotation.SuppressLint;
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

public class Location5_3 extends AppCompatActivity {

    boolean shouldPlay = false;
    boolean offVolume;
    boolean radioAnother;
    int coffee;
    int game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location5_3);
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
        editor.putInt("location", 16);
        editor.apply();


        Button answer3 = findViewById(R.id.answer3);

           answer3.setOnClickListener(new View.OnClickListener() {
               @SuppressLint("SetTextI18n")
               @Override
               public void onClick(View view) {
                   setContentView(R.layout.location5_3_1);
                    Button answer1 = findViewById(R.id.answer1);
                    Button answer2 = findViewById(R.id.answer2);
                    Button answer4 = findViewById(R.id.answer4);

                   answer1.setOnClickListener(new View.OnClickListener() {
                       @SuppressLint("SetTextI18n")
                       @Override
                       public void onClick(View view) {
                           setContentView(R.layout.location5_3_2);
                           Button cont = findViewById(R.id.cont);
                           cont.setOnClickListener(new View.OnClickListener() {
                               @Override
                               public void onClick(View view) {
                                   {
                                       exitFromLocation();
                                   }
                               }
                           });
                       }
                   });

                   answer2.setOnClickListener(new View.OnClickListener() {
                       @SuppressLint("SetTextI18n")
                       @Override
                       public void onClick(View view) {
                           setContentView(R.layout.location5_3_4);
                           Button cont = findViewById(R.id.cont);
                           cont.setOnClickListener(new View.OnClickListener() {
                               @Override
                               public void onClick(View view) {
                                   {
                                       exitFromLocation();
                                   }
                               }

                           });

                       }
                   });

                   answer4.setOnClickListener(new View.OnClickListener() {
                       @SuppressLint("SetTextI18n")
                       @Override
                       public void onClick(View view) {
                           setContentView(R.layout.location5_3_3);
                           Button cont = findViewById(R.id.cont);
                           editor.putBoolean("bizenis", true);
                           editor.apply();
                           Toast toast1 = Toast.makeText(Location5_3.this, "Бизенисмен", Toast.LENGTH_LONG);
                           toast1.setGravity(Gravity.CENTER, 0, 0);
                           //Создаем разметку для заполнения ее изображением:
                           LinearLayout linearLayout = (LinearLayout) toast1.getView();
                           //Создаем в теле Toast объект типа ImageView:
                           ImageView imageView = new ImageView(Location5_3.this);
                           //Привязываем к нему изображение:
                           imageView.setImageResource(R.drawable.bizenis1);
                           //Добавляем изображение к разметке для его отображения и запускаем Toast сообщение:
                           assert linearLayout != null;
                           linearLayout.addView(imageView);
                           toast1.show();
                           cont.setOnClickListener(new View.OnClickListener() {
                               @Override
                               public void onClick(View view) {
                                   {
                                       exitFromLocation();
                                   }
                               }

                           });

                       }
                   });
                   editor.putBoolean("sashadrus", true);
                   editor.apply();
               }
           });
       }

       public void exitFromLocation() {
           try {
               Intent intent = new Intent(Location5_3.this, Location5_1.class);
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
            Intent intent = new Intent(Location5_3.this, MainActivity.class);
            shouldPlay=true;
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        } catch (Exception ignored){
        }
    }
}