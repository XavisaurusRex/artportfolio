package cat.devsofthecoast.artporfolio.artworks.view;

import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import cat.devsofthecoast.artporfolio.R;
import cat.devsofthecoast.artporfolio.artworks.presenter.ArtworksPresenter;
import cat.devsofthecoast.artporfolio.bases.activity.BaseActivity;
import cat.devsofthecoast.artporfolio.dagger.ArtComponent;
import cat.devsofthecoast.artporfolio.utils.StringUtils;

public class ArtworksActivity extends BaseActivity<ArtworksPresenter> implements ArtworksPresenter.View {

    @Inject StringUtils stringUtils;
    @Inject ArtworksPresenter presenter;

    private TextView tvMainContent;
    private TextView btnConnectionError;
    private TextView btnGenericError;
    private View vLoading;


    @Override
    protected void injectView(ArtComponent artComponent) {
        artComponent.inject(this);
    }

    @Override
    protected void initPresenter() {
        presenter.setView(this);
//        this.setPresenter ?? PORQUE
    }

    @Override
    protected int getContentLayout() {
        return R.layout.activity_artworks;
    }

    @Override
    protected void bindViews() {
        tvMainContent = findViewById(R.id.tvMainContent);
        btnConnectionError = findViewById(R.id.btnConnectionError);
        btnGenericError = findViewById(R.id.btnGenericError);
        vLoading = findViewById(R.id.vLoading);
    }

    @Override
    protected void initViews() {
        tvMainContent.setText(stringUtils.insultMe());
        btnConnectionError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNoConnectionError();
            }
        });
        btnConnectionError.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                presenter.requestSomeShit();
                return false;
            }
        });
        btnGenericError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showGenericError(stringUtils.insultMe());
            }
        });
        btnGenericError.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                showGenericError(null);
                return false;
            }
        });
    }

    @Override
    public void showLoading() {
        vLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                vLoading.setVisibility(View.GONE);
            }
        });
    }
}