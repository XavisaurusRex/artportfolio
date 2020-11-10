package cat.devsofthecoast.artporfolio.bases.models.usecases;
import androidx.annotation.Nullable;

import cat.devsofthecoast.artporfolio.bases.models.usecases.appconfig.AppConfig;
import cat.devsofthecoast.artporfolio.bases.exceptions.ArtAppException;
import cat.devsofthecoast.artporfolio.bases.models.usecases.callback.UseCaseCallback;
import cat.devsofthecoast.artporfolio.bases.models.usecases.executor.AsyncPostExecutor;
import cat.devsofthecoast.artporfolio.bases.models.usecases.executor.AsyncThreadExecutor;

public class UseCaseExecutor<I, R> {
    private final AsyncPostExecutor asyncPostExecutor;
    private final AsyncThreadExecutor asyncThreadExecutor;
    private final UseCase<I, R> useCase;
    private final UseCaseCallback<R> useCaseCallback;

    public UseCaseExecutor(AppConfig appConfig, UseCase<I, R> useCase, UseCaseCallback<R> useCaseCallback) {
        this.asyncThreadExecutor = appConfig.getAsyncThreadExecutor();
        this.asyncPostExecutor = appConfig.getAsyncPostExecutor();
        this.useCase = useCase;
        this.useCaseCallback = useCaseCallback;
    }

    public void execute(@Nullable final I input) {
        asyncThreadExecutor.execute(() -> {
            try {
                useCase.run(input, new Callback<R>() {
                    @Override
                    public void onSuccess(@Nullable final R result) {
                        handleSuccess(result);
                    }

                    @Override
                    public void onError(Throwable t) {
                        handleError(t);
                    }
                });
            } catch (ArtAppException exception) {
                // TODO: 10/11/2020 CHANGE THIS IN FUTURE, handle diferent exceptions
                handleError(exception);
            } catch (Throwable exception) {
                handleError(exception);
            }
        });
    }

    private void handleSuccess(@Nullable final R result) {
        asyncPostExecutor.execute(() -> useCaseCallback.onSuccess(result));
    }

    private void handleError(final Throwable t) {
        asyncPostExecutor.execute(() -> useCaseCallback.onError(t));
    }
}

