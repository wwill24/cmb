package com.clevertap.android.sdk.inapp;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import i4.x;

public abstract class e extends a {
    /* access modifiers changed from: package-private */
    public void E0() {
        CleverTapInstanceConfig cleverTapInstanceConfig = this.f10382b;
        if (cleverTapInstanceConfig != null) {
            I0(CleverTapAPI.F(this.f10383c, cleverTapInstanceConfig).s().h());
        }
    }

    public void onDestroy() {
        super.onDestroy();
        B0((Bundle) null);
    }

    public void onPause() {
        super.onPause();
    }

    public void onStart() {
        super.onStart();
        if (this.f10386f.get()) {
            z0();
        }
    }

    /* access modifiers changed from: package-private */
    public void z0() {
        FragmentManager fragmentManager;
        if (!x.t(getActivity()) && !this.f10386f.get() && (fragmentManager = getFragmentManager()) != null) {
            try {
                fragmentManager.p().r(this).i();
            } catch (IllegalStateException unused) {
                fragmentManager.p().r(this).j();
            }
        }
        this.f10386f.set(true);
    }
}
