package cat.devsofthecoast.artporfolio.artworks.model.api;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class ApiArtworksRoot {

    @SerializedName("info")
    private ApiInfo info;

    @SerializedName("data")
    private List<ApiArtworks> artworks;


    public ApiInfo getInfo() {
        return info;
    }

    public List<ApiArtworks> getArtworks() {
        return artworks;
    }

}
