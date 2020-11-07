package cat.devsofthecoast.artporfolio.artworks.presenter.impl;
import androidx.annotation.NonNull;

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
    public void requestSomeShit(String nameToFilter) {
        getView().showLoading();
        requestArtworksUseCase.buildExecutor(createRequestArtworksObserver()).execute(nameToFilter);
    }

    private UseCaseCallback<String> createRequestArtworksObserver() {
        return new ComplexUseCaseCallback<ArtworksPresenter, View, String>(this) {
            @Override
            protected void onSuccess(@NonNull View view, String result) {
                view.requestSomeShitSuccess(result);
            }
        };
    }
}
