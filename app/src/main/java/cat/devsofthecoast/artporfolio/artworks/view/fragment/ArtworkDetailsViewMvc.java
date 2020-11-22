package cat.devsofthecoast.artporfolio.artworks.view.fragment;

import cat.devsofthecoast.artporfolio.artworks.model.api.ApiArtwork;
import cat.devsofthecoast.artporfolio.common.screens.views.mvc.ObservableViewMvc;

public interface ArtworkDetailsViewMvc extends ObservableViewMvc<ArtworkDetailsViewMvc.Listener> {

   public interface Listener {
        void onNavigateUpClicked();

        void onLocationRequestClicked();
    }

    void bindArtwork(ApiArtwork artwork);

    void showProgressIndication();

    void hideProgressIndication();

}