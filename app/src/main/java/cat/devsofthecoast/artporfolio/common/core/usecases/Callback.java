package cat.devsofthecoast.artporfolio.common.core.usecases;
import androidx.annotation.Nullable;

public interface Callback<R> {

    void onSuccess(@Nullable R result);

    void onError(Throwable t);
}
