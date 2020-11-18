package cat.devsofthecoast.artporfolio.artworks.view;

import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;

import javax.inject.Inject;

import cat.devsofthecoast.artporfolio.R;
import cat.devsofthecoast.artporfolio.artworks.model.api.ApiArtworksRoot;
import cat.devsofthecoast.artporfolio.artworks.model.usecase.RequestArtworksUseCase;
import cat.devsofthecoast.artporfolio.bases.models.usecases.callback.UseCaseCallback;
import cat.devsofthecoast.artporfolio.bases.views.ScreensNavigator;
import cat.devsofthecoast.artporfolio.bases.views.activity.BaseActivity;
import cat.devsofthecoast.artporfolio.dependencyinjection.presentantion.PresentationComponent;
import cat.devsofthecoast.artporfolio.utils.StringUtils;

public class ArtworksActivity extends BaseActivity {

    @Inject StringUtils stringUtils;
    @Inject ScreensNavigator screensNavigator;
    @Inject RequestArtworksUseCase requestArtworksUseCase;

    private LinearLayout llProgressBar;
    private AppCompatEditText acetSearchByTerm;

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
//                presenter.requestFilterByName(v.getText() != null ? v.getText().toString() : null);
                showLoading();
                requestArtworksUseCase.buildExecutor(new UseCaseCallback<ApiArtworksRoot>() {
                    @Override
                    public void onSuccess(@Nullable ApiArtworksRoot result) {
                        requestSomeShitSuccess(result);
                    }

                    @Override
                    public void onError(Throwable t) {
                        Toast.makeText(ArtworksActivity.this, "ERROR REQUESTING DATA", Toast.LENGTH_SHORT).show();
                    }
                }).execute(v.getText().toString());
                return true;
            }
            return false;
        });
    }

    @Override
    protected void injectView(PresentationComponent injector) {
        injector.inject(this);
    }

    public void showLoading() {
        llProgressBar.setVisibility(View.VISIBLE);
    }

    public void hideLoading() {
        llProgressBar.setVisibility(View.GONE);
    }

    public void requestSomeShitSuccess(ApiArtworksRoot result) {
        hideLoading();
        screensNavigator.toArtworkDetail(result.getArtworks().get(0).getTitle());
    }
}