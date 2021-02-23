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
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Location2_4 extends AppCompatActivity {

    boolean shouldPlay = false;
    boolean offVolume;
    boolean radioAnother;
    boolean crime;
    int coffee;
    int game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location2_4);
        //Разворачивает приложение на весь экран
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Метод для сохранения состояний
        SharedPreferences save = getSharedPreferences("save", MODE_PRIVATE);
        offVolume = save.getBoolean("offVolume", offVolume);
        radioAnother = save.getBoolean("radio", radioAnother);
        coffee = save.getInt("coffee", coffee);
        game = save.getInt("game", game);
        crime = save.getBoolean("crime", crime);
        final SharedPreferences.Editor editor = save.edit();
        editor.putInt("location", 32);
        editor.apply();


        final Button accusation = findViewById(R.id.accusation);
        final Button back = findViewById(R.id.back);
        final Button exit = findViewById(R.id.exit);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exitFromLocation(Location2.class);
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView text = findViewById(R.id.textView);
                text.setText("Карточка остается с вами \n не забудте ее зарегистрировать!\n Ждем вас в гости снова!");
                text.setVisibility(View.VISIBLE);
                exit.setVisibility(View.INVISIBLE);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        exitFromLocation(Location9999.class);
                    }
                });
            }
        });

        accusation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.location2_5);
                Button one = findViewById(R.id.one);
                Button two = findViewById(R.id.two);
                Button three = findViewById(R.id.three);
                Button four = findViewById(R.id.four);
                Button five = findViewById(R.id.five);
                Button six = findViewById(R.id.six);
                Button seven = findViewById(R.id.seven);
                Button back1 = findViewById(R.id.back);
                back1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        exitFromLocation(Location2.class);
                    }
                });
                TextView text = findViewById(R.id.textView);
                text.setText("Кто же это?!");
                text.setVisibility(View.VISIBLE);
                exit.setVisibility(View.GONE);
                one.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplication(), "Чет я тупанул!", Toast.LENGTH_SHORT).show();
                        exitFromLocation(Location9999.class);
                    }
                });
                two.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplication(), "Что значит я в черном списке?!", Toast.LENGTH_SHORT).show();
                        exitFromLocation(Location9999.class);
                    }
                });
                three.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Achieve achive = new Achieve();
                        achive.achievement("Предатель",getApplicationContext(),R.drawable.traitor1);
                        editor.putBoolean("traitor", true);
                        editor.apply();
                        exitFromLocation(Location9999.class);
                    }
                });
                four.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Achieve achive = new Achieve();
                        achive.achievement("Шерлок",getApplicationContext(),R.drawable.sherlock1);
                        editor.putBoolean("sherlock", true);
                        editor.putInt("location", 0);
                        editor.apply();
                        exitFromLocation(MainActivity.class);
                    }
                });
                five.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplication(), "Что значит слишком низко обвинять его?!", Toast.LENGTH_SHORT).show();
                        exitFromLocation(Location9999.class);
                    }
                });
                six.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplication(), "У нее было алиби?!", Toast.LENGTH_SHORT).show();
                        exitFromLocation(Location9999.class);
                    }
                });
                seven.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplication(), "Что значит я в их игре и проиграл?!", Toast.LENGTH_SHORT).show();
                        exitFromLocation(Location9999.class);
                    }
                });
            }
        });
    }

    public void exitFromLocation(Class n) {
        try {
            Intent intent = new Intent(Location2_4.this, n);
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
            Intent intent = new Intent(Location2_4.this, MainActivity.class);
            shouldPlay=true;
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        } catch (Exception ignored){
        }
    }
}