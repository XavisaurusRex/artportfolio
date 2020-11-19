package cat.devsofthecoast.artporfolio.common.core.usecases.executor.impl;
import androidx.annotation.NonNull;

import java.util.Objects;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import cat.devsofthecoast.artporfolio.common.core.usecases.executor.AsyncThreadExecutor;

public class AsyncThreadExecutorImpl implements AsyncThreadExecutor {

    private final ThreadPoolExecutor threadPoolExecutor;

    public AsyncThreadExecutorImpl() {
        threadPoolExecutor = new ThreadPoolExecutor(
                3,
                Integer.MAX_VALUE,
                60,
                TimeUnit.SECONDS,
                new SynchronousQueue<>());
    }

    @Override
    public void execute(@NonNull Runnable runnable) {
        Objects.requireNonNull(runnable, "Runnable to execute cannot be null");
        threadPoolExecutor.execute(runnable);
    }

    @Override
    public ThreadPoolExecutor getExecutor() {
        return threadPoolExecutor;
    }
}
