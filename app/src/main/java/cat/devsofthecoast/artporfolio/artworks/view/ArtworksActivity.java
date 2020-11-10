package cat.devsofthecoast.artporfolio.artworks.view;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import javax.inject.Inject;

import cat.devsofthecoast.artporfolio.R;
import cat.devsofthecoast.artporfolio.artworks.model.api.ApiArtwork;
import cat.devsofthecoast.artporfolio.artworks.model.app.Artwork;
import cat.devsofthecoast.artporfolio.artworks.presenter.ArtworksPresenter;
import cat.devsofthecoast.artporfolio.bases.views.activity.BasePresenterActivity;
import cat.devsofthecoast.artporfolio.dagger.ArtComponent;
import cat.devsofthecoast.artporfolio.utils.StringUtils;

public class ArtworksActivity extends BasePresenterActivity<ArtworksPresenter> implements ArtworksPresenter.View {

    @Inject StringUtils stringUtils;
    @Inject ArtworksPresenter presenter;

    private LinearLayout llProgressBar;
    private TextView btnConnectionError;
    private TextView btnGenericError;

    @Override
    protected void injectView(ArtComponent artComponent) {
        artComponent.inject(this);
    }

    @Override
    protected void initPresenter() {
        presenter.setView(this);
        setPresenter(presenter);
    }

    @Override
    protected int getContentLayout() {
        return R.layout.activity_artworks;
    }

    @Override
    protected void bindViews() {
        llProgressBar = findViewById(R.id.llProgressBar);
        btnConnectionError = findViewById(R.id.btnConnectionError);
        btnGenericError = findViewById(R.id.btnGenericError);
    }

    @Override
    protected void initViews() {
        btnConnectionError.setOnClickListener(v -> presenter.requestFilterByName("REQUESTED FROM BTN CONNECTION ERROR LONG TOUCH"));
        btnGenericError.setOnClickListener(view -> startActivity(ArtworkDetailActivity.getCallingIntent(ArtworksActivity.this)));
    }

    @Override
    public void showLoading() {
        llProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        llProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void requestSomeShitSuccess(ApiArtwork result) {
        showGenericError("Los datos han llegado correctamente -> " + result.getInfo().getTotal());
    }
}