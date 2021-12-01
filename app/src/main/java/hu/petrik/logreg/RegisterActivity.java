package hu.petrik.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    private EditText emailEditTextRegister, felhasznalonevEditTextRegister, jelszoEditTextRegister, teljesnevEditTextRegister;
    private Button regisztracioButtonRegister, visszaButtonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        init();

        regisztracioButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
    }
}