package mx.edu.ittepic.u3_proyectotienda;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo3 extends View {
    Imagen3 art1, art2, art3, art4;
    Imagen3 nombreTienda, fondo, barraCat, barraCat2, marco1, marco2, marco3, marco4;;
    Imagen3 puntero;
    String categoria;

    public Lienzo3(Context context) {
        super(context);

        barraCat = new Imagen3(R.drawable.barracategorias2,0,270,this);
        barraCat2 = new Imagen3(R.drawable.barra,0,0,this);
        categoria="Jazz";
        fondo= new Imagen3(R.drawable.fondopantalla2,0,0,this);
        nombreTienda = new Imagen3(R.drawable.tiendanombre,50,10,this);
        art1  = new Imagen3(R.drawable.jazzamywinehouse, 10,350, this);
        art2  = new Imagen3(R.drawable.jazzenciassangrantes, 10,650, this);
        art3  = new Imagen3(R.drawable.jazzlouis, 10,950, this);
        art4  = new Imagen3(R.drawable.jazzmilesdavis, 10, 1250,this);

        marco1 = new Imagen3(R.drawable.winehouet, 350,700, this);
        marco2 = new Imagen3(R.drawable.enciasdet, 380,700, this);
        marco3 = new Imagen3(R.drawable.armstrongdet, 380,700, this);
        marco4 = new Imagen3(R.drawable.milesdadet, 380,700, this);
        marco1.hacerVisible(false);
        marco2.hacerVisible(false);
        marco3.hacerVisible(false);
        marco4.hacerVisible(false);

        puntero = null;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();
        fondo.pintar(canvas,p);
        barraCat.pintar(canvas,p);




        nombreTienda.hacerVisible(true);


        art1.pintar(canvas,p);
        art2.pintar(canvas,p);
        art3.pintar(canvas,p);
        art4.pintar(canvas,p);
        marco1.pintar(canvas,p);
        marco2.pintar(canvas,p);
        marco3.pintar(canvas,p);
        marco4.pintar(canvas,p);
        barraCat2.pintar(canvas,p);
        nombreTienda.pintar(canvas,p);
        p.setColor(Color.RED);
        p.setTextSize(50);
        canvas.drawText(categoria, 520, 300, p);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float xp = event.getX();
        float yp = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (art1.estaEnArea(xp,yp)){
                    puntero= art1;
                    marco1.hacerVisible(true);
                    marco2.hacerVisible(false);
                    marco3.hacerVisible(false);
                    marco4.hacerVisible(false);
                }
                if (art2.estaEnArea(xp,yp)){
                    puntero= art2;
                    marco2.hacerVisible(true);
                    marco1.hacerVisible(false);
                    marco3.hacerVisible(false);
                    marco4.hacerVisible(false);
                }
                if (art3.estaEnArea(xp,yp)){
                    puntero= art3;
                    marco3.hacerVisible(true);
                    marco2.hacerVisible(false);
                    marco1.hacerVisible(false);
                    marco4.hacerVisible(false);
                }
                if (art4.estaEnArea(xp,yp)){
                    puntero= art4;
                    marco4.hacerVisible(true);
                    marco2.hacerVisible(false);
                    marco3.hacerVisible(false);
                    marco1.hacerVisible(false);
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (puntero==art1){
                    art1.mover(yp);
                    art2.mover(yp+300);
                    art3.mover(yp+600);
                    art4.mover(yp+900);
                }
                if (puntero==art2){
                    art1.mover(yp-300);
                    art2.mover(yp);
                    art3.mover(yp+300);
                    art4.mover(yp+600);
                }
                if (puntero==art3){
                    art1.mover(yp-600);
                    art2.mover(yp-300);
                    art3.mover(yp);
                    art4.mover(yp+300);
                }
                if (puntero==art4){
                    art1.mover(yp-900);
                    art2.mover(yp-600);
                    art3.mover(yp-300);
                    art4.mover(yp);
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        invalidate();
        return true;
    }
}

