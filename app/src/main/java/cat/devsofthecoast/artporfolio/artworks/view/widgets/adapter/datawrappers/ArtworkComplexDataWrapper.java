package cat.devsofthecoast.artporfolio.artworks.view.widgets.adapter.datawrappers;
import cat.devsofthecoast.artporfolio.artworks.model.api.ApiArtwork;

public class ArtworkComplexDataWrapper extends ArtworkBaseDataWrapper {

    private final ApiArtwork apiArtwork;

    public ArtworkComplexDataWrapper(ApiArtwork apiArtwork) {
        this.apiArtwork = apiArtwork;
    }

    public ApiArtwork getApiArtwork() {
        return apiArtwork;
    }

    @Override
    public int getViewType() {
        return VIEWTYPE_ARTWORK_COMPLEX;
    }
}
