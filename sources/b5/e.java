package b5;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.widget.ImageView;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.image_loader.ImageLoaderContract;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.view.CmbToolbar;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import lc.j;
import w9.b;

public class e {
    /* access modifiers changed from: private */
    public static /* synthetic */ Unit h(Context context, int i10, Drawable drawable, Drawable drawable2, boolean z10, CmbToolbar cmbToolbar) {
        Drawable drawable3 = drawable;
        j(drawable3, new BitmapDrawable(context.getResources(), Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_bottombar_profile), i10, i10, true)), drawable2, z10, false, cmbToolbar);
        return null;
    }

    private static void i(Drawable drawable, Drawable drawable2, CmbToolbar cmbToolbar) {
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable2, drawable});
        int intrinsicWidth = drawable2.getIntrinsicWidth() - drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable2.getIntrinsicHeight() - drawable.getIntrinsicHeight();
        int intrinsicHeight2 = drawable.getIntrinsicHeight() / 2;
        int intrinsicWidth2 = drawable.getIntrinsicWidth() / 2;
        LayerDrawable layerDrawable2 = layerDrawable;
        layerDrawable2.setLayerInset(0, intrinsicWidth2, intrinsicHeight2, intrinsicWidth2, intrinsicHeight2);
        layerDrawable2.setLayerInset(1, intrinsicWidth, 0, 0, intrinsicHeight);
        if (cmbToolbar != null) {
            cmbToolbar.setLeftIcon(layerDrawable);
        }
    }

    /* access modifiers changed from: private */
    public static void j(Drawable drawable, Drawable drawable2, Drawable drawable3, boolean z10, boolean z11, CmbToolbar cmbToolbar) {
        if (z10) {
            i(drawable, drawable2, cmbToolbar);
        } else if (z11) {
            i(drawable3, drawable2, cmbToolbar);
        } else if (cmbToolbar != null) {
            cmbToolbar.setLeftIcon(drawable2);
        }
    }

    public static void k(Context context, ProfileContract$Manager profileContract$Manager, CmbToolbar cmbToolbar, boolean z10) {
        NetworkProfile j10 = profileContract$Manager.j();
        Drawable drawable = context.getResources().getDrawable(R.drawable.profile_badge);
        Drawable drawable2 = context.getResources().getDrawable(R.drawable.boost_icon);
        int dimension = (int) context.getResources().getDimension(R.dimen.avatar_size);
        int dimension2 = (int) context.getResources().getDimension(R.dimen.two_dp);
        List asList = Arrays.asList(new b[]{b.a.f18329a, new b.d(dimension2, dimension2, j.f41113a.a(context, R.attr.main_color))});
        if (j10 == null || j10.getPhotos() == null || j10.getPhotos().isEmpty()) {
            l(context, dimension, drawable, drawable2, asList, z10, cmbToolbar);
            return;
        }
        a aVar = new a(context, dimension, drawable, drawable2, asList, z10, cmbToolbar);
        int i10 = dimension;
        b bVar = new b(context, drawable, drawable2, z10, j10, cmbToolbar);
        com.coffeemeetsbagel.image_loader.b.f13967a.b(context, j10.getPhotos().get(0).getUrl(), (ImageView) null, Integer.valueOf(R.drawable.icon_photo_placement_s), (Integer) null, new ImageLoaderContract.b(i10, i10), asList, Collections.emptyMap(), aVar, bVar, (Bitmap.Config) null, (ImageLoaderContract.ImageBucketSize) null, new ImageLoaderContract.MemoryConfig[0]);
    }

    /* access modifiers changed from: private */
    public static void l(Context context, int i10, Drawable drawable, Drawable drawable2, List<b> list, boolean z10, CmbToolbar cmbToolbar) {
        Context context2 = context;
        c cVar = new c(context2, drawable, drawable2, z10, cmbToolbar);
        com.coffeemeetsbagel.image_loader.b.f13967a.a(context2, R.drawable.ic_bottombar_profile, (ImageView) null, new ImageLoaderContract.b(i10, i10), list, new d(context2, i10, drawable, drawable2, z10, cmbToolbar), cVar);
    }
}
