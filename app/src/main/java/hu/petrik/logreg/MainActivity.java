package hu.petrik.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText felhasznaloEditTextMain, jelszoEditTextMain;
    private Button bejelentkezesButtonMain, regisztracioButtonMain;
    private DBHelper adatbazis;

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

        bejelentkezesButtonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String felhasznaloNev = felhasznaloEditTextMain.getText().toString().trim();
                String jelszo = jelszoEditTextMain.getText().toString().trim();
                String atad = "";

                if (felhasznaloNev.isEmpty() || jelszo.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Minden mezőt ki kell tölteni!", Toast.LENGTH_SHORT).show();
                } else {
                    Cursor keres = adatbazis.keres(felhasznaloNev, jelszo);
                    if (keres.getCount() == 0) {
                        Toast.makeText(getApplicationContext(), "Rossz jelszó, vagy felhasználónév!", Toast.LENGTH_SHORT).show();
                    } else {
                        StringBuilder strB = new StringBuilder();
                        while (keres.moveToNext()) {
                            atad = strB.append(keres.getString(4)).toString();
                        }
                        Intent intent = new Intent(MainActivity.this, LoggedInActivity.class);
                        intent.putExtra("Teljesnev", atad);
                        startActivity(intent);
                        finish();
                    }
                }
            }
        });
    }

    public void init() {
        felhasznaloEditTextMain = findViewById(R.id.felhasznaloEditTextMain);
        jelszoEditTextMain = findViewById(R.id.jelszoEditTextMain);
        bejelentkezesButtonMain = findViewById(R.id.bejelentkezesButtonMain);
        regisztracioButtonMain = findViewById(R.id.regisztracioButtonMain);
        adatbazis = new DBHelper(this);
    }
}