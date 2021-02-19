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

public class Location9999 extends AppCompatActivity {

    boolean shouldPlay = false;
    boolean offVolume;
    boolean radioAnother;
    boolean speed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location9999);
        //Разворачивает приложение на весь экран
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button cont = findViewById(R.id.cont);

        SharedPreferences save = getSharedPreferences("save",MODE_PRIVATE);
        offVolume = save.getBoolean("offVolume", offVolume);
        radioAnother = save.getBoolean("radio", radioAnother);
        speed = save.getBoolean("speed", speed);
        final SharedPreferences.Editor editor = save.edit();
        editor.putInt("location", 0);
        editor.putInt("coffee", 0);
        editor.putInt("game", 0);
        editor.apply();

        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.location9999_1);
                Button cont = findViewById(R.id.cont);

              if(!speed) {
                  speed=true;
                  Toast toast1 = Toast.makeText(Location9999.this, "Скорострел", Toast.LENGTH_LONG);
                  toast1.setGravity(Gravity.CENTER, 0, 0);
                  //Создаем разметку для заполнения ее изображением:
                  LinearLayout linearLayout = (LinearLayout) toast1.getView();
                  //Создаем в теле Toast объект типа ImageView:
                  ImageView imageView = new ImageView(Location9999.this);
                  //Привязываем к нему изображение:
                  imageView.setImageResource(R.drawable.speed1);
                  //Добавляем изображение к разметке для его отображения и запускаем Toast сообщение:
                  assert linearLayout != null;
                  linearLayout.addView(imageView);
                  toast1.show();
              }
              editor.putBoolean("speed", speed);
              editor.apply();
                cont.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        {
                            try {
                                Intent intent = new Intent(Location9999.this, MainActivity.class);
                                startActivity(intent);
                                shouldPlay = true;
                                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                                finish();
                            } catch (Exception ignored) {
                            }
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
            Intent intent = new Intent(Location9999.this, MainActivity.class);
            shouldPlay=true;
            startActivity(intent);
            overridePendingTransition(R.anim.right_out, R.anim.left_in);
            finish();
        } catch (Exception ignored){
        }
    }
}