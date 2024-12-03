package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private static final Comparator<d> f6556a = new a();

    class a implements Comparator<d> {
        a() {
        }

        /* renamed from: a */
        public int compare(d dVar, d dVar2) {
            return dVar.f6559a - dVar2.f6559a;
        }
    }

    public static abstract class b {
        public abstract boolean a(int i10, int i11);

        public abstract boolean b(int i10, int i11);

        public Object c(int i10, int i11) {
            return null;
        }

        public abstract int d();

        public abstract int e();
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        private final int[] f6557a;

        /* renamed from: b  reason: collision with root package name */
        private final int f6558b;

        c(int i10) {
            int[] iArr = new int[i10];
            this.f6557a = iArr;
            this.f6558b = iArr.length / 2;
        }

        /* access modifiers changed from: package-private */
        public int[] a() {
            return this.f6557a;
        }

        /* access modifiers changed from: package-private */
        public int b(int i10) {
            return this.f6557a[i10 + this.f6558b];
        }

        /* access modifiers changed from: package-private */
        public void c(int i10, int i11) {
            this.f6557a[i10 + this.f6558b] = i11;
        }
    }

    static class d {

        /* renamed from: a  reason: collision with root package name */
        public final int f6559a;

        /* renamed from: b  reason: collision with root package name */
        public final int f6560b;

        /* renamed from: c  reason: collision with root package name */
        public final int f6561c;

        d(int i10, int i11, int i12) {
            this.f6559a = i10;
            this.f6560b = i11;
            this.f6561c = i12;
        }

        /* access modifiers changed from: package-private */
        public int a() {
            return this.f6559a + this.f6561c;
        }

        /* access modifiers changed from: package-private */
        public int b() {
            return this.f6560b + this.f6561c;
        }
    }

    public static class e {

        /* renamed from: a  reason: collision with root package name */
        private final List<d> f6562a;

        /* renamed from: b  reason: collision with root package name */
        private final int[] f6563b;

        /* renamed from: c  reason: collision with root package name */
        private final int[] f6564c;

        /* renamed from: d  reason: collision with root package name */
        private final b f6565d;

        /* renamed from: e  reason: collision with root package name */
        private final int f6566e;

        /* renamed from: f  reason: collision with root package name */
        private final int f6567f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f6568g;

        e(b bVar, List<d> list, int[] iArr, int[] iArr2, boolean z10) {
            this.f6562a = list;
            this.f6563b = iArr;
            this.f6564c = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            this.f6565d = bVar;
            this.f6566e = bVar.e();
            this.f6567f = bVar.d();
            this.f6568g = z10;
            a();
            e();
        }

        private void a() {
            d dVar;
            if (this.f6562a.isEmpty()) {
                dVar = null;
            } else {
                dVar = this.f6562a.get(0);
            }
            if (!(dVar != null && dVar.f6559a == 0 && dVar.f6560b == 0)) {
                this.f6562a.add(0, new d(0, 0, 0));
            }
            this.f6562a.add(new d(this.f6566e, this.f6567f, 0));
        }

        private void d(int i10) {
            int i11;
            int size = this.f6562a.size();
            int i12 = 0;
            for (int i13 = 0; i13 < size; i13++) {
                d dVar = this.f6562a.get(i13);
                while (i12 < dVar.f6560b) {
                    if (this.f6564c[i12] != 0 || !this.f6565d.b(i10, i12)) {
                        i12++;
                    } else {
                        if (this.f6565d.a(i10, i12)) {
                            i11 = 8;
                        } else {
                            i11 = 4;
                        }
                        this.f6563b[i10] = (i12 << 4) | i11;
                        this.f6564c[i12] = (i10 << 4) | i11;
                        return;
                    }
                }
                i12 = dVar.b();
            }
        }

        private void e() {
            int i10;
            for (d next : this.f6562a) {
                for (int i11 = 0; i11 < next.f6561c; i11++) {
                    int i12 = next.f6559a + i11;
                    int i13 = next.f6560b + i11;
                    if (this.f6565d.a(i12, i13)) {
                        i10 = 1;
                    } else {
                        i10 = 2;
                    }
                    this.f6563b[i12] = (i13 << 4) | i10;
                    this.f6564c[i13] = (i12 << 4) | i10;
                }
            }
            if (this.f6568g) {
                f();
            }
        }

        private void f() {
            int i10 = 0;
            for (d next : this.f6562a) {
                while (i10 < next.f6559a) {
                    if (this.f6563b[i10] == 0) {
                        d(i10);
                    }
                    i10++;
                }
                i10 = next.a();
            }
        }

        private static g g(Collection<g> collection, int i10, boolean z10) {
            g gVar;
            Iterator<g> it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    gVar = null;
                    break;
                }
                gVar = it.next();
                if (gVar.f6569a == i10 && gVar.f6571c == z10) {
                    it.remove();
                    break;
                }
            }
            while (it.hasNext()) {
                g next = it.next();
                if (z10) {
                    next.f6570b--;
                } else {
                    next.f6570b++;
                }
            }
            return gVar;
        }

        public void b(@NonNull r rVar) {
            e eVar;
            int i10;
            if (rVar instanceof e) {
                eVar = (e) rVar;
            } else {
                eVar = new e(rVar);
            }
            int i11 = this.f6566e;
            ArrayDeque arrayDeque = new ArrayDeque();
            int i12 = this.f6566e;
            int i13 = this.f6567f;
            for (int size = this.f6562a.size() - 1; size >= 0; size--) {
                d dVar = this.f6562a.get(size);
                int a10 = dVar.a();
                int b10 = dVar.b();
                while (true) {
                    if (i12 <= a10) {
                        break;
                    }
                    i12--;
                    int i14 = this.f6563b[i12];
                    if ((i14 & 12) != 0) {
                        int i15 = i14 >> 4;
                        g g10 = g(arrayDeque, i15, false);
                        if (g10 != null) {
                            int i16 = (i11 - g10.f6570b) - 1;
                            eVar.d(i12, i16);
                            if ((i14 & 4) != 0) {
                                eVar.c(i16, 1, this.f6565d.c(i12, i15));
                            }
                        } else {
                            arrayDeque.add(new g(i12, (i11 - i12) - 1, true));
                        }
                    } else {
                        eVar.b(i12, 1);
                        i11--;
                    }
                }
                while (i13 > b10) {
                    i13--;
                    int i17 = this.f6564c[i13];
                    if ((i17 & 12) != 0) {
                        int i18 = i17 >> 4;
                        g g11 = g(arrayDeque, i18, true);
                        if (g11 == null) {
                            arrayDeque.add(new g(i13, i11 - i12, false));
                        } else {
                            eVar.d((i11 - g11.f6570b) - 1, i12);
                            if ((i17 & 4) != 0) {
                                eVar.c(i12, 1, this.f6565d.c(i18, i13));
                            }
                        }
                    } else {
                        eVar.a(i12, 1);
                        i11++;
                    }
                }
                int i19 = dVar.f6559a;
                int i20 = dVar.f6560b;
                for (i10 = 0; i10 < dVar.f6561c; i10++) {
                    if ((this.f6563b[i19] & 15) == 2) {
                        eVar.c(i19, 1, this.f6565d.c(i19, i20));
                    }
                    i19++;
                    i20++;
                }
                i12 = dVar.f6559a;
                i13 = dVar.f6560b;
            }
            eVar.e();
        }

        public void c(@NonNull RecyclerView.Adapter adapter) {
            b(new b(adapter));
        }
    }

    public static abstract class f<T> {
        public abstract boolean a(@NonNull T t10, @NonNull T t11);

        public abstract boolean b(@NonNull T t10, @NonNull T t11);

        public Object c(@NonNull T t10, @NonNull T t11) {
            return null;
        }
    }

    private static class g {

        /* renamed from: a  reason: collision with root package name */
        int f6569a;

        /* renamed from: b  reason: collision with root package name */
        int f6570b;

        /* renamed from: c  reason: collision with root package name */
        boolean f6571c;

        g(int i10, int i11, boolean z10) {
            this.f6569a = i10;
            this.f6570b = i11;
            this.f6571c = z10;
        }
    }

    /* renamed from: androidx.recyclerview.widget.h$h  reason: collision with other inner class name */
    static class C0073h {

        /* renamed from: a  reason: collision with root package name */
        int f6572a;

        /* renamed from: b  reason: collision with root package name */
        int f6573b;

        /* renamed from: c  reason: collision with root package name */
        int f6574c;

        /* renamed from: d  reason: collision with root package name */
        int f6575d;

        public C0073h() {
        }

        /* access modifiers changed from: package-private */
        public int a() {
            return this.f6575d - this.f6574c;
        }

        /* access modifiers changed from: package-private */
        public int b() {
            return this.f6573b - this.f6572a;
        }

        public C0073h(int i10, int i11, int i12, int i13) {
            this.f6572a = i10;
            this.f6573b = i11;
            this.f6574c = i12;
            this.f6575d = i13;
        }
    }

    static class i {

        /* renamed from: a  reason: collision with root package name */
        public int f6576a;

        /* renamed from: b  reason: collision with root package name */
        public int f6577b;

        /* renamed from: c  reason: collision with root package name */
        public int f6578c;

        /* renamed from: d  reason: collision with root package name */
        public int f6579d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f6580e;

        i() {
        }

        /* access modifiers changed from: package-private */
        public int a() {
            return Math.min(this.f6578c - this.f6576a, this.f6579d - this.f6577b);
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            return this.f6579d - this.f6577b != this.f6578c - this.f6576a;
        }

        /* access modifiers changed from: package-private */
        public boolean c() {
            return this.f6579d - this.f6577b > this.f6578c - this.f6576a;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public d d() {
            if (!b()) {
                int i10 = this.f6576a;
                return new d(i10, this.f6577b, this.f6578c - i10);
            } else if (this.f6580e) {
                return new d(this.f6576a, this.f6577b, a());
            } else {
                if (c()) {
                    return new d(this.f6576a, this.f6577b + 1, a());
                }
                return new d(this.f6576a + 1, this.f6577b, a());
            }
        }
    }

    private static i a(C0073h hVar, b bVar, c cVar, c cVar2, int i10) {
        boolean z10;
        int i11;
        int i12;
        int i13;
        int i14;
        if ((hVar.b() - hVar.a()) % 2 == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        int b10 = hVar.b() - hVar.a();
        int i15 = -i10;
        int i16 = i15;
        while (i16 <= i10) {
            if (i16 == i15 || (i16 != i10 && cVar2.b(i16 + 1) < cVar2.b(i16 - 1))) {
                i12 = cVar2.b(i16 + 1);
                i11 = i12;
            } else {
                i12 = cVar2.b(i16 - 1);
                i11 = i12 - 1;
            }
            int i17 = hVar.f6575d - ((hVar.f6573b - i11) - i16);
            if (i10 == 0 || i11 != i12) {
                i13 = i17;
            } else {
                i13 = i17 + 1;
            }
            while (i11 > hVar.f6572a && i17 > hVar.f6574c && bVar.b(i11 - 1, i17 - 1)) {
                i11--;
                i17--;
            }
            cVar2.c(i16, i11);
            if (!z10 || (i14 = b10 - i16) < i15 || i14 > i10 || cVar.b(i14) < i11) {
                i16 += 2;
            } else {
                i iVar = new i();
                iVar.f6576a = i11;
                iVar.f6577b = i17;
                iVar.f6578c = i12;
                iVar.f6579d = i13;
                iVar.f6580e = true;
                return iVar;
            }
        }
        return null;
    }

    @NonNull
    public static e b(@NonNull b bVar) {
        return c(bVar, true);
    }

    @NonNull
    public static e c(@NonNull b bVar, boolean z10) {
        C0073h hVar;
        int e10 = bVar.e();
        int d10 = bVar.d();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new C0073h(0, e10, 0, d10));
        int i10 = ((((e10 + d10) + 1) / 2) * 2) + 1;
        c cVar = new c(i10);
        c cVar2 = new c(i10);
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            C0073h hVar2 = (C0073h) arrayList2.remove(arrayList2.size() - 1);
            i e11 = e(hVar2, bVar, cVar, cVar2);
            if (e11 != null) {
                if (e11.a() > 0) {
                    arrayList.add(e11.d());
                }
                if (arrayList3.isEmpty()) {
                    hVar = new C0073h();
                } else {
                    hVar = (C0073h) arrayList3.remove(arrayList3.size() - 1);
                }
                hVar.f6572a = hVar2.f6572a;
                hVar.f6574c = hVar2.f6574c;
                hVar.f6573b = e11.f6576a;
                hVar.f6575d = e11.f6577b;
                arrayList2.add(hVar);
                hVar2.f6573b = hVar2.f6573b;
                hVar2.f6575d = hVar2.f6575d;
                hVar2.f6572a = e11.f6578c;
                hVar2.f6574c = e11.f6579d;
                arrayList2.add(hVar2);
            } else {
                arrayList3.add(hVar2);
            }
        }
        Collections.sort(arrayList, f6556a);
        return new e(bVar, arrayList, cVar.a(), cVar2.a(), z10);
    }

    private static i d(C0073h hVar, b bVar, c cVar, c cVar2, int i10) {
        int i11;
        int i12;
        int i13;
        int i14;
        boolean z10 = true;
        if (Math.abs(hVar.b() - hVar.a()) % 2 != 1) {
            z10 = false;
        }
        int b10 = hVar.b() - hVar.a();
        int i15 = -i10;
        int i16 = i15;
        while (i16 <= i10) {
            if (i16 == i15 || (i16 != i10 && cVar.b(i16 + 1) > cVar.b(i16 - 1))) {
                i12 = cVar.b(i16 + 1);
                i11 = i12;
            } else {
                i12 = cVar.b(i16 - 1);
                i11 = i12 + 1;
            }
            int i17 = (hVar.f6574c + (i11 - hVar.f6572a)) - i16;
            if (i10 == 0 || i11 != i12) {
                i13 = i17;
            } else {
                i13 = i17 - 1;
            }
            while (i11 < hVar.f6573b && i17 < hVar.f6575d && bVar.b(i11, i17)) {
                i11++;
                i17++;
            }
            cVar.c(i16, i11);
            if (!z10 || (i14 = b10 - i16) < i15 + 1 || i14 > i10 - 1 || cVar2.b(i14) > i11) {
                i16 += 2;
            } else {
                i iVar = new i();
                iVar.f6576a = i12;
                iVar.f6577b = i13;
                iVar.f6578c = i11;
                iVar.f6579d = i17;
                iVar.f6580e = false;
                return iVar;
            }
        }
        return null;
    }

    private static i e(C0073h hVar, b bVar, c cVar, c cVar2) {
        if (hVar.b() >= 1 && hVar.a() >= 1) {
            int b10 = ((hVar.b() + hVar.a()) + 1) / 2;
            cVar.c(1, hVar.f6572a);
            cVar2.c(1, hVar.f6573b);
            for (int i10 = 0; i10 < b10; i10++) {
                i d10 = d(hVar, bVar, cVar, cVar2, i10);
                if (d10 != null) {
                    return d10;
                }
                i a10 = a(hVar, bVar, cVar, cVar2, i10);
                if (a10 != null) {
                    return a10;
                }
            }
        }
        return null;
    }
}
