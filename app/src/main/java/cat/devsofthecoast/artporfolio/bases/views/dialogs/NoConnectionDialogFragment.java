package cat.devsofthecoast.artporfolio.bases.views.dialogs;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import cat.devsofthecoast.artporfolio.R;

public class NoConnectionDialogFragment extends DialogFragment {

    public static NoConnectionDialogFragment newInstance() {
        return new NoConnectionDialogFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialogfragment_no_connection_error, container, false);
    }
}
