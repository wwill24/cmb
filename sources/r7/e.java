package r7;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.image_loader.ImageLoaderContract;
import com.coffeemeetsbagel.image_loader.b;
import com.facebook.shimmer.Shimmer;
import com.facebook.shimmer.ShimmerFrameLayout;
import java.util.Arrays;
import java.util.Collections;
import kotlin.Unit;
import lc.c;
import w9.b;

public abstract class e extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private LayoutInflater f17376a;

    /* renamed from: b  reason: collision with root package name */
    private Context f17377b;

    /* renamed from: c  reason: collision with root package name */
    private final int f17378c;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        View f17379a;

        /* renamed from: b  reason: collision with root package name */
        ImageView f17380b;

        a() {
        }
    }

    public e(Context context, int i10) {
        this.f17377b = context;
        this.f17376a = LayoutInflater.from(context);
        this.f17378c = c.d() / i10;
    }

    private void d(ShimmerFrameLayout shimmerFrameLayout) {
        if (shimmerFrameLayout.isShimmerStarted()) {
            shimmerFrameLayout.setShimmer(((Shimmer.AlphaHighlightBuilder) ((Shimmer.AlphaHighlightBuilder) new Shimmer.AlphaHighlightBuilder().setBaseAlpha(1.0f)).setIntensity(0.0f)).build());
            shimmerFrameLayout.stopShimmer();
            shimmerFrameLayout.clearAnimation();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit e(ShimmerFrameLayout shimmerFrameLayout) {
        d(shimmerFrameLayout);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit f(ShimmerFrameLayout shimmerFrameLayout, Bitmap bitmap) {
        d(shimmerFrameLayout);
        return null;
    }

    public abstract String c(int i10);

    public View getView(int i10, View view, ViewGroup viewGroup) {
        View view2;
        if (view == null) {
            view2 = this.f17376a.inflate(R.layout.griditem_photo, (ViewGroup) null);
            a aVar = new a();
            aVar.f17379a = view2;
            aVar.f17380b = (ImageView) view2.findViewById(R.id.imageView_photo);
            view2.setTag(aVar);
        } else {
            view2 = view;
        }
        a aVar2 = (a) view2.getTag();
        String c10 = c(i10);
        if (!TextUtils.isEmpty(c10)) {
            ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) aVar2.f17380b.getParent();
            shimmerFrameLayout.startShimmer();
            b bVar = b.f13967a;
            Context context = this.f17377b;
            ImageView imageView = aVar2.f17380b;
            Integer valueOf = Integer.valueOf(R.drawable.icon_photo_placement_s);
            int i11 = this.f17378c;
            bVar.b(context, c10, imageView, valueOf, (Integer) null, new ImageLoaderContract.b(i11, i11), Arrays.asList(new b.a[]{b.a.f18329a}), Collections.emptyMap(), new c(this, shimmerFrameLayout), new d(this, shimmerFrameLayout), (Bitmap.Config) null, (ImageLoaderContract.ImageBucketSize) null, new ImageLoaderContract.MemoryConfig[0]);
            aVar2.f17379a.setMinimumHeight(this.f17378c);
            aVar2.f17379a.setMinimumWidth(this.f17378c);
            aVar2.f17380b.setMinimumWidth(this.f17378c);
            aVar2.f17380b.setMinimumHeight(this.f17378c);
            view2.setVisibility(0);
        } else {
            view2.setVisibility(8);
        }
        return view2;
    }
}
