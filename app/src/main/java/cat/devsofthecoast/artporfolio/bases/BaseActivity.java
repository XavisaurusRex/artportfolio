package cat.devsofthecoast.artporfolio.bases;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import javax.inject.Inject;

import cat.devsofthecoast.artporfolio.bases.dialogs.ErrorHandling;
import cat.devsofthecoast.artporfolio.dagger.ArtApplication;
import cat.devsofthecoast.artporfolio.dagger.ArtComponent;

public abstract class BaseActivity extends AppCompatActivity implements ErrorTrait {

    @Inject ErrorHandling errorHandler;

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

    protected abstract int getContentLayout();

    protected abstract void bindViews();

    protected abstract void initViews();

    protected void initPresenter() {
        // no op
    }

    protected void fetchData() {
        // no op
    }

    protected void injectView(ArtComponent artComponent) {
        artComponent.inject(this);
    }

    @Override
    public void showGenericError(@Nullable String errorMessage) {
        errorHandler.showGenericError(getSupportFragmentManager(), errorMessage);
    }

    @Override
    public void showNoConnectionError() {
        errorHandler.showNoConnectionError(getSupportFragmentManager());
    }
}
