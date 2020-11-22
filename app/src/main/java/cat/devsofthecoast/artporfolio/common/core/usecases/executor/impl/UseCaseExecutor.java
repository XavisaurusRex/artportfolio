package cat.devsofthecoast.artporfolio.common.core.usecases.executor.impl;
import androidx.annotation.Nullable;

import cat.devsofthecoast.artporfolio.common.core.appconfig.AppConfig;
import cat.devsofthecoast.artporfolio.common.core.usecases.usecase.UseCase;
import cat.devsofthecoast.artporfolio.common.core.usecases.callback.Callback;
import cat.devsofthecoast.artporfolio.common.core.usecases.callback.UseCaseCallback;
import cat.devsofthecoast.artporfolio.common.core.usecases.executor.AsyncPostExecutor;
import cat.devsofthecoast.artporfolio.common.core.usecases.executor.AsyncThreadExecutor;

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

