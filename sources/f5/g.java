package f5;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import androidx.fragment.app.h;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.image_loader.ImageLoaderContract;
import com.coffeemeetsbagel.image_loader.b;
import com.coffeemeetsbagel.models.NetworkPhoto;
import com.facebook.shimmer.Shimmer;
import com.facebook.shimmer.ShimmerFrameLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import lc.c;
import w9.b;

public class g extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final LayoutInflater f14745a;

    /* renamed from: b  reason: collision with root package name */
    private final int f14746b;

    /* renamed from: c  reason: collision with root package name */
    private List<NetworkPhoto> f14747c = new ArrayList();

    static class a {

        /* renamed from: a  reason: collision with root package name */
        View f14748a;

        /* renamed from: b  reason: collision with root package name */
        ImageView f14749b;

        a() {
        }
    }

    public g(h hVar, int i10) {
        this.f14745a = LayoutInflater.from(hVar);
        this.f14746b = Math.round((float) (c.d() / i10));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit f(ShimmerFrameLayout shimmerFrameLayout) {
        h(shimmerFrameLayout);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit g(ShimmerFrameLayout shimmerFrameLayout, Bitmap bitmap) {
        h(shimmerFrameLayout);
        return null;
    }

    private void h(ShimmerFrameLayout shimmerFrameLayout) {
        if (shimmerFrameLayout.isShimmerStarted()) {
            shimmerFrameLayout.setShimmer(((Shimmer.AlphaHighlightBuilder) ((Shimmer.AlphaHighlightBuilder) new Shimmer.AlphaHighlightBuilder().setBaseAlpha(1.0f)).setIntensity(0.0f)).build());
            shimmerFrameLayout.stopShimmer();
            shimmerFrameLayout.clearAnimation();
        }
    }

    public void c(List<NetworkPhoto> list) {
        this.f14747c.addAll(list);
        notifyDataSetChanged();
    }

    public String d(int i10) {
        return this.f14747c.get(i10).getId();
    }

    public String e(int i10) {
        return this.f14747c.get(i10).getUrl();
    }

    public int getCount() {
        return this.f14747c.size();
    }

    public Object getItem(int i10) {
        return this.f14747c.get(i10);
    }

    public long getItemId(int i10) {
        return (long) i10;
    }

    public View getView(int i10, View view, ViewGroup viewGroup) {
        View view2;
        if (view == null) {
            view2 = this.f14745a.inflate(R.layout.griditem_photo, (ViewGroup) null);
            a aVar = new a();
            aVar.f14748a = view2;
            aVar.f14749b = (ImageView) view2.findViewById(R.id.imageView_photo);
            view2.setTag(aVar);
        } else {
            view2 = view;
        }
        a aVar2 = (a) view2.getTag();
        String url = this.f14747c.get(i10).getUrl();
        if (!TextUtils.isEmpty(url)) {
            ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) aVar2.f14749b.getParent();
            shimmerFrameLayout.startShimmer();
            b bVar = b.f13967a;
            Context context = view2.getContext();
            ImageView imageView = aVar2.f14749b;
            Integer valueOf = Integer.valueOf(R.drawable.icon_photo_placement_s);
            int i11 = this.f14746b;
            bVar.b(context, url, imageView, valueOf, (Integer) null, new ImageLoaderContract.b(i11, i11), Collections.singletonList(b.a.f18329a), Collections.emptyMap(), new e(this, shimmerFrameLayout), new f(this, shimmerFrameLayout), (Bitmap.Config) null, (ImageLoaderContract.ImageBucketSize) null, new ImageLoaderContract.MemoryConfig[0]);
            aVar2.f14748a.setMinimumHeight(this.f14746b);
            aVar2.f14748a.setMinimumWidth(this.f14746b);
            aVar2.f14749b.setMinimumWidth(this.f14746b);
            aVar2.f14749b.setMinimumHeight(this.f14746b);
            view2.setVisibility(0);
        } else {
            view2.setVisibility(8);
        }
        return view2;
    }
}
