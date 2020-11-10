package cat.devsofthecoast.artporfolio.bases.models.usecases.appconfig;
import cat.devsofthecoast.artporfolio.bases.models.usecases.executor.AsyncPostExecutor;
import cat.devsofthecoast.artporfolio.bases.models.usecases.executor.AsyncThreadExecutor;

public interface AppConfig {

    AsyncThreadExecutor getAsyncThreadExecutor();

    AsyncPostExecutor getAsyncPostExecutor();
}
