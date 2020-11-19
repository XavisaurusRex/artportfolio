package cat.devsofthecoast.artporfolio.common.dependencyinjection.app;

import cat.devsofthecoast.artporfolio.common.dependencyinjection.activity.ActivityComponent;
import cat.devsofthecoast.artporfolio.common.dependencyinjection.activity.ActivityModule;
import dagger.Component;

@AppScope
@Component(modules = AppModule.class)
public interface AppComponent {

    ActivityComponent newActivityComponent(ActivityModule activityModule);

}
