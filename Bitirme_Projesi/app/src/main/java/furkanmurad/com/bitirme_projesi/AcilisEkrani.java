package furkanmurad.com.bitirme_projesi;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

public class AcilisEkrani extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acilis_ekrani);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Thread acilisEkrani = new Thread()
        {
            public void run ()
            {
                try {
                    sleep(3000);
                    Intent intent = new Intent(AcilisEkrani.this, HaritaEkrani.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.right_in, R.anim.left_out);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    finish();
                }
            }
        };
        acilisEkrani.start();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        System.exit(0);
    }

}
