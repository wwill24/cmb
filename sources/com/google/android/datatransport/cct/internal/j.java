package com.google.android.datatransport.cct.internal;

import androidx.annotation.NonNull;
import com.google.android.datatransport.cct.internal.f;

public abstract class j {

    public static abstract class a {
        @NonNull
        public abstract j a();

        @NonNull
        public abstract a b(Integer num);

        @NonNull
        public abstract a c(long j10);

        @NonNull
        public abstract a d(long j10);

        @NonNull
        public abstract a e(NetworkConnectionInfo networkConnectionInfo);

        /* access modifiers changed from: package-private */
        @NonNull
        public abstract a f(byte[] bArr);

        /* access modifiers changed from: package-private */
        @NonNull
        public abstract a g(String str);

        @NonNull
        public abstract a h(long j10);
    }

    private static a a() {
        return new f.b();
    }

    @NonNull
    public static a i(@NonNull String str) {
        return a().g(str);
    }

    @NonNull
    public static a j(@NonNull byte[] bArr) {
        return a().f(bArr);
    }

    public abstract Integer b();

    public abstract long c();

    public abstract long d();

    public abstract NetworkConnectionInfo e();

    public abstract byte[] f();

    public abstract String g();

    public abstract long h();
}
