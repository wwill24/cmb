package androidx.recyclerview.widget;

import android.view.View;

class z {

    /* renamed from: a  reason: collision with root package name */
    final b f6723a;

    /* renamed from: b  reason: collision with root package name */
    a f6724b = new a();

    static class a {

        /* renamed from: a  reason: collision with root package name */
        int f6725a = 0;

        /* renamed from: b  reason: collision with root package name */
        int f6726b;

        /* renamed from: c  reason: collision with root package name */
        int f6727c;

        /* renamed from: d  reason: collision with root package name */
        int f6728d;

        /* renamed from: e  reason: collision with root package name */
        int f6729e;

        a() {
        }

        /* access modifiers changed from: package-private */
        public void a(int i10) {
            this.f6725a = i10 | this.f6725a;
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            int i10 = this.f6725a;
            if ((i10 & 7) != 0 && (i10 & (c(this.f6728d, this.f6726b) << 0)) == 0) {
                return false;
            }
            int i11 = this.f6725a;
            if ((i11 & 112) != 0 && (i11 & (c(this.f6728d, this.f6727c) << 4)) == 0) {
                return false;
            }
            int i12 = this.f6725a;
            if ((i12 & 1792) != 0 && (i12 & (c(this.f6729e, this.f6726b) << 8)) == 0) {
                return false;
            }
            int i13 = this.f6725a;
            if ((i13 & 28672) == 0 || (i13 & (c(this.f6729e, this.f6727c) << 12)) != 0) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public int c(int i10, int i11) {
            if (i10 > i11) {
                return 1;
            }
            return i10 == i11 ? 2 : 4;
        }

        /* access modifiers changed from: package-private */
        public void d() {
            this.f6725a = 0;
        }

        /* access modifiers changed from: package-private */
        public void e(int i10, int i11, int i12, int i13) {
            this.f6726b = i10;
            this.f6727c = i11;
            this.f6728d = i12;
            this.f6729e = i13;
        }
    }

    interface b {
        View a(int i10);

        int b(View view);

        int c();

        int d();

        int e(View view);
    }

    z(b bVar) {
        this.f6723a = bVar;
    }

    /* access modifiers changed from: package-private */
    public View a(int i10, int i11, int i12, int i13) {
        int i14;
        int c10 = this.f6723a.c();
        int d10 = this.f6723a.d();
        if (i11 > i10) {
            i14 = 1;
        } else {
            i14 = -1;
        }
        View view = null;
        while (i10 != i11) {
            View a10 = this.f6723a.a(i10);
            this.f6724b.e(c10, d10, this.f6723a.b(a10), this.f6723a.e(a10));
            if (i12 != 0) {
                this.f6724b.d();
                this.f6724b.a(i12);
                if (this.f6724b.b()) {
                    return a10;
                }
            }
            if (i13 != 0) {
                this.f6724b.d();
                this.f6724b.a(i13);
                if (this.f6724b.b()) {
                    view = a10;
                }
            }
            i10 += i14;
        }
        return view;
    }

    /* access modifiers changed from: package-private */
    public boolean b(View view, int i10) {
        this.f6724b.e(this.f6723a.c(), this.f6723a.d(), this.f6723a.b(view), this.f6723a.e(view));
        if (i10 == 0) {
            return false;
        }
        this.f6724b.d();
        this.f6724b.a(i10);
        return this.f6724b.b();
    }
}
