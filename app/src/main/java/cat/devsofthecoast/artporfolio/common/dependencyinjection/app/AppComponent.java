package cat.devsofthecoast.artporfolio.common.dependencyinjection.app;

import cat.devsofthecoast.artporfolio.common.dependencyinjection.activity.ActivityComponent;
import cat.devsofthecoast.artporfolio.common.dependencyinjection.activity.ActivityModule;
import cat.devsofthecoast.artporfolio.common.dependencyinjection.app.modules.AppModule;
import cat.devsofthecoast.artporfolio.common.dependencyinjection.app.modules.RepositoryModule;
import cat.devsofthecoast.artporfolio.common.dependencyinjection.app.scopes.AppScope;
import dagger.Component;

@AppScope
@Component(modules = {AppModule.class, RepositoryModule.class})
public interface AppComponent {

    ActivityComponent newActivityComponent(ActivityModule activityModule);

}
