package cat.devsofthecoast.artporfolio.artworks.view.fragment.impl;
import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import cat.devsofthecoast.artporfolio.R;
import cat.devsofthecoast.artporfolio.artworks.model.api.ApiArtwork;
import cat.devsofthecoast.artporfolio.artworks.view.fragment.ArtworkDetailsViewMvc;
import cat.devsofthecoast.artporfolio.common.screens.toolbar.ToolbarViewMvc;
import cat.devsofthecoast.artporfolio.common.screens.views.ViewMvcFactory;
import cat.devsofthecoast.artporfolio.common.screens.views.mvc.impl.BaseObservableViewMvc;

public class ArtworkDetailsMvcImpl extends BaseObservableViewMvc<ArtworkDetailsViewMvc.Listener> implements ArtworkDetailsViewMvc {

    private final ToolbarViewMvc toolbarViewMvc;

    private final TextView tvMainContent;
    private final Toolbar toolbar;

    public ArtworkDetailsMvcImpl(LayoutInflater inflater,
                                 @Nullable ViewGroup parent,
                                 ViewMvcFactory viewMvcFactory) {
        setRootView(inflater.inflate(R.layout.layout_artwork_detail, parent, false));

        tvMainContent = findViewById(R.id.tvMainContent);

        toolbar = findViewById(R.id.toolbar);
        toolbarViewMvc = viewMvcFactory.newToolbarViewMvc(toolbar);
        initToolbar();
    }

    private void initToolbar() {
        toolbar.addView(toolbarViewMvc.getRootView());

        toolbarViewMvc.setTitle(getString(R.string.artwork_details_screen_title));

        toolbarViewMvc.enableUpButtonAndListen(() -> {
            for (Listener listener : getListeners()) {
                listener.onNavigateUpClicked();
            }
        });

        toolbarViewMvc.enableLocationRequestButtonAndListen(() -> {
            for (Listener listener : getListeners()) {
                listener.onLocationRequestClicked();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void bindArtwork(ApiArtwork artwork) {
        tvMainContent.setText(
                "accessionyear -> " + artwork.getAccessionyear() + "\n" +
                "technique -> " + artwork.getTechnique() + "\n" +
                "mediacount -> " + artwork.getMediacount() + "\n" +
                "totalpageviews -> " + artwork.getTotalpageviews() + "\n" +
                "groupcount -> " + artwork.getGroupcount() + "\n" +
                "people -> " + artwork.getPeople() + "\n" +
                "objectnumber -> " + artwork.getObjectnumber() + "\n" +
                "colorcount -> " + artwork.getColorcount() + "\n" +
                "lastupdate -> " + artwork.getLastupdate() + "\n" +
                "rank -> " + artwork.getRank() + "\n" +
                "imagecount -> " + artwork.getImagecount() + "\n" +
                "description -> " + artwork.getDescription() + "\n" +
                "dateoflastpageview -> " + artwork.getDateoflastpageview() + "\n" +
                "dateoffirstpageview -> " + artwork.getDateoffirstpageview() + "\n" +
                "primaryimageurl -> " + artwork.getPrimaryimageurl() + "\n");
    }

    @Override
    public void showProgressIndication() {

    }

    @Override
    public void hideProgressIndication() {
        // no op
    }
}
