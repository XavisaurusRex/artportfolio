package cat.devsofthecoast.artporfolio.common.core.appconfig;

import cat.devsofthecoast.artporfolio.common.core.usecases.executor.AsyncPostExecutor;
import cat.devsofthecoast.artporfolio.common.core.usecases.executor.AsyncThreadExecutor;

public interface AppConfig {

    AsyncThreadExecutor getAsyncThreadExecutor();

    AsyncPostExecutor getAsyncPostExecutor();
}
