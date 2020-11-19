package cat.devsofthecoast.artporfolio.common.dependencyinjection.presentantion;

import cat.devsofthecoast.artporfolio.artworks.repository.ArtworkRepository;
import cat.devsofthecoast.artporfolio.artworks.usecase.RequestArtworksUseCase;
import cat.devsofthecoast.artporfolio.common.core.appconfig.AppConfig;
import dagger.Module;
import dagger.Provides;

@Module
public class UseCaseModule {

    @Provides
    public RequestArtworksUseCase provideRequestArtworksUseCase(AppConfig appConfig, ArtworkRepository repository) {
        return new RequestArtworksUseCase(appConfig, repository);
    }

}
