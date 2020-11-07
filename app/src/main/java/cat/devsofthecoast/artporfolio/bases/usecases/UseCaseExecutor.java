package cat.devsofthecoast.artporfolio.bases.usecases;
import cat.devsofthecoast.artporfolio.bases.appconfig.AppConfig;
import cat.devsofthecoast.artporfolio.bases.usecases.executor.AsyncPostExecutor;
import cat.devsofthecoast.artporfolio.bases.usecases.executor.AsyncThreadExecutor;

public class UseCaseExecutor<I, R> {
    private final AsyncPostExecutor asyncPostExecutor;
    private final AsyncThreadExecutor asyncThreadExecutor;
    private final UseCase<I, R> useCase;
    private UseCaseCallback<R> useCaseCallback;

    public UseCaseExecutor(AppConfig appConfig, UseCase<I, R> useCase, UseCaseCallback<R> useCaseCallback) {
        asyncThreadExecutor = appConfig.getAsyncThreadExecutor();
        asyncPostExecutor = appConfig.getAsyncPostExecutor();
        this.useCase = useCase;
        this.useCaseCallback = useCaseCallback;
    }

    public void execute(final I input) {
        asyncThreadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                useCase.run(input, new Callback<R>() {
                    @Override
                    public void onSuccess(final R result) {
                        try {
                            asyncPostExecutor.execute(new Runnable() {
                                @Override
                                public void run() {
                                    useCaseCallback.onSuccess(result);
                                }
                            });
                        } catch (Throwable t) {
                            handleError(t);
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        handleError(t);
                    }
                });
            }
        });
    }

    void cancel() {
        useCaseCallback = null;
    }

    private void handleError(final Throwable t) {
        asyncPostExecutor.execute(new Runnable() {
            @Override
            public void run() {
                useCaseCallback.onError(t);
            }
        });
    }
}

