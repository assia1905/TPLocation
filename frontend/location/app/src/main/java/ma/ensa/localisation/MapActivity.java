package ma.ensa.localisation;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private RequestQueue requestQueue;
    private String showUrl = "http://192.168.0.107/localisation/showPositions.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        requestQueue = Volley.newRequestQueue(getApplicationContext());

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        setUpMap();
    }

    private void setUpMap() {
        String showUrl = "http://192.168.0.107:8081/localisation/showPositions.php";
        ProgressBar progressBar = findViewById(R.id.progressBar); // Ajouter un ProgressBar dans XML
        progressBar.setVisibility(View.VISIBLE);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, showUrl, (String) null,
                response -> {
                    // Traitez la réponse et ajoutez les marqueurs
                    try {
                        JSONArray positions = response.getJSONArray("positions");
                        for (int i = 0; i < positions.length(); i++) {
                            JSONObject position = positions.getJSONObject(i);
                            double latitude = position.getDouble("latitude");
                            double longitude = position.getDouble("longitude");
                            mMap.addMarker(new MarkerOptions()
                                    .position(new LatLng(latitude, longitude))
                                    .title("Position " + (i + 1))
                                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                        }
                        if (positions.length() > 0) {
                            JSONObject firstPosition = positions.getJSONObject(0);
                            double latitude = firstPosition.getDouble("latitude");
                            double longitude = firstPosition.getDouble("longitude");
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitude, longitude), 10));
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    progressBar.setVisibility(View.GONE); // Masquer le ProgressBar après chargement
                },
                error -> {
                    error.printStackTrace();
                    progressBar.setVisibility(View.GONE); // Masquer le ProgressBar en cas d'erreur
                });
        requestQueue.add(jsonObjectRequest);
    }
}
