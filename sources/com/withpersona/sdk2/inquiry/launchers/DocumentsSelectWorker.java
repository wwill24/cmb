package com.withpersona.sdk2.inquiry.launchers;

import android.content.Context;
import androidx.activity.result.c;
import androidx.activity.result.e;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.mparticle.identity.IdentityHttpResponse;
import com.squareup.workflow1.j;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.flow.d;
import kotlinx.coroutines.x0;
import org.apache.commons.beanutils.PropertyUtils;
import org.jivesoftware.smackx.jingle.element.JingleReason;

public final class DocumentsSelectWorker implements j<a> {

    /* renamed from: b  reason: collision with root package name */
    private final String f26935b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Context f26936c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final Function0<Unit> f26937d;

    public enum Error {
        FileNotFound,
        PermissionDenied
    }

    public static final class Factory {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final c<String[]> f26941a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final c<e> f26942b;

        /* renamed from: c  reason: collision with root package name */
        private final Context f26943c;

        public Factory(c<String[]> cVar, c<e> cVar2, Context context) {
            kotlin.jvm.internal.j.g(cVar, "openDocumentLauncher");
            kotlin.jvm.internal.j.g(cVar2, "selectFromPhotoLibraryLauncher");
            kotlin.jvm.internal.j.g(context, IdentityHttpResponse.CONTEXT);
            this.f26941a = cVar;
            this.f26942b = cVar2;
            this.f26943c = context;
        }

        public final DocumentsSelectWorker c() {
            return new DocumentsSelectWorker("DocumentPicker", this.f26943c, new DocumentsSelectWorker$Factory$createWithDocumentPicker$1(this));
        }

        public final DocumentsSelectWorker d() {
            return new DocumentsSelectWorker("PhotoLibraryPicker", this.f26943c, new DocumentsSelectWorker$Factory$createWithPhotoLibraryPicker$1(this));
        }
    }

    public static abstract class a {

        /* renamed from: com.withpersona.sdk2.inquiry.launchers.DocumentsSelectWorker$a$a  reason: collision with other inner class name */
        public static final class C0321a extends a {

            /* renamed from: a  reason: collision with root package name */
            public static final C0321a f26944a = new C0321a();

            private C0321a() {
                super((DefaultConstructorMarker) null);
            }
        }

        public static final class b extends a {

            /* renamed from: a  reason: collision with root package name */
            private final List<String> f26945a;

            /* renamed from: b  reason: collision with root package name */
            private final Error f26946b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(List<String> list, Error error) {
                super((DefaultConstructorMarker) null);
                kotlin.jvm.internal.j.g(list, "absoluteFilePaths");
                kotlin.jvm.internal.j.g(error, JingleReason.ELEMENT);
                this.f26945a = list;
                this.f26946b = error;
            }

            public final List<String> a() {
                return this.f26945a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof b)) {
                    return false;
                }
                b bVar = (b) obj;
                return kotlin.jvm.internal.j.b(this.f26945a, bVar.f26945a) && this.f26946b == bVar.f26946b;
            }

            public int hashCode() {
                return (this.f26945a.hashCode() * 31) + this.f26946b.hashCode();
            }

            public String toString() {
                return "Failure(absoluteFilePaths=" + this.f26945a + ", reason=" + this.f26946b + PropertyUtils.MAPPED_DELIM2;
            }
        }

        public static final class c extends a {

            /* renamed from: a  reason: collision with root package name */
            private final List<String> f26947a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c(List<String> list) {
                super((DefaultConstructorMarker) null);
                kotlin.jvm.internal.j.g(list, "absoluteFilePaths");
                this.f26947a = list;
            }

            public final List<String> a() {
                return this.f26947a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof c) && kotlin.jvm.internal.j.b(this.f26947a, ((c) obj).f26947a);
            }

            public int hashCode() {
                return this.f26947a.hashCode();
            }

            public String toString() {
                return "Success(absoluteFilePaths=" + this.f26947a + PropertyUtils.MAPPED_DELIM2;
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public DocumentsSelectWorker(String str, Context context, Function0<Unit> function0) {
        kotlin.jvm.internal.j.g(str, SDKConstants.PARAM_KEY);
        kotlin.jvm.internal.j.g(context, IdentityHttpResponse.CONTEXT);
        kotlin.jvm.internal.j.g(function0, "launchPicker");
        this.f26935b = str;
        this.f26936c = context;
        this.f26937d = function0;
    }

    public boolean a(j<?> jVar) {
        kotlin.jvm.internal.j.g(jVar, "otherWorker");
        if (!(jVar instanceof DocumentsSelectWorker) || !kotlin.jvm.internal.j.b(this.f26935b, ((DocumentsSelectWorker) jVar).f26935b)) {
            return false;
        }
        return true;
    }

    public b<a> run() {
        return d.y(d.v(new DocumentsSelectWorker$run$1(this, (kotlin.coroutines.c<? super DocumentsSelectWorker$run$1>) null)), x0.b());
    }
}
