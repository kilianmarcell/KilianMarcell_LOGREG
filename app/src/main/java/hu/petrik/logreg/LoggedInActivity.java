package hu.petrik.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoggedInActivity extends AppCompatActivity {

    private TextView teljesnevTextViewLoggedIn;
    private Button kijelentkezesBtnLoggedIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);

        init();

        kijelentkezesBtnLoggedIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoggedInActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void init() {
        teljesnevTextViewLoggedIn = findViewById(R.id.teljesnevTextViewLoggedIn);
        kijelentkezesBtnLoggedIn = findViewById(R.id.kijelentkezesBtnLoggedIn);
    }
}