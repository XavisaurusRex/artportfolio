package cat.devsofthecoast.artporfolio.bases.models.usecases.callback;
import androidx.annotation.NonNull;

import cat.devsofthecoast.artporfolio.bases.presenter.BasePresenter;

public abstract class ComplexUseCaseCallback<P extends BasePresenter<V>, V extends BasePresenter.BaseView, R> implements UseCaseCallback<R> {

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
    public void onSuccess(R result) {
        V view = viewLocator.getView();
        if (view != null) {
            if (autoHideLoading) {
                view.hideLoading();
            }
            onSuccess(view, result);
        }
    }

    protected abstract void onSuccess(@NonNull V view, R result);

    @Override
    public void onError(Throwable t) {
        V view = viewLocator.getView();
        if (view != null) {
            onError(view, t);
        }
    }

    protected void onError(@NonNull V view, Throwable t) {
        //TODO: do base stuff on error cause View contains error traits
        if (autoHideLoading) {
            view.hideLoading();
        }
        view.showGenericError(t.getMessage());
    }
}
