package com.withpersona.sdk2.inquiry.internal;

import com.squareup.workflow1.j;
import com.withpersona.sdk2.inquiry.internal.fallbackmode.RealFallbackModeManager;
import com.withpersona.sdk2.inquiry.internal.network.NextStep;
import com.withpersona.sdk2.inquiry.internal.network.p;
import com.withpersona.sdk2.inquiry.network.InternalErrorInfo;
import java.util.Map;
import kotlin.coroutines.c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.d;
import org.apache.commons.beanutils.PropertyUtils;

public final class CreateInquiryWorker implements j<b> {

    /* renamed from: b  reason: collision with root package name */
    private final String f26064b;

    /* renamed from: c  reason: collision with root package name */
    private final String f26065c;

    /* renamed from: d  reason: collision with root package name */
    private final Environment f26066d;

    /* renamed from: e  reason: collision with root package name */
    private final String f26067e;

    /* renamed from: f  reason: collision with root package name */
    private final String f26068f;

    /* renamed from: g  reason: collision with root package name */
    private final Map<String, InquiryField> f26069g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final p f26070h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final RealFallbackModeManager f26071i;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final p f26072a;

        /* renamed from: b  reason: collision with root package name */
        private final RealFallbackModeManager f26073b;

        public a(p pVar, RealFallbackModeManager realFallbackModeManager) {
            kotlin.jvm.internal.j.g(pVar, "service");
            kotlin.jvm.internal.j.g(realFallbackModeManager, "fallbackModeManager");
            this.f26072a = pVar;
            this.f26073b = realFallbackModeManager;
        }

        public final CreateInquiryWorker a(String str, String str2, Environment environment, String str3, String str4, Map<String, ? extends InquiryField> map) {
            kotlin.jvm.internal.j.g(environment, "environment");
            return new CreateInquiryWorker(str, str2, environment, str3, str4, map, this.f26072a, this.f26073b);
        }
    }

    public static abstract class b {

        public static final class a extends b {

            /* renamed from: a  reason: collision with root package name */
            private final String f26074a;

            /* renamed from: b  reason: collision with root package name */
            private final InternalErrorInfo f26075b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str, InternalErrorInfo internalErrorInfo) {
                super((DefaultConstructorMarker) null);
                kotlin.jvm.internal.j.g(internalErrorInfo, "cause");
                this.f26074a = str;
                this.f26075b = internalErrorInfo;
            }

            public final InternalErrorInfo a() {
                return this.f26075b;
            }

            public final String b() {
                return this.f26074a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                return kotlin.jvm.internal.j.b(this.f26074a, aVar.f26074a) && kotlin.jvm.internal.j.b(this.f26075b, aVar.f26075b);
            }

            public int hashCode() {
                String str = this.f26074a;
                return ((str == null ? 0 : str.hashCode()) * 31) + this.f26075b.hashCode();
            }

            public String toString() {
                return "Error(debugMessage=" + this.f26074a + ", cause=" + this.f26075b + PropertyUtils.MAPPED_DELIM2;
            }
        }

        /* renamed from: com.withpersona.sdk2.inquiry.internal.CreateInquiryWorker$b$b  reason: collision with other inner class name */
        public static final class C0314b extends b {

            /* renamed from: a  reason: collision with root package name */
            private final String f26076a;

            /* renamed from: b  reason: collision with root package name */
            private final NextStep f26077b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0314b(String str, NextStep nextStep) {
                super((DefaultConstructorMarker) null);
                kotlin.jvm.internal.j.g(str, "inquiryId");
                kotlin.jvm.internal.j.g(nextStep, "nextStep");
                this.f26076a = str;
                this.f26077b = nextStep;
            }

            public final String a() {
                return this.f26076a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0314b)) {
                    return false;
                }
                C0314b bVar = (C0314b) obj;
                return kotlin.jvm.internal.j.b(this.f26076a, bVar.f26076a) && kotlin.jvm.internal.j.b(this.f26077b, bVar.f26077b);
            }

            public int hashCode() {
                return (this.f26076a.hashCode() * 31) + this.f26077b.hashCode();
            }

            public String toString() {
                return "Success(inquiryId=" + this.f26076a + ", nextStep=" + this.f26077b + PropertyUtils.MAPPED_DELIM2;
            }
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CreateInquiryWorker(String str, String str2, Environment environment, String str3, String str4, Map<String, ? extends InquiryField> map, p pVar, RealFallbackModeManager realFallbackModeManager) {
        kotlin.jvm.internal.j.g(environment, "environment");
        kotlin.jvm.internal.j.g(pVar, "service");
        kotlin.jvm.internal.j.g(realFallbackModeManager, "fallbackModeManager");
        this.f26064b = str;
        this.f26065c = str2;
        this.f26066d = environment;
        this.f26067e = str3;
        this.f26068f = str4;
        this.f26069g = map;
        this.f26070h = pVar;
        this.f26071i = realFallbackModeManager;
    }

    public boolean a(j<?> jVar) {
        kotlin.jvm.internal.j.g(jVar, "otherWorker");
        if (jVar instanceof CreateInquiryWorker) {
            CreateInquiryWorker createInquiryWorker = (CreateInquiryWorker) jVar;
            if (!kotlin.jvm.internal.j.b(this.f26064b, createInquiryWorker.f26064b) || !kotlin.jvm.internal.j.b(this.f26065c, createInquiryWorker.f26065c) || this.f26066d != createInquiryWorker.f26066d) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final String d() {
        return this.f26067e;
    }

    public final Environment e() {
        return this.f26066d;
    }

    public final Map<String, InquiryField> f() {
        return this.f26069g;
    }

    public final String g() {
        return this.f26068f;
    }

    public final String h() {
        return this.f26064b;
    }

    public final String i() {
        return this.f26065c;
    }

    public kotlinx.coroutines.flow.b<b> run() {
        return d.v(new CreateInquiryWorker$run$1(this, (c<? super CreateInquiryWorker$run$1>) null));
    }
}
