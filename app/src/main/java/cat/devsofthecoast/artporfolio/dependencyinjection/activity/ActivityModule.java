package cat.devsofthecoast.artporfolio.dependencyinjection.activity;

import android.view.LayoutInflater;

import androidx.appcompat.app.AppCompatActivity;

import cat.devsofthecoast.artporfolio.bases.views.ScreensNavigator;
import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private final AppCompatActivity activity;

    public ActivityModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    public AppCompatActivity provideActivity() {
        return activity;
    }

    @ActivityScope
    @Provides
    public ScreensNavigator provideScreensNavigator(AppCompatActivity activity) {
        return new ScreensNavigator(activity);
    }

    @Provides
    public LayoutInflater provideLayoutInflater(AppCompatActivity activity) {
        return LayoutInflater.from(activity);
    }
}
