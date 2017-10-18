package edu.nguyenmy.demoservice.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import edu.nguyenmy.demoservice.R;
import edu.nguyenmy.demoservice.service.PlaySongService;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnPlay, mBtnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnPlay = (Button)findViewById(R.id.btn_play);
        mBtnStop = (Button)findViewById(R.id.btn_stop);
        mBtnPlay.setOnClickListener(this);
        mBtnStop.setOnClickListener(this);
    }
    public void playMusic(){
        Intent serviceIntent = new Intent(MainActivity.this, PlaySongService.class);
        this.startService(serviceIntent);
    }
    public void stopMusic(){
        Intent serviceIntent = new Intent(MainActivity.this, PlaySongService.class);
        this.stopService(serviceIntent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_play:
                playMusic();
                MyReceiver myReceiver = new MyReceiver();
                Intent intent = new Intent(this, MyReceiver.class);
                myReceiver.onReceive(this,intent);
                break;
            case R.id.btn_stop:
                stopMusic();
                break;
            default:
                break;
        }
    }
    public class MyReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,"Music is playing",Toast.LENGTH_SHORT).show();
        }
    }
}
