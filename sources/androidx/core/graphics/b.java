package androidx.core.graphics;

import android.graphics.Insets;
import android.graphics.Rect;
import androidx.annotation.NonNull;

public final class b {
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public static final b f4587e = new b(0, 0, 0, 0);

    /* renamed from: a  reason: collision with root package name */
    public final int f4588a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4589b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4590c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4591d;

    static class a {
        static Insets a(int i10, int i11, int i12, int i13) {
            return Insets.of(i10, i11, i12, i13);
        }
    }

    private b(int i10, int i11, int i12, int i13) {
        this.f4588a = i10;
        this.f4589b = i11;
        this.f4590c = i12;
        this.f4591d = i13;
    }

    @NonNull
    public static b a(@NonNull b bVar, @NonNull b bVar2) {
        return b(Math.max(bVar.f4588a, bVar2.f4588a), Math.max(bVar.f4589b, bVar2.f4589b), Math.max(bVar.f4590c, bVar2.f4590c), Math.max(bVar.f4591d, bVar2.f4591d));
    }

    @NonNull
    public static b b(int i10, int i11, int i12, int i13) {
        if (i10 == 0 && i11 == 0 && i12 == 0 && i13 == 0) {
            return f4587e;
        }
        return new b(i10, i11, i12, i13);
    }

    @NonNull
    public static b c(@NonNull Rect rect) {
        return b(rect.left, rect.top, rect.right, rect.bottom);
    }

    @NonNull
    public static b d(@NonNull Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }

    @NonNull
    public Insets e() {
        return a.a(this.f4588a, this.f4589b, this.f4590c, this.f4591d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f4591d == bVar.f4591d && this.f4588a == bVar.f4588a && this.f4590c == bVar.f4590c && this.f4589b == bVar.f4589b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f4588a * 31) + this.f4589b) * 31) + this.f4590c) * 31) + this.f4591d;
    }

    @NonNull
    public String toString() {
        return "Insets{left=" + this.f4588a + ", top=" + this.f4589b + ", right=" + this.f4590c + ", bottom=" + this.f4591d + '}';
    }
}
