package cat.devsofthecoast.artporfolio.common.core.usecases.executor;
import androidx.annotation.NonNull;

import java.util.concurrent.ThreadPoolExecutor;

public interface AsyncThreadExecutor {
    void execute(@NonNull Runnable runnable);

    ThreadPoolExecutor getExecutor();
}
