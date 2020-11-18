package cat.devsofthecoast.artporfolio.bases.views.activity;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.CallSuper;
import androidx.appcompat.app.AppCompatActivity;

import cat.devsofthecoast.artporfolio.dependencyinjection.ArtApplication;
import cat.devsofthecoast.artporfolio.dependencyinjection.activity.ActivityModule;
import cat.devsofthecoast.artporfolio.dependencyinjection.presentantion.PresentationComponent;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    @CallSuper
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDagger();
    }

    private void initDagger() {
        injectView(((ArtApplication) getApplication()).getAppComponent().newActivityComponent(new ActivityModule(this)).newPresentationComponent());
    }

    protected void injectView(PresentationComponent injector) {
        // no op
    }


}
