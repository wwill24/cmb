package com.withpersona.sdk2.inquiry.internal;

import com.squareup.workflow1.j;
import com.withpersona.sdk2.inquiry.internal.network.p;
import com.withpersona.sdk2.inquiry.network.InternalErrorInfo;
import kotlin.coroutines.c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.d;
import org.apache.commons.beanutils.PropertyUtils;

public final class TransitionBackWorker implements j<b> {

    /* renamed from: b  reason: collision with root package name */
    private final String f26273b;

    /* renamed from: c  reason: collision with root package name */
    private final String f26274c;

    /* renamed from: d  reason: collision with root package name */
    private final String f26275d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final p f26276e;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final p f26277a;

        public a(p pVar) {
            kotlin.jvm.internal.j.g(pVar, "service");
            this.f26277a = pVar;
        }

        public final TransitionBackWorker a(String str, String str2, String str3) {
            kotlin.jvm.internal.j.g(str, "sessionToken");
            kotlin.jvm.internal.j.g(str2, "inquiryId");
            kotlin.jvm.internal.j.g(str3, "fromStep");
            return new TransitionBackWorker(str, str2, str3, this.f26277a);
        }
    }

    public static abstract class b {

        public static final class a extends b {

            /* renamed from: a  reason: collision with root package name */
            private final InternalErrorInfo f26278a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(InternalErrorInfo internalErrorInfo) {
                super((DefaultConstructorMarker) null);
                kotlin.jvm.internal.j.g(internalErrorInfo, "cause");
                this.f26278a = internalErrorInfo;
            }

            public final InternalErrorInfo a() {
                return this.f26278a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof a) && kotlin.jvm.internal.j.b(this.f26278a, ((a) obj).f26278a);
            }

            public int hashCode() {
                return this.f26278a.hashCode();
            }

            public String toString() {
                return "Error(cause=" + this.f26278a + PropertyUtils.MAPPED_DELIM2;
            }
        }

        /* renamed from: com.withpersona.sdk2.inquiry.internal.TransitionBackWorker$b$b  reason: collision with other inner class name */
        public static final class C0316b extends b {

            /* renamed from: a  reason: collision with root package name */
            private final InquiryState f26279a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0316b(InquiryState inquiryState) {
                super((DefaultConstructorMarker) null);
                kotlin.jvm.internal.j.g(inquiryState, "nextState");
                this.f26279a = inquiryState;
            }

            public final InquiryState a() {
                return this.f26279a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C0316b) && kotlin.jvm.internal.j.b(this.f26279a, ((C0316b) obj).f26279a);
            }

            public int hashCode() {
                return this.f26279a.hashCode();
            }

            public String toString() {
                return "Success(nextState=" + this.f26279a + PropertyUtils.MAPPED_DELIM2;
            }
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public TransitionBackWorker(String str, String str2, String str3, p pVar) {
        kotlin.jvm.internal.j.g(str, "sessionToken");
        kotlin.jvm.internal.j.g(str2, "inquiryId");
        kotlin.jvm.internal.j.g(str3, "fromStep");
        kotlin.jvm.internal.j.g(pVar, "service");
        this.f26273b = str;
        this.f26274c = str2;
        this.f26275d = str3;
        this.f26276e = pVar;
    }

    public boolean a(j<?> jVar) {
        kotlin.jvm.internal.j.g(jVar, "otherWorker");
        if (jVar instanceof TransitionBackWorker) {
            TransitionBackWorker transitionBackWorker = (TransitionBackWorker) jVar;
            if (!kotlin.jvm.internal.j.b(this.f26273b, transitionBackWorker.f26273b) || !kotlin.jvm.internal.j.b(this.f26274c, transitionBackWorker.f26274c)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final String c() {
        return this.f26275d;
    }

    public final String d() {
        return this.f26274c;
    }

    public final String e() {
        return this.f26273b;
    }

    public kotlinx.coroutines.flow.b<b> run() {
        return d.v(new TransitionBackWorker$run$1(this, (c<? super TransitionBackWorker$run$1>) null));
    }
}
