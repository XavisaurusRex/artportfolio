package cat.devsofthecoast.artporfolio.artworks.view;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import javax.inject.Inject;

import cat.devsofthecoast.artporfolio.artworks.model.api.ApiArtwork;
import cat.devsofthecoast.artporfolio.artworks.view.view.ArtworkDetailsViewMvc;
import cat.devsofthecoast.artporfolio.bases.views.activity.BaseActivity;
import cat.devsofthecoast.artporfolio.bases.views.mvc.ViewMvcFactory;
import cat.devsofthecoast.artporfolio.dependencyinjection.presentantion.PresentationComponent;

public class ArtworkDetailActivity extends BaseActivity {

    public static final String EXTRA_ARTWORK_DESCRIPTION = "artworkDescription";
    private TextView tvMainContent;

    @Inject ViewMvcFactory viewMvcFactory;
    private ArtworkDetailsViewMvc viewMvc;

    public static void start(Context context, ApiArtwork artwork) {
        Intent intent = new Intent(context, ArtworkDetailActivity.class);
        intent.putExtra(EXTRA_ARTWORK_DESCRIPTION, artwork);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewMvc = viewMvcFactory.newArtworkDetailsViewMvc(null);
        setContentView(viewMvc.getRootView());
    }

    @Override
    protected void onStart() {
        super.onStart();
        viewMvc.bindArtwork(getArtworkDescriptionFromExtras());
    }

    @Nullable
    private ApiArtwork getArtworkDescriptionFromExtras() {
        final Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            return (ApiArtwork) bundle.getSerializable(EXTRA_ARTWORK_DESCRIPTION);
        }
        return null;
    }

    @Override
    protected void injectView(PresentationComponent injector) {
        injector.inject(this);
    }
}
