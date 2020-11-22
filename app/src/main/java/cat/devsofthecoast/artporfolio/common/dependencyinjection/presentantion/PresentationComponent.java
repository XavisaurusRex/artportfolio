package cat.devsofthecoast.artporfolio.common.dependencyinjection.presentantion;

import cat.devsofthecoast.artporfolio.artworks.ArtworkDetailFragment;
import cat.devsofthecoast.artporfolio.artworks.ArtworksFragment;
import cat.devsofthecoast.artporfolio.artworks.view.MainActivity;
import cat.devsofthecoast.artporfolio.common.screens.dialogs.genericerror.GenericErrorDialog;
import cat.devsofthecoast.artporfolio.common.screens.dialogs.loading.LoadingDialog;
import dagger.Subcomponent;

@PresentationScope
@Subcomponent(modules = {PresentationModule.class, UseCaseModule.class, ControllerModule.class})
public interface PresentationComponent {

    void inject(MainActivity mainActivity);

    void inject(ArtworksFragment artworksFragment);

    void inject(ArtworkDetailFragment artworkDetailFragment);

    void inject(GenericErrorDialog genericErrorDialog);

    void inject(LoadingDialog loadingDialog);

}
