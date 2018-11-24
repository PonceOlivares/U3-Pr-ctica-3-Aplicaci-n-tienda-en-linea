package mx.edu.ittepic.u3_proyectotienda;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.CountDownTimer;

public class Imagen4 {
    Bitmap icono;
    float x, y;
    boolean visible;
    float desplazamiento;

    public Imagen4(int resource, float _x, float _y, final Lienzo4 l) {
        icono = BitmapFactory.decodeResource(l.getResources(), resource);
        x = _x;
        y = _y;
        visible = true;

    }

    public void pintar(Canvas canvas, Paint p) {

        if (visible) {
            canvas.drawBitmap(icono, x, y, p);
        }
    }

    public void hacerVisible(boolean v) {
        visible = v;
    }

    public boolean estaEnArea(float xp, float yp) {
        if (!visible) return false;
        float x2, y2;
        x2 = x + icono.getWidth();
        y2 = y + icono.getHeight();

        if (xp >= x && xp <= x2) {//validando el rango de las x´s.
            if (yp >= y && yp <= y2) {//valida el rando de las y´s .  Se puede hacer en un solo if.
                return true;
            }
        }

        return false;

    }

    public void mover(float yp) {
        //x = xp - (icono.getWidth() / 2);
        y = yp - (icono.getHeight() / 2);
    }

    public boolean colision(Imagen objetoB) {
        float x2 = x + icono.getWidth();
        float y2 = y + icono.getHeight();

        if (objetoB.estaEnArea(x2, y)) {
            //caso 1
            return true;
        }
        if (objetoB.estaEnArea(x, y)) {
            //caso 2
            return true;
        }

        if (objetoB.estaEnArea(x2, y2)) {
            //caso 3
            return true;
        }

        if (objetoB.estaEnArea(x, y2)) {
            //caso 4
            return true;
        }
        return false;
    }

    public void mover2(float x1, float y1) {
        desplazamiento = x1;

    }

}
