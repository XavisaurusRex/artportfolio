package cat.devsofthecoast.artporfolio.dependencyinjection.presentantion;

import android.view.LayoutInflater;

import cat.devsofthecoast.artporfolio.bases.views.mvc.ViewMvcFactory;
import cat.devsofthecoast.artporfolio.utils.StringUtils;
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
