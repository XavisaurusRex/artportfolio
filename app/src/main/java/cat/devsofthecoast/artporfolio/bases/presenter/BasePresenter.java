package cat.devsofthecoast.artporfolio.bases.presenter;
import cat.devsofthecoast.artporfolio.bases.ErrorTrait;
import cat.devsofthecoast.artporfolio.bases.LoadingTrait;

public interface BasePresenter<T extends BasePresenter.BaseView> {

    void setView(T view);

    T getView();

    interface BaseView extends ErrorTrait, LoadingTrait {
    }
}
