package cat.devsofthecoast.artporfolio.common.dependencyinjection.presentantion;

import android.view.LayoutInflater;

import cat.devsofthecoast.artporfolio.common.screens.views.ViewMvcFactory;
import cat.devsofthecoast.artporfolio.common.screens.utils.StringUtils;
import dagger.Module;
import dagger.Provides;

@Module
public class PresentationModule {

    @Provides
    public ViewMvcFactory provideViewMvcFactory(LayoutInflater layoutInflater) {
        return new ViewMvcFactory(layoutInflater);
    }

    @Provides
    public StringUtils provideStringUtils() {
        return new StringUtils();
    }
}
