package cat.devsofthecoast.artporfolio.artworks.view.activity;

import android.widget.FrameLayout;

import cat.devsofthecoast.artporfolio.common.screens.views.mvc.ObservableViewMvc;

public interface NavDrawerViewMvc extends ObservableViewMvc<NavDrawerViewMvc.Listener> {

    interface Listener {

        void onArtworkListClicked();

    }

    FrameLayout getFragmentFrame();

    boolean isDrawerOpen();

    void openDrawer();

    void closeDrawer();

}
