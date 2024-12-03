package k8;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.image_loader.ImageLoaderContract;
import com.coffeemeetsbagel.image_loader.b;
import com.coffeemeetsbagel.models.enums.MediaItemType;
import com.coffeemeetsbagel.models.interfaces.MediaItemContract;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import w9.b;
import yn.d;

public class d extends androidx.viewpager.widget.a {

    /* renamed from: c  reason: collision with root package name */
    private List<MediaItemContract.MediaItem> f15968c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public MediaItemContract.Listener f15969d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f15970e;

    class a implements d.f {
        a() {
        }

        public void a() {
        }

        public void b(View view, float f10, float f11) {
            d.this.f15969d.onPhotoClicked();
        }
    }

    public d(List<MediaItemContract.MediaItem> list, MediaItemContract.Listener listener, boolean z10) {
        this.f15968c = list;
        this.f15969d = listener;
        this.f15970e = z10;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Unit B(ImageView imageView, yn.d dVar, View view, Bitmap bitmap) {
        imageView.setImageBitmap(bitmap);
        dVar.I();
        view.setVisibility(8);
        return null;
    }

    private void C(String str, View view, ImageView imageView) {
        ImageView imageView2 = imageView;
        yn.d dVar = new yn.d(imageView2);
        dVar.E(new a());
        b.f13967a.b(imageView.getContext(), str, (ImageView) null, (Integer) null, (Integer) null, (ImageLoaderContract.b) null, Collections.emptyList(), Collections.emptyMap(), (Function0<Unit>) null, new a(imageView2, dVar, view), (Bitmap.Config) null, ImageLoaderContract.ImageBucketSize.LARGE, new ImageLoaderContract.MemoryConfig[0]);
    }

    public void D(List<MediaItemContract.MediaItem> list) {
        this.f15968c = list;
        k();
    }

    public void b(ViewGroup viewGroup, int i10, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public int e() {
        List<MediaItemContract.MediaItem> list = this.f15968c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public int f(Object obj) {
        return -2;
    }

    public Object i(ViewGroup viewGroup, int i10) {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.media_pager_default_item, viewGroup, false);
        MediaItemContract.MediaItem mediaItem = this.f15968c.get(i10);
        if (mediaItem.getType() == MediaItemType.PHOTO) {
            frameLayout = (FrameLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.photo_adapter_item, viewGroup, false);
            View findViewById = frameLayout.findViewById(R.id.profilePhotoSpinner);
            ImageView imageView = (ImageView) frameLayout.findViewById(R.id.profilePhotoImageView);
            findViewById.setVisibility(0);
            if (this.f15970e) {
                C(mediaItem.getUrl(), findViewById, imageView);
            } else {
                y(mediaItem.getUrl(), findViewById, imageView);
            }
            viewGroup.addView(frameLayout);
        }
        return frameLayout;
    }

    public boolean j(View view, Object obj) {
        return view == obj;
    }

    public void y(String str, View view, ImageView imageView) {
        View view2 = view;
        if (!TextUtils.isEmpty(str)) {
            b.f13967a.b(imageView.getContext(), str, imageView, (Integer) null, (Integer) null, (ImageLoaderContract.b) null, Collections.singletonList(b.a.f18329a), Collections.emptyMap(), new b(view2), new c(view2), (Bitmap.Config) null, ImageLoaderContract.ImageBucketSize.LARGE, new ImageLoaderContract.MemoryConfig[0]);
        }
    }
}
