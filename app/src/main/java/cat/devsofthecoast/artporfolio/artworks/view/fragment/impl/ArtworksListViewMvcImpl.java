package cat.devsofthecoast.artporfolio.artworks.view.fragment.impl;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cat.devsofthecoast.artporfolio.R;
import cat.devsofthecoast.artporfolio.artworks.model.api.ApiArtwork;
import cat.devsofthecoast.artporfolio.artworks.view.activity.NavDrawerHelper;
import cat.devsofthecoast.artporfolio.artworks.view.fragment.ArtworksListViewMvc;
import cat.devsofthecoast.artporfolio.artworks.view.widgets.adapter.ArtworksAdapter;
import cat.devsofthecoast.artporfolio.artworks.view.widgets.adapter.datawrappers.ArtworkBaseDataWrapper;
import cat.devsofthecoast.artporfolio.artworks.view.widgets.adapter.datawrappers.ArtworkComplexDataWrapper;
import cat.devsofthecoast.artporfolio.artworks.view.widgets.adapter.datawrappers.ArtworkSimplyDataWrapper;
import cat.devsofthecoast.artporfolio.common.screens.toolbar.ToolbarViewMvc;
import cat.devsofthecoast.artporfolio.common.screens.views.ViewMvcFactory;
import cat.devsofthecoast.artporfolio.common.screens.views.mvc.impl.BaseObservableViewMvc;

public class ArtworksListViewMvcImpl extends BaseObservableViewMvc<ArtworksListViewMvc.Listener> implements ArtworksListViewMvc, ArtworksAdapter.Listener {

    private final NavDrawerHelper navDrawerHelper;
    private final ToolbarViewMvc toolbarViewMvc;

    private final Toolbar toolbar;
    private final RecyclerView rcyArtworks;
    private final ProgressBar pbLoading;

    private ArtworksAdapter artworksAdapter;

    public ArtworksListViewMvcImpl(LayoutInflater inflater,
                                   @Nullable ViewGroup parent,
                                   NavDrawerHelper navDrawerHelper,
                                   ViewMvcFactory viewMvcFactory) {
        this.navDrawerHelper = navDrawerHelper;
        setRootView(inflater.inflate(R.layout.layout_artworks_list, parent, false));

        rcyArtworks = findViewById(R.id.rcyArtworks);
        pbLoading = findViewById(R.id.pbLoading);
        toolbar = findViewById(R.id.toolbar);
        toolbarViewMvc = viewMvcFactory.newToolbarViewMvc(toolbar);

        rcyArtworks.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        artworksAdapter = new ArtworksAdapter(viewMvcFactory);
        rcyArtworks.setAdapter(artworksAdapter);
        artworksAdapter.registerListener(this);
        initToolbar();

    }

    private void initToolbar() {
        toolbarViewMvc.setTitle(getString(R.string.artwork_list_screen_title));
        toolbar.addView(toolbarViewMvc.getRootView());
        toolbarViewMvc.enableHamburgerButtonAndListen(() -> navDrawerHelper.openDrawer());
    }


    @Override
    public void bindArtworksList(List<ApiArtwork> artworks) {
        List<ArtworkBaseDataWrapper> dataWrappers = new ArrayList<>();
        for (ApiArtwork apiArtwork : artworks) {
            if (!TextUtils.isEmpty(apiArtwork.getPrimaryimageurl())) {
                dataWrappers.add(new ArtworkComplexDataWrapper(apiArtwork));
            } else {
                dataWrappers.add(new ArtworkSimplyDataWrapper(apiArtwork));
            }
        }
        artworksAdapter.setData(dataWrappers);
    }

    @Override
    public void showProgressIndication() {
        pbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressIndication() {
        pbLoading.setVisibility(View.GONE);
    }

    @Override
    public void onArtworkClicked(ApiArtwork apiArtwork) {
        for (Listener listener : getListeners()) {
            listener.onArtworkClicked(apiArtwork);
        }
    }
}
