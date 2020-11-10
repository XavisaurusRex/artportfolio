package cat.devsofthecoast.artporfolio.artworks.presenter;
import cat.devsofthecoast.artporfolio.artworks.model.api.ApiArtwork;
import cat.devsofthecoast.artporfolio.bases.presenter.BasePresenter;


public interface ArtworksPresenter extends BasePresenter<ArtworksPresenter.View> {

    void requestFilterByName(String nameToFilter);

    interface View extends BasePresenter.BaseView {

        void requestSomeShitSuccess(ApiArtwork result);

    }
}
