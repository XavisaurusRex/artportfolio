package cat.devsofthecoast.artporfolio.bases.models.usecases.executor;
public interface AsyncPostExecutor {
    void execute(Runnable runnable);
}
