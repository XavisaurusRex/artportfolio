package cat.devsofthecoast.artporfolio.artworks.model.api;
import com.google.gson.annotations.SerializedName;

public class ApiImages {

    @SerializedName("web")
    private ApiWeb apiWeb;


    public ApiWeb getApiWeb() {
        return apiWeb;
    }
}
