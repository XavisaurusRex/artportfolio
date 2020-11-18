package cat.devsofthecoast.artporfolio.artworks.view.view;
import java.util.List;

import cat.devsofthecoast.artporfolio.artworks.model.api.ApiArtwork;

public interface ArtworkDetailsViewMvc extends ViewMvc {

    void bindArtwork(ApiArtwork artwork);

    void showProgressIndication();

    void hideProgressIndication();

}