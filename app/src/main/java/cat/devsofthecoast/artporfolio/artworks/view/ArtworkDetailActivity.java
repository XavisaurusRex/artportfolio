package cat.devsofthecoast.artporfolio.artworks.view;
import cat.devsofthecoast.artporfolio.R;
import cat.devsofthecoast.artporfolio.bases.activity.BaseActivity;
import cat.devsofthecoast.artporfolio.dagger.ArtComponent;

public class ArtworkDetailActivity extends BaseActivity {
    @Override
    protected int getContentLayout() {
        return R.layout.activity_artwork_detail;
    }

    @Override
    protected void bindViews() {
        // no op
    }

    @Override
    protected void initViews() {
        // no op
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
