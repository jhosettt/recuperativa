package cl.virginio.recuperativa;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final int SPLASH_DURATION = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        new Handler().postDelayed(() -> {
            Intent intent = new Intent(MainActivity.this, activity_main2.class);
            startActivity(intent);
            finish();
        }, SPLASH_DURATION);
    }
}