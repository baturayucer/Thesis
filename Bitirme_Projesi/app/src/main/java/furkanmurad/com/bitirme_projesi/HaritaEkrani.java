package furkanmurad.com.bitirme_projesi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by FurkanMurat on 28.10.2017.
 */

public class HaritaEkrani extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Marker marker = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_layout);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        System.exit(0);
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        mMap = googleMap;

//        Bitmap.Config conf = Bitmap.Config.ARGB_4444;
//        Bitmap bmp = Bitmap.createBitmap(100, 100, conf);
//        Canvas canvas1 = new Canvas(bmp);
//
//        Paint color = new Paint();
//
//        canvas1.drawBitmap(BitmapFactory.decodeResource(getResources(),
//                R.drawable.map_marker), 0,0, color);

        mMap.setMyLocationEnabled(true);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(40.764868, 29.940509), 13));


        mMap.addMarker(new MarkerOptions().position(new LatLng(40.762781,29.919403))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_marker)).title("Saat Kulesi"));

        mMap.addMarker(new MarkerOptions().position(new LatLng(40.762730, 29.931082))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_marker)).title("Pertev Mehmet Paşa Camii"));

        mMap.addMarker((new MarkerOptions().position(new LatLng(40.759776, 29.905250))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_marker)).title("Seka Park")));



        CustomInfoWindowGoogleMap customInfoWindowGoogleMap = new CustomInfoWindowGoogleMap(this);
        mMap.setInfoWindowAdapter(customInfoWindowGoogleMap);

        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Intent i = new Intent(HaritaEkrani.this, TumBilgiler.class);
                i.putExtra("data", marker.getTitle().toString());
                startActivity(i);
            }
        });

    }

}