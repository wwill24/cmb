package i4;

import android.content.Context;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.inapp.InAppController;
import com.clevertap.android.sdk.l;
import com.clevertap.android.sdk.m;
import com.clevertap.android.sdk.product_config.CTProductConfigController;
import com.clevertap.android.sdk.pushnotification.j;
import java.util.concurrent.Callable;
import n4.d;

public class i {

    /* renamed from: a  reason: collision with root package name */
    private m f15493a;

    /* renamed from: b  reason: collision with root package name */
    private final com.clevertap.android.sdk.db.a f15494b;

    /* renamed from: c  reason: collision with root package name */
    private k4.a f15495c;

    /* renamed from: d  reason: collision with root package name */
    private m4.a f15496d;

    /* renamed from: e  reason: collision with root package name */
    private d f15497e;

    /* renamed from: f  reason: collision with root package name */
    private final e f15498f;

    /* renamed from: g  reason: collision with root package name */
    private CTProductConfigController f15499g;

    /* renamed from: h  reason: collision with root package name */
    private final b f15500h;

    /* renamed from: i  reason: collision with root package name */
    private final CleverTapInstanceConfig f15501i;

    /* renamed from: j  reason: collision with root package name */
    private final Context f15502j;

    /* renamed from: k  reason: collision with root package name */
    private final l f15503k;

    /* renamed from: l  reason: collision with root package name */
    private InAppController f15504l;

    /* renamed from: m  reason: collision with root package name */
    private j f15505m;

    class a implements Callable<Void> {
        a() {
        }

        /* renamed from: a */
        public Void call() {
            i.this.a();
            return null;
        }
    }

    public i(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, e eVar, b bVar, l lVar, com.clevertap.android.sdk.db.a aVar) {
        this.f15501i = cleverTapInstanceConfig;
        this.f15498f = eVar;
        this.f15500h = bVar;
        this.f15503k = lVar;
        this.f15502j = context;
        this.f15494b = aVar;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a() {
        /*
            r9 = this;
            i4.e r0 = r9.f15498f
            java.lang.Object r0 = r0.b()
            monitor-enter(r0)
            n4.d r1 = r9.e()     // Catch:{ all -> 0x004e }
            if (r1 == 0) goto L_0x0014
            i4.b r1 = r9.f15500h     // Catch:{ all -> 0x004e }
            r1.a()     // Catch:{ all -> 0x004e }
            monitor-exit(r0)     // Catch:{ all -> 0x004e }
            return
        L_0x0014:
            com.clevertap.android.sdk.l r1 = r9.f15503k     // Catch:{ all -> 0x004e }
            java.lang.String r1 = r1.x()     // Catch:{ all -> 0x004e }
            if (r1 == 0) goto L_0x0041
            n4.d r1 = new n4.d     // Catch:{ all -> 0x004e }
            com.clevertap.android.sdk.CleverTapInstanceConfig r3 = r9.f15501i     // Catch:{ all -> 0x004e }
            com.clevertap.android.sdk.l r2 = r9.f15503k     // Catch:{ all -> 0x004e }
            java.lang.String r4 = r2.x()     // Catch:{ all -> 0x004e }
            com.clevertap.android.sdk.db.a r2 = r9.f15494b     // Catch:{ all -> 0x004e }
            android.content.Context r5 = r9.f15502j     // Catch:{ all -> 0x004e }
            com.clevertap.android.sdk.db.DBAdapter r5 = r2.c(r5)     // Catch:{ all -> 0x004e }
            i4.e r6 = r9.f15498f     // Catch:{ all -> 0x004e }
            i4.b r7 = r9.f15500h     // Catch:{ all -> 0x004e }
            boolean r8 = i4.x.f15508a     // Catch:{ all -> 0x004e }
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x004e }
            r9.m(r1)     // Catch:{ all -> 0x004e }
            i4.b r1 = r9.f15500h     // Catch:{ all -> 0x004e }
            r1.a()     // Catch:{ all -> 0x004e }
            goto L_0x004c
        L_0x0041:
            com.clevertap.android.sdk.CleverTapInstanceConfig r1 = r9.f15501i     // Catch:{ all -> 0x004e }
            com.clevertap.android.sdk.p r1 = r1.n()     // Catch:{ all -> 0x004e }
            java.lang.String r2 = "CRITICAL : No device ID found!"
            r1.l(r2)     // Catch:{ all -> 0x004e }
        L_0x004c:
            monitor-exit(r0)     // Catch:{ all -> 0x004e }
            return
        L_0x004e:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004e }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: i4.i.a():void");
    }

    public k4.a c() {
        return this.f15495c;
    }

    public m4.a d() {
        return this.f15496d;
    }

    public d e() {
        return this.f15497e;
    }

    public CTProductConfigController f() {
        return this.f15499g;
    }

    public InAppController g() {
        return this.f15504l;
    }

    public m h() {
        return this.f15493a;
    }

    public j i() {
        return this.f15505m;
    }

    public void j() {
        if (this.f15501i.p()) {
            this.f15501i.n().f(this.f15501i.e(), "Instance is analytics only, not initializing Notification Inbox");
        } else {
            com.clevertap.android.sdk.task.a.a(this.f15501i).c().f("initializeInbox", new a());
        }
    }

    public void k(k4.a aVar) {
        this.f15495c = aVar;
    }

    public void l(m4.a aVar) {
        this.f15496d = aVar;
    }

    public void m(d dVar) {
        this.f15497e = dVar;
    }

    public void n(CTProductConfigController cTProductConfigController) {
        this.f15499g = cTProductConfigController;
    }

    public void o(InAppController inAppController) {
        this.f15504l = inAppController;
    }

    public void p(m mVar) {
        this.f15493a = mVar;
    }

    public void q(j jVar) {
        this.f15505m = jVar;
    }
}
