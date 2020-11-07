package cat.devsofthecoast.artporfolio.bases.usecases;
import androidx.annotation.WorkerThread;

public interface UseCase<I, R> {

    @WorkerThread
    void run(I input, Callback<R> callback);

    UseCaseExecutor<I, R> buildExecutor(UseCaseCallback<R> useCaseCallback);
}
