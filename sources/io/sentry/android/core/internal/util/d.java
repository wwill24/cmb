package io.sentry.android.core.internal.util;

import android.annotation.SuppressLint;
import android.content.ContentProvider;
import io.sentry.android.core.i0;
import io.sentry.i1;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final i0 f31022a;

    public d() {
        this(new i0(i1.e()));
    }

    @SuppressLint({"NewApi"})
    public void a(ContentProvider contentProvider) {
        int d10 = this.f31022a.d();
        if (d10 >= 26 && d10 <= 28) {
            String callingPackage = contentProvider.getCallingPackage();
            String packageName = contentProvider.getContext().getPackageName();
            if (callingPackage == null || !callingPackage.equals(packageName)) {
                throw new SecurityException("Provider does not allow for granting of Uri permissions");
            }
        }
    }

    public d(i0 i0Var) {
        this.f31022a = i0Var;
    }
}
