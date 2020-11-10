package cat.devsofthecoast.artporfolio.dagger;
import cat.devsofthecoast.artporfolio.bases.views.dialogs.ErrorHandling;
import cat.devsofthecoast.artporfolio.utils.ListUtils;
import cat.devsofthecoast.artporfolio.utils.StringUtils;
import dagger.Module;
import dagger.Provides;

@Module
public class UtilsModule {

    @Provides
    public StringUtils provideStringUtils() {
        return new StringUtils();
    }

    @Provides
    public ErrorHandling provideErrorHandling() {
        return new ErrorHandling();
    }

    @Provides
    public ListUtils provideListUtils() {
        return new ListUtils();
    }
}
