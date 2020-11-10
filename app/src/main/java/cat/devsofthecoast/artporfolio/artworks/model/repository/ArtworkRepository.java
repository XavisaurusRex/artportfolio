package cat.devsofthecoast.artporfolio.artworks.model.repository;
import java.util.List;

import cat.devsofthecoast.artporfolio.artworks.model.api.ApiArtwork;
import cat.devsofthecoast.artporfolio.artworks.model.app.Artwork;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ArtworkRepository {
    @GET("artworks")
    Call<ApiArtwork> getArtworks();
}
