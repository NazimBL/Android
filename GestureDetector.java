package com.example.dell.apptest;


import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,GestureDetector.OnDoubleTapListener {

    ViewGroup layout;
    Button add,drop;
    EditText edit;
    TextView text,geste;
    GestureDetectorCompat gesture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.gesture=new GestureDetectorCompat(this,this);
        gesture.setOnDoubleTapListener(this);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,(WindowManager.LayoutParams.FLAG_FULLSCREEN));

        initializer();

        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                moveButton();
                return true;
            }
        });
    }

    void initializer(){
      
        text=(TextView)findViewById(R.id.text);
        edit=(EditText)findViewById(R.id.edit);
        geste=(TextView)findViewById(R.id.gest);
        layout=(ViewGroup)findViewById(R.id.layout);
    }

    void moveButton(){
    
        View button=findViewById(R.id.b3);
        //the line that procure the smooth effect
        TransitionManager.beginDelayedTransition(layout);
        
        //position
        LinearLayout.LayoutParams positionRules=
                new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        positionRules.setMargins(200,400,5,5);
        button.setLayoutParams(positionRules);

        //size
        ViewGroup.LayoutParams sizeRules=button.getLayoutParams();
        sizeRules.width=400;
        sizeRules.height=300;
        button.setLayoutParams(sizeRules);
    }
   
    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {

        geste.setText("SINGLE TAP");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {

        geste.setText("DOUBLE TAP");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {

        geste.setText("DOUBLE TAP EVENT ?");
        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {

        geste.setText("DOWN");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {

        geste.setText("SHOW PRESS");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {

        geste.setText("SINGLE TAP UP");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {

        geste.setText("Scroll");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {

        geste.setText("Long press");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

        geste.setText("Fling");
        return true;
    }
}
