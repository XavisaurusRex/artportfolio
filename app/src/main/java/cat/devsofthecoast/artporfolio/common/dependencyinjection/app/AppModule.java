package cat.devsofthecoast.artporfolio.common.dependencyinjection.app;

import android.app.Application;

import cat.devsofthecoast.artporfolio.artworks.repository.ArtworkRepository;
import cat.devsofthecoast.artporfolio.common.core.appconfig.AppConfig;
import cat.devsofthecoast.artporfolio.common.core.appconfig.AppConfigImpl;
import cat.devsofthecoast.artporfolio.common.core.usecases.executor.AsyncPostExecutor;
import cat.devsofthecoast.artporfolio.common.core.usecases.executor.AsyncThreadExecutor;
import cat.devsofthecoast.artporfolio.common.core.usecases.executor.impl.AsyncPostExecutorImpl;
import cat.devsofthecoast.artporfolio.common.core.usecases.executor.impl.AsyncThreadExecutorImpl;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {
    public static final String BASE_URL = "https://openaccess-api.clevelandart.org/api/";

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

    @AppScope
    @Provides
    public ArtworkRepository provideArtworkRepository() {
        return getRetrofit().create(ArtworkRepository.class);
    }

    @AppScope
    @Provides
    public Retrofit getRetrofit() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
