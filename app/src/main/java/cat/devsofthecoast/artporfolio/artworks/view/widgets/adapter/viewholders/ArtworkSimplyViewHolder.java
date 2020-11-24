package cat.devsofthecoast.artporfolio.artworks.view.widgets.adapter.viewholders;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Set;

import cat.devsofthecoast.artporfolio.R;
import cat.devsofthecoast.artporfolio.artworks.view.widgets.adapter.ArtworksAdapter;
import cat.devsofthecoast.artporfolio.artworks.view.widgets.adapter.datawrappers.ArtworkSimplyDataWrapper;

public class ArtworkSimplyViewHolder extends ArtworksViewHolder<ArtworkSimplyDataWrapper> {

    private TextView tvTitle;
    private TextView tvWorld;
    private TextView tvCounter;

    public ArtworkSimplyViewHolder(LayoutInflater inflater, ViewGroup parent) {
        super(inflater.inflate(R.layout.viewholder_simplyartwork, parent, false));
    }


    @Override
    public void bind() {
        tvTitle = findViewById(R.id.tvTitle);
        tvWorld = findViewById(R.id.tvWorld);
        tvCounter = findViewById(R.id.tvCounter);
    }

    @Override
    public void decorate(int position, ArtworkSimplyDataWrapper item, Set<ArtworksAdapter.Listener> listeners) {
        tvTitle.setText(item.getApiArtwork().getTitle());
        tvWorld.setText("NO IMAGE");
        tvCounter.setText(String.valueOf(position));

        itemView.setOnClickListener(v -> {
            for (ArtworksAdapter.Listener listener : listeners) {
                listener.onArtworkClicked(item.getApiArtwork());
            }
        });
    }
}
