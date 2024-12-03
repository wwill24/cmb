package com.google.android.datatransport.cct.internal;

import androidx.annotation.NonNull;
import com.google.android.datatransport.cct.internal.g;
import com.google.firebase.encoders.annotations.Encodable;
import java.util.List;

public abstract class k {

    public static abstract class a {
        @NonNull
        public abstract k a();

        @NonNull
        public abstract a b(ClientInfo clientInfo);

        @NonNull
        public abstract a c(List<j> list);

        /* access modifiers changed from: package-private */
        @NonNull
        public abstract a d(Integer num);

        /* access modifiers changed from: package-private */
        @NonNull
        public abstract a e(String str);

        @NonNull
        public abstract a f(QosTier qosTier);

        @NonNull
        public abstract a g(long j10);

        @NonNull
        public abstract a h(long j10);

        @NonNull
        public a i(int i10) {
            return d(Integer.valueOf(i10));
        }

        @NonNull
        public a j(@NonNull String str) {
            return e(str);
        }
    }

    @NonNull
    public static a a() {
        return new g.b();
    }

    public abstract ClientInfo b();

    @Encodable.Field(name = "logEvent")
    public abstract List<j> c();

    public abstract Integer d();

    public abstract String e();

    public abstract QosTier f();

    public abstract long g();

    public abstract long h();
}
