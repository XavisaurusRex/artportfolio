package cat.devsofthecoast.artporfolio.common.core.usecases.executor;
public interface AsyncPostExecutor {
    void execute(Runnable runnable);
}
