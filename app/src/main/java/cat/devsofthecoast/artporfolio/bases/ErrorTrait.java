package cat.devsofthecoast.artporfolio.bases;
import androidx.annotation.Nullable;

public interface ErrorTrait {

    void showGenericError(@Nullable String errorMessage);

    void showNoConnectionError();

}
