package andrey.first.playquestgaga;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;

import java.util.ArrayList;
import java.util.Random;

public class MyService2 extends Service {
    MediaPlayer player = new MediaPlayer();
    ArrayList<Integer> songListBirusa = new ArrayList<>();

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    final Random random = new Random();

    @Override
    public void onCreate() {

            songListBirusa.add(R.raw.birusa1);
            songListBirusa.add(R.raw.birusa2);
            songListBirusa.add(R.raw.birusa3);
            songListBirusa.add(R.raw.birusa4);
            songListBirusa.add(R.raw.birusa5);

            player = MediaPlayer.create(this,songListBirusa.get(random.nextInt(songListBirusa.size())));
            player.setAudioStreamType(AudioManager.STREAM_MUSIC);

        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                nextSong();
            }
        });

    }

    public void nextSong() {
            player.release();
            player = new MediaPlayer();
            player.setAudioStreamType(AudioManager.STREAM_MUSIC);
            player = MediaPlayer.create(MyService2.this,songListBirusa.get(random.nextInt(6)));
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                nextSong();
            }
        });
        player.start();
        }

    @Override
    public void onDestroy() {
        player.stop();
        player.release();
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        player.start();
        return START_STICKY;
    }
}