package com.withpersona.sdk2.inquiry.launchers;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.activity.result.c;
import com.mparticle.identity.IdentityHttpResponse;
import com.squareup.workflow1.j;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.flow.d;
import kotlinx.coroutines.x0;

public final class DocumentSelectWorker implements j<a> {

    /* renamed from: b  reason: collision with root package name */
    private final c<String[]> f26926b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Context f26927c;

    public static abstract class a {

        /* renamed from: com.withpersona.sdk2.inquiry.launchers.DocumentSelectWorker$a$a  reason: collision with other inner class name */
        public static final class C0320a extends a {

            /* renamed from: a  reason: collision with root package name */
            public static final C0320a f26932a = new C0320a();

            private C0320a() {
                super((DefaultConstructorMarker) null);
            }
        }

        public static final class b extends a {

            /* renamed from: a  reason: collision with root package name */
            private final String f26933a;

            /* renamed from: b  reason: collision with root package name */
            private final String f26934b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(String str, String str2) {
                super((DefaultConstructorMarker) null);
                kotlin.jvm.internal.j.g(str, "absoluteFilePath");
                this.f26933a = str;
                this.f26934b = str2;
            }

            public final String a() {
                return this.f26933a;
            }

            public final String b() {
                return this.f26934b;
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public DocumentSelectWorker(c<String[]> cVar, Context context) {
        kotlin.jvm.internal.j.g(cVar, "openDocumentLauncher");
        kotlin.jvm.internal.j.g(context, IdentityHttpResponse.CONTEXT);
        this.f26926b = cVar;
        this.f26927c = context;
    }

    public boolean a(j<?> jVar) {
        return j.b.a(this, jVar);
    }

    public final String c(Uri uri) {
        String str;
        kotlin.jvm.internal.j.g(uri, "file");
        Cursor query = this.f26927c.getContentResolver().query(uri, (String[]) null, (String) null, (String[]) null, (String) null);
        if (query != null) {
            query.moveToFirst();
        }
        if (query != null) {
            str = query.getString(Math.max(query.getColumnIndex("_display_name"), 0));
        } else {
            str = null;
        }
        if (query != null) {
            query.close();
        }
        return str;
    }

    public final void d() {
        this.f26926b.b(new String[]{"image/*", "application/pdf"});
    }

    public b<a> run() {
        return d.y(new DocumentSelectWorker$run$$inlined$map$1(new m(), this), x0.b());
    }
}
