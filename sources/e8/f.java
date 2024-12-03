package e8;

import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import androidx.core.content.FileProvider;
import b8.c;
import b8.d;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.feature.instagram.InstagramContract$InstagramError;
import com.coffeemeetsbagel.feature.instagram.InstagramContract$Manager;
import com.coffeemeetsbagel.feature.instagram.api.models.InstagramMediaItem;
import com.coffeemeetsbagel.feature.instagram.b;
import com.coffeemeetsbagel.image_loader.ImageLoaderContract;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public class f implements c, b.a<InstagramMediaItem[], InstagramContract$InstagramError> {

    /* renamed from: a  reason: collision with root package name */
    private final InstagramContract$Manager f14605a;

    /* renamed from: b  reason: collision with root package name */
    private d f14606b;

    /* renamed from: c  reason: collision with root package name */
    private List<InstagramMediaItem> f14607c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private b<InstagramMediaItem[], InstagramContract$InstagramError> f14608d;

    public f(d dVar, InstagramContract$Manager instagramContract$Manager) {
        this.f14606b = dVar;
        this.f14605a = instagramContract$Manager;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit g(Bitmap bitmap) {
        if (this.f14606b == null) {
            return null;
        }
        String i10 = lc.f.i(bitmap, 100, Bakery.w().getFilesDir() + "/temp.png");
        Uri f10 = FileProvider.f(this.f14606b.getContext(), "com.coffeemeetsbagel.fileprovider", new File(i10));
        this.f14606b.k();
        this.f14606b.H(f10, i10);
        return null;
    }

    public void b() {
        if (this.f14608d.a()) {
            this.f14608d.b();
        }
    }

    public void c() {
    }

    public void e(InstagramMediaItem instagramMediaItem) {
        this.f14606b.j();
        com.coffeemeetsbagel.image_loader.b.f13967a.b(this.f14606b.getContext(), instagramMediaItem.images.standardResolution.url, (ImageView) null, (Integer) null, (Integer) null, (ImageLoaderContract.b) null, Collections.emptyList(), Collections.emptyMap(), (Function0<Unit>) null, new e(this), (Bitmap.Config) null, (ImageLoaderContract.ImageBucketSize) null, new ImageLoaderContract.MemoryConfig[0]);
    }

    /* renamed from: h */
    public void a(InstagramMediaItem[] instagramMediaItemArr) {
        if (this.f14606b != null) {
            this.f14607c.addAll(Arrays.asList(instagramMediaItemArr));
            if (this.f14607c.isEmpty()) {
                this.f14606b.E();
            } else {
                this.f14606b.f0(this.f14607c);
            }
        }
    }

    /* renamed from: i */
    public void d(InstagramContract$InstagramError instagramContract$InstagramError) {
        d dVar = this.f14606b;
        if (dVar == null) {
            return;
        }
        if (instagramContract$InstagramError == InstagramContract$InstagramError.NOT_AUTHORIZED) {
            dVar.z();
        } else {
            dVar.j0();
        }
    }

    public void start() {
        this.f14606b.C();
        b<InstagramMediaItem[], InstagramContract$InstagramError> c10 = this.f14605a.c(this);
        this.f14608d = c10;
        c10.b();
    }

    public void stop() {
        this.f14606b = null;
    }
}
