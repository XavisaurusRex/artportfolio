package cat.devsofthecoast.artporfolio.artworks.model.api;
import com.google.gson.annotations.SerializedName;

public final class ApiInfo {

    @SerializedName("total")
    private int total;

    public int getTotal() {
        return total;
    }
}
