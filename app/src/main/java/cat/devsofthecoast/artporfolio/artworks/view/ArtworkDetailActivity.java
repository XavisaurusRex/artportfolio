package cat.devsofthecoast.artporfolio.artworks.view;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import javax.inject.Inject;

import cat.devsofthecoast.artporfolio.R;
import cat.devsofthecoast.artporfolio.bases.views.activity.BaseActivity;
import cat.devsofthecoast.artporfolio.dependencyinjection.activity.ActivityComponent;
import cat.devsofthecoast.artporfolio.dependencyinjection.presentantion.PresentationComponent;
import cat.devsofthecoast.artporfolio.utils.StringUtils;

public class ArtworkDetailActivity extends BaseActivity {

    public static final String EXTRA_ARTWORK_DESCRIPTION = "artworkDescription";
    private TextView tvMainContent;

    @Inject StringUtils stringUtils;

    public static void start(Context context, String artworkDescription) {
        Intent intent = new Intent(context, ArtworkDetailActivity.class);
        intent.putExtra(EXTRA_ARTWORK_DESCRIPTION, artworkDescription);
        context.startActivity(intent);
    }

    @Override
    protected int getContentLayout() {
        return R.layout.activity_artwork_detail;
    }

    @Override
    protected void bindViews() {
        tvMainContent = findViewById(R.id.tvMainContent);
    }

    @Override
    protected void initViews() {
        tvMainContent.setText(getArtworkDescriptionFromExtras());
    }

    @Nullable
    private String getArtworkDescriptionFromExtras() {
        final Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            return bundle.getString(EXTRA_ARTWORK_DESCRIPTION);
        }
        return null;
    }

    @Override
    protected void injectView(PresentationComponent injector) {
        injector.inject(this);
    }
}
