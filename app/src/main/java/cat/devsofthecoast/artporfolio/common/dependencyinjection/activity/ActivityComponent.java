package cat.devsofthecoast.artporfolio.common.dependencyinjection.activity;

import cat.devsofthecoast.artporfolio.common.dependencyinjection.presentantion.PresentationComponent;
import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    PresentationComponent newPresentationComponent();

}
