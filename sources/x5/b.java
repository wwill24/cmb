package x5;

import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.j;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final String f18558a;

    /* renamed from: b  reason: collision with root package name */
    private final Drawable f18559b;

    /* renamed from: c  reason: collision with root package name */
    private final int f18560c;

    /* renamed from: d  reason: collision with root package name */
    private String f18561d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f18562e;

    public b(String str, Drawable drawable, int i10, String str2, boolean z10) {
        j.g(str, "title");
        this.f18558a = str;
        this.f18559b = drawable;
        this.f18560c = i10;
        this.f18561d = str2;
        this.f18562e = z10;
    }

    public final String a() {
        return this.f18561d;
    }

    public final Drawable b() {
        return this.f18559b;
    }

    public final int c() {
        return this.f18560c;
    }

    public final void d(String str) {
        this.f18561d = str;
    }

    public final void e(boolean z10) {
        this.f18562e = z10;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!j.b(this.f18558a, bVar.g()) || !j.b(this.f18559b, bVar.b()) || this.f18560c != bVar.c() || !j.b(this.f18561d, bVar.a())) {
            return false;
        }
        return true;
    }

    public final Boolean f() {
        return Boolean.valueOf(this.f18562e);
    }

    public final String g() {
        return this.f18558a;
    }

    public int hashCode() {
        int i10;
        int hashCode = this.f18558a.hashCode() * 31;
        Drawable drawable = this.f18559b;
        int i11 = 0;
        if (drawable != null) {
            i10 = drawable.hashCode();
        } else {
            i10 = 0;
        }
        int i12 = (((hashCode + i10) * 31) + this.f18560c) * 31;
        String str = this.f18561d;
        if (str != null) {
            i11 = str.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "CmbBottomNavItem{title=" + this.f18558a + ", icon=" + this.f18559b + ", resId=" + this.f18560c + ", badge=" + this.f18561d + '}';
    }
}
