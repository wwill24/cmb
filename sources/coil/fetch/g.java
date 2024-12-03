package coil.fetch;

import android.graphics.drawable.Drawable;
import coil.decode.DataSource;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0015\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0013\u001a\u0004\b\t\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcoil/fetch/g;", "Lcoil/fetch/h;", "", "other", "", "equals", "", "hashCode", "Landroid/graphics/drawable/Drawable;", "a", "Landroid/graphics/drawable/Drawable;", "b", "()Landroid/graphics/drawable/Drawable;", "drawable", "Z", "c", "()Z", "isSampled", "Lcoil/decode/DataSource;", "Lcoil/decode/DataSource;", "()Lcoil/decode/DataSource;", "dataSource", "<init>", "(Landroid/graphics/drawable/Drawable;ZLcoil/decode/DataSource;)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class g extends h {

    /* renamed from: a  reason: collision with root package name */
    private final Drawable f8194a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f8195b;

    /* renamed from: c  reason: collision with root package name */
    private final DataSource f8196c;

    public g(Drawable drawable, boolean z10, DataSource dataSource) {
        super((DefaultConstructorMarker) null);
        this.f8194a = drawable;
        this.f8195b = z10;
        this.f8196c = dataSource;
    }

    public final DataSource a() {
        return this.f8196c;
    }

    public final Drawable b() {
        return this.f8194a;
    }

    public final boolean c() {
        return this.f8195b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (j.b(this.f8194a, gVar.f8194a) && this.f8195b == gVar.f8195b && this.f8196c == gVar.f8196c) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return (((this.f8194a.hashCode() * 31) + Boolean.hashCode(this.f8195b)) * 31) + this.f8196c.hashCode();
    }
}
