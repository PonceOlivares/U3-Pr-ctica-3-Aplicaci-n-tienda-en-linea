package mx.edu.ittepic.u3_proyectotienda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Lienzo5(this));
    }
}
