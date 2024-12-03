package com.google.android.gms.cloudmessaging;

import android.os.Bundle;

final class r extends s<Void> {
    r(int i10, int i11, Bundle bundle) {
        super(i10, 2, bundle);
    }

    /* access modifiers changed from: package-private */
    public final void a(Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            d(null);
        } else {
            c(new zzq(4, "Invalid response to one way request", (Throwable) null));
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean b() {
        return true;
    }
}
