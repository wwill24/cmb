package p3;

import androidx.annotation.NonNull;
import androidx.core.util.e;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import f4.j;
import i3.b;
import j3.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import p3.n;

class q<Model, Data> implements n<Model, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final List<n<Model, Data>> f16963a;

    /* renamed from: b  reason: collision with root package name */
    private final e<List<Throwable>> f16964b;

    static class a<Data> implements d<Data>, d.a<Data> {

        /* renamed from: a  reason: collision with root package name */
        private final List<d<Data>> f16965a;

        /* renamed from: b  reason: collision with root package name */
        private final e<List<Throwable>> f16966b;

        /* renamed from: c  reason: collision with root package name */
        private int f16967c = 0;

        /* renamed from: d  reason: collision with root package name */
        private Priority f16968d;

        /* renamed from: e  reason: collision with root package name */
        private d.a<? super Data> f16969e;

        /* renamed from: f  reason: collision with root package name */
        private List<Throwable> f16970f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f16971g;

        a(@NonNull List<d<Data>> list, @NonNull e<List<Throwable>> eVar) {
            this.f16966b = eVar;
            j.c(list);
            this.f16965a = list;
        }

        private void g() {
            if (!this.f16971g) {
                if (this.f16967c < this.f16965a.size() - 1) {
                    this.f16967c++;
                    d(this.f16968d, this.f16969e);
                    return;
                }
                j.d(this.f16970f);
                this.f16969e.c(new GlideException("Fetch failed", (List<Throwable>) new ArrayList(this.f16970f)));
            }
        }

        @NonNull
        public Class<Data> a() {
            return this.f16965a.get(0).a();
        }

        public void b() {
            List<Throwable> list = this.f16970f;
            if (list != null) {
                this.f16966b.a(list);
            }
            this.f16970f = null;
            for (d<Data> b10 : this.f16965a) {
                b10.b();
            }
        }

        public void c(@NonNull Exception exc) {
            ((List) j.d(this.f16970f)).add(exc);
            g();
        }

        public void cancel() {
            this.f16971g = true;
            for (d<Data> cancel : this.f16965a) {
                cancel.cancel();
            }
        }

        public void d(@NonNull Priority priority, @NonNull d.a<? super Data> aVar) {
            this.f16968d = priority;
            this.f16969e = aVar;
            this.f16970f = this.f16966b.acquire();
            this.f16965a.get(this.f16967c).d(priority, this);
            if (this.f16971g) {
                cancel();
            }
        }

        @NonNull
        public DataSource e() {
            return this.f16965a.get(0).e();
        }

        public void f(Data data) {
            if (data != null) {
                this.f16969e.f(data);
            } else {
                g();
            }
        }
    }

    q(@NonNull List<n<Model, Data>> list, @NonNull e<List<Throwable>> eVar) {
        this.f16963a = list;
        this.f16964b = eVar;
    }

    public boolean a(@NonNull Model model) {
        for (n<Model, Data> a10 : this.f16963a) {
            if (a10.a(model)) {
                return true;
            }
        }
        return false;
    }

    public n.a<Data> b(@NonNull Model model, int i10, int i11, @NonNull i3.e eVar) {
        n.a b10;
        int size = this.f16963a.size();
        ArrayList arrayList = new ArrayList(size);
        b bVar = null;
        for (int i12 = 0; i12 < size; i12++) {
            n nVar = this.f16963a.get(i12);
            if (nVar.a(model) && (b10 = nVar.b(model, i10, i11, eVar)) != null) {
                bVar = b10.f16956a;
                arrayList.add(b10.f16958c);
            }
        }
        if (arrayList.isEmpty() || bVar == null) {
            return null;
        }
        return new n.a<>(bVar, new a(arrayList, this.f16964b));
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.f16963a.toArray()) + '}';
    }
}
