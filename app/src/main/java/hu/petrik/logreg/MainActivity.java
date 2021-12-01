package hu.petrik.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText felhasznaloEditTextMain, jelszoEditTextMain;
    private Button bejelentkezesButtonMain, regisztracioButtonMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        regisztracioButtonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void init() {
        felhasznaloEditTextMain = findViewById(R.id.felhasznaloEditTextMain);
        jelszoEditTextMain = findViewById(R.id.jelszoEditTextMain);
        bejelentkezesButtonMain = findViewById(R.id.bejelentkezesButtonMain);
        regisztracioButtonMain = findViewById(R.id.regisztracioButtonMain);
    }
}