package cat.devsofthecoast.artporfolio.common.screens.views;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import cat.devsofthecoast.artporfolio.artworks.view.ArtworkDetailsViewMvc;
import cat.devsofthecoast.artporfolio.artworks.view.ArtworksListViewMvc;
import cat.devsofthecoast.artporfolio.artworks.view.NavDrawerHelper;
import cat.devsofthecoast.artporfolio.artworks.view.NavDrawerViewMvc;
import cat.devsofthecoast.artporfolio.artworks.view.impl.ArtworkDetailsMvcImpl;
import cat.devsofthecoast.artporfolio.artworks.view.impl.ArtworksListViewMvcImpl;
import cat.devsofthecoast.artporfolio.artworks.view.impl.NavDrawerViewMvcImpl;
import cat.devsofthecoast.artporfolio.common.screens.dialogs.genericerror.view.GenericErrorViewMvc;
import cat.devsofthecoast.artporfolio.common.screens.dialogs.genericerror.view.impl.GenericErrorViewMvcImpl;
import cat.devsofthecoast.artporfolio.common.screens.dialogs.loading.view.LoadingDialogViewMvc;
import cat.devsofthecoast.artporfolio.common.screens.dialogs.loading.view.LoadingDialogViewMvcImpl;
import cat.devsofthecoast.artporfolio.common.screens.toolbar.ToolbarViewMvc;

public class ViewMvcFactory {
    private final LayoutInflater layoutInflater;
    private final NavDrawerHelper navDrawerHelper;

    public ViewMvcFactory(LayoutInflater layoutInflater, NavDrawerHelper navDrawerHelper) {
        this.layoutInflater = layoutInflater;
        this.navDrawerHelper = navDrawerHelper;
    }

    public ArtworksListViewMvc newArtworksListViewMvc(@Nullable ViewGroup parent) {
        return new ArtworksListViewMvcImpl(layoutInflater, parent, navDrawerHelper, this);
    }

    public ArtworkDetailsViewMvc newArtworkDetailsViewMvc(@Nullable ViewGroup parent) {
        return new ArtworkDetailsMvcImpl(layoutInflater, parent, this);
    }

    public NavDrawerViewMvc newNavDrawerViewMvc(@Nullable ViewGroup parent) {
        return new NavDrawerViewMvcImpl(layoutInflater, parent);
    }

    public GenericErrorViewMvc newGenericErrorViewMvc(@Nullable ViewGroup parent) {
        return new GenericErrorViewMvcImpl(layoutInflater, parent);
    }

    public LoadingDialogViewMvc newLoadingDialogViewMvc(@Nullable ViewGroup parent) {
        return new LoadingDialogViewMvcImpl(layoutInflater, parent);
    }

    public ToolbarViewMvc newToolbarViewMvc(@Nullable ViewGroup parent) {
        return new ToolbarViewMvc(layoutInflater, parent);
    }
}
