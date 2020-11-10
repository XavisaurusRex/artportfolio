package cat.devsofthecoast.artporfolio.artworks.model.usecase;
import java.io.IOException;
import java.util.List;

import cat.devsofthecoast.artporfolio.artworks.model.api.ApiArtwork;
import cat.devsofthecoast.artporfolio.artworks.model.app.Artwork;
import cat.devsofthecoast.artporfolio.artworks.model.repository.ArtworkRepository;
import cat.devsofthecoast.artporfolio.bases.models.usecases.appconfig.AppConfig;
import cat.devsofthecoast.artporfolio.bases.exceptions.ArtAppException;
import cat.devsofthecoast.artporfolio.bases.models.usecases.Callback;
import cat.devsofthecoast.artporfolio.bases.models.usecases.UseCase;
import cat.devsofthecoast.artporfolio.bases.models.usecases.UseCaseExecutor;
import cat.devsofthecoast.artporfolio.bases.models.usecases.callback.UseCaseCallback;
import retrofit2.Response;

public class RequestArtworksUseCase implements UseCase<String, ApiArtwork> {

    private final AppConfig appConfig;
    private final ArtworkRepository repository;

    public RequestArtworksUseCase(AppConfig appConfig, ArtworkRepository repository) {
        this.appConfig = appConfig;
        this.repository = repository;
    }

    @Override
    public void run(String input, Callback<ApiArtwork> callback) throws ArtAppException, IOException {
        Response<ApiArtwork> response = repository.getArtworks().execute();
        if (response.isSuccessful()) {
            callback.onSuccess(response.body());
        } else {
            throw new ArtAppException("Cant parse response");
        }
    }

    @Override
    public UseCaseExecutor<String, ApiArtwork> buildExecutor(final UseCaseCallback<ApiArtwork> useCaseCallback) {
        return new Executor(useCaseCallback);
    }

    private class Executor extends UseCaseExecutor<String, ApiArtwork> {
        private Executor(UseCaseCallback<ApiArtwork> useCaseCallback) {
            super(appConfig, RequestArtworksUseCase.this, useCaseCallback);
        }
    }
}
