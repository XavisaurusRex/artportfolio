package cat.devsofthecoast.artporfolio.artworks.view.widgets;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Set;

public abstract class BaseViewHolder<T extends BaseDataWrapper, L> extends RecyclerView.ViewHolder {

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public abstract void bind();

    public abstract void decorate(int position, final T item, final Set<L> listeners);

    protected <T extends View> T findViewById(int id) {
        return itemView.findViewById(id);
    }

}
