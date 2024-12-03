package b5;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.coffeemeetsbagel.view.CmbToolbar;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class c implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f7835a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Drawable f7836b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Drawable f7837c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f7838d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ CmbToolbar f7839e;

    public /* synthetic */ c(Context context, Drawable drawable, Drawable drawable2, boolean z10, CmbToolbar cmbToolbar) {
        this.f7835a = context;
        this.f7836b = drawable;
        this.f7837c = drawable2;
        this.f7838d = z10;
        this.f7839e = cmbToolbar;
    }

    public final Object invoke(Object obj) {
        return e.j(this.f7836b, new BitmapDrawable(this.f7835a.getResources(), (Bitmap) obj), this.f7837c, this.f7838d, false, this.f7839e);
    }
}
