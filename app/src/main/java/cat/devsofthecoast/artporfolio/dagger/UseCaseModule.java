package cat.devsofthecoast.artporfolio.dagger;

import cat.devsofthecoast.artporfolio.artworks.usecase.impl.RequestArtworksUseCase;
import cat.devsofthecoast.artporfolio.bases.appconfig.AppConfig;
import cat.devsofthecoast.artporfolio.utils.StringUtils;
import dagger.Module;
import dagger.Provides;

@Module
public class UseCaseModule {

    @Provides
    public RequestArtworksUseCase provideRequestArtworksUseCase(AppConfig appConfig, StringUtils stringUtils) {
        return new RequestArtworksUseCase(appConfig, stringUtils);
    }

}
