package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;

public class e implements r {

    /* renamed from: a  reason: collision with root package name */
    final r f6495a;

    /* renamed from: b  reason: collision with root package name */
    int f6496b = 0;

    /* renamed from: c  reason: collision with root package name */
    int f6497c = -1;

    /* renamed from: d  reason: collision with root package name */
    int f6498d = -1;

    /* renamed from: e  reason: collision with root package name */
    Object f6499e = null;

    public e(@NonNull r rVar) {
        this.f6495a = rVar;
    }

    public void a(int i10, int i11) {
        int i12;
        if (this.f6496b == 1 && i10 >= (i12 = this.f6497c)) {
            int i13 = this.f6498d;
            if (i10 <= i12 + i13) {
                this.f6498d = i13 + i11;
                this.f6497c = Math.min(i10, i12);
                return;
            }
        }
        e();
        this.f6497c = i10;
        this.f6498d = i11;
        this.f6496b = 1;
    }

    public void b(int i10, int i11) {
        int i12;
        if (this.f6496b != 2 || (i12 = this.f6497c) < i10 || i12 > i10 + i11) {
            e();
            this.f6497c = i10;
            this.f6498d = i11;
            this.f6496b = 2;
            return;
        }
        this.f6498d += i11;
        this.f6497c = i10;
    }

    @SuppressLint({"UnknownNullness"})
    public void c(int i10, int i11, Object obj) {
        int i12;
        if (this.f6496b == 3) {
            int i13 = this.f6497c;
            int i14 = this.f6498d;
            if (i10 <= i13 + i14 && (i12 = i10 + i11) >= i13 && this.f6499e == obj) {
                this.f6497c = Math.min(i10, i13);
                this.f6498d = Math.max(i14 + i13, i12) - this.f6497c;
                return;
            }
        }
        e();
        this.f6497c = i10;
        this.f6498d = i11;
        this.f6499e = obj;
        this.f6496b = 3;
    }

    public void d(int i10, int i11) {
        e();
        this.f6495a.d(i10, i11);
    }

    public void e() {
        int i10 = this.f6496b;
        if (i10 != 0) {
            if (i10 == 1) {
                this.f6495a.a(this.f6497c, this.f6498d);
            } else if (i10 == 2) {
                this.f6495a.b(this.f6497c, this.f6498d);
            } else if (i10 == 3) {
                this.f6495a.c(this.f6497c, this.f6498d, this.f6499e);
            }
            this.f6499e = null;
            this.f6496b = 0;
        }
    }
}
