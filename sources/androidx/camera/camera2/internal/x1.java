package androidx.camera.camera2.internal;

import o.c0;

class x1 {

    /* renamed from: a  reason: collision with root package name */
    private final Object f2022a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final c0 f2023b;

    /* renamed from: c  reason: collision with root package name */
    private int f2024c;

    x1(c0 c0Var, int i10) {
        this.f2023b = c0Var;
        this.f2024c = i10;
    }

    public int a() {
        int i10;
        synchronized (this.f2022a) {
            i10 = this.f2024c;
        }
        return i10;
    }

    /* access modifiers changed from: package-private */
    public void b(int i10) {
        synchronized (this.f2022a) {
            this.f2024c = i10;
        }
    }
}
