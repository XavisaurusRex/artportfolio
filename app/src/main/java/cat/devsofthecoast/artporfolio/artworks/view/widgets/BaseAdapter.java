package cat.devsofthecoast.artporfolio.artworks.view.widgets;
import androidx.annotation.NonNull;

import java.util.List;

public abstract class BaseAdapter<DW extends BaseDataWrapper, VH extends BaseViewHolder<DW, L>, L> extends BaseObservableRecycler<DW, VH, L> {

    private List<DW> data;

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.bind();
        holder.decorate(position, getItem(position), getListeners());
    }

    public DW getItem(int position) {
        return data != null && position < data.size()
                ? data.get(position)
                : null;
    }

    @Override
    public int getItemViewType(int position) {
        return getItem(position).getViewType();
    }

    public void setData(List<DW> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public List<DW> getData() {
        return data;
    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

}
