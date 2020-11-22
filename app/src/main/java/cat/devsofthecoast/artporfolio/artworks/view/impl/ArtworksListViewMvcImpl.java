package cat.devsofthecoast.artporfolio.artworks.view.impl;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import java.util.List;

import cat.devsofthecoast.artporfolio.R;
import cat.devsofthecoast.artporfolio.artworks.model.api.ApiArtwork;
import cat.devsofthecoast.artporfolio.artworks.view.ArtworksListViewMvc;
import cat.devsofthecoast.artporfolio.artworks.view.NavDrawerHelper;
import cat.devsofthecoast.artporfolio.common.screens.toolbar.ToolbarViewMvc;
import cat.devsofthecoast.artporfolio.common.screens.views.ViewMvcFactory;
import cat.devsofthecoast.artporfolio.common.screens.views.mvc.impl.BaseObservableViewMvc;

public class ArtworksListViewMvcImpl extends BaseObservableViewMvc<ArtworksListViewMvc.Listener> implements ArtworksListViewMvc {

    private final NavDrawerHelper navDrawerHelper;
    private final ToolbarViewMvc toolbarViewMvc;

    private final TextView tvMainContent;
    private final Toolbar toolbar;

    public ArtworksListViewMvcImpl(LayoutInflater inflater,
                                   @Nullable ViewGroup parent,
                                   NavDrawerHelper navDrawerHelper,
                                   ViewMvcFactory viewMvcFactory) {
        this.navDrawerHelper = navDrawerHelper;
        setRootView(inflater.inflate(R.layout.layout_artworks_list, parent, false));

        tvMainContent = findViewById(R.id.tvMainContent);
        toolbar = findViewById(R.id.toolbar);
        toolbarViewMvc = viewMvcFactory.newToolbarViewMvc(toolbar);
        initToolbar();
    }

    private void initToolbar() {
        toolbarViewMvc.setTitle(getString(R.string.artwork_list_screen_title));
        toolbar.addView(toolbarViewMvc.getRootView());
        toolbarViewMvc.enableHamburgerButtonAndListen(() -> navDrawerHelper.openDrawer());
    }

    @Override
    public void bindArtworksList(List<ApiArtwork> artworks) {
        StringBuilder sb = new StringBuilder();
        for (ApiArtwork artwork : artworks) {
            sb.append(artwork.getTitle()).append(", ");
        }
        tvMainContent.setText(sb.toString());
        tvMainContent.setOnClickListener(new View.OnClickListener() {
            private final ApiArtwork apiArtwork = artworks.get(0);

            @Override
            public void onClick(View v) {
                for (Listener listener : getListeners()) {
                    listener.onArtworkClicked(apiArtwork);
                }
            }
        });
    }

    @Override
    public void showProgressIndication() {
        tvMainContent.setText("Loading");
    }

    @Override
    public void hideProgressIndication() {
        // no op
    }

}
