package cat.devsofthecoast.artporfolio.dagger;
import cat.devsofthecoast.artporfolio.artworks.presenter.ArtworksPresenter;
import cat.devsofthecoast.artporfolio.artworks.presenter.impl.ArtworksPresenterImpl;
import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {

    @Provides
    ArtworksPresenter provideArtworksPresenter() {
        return new ArtworksPresenterImpl();
    }
}
