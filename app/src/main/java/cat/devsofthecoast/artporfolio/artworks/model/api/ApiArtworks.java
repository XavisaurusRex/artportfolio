package cat.devsofthecoast.artporfolio.artworks.model.api;
import com.google.gson.annotations.SerializedName;

public final class ApiArtworks {

    @SerializedName("id")
    private int id;

   @SerializedName("accession_number")
    private String accessionNumber;

    @SerializedName("title")
    private String title;

    @SerializedName("title_in_original_language")
    private String originalTitle;

    @SerializedName("url")
    private String url;

    public int getId() {
        return id;
    }

    public String getAccessionNumber() {
        return accessionNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getUrl() {
        return url;
    }
}
