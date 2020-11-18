package cat.devsofthecoast.artporfolio.bases.views.mvc;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import cat.devsofthecoast.artporfolio.artworks.view.view.ArtworkDetailsMvcImpl;
import cat.devsofthecoast.artporfolio.artworks.view.view.ArtworkDetailsViewMvc;
import cat.devsofthecoast.artporfolio.artworks.view.view.ArtworksListViewMvc;
import cat.devsofthecoast.artporfolio.artworks.view.view.ArtworksListViewMvcImpl;

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
}
