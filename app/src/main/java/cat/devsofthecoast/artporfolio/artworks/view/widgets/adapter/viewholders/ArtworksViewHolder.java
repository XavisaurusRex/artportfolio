package cat.devsofthecoast.artporfolio.artworks.view.widgets.adapter.viewholders;
import android.view.View;

import androidx.annotation.NonNull;

import cat.devsofthecoast.artporfolio.artworks.view.widgets.BaseDataWrapper;
import cat.devsofthecoast.artporfolio.artworks.view.widgets.BaseViewHolder;
import cat.devsofthecoast.artporfolio.artworks.view.widgets.adapter.ArtworksAdapter;

public abstract class ArtworksViewHolder<DW extends BaseDataWrapper> extends BaseViewHolder<DW, ArtworksAdapter.Listener> {
    public ArtworksViewHolder(@NonNull View itemView) {
        super(itemView);
    }
}
