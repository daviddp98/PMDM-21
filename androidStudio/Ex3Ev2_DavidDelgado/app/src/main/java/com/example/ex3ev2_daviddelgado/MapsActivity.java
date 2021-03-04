package com.example.ex3ev2_daviddelgado;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
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

        Bundle getExtras = getIntent().getExtras();

        String nombre = getExtras.getString("nombre");
        Double latitud = getExtras.getDouble("latitud");
        Double longitud = getExtras.getDouble("longitud");

        LatLng loc = new LatLng(latitud, longitud);
        mMap.addMarker(new MarkerOptions().position(loc).title(nombre).icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_marker)));

        //// Museo de Bellas Artes de Sevilla
        if (latitud == 37.392646943707796 && longitud == -5.999914383771823) {
            mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(37.39244949934984, -5.995230813946436))
                    .title("Confitería La Campana")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));

            mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(37.39348987323825, -5.988970123669488))
                    .title("Restaurante El Rinconcillo")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));

            mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(37.39765122447232, -5.996865284232353))
                    .title("Eslava")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));

            ///// MoMa de Nueva York
        } else if (latitud == 40.76165209156912 && longitud == -73.97766451810115) {
            mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(40.76563389168229, -73.98299674962287))
                    .title("Wendys, comida para llevar")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));

            mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(40.77775659764876, -73.9807973382308))
                    .title("CoCo Fresh Tea & Juice")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));

            mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(40.7599292796627, -73.97496085141407))
                    .title("Blue Bottle Coffee")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));

            ///// Museo Van Gogh
        } else if (latitud == 52.358494507493525 && longitud == 4.881665683760765) {
            mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(52.35993599070915, 4.8805069694663))
                    .title("PC Hooftstraat")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));

            mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(52.3568957165659, 4.878168083205252))
                    .title("El LovreXO Hotel Dinner")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
            ///// Museo del Louvre
        } else if (latitud == 48.86073813082154 && longitud == 2.3381160663922986) {
            mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(48.86047696898544, 2.340862648423622))
                    .title("Le Fumoir")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));

            mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(48.86236859687876, 2.339757578309457))
                    .title("Le Café Plume")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));

            mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(48.859298194552096, 2.3403905796369746))
                    .title("Coffee Crepes")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));

        }

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(loc, 15));

        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
    }
}