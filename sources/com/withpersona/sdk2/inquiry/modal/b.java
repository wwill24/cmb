package com.withpersona.sdk2.inquiry.modal;

import com.squareup.workflow1.ui.modal.d;
import java.util.List;
import kotlin.jvm.internal.j;

public final class b<B, T> implements d<B, di.b<T>>, com.squareup.workflow1.ui.d {

    /* renamed from: b  reason: collision with root package name */
    private final B f27007b;

    /* renamed from: c  reason: collision with root package name */
    private final List<di.b<T>> f27008c;

    /* renamed from: d  reason: collision with root package name */
    private final String f27009d;

    /* renamed from: e  reason: collision with root package name */
    private final B f27010e;

    public b(B b10, List<di.b<T>> list, String str) {
        j.g(b10, "baseScreen");
        j.g(list, "modals");
        j.g(str, "compatibilityKey");
        this.f27007b = b10;
        this.f27008c = list;
        this.f27009d = str;
        this.f27010e = b10;
    }

    public List<di.b<T>> a() {
        return this.f27008c;
    }

    public B b() {
        return this.f27010e;
    }

    public String c() {
        return this.f27009d;
    }
}
