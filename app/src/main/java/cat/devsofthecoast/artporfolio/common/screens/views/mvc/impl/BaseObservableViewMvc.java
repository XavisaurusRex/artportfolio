package cat.devsofthecoast.artporfolio.common.screens.views.mvc.impl;
import android.view.View;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import cat.devsofthecoast.artporfolio.common.screens.views.mvc.ObservableViewMvc;

public abstract class BaseObservableViewMvc<ListenerType> extends BaseViewMvc
        implements ObservableViewMvc<ListenerType> {

    private Set<ListenerType> listeners = new HashSet<>();

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
