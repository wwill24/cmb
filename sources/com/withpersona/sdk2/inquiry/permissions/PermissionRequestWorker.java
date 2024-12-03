package com.withpersona.sdk2.inquiry.permissions;

import android.content.Context;
import androidx.activity.result.c;
import com.mparticle.identity.IdentityHttpResponse;
import com.squareup.workflow1.j;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.d;

public final class PermissionRequestWorker implements j<b> {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final c<String> f27110b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Context f27111c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final Permission f27112d;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Context f27113a;

        /* renamed from: b  reason: collision with root package name */
        private final c<String> f27114b;

        public a(Context context, c<String> cVar) {
            kotlin.jvm.internal.j.g(context, IdentityHttpResponse.CONTEXT);
            kotlin.jvm.internal.j.g(cVar, "requestPermissionsLauncher");
            this.f27113a = context;
            this.f27114b = cVar;
        }

        public final PermissionRequestWorker a(Permission permission) {
            kotlin.jvm.internal.j.g(permission, "permission");
            return new PermissionRequestWorker(this.f27114b, this.f27113a, permission);
        }
    }

    public static abstract class b {

        public static final class a extends b {

            /* renamed from: a  reason: collision with root package name */
            public static final a f27115a = new a();

            private a() {
                super((DefaultConstructorMarker) null);
            }
        }

        /* renamed from: com.withpersona.sdk2.inquiry.permissions.PermissionRequestWorker$b$b  reason: collision with other inner class name */
        public static final class C0322b extends b {

            /* renamed from: a  reason: collision with root package name */
            public static final C0322b f27116a = new C0322b();

            private C0322b() {
                super((DefaultConstructorMarker) null);
            }
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PermissionRequestWorker(c<String> cVar, Context context, Permission permission) {
        kotlin.jvm.internal.j.g(cVar, "requestPermissionsLauncher");
        kotlin.jvm.internal.j.g(context, IdentityHttpResponse.CONTEXT);
        kotlin.jvm.internal.j.g(permission, "permission");
        this.f27110b = cVar;
        this.f27111c = context;
        this.f27112d = permission;
    }

    public boolean a(j<?> jVar) {
        kotlin.jvm.internal.j.g(jVar, "otherWorker");
        if (!(jVar instanceof PermissionRequestWorker) || ((PermissionRequestWorker) jVar).f27112d != this.f27112d) {
            return false;
        }
        return true;
    }

    public kotlinx.coroutines.flow.b<b> run() {
        return d.v(new PermissionRequestWorker$run$1(this, (kotlin.coroutines.c<? super PermissionRequestWorker$run$1>) null));
    }
}
