package xl;

import cm.f;

public class d extends f {

    /* renamed from: a  reason: collision with root package name */
    private final cm.d[] f24693a;

    /* renamed from: b  reason: collision with root package name */
    private int f24694b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f24695c = -1;

    /* renamed from: d  reason: collision with root package name */
    private boolean f24696d = false;

    public d(cm.d... dVarArr) {
        this.f24693a = dVarArr;
    }

    public f a(int i10) {
        this.f24695c = i10;
        return this;
    }

    public f b(int i10) {
        this.f24694b = i10;
        return this;
    }

    public f e() {
        this.f24696d = true;
        return this;
    }

    public cm.d[] f() {
        return this.f24693a;
    }

    public int g() {
        return this.f24695c;
    }

    public int h() {
        return this.f24694b;
    }

    public boolean i() {
        return this.f24696d;
    }
}
