package cat.devsofthecoast.artporfolio.dagger;
import javax.inject.Singleton;

import cat.devsofthecoast.artporfolio.artworks.model.repository.ArtworkRepository;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RepositoryModule {

    public static final String BASE_URL = "https://openaccess-api.clevelandart.org/api/";

    @Provides
    ArtworkRepository provideArtworkRepository() {
        return getRetrofit().create(ArtworkRepository.class);
    }

    private Retrofit getRetrofit() {
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
