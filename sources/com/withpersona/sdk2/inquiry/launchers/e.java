package com.withpersona.sdk2.inquiry.launchers;

import android.net.Uri;
import c.d;
import c.k;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class e {
    public static final u<String[], List<Uri>> d() {
        return new u<>(new d(), new d());
    }

    /* access modifiers changed from: private */
    public static final void e(List list) {
        j.g(list, "uriList");
        new n().b(list);
    }

    public static final u<androidx.activity.result.e, List<Uri>> f() {
        return new u<>(new c.e(0, 1, (DefaultConstructorMarker) null), new b());
    }

    /* access modifiers changed from: private */
    public static final void g(List list) {
        j.g(list, "uriList");
        new n().b(list);
    }

    public static final u<Uri, Boolean> h() {
        return new u<>(new k(), new c());
    }

    /* access modifiers changed from: private */
    public static final void i(boolean z10) {
        new s().b(z10);
    }
}
