package cat.devsofthecoast.artporfolio.artworks.view.view;
import java.util.List;

import cat.devsofthecoast.artporfolio.artworks.model.api.ApiArtwork;

public interface ArtworksListViewMvc extends ObservableViewMvc<ArtworksListViewMvc.Listener> {

    public interface Listener {
        void onArtworkClicked(ApiArtwork artwork);
    }

    void bindArtworksList(List<ApiArtwork> artworks);

    void showProgressIndication();

    void hideProgressIndication();

}