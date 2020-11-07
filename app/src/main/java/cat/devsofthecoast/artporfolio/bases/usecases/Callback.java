package cat.devsofthecoast.artporfolio.bases.usecases;
public interface Callback<R> {

    void onSuccess(R result);

    void onError(Throwable t);
}
