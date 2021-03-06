package cat.devsofthecoast.artporfolio.dagger;

import javax.inject.Singleton;

import cat.devsofthecoast.artporfolio.bases.models.usecases.appconfig.AppConfig;
import cat.devsofthecoast.artporfolio.bases.models.usecases.appconfig.AppConfigImpl;
import cat.devsofthecoast.artporfolio.bases.models.usecases.executor.AsyncPostExecutor;
import cat.devsofthecoast.artporfolio.bases.models.usecases.executor.AsyncThreadExecutor;
import cat.devsofthecoast.artporfolio.bases.models.usecases.executor.impl.AsyncPostExecutorImpl;
import cat.devsofthecoast.artporfolio.bases.models.usecases.executor.impl.AsyncThreadExecutorImpl;
import dagger.Module;
import dagger.Provides;

@Module
public class CoreModule {

    @Singleton
    @Provides
    public AppConfig provideAppConfig(AsyncThreadExecutor asyncThreadExecutor, AsyncPostExecutor asyncPostExecutor) {
        return new AppConfigImpl(asyncThreadExecutor, asyncPostExecutor);
    }

    @Singleton
    @Provides
    public AsyncThreadExecutor provideAsyncThreadExecutor() {
        return new AsyncThreadExecutorImpl();
    }

    @Singleton
    @Provides
    public AsyncPostExecutor provideAsyncPostExecutor() {
        return new AsyncPostExecutorImpl();
    }
}
