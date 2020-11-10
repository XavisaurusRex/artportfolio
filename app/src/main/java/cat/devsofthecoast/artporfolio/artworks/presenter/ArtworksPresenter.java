package cat.devsofthecoast.artporfolio.artworks.presenter;
import androidx.annotation.Nullable;

import cat.devsofthecoast.artporfolio.artworks.model.api.ApiArtworksRoot;
import cat.devsofthecoast.artporfolio.bases.presenter.BasePresenter;


public interface ArtworksPresenter extends BasePresenter<ArtworksPresenter.View> {

    void requestFilterByName(@Nullable String nameToFilter);

    interface View extends BasePresenter.BaseView {

        void requestSomeShitSuccess(ApiArtworksRoot result);

    }
}
