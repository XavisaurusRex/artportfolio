package cat.devsofthecoast.artporfolio.common.core.usecases.usecase;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;

import cat.devsofthecoast.artporfolio.common.core.usecases.callback.Callback;
import cat.devsofthecoast.artporfolio.common.core.usecases.callback.UseCaseCallback;
import cat.devsofthecoast.artporfolio.common.core.usecases.executor.impl.UseCaseExecutor;

public interface UseCase<I, R> extends UseCaseCallback<R> {

    @WorkerThread
    void run(@Nullable I input, Callback<R> callback) throws Exception;

    UseCaseExecutor<I, R> buildExecutor();
}
