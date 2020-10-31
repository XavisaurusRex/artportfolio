package cat.devsofthecoast.artporfolio;

import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import cat.devsofthecoast.artporfolio.bases.BaseActivity;
import cat.devsofthecoast.artporfolio.dagger.ArtComponent;
import cat.devsofthecoast.artporfolio.utils.StringUtils;

public class ArtworksActivity extends BaseActivity {

    @Inject StringUtils stringUtils;
    private TextView tvMainContent;
    private TextView btnConnectionError;
    private TextView btnGenericError;

    @Override
    protected void injectView(ArtComponent artComponent) {
        artComponent.inject(this);
    }

    @Override
    protected int getContentLayout() {
        return R.layout.activity_artworks;
    }

    @Override
    protected void bindViews() {
        tvMainContent = findViewById(R.id.tvMainContent);
        btnConnectionError = findViewById(R.id.btnConnectionError);
        btnGenericError = findViewById(R.id.btnGenericError);
    }

    @Override
    protected void initViews() {
        tvMainContent.setText(stringUtils.insultMe());
        btnConnectionError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNoConnectionError();
            }
        });
        btnGenericError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showGenericError(stringUtils.insultMe());
            }
        });
        btnGenericError.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                showGenericError(null);
                return false;
            }
        });
    }
}