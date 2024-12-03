package o9;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import androidx.annotation.NonNull;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbTextView;

public class b extends Dialog {
    public b(@NonNull Context context, boolean z10, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z10, onCancelListener);
        if (getWindow() != null) {
            getWindow().requestFeature(1);
            getWindow().setBackgroundDrawableResource(17170445);
        }
        setContentView(R.layout.boosted_dialog);
        ((CmbTextView) findViewById(R.id.boosted_button)).setOnClickListener(new a(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        dismiss();
    }
}
