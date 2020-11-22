package cat.devsofthecoast.artporfolio.artworks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import javax.inject.Inject;

import cat.devsofthecoast.artporfolio.artworks.model.api.ApiArtwork;
import cat.devsofthecoast.artporfolio.artworks.model.api.ApiArtworksRoot;
import cat.devsofthecoast.artporfolio.artworks.usecase.RequestArtworksUseCase;
import cat.devsofthecoast.artporfolio.artworks.view.ArtworksListViewMvc;
import cat.devsofthecoast.artporfolio.common.core.usecases.callback.UseCaseCallback;
import cat.devsofthecoast.artporfolio.common.screens.controllers.BaseFragment;
import cat.devsofthecoast.artporfolio.common.screens.navigators.DialogsNavigator;
import cat.devsofthecoast.artporfolio.common.screens.navigators.ScreensNavigator;
import cat.devsofthecoast.artporfolio.common.screens.views.ViewMvcFactory;
import cat.devsofthecoast.artporfolio.common.dependencyinjection.presentantion.PresentationComponent;

public class ArtworksFragment extends BaseFragment implements ArtworksListViewMvc.Listener, RequestArtworksUseCase.Listener {

    @Inject ScreensNavigator screensNavigator;
    @Inject DialogsNavigator dialogsNavigator;
    @Inject RequestArtworksUseCase requestArtworksUseCase;
    @Inject ViewMvcFactory viewMvcFactory;

    private ArtworksListViewMvc viewMvc;

    public static Fragment newInstance() {
        return new ArtworksFragment();
    }

    @Override
    protected void injectView(PresentationComponent injector) {
        injector.inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewMvc = viewMvcFactory.newArtworksListViewMvc(null);
        return viewMvc.getRootView();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        requestArtworksUseCase.buildExecutor().execute(null);
        dialogsNavigator.showLoading("Cargando lista de arte");
    }

    @Override
    public void onStart() {
        super.onStart();
        viewMvc.registerListener(this);
        requestArtworksUseCase.registerListener(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        viewMvc.unregisterListener(this);
        requestArtworksUseCase.unregisterListener(this);
    }

    @Override
    public void onArtworkClicked(ApiArtwork artwork) {
        screensNavigator.toArtworkDetail(artwork);
    }

    @Override
    public void onRequestArtworksUseCaseSuccess(ApiArtworksRoot apiArtworksRoot) {
        viewMvc.bindArtworksList(apiArtworksRoot.getArtworks());
        dialogsNavigator.hideLoading();
    }

    @Override
    public void onRequestArtworksUseCaseError(Throwable t) {
        Toast.makeText(ArtworksFragment.this.getContext(), "ERROR REQUESTING DATA", Toast.LENGTH_SHORT).show();
    }
}