package ma.ensa.localisation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import ma.ensa.localisation.MainActivity;
import ma.ensa.localisation.R;

public class WelcomeActivity extends AppCompatActivity {

    private static final int ANIMATION_DURATION = 2000; // Durée de l'animation en millisecondes
    private static final int DELAY_BEFORE_NEXT_ACTIVITY = 3000; // Délai avant de passer à l'activité suivante

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome); // Assurez-vous que le nom du layout est "activity_welcome"

        ImageView welcomeImage = findViewById(R.id.welcome_image);

        // Charger l'animation
        Animation fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        // Appliquer l'animation à l'ImageView
        welcomeImage.startAnimation(fadeInAnimation);

        // Délai pour passer à l'activité suivante après l'animation
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Terminer WelcomeActivity pour ne pas revenir en arrière
            }
        }, DELAY_BEFORE_NEXT_ACTIVITY);
    }
}
