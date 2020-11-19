package cat.devsofthecoast.artporfolio.common.core.usecases;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;

import cat.devsofthecoast.artporfolio.common.core.usecases.callback.UseCaseCallback;

public interface UseCase<I, R> {

    @WorkerThread
    void run(@Nullable I input, Callback<R> callback) throws Exception;

    UseCaseExecutor<I, R> buildExecutor(UseCaseCallback<R> useCaseCallback);
}
