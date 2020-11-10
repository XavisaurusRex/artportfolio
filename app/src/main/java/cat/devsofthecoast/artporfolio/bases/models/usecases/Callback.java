package cat.devsofthecoast.artporfolio.bases.models.usecases;
public interface Callback<R> {

    void onSuccess(R result);

    void onError(Throwable t);
}
