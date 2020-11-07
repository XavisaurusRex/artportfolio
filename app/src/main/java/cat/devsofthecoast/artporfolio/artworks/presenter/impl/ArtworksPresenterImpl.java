package cat.devsofthecoast.artporfolio.artworks.presenter.impl;
import cat.devsofthecoast.artporfolio.artworks.presenter.ArtworksPresenter;
import cat.devsofthecoast.artporfolio.artworks.usecase.impl.RequestArtworksUseCase;
import cat.devsofthecoast.artporfolio.bases.presenter.impl.BasePresenterImpl;
import cat.devsofthecoast.artporfolio.bases.usecases.UseCaseCallback;

public class ArtworksPresenterImpl extends BasePresenterImpl<ArtworksPresenter.View> implements ArtworksPresenter {

    private final RequestArtworksUseCase requestArtworksUseCase;

    public ArtworksPresenterImpl(RequestArtworksUseCase requestArtworksUseCase) {
        this.requestArtworksUseCase = requestArtworksUseCase;
    }

    @Override
    public void requestSomeShit(String nameToShittyRequest) {
        getView().showLoading();
        requestArtworksUseCase.buildExecutor(createObserver()).execute(nameToShittyRequest);
    }

    private UseCaseCallback<String> createObserver() {
        return new UseCaseCallback<String>() {
            @Override
            public void onSuccess(String result) {
                getView().hideLoading();
                getView().requestSomeShitSuccess(result);
            }

            @Override
            public void onError(Throwable t) {
                getView().hideLoading();
                getView().requestSomeShitFail(t.getMessage());
            }
        };
    }
}
