package cat.devsofthecoast.artporfolio.artworks.usecase;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.WorkerThread;

import java.io.IOException;

import cat.devsofthecoast.artporfolio.artworks.model.api.ApiArtworksRoot;
import cat.devsofthecoast.artporfolio.artworks.repository.ArtworkRepository;
import cat.devsofthecoast.artporfolio.common.core.appconfig.AppConfig;
import cat.devsofthecoast.artporfolio.common.core.exceptions.ArtAppException;
import cat.devsofthecoast.artporfolio.common.core.usecases.callback.Callback;
import cat.devsofthecoast.artporfolio.common.core.usecases.usecase.impl.BaseObservableUseCase;
import retrofit2.Response;

public class RequestArtworksUseCase extends BaseObservableUseCase<String, ApiArtworksRoot, RequestArtworksUseCase.Listener> {

    public static final int LIMIT_RESULTS_NUMBER = 20;
    private final ArtworkRepository repository;

    public RequestArtworksUseCase(AppConfig appConfig, ArtworkRepository repository) {
        super(appConfig);
        this.repository = repository;
    }

    @Override
    @WorkerThread
    public void run(@Nullable String input, Callback<ApiArtworksRoot> callback) throws IOException {
        Response<ApiArtworksRoot> response = repository.getArtworks(input, LIMIT_RESULTS_NUMBER).execute();
        if (response.isSuccessful()) {
            callback.onSuccess(response.body());
        } else {
            callback.onError(new ArtAppException("Cant parse response"));
        }
    }

    @Override
    @UiThread
    public void onSuccess(@Nullable ApiArtworksRoot result) {
        for (Listener listener : getListeners()) {
            listener.onRequestArtworksUseCaseSuccess(result);
        }
    }

    @Override
    @UiThread
    public void onError(Throwable t) {
        for (Listener listener : getListeners()) {
            listener.onRequestArtworksUseCaseError(t);
        }
    }

    public interface Listener {
        void onRequestArtworksUseCaseSuccess(ApiArtworksRoot apiArtworksRoot);

        void onRequestArtworksUseCaseError(Throwable t);
    }
}
