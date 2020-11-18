package cat.devsofthecoast.artporfolio.artworks.view.view;
public interface ObservableViewMvc<ListenerType> extends ViewMvc {

    void registerListener(ListenerType listener);

    void unregisterListener(ListenerType listener);

}
