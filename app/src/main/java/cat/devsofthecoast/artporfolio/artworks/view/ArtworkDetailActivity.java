package cat.devsofthecoast.artporfolio.artworks.view;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

import javax.inject.Inject;

import cat.devsofthecoast.artporfolio.R;
import cat.devsofthecoast.artporfolio.bases.activity.BasePresenterActivity;
import cat.devsofthecoast.artporfolio.bases.presenter.BasePresenter;
import cat.devsofthecoast.artporfolio.dagger.ArtComponent;
import cat.devsofthecoast.artporfolio.utils.StringUtils;


@SuppressWarnings("rawtypes")
public class ArtworkDetailActivity extends BasePresenterActivity {

    private TextView tvMainContent;

    @Inject StringUtils stringUtils;

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, ArtworkDetailActivity.class);
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
