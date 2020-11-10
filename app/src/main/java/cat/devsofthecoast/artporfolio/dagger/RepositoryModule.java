package cat.devsofthecoast.artporfolio.dagger;
import cat.devsofthecoast.artporfolio.artworks.model.repository.ArtworkRepository;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RepositoryModule {

    public static final String BASE_URL = "https://openaccess-api.clevelandart.org/api/";

    @Provides
    ArtworkRepository provideArtworkRepository() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ArtworkRepository.class);
    }
}
