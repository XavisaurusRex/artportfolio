package cat.devsofthecoast.artporfolio.bases.models.usecases;
import androidx.annotation.Nullable;

public interface Callback<R> {

    void onSuccess(@Nullable R result);

    void onError(Throwable t);
}
