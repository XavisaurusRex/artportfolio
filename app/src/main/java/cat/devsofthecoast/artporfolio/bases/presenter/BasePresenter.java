package cat.devsofthecoast.artporfolio.bases.presenter;
import cat.devsofthecoast.artporfolio.bases.ErrorTrait;
import cat.devsofthecoast.artporfolio.bases.LoadingTrait;

public interface BasePresenter<V extends BasePresenter.BaseView> {

    void setView(V view);

    V getView();

    interface BaseView extends ErrorTrait, LoadingTrait {
    }
}
