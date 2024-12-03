package com.withpersona.sdk2.inquiry.document.network;

import com.squareup.workflow1.j;
import com.withpersona.sdk2.inquiry.document.DocumentFile;
import com.withpersona.sdk2.inquiry.network.InternalErrorInfo;
import kotlin.coroutines.c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.d;
import org.apache.commons.beanutils.PropertyUtils;

public final class DocumentFileDeleteWorker implements j<b> {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final String f25210b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final a f25211c;

    /* renamed from: d  reason: collision with root package name */
    private final String f25212d;

    /* renamed from: e  reason: collision with root package name */
    private final DocumentFile.Remote f25213e;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final a f25214a;

        public a(a aVar) {
            kotlin.jvm.internal.j.g(aVar, "service");
            this.f25214a = aVar;
        }

        public final DocumentFileDeleteWorker a(String str, String str2, DocumentFile.Remote remote) {
            kotlin.jvm.internal.j.g(str, "sessionToken");
            kotlin.jvm.internal.j.g(str2, "documentId");
            kotlin.jvm.internal.j.g(remote, "remoteDocument");
            return new DocumentFileDeleteWorker(str, this.f25214a, str2, remote, (DefaultConstructorMarker) null);
        }
    }

    public static abstract class b {

        public static final class a extends b {

            /* renamed from: a  reason: collision with root package name */
            private final InternalErrorInfo f25215a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(InternalErrorInfo internalErrorInfo) {
                super((DefaultConstructorMarker) null);
                kotlin.jvm.internal.j.g(internalErrorInfo, "cause");
                this.f25215a = internalErrorInfo;
            }

            public final InternalErrorInfo a() {
                return this.f25215a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof a) && kotlin.jvm.internal.j.b(this.f25215a, ((a) obj).f25215a);
            }

            public int hashCode() {
                return this.f25215a.hashCode();
            }

            public String toString() {
                return "Error(cause=" + this.f25215a + PropertyUtils.MAPPED_DELIM2;
            }
        }

        /* renamed from: com.withpersona.sdk2.inquiry.document.network.DocumentFileDeleteWorker$b$b  reason: collision with other inner class name */
        public static final class C0304b extends b {

            /* renamed from: a  reason: collision with root package name */
            public static final C0304b f25216a = new C0304b();

            private C0304b() {
                super((DefaultConstructorMarker) null);
            }
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private DocumentFileDeleteWorker(String str, a aVar, String str2, DocumentFile.Remote remote) {
        this.f25210b = str;
        this.f25211c = aVar;
        this.f25212d = str2;
        this.f25213e = remote;
    }

    public /* synthetic */ DocumentFileDeleteWorker(String str, a aVar, String str2, DocumentFile.Remote remote, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, aVar, str2, remote);
    }

    public boolean a(j<?> jVar) {
        kotlin.jvm.internal.j.g(jVar, "otherWorker");
        if (jVar instanceof DocumentFileDeleteWorker) {
            DocumentFileDeleteWorker documentFileDeleteWorker = (DocumentFileDeleteWorker) jVar;
            if (!kotlin.jvm.internal.j.b(this.f25210b, documentFileDeleteWorker.f25210b) || !kotlin.jvm.internal.j.b(this.f25213e, documentFileDeleteWorker.f25213e)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final DocumentFile.Remote d() {
        return this.f25213e;
    }

    public kotlinx.coroutines.flow.b<b> run() {
        return d.v(new DocumentFileDeleteWorker$run$1(this, (c<? super DocumentFileDeleteWorker$run$1>) null));
    }
}
