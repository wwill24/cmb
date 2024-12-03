package com.withpersona.sdk2.inquiry.internal;

import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.internal.network.p;
import com.withpersona.sdk2.inquiry.network.InternalErrorInfo;
import kotlin.coroutines.c;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.o2;
import kotlinx.coroutines.s1;
import kotlinx.coroutines.x0;

public final class ErrorReportingManager {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final p f26081a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final s f26082b;

    /* renamed from: c  reason: collision with root package name */
    private final k0 f26083c = l0.a(x0.a().e0(o2.b((s1) null, 1, (Object) null)));

    public ErrorReportingManager(p pVar, s sVar) {
        j.g(pVar, "inquiryService");
        j.g(sVar, "moshi");
        this.f26081a = pVar;
        this.f26082b = sVar;
    }

    public final s1 c(String str, InternalErrorInfo internalErrorInfo) {
        j.g(str, "sessionToken");
        j.g(internalErrorInfo, "errorInfo");
        return j.d(this.f26083c, x0.b(), (CoroutineStart) null, new ErrorReportingManager$reportError$1(this, str, internalErrorInfo, (c<? super ErrorReportingManager$reportError$1>) null), 2, (Object) null);
    }

    public final s1 d(String str) {
        j.g(str, "sessionToken");
        return j.d(this.f26083c, x0.b(), (CoroutineStart) null, new ErrorReportingManager$reportSessionCancelled$1(this, str, (c<? super ErrorReportingManager$reportSessionCancelled$1>) null), 2, (Object) null);
    }
}
