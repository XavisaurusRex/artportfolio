package cat.devsofthecoast.artporfolio.artworks.presenter.impl;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import cat.devsofthecoast.artporfolio.artworks.model.api.ApiArtworksRoot;
import cat.devsofthecoast.artporfolio.artworks.presenter.ArtworksPresenter;
import cat.devsofthecoast.artporfolio.artworks.model.usecase.RequestArtworksUseCase;
import cat.devsofthecoast.artporfolio.bases.presenter.impl.BasePresenterImpl;
import cat.devsofthecoast.artporfolio.bases.models.usecases.callback.ComplexUseCaseCallback;
import cat.devsofthecoast.artporfolio.bases.models.usecases.callback.UseCaseCallback;

public class ArtworksPresenterImpl extends BasePresenterImpl<ArtworksPresenter.View> implements ArtworksPresenter {

    private final RequestArtworksUseCase requestArtworksUseCase;
    private UseCaseCallback<ApiArtworksRoot> requestArtworksObserver;

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
    public void requestFilterByName(@Nullable final String nameToFilter) {
        getView().showLoading();
        requestArtworksUseCase.buildExecutor(requestArtworksObserver).execute(nameToFilter);
    }

    private UseCaseCallback<ApiArtworksRoot> createRequestArtworksObserver() {
        return new ComplexUseCaseCallback<ArtworksPresenter, View, ApiArtworksRoot>(this) {
            @Override
            protected void onSuccess(@NonNull View view, @Nullable ApiArtworksRoot result) {
                view.requestSomeShitSuccess(result);
            }
        };
    }
}
