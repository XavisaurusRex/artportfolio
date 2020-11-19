package cat.devsofthecoast.artporfolio.common.screens.screensnavigator;
import cat.devsofthecoast.artporfolio.artworks.ArtworkDetailFragment;
import cat.devsofthecoast.artporfolio.artworks.ArtworksFragment;
import cat.devsofthecoast.artporfolio.artworks.model.api.ApiArtwork;
import cat.devsofthecoast.artporfolio.common.screens.fragmentframehelper.FragmentFrameHelper;

public class ScreensNavigator {

    private FragmentFrameHelper mFragmentFrameHelper;

    public ScreensNavigator(FragmentFrameHelper mFragmentFrameHelper) {
        this.mFragmentFrameHelper = mFragmentFrameHelper;
    }

    public void toArtworkList() {
        mFragmentFrameHelper.replaceFragmentAndClearBackstack(ArtworksFragment.newInstance());
    }

    public void toArtworkDetail(ApiArtwork artwork) {
        mFragmentFrameHelper.replaceFragment(ArtworkDetailFragment.newInstance(artwork));
    }

    public void navigateUp() {
        mFragmentFrameHelper.navigateUp();
    }
}
