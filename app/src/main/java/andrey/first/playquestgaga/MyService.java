package andrey.first.playquestgaga;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import java.util.ArrayList;
import java.util.Random;

public class MyService extends Service {
    MediaPlayer player = new MediaPlayer();
    ArrayList<Integer> songListGaga = new ArrayList<>();

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    final Random random = new Random();

    @Override
    public void onCreate() {




            songListGaga.add(R.raw.gaga1);
            songListGaga.add(R.raw.gaga2);
            songListGaga.add(R.raw.gaga3);
            songListGaga.add(R.raw.gaga4);
            songListGaga.add(R.raw.gaga5);

            player = MediaPlayer.create(this,songListGaga.get(random.nextInt(6)));
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
            player = MediaPlayer.create(MyService.this,songListGaga.get(random.nextInt(6)));
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