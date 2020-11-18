package cat.devsofthecoast.artporfolio.dependencyinjection.presentantion;

import cat.devsofthecoast.artporfolio.artworks.view.ArtworkDetailActivity;
import cat.devsofthecoast.artporfolio.artworks.view.ArtworksActivity;
import dagger.Subcomponent;

@PresentationScope
@Subcomponent(modules = {PresentationModule.class, UseCaseModule.class})
public interface PresentationComponent {

    void inject(ArtworksActivity artworksActivity);

    void inject(ArtworkDetailActivity artworkDetailActivity);

}
