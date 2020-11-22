package cat.devsofthecoast.artporfolio.common.core.usecases.usecase;
public interface ObservableUseCase<ListenerType> {

    void registerListener(ListenerType listener);

    void unregisterListener(ListenerType listener);

}
