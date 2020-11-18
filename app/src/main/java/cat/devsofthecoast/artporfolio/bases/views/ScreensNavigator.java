package cat.devsofthecoast.artporfolio.bases.views;
import androidx.appcompat.app.AppCompatActivity;

import cat.devsofthecoast.artporfolio.artworks.view.ArtworkDetailActivity;

public class ScreensNavigator {

    private final AppCompatActivity activity;

    public ScreensNavigator(AppCompatActivity activity) {
        this.activity = activity;
    }

    public void navigateBack() {
        activity.onBackPressed();
    }

    public void toArtworkDetail(String artworkDescription) {
        ArtworkDetailActivity.start(activity, artworkDescription);
    }
}
