package com.withpersona.sdk2.inquiry.internal;

import com.squareup.workflow1.j;
import com.withpersona.sdk2.inquiry.internal.fallbackmode.RealFallbackModeManager;
import com.withpersona.sdk2.inquiry.internal.network.p;
import com.withpersona.sdk2.inquiry.network.InternalErrorInfo;
import kotlin.coroutines.c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.d;
import org.apache.commons.beanutils.PropertyUtils;

public final class CreateInquirySessionWorker implements j<b> {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final String f26055b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final p f26056c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final com.withpersona.sdk2.inquiry.shared.device.b f26057d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final RealFallbackModeManager f26058e;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final p f26059a;

        /* renamed from: b  reason: collision with root package name */
        private final com.withpersona.sdk2.inquiry.shared.device.b f26060b;

        /* renamed from: c  reason: collision with root package name */
        private final RealFallbackModeManager f26061c;

        public a(p pVar, com.withpersona.sdk2.inquiry.shared.device.b bVar, RealFallbackModeManager realFallbackModeManager) {
            kotlin.jvm.internal.j.g(pVar, "service");
            kotlin.jvm.internal.j.g(bVar, "deviceIdProvider");
            kotlin.jvm.internal.j.g(realFallbackModeManager, "fallbackModeManager");
            this.f26059a = pVar;
            this.f26060b = bVar;
            this.f26061c = realFallbackModeManager;
        }

        public final CreateInquirySessionWorker a(String str) {
            kotlin.jvm.internal.j.g(str, "inquiryId");
            return new CreateInquirySessionWorker(str, this.f26059a, this.f26060b, this.f26061c);
        }
    }

    public static abstract class b {

        public static final class a extends b {

            /* renamed from: a  reason: collision with root package name */
            private final InternalErrorInfo f26062a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(InternalErrorInfo internalErrorInfo) {
                super((DefaultConstructorMarker) null);
                kotlin.jvm.internal.j.g(internalErrorInfo, "cause");
                this.f26062a = internalErrorInfo;
            }

            public final InternalErrorInfo a() {
                return this.f26062a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof a) && kotlin.jvm.internal.j.b(this.f26062a, ((a) obj).f26062a);
            }

            public int hashCode() {
                return this.f26062a.hashCode();
            }

            public String toString() {
                return "Error(cause=" + this.f26062a + PropertyUtils.MAPPED_DELIM2;
            }
        }

        /* renamed from: com.withpersona.sdk2.inquiry.internal.CreateInquirySessionWorker$b$b  reason: collision with other inner class name */
        public static final class C0313b extends b {

            /* renamed from: a  reason: collision with root package name */
            private final String f26063a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0313b(String str) {
                super((DefaultConstructorMarker) null);
                kotlin.jvm.internal.j.g(str, "sessionToken");
                this.f26063a = str;
            }

            public final String a() {
                return this.f26063a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C0313b) && kotlin.jvm.internal.j.b(this.f26063a, ((C0313b) obj).f26063a);
            }

            public int hashCode() {
                return this.f26063a.hashCode();
            }

            public String toString() {
                return "Success(sessionToken=" + this.f26063a + PropertyUtils.MAPPED_DELIM2;
            }
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CreateInquirySessionWorker(String str, p pVar, com.withpersona.sdk2.inquiry.shared.device.b bVar, RealFallbackModeManager realFallbackModeManager) {
        kotlin.jvm.internal.j.g(str, "inquiryId");
        kotlin.jvm.internal.j.g(pVar, "service");
        kotlin.jvm.internal.j.g(bVar, "deviceIdProvider");
        kotlin.jvm.internal.j.g(realFallbackModeManager, "fallbackModeManager");
        this.f26055b = str;
        this.f26056c = pVar;
        this.f26057d = bVar;
        this.f26058e = realFallbackModeManager;
    }

    public boolean a(j<?> jVar) {
        kotlin.jvm.internal.j.g(jVar, "otherWorker");
        if (!(jVar instanceof CreateInquirySessionWorker) || !kotlin.jvm.internal.j.b(this.f26055b, ((CreateInquirySessionWorker) jVar).f26055b)) {
            return false;
        }
        return true;
    }

    public kotlinx.coroutines.flow.b<b> run() {
        return d.v(new CreateInquirySessionWorker$run$1(this, (c<? super CreateInquirySessionWorker$run$1>) null));
    }
}
