package androidx.coordinatorlayout.widget;

import androidx.annotation.NonNull;
import androidx.collection.g;
import androidx.core.util.e;
import androidx.core.util.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final e<ArrayList<T>> f4381a = new f(10);

    /* renamed from: b  reason: collision with root package name */
    private final g<T, ArrayList<T>> f4382b = new g<>();

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<T> f4383c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private final HashSet<T> f4384d = new HashSet<>();

    private void e(T t10, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (!arrayList.contains(t10)) {
            if (!hashSet.contains(t10)) {
                hashSet.add(t10);
                ArrayList arrayList2 = this.f4382b.get(t10);
                if (arrayList2 != null) {
                    int size = arrayList2.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        e(arrayList2.get(i10), arrayList, hashSet);
                    }
                }
                hashSet.remove(t10);
                arrayList.add(t10);
                return;
            }
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
    }

    @NonNull
    private ArrayList<T> f() {
        ArrayList<T> acquire = this.f4381a.acquire();
        if (acquire == null) {
            return new ArrayList<>();
        }
        return acquire;
    }

    private void k(@NonNull ArrayList<T> arrayList) {
        arrayList.clear();
        this.f4381a.a(arrayList);
    }

    public void a(@NonNull T t10, @NonNull T t11) {
        if (!this.f4382b.containsKey(t10) || !this.f4382b.containsKey(t11)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList arrayList = this.f4382b.get(t10);
        if (arrayList == null) {
            arrayList = f();
            this.f4382b.put(t10, arrayList);
        }
        arrayList.add(t11);
    }

    public void b(@NonNull T t10) {
        if (!this.f4382b.containsKey(t10)) {
            this.f4382b.put(t10, null);
        }
    }

    public void c() {
        int size = this.f4382b.size();
        for (int i10 = 0; i10 < size; i10++) {
            ArrayList n10 = this.f4382b.n(i10);
            if (n10 != null) {
                k(n10);
            }
        }
        this.f4382b.clear();
    }

    public boolean d(@NonNull T t10) {
        return this.f4382b.containsKey(t10);
    }

    public List g(@NonNull T t10) {
        return this.f4382b.get(t10);
    }

    public List<T> h(@NonNull T t10) {
        int size = this.f4382b.size();
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < size; i10++) {
            ArrayList n10 = this.f4382b.n(i10);
            if (n10 != null && n10.contains(t10)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f4382b.j(i10));
            }
        }
        return arrayList;
    }

    @NonNull
    public ArrayList<T> i() {
        this.f4383c.clear();
        this.f4384d.clear();
        int size = this.f4382b.size();
        for (int i10 = 0; i10 < size; i10++) {
            e(this.f4382b.j(i10), this.f4383c, this.f4384d);
        }
        return this.f4383c;
    }

    public boolean j(@NonNull T t10) {
        int size = this.f4382b.size();
        for (int i10 = 0; i10 < size; i10++) {
            ArrayList n10 = this.f4382b.n(i10);
            if (n10 != null && n10.contains(t10)) {
                return true;
            }
        }
        return false;
    }
}
