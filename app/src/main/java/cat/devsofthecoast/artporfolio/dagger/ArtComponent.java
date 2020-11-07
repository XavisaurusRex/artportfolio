package cat.devsofthecoast.artporfolio.dagger;

import javax.inject.Singleton;

import cat.devsofthecoast.artporfolio.artworks.view.ArtworkDetailActivity;
import cat.devsofthecoast.artporfolio.artworks.view.ArtworksActivity;
import dagger.Component;

@Singleton
@Component(modules = {UseCaseModule.class, PresenterModule.class, MapperModule.class, UtilsModule.class, CoreModule.class})
public interface ArtComponent {

    void inject(ArtworksActivity artworksActivity);

    void inject(ArtworkDetailActivity artworkDetailActivity);
}


