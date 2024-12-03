package io.sentry.android.core;

import android.content.Context;
import io.sentry.android.core.internal.util.ConnectivityChecker;
import io.sentry.h0;
import io.sentry.transport.q;

final class c0 implements q {

    /* renamed from: a  reason: collision with root package name */
    private final Context f30949a;

    /* renamed from: b  reason: collision with root package name */
    private final h0 f30950b;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f30951a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                io.sentry.android.core.internal.util.ConnectivityChecker$Status[] r0 = io.sentry.android.core.internal.util.ConnectivityChecker.Status.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f30951a = r0
                io.sentry.android.core.internal.util.ConnectivityChecker$Status r1 = io.sentry.android.core.internal.util.ConnectivityChecker.Status.CONNECTED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f30951a     // Catch:{ NoSuchFieldError -> 0x001d }
                io.sentry.android.core.internal.util.ConnectivityChecker$Status r1 = io.sentry.android.core.internal.util.ConnectivityChecker.Status.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f30951a     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.sentry.android.core.internal.util.ConnectivityChecker$Status r1 = io.sentry.android.core.internal.util.ConnectivityChecker.Status.NO_PERMISSION     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.c0.a.<clinit>():void");
        }
    }

    c0(Context context, h0 h0Var) {
        this.f30949a = context;
        this.f30950b = h0Var;
    }

    /* access modifiers changed from: package-private */
    public boolean a(ConnectivityChecker.Status status) {
        int i10 = a.f30951a[status.ordinal()];
        return i10 == 1 || i10 == 2 || i10 == 3;
    }

    public boolean isConnected() {
        return a(ConnectivityChecker.b(this.f30949a, this.f30950b));
    }
}
