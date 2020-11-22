package cat.devsofthecoast.artporfolio.common.screens.toolbar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import cat.devsofthecoast.artporfolio.R;
import cat.devsofthecoast.artporfolio.common.screens.views.mvc.impl.BaseViewMvc;


public class ToolbarViewMvc extends BaseViewMvc {

    public interface NavigateUpClickListener {
        void onNavigateUpClicked();
    }

    public interface HamburgerClickListener {
        void onHamburgerClicked();
    }

    public interface LocationRequestListener {
        void onLocationRequestClicked();
    }

    private final TextView mTxtTitle;
    private final ImageButton mBtnBack;
    private final ImageButton mBtnHamburger;
    private final ImageButton mBtnLocationRequest;

    private NavigateUpClickListener mNavigateUpClickListener;
    private HamburgerClickListener mHamburgerClickListener;
    private LocationRequestListener mLocationRequestListener;

    public ToolbarViewMvc(LayoutInflater inflater, ViewGroup parent) {
        setRootView(inflater.inflate(R.layout.layout_toolbar, parent, false));
        mTxtTitle = findViewById(R.id.txt_toolbar_title);
        mBtnHamburger = findViewById(R.id.btn_hamburger);
        mBtnHamburger.setOnClickListener(view -> mHamburgerClickListener.onHamburgerClicked());
        mBtnBack = findViewById(R.id.btn_back);
        mBtnBack.setOnClickListener(view -> mNavigateUpClickListener.onNavigateUpClicked());
        mBtnLocationRequest = findViewById(R.id.btn_location);
        mBtnLocationRequest.setOnClickListener(view -> mLocationRequestListener.onLocationRequestClicked());
    }

    public void setTitle(String title) {
        mTxtTitle.setText(title);
    }

    public void enableHamburgerButtonAndListen(HamburgerClickListener hamburgerClickListener) {
        if (mNavigateUpClickListener != null) {
            throw new RuntimeException("hamburger and up shouldn't be shown together");
        }
        mHamburgerClickListener = hamburgerClickListener;
        mBtnHamburger.setVisibility(View.VISIBLE);
    }

    public void enableUpButtonAndListen(NavigateUpClickListener navigateUpClickListener) {
        if (mHamburgerClickListener != null) {
            throw new RuntimeException("hamburger and up shouldn't be shown together");
        }
        mNavigateUpClickListener = navigateUpClickListener;
        mBtnBack.setVisibility(View.VISIBLE);
    }

    public void enableLocationRequestButtonAndListen(LocationRequestListener locationRequestListener) {
        mLocationRequestListener = locationRequestListener;
        mBtnLocationRequest.setVisibility(View.VISIBLE);
    }

}
