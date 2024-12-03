package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.z0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public final class r {
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public static final r f2876b = new a().d(0).b();
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public static final r f2877c = new a().d(1).b();

    /* renamed from: a  reason: collision with root package name */
    private LinkedHashSet<p> f2878a;

    r(LinkedHashSet<p> linkedHashSet) {
        this.f2878a = linkedHashSet;
    }

    @NonNull
    public LinkedHashSet<CameraInternal> a(@NonNull LinkedHashSet<CameraInternal> linkedHashSet) {
        ArrayList arrayList = new ArrayList();
        Iterator<CameraInternal> it = linkedHashSet.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().b());
        }
        List<q> b10 = b(arrayList);
        LinkedHashSet<CameraInternal> linkedHashSet2 = new LinkedHashSet<>();
        Iterator<CameraInternal> it2 = linkedHashSet.iterator();
        while (it2.hasNext()) {
            CameraInternal next = it2.next();
            if (b10.contains(next.b())) {
                linkedHashSet2.add(next);
            }
        }
        return linkedHashSet2;
    }

    @NonNull
    public List<q> b(@NonNull List<q> list) {
        List<q> arrayList = new ArrayList<>(list);
        Iterator<p> it = this.f2878a.iterator();
        while (it.hasNext()) {
            arrayList = it.next().b(Collections.unmodifiableList(arrayList));
        }
        arrayList.retainAll(list);
        return arrayList;
    }

    @NonNull
    public LinkedHashSet<p> c() {
        return this.f2878a;
    }

    public Integer d() {
        Iterator<p> it = this.f2878a.iterator();
        Integer num = null;
        while (it.hasNext()) {
            p next = it.next();
            if (next instanceof z0) {
                Integer valueOf = Integer.valueOf(((z0) next).c());
                if (num == null) {
                    num = valueOf;
                } else if (!num.equals(valueOf)) {
                    throw new IllegalStateException("Multiple conflicting lens facing requirements exist.");
                }
            }
        }
        return num;
    }

    @NonNull
    public CameraInternal e(@NonNull LinkedHashSet<CameraInternal> linkedHashSet) {
        Iterator<CameraInternal> it = a(linkedHashSet).iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new IllegalArgumentException("No available camera can be found");
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final LinkedHashSet<p> f2879a;

        public a() {
            this.f2879a = new LinkedHashSet<>();
        }

        @NonNull
        public static a c(@NonNull r rVar) {
            return new a(rVar.c());
        }

        @NonNull
        public a a(@NonNull p pVar) {
            this.f2879a.add(pVar);
            return this;
        }

        @NonNull
        public r b() {
            return new r(this.f2879a);
        }

        @NonNull
        public a d(int i10) {
            this.f2879a.add(new z0(i10));
            return this;
        }

        private a(@NonNull LinkedHashSet<p> linkedHashSet) {
            this.f2879a = new LinkedHashSet<>(linkedHashSet);
        }
    }
}
