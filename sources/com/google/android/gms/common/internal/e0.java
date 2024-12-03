package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.api.internal.j;

public abstract class e0 implements DialogInterface.OnClickListener {
    public static e0 b(Activity activity, Intent intent, int i10) {
        return new b0(intent, activity, i10);
    }

    public static e0 c(@NonNull Fragment fragment, Intent intent, int i10) {
        return new c0(intent, fragment, i10);
    }

    public static e0 d(@NonNull j jVar, Intent intent, int i10) {
        return new d0(intent, jVar, 2);
    }

    /* access modifiers changed from: protected */
    public abstract void a();

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0007, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
        android.os.Build.FINGERPRINT.contains("generic");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
        r2.dismiss();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0009 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.content.DialogInterface r2, int r3) {
        /*
            r1 = this;
            r1.a()     // Catch:{ ActivityNotFoundException -> 0x0009 }
            r2.dismiss()
            return
        L_0x0007:
            r3 = move-exception
            goto L_0x0014
        L_0x0009:
            java.lang.String r3 = android.os.Build.FINGERPRINT     // Catch:{ all -> 0x0007 }
            java.lang.String r0 = "generic"
            r3.contains(r0)     // Catch:{ all -> 0x0007 }
            r2.dismiss()
            return
        L_0x0014:
            r2.dismiss()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.e0.onClick(android.content.DialogInterface, int):void");
    }
}
