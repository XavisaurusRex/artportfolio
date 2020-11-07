package cat.devsofthecoast.artporfolio.bases.activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import javax.inject.Inject;

import cat.devsofthecoast.artporfolio.bases.ErrorTrait;
import cat.devsofthecoast.artporfolio.bases.dialogs.ErrorHandling;
import cat.devsofthecoast.artporfolio.bases.presenter.BasePresenter;
import cat.devsofthecoast.artporfolio.dagger.ArtApplication;
import cat.devsofthecoast.artporfolio.dagger.ArtComponent;

@SuppressWarnings("rawtypes")
public abstract class BasePresenterActivity<P extends BasePresenter<? extends BasePresenter.BaseView>> extends AppCompatActivity implements BasePresenter.BaseView, ErrorTrait {

    @Inject ErrorHandling errorHandler;
    private P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentLayout());
        initDagger();
        bindViews();
        initViews();
        initPresenter();
        fetchData();
    }

    protected void initDagger() {
        injectView(((ArtApplication) getApplication()).getArtComponent());
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.destroy();
    }

    protected abstract int getContentLayout();

    protected abstract void bindViews();

    protected abstract void initViews();

    protected abstract void injectView(ArtComponent artComponent);

    protected void initPresenter() {
        // no op
    }

    protected void fetchData() {
        // no op
    }

    @Override
    public void showGenericError(@Nullable String errorMessage) {
        errorHandler.showGenericError(getSupportFragmentManager(), errorMessage);
    }

    @Override
    public void showNoConnectionError() {
        errorHandler.showNoConnectionError(getSupportFragmentManager());
    }

    protected void setPresenter(P presenter) {
        this.presenter = presenter;
    }
}
