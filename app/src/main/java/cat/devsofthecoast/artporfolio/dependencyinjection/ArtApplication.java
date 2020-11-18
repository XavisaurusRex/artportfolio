package cat.devsofthecoast.artporfolio.dependencyinjection;
import android.app.Application;

import cat.devsofthecoast.artporfolio.dependencyinjection.app.AppComponent;
import cat.devsofthecoast.artporfolio.dependencyinjection.app.AppModule;
import cat.devsofthecoast.artporfolio.dependencyinjection.app.DaggerAppComponent;

public class ArtApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
