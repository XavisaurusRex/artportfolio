package cat.devsofthecoast.artporfolio.artworks.view;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;

import cat.devsofthecoast.artporfolio.common.dependencyinjection.presentantion.PresentationComponent;
import cat.devsofthecoast.artporfolio.common.screens.controllers.BackPressDispatcher;
import cat.devsofthecoast.artporfolio.common.screens.controllers.BackPressedListener;
import cat.devsofthecoast.artporfolio.common.screens.controllers.BaseActivity;
import cat.devsofthecoast.artporfolio.common.screens.fragmentframehelper.FragmentFrameWrapper;
import cat.devsofthecoast.artporfolio.common.screens.screensnavigator.ScreensNavigator;
import cat.devsofthecoast.artporfolio.common.screens.views.ViewMvcFactory;

public class MainActivity extends BaseActivity implements
        BackPressDispatcher,
        FragmentFrameWrapper,
        NavDrawerViewMvc.Listener,
        NavDrawerHelper {


    private final Set<BackPressedListener> mBackPressedListeners = new HashSet<>();

    @Inject ScreensNavigator mScreensNavigator;
    @Inject ViewMvcFactory viewMvcFactory;

    private NavDrawerViewMvc mViewMvc;

    @Override
    protected void injectView(PresentationComponent presentationComponent) {
        super.injectView(presentationComponent);
        presentationComponent.inject(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewMvc = viewMvcFactory.newNavDrawerViewMvc(null);
        setContentView(mViewMvc.getRootView());

        if (savedInstanceState == null) {
            mScreensNavigator.toArtworkList();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        mViewMvc.registerListener(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mViewMvc.unregisterListener(this);
    }

    @Override
    public void onArtworkListClicked() {
        mScreensNavigator.toArtworkList();
    }

    @Override
    public void registerListener(BackPressedListener listener) {
        mBackPressedListeners.add(listener);
    }

    @Override
    public void unregisterListener(BackPressedListener listener) {
        mBackPressedListeners.remove(listener);
    }

    @Override
    public void onBackPressed() {
        boolean isBackPressConsumedByAnyListener = false;
        for (BackPressedListener listener : mBackPressedListeners) {
            if (listener.onBackPressed()) {
                isBackPressConsumedByAnyListener = true;
            }
        }
        if (isBackPressConsumedByAnyListener) {
            return;
        }

        if (mViewMvc.isDrawerOpen()) {
            mViewMvc.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public FrameLayout getFragmentFrame() {
        return mViewMvc.getFragmentFrame();
    }

    @Override
    public void openDrawer() {
        mViewMvc.openDrawer();
    }

    @Override
    public void closeDrawer() {
        mViewMvc.closeDrawer();
    }

    @Override
    public boolean isDrawerOpen() {
        return mViewMvc.isDrawerOpen();
    }
}
