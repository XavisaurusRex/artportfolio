package cat.devsofthecoast.artporfolio.artworks.view;
import android.widget.TextView;

import javax.inject.Inject;

import cat.devsofthecoast.artporfolio.R;
import cat.devsofthecoast.artporfolio.bases.activity.BaseActivity;
import cat.devsofthecoast.artporfolio.dagger.ArtComponent;
import cat.devsofthecoast.artporfolio.utils.StringUtils;

public class ArtworkDetailActivity extends BaseActivity {

    private TextView tvMainContent;

    @Inject StringUtils stringUtils;

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
        // no op
        tvMainContent.setText(stringUtils.insultMe());
    }

    @Override
    protected void injectView(ArtComponent artComponent) {
        artComponent.inject(this);
    }

    @Override
    public void showLoading() {
        // no op
    }

    @Override
    public void hideLoading() {
        // no op
    }
}
