package com.withpersona.sdk2.inquiry.launchers;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.c;
import kotlinx.coroutines.flow.h;
import kotlinx.coroutines.flow.l;
import kotlinx.coroutines.flow.m;

public final class s implements l<Boolean> {

    /* renamed from: b  reason: collision with root package name */
    public static final a f26966b = new a((DefaultConstructorMarker) null);

    /* renamed from: c  reason: collision with root package name */
    private static final h<Boolean> f26967c = m.b(0, 1, BufferOverflow.DROP_OLDEST, 1, (Object) null);

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ h<Boolean> f26968a = f26967c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Object a(c<? super Boolean> cVar, kotlin.coroutines.c<?> cVar2) {
        return this.f26968a.a(cVar, cVar2);
    }

    public final boolean b(boolean z10) {
        return f26967c.e(Boolean.valueOf(z10));
    }
}
