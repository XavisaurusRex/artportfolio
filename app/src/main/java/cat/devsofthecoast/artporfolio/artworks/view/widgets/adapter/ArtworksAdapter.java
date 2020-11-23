package cat.devsofthecoast.artporfolio.artworks.view.widgets.adapter;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import cat.devsofthecoast.artporfolio.artworks.model.api.ApiArtwork;
import cat.devsofthecoast.artporfolio.artworks.view.widgets.BaseAdapter;
import cat.devsofthecoast.artporfolio.artworks.view.widgets.adapter.datawrappers.ArtworkBaseDataWrapper;
import cat.devsofthecoast.artporfolio.artworks.view.widgets.adapter.viewholders.ArtworksViewHolder;
import cat.devsofthecoast.artporfolio.common.screens.views.ViewMvcFactory;

public class ArtworksAdapter extends BaseAdapter<ArtworkBaseDataWrapper, ArtworksViewHolder<ArtworkBaseDataWrapper>, ArtworksAdapter.Listener> {

    private final ViewMvcFactory viewMvcFactory;

    public ArtworksAdapter(ViewMvcFactory viewMvcFactory) {
        this.viewMvcFactory = viewMvcFactory;
    }

    @NonNull
    @Override
    public ArtworksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case ArtworkBaseDataWrapper.VIEWTYPE_ARTWORK_SIMPLY:
                return viewMvcFactory.newArtworkSimplyViewHolder(parent);
            case ArtworkBaseDataWrapper.VIEWTYPE_ARTWORK_COMPLEX:
                return viewMvcFactory.newArtworkComplexViewHolder(parent);
            default:
                throw new IllegalStateException("UnknownViewType");
        }
    }

    public interface Listener {
        void onArtworkClicked(ApiArtwork apiArtwork);
    }
}
