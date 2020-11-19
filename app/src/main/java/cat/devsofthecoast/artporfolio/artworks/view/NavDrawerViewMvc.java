package cat.devsofthecoast.artporfolio.artworks.view;

import android.widget.FrameLayout;

import cat.devsofthecoast.artporfolio.common.screens.views.ObservableViewMvc;

public interface NavDrawerViewMvc extends ObservableViewMvc<NavDrawerViewMvc.Listener> {

    interface Listener {

        void onArtworkListClicked();

    }

    FrameLayout getFragmentFrame();

    boolean isDrawerOpen();

    void openDrawer();

    void closeDrawer();

}