package cat.devsofthecoast.artporfolio.bases.views.activity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import cat.devsofthecoast.artporfolio.dependencyinjection.ArtApplication;
import cat.devsofthecoast.artporfolio.dependencyinjection.activity.ActivityComponent;
import cat.devsofthecoast.artporfolio.dependencyinjection.activity.ActivityModule;
import cat.devsofthecoast.artporfolio.dependencyinjection.presentantion.PresentationComponent;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentLayout());
        initDagger();
        bindViews();
        initViews();
        fetchData();
    }

    private void initDagger() {
        injectView(((ArtApplication) getApplication()).getAppComponent().newActivityComponent(new ActivityModule(this)).newPresentationComponent());
    }

    protected abstract int getContentLayout();

    protected abstract void bindViews();

    protected abstract void initViews();

    protected void injectView(PresentationComponent injector) {
        // no op
    }

    protected void fetchData() {
        // no op
    }

}
