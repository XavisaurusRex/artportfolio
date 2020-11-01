package cat.devsofthecoast.artporfolio.artworks.presenter;
import cat.devsofthecoast.artporfolio.artworks.models.api.SomeShit;
import cat.devsofthecoast.artporfolio.bases.presenter.BasePresenter;


public interface ArtworksPresenter extends BasePresenter<ArtworksPresenter.View> {

    void requestSomeShit();

    interface View extends BasePresenter.BaseView {

        void requestSomeShitSuccess(SomeShit someShit);

    }
}
