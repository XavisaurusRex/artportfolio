package cat.devsofthecoast.artporfolio.common.core.usecases.usecase.impl;
import cat.devsofthecoast.artporfolio.common.core.appconfig.AppConfig;
import cat.devsofthecoast.artporfolio.common.core.usecases.usecase.UseCase;
import cat.devsofthecoast.artporfolio.common.core.usecases.executor.impl.UseCaseExecutor;

public abstract class BaseUseCase<I, R> implements UseCase<I, R> {

    private final AppConfig appConfig;

    public BaseUseCase(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    @Override
    public UseCaseExecutor<I, R> buildExecutor() {
        return new UseCaseExecutor<>(appConfig, this, this);
    }

}
