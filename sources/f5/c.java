package f5;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.image_loader.ImageLoaderContract;
import com.coffeemeetsbagel.image_loader.b;
import com.coffeemeetsbagel.models.FacebookAlbum;
import com.facebook.shimmer.Shimmer;
import com.facebook.shimmer.ShimmerFrameLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import w9.b;

public class c extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final Context f14734a;

    /* renamed from: b  reason: collision with root package name */
    private final LayoutInflater f14735b;

    /* renamed from: c  reason: collision with root package name */
    private List<FacebookAlbum> f14736c = new ArrayList();

    static class a {

        /* renamed from: a  reason: collision with root package name */
        ImageView f14737a;

        /* renamed from: b  reason: collision with root package name */
        TextView f14738b;

        /* renamed from: c  reason: collision with root package name */
        TextView f14739c;

        a() {
        }
    }

    public c(Context context) {
        this.f14734a = context;
        this.f14735b = LayoutInflater.from(context);
    }

    private void e(ShimmerFrameLayout shimmerFrameLayout) {
        if (shimmerFrameLayout.isShimmerStarted()) {
            shimmerFrameLayout.setShimmer(((Shimmer.AlphaHighlightBuilder) ((Shimmer.AlphaHighlightBuilder) new Shimmer.AlphaHighlightBuilder().setBaseAlpha(1.0f)).setIntensity(0.0f)).build());
            shimmerFrameLayout.stopShimmer();
            shimmerFrameLayout.clearAnimation();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit f(ShimmerFrameLayout shimmerFrameLayout) {
        e(shimmerFrameLayout);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit g(ShimmerFrameLayout shimmerFrameLayout, Bitmap bitmap) {
        e(shimmerFrameLayout);
        return null;
    }

    public void c(FacebookAlbum facebookAlbum, int i10) {
        this.f14736c.add(i10, facebookAlbum);
        notifyDataSetChanged();
    }

    /* renamed from: d */
    public FacebookAlbum getItem(int i10) {
        return this.f14736c.get(i10);
    }

    public int getCount() {
        return this.f14736c.size();
    }

    public long getItemId(int i10) {
        return (long) i10;
    }

    public View getView(int i10, View view, ViewGroup viewGroup) {
        View view2;
        if (view == null) {
            a aVar = new a();
            view2 = this.f14735b.inflate(R.layout.row_view_album, (ViewGroup) null);
            aVar.f14737a = (ImageView) view2.findViewById(R.id.imageView_thumbnail_album);
            aVar.f14738b = (TextView) view2.findViewById(R.id.text_albumName);
            aVar.f14739c = (TextView) view2.findViewById(R.id.subtext_albumCount);
            view2.setTag(aVar);
        } else {
            view2 = view;
        }
        a aVar2 = (a) view2.getTag();
        FacebookAlbum facebookAlbum = this.f14736c.get(i10);
        int count = facebookAlbum.getCount();
        String name = facebookAlbum.getName();
        String thumbUrl = facebookAlbum.getThumbUrl();
        String quantityString = this.f14734a.getResources().getQuantityString(R.plurals.photo_count_plural, count, new Object[]{Integer.valueOf(count)});
        aVar2.f14738b.setText(name);
        aVar2.f14739c.setText(quantityString);
        if (!TextUtils.isEmpty(thumbUrl)) {
            int dimension = (int) this.f14734a.getResources().getDimension(R.dimen.height_row_view_album);
            ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) aVar2.f14737a.getParent();
            shimmerFrameLayout.startShimmer();
            b.f13967a.b(view2.getContext(), thumbUrl, aVar2.f14737a, Integer.valueOf(R.drawable.icon_photo_placement_s), (Integer) null, new ImageLoaderContract.b(dimension, dimension), Arrays.asList(new b.a[]{b.a.f18329a}), Collections.emptyMap(), new a(this, shimmerFrameLayout), new b(this, shimmerFrameLayout), (Bitmap.Config) null, (ImageLoaderContract.ImageBucketSize) null, new ImageLoaderContract.MemoryConfig[0]);
        }
        return view2;
    }

    public void h(List<FacebookAlbum> list) {
        this.f14736c = list;
        notifyDataSetChanged();
    }
}
