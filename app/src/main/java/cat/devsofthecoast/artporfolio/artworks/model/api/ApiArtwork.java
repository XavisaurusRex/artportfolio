package cat.devsofthecoast.artporfolio.artworks.model.api;
import com.google.gson.annotations.SerializedName;

public class ApiArtwork {

    @SerializedName("info")
    private ApiInfo info;

    public ApiInfo getInfo() {
        return info;
    }

}
