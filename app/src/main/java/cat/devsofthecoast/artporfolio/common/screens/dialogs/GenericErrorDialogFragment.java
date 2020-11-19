package cat.devsofthecoast.artporfolio.common.screens.dialogs;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.DialogFragment;

import cat.devsofthecoast.artporfolio.R;

// TODO: 10/11/2020 CANNOT SOLVE WHITE BACKGROUND WTF
public class GenericErrorDialogFragment extends DialogFragment {

    public static final String EXTRA_ERROR_MESSAGE = "errorMessage";
    private TextView tvMainContent;
    private AppCompatButton acbDismiss;

    public static GenericErrorDialogFragment newInstance(@Nullable String errorMessage) {
        return new GenericErrorDialogFragment(errorMessage);
    }

    public GenericErrorDialogFragment() { }

    private GenericErrorDialogFragment(String errorMessage) {
        Bundle args = new Bundle();
        args.putString(EXTRA_ERROR_MESSAGE, errorMessage);
        setArguments(args);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialogfragment_generic_error, container);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvMainContent = view.findViewById(R.id.tvMainContent);
        acbDismiss = view.findViewById(R.id.acbDismiss);
        configureTitle();
        configureListeners();
    }

    private void configureListeners() {
        acbDismiss.setOnClickListener(v -> dismiss());
    }

    private void configureTitle() {
        final String errorDescription = getErrorDescriptionFromExtras();
        if (errorDescription != null) {
            tvMainContent.setText(errorDescription);
        }
    }

    @Nullable
    private String getErrorDescriptionFromExtras() {
        return getArguments() != null ? getArguments().getString(EXTRA_ERROR_MESSAGE) : null;
    }

}
