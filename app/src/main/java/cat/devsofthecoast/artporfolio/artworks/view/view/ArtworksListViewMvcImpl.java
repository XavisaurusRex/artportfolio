package cat.devsofthecoast.artporfolio.artworks.view.view;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.List;

import cat.devsofthecoast.artporfolio.R;
import cat.devsofthecoast.artporfolio.artworks.model.api.ApiArtwork;

public class ArtworksListViewMvcImpl extends BaseObservableViewMvc<ArtworksListViewMvc.Listener> implements ArtworksListViewMvc {

    private final TextView tvMainContent;

    public ArtworksListViewMvcImpl(LayoutInflater inflater,
                                   @Nullable ViewGroup parent) {
        setRootView(inflater.inflate(R.layout.layout_artworks_list, parent, false));

        tvMainContent = findViewById(R.id.tvMainContent);
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
