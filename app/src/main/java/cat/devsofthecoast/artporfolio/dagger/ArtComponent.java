package cat.devsofthecoast.artporfolio.dagger;

import javax.inject.Singleton;

import cat.devsofthecoast.artporfolio.ArtworksActivity;
import cat.devsofthecoast.artporfolio.bases.BaseActivity;
import dagger.Component;

@Singleton
@Component(modules = {UseCaseModule.class, MapperModule.class, UtilsModule.class})
public interface ArtComponent {
    void inject(BaseActivity baseActivity);

    void inject(ArtworksActivity artworksActivity);

}


