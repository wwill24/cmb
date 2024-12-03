package fj;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class h<T> implements d<Set<T>> {

    /* renamed from: c  reason: collision with root package name */
    private static final d<Set<Object>> f29649c = e.a(Collections.emptySet());

    /* renamed from: a  reason: collision with root package name */
    private final List<fk.a<T>> f29650a;

    /* renamed from: b  reason: collision with root package name */
    private final List<fk.a<Collection<T>>> f29651b;

    public static final class b<T> {

        /* renamed from: a  reason: collision with root package name */
        private final List<fk.a<T>> f29652a;

        /* renamed from: b  reason: collision with root package name */
        private final List<fk.a<Collection<T>>> f29653b;

        public b<T> a(fk.a<? extends Collection<? extends T>> aVar) {
            this.f29653b.add(aVar);
            return this;
        }

        public b<T> b(fk.a<? extends T> aVar) {
            this.f29652a.add(aVar);
            return this;
        }

        public h<T> c() {
            return new h<>(this.f29652a, this.f29653b);
        }

        private b(int i10, int i11) {
            this.f29652a = b.d(i10);
            this.f29653b = b.d(i11);
        }
    }

    public static <T> b<T> a(int i10, int i11) {
        return new b<>(i10, i11);
    }

    /* renamed from: b */
    public Set<T> get() {
        int size = this.f29650a.size();
        ArrayList arrayList = new ArrayList(this.f29651b.size());
        int size2 = this.f29651b.size();
        for (int i10 = 0; i10 < size2; i10++) {
            Collection collection = (Collection) this.f29651b.get(i10).get();
            size += collection.size();
            arrayList.add(collection);
        }
        HashSet b10 = b.b(size);
        int size3 = this.f29650a.size();
        for (int i11 = 0; i11 < size3; i11++) {
            b10.add(g.b(this.f29650a.get(i11).get()));
        }
        int size4 = arrayList.size();
        for (int i12 = 0; i12 < size4; i12++) {
            for (Object b11 : (Collection) arrayList.get(i12)) {
                b10.add(g.b(b11));
            }
        }
        return Collections.unmodifiableSet(b10);
    }

    private h(List<fk.a<T>> list, List<fk.a<Collection<T>>> list2) {
        this.f29650a = list;
        this.f29651b = list2;
    }
}
