package cat.devsofthecoast.artporfolio.dagger;
import cat.devsofthecoast.artporfolio.artworks.presenter.ArtworksPresenter;
import cat.devsofthecoast.artporfolio.artworks.presenter.impl.ArtworksPresenterImpl;
import cat.devsofthecoast.artporfolio.artworks.usecase.impl.RequestArtworksUseCase;
import cat.devsofthecoast.artporfolio.bases.appconfig.AppConfig;
import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {

    @Provides
    ArtworksPresenter provideArtworksPresenter(RequestArtworksUseCase requestArtworksUseCase) {
        return new ArtworksPresenterImpl(requestArtworksUseCase);
    }
}
