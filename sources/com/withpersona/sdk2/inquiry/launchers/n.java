package com.withpersona.sdk2.inquiry.launchers;

import android.net.Uri;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.c;
import kotlinx.coroutines.flow.h;
import kotlinx.coroutines.flow.l;
import kotlinx.coroutines.flow.m;

public final class n implements l<List<? extends Uri>> {

    /* renamed from: b  reason: collision with root package name */
    public static final a f26961b = new a((DefaultConstructorMarker) null);

    /* renamed from: c  reason: collision with root package name */
    private static final h<List<Uri>> f26962c = m.b(0, 1, BufferOverflow.DROP_OLDEST, 1, (Object) null);

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ h<List<Uri>> f26963a = f26962c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Object a(c<? super List<? extends Uri>> cVar, kotlin.coroutines.c<?> cVar2) {
        return this.f26963a.a(cVar, cVar2);
    }

    public final boolean b(List<Uri> list) {
        j.g(list, "uri");
        return f26962c.e(list);
    }
}
