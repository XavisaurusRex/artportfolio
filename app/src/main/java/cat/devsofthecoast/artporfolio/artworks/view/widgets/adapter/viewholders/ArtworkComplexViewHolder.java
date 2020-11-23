package cat.devsofthecoast.artporfolio.artworks.view.widgets.adapter.viewholders;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Set;

import cat.devsofthecoast.artporfolio.R;
import cat.devsofthecoast.artporfolio.artworks.view.widgets.adapter.ArtworksAdapter;
import cat.devsofthecoast.artporfolio.artworks.view.widgets.adapter.datawrappers.ArtworkComplexDataWrapper;
import cat.devsofthecoast.artporfolio.common.screens.utils.ListUtils;

public class ArtworkComplexViewHolder extends ArtworksViewHolder<ArtworkComplexDataWrapper> {

    private TextView tvTitle;
    private TextView tcArtistName;
    private ImageView ivPicture;
    private TextView tvCounter;

    public ArtworkComplexViewHolder(LayoutInflater inflater, ViewGroup parent) {
        super(inflater.inflate(R.layout.viewholder_complexartwork, parent, false));
    }


    @Override
    public void bind() {
        tvTitle = findViewById(R.id.tvTitle);
        tcArtistName = findViewById(R.id.tcArtistName);
        ivPicture = findViewById(R.id.ivPicture);
        tvCounter = findViewById(R.id.tvCounter);
    }

    @Override
    public void decorate(int position, ArtworkComplexDataWrapper item, Set<ArtworksAdapter.Listener> listeners) {
        tvTitle.setText(item.getApiArtwork().getTitle());
        if(!ListUtils.isEmpty(item.getApiArtwork().getApiCreators())){
            tcArtistName.setText(item.getApiArtwork().getApiCreators().get(0).getDescription());
        }
        Glide.with(itemView.getContext())
                .load(item.getApiArtwork().getApiImages().getApiWeb().getImageUrl())
                .centerCrop()
                .into(ivPicture);
        tvCounter.setText(String.valueOf(position));

        itemView.setOnClickListener(v -> {
            for (ArtworksAdapter.Listener listener : listeners) {
                listener.onArtworkClicked(item.getApiArtwork());
            }
        });
    }
}
