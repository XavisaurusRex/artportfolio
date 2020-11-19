package cat.devsofthecoast.artporfolio.common.screens.controllers;
import android.os.Bundle;

import androidx.annotation.CallSuper;
import androidx.appcompat.app.AppCompatActivity;

import cat.devsofthecoast.artporfolio.common.dependencyinjection.ArtApplication;
import cat.devsofthecoast.artporfolio.common.dependencyinjection.activity.ActivityModule;
import cat.devsofthecoast.artporfolio.common.dependencyinjection.presentantion.PresentationComponent;

public abstract class BaseActivity extends AppCompatActivity {

    private PresentationComponent presentationComponent;

    @Override
    @CallSuper
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDagger();
    }

    private void initDagger() {
        injectView(((ArtApplication) getApplication()).
                getAppComponent()
                .newActivityComponent(new ActivityModule(this))
                .newPresentationComponent());
    }

    @CallSuper
    protected void injectView(PresentationComponent presentationComponent) {
        this.presentationComponent = presentationComponent;
    }

    public PresentationComponent getPresentationComponent() {
        return presentationComponent;
    }
}
