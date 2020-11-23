package cat.devsofthecoast.artporfolio.common.screens.dialogs.loading.view;
import androidx.annotation.Nullable;

import cat.devsofthecoast.artporfolio.common.screens.views.mvc.ViewMvc;

public interface LoadingDialogViewMvc extends ViewMvc {

    void bindLoadingMessage(@Nullable String loadingMessage);
}
