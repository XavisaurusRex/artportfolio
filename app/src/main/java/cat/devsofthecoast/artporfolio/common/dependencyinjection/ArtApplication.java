package cat.devsofthecoast.artporfolio.common.dependencyinjection;
import android.app.Application;

import cat.devsofthecoast.artporfolio.common.dependencyinjection.app.AppComponent;
import cat.devsofthecoast.artporfolio.common.dependencyinjection.app.AppModule;
import cat.devsofthecoast.artporfolio.common.dependencyinjection.app.DaggerAppComponent;

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
