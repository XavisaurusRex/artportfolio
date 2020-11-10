package cat.devsofthecoast.artporfolio.bases.models.usecases.executor;
import androidx.annotation.NonNull;

import java.util.concurrent.ThreadPoolExecutor;

public interface AsyncThreadExecutor {
    void execute(@NonNull Runnable runnable);

    ThreadPoolExecutor getExecutor();
}
