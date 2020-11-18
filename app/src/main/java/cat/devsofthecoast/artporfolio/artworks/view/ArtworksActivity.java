package cat.devsofthecoast.artporfolio.artworks.view;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;

import javax.inject.Inject;

import cat.devsofthecoast.artporfolio.artworks.model.api.ApiArtwork;
import cat.devsofthecoast.artporfolio.artworks.model.api.ApiArtworksRoot;
import cat.devsofthecoast.artporfolio.artworks.model.usecase.RequestArtworksUseCase;
import cat.devsofthecoast.artporfolio.artworks.view.view.ArtworksListViewMvc;
import cat.devsofthecoast.artporfolio.bases.models.usecases.callback.UseCaseCallback;
import cat.devsofthecoast.artporfolio.bases.views.ScreensNavigator;
import cat.devsofthecoast.artporfolio.bases.views.activity.BaseActivity;
import cat.devsofthecoast.artporfolio.bases.views.mvc.ViewMvcFactory;
import cat.devsofthecoast.artporfolio.dependencyinjection.presentantion.PresentationComponent;
import cat.devsofthecoast.artporfolio.utils.StringUtils;

public class ArtworksActivity extends BaseActivity implements ArtworksListViewMvc.Listener {

    @Inject StringUtils stringUtils;
    @Inject ScreensNavigator screensNavigator;
    @Inject RequestArtworksUseCase requestArtworksUseCase;
    @Inject ViewMvcFactory viewMvcFactory;

    private ArtworksListViewMvc viewMvc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewMvc = viewMvcFactory.newArtworksListViewMvc(null);
        setContentView(viewMvc.getRootView());
    }

    @Override
    protected void onStart() {
        super.onStart();
        viewMvc.registerListener(this);


        requestArtworksUseCase.buildExecutor(new UseCaseCallback<ApiArtworksRoot>() {
            @Override
            public void onSuccess(@Nullable ApiArtworksRoot result) {
                requestSomeShitSuccess(result);
            }

            @Override
            public void onError(Throwable t) {
                Toast.makeText(ArtworksActivity.this, "ERROR REQUESTING DATA", Toast.LENGTH_SHORT).show();
            }
        }).execute(null);
    }


    @Override
    protected void injectView(PresentationComponent injector) {
        injector.inject(this);
    }

    public void requestSomeShitSuccess(ApiArtworksRoot result) {
        viewMvc.bindArtworksList(result.getArtworks());
    }

    @Override
    public void onArtworkClicked(ApiArtwork artwork) {
        screensNavigator.toArtworkDetail(artwork);
    }
}