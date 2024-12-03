package coil.util;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import coil.request.CachePolicy;
import coil.request.g;
import coil.size.Precision;
import coil.size.ViewSizeResolver;
import coil.size.d;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineDispatcher;
import net.bytebuddy.asm.Advice;
import p2.b;
import r2.c;

@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a5\u0010\u0006\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\"\u001a\u0010\r\u001a\u00020\b8\u0000X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0018\u0010\u0010\u001a\u00020\u000e*\u00020\u00008@X\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcoil/request/g;", "Landroid/graphics/drawable/Drawable;", "drawable", "", "resId", "default", "c", "(Lcoil/request/g;Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;", "Lcoil/request/a;", "a", "Lcoil/request/a;", "b", "()Lcoil/request/a;", "DEFAULT_REQUEST_OPTIONS", "", "(Lcoil/request/g;)Z", "allowInexactSize", "coil-base_release"}, k = 2, mv = {1, 7, 1})
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static final coil.request.a f8424a = new coil.request.a((CoroutineDispatcher) null, (CoroutineDispatcher) null, (CoroutineDispatcher) null, (CoroutineDispatcher) null, (c.a) null, (Precision) null, (Bitmap.Config) null, false, false, (Drawable) null, (Drawable) null, (Drawable) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, Advice.MethodSizeHandler.UNDEFINED_SIZE, (DefaultConstructorMarker) null);

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f8425a;

        static {
            int[] iArr = new int[Precision.values().length];
            iArr[Precision.EXACT.ordinal()] = 1;
            iArr[Precision.INEXACT.ordinal()] = 2;
            iArr[Precision.AUTOMATIC.ordinal()] = 3;
            f8425a = iArr;
        }
    }

    public static final boolean a(g gVar) {
        int i10 = a.f8425a[gVar.H().ordinal()];
        if (i10 == 1) {
            return false;
        }
        if (i10 != 2) {
            if (i10 != 3) {
                throw new NoWhenBranchMatchedException();
            } else if ((gVar.q().m() != null || !(gVar.K() instanceof d)) && (!(gVar.M() instanceof b) || !(gVar.K() instanceof ViewSizeResolver) || !(((b) gVar.M()).getView() instanceof ImageView) || ((b) gVar.M()).getView() != ((ViewSizeResolver) gVar.K()).getView())) {
                return false;
            }
        }
        return true;
    }

    public static final coil.request.a b() {
        return f8424a;
    }

    public static final Drawable c(g gVar, Drawable drawable, Integer num, Drawable drawable2) {
        if (drawable != null) {
            return drawable;
        }
        if (num == null) {
            return drawable2;
        }
        if (num.intValue() == 0) {
            return null;
        }
        return d.a(gVar.l(), num.intValue());
    }
}
