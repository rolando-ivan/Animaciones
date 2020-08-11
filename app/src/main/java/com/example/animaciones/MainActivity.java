package com.example.animaciones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout textView;
    private TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto = findViewById(R.id.texto);
        textView = findViewById(R.id.textView);
        final EditText editText = findViewById(R.id.editText);
        Button boton = findViewById(R.id.boton);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animacion2 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.animacion_aparecer);
                editText.startAnimation(animacion2);
                editText.setVisibility(View.VISIBLE);
                textView.setVisibility(View.VISIBLE);
                Animation animacion = AnimationUtils.loadAnimation(MainActivity.this, R.anim.animacion);
                textView.startAnimation(animacion);
                ObjectAnimator animacionAlpha = ObjectAnimator.ofFloat(texto, "alpha", 1f, 0f);
                animacionAlpha.setDuration(2000);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(animacionAlpha);
                animatorSet.start();
            }
        });
        Button cerrar = findViewById(R.id.cerrar);
        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animacion2 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.animacion_desvanecer);
                editText.startAnimation(animacion2);
                editText.setVisibility(View.GONE);
                String nombre = editText.getText().toString();
                texto.setText(nombre);
                texto.setVisibility(View.VISIBLE);
                Animation animacion1 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.animacion_texto);
                texto.startAnimation(animacion1);
                Animation animacion = AnimationUtils.loadAnimation(MainActivity.this, R.anim.animacion_cerrar);
                textView.startAnimation(animacion);
                textView.setVisibility(View.GONE);
                ObjectAnimator animacionAlpha = ObjectAnimator.ofFloat(texto, "alpha", 0f, 1f);
                animacionAlpha.setDuration(2);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(animacionAlpha);
                animatorSet.start();
            }
        });

    }
}