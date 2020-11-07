package cat.devsofthecoast.artporfolio.bases.presenter.impl;
import androidx.annotation.CallSuper;

import cat.devsofthecoast.artporfolio.bases.presenter.BasePresenter;

public abstract class BasePresenterImpl<T extends BasePresenter.BaseView> implements BasePresenter<T> {

    private T view;

    @Override
    public void setView(T view) {
        this.view = view;
        initUseCaseObservers(view);
    }

    @Override
    public T getView() {
        return view;
    }

    @CallSuper
    @Override
    public void destroy() {
        this.view = null;
        destroyUseCaseObservers();
    }
}
