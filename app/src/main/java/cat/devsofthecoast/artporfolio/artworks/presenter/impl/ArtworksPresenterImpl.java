package cat.devsofthecoast.artporfolio.artworks.presenter.impl;
import android.os.HandlerThread;

import cat.devsofthecoast.artporfolio.artworks.presenter.ArtworksPresenter;
import cat.devsofthecoast.artporfolio.bases.presenter.impl.BasePresenterImpl;

public class ArtworksPresenterImpl extends BasePresenterImpl<ArtworksPresenter.View> implements ArtworksPresenter {

    public ArtworksPresenterImpl() {
    }

    @Override
    public void requestSomeShit() {
        getView().showLoading();
        new Thread(new Runnable() {
            public void run(){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                getView().hideLoading();
            }
        }).start();
    }
}
