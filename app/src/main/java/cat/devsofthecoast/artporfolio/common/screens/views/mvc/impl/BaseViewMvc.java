package cat.devsofthecoast.artporfolio.common.screens.views.mvc.impl;
import android.content.Context;
import android.view.View;

import androidx.annotation.StringRes;

import cat.devsofthecoast.artporfolio.common.screens.views.mvc.ViewMvc;

public abstract class BaseViewMvc implements ViewMvc {

    private View rootView;

    @Override
    public View getRootView() {
        return rootView;
    }

    protected void setRootView(View rootView) {
        this.rootView = rootView;
    }

    protected <T extends View> T findViewById(int id) {
        return getRootView().findViewById(id);
    }

    protected Context getContext() {
        return getRootView().getContext();
    }

    protected String getString(@StringRes int id) {
        return getContext().getString(id);
    }
}
