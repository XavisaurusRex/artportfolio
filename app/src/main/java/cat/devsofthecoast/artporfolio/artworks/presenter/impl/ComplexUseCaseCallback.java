package cat.devsofthecoast.artporfolio.artworks.presenter.impl;
import androidx.annotation.NonNull;

import cat.devsofthecoast.artporfolio.bases.presenter.BasePresenter;
import cat.devsofthecoast.artporfolio.bases.usecases.UseCaseCallback;

public abstract class ComplexUseCaseCallback<P extends BasePresenter<V>, V extends BasePresenter.BaseView, S> implements UseCaseCallback<S> {

    private final P viewLocator;
    private final boolean autoHideLoading;

    public ComplexUseCaseCallback(P viewLocator) {
        this.viewLocator = viewLocator;
        this.autoHideLoading = true;
    }

    public ComplexUseCaseCallback(P viewLocator, boolean autoHideLoading) {
        this.viewLocator = viewLocator;
        this.autoHideLoading = autoHideLoading;
    }

    @Override
    public void onSuccess(S result) {
        V view = viewLocator.getView();
        if (view != null) {
            if(autoHideLoading){
                view.hideLoading();
            }
            onSuccess(view, result);
        }
    }

    protected abstract void onSuccess(@NonNull V view, S result);

    @Override
    public void onError(Throwable t) {
        V view = viewLocator.getView();
        if (view != null) {
            onError(view, t);
        }
    }

    protected void onError(@NonNull V view, Throwable t) {
        //do base stuff on error cause View contains error traits
        view.showGenericError(t.getMessage());
    }
}
