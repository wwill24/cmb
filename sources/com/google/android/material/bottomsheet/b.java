package com.google.android.material.bottomsheet;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.app.j;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class b extends j {

    /* renamed from: a  reason: collision with root package name */
    private boolean f19324a;

    /* renamed from: com.google.android.material.bottomsheet.b$b  reason: collision with other inner class name */
    private class C0233b extends BottomSheetBehavior.f {
        private C0233b() {
        }

        public void b(@NonNull View view, float f10) {
        }

        public void c(@NonNull View view, int i10) {
            if (i10 == 5) {
                b.this.A0();
            }
        }
    }

    /* access modifiers changed from: private */
    public void A0() {
        if (this.f19324a) {
            super.dismissAllowingStateLoss();
        } else {
            super.dismiss();
        }
    }

    private void B0(@NonNull BottomSheetBehavior<?> bottomSheetBehavior, boolean z10) {
        this.f19324a = z10;
        if (bottomSheetBehavior.p0() == 5) {
            A0();
            return;
        }
        if (getDialog() instanceof a) {
            ((a) getDialog()).p();
        }
        bottomSheetBehavior.Y(new C0233b());
        bottomSheetBehavior.Q0(5);
    }

    private boolean C0(boolean z10) {
        Dialog dialog = getDialog();
        if (!(dialog instanceof a)) {
            return false;
        }
        a aVar = (a) dialog;
        BottomSheetBehavior<FrameLayout> n10 = aVar.n();
        if (!n10.u0() || !aVar.o()) {
            return false;
        }
        B0(n10, z10);
        return true;
    }

    public void dismiss() {
        if (!C0(false)) {
            super.dismiss();
        }
    }

    public void dismissAllowingStateLoss() {
        if (!C0(true)) {
            super.dismissAllowingStateLoss();
        }
    }

    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        return new a(getContext(), getTheme());
    }
}
