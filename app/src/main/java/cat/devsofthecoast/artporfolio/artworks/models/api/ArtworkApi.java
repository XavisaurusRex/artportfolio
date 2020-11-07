package cat.devsofthecoast.artporfolio.artworks.models.api;
public class ArtworkApi {
    private final String title;
    private final String subtitle;

    // TODO: 06/11/2020 SHOULD BE SUBSTITUTED BY Serialized name from json response, for now, mocked
    public ArtworkApi(String title, String subtitle) {
        this.title = title;
        this.subtitle = subtitle;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }
}
