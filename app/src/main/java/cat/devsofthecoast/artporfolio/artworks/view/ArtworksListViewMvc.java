package cat.devsofthecoast.artporfolio.artworks.view;
import java.util.List;

import cat.devsofthecoast.artporfolio.artworks.model.api.ApiArtwork;
import cat.devsofthecoast.artporfolio.common.screens.views.ObservableViewMvc;

public interface ArtworksListViewMvc extends ObservableViewMvc<ArtworksListViewMvc.Listener> {

    public interface Listener {
        void onArtworkClicked(ApiArtwork artwork);
    }

    void bindArtworksList(List<ApiArtwork> artworks);

    void showProgressIndication();

    void hideProgressIndication();

}