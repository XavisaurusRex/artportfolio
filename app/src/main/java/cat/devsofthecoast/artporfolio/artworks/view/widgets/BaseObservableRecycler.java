package cat.devsofthecoast.artporfolio.artworks.view.widgets;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class BaseObservableRecycler<DW extends BaseDataWrapper, VH extends BaseViewHolder<DW, L>, L> extends RecyclerView.Adapter<VH> implements ObservableRecycler<L> {

    private final Set<L> listeners = new HashSet<>();

    @Override
    public void registerListener(L listener) {
        listeners.add(listener);
    }

    @Override
    public void unregisterListener(L listener) {
        listeners.remove(listener);
    }

    protected final Set<L> getListeners() {
        return Collections.unmodifiableSet(listeners);
    }
}
