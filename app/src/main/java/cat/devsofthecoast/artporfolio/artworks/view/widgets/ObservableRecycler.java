package cat.devsofthecoast.artporfolio.artworks.view.widgets;
import androidx.recyclerview.widget.RecyclerView;

public interface ObservableRecycler<ListenerType> {
    void registerListener(ListenerType listener);

    void unregisterListener(ListenerType listener);
}
