package cat.devsofthecoast.artporfolio.artworks.view;

import cat.devsofthecoast.artporfolio.artworks.model.api.ApiArtwork;
import cat.devsofthecoast.artporfolio.common.screens.views.ViewMvc;

public interface ArtworkDetailsViewMvc extends ViewMvc {

    void bindArtwork(ApiArtwork artwork);

    void showProgressIndication();

    void hideProgressIndication();

}