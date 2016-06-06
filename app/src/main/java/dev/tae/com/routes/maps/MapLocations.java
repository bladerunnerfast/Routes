package dev.tae.com.routes.maps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import dev.tae.com.routes.R;

public class MapLocations extends FragmentActivity implements OnMapReadyCallback {
    private double[] gps = new double[]{};
    private String startName, endName;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_locations);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        Intent intent = getIntent();
        if(intent != null){
            gps = intent.getDoubleArrayExtra("gps");
            startName = intent.getStringExtra("startName");
            endName = intent.getStringExtra("endName");
            System.out.println("map start name: "+startName);
            System.out.println("map end name: "+endName);
        }
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        System.out.println("map GPS1: "+gps[0]+" "+gps[1]);
        System.out.println("map GPS2: "+gps[2]+" "+gps[3]);

        LatLng start = new LatLng(gps[0], gps[1]);
        LatLng end = new LatLng(gps[2], gps[3]);
        mMap.addMarker(new MarkerOptions().position(start).title(startName));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(start));
        mMap.addMarker(new MarkerOptions().position(end).title(endName));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(mMap.getCameraPosition().zoom - 0.5f));
    }
}
