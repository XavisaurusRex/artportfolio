package cat.devsofthecoast.artporfolio.artworks;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import javax.inject.Inject;

import cat.devsofthecoast.artporfolio.artworks.model.api.ApiArtwork;
import cat.devsofthecoast.artporfolio.artworks.view.ArtworkDetailsViewMvc;
import cat.devsofthecoast.artporfolio.common.dependencyinjection.presentantion.PresentationComponent;
import cat.devsofthecoast.artporfolio.common.screens.controllers.BaseFragment;
import cat.devsofthecoast.artporfolio.common.screens.navigators.ScreensNavigator;
import cat.devsofthecoast.artporfolio.common.screens.views.ViewMvcFactory;

public class ArtworkDetailFragment extends BaseFragment implements ArtworkDetailsViewMvc.Listener {

    public static final String ARGS_ARTWORK_DESCRIPTION = "artworkDescription";

    @Inject ViewMvcFactory viewMvcFactory;
    @Inject ScreensNavigator screensNavigator;

    private ArtworkDetailsViewMvc viewMvc;

    public static ArtworkDetailFragment newInstance(ApiArtwork artwork) {
        Bundle args = new Bundle();
        args.putSerializable(ARGS_ARTWORK_DESCRIPTION, artwork);
        ArtworkDetailFragment fragment = new ArtworkDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void injectView(PresentationComponent injector) {
        injector.inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewMvc = viewMvcFactory.newArtworkDetailsViewMvc(null);
        return viewMvc.getRootView();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewMvc.bindArtwork(getArtworkDescriptionFromExtras());
    }

    @Override
    public void onStart() {
        super.onStart();
        viewMvc.registerListener(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        viewMvc.unregisterListener(this);
    }

    @Nullable
    private ApiArtwork getArtworkDescriptionFromExtras() {
        return getArguments() != null ? (ApiArtwork) getArguments().getSerializable(ARGS_ARTWORK_DESCRIPTION) : null;
    }

    @Override
    public void onNavigateUpClicked() {
        screensNavigator.navigateUp();
    }

    @Override
    public void onLocationRequestClicked() {
        Toast.makeText(getContext(), "location requested", Toast.LENGTH_SHORT).show();
    }
}
