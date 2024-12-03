package i9;

import ga.e;
import ga.f;
import ga.g;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class c implements f, e.a {

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f15522e = {0, 100, 500, 1000, 1500, 2000};

    /* renamed from: a  reason: collision with root package name */
    private final e f15523a;

    /* renamed from: b  reason: collision with root package name */
    private g f15524b;

    /* renamed from: c  reason: collision with root package name */
    private Set<String> f15525c;

    /* renamed from: d  reason: collision with root package name */
    private List<String> f15526d;

    public c(e eVar, g gVar) {
        this.f15523a = eVar;
        this.f15524b = gVar;
    }

    public void a() {
        ArrayList arrayList = new ArrayList();
        for (int valueOf : f15522e) {
            arrayList.add(Integer.valueOf(valueOf));
        }
        this.f15524b.n(arrayList);
    }

    public void b(Set<String> set) {
        this.f15525c = set;
        if (set.isEmpty()) {
            this.f15526d = new ArrayList(this.f15523a.f());
        } else {
            this.f15526d = new ArrayList(this.f15523a.c(set));
        }
        this.f15524b.U(this.f15526d);
    }

    public void c(String str, String str2) {
        Set<String> set = this.f15525c;
        if (set == null || set.isEmpty() || this.f15525c.contains(str)) {
            this.f15526d.add(str2);
            this.f15524b.U(this.f15526d);
        }
    }

    public void d(int i10) {
        this.f15523a.i(i10);
        this.f15524b.B(i10);
    }

    public void e() {
        this.f15524b.h(this.f15523a.d());
        this.f15524b.v();
    }

    public void start() {
        this.f15523a.h(this);
        this.f15524b.B(this.f15523a.e());
        ArrayList arrayList = new ArrayList(this.f15523a.f());
        this.f15526d = arrayList;
        this.f15524b.U(arrayList);
    }

    public void stop() {
        this.f15523a.g(this);
        this.f15524b = null;
    }
}
