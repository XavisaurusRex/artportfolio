package cat.devsofthecoast.artporfolio.common.dependencyinjection.activity;

import android.view.LayoutInflater;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import cat.devsofthecoast.artporfolio.common.screens.fragmentframehelper.FragmentFrameHelper;
import cat.devsofthecoast.artporfolio.common.screens.fragmentframehelper.FragmentFrameWrapper;
import cat.devsofthecoast.artporfolio.common.screens.navigators.DialogsNavigator;
import cat.devsofthecoast.artporfolio.common.screens.navigators.ScreensNavigator;
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

    @Provides
    @ActivityScope
    public ScreensNavigator provideScreensNavigator(FragmentFrameHelper fragmentFrameHelper) {
        return new ScreensNavigator(fragmentFrameHelper);
    }

    @Provides
    public DialogsNavigator provideDialogsNavigator(FragmentManager fragmentManager) {
        return new DialogsNavigator(fragmentManager);
    }

    @Provides
    public LayoutInflater provideLayoutInflater(AppCompatActivity activity) {
        return LayoutInflater.from(activity);
    }

    @Provides
    @ActivityScope
    public FragmentFrameHelper provideFragmentFrameHelper(AppCompatActivity activity, FragmentFrameWrapper fragmentFrameWrapper, FragmentManager fragmentManager) {
        return new FragmentFrameHelper(activity, fragmentFrameWrapper, fragmentManager);
    }

    @Provides
    @ActivityScope
    public FragmentManager provideFragmentManager() {
        return activity.getSupportFragmentManager();
    }

    @Provides
    @ActivityScope
    public FragmentFrameWrapper provideFragmentFrameWrapper() {
        return (FragmentFrameWrapper) activity;
    }
}
