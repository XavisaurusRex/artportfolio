package cat.devsofthecoast.artporfolio.dagger;
import cat.devsofthecoast.artporfolio.utils.StringUtils;
import dagger.Module;
import dagger.Provides;

@Module
public class UtilsModule {

    @Provides
    public StringUtils provideStringUtils() {
        return new StringUtils();
    }
}
