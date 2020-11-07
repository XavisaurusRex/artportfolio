package cat.devsofthecoast.artporfolio.bases.appconfig;
import cat.devsofthecoast.artporfolio.bases.usecases.executor.AsyncPostExecutor;
import cat.devsofthecoast.artporfolio.bases.usecases.executor.AsyncThreadExecutor;

public interface AppConfig {

    AsyncThreadExecutor getAsyncThreadExecutor();

    AsyncPostExecutor getAsyncPostExecutor();
}
