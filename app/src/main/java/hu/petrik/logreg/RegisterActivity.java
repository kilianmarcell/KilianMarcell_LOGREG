package hu.petrik.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText emailEditTextRegister, felhasznalonevEditTextRegister, jelszoEditTextRegister, teljesnevEditTextRegister;
    private Button regisztracioButtonRegister, visszaButtonRegister;
    private DBHelper adatbazis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        init();

        regisztracioButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditTextRegister.getText().toString().trim();
                String felhasznalonev = felhasznalonevEditTextRegister.getText().toString().trim();
                String jelszo = jelszoEditTextRegister.getText().toString().trim();
                String teljesnev = teljesnevEditTextRegister.getText().toString().trim();

                if (email.isEmpty() || felhasznalonev.isEmpty() || jelszo.isEmpty() || teljesnev.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Minden mezőt ki kell tölteni!", Toast.LENGTH_SHORT).show();
                } else {
                    if (adatbazis.adatFelvetel(email, felhasznalonev, jelszo, teljesnev)) {
                        Toast.makeText(getApplicationContext(), "Sikeres rögzítés!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Sikertelen rögzítés!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        visszaButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void init() {
        emailEditTextRegister = findViewById(R.id.emailEditTextRegister);
        felhasznalonevEditTextRegister = findViewById(R.id.felhasznalonevEditTextRegister);
        jelszoEditTextRegister = findViewById(R.id.jelszoEditTextRegister);
        teljesnevEditTextRegister = findViewById(R.id.teljesnevEditTextRegister);
        regisztracioButtonRegister = findViewById(R.id.regisztracioButtonRegister);
        visszaButtonRegister = findViewById(R.id.visszaButtonRegister);
        adatbazis = new DBHelper(this);
    }
}