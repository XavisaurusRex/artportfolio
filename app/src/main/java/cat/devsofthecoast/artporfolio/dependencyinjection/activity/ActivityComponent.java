package cat.devsofthecoast.artporfolio.dependencyinjection.activity;

import cat.devsofthecoast.artporfolio.dependencyinjection.presentantion.PresentationComponent;
import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    PresentationComponent newPresentationComponent();

}
