package cat.devsofthecoast.artporfolio.bases.models.usecases.callback;
public interface UseCaseCallback<R> {

    void onSuccess(R result);

    void onError(Throwable t);
}
