package coil.request;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u00002\u00020\u0001B!\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\u0006\u0010\u0016\u001a\u00020\u0012¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u001c\u0010\f\u001a\u0004\u0018\u00010\b8\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u001a\u0010\u0011\u001a\u00020\r8\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcoil/request/d;", "Lcoil/request/h;", "", "other", "", "equals", "", "hashCode", "Landroid/graphics/drawable/Drawable;", "a", "Landroid/graphics/drawable/Drawable;", "()Landroid/graphics/drawable/Drawable;", "drawable", "Lcoil/request/g;", "b", "Lcoil/request/g;", "()Lcoil/request/g;", "request", "", "c", "Ljava/lang/Throwable;", "()Ljava/lang/Throwable;", "throwable", "<init>", "(Landroid/graphics/drawable/Drawable;Lcoil/request/g;Ljava/lang/Throwable;)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class d extends h {

    /* renamed from: a  reason: collision with root package name */
    private final Drawable f8301a;

    /* renamed from: b  reason: collision with root package name */
    private final g f8302b;

    /* renamed from: c  reason: collision with root package name */
    private final Throwable f8303c;

    public d(Drawable drawable, g gVar, Throwable th2) {
        super((DefaultConstructorMarker) null);
        this.f8301a = drawable;
        this.f8302b = gVar;
        this.f8303c = th2;
    }

    public Drawable a() {
        return this.f8301a;
    }

    public g b() {
        return this.f8302b;
    }

    public final Throwable c() {
        return this.f8303c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (!j.b(a(), dVar.a()) || !j.b(b(), dVar.b()) || !j.b(this.f8303c, dVar.f8303c)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i10;
        Drawable a10 = a();
        if (a10 != null) {
            i10 = a10.hashCode();
        } else {
            i10 = 0;
        }
        return (((i10 * 31) + b().hashCode()) * 31) + this.f8303c.hashCode();
    }
}
