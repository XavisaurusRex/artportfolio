package cat.devsofthecoast.artporfolio.bases.models.usecases.callback;
import androidx.annotation.Nullable;

public interface UseCaseCallback<R> {

    void onSuccess(@Nullable R result);

    void onError(Throwable t);
}
