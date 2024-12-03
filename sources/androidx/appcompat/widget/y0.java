package androidx.appcompat.widget;

class y0 {

    /* renamed from: a  reason: collision with root package name */
    private int f1498a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f1499b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f1500c = Integer.MIN_VALUE;

    /* renamed from: d  reason: collision with root package name */
    private int f1501d = Integer.MIN_VALUE;

    /* renamed from: e  reason: collision with root package name */
    private int f1502e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f1503f = 0;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1504g = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1505h = false;

    y0() {
    }

    public int a() {
        return this.f1504g ? this.f1498a : this.f1499b;
    }

    public int b() {
        return this.f1498a;
    }

    public int c() {
        return this.f1499b;
    }

    public int d() {
        return this.f1504g ? this.f1499b : this.f1498a;
    }

    public void e(int i10, int i11) {
        this.f1505h = false;
        if (i10 != Integer.MIN_VALUE) {
            this.f1502e = i10;
            this.f1498a = i10;
        }
        if (i11 != Integer.MIN_VALUE) {
            this.f1503f = i11;
            this.f1499b = i11;
        }
    }

    public void f(boolean z10) {
        if (z10 != this.f1504g) {
            this.f1504g = z10;
            if (!this.f1505h) {
                this.f1498a = this.f1502e;
                this.f1499b = this.f1503f;
            } else if (z10) {
                int i10 = this.f1501d;
                if (i10 == Integer.MIN_VALUE) {
                    i10 = this.f1502e;
                }
                this.f1498a = i10;
                int i11 = this.f1500c;
                if (i11 == Integer.MIN_VALUE) {
                    i11 = this.f1503f;
                }
                this.f1499b = i11;
            } else {
                int i12 = this.f1500c;
                if (i12 == Integer.MIN_VALUE) {
                    i12 = this.f1502e;
                }
                this.f1498a = i12;
                int i13 = this.f1501d;
                if (i13 == Integer.MIN_VALUE) {
                    i13 = this.f1503f;
                }
                this.f1499b = i13;
            }
        }
    }

    public void g(int i10, int i11) {
        this.f1500c = i10;
        this.f1501d = i11;
        this.f1505h = true;
        if (this.f1504g) {
            if (i11 != Integer.MIN_VALUE) {
                this.f1498a = i11;
            }
            if (i10 != Integer.MIN_VALUE) {
                this.f1499b = i10;
                return;
            }
            return;
        }
        if (i10 != Integer.MIN_VALUE) {
            this.f1498a = i10;
        }
        if (i11 != Integer.MIN_VALUE) {
            this.f1499b = i11;
        }
    }
}
