package cat.devsofthecoast.artporfolio;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import javax.inject.Inject;

import cat.devsofthecoast.artporfolio.dagger.ArtApplication;
import cat.devsofthecoast.artporfolio.utils.StringUtils;

public class MainActivity extends AppCompatActivity {

    @Inject StringUtils stringUtils;
    private TextView tvMainContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // dependency injection
        ((ArtApplication) getApplication()).getAppComponent().inject(this);

        tvMainContent = findViewById(R.id.tvMainContent);

        tvMainContent.setText(stringUtils.insultMe());
    }
}