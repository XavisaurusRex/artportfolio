package cat.devsofthecoast.artporfolio.common.dependencyinjection.app.modules;

import android.app.Application;

import cat.devsofthecoast.artporfolio.common.core.appconfig.AppConfig;
import cat.devsofthecoast.artporfolio.common.core.appconfig.AppConfigImpl;
import cat.devsofthecoast.artporfolio.common.core.usecases.executor.AsyncPostExecutor;
import cat.devsofthecoast.artporfolio.common.core.usecases.executor.AsyncThreadExecutor;
import cat.devsofthecoast.artporfolio.common.core.usecases.executor.impl.AsyncPostExecutorImpl;
import cat.devsofthecoast.artporfolio.common.core.usecases.executor.impl.AsyncThreadExecutorImpl;
import cat.devsofthecoast.artporfolio.common.dependencyinjection.app.scopes.AppScope;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    public Application provideApplication() {
        return application;
    }

    @AppScope
    @Provides
    public AppConfig provideAppConfig(AsyncThreadExecutor asyncThreadExecutor, AsyncPostExecutor asyncPostExecutor) {
        return new AppConfigImpl(asyncThreadExecutor, asyncPostExecutor);
    }

    @AppScope
    @Provides
    public AsyncThreadExecutor provideAsyncThreadExecutor() {
        return new AsyncThreadExecutorImpl();
    }

    @AppScope
    @Provides
    public AsyncPostExecutor provideAsyncPostExecutor() {
        return new AsyncPostExecutorImpl();
    }

}
