package cat.devsofthecoast.artporfolio.common.screens.dialogs;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;

public class ErrorHandling {

    public void showNoConnectionError(FragmentManager fm) {
        NoConnectionDialogFragment.newInstance().show(fm, null);
    }

    public void showGenericError(FragmentManager fm, @Nullable String errorMessage) {
        GenericErrorDialogFragment.newInstance(errorMessage).show(fm, null);
    }
}
