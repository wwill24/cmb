package com.mparticle;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import com.mparticle.c;
import com.mparticle.g0;
import com.mparticle.internal.InternalSession;
import com.mparticle.internal.JsonReportingMessage;
import com.mparticle.internal.Logger;
import com.mparticle.internal.MPUtility;
import com.mparticle.internal.h;
import com.mparticle.internal.j;
import com.mparticle.internal.k;
import com.mparticle.internal.listeners.InternalListenerManager;
import com.mparticle.k0;
import com.mparticle.kits.ReportingMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.json.JSONException;

public class d0 {

    /* renamed from: e  reason: collision with root package name */
    private static c f22275e;

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f22276a;

    /* renamed from: b  reason: collision with root package name */
    private Context f22277b;

    /* renamed from: c  reason: collision with root package name */
    private i f22278c;

    /* renamed from: d  reason: collision with root package name */
    private MParticleOptions f22279d;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f22280a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ s0 f22281b;

        /* renamed from: com.mparticle.d0$a$a  reason: collision with other inner class name */
        class C0254a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Map f22283a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Map f22284b;

            C0254a(Map map, Map map2) {
                this.f22283a = map;
                this.f22284b = map2;
            }

            public void run() {
                a aVar = a.this;
                aVar.f22281b.a(this.f22283a, this.f22284b, Long.valueOf(aVar.f22280a));
            }
        }

        a(long j10, s0 s0Var) {
            this.f22280a = j10;
            this.f22281b = s0Var;
        }

        public void run() {
            new Handler(Looper.getMainLooper()).post(new C0254a(d0.this.c(this.f22280a), d0.this.b(this.f22280a)));
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private String f22286a;

        /* renamed from: b  reason: collision with root package name */
        private Object f22287b;

        /* renamed from: c  reason: collision with root package name */
        private Object f22288c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f22289d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f22290e;

        /* renamed from: f  reason: collision with root package name */
        private long f22291f;

        /* renamed from: g  reason: collision with root package name */
        private long f22292g;

        public b(String str, Object obj, Object obj2, boolean z10, boolean z11, long j10, long j11) {
            this.f22286a = str;
            this.f22287b = obj;
            this.f22288c = obj2;
            this.f22289d = z10;
            this.f22290e = z11;
            this.f22291f = j10;
            this.f22292g = j11;
        }

        public String a() {
            return this.f22286a;
        }

        public long b() {
            return this.f22292g;
        }

        public Object c() {
            return this.f22287b;
        }

        public Object d() {
            return this.f22288c;
        }

        public long e() {
            return this.f22291f;
        }

        public boolean f() {
            return this.f22289d;
        }

        public boolean g() {
            return this.f22290e;
        }
    }

    public interface c {
        void a(c cVar);
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        private int f22293a;

        /* renamed from: b  reason: collision with root package name */
        private String f22294b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f22295c;

        public d(int i10, boolean z10, String str) {
            this.f22293a = i10;
            this.f22294b = str;
            this.f22295c = z10;
        }

        public int a() {
            return this.f22293a;
        }

        public String b() {
            return this.f22294b;
        }

        public boolean c() {
            return this.f22295c;
        }
    }

    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public String f22296a;

        /* renamed from: b  reason: collision with root package name */
        public long f22297b;

        /* renamed from: c  reason: collision with root package name */
        public long f22298c;
    }

    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public Map<String, Object> f22299a;

        /* renamed from: b  reason: collision with root package name */
        public Map<String, List<String>> f22300b;

        /* renamed from: c  reason: collision with root package name */
        public long f22301c;

        /* renamed from: d  reason: collision with root package name */
        public long f22302d;
    }

    public d0(Context context, MParticleOptions mParticleOptions) {
        this.f22277b = context;
        this.f22279d = mParticleOptions;
        this.f22276a = context.getSharedPreferences("mParticlePrefs", 0);
        this.f22278c = new i(context);
    }

    private void f() {
        this.f22276a.edit().putInt("mp::events::counter", 0).apply();
    }

    public void a(long j10, long j11) {
        w c10 = c();
        try {
            c10.b();
            new f().a(c10, j10, j11);
            new g0().a(c10, j10, j11);
            new k0().a(c10, j10, j11);
            new n0().a(c10, j10, j11);
            new t0().a(c10, j10, j11);
            c10.c();
        } finally {
            c10.a();
        }
    }

    public void b(String str, org.json.b bVar) {
        n0.a(c(), bVar, str);
    }

    public w c() {
        return new x(this.f22278c.getWritableDatabase());
    }

    public List<d> d() {
        return q0.b(c());
    }

    public boolean e() {
        return g0.d(c());
    }

    public void b(String str) {
        w c10 = c();
        try {
            c10.b();
            g0.a(c10, str);
            n0.a(c10, str);
            c10.c();
        } finally {
            c10.a();
        }
    }

    public List<String> c(String str) {
        return n0.b(c(), str);
    }

    public Map<String, Object> c(long j10) {
        if (c() == null) {
            return null;
        }
        TreeMap<String, String> b10 = t0.b(c(), j10);
        HashMap hashMap = new HashMap();
        for (Map.Entry next : b10.entrySet()) {
            hashMap.put((String) next.getKey(), MPUtility.toNumberOrString((String) next.getValue()));
        }
        return hashMap;
    }

    public void b(String str, String str2) {
        n0.b(c(), str, str2);
    }

    public void b() {
        q0.a(c());
    }

    public void a(c cVar, String str) throws JSONException {
        f.a(c(), this.f22277b, cVar, str, Long.valueOf(cVar.b()));
    }

    public TreeMap<String, List<String>> b(long j10) {
        if (c() != null) {
            return t0.a(c(), j10);
        }
        return null;
    }

    public void a(c cVar) throws JSONException {
        org.json.a a10 = f.a(c(), this.f22277b, Long.valueOf(cVar.b()));
        if (!MPUtility.isEmpty(a10)) {
            cVar.put(ReportingMessage.MessageType.BREADCRUMB, (Object) a10);
        }
    }

    public void a() {
        g0.a(c());
    }

    public void a(String str, c cVar, String str2, Integer num) throws JSONException {
        g0.a(c(), str, cVar, cVar.b(), str2, num);
        c cVar2 = f22275e;
        if (cVar2 != null) {
            cVar2.a(cVar);
        }
    }

    public void a(com.mparticle.internal.b bVar, com.mparticle.internal.c cVar, String str) throws JSONException {
        w c10 = c();
        c10.b();
        try {
            List<g0.b> b10 = g0.b(c10, str);
            if (b10.size() <= 0) {
                c10.c();
                return;
            }
            HashMap<e, h> a10 = a(b10, c10, bVar, true);
            for (org.json.b a11 : n0.a(c10, a10)) {
                cVar.a(this.f22277b, a11);
            }
            a(a10, c10, cVar, bVar, str, true);
            c10.c();
            c10.a();
        } finally {
            c10.a();
        }
    }

    public void a(com.mparticle.internal.b bVar, com.mparticle.internal.c cVar, String str, boolean z10) throws JSONException {
        w c10 = c();
        c10.b();
        try {
            List<g0.b> b10 = g0.b(c10);
            if (b10.size() <= 0) {
                c10.c();
                c10.a();
                return;
            }
            HashMap<e, h> a10 = a(b10, c10, bVar, false, z10);
            for (k0.b next : k0.a(c10)) {
                h hVar = null;
                h hVar2 = null;
                h hVar3 = null;
                for (Map.Entry next2 : a10.entrySet()) {
                    e eVar = (e) next2.getKey();
                    if (MPUtility.isEqual(eVar.e(), next.d()) && MPUtility.isEqual(Long.valueOf(eVar.d()), next.a())) {
                        hVar = (h) next2.getValue();
                    } else if (MPUtility.isEqual(eVar.e(), next.d())) {
                        hVar2 = (h) next2.getValue();
                    } else {
                        hVar3 = (h) next2.getValue();
                    }
                }
                if (hVar == null) {
                    hVar = hVar2;
                }
                if (hVar != null) {
                    hVar3 = hVar;
                }
                if (hVar3 != null) {
                    hVar3.b(next.b());
                    InternalListenerManager.getListener().onCompositeObjects(next, hVar3);
                    k0.a(c10, next.c());
                }
            }
            for (org.json.b a11 : n0.a(c10, a10)) {
                try {
                    com.mparticle.internal.c cVar2 = cVar;
                    cVar.a(this.f22277b, a11);
                } catch (Throwable th2) {
                    th = th2;
                    c10.a();
                    throw th;
                }
            }
            a((Map<e, h>) a10, c10, cVar, bVar, str, false, z10);
            c10.c();
            c10.a();
        } catch (Throwable th3) {
            th = th3;
            c10.a();
            throw th;
        }
    }

    private HashMap<e, h> a(List<g0.b> list, w wVar, com.mparticle.internal.b bVar, boolean z10) throws JSONException {
        return a(list, wVar, bVar, z10, false);
    }

    private HashMap<e, h> a(List<g0.b> list, w wVar, com.mparticle.internal.b bVar, boolean z10, boolean z11) throws JSONException {
        w wVar2 = wVar;
        HashMap<e, h> hashMap = new HashMap<>();
        Iterator<g0.b> it = list.iterator();
        int i10 = -1;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            g0.b next = it.next();
            e eVar = new e(next);
            h hVar = hashMap.get(eVar);
            if (hVar == null) {
                hVar = a(bVar, true, eVar);
                hashMap.put(eVar, hVar);
            } else {
                com.mparticle.internal.b bVar2 = bVar;
            }
            int length = next.c().length();
            org.json.b bVar3 = new org.json.b(next.c());
            long j10 = (long) length;
            if (hVar.c() + j10 > 204800) {
                break;
            }
            if (z10) {
                hVar.c(bVar3);
            } else {
                hVar.a(bVar3);
            }
            InternalListenerManager.getListener().onCompositeObjects(next, hVar);
            hVar.a(j10);
            i10 = next.d();
        }
        if (z11) {
            g0.b(wVar2, i10);
        } else {
            g0.a(wVar2, i10);
        }
        return hashMap;
    }

    private void a(Map<e, h> map, w wVar, com.mparticle.internal.c cVar, com.mparticle.internal.b bVar, String str, boolean z10) {
        a(map, wVar, cVar, bVar, str, z10, false);
    }

    private void a(Map<e, h> map, w wVar, com.mparticle.internal.c cVar, com.mparticle.internal.b bVar, String str, boolean z10, boolean z11) {
        org.json.a aVar;
        for (Map.Entry next : map.entrySet()) {
            e eVar = (e) next.getKey();
            h hVar = (h) next.getValue();
            if (hVar != null) {
                String e10 = eVar.e();
                if (hVar.a() == null) {
                    hVar.d(cVar.a(this.f22277b));
                }
                if (hVar.b() == null || e10.equals(str)) {
                    hVar.e(cVar.b(this.f22277b));
                }
                if (z10) {
                    aVar = hVar.e();
                } else {
                    aVar = hVar.d();
                }
                hVar.a(a(bVar, aVar, eVar.d()));
                hVar.f(a(aVar, eVar.d()));
                MParticleOptions mParticleOptions = this.f22279d;
                org.json.b bVar2 = hVar;
                if (mParticleOptions != null) {
                    bVar2 = hVar;
                    if (mParticleOptions.getBatchCreationListener() != null) {
                        try {
                            org.json.b onBatchCreated = this.f22279d.getBatchCreationListener().onBatchCreated(hVar);
                            if (onBatchCreated != null) {
                                if (onBatchCreated.length() != 0) {
                                    onBatchCreated.put("mb", true);
                                    bVar2 = onBatchCreated;
                                }
                            }
                            Logger.error("Not uploading batch due to 'onCreateBatch' handler being empty");
                            return;
                        } catch (Exception e11) {
                            Logger.error(e11, "batch creation listener error, original batch will be uploaded");
                            bVar2 = hVar;
                        }
                    }
                }
                q0.a(wVar, bVar2, bVar.j());
                if (!z10 && !z11) {
                    a(str);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        w c10 = c();
        Set<String> c11 = g0.c(c10);
        c11.add(str);
        n0.a(c10, c11);
    }

    private org.json.b a(org.json.a aVar, long j10) {
        org.json.b bVar = null;
        if (aVar != null) {
            for (int i10 = 0; i10 < aVar.o(); i10++) {
                try {
                    if (aVar.j(i10).get("dt").equals("uac")) {
                        bVar = aVar.j(i10).getJSONObject("ua");
                        aVar.j(i10).remove("ua");
                    }
                } catch (NullPointerException | JSONException unused) {
                }
            }
        }
        return bVar == null ? a(j10) : bVar;
    }

    private org.json.a a(com.mparticle.internal.b bVar, org.json.a aVar, long j10) {
        org.json.a aVar2 = null;
        if (aVar != null) {
            for (int i10 = 0; i10 < aVar.o(); i10++) {
                try {
                    if (aVar.j(i10).get("dt").equals("uic")) {
                        aVar2 = aVar.j(i10).getJSONArray("ui");
                        aVar.j(i10).remove("ui");
                    }
                } catch (NullPointerException | JSONException unused) {
                }
            }
        }
        return aVar2 == null ? bVar.e(j10) : aVar2;
    }

    private h a(com.mparticle.internal.b bVar, boolean z10, e eVar) throws JSONException {
        return h.a(z10, bVar, bVar.c(eVar.d()), eVar);
    }

    public void a(String str, long j10, long j11) {
        n0.a(c(), str, j10, j11);
    }

    public void a(String str, String str2) {
        n0.a(c(), str, str2);
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v3, types: [com.mparticle.c] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.mparticle.c a(java.lang.String r15, android.location.Location r16, java.util.Set<java.lang.Long> r17) throws org.json.JSONException {
        /*
            r14 = this;
            r1 = 0
            com.mparticle.w r0 = r14.c()     // Catch:{ all -> 0x0050 }
            r3 = r15
            android.database.Cursor r13 = com.mparticle.n0.c(r0, r15)     // Catch:{ all -> 0x0050 }
            boolean r0 = r13.moveToFirst()     // Catch:{ all -> 0x004d }
            if (r0 == 0) goto L_0x0043
            r0 = 0
            long r4 = r13.getLong(r0)     // Catch:{ all -> 0x004d }
            r0 = 1
            long r6 = r13.getLong(r0)     // Catch:{ all -> 0x004d }
            r0 = 2
            long r8 = r13.getLong(r0)     // Catch:{ all -> 0x004d }
            r0 = 3
            java.lang.String r0 = r13.getString(r0)     // Catch:{ all -> 0x004d }
            if (r0 == 0) goto L_0x002b
            org.json.b r1 = new org.json.b     // Catch:{ all -> 0x004d }
            r1.<init>((java.lang.String) r0)     // Catch:{ all -> 0x004d }
        L_0x002b:
            r10 = r1
            r2 = r14
            r3 = r15
            r11 = r16
            r12 = r17
            com.mparticle.c r1 = r2.a((java.lang.String) r3, (long) r4, (long) r6, (long) r8, (org.json.b) r10, (android.location.Location) r11, (java.util.Set<java.lang.Long>) r12)     // Catch:{ all -> 0x004d }
            java.lang.String r0 = "id"
            java.util.UUID r2 = java.util.UUID.randomUUID()     // Catch:{ all -> 0x004d }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x004d }
            r1.put((java.lang.String) r0, (java.lang.Object) r2)     // Catch:{ all -> 0x004d }
        L_0x0043:
            boolean r0 = r13.isClosed()
            if (r0 != 0) goto L_0x004c
            r13.close()
        L_0x004c:
            return r1
        L_0x004d:
            r0 = move-exception
            r1 = r13
            goto L_0x0051
        L_0x0050:
            r0 = move-exception
        L_0x0051:
            if (r1 == 0) goto L_0x005c
            boolean r2 = r1.isClosed()
            if (r2 != 0) goto L_0x005c
            r1.close()
        L_0x005c:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mparticle.d0.a(java.lang.String, android.location.Location, java.util.Set):com.mparticle.c");
    }

    /* access modifiers changed from: package-private */
    public c a(String str, long j10, long j11, long j12, org.json.b bVar, Location location, Set<Long> set) throws JSONException {
        long j13 = j10;
        long j14 = j11;
        int i10 = this.f22276a.getInt("mp::events::counter", 0);
        f();
        InternalSession internalSession = new InternalSession();
        internalSession.mSessionID = str;
        internalSession.mSessionStartTime = j13;
        org.json.a aVar = new org.json.a();
        long longValue = h.f22319b.longValue();
        for (Long next : set) {
            if (next != h.f22319b) {
                aVar.E(next);
                longValue = next.longValue();
            }
        }
        c a10 = new c.a(ReportingMessage.MessageType.SESSION_END).a(j14).a(bVar).a(internalSession, location, longValue);
        a10.put("en", i10);
        a10.put("sl", j12);
        a10.put("slx", j14 - j13);
        a10.put("cs", (Object) j.n());
        a10.put("smpids", (Object) aVar);
        return a10;
    }

    public void a(c cVar, String str, org.json.b bVar, org.json.b bVar2) throws JSONException {
        c cVar2 = cVar;
        String str2 = str;
        n0.a(c(), cVar2, str2, bVar.toString(), bVar2.toString(), cVar.b());
    }

    public void a(List<JsonReportingMessage> list, long j10) {
        w c10 = c();
        try {
            c10.b();
            for (int i10 = 0; i10 < list.size(); i10++) {
                k0.a(c10, list.get(i10), j10);
            }
            c10.c();
        } catch (Exception e10) {
            Logger.verbose("Error inserting reporting message: " + e10.toString());
        } catch (Throwable th2) {
            c10.a();
            throw th2;
        }
        c10.a();
    }

    public int a(int i10) {
        return q0.a(c(), i10);
    }

    public void a(String str, org.json.b bVar) {
        q0.a(c(), str, bVar);
    }

    public org.json.b a(long j10) {
        Map<String, Object> a10 = a((s0) null, j10);
        org.json.b bVar = new org.json.b();
        for (Map.Entry next : a10.entrySet()) {
            Object value = next.getValue();
            if (next.getValue() instanceof List) {
                org.json.a aVar = new org.json.a();
                for (String E : (List) value) {
                    aVar.E(E);
                }
                try {
                    bVar.put((String) next.getKey(), (Object) aVar);
                } catch (JSONException unused) {
                }
            } else {
                Object value2 = next.getValue();
                if (value2 == null) {
                    value2 = org.json.b.NULL;
                }
                bVar.put((String) next.getKey(), (Object) value2.toString());
            }
        }
        return bVar;
    }

    public Map<String, Object> a(s0 s0Var, long j10) {
        HashMap hashMap = new HashMap();
        if (s0Var == null || Looper.getMainLooper() != Looper.myLooper()) {
            Map<String, Object> c10 = c(j10);
            TreeMap<String, List<String>> b10 = b(j10);
            if (s0Var != null) {
                s0Var.a(c10, b10, Long.valueOf(j10));
            }
            if (c10 != null) {
                hashMap.putAll(c10);
            }
            if (b10 != null) {
                hashMap.putAll(b10);
            }
            return hashMap;
        }
        MParticle instance = MParticle.getInstance();
        if (instance == null) {
            return null;
        }
        instance.Internal().d().m().post(new a(j10, s0Var));
        return null;
    }

    public List<b> a(f fVar) {
        f fVar2 = fVar;
        ArrayList arrayList = new ArrayList();
        if (c() == null) {
            return arrayList;
        }
        Map<String, Object> a10 = a((s0) null, fVar2.f22302d);
        w c10 = c();
        try {
            c10.b();
            long currentTimeMillis = System.currentTimeMillis();
            Map<String, List<String>> map = fVar2.f22300b;
            if (map != null) {
                for (Map.Entry next : map.entrySet()) {
                    String str = (String) next.getKey();
                    List<String> list = (List) next.getValue();
                    Object obj = a10.get(str);
                    if (obj == null || !(obj instanceof List) || !obj.equals(list)) {
                        boolean z10 = t0.a(c10, str, fVar2.f22302d) == 0;
                        for (String a11 : list) {
                            t0.a(c10, str, a11, currentTimeMillis, true, fVar2.f22302d);
                            str = str;
                            obj = obj;
                            list = list;
                        }
                        arrayList.add(new b(str, list, obj, false, z10, fVar2.f22301c, fVar2.f22302d));
                    }
                }
            }
            Map<String, Object> map2 = fVar2.f22299a;
            if (map2 != null) {
                for (Map.Entry next2 : map2.entrySet()) {
                    String str2 = (String) next2.getKey();
                    String obj2 = next2.getValue() != null ? next2.getValue().toString() : null;
                    Object obj3 = a10.get(str2);
                    if (obj3 == null || !(obj3 instanceof String) || !((String) obj3).equalsIgnoreCase(obj2)) {
                        boolean z11 = t0.a(c10, str2, fVar2.f22302d) == 0;
                        t0.a(c10, str2, obj2, currentTimeMillis, false, fVar2.f22302d);
                        arrayList.add(new b(str2, obj2, obj3, false, z11, fVar2.f22301c, fVar2.f22302d));
                    }
                }
            }
            c10.c();
        } catch (Exception e10) {
            Logger.error(e10, "Error while adding user attributes: ", e10.toString());
        } catch (Throwable th2) {
            c10.a();
            throw th2;
        }
        c10.a();
        return arrayList;
    }

    public void a(e eVar, k kVar) {
        e eVar2 = eVar;
        k kVar2 = kVar;
        Map<String, Object> a10 = a((s0) null, eVar2.f22298c);
        w c10 = c();
        try {
            c10.b();
            int a11 = t0.a(c10, eVar2.f22296a, eVar2.f22298c);
            if (kVar2 != null && a11 > 0) {
                kVar2.a(eVar2.f22296a, eVar2.f22298c);
                String str = eVar2.f22296a;
                kVar.a(str, (Object) null, a10.get(str), true, false, eVar2.f22297b, eVar2.f22298c);
            }
            c10.c();
        } catch (Exception unused) {
        } finally {
            c10.a();
        }
    }
}
