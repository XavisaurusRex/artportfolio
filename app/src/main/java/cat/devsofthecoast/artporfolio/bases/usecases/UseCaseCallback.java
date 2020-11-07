package cat.devsofthecoast.artporfolio.bases.usecases;
public interface UseCaseCallback<R> {

    void onSuccess(R result);

    void onError(Throwable t);
}
