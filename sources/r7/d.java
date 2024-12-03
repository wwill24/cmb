package r7;

import android.graphics.Bitmap;
import com.facebook.shimmer.ShimmerFrameLayout;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class d implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f17374a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ShimmerFrameLayout f17375b;

    public /* synthetic */ d(e eVar, ShimmerFrameLayout shimmerFrameLayout) {
        this.f17374a = eVar;
        this.f17375b = shimmerFrameLayout;
    }

    public final Object invoke(Object obj) {
        return this.f17374a.f(this.f17375b, (Bitmap) obj);
    }
}
