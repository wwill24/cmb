package com.coffeemeetsbagel.image_loader;

import a7.a;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.coffeemeetsbagel.image_loader.ImageLoaderContract;
import com.coffeemeetsbagel.image_loader.glide.GlideImageLoader;
import com.mparticle.identity.IdentityHttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;

public final class b implements ImageLoaderContract {

    /* renamed from: a  reason: collision with root package name */
    public static final b f13967a = new b();

    /* renamed from: b  reason: collision with root package name */
    private static ImageLoaderContract f13968b;

    /* renamed from: c  reason: collision with root package name */
    private static float f13969c = 1.0f;

    /* renamed from: d  reason: collision with root package name */
    private static a f13970d;

    /* renamed from: e  reason: collision with root package name */
    private static s9.a f13971e;

    private b() {
    }

    private final int c(ImageLoaderContract.ImageBucketSize imageBucketSize) {
        boolean z10;
        float f10;
        boolean z11;
        boolean z12;
        if (imageBucketSize == null) {
            return c.b(ImageLoaderContract.ImageBucketSize.DEFAULT.b());
        }
        float b10 = imageBucketSize.b() * f13969c;
        boolean z13 = true;
        if (0.0f > b10 || b10 > ImageLoaderContract.ImageBucketSize.MICRO.b()) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            f10 = ImageLoaderContract.ImageBucketSize.MICRO.b();
        } else {
            float b11 = ImageLoaderContract.ImageBucketSize.MICRO.b();
            ImageLoaderContract.ImageBucketSize imageBucketSize2 = ImageLoaderContract.ImageBucketSize.SMALL;
            if (b10 > imageBucketSize2.b() || b11 > b10) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                f10 = imageBucketSize2.b();
            } else {
                float b12 = imageBucketSize2.b();
                ImageLoaderContract.ImageBucketSize imageBucketSize3 = ImageLoaderContract.ImageBucketSize.MEDIUM;
                if (b10 > imageBucketSize3.b() || b12 > b10) {
                    z12 = false;
                } else {
                    z12 = true;
                }
                if (z12) {
                    f10 = imageBucketSize3.b();
                } else {
                    float b13 = imageBucketSize3.b();
                    ImageLoaderContract.ImageBucketSize imageBucketSize4 = ImageLoaderContract.ImageBucketSize.LARGE;
                    if (b10 > imageBucketSize4.b() || b13 > b10) {
                        z13 = false;
                    }
                    if (z13) {
                        f10 = imageBucketSize4.b();
                    } else {
                        f10 = ImageLoaderContract.ImageBucketSize.DEFAULT.b();
                    }
                }
            }
        }
        return c.b(f10);
    }

    private final void f(Context context) {
        f13968b = new GlideImageLoader(context, f13970d);
        f13969c = context.getResources().getDisplayMetrics().density;
    }

    public void a(Context context, int i10, ImageView imageView, ImageLoaderContract.b bVar, List<? extends w9.b> list, Function0<Unit> function0, Function1<? super Bitmap, Unit> function1) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(list, "transformations");
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
        }
        f(context);
        ImageLoaderContract imageLoaderContract = f13968b;
        if (imageLoaderContract != null) {
            imageLoaderContract.a(context, i10, imageView, bVar, list, function0, function1);
        }
    }

    public void b(Context context, String str, ImageView imageView, Integer num, Integer num2, ImageLoaderContract.b bVar, List<? extends w9.b> list, Map<String, String> map, Function0<Unit> function0, Function1<? super Bitmap, Unit> function1, Bitmap.Config config, ImageLoaderContract.ImageBucketSize imageBucketSize, ImageLoaderContract.MemoryConfig... memoryConfigArr) {
        boolean z10;
        Context context2 = context;
        String str2 = str;
        ImageView imageView2 = imageView;
        Map<String, String> map2 = map;
        ImageLoaderContract.MemoryConfig[] memoryConfigArr2 = memoryConfigArr;
        j.g(context2, IdentityHttpResponse.CONTEXT);
        j.g(str2, "url");
        j.g(list, "transformations");
        j.g(map2, "extraParams");
        j.g(memoryConfigArr2, "memoryConfig");
        if (context2 instanceof Activity) {
            Activity activity = (Activity) context2;
            if (activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
        }
        f(context);
        if (str.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            fa.a.f40771d.f(new NullPointerException("path cannot be null"));
            if (imageView2 == null) {
                return;
            }
            if (num != null) {
                imageView2.setImageResource(num.intValue());
            } else if (num2 != null) {
                imageView2.setImageResource(num2.intValue());
            }
        } else {
            String b10 = new a().b(a.f13965a.a(map2, c(imageBucketSize)), str2);
            ImageLoaderContract imageLoaderContract = f13968b;
            if (imageLoaderContract != null) {
                imageLoaderContract.b(context, b10, imageView, num, num2, bVar, list, map, function0, function1, config, imageBucketSize, (ImageLoaderContract.MemoryConfig[]) Arrays.copyOf(memoryConfigArr2, memoryConfigArr2.length));
            }
        }
    }

    public final void d(a aVar) {
        j.g(aVar, "analyticsManager");
        if (f13970d == null) {
            f13970d = aVar;
        }
    }

    public final void e(s9.a aVar) {
        j.g(aVar, "featureManager");
        if (f13971e == null) {
            f13971e = aVar;
        }
    }
}
