package cat.devsofthecoast.artporfolio.common.screens.dialogs.loading.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

import cat.devsofthecoast.artporfolio.R;
import cat.devsofthecoast.artporfolio.common.screens.views.mvc.impl.BaseViewMvc;

public class LoadingDialogViewMvcImpl extends BaseViewMvc implements LoadingDialogViewMvc {

    private final TextView tvLoadingMessage;


    public LoadingDialogViewMvcImpl(LayoutInflater inflater, ViewGroup parent) {
        setRootView(inflater.inflate(R.layout.dialogfragment_loading, parent));
        tvLoadingMessage = findViewById(R.id.tvLoadingMessage);
    }


    @Override
    public void bindLoadingMessage(@Nullable String loadingMessage) {
        tvLoadingMessage.setText(!TextUtils.isEmpty(loadingMessage) ? loadingMessage: getString(R.string.loadingdialog_defaultmessage));
    }
}
