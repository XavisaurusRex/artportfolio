package cat.devsofthecoast.artporfolio.common.screens.dialogs.genericerror.view;
import androidx.annotation.Nullable;

import cat.devsofthecoast.artporfolio.common.screens.views.mvc.ObservableViewMvc;

public interface GenericErrorViewMvc extends ObservableViewMvc<GenericErrorViewMvc.Listener> {

    interface Listener {

        void onOkButtonClicked();

    }


    void bindErrorMessage(@Nullable String errorMessage);

}
