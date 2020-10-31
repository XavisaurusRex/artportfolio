package cat.devsofthecoast.artporfolio.dagger;

import javax.inject.Singleton;

import cat.devsofthecoast.artporfolio.MainActivity;
import dagger.Component;

@Singleton
@Component(modules = {UseCaseModule.class, MapperModule.class, UtilsModule.class})
public interface AppComponent {
    void inject(MainActivity mainActivity);
}


