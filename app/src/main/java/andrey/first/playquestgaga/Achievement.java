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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Achievement extends AppCompatActivity {

    boolean shouldPlay = false;
    boolean offVolume;
    boolean radioAnother;
    boolean speed;
    boolean kolya;
    boolean bizenis;
    boolean cofemaniac;
    boolean traitor;
    boolean igrolastik;
    boolean sherlock;
    boolean rag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.achievement);
        //Разворачивает приложение на весь экран
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        SharedPreferences save = getSharedPreferences("save",MODE_PRIVATE);
        offVolume = save.getBoolean("offVolume", offVolume);
        radioAnother = save.getBoolean("radio", radioAnother);
        speed = save.getBoolean("speed", speed);
        bizenis = save.getBoolean("bizenis", bizenis);
        cofemaniac = save.getBoolean("cofemaniac",cofemaniac);
        traitor = save.getBoolean("traitor",traitor);
        igrolastik = save.getBoolean("igrolastik", igrolastik);
        sherlock = save.getBoolean("sherlock", sherlock);
        rag = save.getBoolean("rag", rag);
        kolya = save.getBoolean("kolya", kolya);

        if (bizenis){
            ImageView speed = findViewById(R.id.bizenismen);
            speed.setBackgroundResource(R.drawable.bizenis1);
            TextView speedText = findViewById(R.id.textBizenismen);
            speedText.setVisibility(View.VISIBLE);
            speed.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(getApplication(), "Тебе бы играть на бирже!", Toast.LENGTH_SHORT).show();
                        }
                    }
            );
        }

        if (kolya){
            ImageView speed = findViewById(R.id.kolya);
            speed.setBackgroundResource(R.drawable.kolya1);
            TextView speedText = findViewById(R.id.textKolya);
            speedText.setVisibility(View.VISIBLE);
            speed.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(getApplication(), "Можешь взять конфетку!", Toast.LENGTH_SHORT).show();
                        }
                    }
            );
        }

        if (rag){
            ImageView speed = findViewById(R.id.rag);
            speed.setBackgroundResource(R.drawable.rag1);
            TextView speedText = findViewById(R.id.textRag);
            speedText.setVisibility(View.VISIBLE);
            speed.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(getApplication(), "Альтруизм хорошо, но не в таких колличествах", Toast.LENGTH_SHORT).show();
                        }
                    }
            );
        }

        if (igrolastik){
            ImageView speed = findViewById(R.id.gamemaster);
            speed.setBackgroundResource(R.drawable.gamemaster1);
            TextView speedText = findViewById(R.id.textGameMaster);
            speedText.setVisibility(View.VISIBLE);
            speed.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(getApplication(), "Похоже тебе пора вести обучения!", Toast.LENGTH_SHORT).show();
                        }
                    }
            );
        }

        if (cofemaniac){
            ImageView speed = findViewById(R.id.coffee);
            speed.setBackgroundResource(R.drawable.coffeemaniac1);
            TextView speedText = findViewById(R.id.textCoffee);
            speedText.setVisibility(View.VISIBLE);
            speed.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(getApplication(), "После тебя придётся менять капучинатор", Toast.LENGTH_SHORT).show();
                        }
                    }
            );
        }

        if (speed) {
            ImageView speed = findViewById(R.id.speed);
            speed.setBackgroundResource(R.drawable.speed1);
            TextView speedText = findViewById(R.id.textSpeed);
            speedText.setVisibility(View.VISIBLE);
            speed.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(getApplication(), "Не успел зайти, как сразу выходишь?", Toast.LENGTH_SHORT).show();
                        }
                    }
            );
        }

            if (sherlock){
                ImageView sherlock = findViewById(R.id.sherlock);
                sherlock.setBackgroundResource(R.drawable.sherlock1);
                TextView sherlockText = findViewById(R.id.textSherlock);
                sherlockText.setVisibility(View.VISIBLE);
                sherlock.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(getApplication(), "От тебя не скроется ни одна деталь!", Toast.LENGTH_SHORT).show();
                            }
                        }
                );
        }

        if (traitor){
            ImageView sherlock = findViewById(R.id.traitor);
            sherlock.setBackgroundResource(R.drawable.traitor1);
            TextView sherlockText = findViewById(R.id.textTraitor);
            sherlockText.setVisibility(View.VISIBLE);
            sherlock.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(getApplication(), "Иуда восхищается тобой", Toast.LENGTH_SHORT).show();
                        }
                    }
            );
        }


        Button btnBack = findViewById(R.id.backFromAchievement);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    Intent intent = new Intent(Achievement.this, MainActivity.class);
                    shouldPlay = true;
                    startActivity(intent);
                    overridePendingTransition(R.anim.right_out, R.anim.left_in);
                    finish();
                } catch (Exception ignored){
                }

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
            Intent intent = new Intent(Achievement.this, MainActivity.class);
            shouldPlay=true;
            startActivity(intent);
            overridePendingTransition(R.anim.right_out, R.anim.left_in);
            finish();
        } catch (Exception ignored){
        }
    }
}