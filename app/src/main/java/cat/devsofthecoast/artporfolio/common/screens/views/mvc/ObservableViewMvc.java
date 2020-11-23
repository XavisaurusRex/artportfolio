package cat.devsofthecoast.artporfolio.common.screens.views.mvc;
import cat.devsofthecoast.artporfolio.common.screens.views.mvc.ViewMvc;

public interface ObservableViewMvc<ListenerType> extends ViewMvc {

    void registerListener(ListenerType listener);

    void unregisterListener(ListenerType listener);

}
