package cat.devsofthecoast.artporfolio.common.screens.controllers;


import android.os.Bundle;

import androidx.annotation.CallSuper;
import androidx.fragment.app.Fragment;

import cat.devsofthecoast.artporfolio.common.dependencyinjection.presentantion.PresentationComponent;

public class BaseFragment extends Fragment {

    @Override
    @CallSuper
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDagger();
    }

    private void initDagger() {
        injectView(((BaseActivity) requireActivity()).getPresentationComponent());
    }

    protected void injectView(PresentationComponent injector) {
        // no op
    }

}
