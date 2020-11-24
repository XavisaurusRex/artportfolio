package cat.devsofthecoast.artporfolio.common.dependencyinjection.app.modules;

import cat.devsofthecoast.artporfolio.BuildConfig;
import cat.devsofthecoast.artporfolio.artworks.repository.ArtworkRepository;
import cat.devsofthecoast.artporfolio.common.dependencyinjection.app.scopes.AppScope;
import cat.devsofthecoast.artporfolio.common.dependencyinjection.app.scopes.HarvardArtMuseumApiScope;
import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RepositoryModule {

    public static final String HARVARD_ART_MUSEUM_API_KEY = "apikey";

    @AppScope
    @Provides
    public ArtworkRepository provideArtworkRepository(@HarvardArtMuseumApiScope OkHttpClient okHttpClient) {
        return getRetrofit(okHttpClient).create(ArtworkRepository.class);
    }

    @AppScope
    @Provides
    public Retrofit getRetrofit(@HarvardArtMuseumApiScope OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @AppScope
    @HarvardArtMuseumApiScope
    public OkHttpClient provideOkHttpClientForHarvardArtMuseumRequests(@HarvardArtMuseumApiScope String HARVARD_ART_MUSEUM_API_KEY_VALUE) {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();

        httpClientBuilder.addInterceptor(
                (Interceptor) chain -> {
                    Request.Builder request = chain.request().newBuilder();
                    HttpUrl originalHttpUrl = chain.request().url();
                    HttpUrl url = originalHttpUrl.newBuilder().addQueryParameter(HARVARD_ART_MUSEUM_API_KEY, HARVARD_ART_MUSEUM_API_KEY_VALUE).build();
                    request.url(url);
                    return chain.proceed(request.build());
                }
        );

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpClientBuilder.addInterceptor(logging);
        }


        return httpClientBuilder.build();
    }

    /**
     * We need an api key to acces Harvard Art Museum public api, you have to request yours and
     * put in your gradle.properties.
     *
     * @return String ApiKey
     * @see <a href="https://docs.google.com/forms/d/e/1FAIpQLSfkmEBqH76HLMMiCC-GPPnhcvHC9aJS86E32dOd0Z8MpY2rvQ/viewform">Request Api Key to execute this app</a>
     */
    @Provides
    @AppScope
    @HarvardArtMuseumApiScope
    public String provideHarvardArtMuseumApiKey() {
        return BuildConfig.API_KEY;
    }
}
