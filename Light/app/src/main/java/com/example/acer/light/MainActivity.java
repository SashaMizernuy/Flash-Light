package com.example.acer.light;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import java.lang.reflect.Method;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    public Camera cam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // RelativeLayout r=(RelativeLayout) findViewById(R.layout.activity_main);
    }
    public   void lampOnClick(View v){
        ImageButton bt=(ImageButton)v;
        if(cam==null) {
            cam = Camera.open();
            Parameters p = cam.getParameters();
            p.setFlashMode(Parameters.FLASH_MODE_TORCH);//FLASH_MODE_ON;FLASH_MODE_AUTO;FLASH_MODE_MODE_RED_EYE;
            cam.setParameters(p);
            cam.startPreview();
            bt.setImageResource(R.drawable.btn_on);
        }
        else{ Parameters p = cam.getParameters();
            p.setFlashMode(Parameters.FLASH_MODE_OFF);
            cam.setParameters(p);
            cam.startPreview();
            cam.release();
            cam=null;
            bt.setImageResource(R.drawable.btn_off);
        }
    }

}
