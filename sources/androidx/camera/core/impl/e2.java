package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.v1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class e2 {

    /* renamed from: a  reason: collision with root package name */
    private final String f2509a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, b> f2510b = new LinkedHashMap();

    private interface a {
        boolean a(b bVar);
    }

    private static final class b {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final SessionConfig f2511a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        private final f2<?> f2512b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f2513c = false;

        /* renamed from: d  reason: collision with root package name */
        private boolean f2514d = false;

        b(@NonNull SessionConfig sessionConfig, @NonNull f2<?> f2Var) {
            this.f2511a = sessionConfig;
            this.f2512b = f2Var;
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return this.f2514d;
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            return this.f2513c;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public SessionConfig c() {
            return this.f2511a;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public f2<?> d() {
            return this.f2512b;
        }

        /* access modifiers changed from: package-private */
        public void e(boolean z10) {
            this.f2514d = z10;
        }

        /* access modifiers changed from: package-private */
        public void f(boolean z10) {
            this.f2513c = z10;
        }
    }

    public e2(@NonNull String str) {
        this.f2509a = str;
    }

    private b i(@NonNull String str, @NonNull SessionConfig sessionConfig, @NonNull f2<?> f2Var) {
        b bVar = this.f2510b.get(str);
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b(sessionConfig, f2Var);
        this.f2510b.put(str, bVar2);
        return bVar2;
    }

    private Collection<SessionConfig> j(a aVar) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : this.f2510b.entrySet()) {
            if (aVar == null || aVar.a((b) next.getValue())) {
                arrayList.add(((b) next.getValue()).c());
            }
        }
        return arrayList;
    }

    private Collection<f2<?>> k(a aVar) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : this.f2510b.entrySet()) {
            if (aVar == null || aVar.a((b) next.getValue())) {
                arrayList.add(((b) next.getValue()).d());
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean m(b bVar) {
        return bVar.a() && bVar.b();
    }

    @NonNull
    public SessionConfig.f d() {
        SessionConfig.f fVar = new SessionConfig.f();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : this.f2510b.entrySet()) {
            b bVar = (b) next.getValue();
            if (bVar.a() && bVar.b()) {
                fVar.a(bVar.c());
                arrayList.add((String) next.getKey());
            }
        }
        v1.a("UseCaseAttachState", "Active and attached use case: " + arrayList + " for camera: " + this.f2509a);
        return fVar;
    }

    @NonNull
    public Collection<SessionConfig> e() {
        return Collections.unmodifiableCollection(j(new d2()));
    }

    @NonNull
    public SessionConfig.f f() {
        SessionConfig.f fVar = new SessionConfig.f();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : this.f2510b.entrySet()) {
            b bVar = (b) next.getValue();
            if (bVar.b()) {
                fVar.a(bVar.c());
                arrayList.add((String) next.getKey());
            }
        }
        v1.a("UseCaseAttachState", "All use case: " + arrayList + " for camera: " + this.f2509a);
        return fVar;
    }

    @NonNull
    public Collection<SessionConfig> g() {
        return Collections.unmodifiableCollection(j(new b2()));
    }

    @NonNull
    public Collection<f2<?>> h() {
        return Collections.unmodifiableCollection(k(new c2()));
    }

    public boolean l(@NonNull String str) {
        if (!this.f2510b.containsKey(str)) {
            return false;
        }
        return this.f2510b.get(str).b();
    }

    public void p(@NonNull String str) {
        this.f2510b.remove(str);
    }

    public void q(@NonNull String str, @NonNull SessionConfig sessionConfig, @NonNull f2<?> f2Var) {
        i(str, sessionConfig, f2Var).e(true);
    }

    public void r(@NonNull String str, @NonNull SessionConfig sessionConfig, @NonNull f2<?> f2Var) {
        i(str, sessionConfig, f2Var).f(true);
    }

    public void s(@NonNull String str) {
        if (this.f2510b.containsKey(str)) {
            b bVar = this.f2510b.get(str);
            bVar.f(false);
            if (!bVar.a()) {
                this.f2510b.remove(str);
            }
        }
    }

    public void t(@NonNull String str) {
        if (this.f2510b.containsKey(str)) {
            b bVar = this.f2510b.get(str);
            bVar.e(false);
            if (!bVar.b()) {
                this.f2510b.remove(str);
            }
        }
    }

    public void u(@NonNull String str, @NonNull SessionConfig sessionConfig, @NonNull f2<?> f2Var) {
        if (this.f2510b.containsKey(str)) {
            b bVar = new b(sessionConfig, f2Var);
            b bVar2 = this.f2510b.get(str);
            bVar.f(bVar2.b());
            bVar.e(bVar2.a());
            this.f2510b.put(str, bVar);
        }
    }
}
