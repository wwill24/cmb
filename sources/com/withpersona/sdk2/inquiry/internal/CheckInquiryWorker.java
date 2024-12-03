package com.withpersona.sdk2.inquiry.internal;

import com.squareup.workflow1.j;
import com.withpersona.sdk2.inquiry.internal.InquiryState;
import com.withpersona.sdk2.inquiry.internal.fallbackmode.RealFallbackModeManager;
import com.withpersona.sdk2.inquiry.internal.network.p;
import com.withpersona.sdk2.inquiry.network.InternalErrorInfo;
import com.withpersona.sdk2.inquiry.sandbox.SandboxFlags;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.d;
import org.apache.commons.beanutils.PropertyUtils;

public final class CheckInquiryWorker implements j<c> {

    /* renamed from: h  reason: collision with root package name */
    public static final a f26041h = new a((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private final String f26042b;

    /* renamed from: c  reason: collision with root package name */
    private final String f26043c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final p f26044d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final com.withpersona.sdk2.inquiry.shared.device.b f26045e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final SandboxFlags f26046f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final RealFallbackModeManager f26047g;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final p f26048a;

        /* renamed from: b  reason: collision with root package name */
        private final com.withpersona.sdk2.inquiry.shared.device.b f26049b;

        /* renamed from: c  reason: collision with root package name */
        private final SandboxFlags f26050c;

        /* renamed from: d  reason: collision with root package name */
        private final RealFallbackModeManager f26051d;

        public b(p pVar, com.withpersona.sdk2.inquiry.shared.device.b bVar, SandboxFlags sandboxFlags, RealFallbackModeManager realFallbackModeManager) {
            kotlin.jvm.internal.j.g(pVar, "service");
            kotlin.jvm.internal.j.g(bVar, "deviceIdProvider");
            kotlin.jvm.internal.j.g(sandboxFlags, "sandboxFlags");
            kotlin.jvm.internal.j.g(realFallbackModeManager, "fallbackModeManager");
            this.f26048a = pVar;
            this.f26049b = bVar;
            this.f26050c = sandboxFlags;
            this.f26051d = realFallbackModeManager;
        }

        public final CheckInquiryWorker a(String str, String str2) {
            kotlin.jvm.internal.j.g(str, "sessionToken");
            kotlin.jvm.internal.j.g(str2, "inquiryId");
            return new CheckInquiryWorker(str, str2, this.f26048a, this.f26049b, this.f26050c, this.f26051d);
        }
    }

    public static abstract class c {

        public static final class a extends c {

            /* renamed from: a  reason: collision with root package name */
            private final InquiryState.Complete f26052a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(InquiryState.Complete complete) {
                super((DefaultConstructorMarker) null);
                kotlin.jvm.internal.j.g(complete, "nextState");
                this.f26052a = complete;
            }

            public final InquiryState.Complete a() {
                return this.f26052a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof a) && kotlin.jvm.internal.j.b(this.f26052a, ((a) obj).f26052a);
            }

            public int hashCode() {
                return this.f26052a.hashCode();
            }

            public String toString() {
                return "Complete(nextState=" + this.f26052a + PropertyUtils.MAPPED_DELIM2;
            }
        }

        public static final class b extends c {

            /* renamed from: a  reason: collision with root package name */
            private final InternalErrorInfo f26053a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(InternalErrorInfo internalErrorInfo) {
                super((DefaultConstructorMarker) null);
                kotlin.jvm.internal.j.g(internalErrorInfo, "cause");
                this.f26053a = internalErrorInfo;
            }

            public final InternalErrorInfo a() {
                return this.f26053a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof b) && kotlin.jvm.internal.j.b(this.f26053a, ((b) obj).f26053a);
            }

            public int hashCode() {
                return this.f26053a.hashCode();
            }

            public String toString() {
                return "Error(cause=" + this.f26053a + PropertyUtils.MAPPED_DELIM2;
            }
        }

        /* renamed from: com.withpersona.sdk2.inquiry.internal.CheckInquiryWorker$c$c  reason: collision with other inner class name */
        public static final class C0312c extends c {

            /* renamed from: a  reason: collision with root package name */
            private final InquiryState f26054a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0312c(InquiryState inquiryState) {
                super((DefaultConstructorMarker) null);
                kotlin.jvm.internal.j.g(inquiryState, "nextState");
                this.f26054a = inquiryState;
            }

            public final InquiryState a() {
                return this.f26054a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C0312c) && kotlin.jvm.internal.j.b(this.f26054a, ((C0312c) obj).f26054a);
            }

            public int hashCode() {
                return this.f26054a.hashCode();
            }

            public String toString() {
                return "Success(nextState=" + this.f26054a + PropertyUtils.MAPPED_DELIM2;
            }
        }

        private c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CheckInquiryWorker(String str, String str2, p pVar, com.withpersona.sdk2.inquiry.shared.device.b bVar, SandboxFlags sandboxFlags, RealFallbackModeManager realFallbackModeManager) {
        kotlin.jvm.internal.j.g(str, "sessionToken");
        kotlin.jvm.internal.j.g(str2, "inquiryId");
        kotlin.jvm.internal.j.g(pVar, "service");
        kotlin.jvm.internal.j.g(bVar, "deviceIdProvider");
        kotlin.jvm.internal.j.g(sandboxFlags, "sandboxFlags");
        kotlin.jvm.internal.j.g(realFallbackModeManager, "fallbackModeManager");
        this.f26042b = str;
        this.f26043c = str2;
        this.f26044d = pVar;
        this.f26045e = bVar;
        this.f26046f = sandboxFlags;
        this.f26047g = realFallbackModeManager;
    }

    /* access modifiers changed from: private */
    public final Object g(kotlinx.coroutines.flow.c<? super c> cVar, InquiryState inquiryState, kotlin.coroutines.c<? super Unit> cVar2) {
        if (inquiryState instanceof InquiryState.Complete) {
            Object c10 = cVar.c(new c.a((InquiryState.Complete) inquiryState), cVar2);
            if (c10 == b.d()) {
                return c10;
            }
            return Unit.f32013a;
        }
        Object c11 = cVar.c(new c.C0312c(inquiryState), cVar2);
        if (c11 == b.d()) {
            return c11;
        }
        return Unit.f32013a;
    }

    public boolean a(j<?> jVar) {
        kotlin.jvm.internal.j.g(jVar, "otherWorker");
        if (jVar instanceof CheckInquiryWorker) {
            CheckInquiryWorker checkInquiryWorker = (CheckInquiryWorker) jVar;
            if (!kotlin.jvm.internal.j.b(this.f26042b, checkInquiryWorker.f26042b) || !kotlin.jvm.internal.j.b(this.f26043c, checkInquiryWorker.f26043c)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final String h() {
        return this.f26043c;
    }

    public final String i() {
        return this.f26042b;
    }

    public kotlinx.coroutines.flow.b<c> run() {
        return d.v(new CheckInquiryWorker$run$1(this, (kotlin.coroutines.c<? super CheckInquiryWorker$run$1>) null));
    }
}
