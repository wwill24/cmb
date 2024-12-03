package com.withpersona.sdk2.inquiry.document.network;

import com.squareup.workflow1.j;
import com.withpersona.sdk2.inquiry.network.InternalErrorInfo;
import kotlin.coroutines.c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.d;
import org.apache.commons.beanutils.PropertyUtils;

public final class DocumentCreateWorker implements j<b> {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final String f25190b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final a f25191c;

    /* renamed from: d  reason: collision with root package name */
    private final String f25192d;

    /* renamed from: e  reason: collision with root package name */
    private final int f25193e;

    /* renamed from: f  reason: collision with root package name */
    private final String f25194f;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final a f25195a;

        public a(a aVar) {
            kotlin.jvm.internal.j.g(aVar, "service");
            this.f25195a = aVar;
        }

        public final DocumentCreateWorker a(String str, String str2, String str3, int i10) {
            kotlin.jvm.internal.j.g(str, "sessionToken");
            kotlin.jvm.internal.j.g(str2, "documentKind");
            kotlin.jvm.internal.j.g(str3, "fieldKeyDocument");
            return new DocumentCreateWorker(str, this.f25195a, str2, i10, str3, (DefaultConstructorMarker) null);
        }
    }

    public static abstract class b {

        public static final class a extends b {

            /* renamed from: a  reason: collision with root package name */
            private final InternalErrorInfo.NetworkErrorInfo f25196a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(InternalErrorInfo.NetworkErrorInfo networkErrorInfo) {
                super((DefaultConstructorMarker) null);
                kotlin.jvm.internal.j.g(networkErrorInfo, "cause");
                this.f25196a = networkErrorInfo;
            }

            public final InternalErrorInfo.NetworkErrorInfo a() {
                return this.f25196a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof a) && kotlin.jvm.internal.j.b(this.f25196a, ((a) obj).f25196a);
            }

            public int hashCode() {
                return this.f25196a.hashCode();
            }

            public String toString() {
                return "Error(cause=" + this.f25196a + PropertyUtils.MAPPED_DELIM2;
            }
        }

        /* renamed from: com.withpersona.sdk2.inquiry.document.network.DocumentCreateWorker$b$b  reason: collision with other inner class name */
        public static final class C0303b extends b {

            /* renamed from: a  reason: collision with root package name */
            private final String f25197a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0303b(String str) {
                super((DefaultConstructorMarker) null);
                kotlin.jvm.internal.j.g(str, "documentId");
                this.f25197a = str;
            }

            public final String a() {
                return this.f25197a;
            }
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private DocumentCreateWorker(String str, a aVar, String str2, int i10, String str3) {
        this.f25190b = str;
        this.f25191c = aVar;
        this.f25192d = str2;
        this.f25193e = i10;
        this.f25194f = str3;
    }

    public /* synthetic */ DocumentCreateWorker(String str, a aVar, String str2, int i10, String str3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, aVar, str2, i10, str3);
    }

    public boolean a(j<?> jVar) {
        kotlin.jvm.internal.j.g(jVar, "otherWorker");
        if (jVar instanceof DocumentCreateWorker) {
            DocumentCreateWorker documentCreateWorker = (DocumentCreateWorker) jVar;
            if (!kotlin.jvm.internal.j.b(this.f25190b, documentCreateWorker.f25190b) || !kotlin.jvm.internal.j.b(this.f25194f, documentCreateWorker.f25194f)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final String d() {
        return this.f25192d;
    }

    public final String e() {
        return this.f25194f;
    }

    public final int f() {
        return this.f25193e;
    }

    public kotlinx.coroutines.flow.b<b> run() {
        return d.v(new DocumentCreateWorker$run$1(this, (c<? super DocumentCreateWorker$run$1>) null));
    }
}
