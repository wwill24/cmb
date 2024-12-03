package com.withpersona.sdk2.inquiry.document;

import android.content.Context;
import android.net.Uri;
import android.widget.Toast;
import androidx.activity.result.c;
import androidx.core.content.FileProvider;
import com.mparticle.identity.IdentityHttpResponse;
import com.squareup.workflow1.j;
import com.withpersona.sdk2.inquiry.launchers.s;
import java.io.File;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.b;

public final class DocumentCameraWorker implements j<a> {

    /* renamed from: b  reason: collision with root package name */
    private final c<Uri> f24955b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Context f24956c;

    public static abstract class a {

        /* renamed from: com.withpersona.sdk2.inquiry.document.DocumentCameraWorker$a$a  reason: collision with other inner class name */
        public static final class C0299a extends a {

            /* renamed from: a  reason: collision with root package name */
            public static final C0299a f24961a = new C0299a();

            private C0299a() {
                super((DefaultConstructorMarker) null);
            }
        }

        public static final class b extends a {

            /* renamed from: a  reason: collision with root package name */
            private final String f24962a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(String str) {
                super((DefaultConstructorMarker) null);
                kotlin.jvm.internal.j.g(str, "absoluteFilePath");
                this.f24962a = str;
            }

            public final String a() {
                return this.f24962a;
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public DocumentCameraWorker(c<Uri> cVar, Context context) {
        kotlin.jvm.internal.j.g(cVar, "pictureLauncher");
        kotlin.jvm.internal.j.g(context, IdentityHttpResponse.CONTEXT);
        this.f24955b = cVar;
        this.f24956c = context;
    }

    /* access modifiers changed from: private */
    public final File e() {
        return new File(this.f24956c.getExternalFilesDir(""), "document_camera_photo_time.jpg");
    }

    public boolean a(j<?> jVar) {
        return j.b.a(this, jVar);
    }

    public final boolean d(String str) {
        kotlin.jvm.internal.j.g(str, "errorMessage");
        try {
            Context context = this.f24956c;
            this.f24955b.b(FileProvider.f(context, this.f24956c.getPackageName() + ".persona.provider", e()));
            return true;
        } catch (IllegalArgumentException unused) {
            Toast.makeText(this.f24956c, str, 0).show();
            return false;
        }
    }

    public b<a> run() {
        return new DocumentCameraWorker$run$$inlined$map$1(new s(), this);
    }
}
