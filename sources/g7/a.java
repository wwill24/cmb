package g7;

import com.coffeemeetsbagel.match.j;

public class a implements j.e {

    /* renamed from: a  reason: collision with root package name */
    private final int f15195a;

    /* renamed from: b  reason: collision with root package name */
    private final j.e f15196b;

    /* renamed from: c  reason: collision with root package name */
    private int f15197c;

    public a(int i10, j.e eVar) {
        this.f15195a = i10;
        this.f15196b = eVar;
    }

    public void a(boolean z10) {
        int i10 = this.f15197c + 1;
        this.f15197c = i10;
        if (i10 == this.f15195a) {
            this.f15196b.a(z10);
        }
    }
}
