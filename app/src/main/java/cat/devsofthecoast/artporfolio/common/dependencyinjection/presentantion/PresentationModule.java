package cat.devsofthecoast.artporfolio.common.dependencyinjection.presentantion;

import android.view.LayoutInflater;

import androidx.appcompat.app.AppCompatActivity;

import cat.devsofthecoast.artporfolio.artworks.view.activity.NavDrawerHelper;
import cat.devsofthecoast.artporfolio.common.screens.utils.StringUtils;
import cat.devsofthecoast.artporfolio.common.screens.views.ViewMvcFactory;
import dagger.Module;
import dagger.Provides;

@Module
public class PresentationModule {

    @Provides
    public ViewMvcFactory provideViewMvcFactory(LayoutInflater layoutInflater, NavDrawerHelper navDrawerHelper) {
        return new ViewMvcFactory(layoutInflater, navDrawerHelper);
    }

    @Provides
    public NavDrawerHelper provideNavDrawerHelper(AppCompatActivity appCompatActivity) {
        return (NavDrawerHelper) appCompatActivity;
    }

    @Provides
    public StringUtils provideStringUtils() {
        return new StringUtils();
    }
}
