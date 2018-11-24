package mx.edu.ittepic.u3_proyectotienda;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo extends View {
    Imagen puntero, fondo, nombreTienda, barraCat, boton1;
    Imagen cat1,cat2, cat3, cat4, marco1, marco2, marco3, marco4;
    Imagen boton2, boton3, boton4;
    String mensaje;
    int contador=0;
    MainActivity aqui;


    public Lienzo(Context context) {
        super(context);

        nombreTienda = new Imagen(R.drawable.tiendanombre,50,10,this);
        barraCat = new Imagen(R.drawable.barracategorias,0,400,this);
        fondo= new Imagen(R.drawable.fondopantalla2,0,0,this);
        mensaje = "NO SE HA TOCADO EL OBJETO";
        cat1 = new Imagen(R.drawable.logoclasica , 1,425 , this);
        cat2 = new Imagen(R.drawable.logojazz , 300,425 , this);
        cat3 = new Imagen(R.drawable.logoindie , 600,425 , this);
        cat4 = new Imagen(R.drawable.logorock , 920,425 , this);


        marco1 = new Imagen(R.drawable.marcoclasica, 50,850, this);
        marco2 = new Imagen(R.drawable.marcojazz, 50,850, this);
        marco3 = new Imagen(R.drawable.marcoindie, 50,850, this);
        marco4 = new Imagen(R.drawable.marcorock, 50,850, this);

        boton1 = new Imagen(R.drawable.botonadelante, 800,1100,this);
        boton2 = new Imagen(R.drawable.botonadelante, 800, 1101,this);
        boton3 = new Imagen(R.drawable.botonadelante, 800, 1102,this);
        boton4 = new Imagen(R.drawable.botonadelante, 800, 1103,this);


        marco1.hacerVisible(false);
        marco2.hacerVisible(false);
        marco3.hacerVisible(false);
        marco4.hacerVisible(false);

        boton1.hacerVisible(false);
        boton2.hacerVisible(false);
        boton3.hacerVisible(false);
        boton4.hacerVisible(false);
        aqui=(MainActivity)context;
        puntero = null;//un puntero debe ser apuntado a null, no con new ni constructor,
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();
        fondo.pintar(canvas,p);
        nombreTienda.pintar(canvas,p);
        barraCat.pintar(canvas,p);

        cat1.pintar(canvas,p);
        cat2.pintar(canvas,p);
        cat3.pintar(canvas,p);
        cat4.pintar(canvas,p);

        marco1.pintar(canvas,p);
        marco2.pintar(canvas,p);
        marco3.pintar(canvas,p);
        marco4.pintar(canvas,p);

        boton1.pintar(canvas,p);
        boton2.pintar(canvas,p);
        boton3.pintar(canvas,p);
        boton4.pintar(canvas,p);

        p.setColor(Color.RED);
        p.setTextSize(50);
        //canvas.drawText(mensaje, 50, 100, p);


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float xp = event.getX();
        float yp = event.getY();
        //mensaje= "No se ha tocado objeto";
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (cat1.estaEnArea(xp,yp)){
                    puntero=cat1;
                    marco1.hacerVisible(true);
                    marco2.hacerVisible(false);
                    marco3.hacerVisible(false);
                    marco4.hacerVisible(false);

                    boton1.hacerVisible(true);
                    boton2.hacerVisible(false);
                    boton3.hacerVisible(false);
                    boton4.hacerVisible(false);
                    contador=1;
                }
                if (cat2.estaEnArea(xp,yp)){
                    puntero=cat2;
                    marco2.hacerVisible(true);
                    marco1.hacerVisible(false);
                    marco3.hacerVisible(false);
                    marco4.hacerVisible(false);

                    boton2.hacerVisible(true);
                    boton1.hacerVisible(false);
                    boton3.hacerVisible(false);
                    boton4.hacerVisible(false);

                    contador = 2;
                }
                if (cat3.estaEnArea(xp,yp)){
                    puntero=cat3;
                    marco3.hacerVisible(true);
                    marco2.hacerVisible(false);
                    marco1.hacerVisible(false);
                    marco4.hacerVisible(false);

                    boton3.hacerVisible(true);
                    boton1.hacerVisible(false);
                    boton2.hacerVisible(false);
                    boton4.hacerVisible(false);
                    contador=3;
                }
                if (cat4.estaEnArea(xp,yp)){
                    puntero=cat4;
                    marco4.hacerVisible(true);
                    marco2.hacerVisible(false);
                    marco3.hacerVisible(false);
                    marco1.hacerVisible(false);

                    boton4.hacerVisible(true);
                    boton1.hacerVisible(false);
                    boton2.hacerVisible(false);
                    boton3.hacerVisible(false);
                    contador=4;
                }
                if (boton1.estaEnArea(xp,yp)){
                    if (contador==1){
                        Intent i = new Intent(aqui, Main2Activity.class);
                        aqui.startActivity(i);
                    }

                }
                if (boton2.estaEnArea(xp,yp)){
                    if (contador==2){
                        Intent i = new Intent(aqui, Main3Activity.class);
                        aqui.startActivity(i);
                    }

                }
                if (boton3.estaEnArea(xp,yp)){
                    if (contador==3){
                        Intent i = new Intent(aqui, Main4Activity.class);
                        aqui.startActivity(i);
                    }

                }
                if (boton4.estaEnArea(xp,yp)){
                    if (contador==4){
                        Intent i = new Intent(aqui, Main5Activity.class);
                        aqui.startActivity(i);
                    }

                }



                break;
            case MotionEvent.ACTION_MOVE:
                if (puntero==cat1){
                 cat1.mover(xp);
                 cat2.mover(xp+300);
                 cat3.mover(xp+600);
                 cat4.mover(xp+900);
                }
                if (puntero==cat2){
                    cat1.mover(xp-300);
                    cat2.mover(xp);
                    cat3.mover(xp+300);
                    cat4.mover(xp+600);
                }
                if (puntero==cat3){
                    cat1.mover(xp-600);
                    cat2.mover(xp-300);
                    cat3.mover(xp);
                    cat4.mover(xp+300);
                }
                if (puntero==cat4){
                    cat1.mover(xp-900);
                    cat2.mover(xp-600);
                    cat3.mover(xp-300);
                    cat4.mover(xp);
                }

                break;
            case MotionEvent.ACTION_UP:

                puntero=null;
                break;
        }
        invalidate();
        return true;
    }
}
