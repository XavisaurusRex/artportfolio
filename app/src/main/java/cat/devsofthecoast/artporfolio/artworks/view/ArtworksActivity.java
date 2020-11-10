package cat.devsofthecoast.artporfolio.artworks.view;

import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatEditText;

import javax.inject.Inject;

import cat.devsofthecoast.artporfolio.R;
import cat.devsofthecoast.artporfolio.artworks.model.api.ApiArtworksRoot;
import cat.devsofthecoast.artporfolio.artworks.presenter.ArtworksPresenter;
import cat.devsofthecoast.artporfolio.bases.views.activity.BasePresenterActivity;
import cat.devsofthecoast.artporfolio.dagger.ArtComponent;
import cat.devsofthecoast.artporfolio.utils.StringUtils;

public class ArtworksActivity extends BasePresenterActivity<ArtworksPresenter> implements ArtworksPresenter.View {

    @Inject StringUtils stringUtils;
    @Inject ArtworksPresenter presenter;

    private LinearLayout llProgressBar;
    private AppCompatEditText acetSearchByTerm;

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
        acetSearchByTerm = findViewById(R.id.acetSearchByTerm);
    }

    @Override
    protected void initViews() {
        acetSearchByTerm.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                presenter.requestFilterByName(v.getText() != null ? v.getText().toString() : null);
                return true;
            }
            return false;
        });
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
    public void requestSomeShitSuccess(ApiArtworksRoot result) {
        showGenericError("Los datos han llegado correctamente -> " + result.getInfo().getTotal());
    }
}