package androidx.work.impl;

import g2.m;
import g2.u;
import g2.x;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rR\u0014\u0010\u0011\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0010R \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0013¨\u0006\u0017"}, d2 = {"Landroidx/work/impl/w;", "", "Lg2/m;", "id", "Landroidx/work/impl/v;", "d", "b", "", "workSpecId", "", "c", "", "a", "Lg2/u;", "spec", "e", "Ljava/lang/Object;", "lock", "", "Ljava/util/Map;", "runs", "<init>", "()V", "work-runtime_release"}, k = 1, mv = {1, 7, 1})
public final class w {

    /* renamed from: a  reason: collision with root package name */
    private final Object f7638a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final Map<m, v> f7639b = new LinkedHashMap();

    public final boolean a(m mVar) {
        boolean containsKey;
        j.g(mVar, "id");
        synchronized (this.f7638a) {
            containsKey = this.f7639b.containsKey(mVar);
        }
        return containsKey;
    }

    public final v b(m mVar) {
        v remove;
        j.g(mVar, "id");
        synchronized (this.f7638a) {
            remove = this.f7639b.remove(mVar);
        }
        return remove;
    }

    public final List<v> c(String str) {
        List<v> x02;
        j.g(str, "workSpecId");
        synchronized (this.f7638a) {
            Map<m, v> map = this.f7639b;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry next : map.entrySet()) {
                if (j.b(((m) next.getKey()).b(), str)) {
                    linkedHashMap.put(next.getKey(), next.getValue());
                }
            }
            for (m remove : linkedHashMap.keySet()) {
                this.f7639b.remove(remove);
            }
            x02 = CollectionsKt___CollectionsKt.x0(linkedHashMap.values());
        }
        return x02;
    }

    public final v d(m mVar) {
        v vVar;
        j.g(mVar, "id");
        synchronized (this.f7638a) {
            Map<m, v> map = this.f7639b;
            v vVar2 = map.get(mVar);
            if (vVar2 == null) {
                vVar2 = new v(mVar);
                map.put(mVar, vVar2);
            }
            vVar = vVar2;
        }
        return vVar;
    }

    public final v e(u uVar) {
        j.g(uVar, "spec");
        return d(x.a(uVar));
    }
}
