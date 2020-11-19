package cat.devsofthecoast.artporfolio.common.core.usecases.callback;
import androidx.annotation.Nullable;

public interface UseCaseCallback<R> {

    void onSuccess(@Nullable R result);

    void onError(Throwable t);
}
