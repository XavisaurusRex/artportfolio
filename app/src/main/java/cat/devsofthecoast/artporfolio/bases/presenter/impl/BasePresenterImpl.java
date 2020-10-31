package cat.devsofthecoast.artporfolio.bases.presenter.impl;
import cat.devsofthecoast.artporfolio.bases.presenter.BasePresenter;

public class BasePresenterImpl<T extends BasePresenter.BaseView> implements BasePresenter<T> {

    private T view;

    @Override
    public void setView(T view) {
        this.view = view;
    }

    @Override
    public T getView() {
        return view;
    }

}
