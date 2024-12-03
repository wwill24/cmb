package com.coffeemeetsbagel.my_profile;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.image_loader.ImageLoaderContract;
import com.coffeemeetsbagel.photo.Photo;
import com.facebook.shimmer.Shimmer;
import com.facebook.shimmer.ShimmerFrameLayout;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import lc.c;
import lc.o;
import w9.b;
import z9.m;

public class j extends RecyclerView.Adapter<RecyclerView.d0> {

    /* renamed from: d  reason: collision with root package name */
    private final m f34756d;

    /* renamed from: e  reason: collision with root package name */
    private Context f34757e;

    /* renamed from: f  reason: collision with root package name */
    private List<Photo> f34758f;

    /* renamed from: g  reason: collision with root package name */
    private int f34759g;

    /* renamed from: h  reason: collision with root package name */
    private int f34760h;

    /* renamed from: j  reason: collision with root package name */
    private int f34761j = this.f34757e.getResources().getDimensionPixelSize(R.dimen.margin_xlarge);

    /* renamed from: k  reason: collision with root package name */
    private t8.m f34762k;

    public static class a extends RecyclerView.d0 {
        a(View view) {
            super(view);
        }
    }

    public static class b extends RecyclerView.d0 {

        /* renamed from: u  reason: collision with root package name */
        ImageView f34763u;

        /* renamed from: v  reason: collision with root package name */
        ShimmerFrameLayout f34764v;

        b(View view) {
            super(view);
            ImageView imageView = (ImageView) view.findViewById(R.id.my_photo_item);
            this.f34763u = imageView;
            this.f34764v = (ShimmerFrameLayout) imageView.getParent();
        }
    }

    public j(Context context, List<Photo> list, int i10, m mVar, t8.m mVar2) {
        this.f34757e = context;
        this.f34758f = list;
        this.f34760h = i10;
        this.f34762k = mVar2;
        this.f34759g = (int) (((((float) c.d()) - (context.getResources().getDimension(R.dimen.margin_med) * 2.0f)) - (this.f34757e.getResources().getDimension(R.dimen.padding_my_profile_photos) * 2.0f)) / 3.0f);
        this.f34756d = mVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit L(int i10, ImageView imageView, Photo photo, int i11, int i12, ShimmerFrameLayout shimmerFrameLayout) {
        if (i10 > 0) {
            O(imageView, photo, i11, i12, shimmerFrameLayout, i10 - 1);
            return null;
        }
        R(shimmerFrameLayout);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit M(ShimmerFrameLayout shimmerFrameLayout, Bitmap bitmap) {
        R(shimmerFrameLayout);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void N(b bVar, View view) {
        this.f34756d.M(bVar.q());
    }

    private void O(ImageView imageView, Photo photo, int i10, int i11, ShimmerFrameLayout shimmerFrameLayout, int i12) {
        String url = photo.getUrl();
        int i13 = i11;
        int round = Math.round((float) i13);
        com.coffeemeetsbagel.image_loader.b.f13967a.b(this.f34757e, url, imageView, Integer.valueOf(i10), Integer.valueOf(i10), new ImageLoaderContract.b(round, round), Arrays.asList(new b.h[]{b.h.f18338a}), Collections.emptyMap(), new h(this, i12, imageView, photo, i10, i13, shimmerFrameLayout), new i(this, shimmerFrameLayout), Bitmap.Config.RGB_565, (ImageLoaderContract.ImageBucketSize) null, ImageLoaderContract.MemoryConfig.NO_CACHE);
    }

    private void R(ShimmerFrameLayout shimmerFrameLayout) {
        if (shimmerFrameLayout != null && shimmerFrameLayout.isShimmerStarted()) {
            shimmerFrameLayout.setShimmer(((Shimmer.AlphaHighlightBuilder) ((Shimmer.AlphaHighlightBuilder) new Shimmer.AlphaHighlightBuilder().setBaseAlpha(1.0f)).setIntensity(0.0f)).build());
            shimmerFrameLayout.stopShimmer();
            shimmerFrameLayout.clearAnimation();
        }
    }

    private void S(List<Photo> list, int i10, int i11) {
        Collections.swap(list, i10, i11);
        o.d(this.f34762k.a(i10), this.f34762k.a(i11), this.f34762k.e());
    }

    public List<Photo> J() {
        return this.f34758f;
    }

    public boolean K(int i10) {
        return i10 == this.f34760h;
    }

    public void P() {
        this.f34762k.h(this.f34758f);
    }

    public boolean Q(int i10, int i11) {
        if (i10 < i11) {
            for (int i12 = i10 + 1; i12 <= i11; i12++) {
                S(this.f34758f, i12, i12 - 1);
            }
        } else {
            for (int i13 = i10; i13 > i11; i13--) {
                S(this.f34758f, i13, i13 - 1);
            }
        }
        o(i10, i11);
        return true;
    }

    public void T(List<Photo> list) {
        this.f34758f = list;
        l();
    }

    public int g() {
        return this.f34760h + 1;
    }

    public int i(int i10) {
        if (K(i10)) {
            return 1;
        }
        return super.i(i10);
    }

    public void v(@NonNull RecyclerView.d0 d0Var, int i10) {
        if (d0Var instanceof b) {
            b bVar = (b) d0Var;
            List<Photo> list = this.f34758f;
            if (list == null || i10 >= list.size()) {
                ImageView imageView = bVar.f34763u;
                int i11 = this.f34761j;
                imageView.setPadding(i11, i11, i11, i11);
                bVar.f34763u.setImageResource(R.drawable.icon_add_picture);
            } else {
                int i12 = this.f34759g;
                bVar.f34764v.startShimmer();
                bVar.f34763u.setPadding(0, 0, 0, 0);
                O(bVar.f34763u, this.f34758f.get(i10), R.drawable.icon_photo_placement_s, i12, bVar.f34764v, 20);
            }
            bVar.f34763u.setOnClickListener(new g(this, bVar));
        }
    }

    @NonNull
    public RecyclerView.d0 x(@NonNull ViewGroup viewGroup, int i10) {
        if (i10 == 1) {
            return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.partial_photo_grid_footer, viewGroup, false));
        }
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.my_photo_item, viewGroup, false));
    }
}
