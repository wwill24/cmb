package com.google.android.gms.common;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.c;
import com.google.android.gms.common.internal.p;

public class h extends c {

    /* renamed from: a  reason: collision with root package name */
    private Dialog f38899a;

    /* renamed from: b  reason: collision with root package name */
    private DialogInterface.OnCancelListener f38900b;

    /* renamed from: c  reason: collision with root package name */
    private Dialog f38901c;

    @NonNull
    public static h z0(@NonNull Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        h hVar = new h();
        Dialog dialog2 = (Dialog) p.l(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener((DialogInterface.OnCancelListener) null);
        dialog2.setOnDismissListener((DialogInterface.OnDismissListener) null);
        hVar.f38899a = dialog2;
        if (onCancelListener != null) {
            hVar.f38900b = onCancelListener;
        }
        return hVar;
    }

    public void onCancel(@NonNull DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f38900b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.f38899a;
        if (dialog != null) {
            return dialog;
        }
        setShowsDialog(false);
        if (this.f38901c == null) {
            this.f38901c = new AlertDialog.Builder((Context) p.k(getContext())).create();
        }
        return this.f38901c;
    }

    public void show(@NonNull FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
