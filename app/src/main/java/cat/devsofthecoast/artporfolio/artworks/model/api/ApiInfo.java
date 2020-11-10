package cat.devsofthecoast.artporfolio.artworks.model.api;
import com.google.gson.annotations.SerializedName;

public final class ApiInfo {

    @SerializedName("total")
    private int total;

    @SerializedName("parameters")
    private ApiParams params;

    public int getTotal() {
        return total;
    }

    public ApiParams getParams() {
        return params;
    }
}
