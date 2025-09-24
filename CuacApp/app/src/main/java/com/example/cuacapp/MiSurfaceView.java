package com.example.cuacapp;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.SurfaceHolder;
import android.graphics.Canvas;
import android.graphics.Paint;

public class MiSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    private SurfaceHolder holder;
    private Paint paint;

    public MiSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        holder = getHolder();
        holder.addCallback(this);

        paint = new Paint();
        paint.setColor(Color.WHITE);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {};
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int wigth, int height) {}

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {}

    //Dibujar un círculo
    public void dibujarFigura() {
        Canvas lienzo = holder.lockCanvas();
        if (lienzo != null) {
            lienzo.drawColor(Color.WHITE);  //Limpiamos el fondo

            //Lo colocamos en el centro del lienzo
            int X = lienzo.getWidth() / 2;
            int Y = lienzo.getHeight() / 2;
            int radio = 100;    //Radio del circulo
            lienzo.drawCircle(X, Y, radio, paint);
            holder.unlockCanvasAndPost(lienzo);
        }
    }

    //Limpiamos el canvas
    public void limpiar() {
        Canvas lienzo = holder.lockCanvas();
        if (lienzo != null) {
            lienzo.drawColor(Color.WHITE);
            holder.unlockCanvasAndPost(lienzo);
        }
    }
}
