package com.withpersona.sdk2.inquiry.document.network;

import com.squareup.workflow1.j;
import com.withpersona.sdk2.inquiry.document.DocumentFile;
import com.withpersona.sdk2.inquiry.network.InternalErrorInfo;
import java.util.List;
import kotlin.coroutines.c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.d;

public final class DocumentLoadWorker implements j<b> {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final String f25235b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final a f25236c;

    /* renamed from: d  reason: collision with root package name */
    private final String f25237d;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final a f25238a;

        public a(a aVar) {
            kotlin.jvm.internal.j.g(aVar, "service");
            this.f25238a = aVar;
        }

        public final DocumentLoadWorker a(String str, String str2) {
            kotlin.jvm.internal.j.g(str, "sessionToken");
            kotlin.jvm.internal.j.g(str2, "documentId");
            return new DocumentLoadWorker(str, this.f25238a, str2, (DefaultConstructorMarker) null);
        }
    }

    public static abstract class b {

        public static final class a extends b {

            /* renamed from: a  reason: collision with root package name */
            private final InternalErrorInfo f25239a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(InternalErrorInfo internalErrorInfo) {
                super((DefaultConstructorMarker) null);
                kotlin.jvm.internal.j.g(internalErrorInfo, "cause");
                this.f25239a = internalErrorInfo;
            }

            public final InternalErrorInfo a() {
                return this.f25239a;
            }
        }

        /* renamed from: com.withpersona.sdk2.inquiry.document.network.DocumentLoadWorker$b$b  reason: collision with other inner class name */
        public static final class C0306b extends b {

            /* renamed from: a  reason: collision with root package name */
            private final List<DocumentFile> f25240a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0306b(List<? extends DocumentFile> list) {
                super((DefaultConstructorMarker) null);
                kotlin.jvm.internal.j.g(list, "documents");
                this.f25240a = list;
            }

            public final List<DocumentFile> a() {
                return this.f25240a;
            }
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private DocumentLoadWorker(String str, a aVar, String str2) {
        this.f25235b = str;
        this.f25236c = aVar;
        this.f25237d = str2;
    }

    public /* synthetic */ DocumentLoadWorker(String str, a aVar, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, aVar, str2);
    }

    public boolean a(j<?> jVar) {
        kotlin.jvm.internal.j.g(jVar, "otherWorker");
        if (jVar instanceof DocumentLoadWorker) {
            DocumentLoadWorker documentLoadWorker = (DocumentLoadWorker) jVar;
            if (!kotlin.jvm.internal.j.b(this.f25235b, documentLoadWorker.f25235b) || !kotlin.jvm.internal.j.b(this.f25237d, documentLoadWorker.f25237d)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final String d() {
        return this.f25237d;
    }

    public kotlinx.coroutines.flow.b<b> run() {
        return d.v(new DocumentLoadWorker$run$1(this, (c<? super DocumentLoadWorker$run$1>) null));
    }
}
