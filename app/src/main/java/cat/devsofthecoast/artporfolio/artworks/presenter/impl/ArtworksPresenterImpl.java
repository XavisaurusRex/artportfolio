package cat.devsofthecoast.artporfolio.artworks.presenter.impl;
import androidx.annotation.NonNull;

import cat.devsofthecoast.artporfolio.artworks.presenter.ArtworksPresenter;
import cat.devsofthecoast.artporfolio.artworks.usecase.impl.RequestArtworksUseCase;
import cat.devsofthecoast.artporfolio.bases.presenter.impl.BasePresenterImpl;
import cat.devsofthecoast.artporfolio.bases.usecases.UseCaseCallback;

public class ArtworksPresenterImpl extends BasePresenterImpl<ArtworksPresenter.View> implements ArtworksPresenter {

    private final RequestArtworksUseCase requestArtworksUseCase;
    private UseCaseCallback<String> requestArtworksObserver;

    public ArtworksPresenterImpl(RequestArtworksUseCase requestArtworksUseCase) {
        this.requestArtworksUseCase = requestArtworksUseCase;
    }

    @Override
    public void initUseCaseObservers(@NonNull View view) {
        // TODO: 07/11/2020 Why need to provide View into observer?
        requestArtworksObserver = createRequestArtworksObserver();
    }

    @Override
    public void destroyUseCaseObservers() {
        requestArtworksObserver = null;
    }

    @Override
    public void requestFilterByName(String nameToFilter) {
        getView().showLoading();
        requestArtworksUseCase.buildExecutor(requestArtworksObserver).execute(nameToFilter);
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
