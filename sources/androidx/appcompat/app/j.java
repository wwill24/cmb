package androidx.appcompat.app;

import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.c;

public class j extends c {
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        return new i(getContext(), getTheme());
    }

    public void setupDialog(@NonNull Dialog dialog, int i10) {
        if (dialog instanceof i) {
            i iVar = (i) dialog;
            if (!(i10 == 1 || i10 == 2)) {
                if (i10 == 3) {
                    dialog.getWindow().addFlags(24);
                } else {
                    return;
                }
            }
            iVar.h(1);
            return;
        }
        super.setupDialog(dialog, i10);
    }
}
