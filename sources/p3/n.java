package p3;

import androidx.annotation.NonNull;
import f4.j;
import i3.b;
import i3.e;
import j3.d;
import java.util.Collections;
import java.util.List;

public interface n<Model, Data> {

    public static class a<Data> {

        /* renamed from: a  reason: collision with root package name */
        public final b f16956a;

        /* renamed from: b  reason: collision with root package name */
        public final List<b> f16957b;

        /* renamed from: c  reason: collision with root package name */
        public final d<Data> f16958c;

        public a(@NonNull b bVar, @NonNull d<Data> dVar) {
            this(bVar, Collections.emptyList(), dVar);
        }

        public a(@NonNull b bVar, @NonNull List<b> list, @NonNull d<Data> dVar) {
            this.f16956a = (b) j.d(bVar);
            this.f16957b = (List) j.d(list);
            this.f16958c = (d) j.d(dVar);
        }
    }

    boolean a(@NonNull Model model);

    a<Data> b(@NonNull Model model, int i10, int i11, @NonNull e eVar);
}
