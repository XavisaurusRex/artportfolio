package cat.devsofthecoast.artporfolio.common.core.usecases.callback;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;

public interface Callback<R> {

    @WorkerThread
    void onSuccess(@Nullable R result);

    @WorkerThread
    void onError(Throwable t);

}
