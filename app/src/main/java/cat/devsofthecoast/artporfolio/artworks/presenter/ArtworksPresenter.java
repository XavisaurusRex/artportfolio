package cat.devsofthecoast.artporfolio.artworks.presenter;
import cat.devsofthecoast.artporfolio.artworks.models.api.ArtworkApi;
import cat.devsofthecoast.artporfolio.bases.presenter.BasePresenter;


public interface ArtworksPresenter extends BasePresenter<ArtworksPresenter.View> {

    void requestSomeShit(String nameToShittyRequest);

    interface View extends BasePresenter.BaseView {

        void requestSomeShitSuccess(String result);

        void requestSomeShitFail(String errorMessage);

    }
}
