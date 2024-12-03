package b5;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.view.CmbToolbar;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class b implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f7829a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Drawable f7830b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Drawable f7831c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f7832d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ NetworkProfile f7833e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ CmbToolbar f7834f;

    public /* synthetic */ b(Context context, Drawable drawable, Drawable drawable2, boolean z10, NetworkProfile networkProfile, CmbToolbar cmbToolbar) {
        this.f7829a = context;
        this.f7830b = drawable;
        this.f7831c = drawable2;
        this.f7832d = z10;
        this.f7833e = networkProfile;
        this.f7834f = cmbToolbar;
    }

    public final Object invoke(Object obj) {
        return e.j(this.f7830b, new BitmapDrawable(this.f7829a.getResources(), (Bitmap) obj), this.f7831c, this.f7832d, this.f7833e.hasActiveBoost(), this.f7834f);
    }
}
