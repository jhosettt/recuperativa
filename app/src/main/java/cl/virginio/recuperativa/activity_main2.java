package cl.virginio.recuperativa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class activity_main2 extends AppCompatActivity {

    private EditText latitude1, longitude1;
    private EditText latitude2, longitude2;
    private EditText latitude3, longitude3;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        latitude1 = findViewById(R.id.latitude1);
        longitude1 = findViewById(R.id.longitude1);
        latitude2 = findViewById(R.id.latitude2);
        longitude2 = findViewById(R.id.longitude2);
        latitude3 = findViewById(R.id.latitude3);
        longitude3 = findViewById(R.id.longitude3);
        btnSubmit = findViewById(R.id.btnSubmit);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    double lat1 = Double.parseDouble(latitude1.getText().toString());
                    double lon1 = Double.parseDouble(longitude1.getText().toString());
                    double lat2 = Double.parseDouble(latitude2.getText().toString());
                    double lon2 = Double.parseDouble(longitude2.getText().toString());
                    double lat3 = Double.parseDouble(latitude3.getText().toString());
                    double lon3 = Double.parseDouble(longitude3.getText().toString());


                    Intent intent = new Intent(activity_main2.this, MapsActivity.class);
                    intent.putExtra("lat1", lat1);
                    intent.putExtra("lon1", lon1);
                    intent.putExtra("lat2", lat2);
                    intent.putExtra("lon2", lon2);
                    intent.putExtra("lat3", lat3);
                    intent.putExtra("lon3", lon3);

                    startActivity(intent);

                } catch (NumberFormatException e) {

                    Toast.makeText(activity_main2.this, "Por favor, ingrese coordenadas válidas", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}