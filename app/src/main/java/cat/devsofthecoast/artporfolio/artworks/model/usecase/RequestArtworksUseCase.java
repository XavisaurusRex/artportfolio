package cat.devsofthecoast.artporfolio.artworks.model.usecase;
import androidx.annotation.Nullable;

import java.io.IOException;

import cat.devsofthecoast.artporfolio.artworks.model.api.ApiArtworksRoot;
import cat.devsofthecoast.artporfolio.artworks.model.repository.ArtworkRepository;
import cat.devsofthecoast.artporfolio.bases.exceptions.ArtAppException;
import cat.devsofthecoast.artporfolio.bases.models.usecases.Callback;
import cat.devsofthecoast.artporfolio.bases.models.usecases.UseCase;
import cat.devsofthecoast.artporfolio.bases.models.usecases.UseCaseExecutor;
import cat.devsofthecoast.artporfolio.bases.models.usecases.appconfig.AppConfig;
import cat.devsofthecoast.artporfolio.bases.models.usecases.callback.UseCaseCallback;
import retrofit2.Response;

public class RequestArtworksUseCase implements UseCase<String, ApiArtworksRoot> {

    public static final int LIMIT_RESULTS_NUMBER = 20;
    private final AppConfig appConfig;
    private final ArtworkRepository repository;

    public RequestArtworksUseCase(AppConfig appConfig, ArtworkRepository repository) {
        this.appConfig = appConfig;
        this.repository = repository;
    }

    @Override
    public void run(@Nullable String input, @Nullable Callback<ApiArtworksRoot> callback) throws ArtAppException, IOException {
        Response<ApiArtworksRoot> response = repository.getArtworks(input, LIMIT_RESULTS_NUMBER).execute();
        if (response.isSuccessful()) {
            callback.onSuccess(response.body());
        } else {
            throw new ArtAppException("Cant parse response");
        }
    }

    @Override
    public UseCaseExecutor<String, ApiArtworksRoot> buildExecutor(final UseCaseCallback<ApiArtworksRoot> useCaseCallback) {
        return new Executor(useCaseCallback);
    }

    private class Executor extends UseCaseExecutor<String, ApiArtworksRoot> {
        private Executor(UseCaseCallback<ApiArtworksRoot> useCaseCallback) {
            super(appConfig, RequestArtworksUseCase.this, useCaseCallback);
        }
    }
}
