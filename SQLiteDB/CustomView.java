package com.example.dell.apptest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

/**
 * Created by DELL on 01/09/2016.
 */
public class CustomView extends View {


    Bitmap bitmap;
    float Y;

    public CustomView (Context context){

        super(context);
        bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.pirate);
        bitmap= Bitmap.createScaledBitmap(bitmap, 200, 200, false);
        Y=0;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    canvas.drawColor(Color.WHITE);
    canvas.drawBitmap(bitmap,canvas.getWidth()/2,Y,null);

        if(Y<canvas.getHeight()) Y+=10;
        else Y=0;

     Rect rect=new Rect(0,400,canvas.getWidth(),550);
        Paint paint=new Paint();
        paint.setColor(Color.BLUE);

     canvas.drawRect(rect,paint);

        invalidate();
    }
}
