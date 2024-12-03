package l8;

import android.text.TextUtils;
import hb.c;
import oc.e;
import qj.m;
import qj.w;
import qj.y;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.gson.d f16064a = new com.google.gson.d();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final c f16065b;

    /* renamed from: c  reason: collision with root package name */
    private final m8.a f16066c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f16067d;

    class a implements g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f16068a;

        a(y yVar) {
            this.f16068a = yVar;
        }

        public void a(String str) {
            this.f16068a.onSuccess(str);
            d.this.f16067d = str;
            d.this.f16065b.w("KEY_CHAT_TOKEN", str);
        }

        public void b(String str) {
            this.f16068a.onError(new Throwable(str));
        }
    }

    public d(c cVar, m8.a aVar) {
        this.f16065b = cVar;
        this.f16066c = aVar;
        this.f16067d = cVar.r("KEY_CHAT_TOKEN");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean i(String str) throws Exception {
        return !k(str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j(y yVar) throws Exception {
        this.f16066c.a(new a(yVar));
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean k(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r0 = "\\."
            java.lang.String[] r6 = r6.split(r0)
            r0 = 1
            java.lang.String r1 = new java.lang.String     // Catch:{ Base64DecoderException -> 0x0032 }
            r6 = r6[r0]     // Catch:{ Base64DecoderException -> 0x0032 }
            byte[] r6 = lc.d.a(r6)     // Catch:{ Base64DecoderException -> 0x0032 }
            r1.<init>(r6)     // Catch:{ Base64DecoderException -> 0x0032 }
            com.google.gson.d r6 = r5.f16064a     // Catch:{  }
            java.lang.Class<com.coffeemeetsbagel.feature.mongoose.api.models.ChatTokenDecoded> r2 = com.coffeemeetsbagel.feature.mongoose.api.models.ChatTokenDecoded.class
            java.lang.Object r6 = r6.k(r1, r2)     // Catch:{  }
            com.coffeemeetsbagel.feature.mongoose.api.models.ChatTokenDecoded r6 = (com.coffeemeetsbagel.feature.mongoose.api.models.ChatTokenDecoded) r6     // Catch:{  }
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.MILLISECONDS
            long r2 = r6.getExp()
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.SECONDS
            long r1 = r1.convert(r2, r6)
            long r3 = java.lang.System.currentTimeMillis()
            int r6 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r6 < 0) goto L_0x0031
            goto L_0x0032
        L_0x0031:
            r0 = 0
        L_0x0032:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: l8.d.k(java.lang.String):boolean");
    }

    public void e() {
        this.f16067d = null;
    }

    /* access modifiers changed from: package-private */
    public w<String> f() {
        return h().c(new a(this)).g(w.l(new b(this)));
    }

    /* access modifiers changed from: package-private */
    public w<String> g() {
        return w.k(new c(this)).I(new e(3));
    }

    /* access modifiers changed from: package-private */
    public m<String> h() {
        return TextUtils.isEmpty(this.f16067d) ? m.b() : m.e(this.f16067d);
    }
}
