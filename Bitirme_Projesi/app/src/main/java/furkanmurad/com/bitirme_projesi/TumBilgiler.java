package furkanmurad.com.bitirme_projesi;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by FurkanMurat on 23.11.2017.
 */

public class TumBilgiler extends Activity {

    private LinearLayout mGallery;
    private int[] mImgIds;
    private LayoutInflater mInflater;
    private HorizontalScrollView horizontalScrollView;

    TextView tv;
  //  private View cell;
   // private LinearLayout linearLayout;
    private int[] img_saatKulesi = {R.drawable.saatkulesi, R.drawable.saatkulesi0, R.drawable.saatkulesi1,
            R.drawable.saatkulesi2, R.drawable.saatkulesi3, R.drawable.saatkulesi4};
    private int[] img_pertevmehmetpasa = {R.drawable.pertevmehmetpasa0, R.drawable.pertevmehmetpasa1,
            R.drawable.pertevmehmetpasa3, R.drawable.pertevmehmetpasa4};

    private int[] img_sekapark = {R.drawable.sekapark, R.drawable.sekapark1, R.drawable.sekapark2};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cell_main);

        mInflater = LayoutInflater.from(this);

        mGallery = (LinearLayout) findViewById(R.id._linearLayout);

        String data = getIntent().getExtras().get("data").toString();



        switch (data) {
            case "Saat Kulesi":
                for (int i = 0; i < img_saatKulesi.length; i++) {
                    View view = mInflater.inflate(R.layout.cell, mGallery, false);
                    ImageView img = (ImageView) view.findViewById(R.id._image);
                    img.setImageBitmap(decodeSampledBitmapFromResource(getResources(), img_saatKulesi[i], 100, 100));
                    mGallery.addView(view);


                    img.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            tv = (TextView) findViewById(R.id.info_img);
                            tv.setText(R.string.saatkulesi_info);
                            tv.setVisibility(View.VISIBLE);
                        }
                    });
                }
                break;

            case "Pertev Mehmet Paşa Camii":
                for (int i = 0; i < img_pertevmehmetpasa.length; i++) {
                    View view = mInflater.inflate(R.layout.cell, mGallery, false);
                    ImageView img = (ImageView) view.findViewById(R.id._image);
                    img.setImageBitmap(decodeSampledBitmapFromResource(getResources(), img_pertevmehmetpasa[i], 100, 100));
                    mGallery.addView(view);
                }
                break;

            case "Seka Park":
                for (int i = 0; i < img_sekapark.length; i++) {
                    View view = mInflater.inflate(R.layout.cell, mGallery, false);
                    ImageView img = (ImageView) view.findViewById(R.id._image);
                    img.setImageBitmap(decodeSampledBitmapFromResource(getResources(), img_sekapark[i], 100, 100));
                    mGallery.addView(view);
                }
                break;
            default:
                    Toast.makeText(getApplicationContext(), "DEFAULT", Toast.LENGTH_SHORT).show();
                    break;
        }




/*
        if(getIntent().getExtras().getString("data").equals("Saat Kulesi")) {

            for (int i = 0; i < img_saatKulesi.length; i++) {
                View view = mInflater.inflate(R.layout.cell, mGallery, false);
                ImageView img = (ImageView) view.findViewById(R.id._image);
                img.setImageResource(img_saatKulesi[i]);
                mGallery.addView(view);
            }
        }
        else if(getIntent().getExtras().getString("data").equals("Pertev Mehmet Paşa Camii")){
            for (int i = 0; i < img_pertevmehmetpasa.length; i++) {
                View view = mInflater.inflate(R.layout.cell, mGallery, false);
                ImageView img = (ImageView) view.findViewById(R.id._image);
                img.setImageResource(img_pertevmehmetpasa[i]);
                mGallery.addView(view);
            }
        }
        else if(getIntent().getExtras().getString("data").equals("Seka Park")){
            for (int i = 0; i < img_sekapark.length; i++) {
                View view = mInflater.inflate(R.layout.cell, mGallery, false);
                ImageView img = (ImageView) view.findViewById(R.id._image);
                img.setImageResource(img_sekapark[i]);
                mGallery.addView(view);
            }
        }

        else
        {
            Toast.makeText(getApplicationContext(),  "ELSE", Toast.LENGTH_SHORT).show();
        }
*/
    }

    private Bitmap decodeSampledBitmapFromResource(Resources resources, int resId, int reqWidth, int reqHeight) {
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(resources, resId, options);

    }

    private int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
            // Raw height and width of image
            final int height = options.outHeight;
            final int width = options.outWidth;
            int inSampleSize = 1;

            if (height > reqHeight || width > reqWidth) {

                final int halfHeight = height / 2;
                final int halfWidth = width / 2;

                // Calculate the largest inSampleSize value that is a power of 2 and keeps both
                // height and width larger than the requested height and width.
                while ((halfHeight / inSampleSize) >= reqHeight
                        && (halfWidth / inSampleSize) >= reqWidth) {
                    inSampleSize *= 2;
                }
            }

            return inSampleSize;

        }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
