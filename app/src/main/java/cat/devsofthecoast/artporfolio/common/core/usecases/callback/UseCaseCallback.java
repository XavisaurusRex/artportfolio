package cat.devsofthecoast.artporfolio.common.core.usecases.callback;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;

public interface UseCaseCallback<R> {

    @UiThread
    void onSuccess(@Nullable R result);

    @UiThread
    void onError(Throwable t);
}
