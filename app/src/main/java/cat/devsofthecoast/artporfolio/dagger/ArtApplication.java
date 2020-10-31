package cat.devsofthecoast.artporfolio.dagger;
import android.app.Application;

public class ArtApplication extends Application {

    private ArtComponent artComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        artComponent = DaggerArtComponent.create();
    }

    public ArtComponent getArtComponent() {
        return artComponent;
    }
}
