package cat.devsofthecoast.artporfolio.common.screens.navigators;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import cat.devsofthecoast.artporfolio.common.screens.dialogs.genericerror.GenericErrorDialog;
import cat.devsofthecoast.artporfolio.common.screens.dialogs.loading.LoadingDialog;

public class DialogsNavigator {

    public static final String LOADING_FRAGMENT = "Loading Fragment";
    private final FragmentManager fragmentManager;

    public DialogsNavigator(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public void showGenericErrorDialog(@Nullable String errorMessage) {
        fragmentManager.beginTransaction()
                .add(GenericErrorDialog.newInstance(errorMessage), null)
                .commitAllowingStateLoss();
    }

    public void showLoading(@Nullable String loadingMessage) {
        fragmentManager.beginTransaction()
                .add(LoadingDialog.newInstance(loadingMessage), LOADING_FRAGMENT)
                .commitAllowingStateLoss();
    }

    public void hideLoading() {
        final Fragment loadingFragment = getLoadingFragment();
        if (loadingFragment != null) {
            fragmentManager.beginTransaction()
                    .remove(loadingFragment)
                    .commitNowAllowingStateLoss();
        }
    }

    public boolean isLoadingShown() {
        return getLoadingFragment() != null;
    }

    private Fragment getLoadingFragment() {
        Fragment loadingFragment = null;
        for (Fragment fragment : fragmentManager.getFragments()) {
            if (LOADING_FRAGMENT.equals(fragment.getTag())) {
                loadingFragment = fragment;
            }
        }
        return loadingFragment;
    }
}
