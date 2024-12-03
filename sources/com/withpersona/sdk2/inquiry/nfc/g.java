package com.withpersona.sdk2.inquiry.nfc;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.c;
import kotlinx.coroutines.flow.h;
import kotlinx.coroutines.flow.l;
import kotlinx.coroutines.flow.m;

public final class g implements l<PassportNfcReaderOutput> {

    /* renamed from: b  reason: collision with root package name */
    public static final a f27074b = new a((DefaultConstructorMarker) null);

    /* renamed from: c  reason: collision with root package name */
    private static final h<PassportNfcReaderOutput> f27075c = m.b(0, 1, BufferOverflow.DROP_OLDEST, 1, (Object) null);

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ h<PassportNfcReaderOutput> f27076a = f27075c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Object a(c<? super PassportNfcReaderOutput> cVar, kotlin.coroutines.c<?> cVar2) {
        return this.f27076a.a(cVar, cVar2);
    }

    public final boolean b(PassportNfcReaderOutput passportNfcReaderOutput) {
        j.g(passportNfcReaderOutput, "output");
        return f27075c.e(passportNfcReaderOutput);
    }
}
