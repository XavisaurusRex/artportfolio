package cat.devsofthecoast.artporfolio.bases.models.usecases;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;

import cat.devsofthecoast.artporfolio.bases.models.usecases.callback.UseCaseCallback;

public interface UseCase<I, R> {

    @WorkerThread
    void run(@Nullable I input, Callback<R> callback) throws Exception;

    UseCaseExecutor<I, R> buildExecutor(UseCaseCallback<R> useCaseCallback);
}
