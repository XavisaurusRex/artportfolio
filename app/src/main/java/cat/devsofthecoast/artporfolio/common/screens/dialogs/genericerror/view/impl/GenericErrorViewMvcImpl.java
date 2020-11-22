package cat.devsofthecoast.artporfolio.common.screens.dialogs.genericerror.view.impl;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

import cat.devsofthecoast.artporfolio.R;
import cat.devsofthecoast.artporfolio.common.screens.dialogs.genericerror.view.GenericErrorViewMvc;
import cat.devsofthecoast.artporfolio.common.screens.views.mvc.impl.BaseObservableViewMvc;

public class GenericErrorViewMvcImpl extends BaseObservableViewMvc<GenericErrorViewMvc.Listener> implements GenericErrorViewMvc {

    private final TextView tvErrorMessage;
    private final AppCompatButton btnReturn;

    public GenericErrorViewMvcImpl(LayoutInflater layoutInflater, ViewGroup parent) {
        setRootView(layoutInflater.inflate(R.layout.dialogfragment_generic_error, parent, false));
        tvErrorMessage = findViewById(R.id.tvErrorMessage);
        btnReturn = findViewById(R.id.btnReturn);
        configureListeners();
    }

    private void configureListeners() {
        btnReturn.setOnClickListener(v -> {
            for (Listener listener : getListeners()) {
                listener.onOkButtonClicked();
            }
        });
    }

    @Override
    public void bindErrorMessage(@Nullable String errorMessage) {
        tvErrorMessage.setText(errorMessage != null ? errorMessage : getString(R.string.artdialog_generic_error));
    }

}
