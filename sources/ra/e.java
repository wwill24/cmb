package ra;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import qj.q;

public abstract class e<Plugin, DynamicDependency> {
    /* access modifiers changed from: private */
    public static /* synthetic */ List g(List list, Object[] objArr) throws Exception {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < objArr.length; i10++) {
            if (Boolean.TRUE.equals(objArr[i10])) {
                arrayList.add((a) list.get(i10));
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean h(List list) throws Exception {
        return !list.isEmpty();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ a i(List list) throws Exception {
        return (a) list.get(0);
    }

    @NonNull
    public q<List<a<Plugin, DynamicDependency>>> d() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (a aVar : f()) {
            if (aVar.d().booleanValue()) {
                arrayList.add(aVar);
                arrayList2.add(aVar.c());
            }
        }
        return q.k(arrayList2, new d(arrayList));
    }

    public q<a<Plugin, DynamicDependency>> e() {
        return d().B(new b()).W(new c());
    }

    /* access modifiers changed from: protected */
    public abstract List<a<Plugin, DynamicDependency>> f();
}
