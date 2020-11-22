package cat.devsofthecoast.artporfolio.artworks.view.impl;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import cat.devsofthecoast.artporfolio.R;
import cat.devsofthecoast.artporfolio.artworks.model.api.ApiArtwork;
import cat.devsofthecoast.artporfolio.artworks.view.ArtworkDetailsViewMvc;
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
