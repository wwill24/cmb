package com.withpersona.sdk2.inquiry.document.network;

import com.squareup.workflow1.j;
import com.withpersona.sdk2.inquiry.document.DocumentFile;
import com.withpersona.sdk2.inquiry.network.GenericFileUploadErrorResponse;
import com.withpersona.sdk2.inquiry.network.InternalErrorInfo;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.d;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.s1;
import kotlinx.coroutines.x0;
import ti.c;

public final class DocumentFileUploadWorker implements j<b> {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final String f25220b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final a f25221c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final String f25222d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final DocumentFile.Local f25223e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final c f25224f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final k0 f25225g;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final a f25226a;

        /* renamed from: b  reason: collision with root package name */
        private final c f25227b;

        public a(a aVar, c cVar) {
            kotlin.jvm.internal.j.g(aVar, "service");
            kotlin.jvm.internal.j.g(cVar, "fileHelper");
            this.f25226a = aVar;
            this.f25227b = cVar;
        }

        public final DocumentFileUploadWorker a(String str, String str2, DocumentFile.Local local) {
            kotlin.jvm.internal.j.g(str, "sessionToken");
            kotlin.jvm.internal.j.g(str2, "documentId");
            kotlin.jvm.internal.j.g(local, "localDocument");
            return new DocumentFileUploadWorker(str, this.f25226a, str2, local, this.f25227b, (DefaultConstructorMarker) null);
        }
    }

    public static abstract class b {

        public static final class a extends b {

            /* renamed from: a  reason: collision with root package name */
            private final GenericFileUploadErrorResponse.DocumentErrorResponse f25228a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(GenericFileUploadErrorResponse.DocumentErrorResponse documentErrorResponse) {
                super((DefaultConstructorMarker) null);
                kotlin.jvm.internal.j.g(documentErrorResponse, "cause");
                this.f25228a = documentErrorResponse;
            }

            public final GenericFileUploadErrorResponse.DocumentErrorResponse a() {
                return this.f25228a;
            }
        }

        /* renamed from: com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker$b$b  reason: collision with other inner class name */
        public static final class C0305b extends b {

            /* renamed from: a  reason: collision with root package name */
            private final InternalErrorInfo f25229a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0305b(InternalErrorInfo internalErrorInfo) {
                super((DefaultConstructorMarker) null);
                kotlin.jvm.internal.j.g(internalErrorInfo, "cause");
                this.f25229a = internalErrorInfo;
            }

            public final InternalErrorInfo a() {
                return this.f25229a;
            }
        }

        public static final class c extends b {

            /* renamed from: a  reason: collision with root package name */
            private final int f25230a;

            public c(int i10) {
                super((DefaultConstructorMarker) null);
                this.f25230a = i10;
            }

            public final int a() {
                return this.f25230a;
            }
        }

        public static final class d extends b {

            /* renamed from: a  reason: collision with root package name */
            private final DocumentFile.Local f25231a;

            /* renamed from: b  reason: collision with root package name */
            private final DocumentFile.Remote f25232b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public d(DocumentFile.Local local, DocumentFile.Remote remote) {
                super((DefaultConstructorMarker) null);
                kotlin.jvm.internal.j.g(local, "oldLocalDocument");
                kotlin.jvm.internal.j.g(remote, "newRemoteDocument");
                this.f25231a = local;
                this.f25232b = remote;
            }

            public final DocumentFile.Remote a() {
                return this.f25232b;
            }

            public final DocumentFile.Local b() {
                return this.f25231a;
            }
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private DocumentFileUploadWorker(String str, a aVar, String str2, DocumentFile.Local local, c cVar) {
        this.f25220b = str;
        this.f25221c = aVar;
        this.f25222d = str2;
        this.f25223e = local;
        this.f25224f = cVar;
        this.f25225g = l0.a(x0.a().e0(x1.b((s1) null, 1, (Object) null)));
    }

    public /* synthetic */ DocumentFileUploadWorker(String str, a aVar, String str2, DocumentFile.Local local, c cVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, aVar, str2, local, cVar);
    }

    public boolean a(j<?> jVar) {
        kotlin.jvm.internal.j.g(jVar, "otherWorker");
        if (jVar instanceof DocumentFileUploadWorker) {
            DocumentFileUploadWorker documentFileUploadWorker = (DocumentFileUploadWorker) jVar;
            if (!kotlin.jvm.internal.j.b(this.f25220b, documentFileUploadWorker.f25220b) || !kotlin.jvm.internal.j.b(this.f25223e, documentFileUploadWorker.f25223e)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public kotlinx.coroutines.flow.b<b> run() {
        return d.v(new DocumentFileUploadWorker$run$1(this, (kotlin.coroutines.c<? super DocumentFileUploadWorker$run$1>) null));
    }
}
