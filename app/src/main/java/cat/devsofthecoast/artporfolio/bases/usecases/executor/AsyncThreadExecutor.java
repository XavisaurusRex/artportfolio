package cat.devsofthecoast.artporfolio.bases.usecases.executor;
import androidx.annotation.NonNull;

public interface AsyncThreadExecutor {
    void execute(@NonNull Runnable runnable);
}
