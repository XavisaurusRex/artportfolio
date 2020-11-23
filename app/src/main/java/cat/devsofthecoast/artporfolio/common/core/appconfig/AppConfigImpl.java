package cat.devsofthecoast.artporfolio.common.core.appconfig;

import androidx.annotation.NonNull;

import cat.devsofthecoast.artporfolio.common.core.usecases.executor.AsyncPostExecutor;
import cat.devsofthecoast.artporfolio.common.core.usecases.executor.AsyncThreadExecutor;

public class AppConfigImpl implements AppConfig {

    private final AsyncThreadExecutor asyncThreadExecutor;
    private final AsyncPostExecutor asyncPostExecutor;

    public AppConfigImpl(AsyncThreadExecutor asyncThreadExecutor, AsyncPostExecutor asyncPostExecutor) {
        this.asyncThreadExecutor = asyncThreadExecutor;
        this.asyncPostExecutor = asyncPostExecutor;
    }

    @Override
    @NonNull
    public AsyncThreadExecutor getAsyncThreadExecutor() {
        return asyncThreadExecutor;
    }

    @Override
    @NonNull
    public AsyncPostExecutor getAsyncPostExecutor() {
        return asyncPostExecutor;
    }
}
