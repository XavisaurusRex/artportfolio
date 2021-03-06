package cat.devsofthecoast.artporfolio.bases.models.usecases.executor.impl;
import android.os.Handler;
import android.os.Looper;

import cat.devsofthecoast.artporfolio.bases.models.usecases.executor.AsyncPostExecutor;

public class AsyncPostExecutorImpl implements AsyncPostExecutor {
    private final Handler handler = new Handler(Looper.getMainLooper());

    @Override
    public void execute(Runnable runnable) {
        handler.post(runnable);
    }
}
