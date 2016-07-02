import android.support.v7.app.AppCompatActivity;

import com.parse.ParseInstallation;

/**
 * Created by hal_kumar on 06/27/2016.
 */
public class Aplication extends AppCompatActivity {
    public void onCreate() {

        ParseInstallation.getCurrentInstallation().saveInBackground();
    }
}
