package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class LifecycleCallback {
    @NonNull
    protected final j mLifecycleFragment;

    protected LifecycleCallback(@NonNull j jVar) {
        this.mLifecycleFragment = jVar;
    }

    @Keep
    private static j getChimeraLifecycleFragmentImpl(i iVar) {
        throw new IllegalStateException("Method not available in SDK.");
    }

    @NonNull
    public static j getFragment(@NonNull Activity activity) {
        return getFragment(new i(activity));
    }

    public void dump(@NonNull String str, @NonNull FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @NonNull String[] strArr) {
    }

    @NonNull
    public Activity getActivity() {
        Activity g02 = this.mLifecycleFragment.g0();
        p.k(g02);
        return g02;
    }

    public void onActivityResult(int i10, int i11, @NonNull Intent intent) {
    }

    public void onCreate(Bundle bundle) {
    }

    public void onDestroy() {
    }

    public void onResume() {
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    @NonNull
    public static j getFragment(@NonNull ContextWrapper contextWrapper) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    protected static j getFragment(@NonNull i iVar) {
        if (iVar.d()) {
            return w3.B0(iVar.b());
        }
        if (iVar.c()) {
            return u3.c(iVar.a());
        }
        throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
    }
}
