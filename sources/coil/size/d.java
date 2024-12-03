package coil.size;

import android.content.Context;
import android.util.DisplayMetrics;
import coil.size.c;
import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\n\u001a\u00020\tH\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcoil/size/d;", "Lcoil/size/h;", "Lcoil/size/g;", "b", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "other", "", "equals", "", "hashCode", "Landroid/content/Context;", "a", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class d implements h {

    /* renamed from: a  reason: collision with root package name */
    private final Context f8409a;

    public d(Context context) {
        this.f8409a = context;
    }

    public Object b(c<? super g> cVar) {
        DisplayMetrics displayMetrics = this.f8409a.getResources().getDisplayMetrics();
        c.a a10 = a.a(Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels));
        return new g(a10, a10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d) && j.b(this.f8409a, ((d) obj).f8409a);
    }

    public int hashCode() {
        return this.f8409a.hashCode();
    }
}
