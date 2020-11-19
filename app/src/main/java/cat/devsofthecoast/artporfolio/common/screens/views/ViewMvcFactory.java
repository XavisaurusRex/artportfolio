package cat.devsofthecoast.artporfolio.common.screens.views;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import cat.devsofthecoast.artporfolio.artworks.view.ArtworkDetailsViewMvc;
import cat.devsofthecoast.artporfolio.artworks.view.ArtworksListViewMvc;
import cat.devsofthecoast.artporfolio.artworks.view.NavDrawerViewMvc;
import cat.devsofthecoast.artporfolio.artworks.view.impl.ArtworkDetailsMvcImpl;
import cat.devsofthecoast.artporfolio.artworks.view.impl.ArtworksListViewMvcImpl;
import cat.devsofthecoast.artporfolio.artworks.view.impl.NavDrawerViewMvcImpl;

public class ViewMvcFactory {
    private final LayoutInflater layoutInflater;

    public ViewMvcFactory(LayoutInflater layoutInflater) {
        this.layoutInflater = layoutInflater;
    }

    public ArtworksListViewMvc newArtworksListViewMvc(@Nullable ViewGroup parent) {
        return new ArtworksListViewMvcImpl(layoutInflater, parent);
    }

    public ArtworkDetailsViewMvc newArtworkDetailsViewMvc(@Nullable ViewGroup parent) {
        return new ArtworkDetailsMvcImpl(layoutInflater, parent);
    }

    public NavDrawerViewMvc newNavDrawerViewMvc(@Nullable ViewGroup parent) {
        return new NavDrawerViewMvcImpl(layoutInflater, parent);
    }
}
