package com.withpersona.sdk2.inquiry.sandbox;

import com.squareup.workflow1.ui.r;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import okhttp3.a0;
import okhttp3.u;
import okhttp3.v;
import okhttp3.w;
import okhttp3.y;
import okhttp3.z;
import okio.Buffer;
import org.jivesoftware.smackx.json.packet.JsonPacketExtension;
import org.json.b;
import qi.d;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final C0325a f27161a = new C0325a((DefaultConstructorMarker) null);

    /* renamed from: com.withpersona.sdk2.inquiry.sandbox.a$a  reason: collision with other inner class name */
    public static final class C0325a {
        private C0325a() {
        }

        public /* synthetic */ C0325a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Set<r<?>> a() {
            return m0.d(SandboxScreenRunner.f27156c);
        }
    }

    /* access modifiers changed from: private */
    public static final a0 c(SandboxFlags sandboxFlags, u.a aVar) {
        String str;
        j.g(sandboxFlags, "$flags");
        y g10 = aVar.g();
        z a10 = g10.a();
        List<String> n10 = g10.j().n();
        j.f(n10, "request.url().pathSegments()");
        if (!j.b(CollectionsKt___CollectionsKt.Y(n10), "transition") || a10 == null || !sandboxFlags.b()) {
            return aVar.a(g10);
        }
        String a11 = SandboxFlags.f27148c.a(sandboxFlags.a());
        v b10 = a10.b();
        if (b10 != null) {
            str = b10.h();
        } else {
            str = null;
        }
        if (j.b(str, "form-data")) {
            w wVar = (w) a10;
            w.a e10 = new w.a().e(wVar.b());
            List<w.c> k10 = wVar.k();
            j.f(k10, "body.parts()");
            for (w.c c10 : k10) {
                e10.c(c10);
            }
            return aVar.a(g10.h().h(g10.g(), e10.a("meta[workflowInitialVariables][debugForcedStatus]", a11).d()).b());
        } else if (!j.b(str, JsonPacketExtension.ELEMENT)) {
            return aVar.a(g10);
        } else {
            Buffer buffer = new Buffer();
            a10.i(buffer);
            b bVar = new b(buffer.G());
            b optJSONObject = bVar.optJSONObject("meta");
            if (optJSONObject == null) {
                optJSONObject = new b();
            }
            optJSONObject.put("workflowInitialVariables", (Object) new b().put("debugForcedStatus", (Object) a11));
            bVar.put("meta", (Object) optJSONObject);
            return aVar.a(g10.h().h(g10.g(), z.d(a10.b(), bVar.toString())).b());
        }
    }

    public static final Set<r<?>> d() {
        return f27161a.a();
    }

    public final u b(SandboxFlags sandboxFlags) {
        j.g(sandboxFlags, "flags");
        return new d(sandboxFlags);
    }
}
