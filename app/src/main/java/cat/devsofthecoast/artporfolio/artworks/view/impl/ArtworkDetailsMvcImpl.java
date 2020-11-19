package cat.devsofthecoast.artporfolio.artworks.view.impl;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

import cat.devsofthecoast.artporfolio.R;
import cat.devsofthecoast.artporfolio.artworks.model.api.ApiArtwork;
import cat.devsofthecoast.artporfolio.artworks.view.ArtworkDetailsViewMvc;
import cat.devsofthecoast.artporfolio.common.screens.views.BaseViewMvc;

public class ArtworkDetailsMvcImpl extends BaseViewMvc implements ArtworkDetailsViewMvc {

    private final TextView tvMainContent;

    public ArtworkDetailsMvcImpl(LayoutInflater inflater,
                                 @Nullable ViewGroup parent) {
        setRootView(inflater.inflate(R.layout.layout_artwork_detail, parent, false));

        tvMainContent = findViewById(R.id.tvMainContent);
    }

    @Override
    public void bindArtwork(ApiArtwork artwork) {
        tvMainContent.setText(
                "Id -> " + artwork.getId() + "\n" +
                        "AccessionNumber -> " + artwork.getAccessionNumber() + "\n" +
                        "Title -> " + artwork.getTitle() + "\n" +
                        "OriginalTitle -> " + artwork.getOriginalTitle() + "\n" +
                        "Url -> " + artwork.getUrl()
        );
    }

    @Override
    public void showProgressIndication() {

    }

    @Override
    public void hideProgressIndication() {
        // no op
    }
}
