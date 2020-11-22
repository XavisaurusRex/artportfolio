package cat.devsofthecoast.artporfolio.common.screens.dialogs.loading;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import javax.inject.Inject;

import cat.devsofthecoast.artporfolio.common.dependencyinjection.presentantion.PresentationComponent;
import cat.devsofthecoast.artporfolio.common.screens.dialogs.bases.BaseDialog;
import cat.devsofthecoast.artporfolio.common.screens.dialogs.loading.view.LoadingDialogViewMvc;
import cat.devsofthecoast.artporfolio.common.screens.views.ViewMvcFactory;

public class LoadingDialog extends BaseDialog {

    public static final String ARGS_LOADING_MESSAGE = "loadingMessage";

    @Inject ViewMvcFactory viewMvcFactory;

    private LoadingDialogViewMvc viewMvc;

    public static LoadingDialog newInstance(@Nullable String loadingMessage) {
        Bundle args = new Bundle();
        args.putString(ARGS_LOADING_MESSAGE, loadingMessage);
        LoadingDialog fragment = new LoadingDialog();
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
        viewMvc = viewMvcFactory.newLoadingDialogViewMvc(container);
        viewMvc.bindLoadingMessage(getLoadingMessageFromArgs());
        return viewMvc.getRootView();
    }

    @Nullable
    public String getLoadingMessageFromArgs() {
        return getArguments() != null ? getArguments().getString(ARGS_LOADING_MESSAGE) : null;
    }
}
