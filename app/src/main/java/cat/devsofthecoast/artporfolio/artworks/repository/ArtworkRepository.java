package cat.devsofthecoast.artporfolio.artworks.repository;

import cat.devsofthecoast.artporfolio.artworks.model.api.ApiArtworksRoot;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ArtworkRepository {
    @GET("artworks")
    Call<ApiArtworksRoot> getArtworks(@Query("q") String searchTerm, @Query("limit") int limitResultsNumber);
}
