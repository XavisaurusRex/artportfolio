package cat.devsofthecoast.artporfolio.common.screens.dialogs.bases;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import cat.devsofthecoast.artporfolio.common.dependencyinjection.presentantion.PresentationComponent;
import cat.devsofthecoast.artporfolio.common.screens.controllers.BaseActivity;

public abstract class BaseDialog extends DialogFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectView(((BaseActivity) requireActivity()).getPresentationComponent());
    }

    protected void injectView(PresentationComponent injector) {
        // no op
    }
}
