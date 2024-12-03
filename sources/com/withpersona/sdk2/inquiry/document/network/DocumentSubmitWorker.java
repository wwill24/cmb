package com.withpersona.sdk2.inquiry.document.network;

import com.squareup.workflow1.j;
import com.withpersona.sdk2.inquiry.document.DocumentFile;
import com.withpersona.sdk2.inquiry.network.InternalErrorInfo;
import java.util.List;
import kotlin.coroutines.c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.d;
import org.apache.commons.beanutils.PropertyUtils;

public final class DocumentSubmitWorker implements j<b> {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final String f25243b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final a f25244c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final String f25245d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final String f25246e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final String f25247f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final ji.a f25248g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final ui.a f25249h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final List<DocumentFile> f25250i;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final a f25251a;

        /* renamed from: b  reason: collision with root package name */
        private final ji.a f25252b;

        /* renamed from: c  reason: collision with root package name */
        private final ui.a f25253c;

        public a(a aVar, ji.a aVar2, ui.a aVar3) {
            kotlin.jvm.internal.j.g(aVar, "service");
            kotlin.jvm.internal.j.g(aVar2, "fallbackModeManager");
            kotlin.jvm.internal.j.g(aVar3, "dataCollector");
            this.f25251a = aVar;
            this.f25252b = aVar2;
            this.f25253c = aVar3;
        }

        public final DocumentSubmitWorker a(String str, String str2, String str3, String str4, List<? extends DocumentFile> list) {
            kotlin.jvm.internal.j.g(str, "sessionToken");
            kotlin.jvm.internal.j.g(str2, "inquiryId");
            kotlin.jvm.internal.j.g(str3, "fromStep");
            String str5 = str4;
            kotlin.jvm.internal.j.g(str5, "fromComponent");
            List<? extends DocumentFile> list2 = list;
            kotlin.jvm.internal.j.g(list2, "documents");
            return new DocumentSubmitWorker(str, this.f25251a, str2, str3, str5, this.f25252b, this.f25253c, list2, (DefaultConstructorMarker) null);
        }
    }

    public static abstract class b {

        public static final class a extends b {

            /* renamed from: a  reason: collision with root package name */
            private final InternalErrorInfo f25254a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(InternalErrorInfo internalErrorInfo) {
                super((DefaultConstructorMarker) null);
                kotlin.jvm.internal.j.g(internalErrorInfo, "cause");
                this.f25254a = internalErrorInfo;
            }

            public final InternalErrorInfo a() {
                return this.f25254a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof a) && kotlin.jvm.internal.j.b(this.f25254a, ((a) obj).f25254a);
            }

            public int hashCode() {
                return this.f25254a.hashCode();
            }

            public String toString() {
                return "Error(cause=" + this.f25254a + PropertyUtils.MAPPED_DELIM2;
            }
        }

        /* renamed from: com.withpersona.sdk2.inquiry.document.network.DocumentSubmitWorker$b$b  reason: collision with other inner class name */
        public static final class C0307b extends b {

            /* renamed from: a  reason: collision with root package name */
            public static final C0307b f25255a = new C0307b();

            private C0307b() {
                super((DefaultConstructorMarker) null);
            }
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private DocumentSubmitWorker(String str, a aVar, String str2, String str3, String str4, ji.a aVar2, ui.a aVar3, List<? extends DocumentFile> list) {
        this.f25243b = str;
        this.f25244c = aVar;
        this.f25245d = str2;
        this.f25246e = str3;
        this.f25247f = str4;
        this.f25248g = aVar2;
        this.f25249h = aVar3;
        this.f25250i = list;
    }

    public /* synthetic */ DocumentSubmitWorker(String str, a aVar, String str2, String str3, String str4, ji.a aVar2, ui.a aVar3, List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, aVar, str2, str3, str4, aVar2, aVar3, list);
    }

    public boolean a(j<?> jVar) {
        kotlin.jvm.internal.j.g(jVar, "otherWorker");
        if (!(jVar instanceof DocumentSubmitWorker) || !kotlin.jvm.internal.j.b(this.f25243b, ((DocumentSubmitWorker) jVar).f25243b)) {
            return false;
        }
        return true;
    }

    public kotlinx.coroutines.flow.b<b> run() {
        return d.v(new DocumentSubmitWorker$run$1(this, (c<? super DocumentSubmitWorker$run$1>) null));
    }
}
