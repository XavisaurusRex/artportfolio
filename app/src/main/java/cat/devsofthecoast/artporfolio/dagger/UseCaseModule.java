package cat.devsofthecoast.artporfolio.dagger;

import cat.devsofthecoast.artporfolio.artworks.model.repository.ArtworkRepository;
import cat.devsofthecoast.artporfolio.artworks.model.usecase.RequestArtworksUseCase;
import cat.devsofthecoast.artporfolio.bases.models.usecases.appconfig.AppConfig;
import dagger.Module;
import dagger.Provides;

@Module
public class UseCaseModule {

    @Provides
    public RequestArtworksUseCase provideRequestArtworksUseCase(AppConfig appConfig, ArtworkRepository artworkRepository) {
        return new RequestArtworksUseCase(appConfig, artworkRepository);
    }

}
