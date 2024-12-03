package com.google.android.gms.common;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;

public class b extends DialogFragment {

    /* renamed from: a  reason: collision with root package name */
    private Dialog f38862a;

    /* renamed from: b  reason: collision with root package name */
    private DialogInterface.OnCancelListener f38863b;

    /* renamed from: c  reason: collision with root package name */
    private Dialog f38864c;

    @NonNull
    public static b a(@NonNull Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        b bVar = new b();
        Dialog dialog2 = (Dialog) p.l(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener((DialogInterface.OnCancelListener) null);
        dialog2.setOnDismissListener((DialogInterface.OnDismissListener) null);
        bVar.f38862a = dialog2;
        if (onCancelListener != null) {
            bVar.f38863b = onCancelListener;
        }
        return bVar;
    }

    public void onCancel(@NonNull DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f38863b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.f38862a;
        if (dialog != null) {
            return dialog;
        }
        setShowsDialog(false);
        if (this.f38864c == null) {
            this.f38864c = new AlertDialog.Builder((Context) p.k(getActivity())).create();
        }
        return this.f38864c;
    }

    public void show(@NonNull FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
