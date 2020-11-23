package cat.devsofthecoast.artporfolio.common.core.usecases.usecase.impl;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import cat.devsofthecoast.artporfolio.common.core.appconfig.AppConfig;
import cat.devsofthecoast.artporfolio.common.core.usecases.usecase.ObservableUseCase;

public abstract class BaseObservableUseCase<I, R, ListenerType> extends BaseUseCase<I, R> implements ObservableUseCase<ListenerType> {

    private Set<ListenerType> listeners = new HashSet<>();

    public BaseObservableUseCase(AppConfig appConfig) {
        super(appConfig);
    }

    @Override
    public void registerListener(ListenerType listener) {
        listeners.add(listener);
    }

    @Override
    public void unregisterListener(ListenerType listener) {
        listeners.remove(listener);
    }

    protected final Set<ListenerType> getListeners() {
        return Collections.unmodifiableSet(listeners);
    }

}
