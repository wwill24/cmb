package com.withpersona.sdk2.inquiry.launchers;

import android.net.Uri;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.c;
import kotlinx.coroutines.flow.h;
import kotlinx.coroutines.flow.l;

public final class m implements l<Uri> {

    /* renamed from: b  reason: collision with root package name */
    public static final a f26958b = new a((DefaultConstructorMarker) null);

    /* renamed from: c  reason: collision with root package name */
    private static final h<Uri> f26959c = kotlinx.coroutines.flow.m.b(0, 1, BufferOverflow.DROP_OLDEST, 1, (Object) null);

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ h<Uri> f26960a = f26959c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Object a(c<? super Uri> cVar, kotlin.coroutines.c<?> cVar2) {
        return this.f26960a.a(cVar, cVar2);
    }

    public final boolean b(Uri uri) {
        return f26959c.e(uri);
    }
}
