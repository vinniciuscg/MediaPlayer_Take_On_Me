package mediaplayer.vinicius.com.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private Button botaoTocar;
    private TextView textoExibir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoExibir = (TextView) findViewById(R.id.textViewId);
        botaoTocar = (Button) findViewById(R.id.buttonId);

        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.music);

        botaoTocar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying()){
                    pause();
                }else{
                    play();
                }
            }
        });
    }

    private void play(){
        if(mediaPlayer != null){
            mediaPlayer.start();
            botaoTocar.setText("Pausar");
            textoExibir.setText("Tocando...");
        }
    }

    private void pause(){
        if(mediaPlayer != null){
            mediaPlayer.pause();
            botaoTocar.setText("Tocar");
            textoExibir.setText("");
        }
    }

    @Override
    protected void onDestroy() {

        if(mediaPlayer != null && mediaPlayer.isPlaying()){
            mediaPlayer.release();
            mediaPlayer = null;
        }

        super.onDestroy();
    }
}
