package cat.devsofthecoast.artporfolio.artworks.presenter.impl;
import androidx.annotation.NonNull;

import java.util.List;

import cat.devsofthecoast.artporfolio.artworks.model.api.ApiArtwork;
import cat.devsofthecoast.artporfolio.artworks.model.app.Artwork;
import cat.devsofthecoast.artporfolio.artworks.presenter.ArtworksPresenter;
import cat.devsofthecoast.artporfolio.artworks.model.usecase.RequestArtworksUseCase;
import cat.devsofthecoast.artporfolio.bases.presenter.impl.BasePresenterImpl;
import cat.devsofthecoast.artporfolio.bases.models.usecases.callback.ComplexUseCaseCallback;
import cat.devsofthecoast.artporfolio.bases.models.usecases.callback.UseCaseCallback;

public class ArtworksPresenterImpl extends BasePresenterImpl<ArtworksPresenter.View> implements ArtworksPresenter {

    private final RequestArtworksUseCase requestArtworksUseCase;
    private UseCaseCallback<ApiArtwork> requestArtworksObserver;

    public ArtworksPresenterImpl(RequestArtworksUseCase requestArtworksUseCase) {
        this.requestArtworksUseCase = requestArtworksUseCase;
    }

    @Override
    public void initUseCaseObservers(@NonNull View view) {
        requestArtworksObserver = createRequestArtworksObserver();
    }

    @Override
    public void destroyUseCaseObservers() {
        requestArtworksObserver = null;
    }

    @Override
    public void requestFilterByName(final String nameToFilter) {
        getView().showLoading();
        requestArtworksUseCase.buildExecutor(requestArtworksObserver).execute(nameToFilter);
    }

    private UseCaseCallback<ApiArtwork> createRequestArtworksObserver() {
        return new ComplexUseCaseCallback<ArtworksPresenter, View, ApiArtwork>(this) {
            @Override
            protected void onSuccess(@NonNull View view, ApiArtwork result) {
                view.requestSomeShitSuccess(result);
            }
        };
    }
}
