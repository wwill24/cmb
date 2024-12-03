package a4;

import androidx.annotation.NonNull;
import i3.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f142a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, List<a<?, ?>>> f143b = new HashMap();

    private static class a<T, R> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<T> f144a;

        /* renamed from: b  reason: collision with root package name */
        final Class<R> f145b;

        /* renamed from: c  reason: collision with root package name */
        final f<T, R> f146c;

        public a(@NonNull Class<T> cls, @NonNull Class<R> cls2, f<T, R> fVar) {
            this.f144a = cls;
            this.f145b = cls2;
            this.f146c = fVar;
        }

        public boolean a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            if (!this.f144a.isAssignableFrom(cls) || !cls2.isAssignableFrom(this.f145b)) {
                return false;
            }
            return true;
        }
    }

    @NonNull
    private synchronized List<a<?, ?>> c(@NonNull String str) {
        List<a<?, ?>> list;
        if (!this.f142a.contains(str)) {
            this.f142a.add(str);
        }
        list = this.f143b.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.f143b.put(str, list);
        }
        return list;
    }

    public synchronized <T, R> void a(@NonNull String str, @NonNull f<T, R> fVar, @NonNull Class<T> cls, @NonNull Class<R> cls2) {
        c(str).add(new a(cls, cls2, fVar));
    }

    @NonNull
    public synchronized <T, R> List<f<T, R>> b(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.f142a) {
            List<a> list = this.f143b.get(str);
            if (list != null) {
                for (a aVar : list) {
                    if (aVar.a(cls, cls2)) {
                        arrayList.add(aVar.f146c);
                    }
                }
            }
        }
        return arrayList;
    }

    @NonNull
    public synchronized <T, R> List<Class<R>> d(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.f142a) {
            List<a> list = this.f143b.get(str);
            if (list != null) {
                for (a aVar : list) {
                    if (aVar.a(cls, cls2) && !arrayList.contains(aVar.f145b)) {
                        arrayList.add(aVar.f145b);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized void e(@NonNull List<String> list) {
        ArrayList<String> arrayList = new ArrayList<>(this.f142a);
        this.f142a.clear();
        for (String add : list) {
            this.f142a.add(add);
        }
        for (String str : arrayList) {
            if (!list.contains(str)) {
                this.f142a.add(str);
            }
        }
    }
}
