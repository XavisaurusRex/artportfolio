package cat.devsofthecoast.artporfolio.dependencyinjection.app;

import cat.devsofthecoast.artporfolio.dependencyinjection.activity.ActivityComponent;
import cat.devsofthecoast.artporfolio.dependencyinjection.activity.ActivityModule;
import dagger.Component;

@AppScope
@Component(modules = AppModule.class)
public interface AppComponent {

    ActivityComponent newActivityComponent(ActivityModule activityModule);

}
