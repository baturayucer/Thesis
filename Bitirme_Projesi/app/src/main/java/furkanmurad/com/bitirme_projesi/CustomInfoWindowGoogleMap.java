package furkanmurad.com.bitirme_projesi;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

/**
 * Created by FurkanMurat on 13.11.2017.
 */

public class CustomInfoWindowGoogleMap implements GoogleMap.InfoWindowAdapter {

    private Context context;
    GoogleMap googleMap;

    public CustomInfoWindowGoogleMap(Context ctx) {
        context = ctx;
    }


    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }


    @Override
    public View getInfoContents(final Marker marker) {

        View view = ((Activity) context).getLayoutInflater().inflate(R.layout.info_location, null);

        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rlayout);

        TextView info_title = (TextView) view.findViewById(R.id.info_title);

        TextView info_snippet = (TextView) view.findViewById(R.id.info_snippet);

        ImageView img = (ImageView) view.findViewById(R.id.imageView);

        manageMarker(marker, info_title, info_snippet, img);

        return view;
    }


    private void manageMarker(Marker marker, TextView tv_infotitle, TextView tv_infosnippet, ImageView img) {
        if (marker.getTitle().equals("Saat Kulesi")) {
            tv_infotitle.setText(R.string.saatkulesi);
            tv_infosnippet.setText(R.string.devam);
            img.setImageResource(R.drawable.saatkulesi);

        } else if (marker.getTitle().equals("Seka Park")) {
            tv_infotitle.setText(R.string.sekapark);
            tv_infosnippet.setText(R.string.devam);
            img.setImageResource(R.drawable.sekapark);
        } else if (marker.getTitle().equals("Pertev Mehmet Paşa Camii")) {
            tv_infotitle.setText(R.string.pertevmehmetpasacamii);
            tv_infosnippet.setText(R.string.devam);
            img.setImageResource(R.drawable.pertevmehmetpasacamii);
        } else {
            tv_infotitle.setText(R.string.notfound_title);
            tv_infosnippet.setText(R.string.notfound_info);
            img.setImageResource(R.drawable.imagenotfound);
        }
    }


}
