package cat.devsofthecoast.artporfolio.bases.presenter;
import androidx.annotation.NonNull;

import cat.devsofthecoast.artporfolio.bases.ErrorTrait;
import cat.devsofthecoast.artporfolio.bases.LoadingTrait;

public interface BasePresenter<V extends BasePresenter.BaseView> {

    void setView(V view);

    V getView();


    void initUseCaseObservers(@NonNull V view);

    void destroy();

    void destroyUseCaseObservers();

    interface BaseView extends ErrorTrait, LoadingTrait {
    }
}
