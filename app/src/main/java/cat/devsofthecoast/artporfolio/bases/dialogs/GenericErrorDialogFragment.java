package cat.devsofthecoast.artporfolio.bases.dialogs;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import cat.devsofthecoast.artporfolio.R;

public class GenericErrorDialogFragment extends DialogFragment {

    public static final String EXTRA_ERROR_MESSAGE = "errorMessage";
    private TextView tvMainContent;

    public static GenericErrorDialogFragment newInstance(@Nullable String errorMessage) {
        return new GenericErrorDialogFragment(errorMessage);
    }

    private GenericErrorDialogFragment(String errorMessage) {
        Bundle args = new Bundle();
        args.putString(EXTRA_ERROR_MESSAGE, errorMessage);
        setArguments(args);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialogfragment_generic_error, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvMainContent = view.findViewById(R.id.tvMainContent);
        configureTitle();
    }

    private void configureTitle() {
        final String errorDescription = getErrorDescriptionFromExtras();
        if (errorDescription != null){
            tvMainContent.setText(errorDescription);
        }
    }

    @Nullable
    private String getErrorDescriptionFromExtras() {
        return getArguments() != null ? getArguments().getString(EXTRA_ERROR_MESSAGE) : null;
    }

}
