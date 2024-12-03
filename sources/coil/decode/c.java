package coil.decode;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016R\u0017\u0010\u000b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR\u0017\u0010\u000f\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcoil/decode/c;", "", "other", "", "equals", "", "hashCode", "Landroid/graphics/drawable/Drawable;", "a", "Landroid/graphics/drawable/Drawable;", "()Landroid/graphics/drawable/Drawable;", "drawable", "b", "Z", "()Z", "isSampled", "<init>", "(Landroid/graphics/drawable/Drawable;Z)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final Drawable f8090a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f8091b;

    public c(Drawable drawable, boolean z10) {
        this.f8090a = drawable;
        this.f8091b = z10;
    }

    public final Drawable a() {
        return this.f8090a;
    }

    public final boolean b() {
        return this.f8091b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (!j.b(this.f8090a, cVar.f8090a) || this.f8091b != cVar.f8091b) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f8090a.hashCode() * 31) + Boolean.hashCode(this.f8091b);
    }
}
