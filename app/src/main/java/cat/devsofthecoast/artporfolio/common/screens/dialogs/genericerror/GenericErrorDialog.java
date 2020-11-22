package cat.devsofthecoast.artporfolio.common.screens.dialogs.genericerror;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import javax.inject.Inject;

import cat.devsofthecoast.artporfolio.common.dependencyinjection.presentantion.PresentationComponent;
import cat.devsofthecoast.artporfolio.common.screens.dialogs.bases.BaseDialog;
import cat.devsofthecoast.artporfolio.common.screens.dialogs.genericerror.view.GenericErrorViewMvc;
import cat.devsofthecoast.artporfolio.common.screens.views.ViewMvcFactory;

public class GenericErrorDialog extends BaseDialog implements GenericErrorViewMvc.Listener {

    public static final String EXTRA_ERROR_MESSAGE = "errorMessage";

    @Inject ViewMvcFactory viewMvcFactory;

    private GenericErrorViewMvc viewMvc;

    public static GenericErrorDialog newInstance(String errorMessage) {
        Bundle args = new Bundle();
        args.putString(EXTRA_ERROR_MESSAGE, errorMessage);
        GenericErrorDialog fragment = new GenericErrorDialog();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void injectView(PresentationComponent injector) {
        injector.inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewMvc = viewMvcFactory.newGenericErrorViewMvc(container);
        viewMvc.bindErrorMessage(getErrorDescriptionFromExtras());
        return viewMvc.getRootView();
    }

    @Override
    public void onStart() {
        super.onStart();
        viewMvc.registerListener(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        viewMvc.unregisterListener(this);
    }

    @Nullable
    private String getErrorDescriptionFromExtras() {
        return getArguments() != null ? getArguments().getString(EXTRA_ERROR_MESSAGE) : null;
    }

    @Override
    public void onOkButtonClicked() {
        dismiss();
    }
}
