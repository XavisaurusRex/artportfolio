package cat.devsofthecoast.artporfolio.artworks.view.widgets.adapter.viewholders;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.List;
import java.util.Set;

import cat.devsofthecoast.artporfolio.R;
import cat.devsofthecoast.artporfolio.artworks.model.api.ApiPeople;
import cat.devsofthecoast.artporfolio.artworks.view.widgets.adapter.ArtworksAdapter;
import cat.devsofthecoast.artporfolio.artworks.view.widgets.adapter.datawrappers.ArtworkComplexDataWrapper;
import cat.devsofthecoast.artporfolio.common.screens.utils.ListUtils;

public class ArtworkComplexViewHolder extends ArtworksViewHolder<ArtworkComplexDataWrapper> {

    private static final String ARTIST_ROLE = "Artist";

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
        final List<ApiPeople> apiPeopleList = item.getApiArtwork().getPeople();
        if (!ListUtils.isEmpty(apiPeopleList)) {
            for (int i = 0; i < apiPeopleList.size(); i++) {
                if (ARTIST_ROLE.equals(apiPeopleList.get(i).getRole())) {
                    tcArtistName.setText(item.getApiArtwork().getPeople().get(0).getName());
                    return;
                }
            }
        }
        Glide.with(itemView.getContext())
                .load(item.getApiArtwork().getPrimaryimageurl())
                .centerCrop()

                .addListener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        Log.d("Glide", "Charge image at position -> " + position + " FAILED", e);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        Log.d("Glide", "Charge image at position -> " + position + " SUCCESS");
                        return false;
                    }
                })
                .into(ivPicture);
        tvCounter.setText(String.valueOf(position));

        itemView.setOnClickListener(v -> {
            for (ArtworksAdapter.Listener listener : listeners) {
                listener.onArtworkClicked(item.getApiArtwork());
            }
        });
    }
}
