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
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Settings extends AppCompatActivity {

    boolean shouldPlay = false;
    boolean offVolume;
    boolean radioAnother;
    boolean savedOffVolume;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        //Разворачивает приложение на весь экран
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Определеник нопок на экране
        Button btnBack = findViewById(R.id.backFromSettings);
        @SuppressLint("UseSwitchCompatOrMaterialCode")
        Switch volOnOff = findViewById(R.id.settingsOnOff);
        RadioButton radioGaga = findViewById(R.id.radioGaga);
        RadioButton radioBirusa = findViewById(R.id.radioBirusa);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
       final int selectRadio = radioGroup.getCheckedRadioButtonId();
        //Метод для сохранения состояний
        SharedPreferences save = getSharedPreferences("save",MODE_PRIVATE);
        final SharedPreferences.Editor editor = save.edit();

        //Загружаем состояние
        offVolume = save.getBoolean("offVolume", offVolume);
        radioAnother = save.getBoolean("radio", radioAnother);
        if (radioAnother) {
            radioBirusa.setChecked(true); radioGaga.setChecked(false);
        } else {
            radioBirusa.setChecked(false); radioGaga.setChecked(true);
        }
        volOnOff.setChecked(offVolume);


        volOnOff.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)  {
                    stopService(new Intent(Settings.this, MyService.class));
                    stopService(new Intent(Settings.this, MyService2.class));
                    offVolume=true;

                } else {
                    if(radioAnother) {
                        startService(new Intent(Settings.this, MyService2.class));
                    } else {
                        startService(new Intent(Settings.this, MyService.class));
                    }
                    offVolume=false;
                }
                //Сохраняем состояние
                editor.putBoolean("offVolume", offVolume);
                editor.apply();
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int selectRadio) {
                        RadioButton rb = group.findViewById(selectRadio);
                        switch (rb.getId()) {
                            case R.id.radioGaga: {
                                stopService(new Intent(Settings.this, MyService2.class));
                                startService(new Intent(Settings.this, MyService.class));
                                radioAnother=false;
                            }
                            break;
                            case R.id.radioBirusa: {
                                stopService(new Intent(Settings.this, MyService.class));
                                startService(new Intent(Settings.this, MyService2.class));
                                radioAnother=true;
                            }
                            break;
                            default:
                                break;
                        }
                        editor.putBoolean("radio", radioAnother);
                        editor.apply();
                    }
                });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Settings.this, MainActivity.class);
                    startActivity(intent);
                    shouldPlay = true;
                    overridePendingTransition(R.anim.right_out, R.anim.left_in);
                    finish();
                } catch (Exception e){
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
    protected void onResume() {
        if(!isMyServiceRunning()&!offVolume&!radioAnother)
            startService(new Intent(this, MyService.class));
        if(!isMyServiceRunning()&!offVolume&radioAnother)
            startService(new Intent(this, MyService2.class));
        super.onResume();
    }


    private boolean isMyServiceRunning() {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if ((MyService.class.getName().equals(service.service.getClassName()))&&(MyService2.class.getName().equals(service.service.getClassName()))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(Settings.this, MainActivity.class);
            intent.putExtra("offVolume", offVolume);
            intent.putExtra("radio", radioAnother);
            shouldPlay=true;
            startActivity(intent);
            overridePendingTransition(R.anim.right_out, R.anim.left_in);
            finish();
        } catch (Exception e){
        }
    }
}