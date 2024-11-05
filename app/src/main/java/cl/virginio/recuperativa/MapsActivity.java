package cl.virginio.recuperativa;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this); // Esto llama a onMapReady cuando el mapa está listo
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            LatLng point1 = new LatLng(extras.getDouble("lat1"), extras.getDouble("lon1"));
            LatLng point2 = new LatLng(extras.getDouble("lat2"), extras.getDouble("lon2"));
            LatLng point3 = new LatLng(extras.getDouble("lat3"), extras.getDouble("lon3"));


            mMap.addMarker(new MarkerOptions().position(point1).title("Punto 1"));
            mMap.addMarker(new MarkerOptions().position(point2).title("Punto 2"));
            mMap.addMarker(new MarkerOptions().position(point3).title("Punto 3"));


            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point1, 10));
        }
    }
}