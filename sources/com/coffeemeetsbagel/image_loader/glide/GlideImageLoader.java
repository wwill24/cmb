package com.coffeemeetsbagel.image_loader.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.renderscript.RenderScript;
import android.widget.ImageView;
import c4.h;
import com.bumptech.glide.g;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.GlideException;
import com.coffeemeetsbagel.image_loader.ImageLoaderContract;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.mparticle.identity.IdentityHttpResponse;
import gk.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import s3.k;
import w9.b;
import x9.e;

public final class GlideImageLoader implements ImageLoaderContract {

    /* renamed from: d  reason: collision with root package name */
    public static final a f13972d = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f13973a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final a7.a f13974b;

    /* renamed from: c  reason: collision with root package name */
    private final f f13975c = b.b(new GlideImageLoader$renderScript$2(this));

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f13976a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            try {
                iArr[Bitmap.Config.RGB_565.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f13976a = iArr;
        }
    }

    public static final class c implements b4.b<Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f13977a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ GlideImageLoader f13978b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Function1<Bitmap, Unit> f13979c;

        c(Function0<Unit> function0, GlideImageLoader glideImageLoader, Function1<? super Bitmap, Unit> function1) {
            this.f13977a = function0;
            this.f13978b = glideImageLoader;
            this.f13979c = function1;
        }

        public boolean a(GlideException glideException, Object obj, h<Bitmap> hVar, boolean z10) {
            String str;
            j.g(obj, DeviceRequestsHelper.DEVICE_INFO_MODEL);
            j.g(hVar, TypeProxy.INSTANCE_FIELD);
            Function0<Unit> function0 = this.f13977a;
            if (function0 != null) {
                function0.invoke();
            }
            a7.a d10 = this.f13978b.f13974b;
            if (d10 == null) {
                return false;
            }
            if (glideException != null) {
                str = glideException.getMessage();
            } else {
                str = null;
            }
            d10.trackEvent("Image Failed To Load", g0.f(gk.h.a("error", str)));
            return false;
        }

        /* renamed from: c */
        public boolean b(Bitmap bitmap, Object obj, h<Bitmap> hVar, DataSource dataSource, boolean z10) {
            j.g(obj, DeviceRequestsHelper.DEVICE_INFO_MODEL);
            j.g(hVar, TypeProxy.INSTANCE_FIELD);
            Function1<Bitmap, Unit> function1 = this.f13979c;
            if (function1 == null) {
                return false;
            }
            function1.invoke(bitmap);
            return false;
        }
    }

    public static final class d extends c4.c<Bitmap> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f13980d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Function1<Bitmap, Unit> f13981e;

        d(Function0<Unit> function0, Function1<? super Bitmap, Unit> function1) {
            this.f13980d = function0;
            this.f13981e = function1;
        }

        /* renamed from: e */
        public void f(Bitmap bitmap, d4.f<? super Bitmap> fVar) {
            j.g(bitmap, "resource");
            Function1<Bitmap, Unit> function1 = this.f13981e;
            if (function1 != null) {
                function1.invoke(bitmap);
            }
        }

        public void k(Drawable drawable) {
        }

        public void l(Drawable drawable) {
            Function0<Unit> function0 = this.f13980d;
            if (function0 != null) {
                function0.invoke();
            }
            fa.a.f40771d.b("GlideImageLoader", "failed loading bitmap");
        }
    }

    public GlideImageLoader(Context context, a7.a aVar) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        this.f13973a = context;
        this.f13974b = aVar;
    }

    private final RenderScript f() {
        return (RenderScript) this.f13975c.getValue();
    }

    private final void g(g<Bitmap> gVar, ImageLoaderContract.b bVar, List<? extends w9.b> list, ImageView imageView, Function1<? super Bitmap, Unit> function1, Function0<Unit> function0, Bitmap.Config config, ImageLoaderContract.MemoryConfig... memoryConfigArr) {
        Object obj;
        Object dVar;
        b4.c cVar = new b4.c();
        if (bVar != null) {
            b4.c cVar2 = (b4.c) cVar.W(bVar.b(), bVar.a());
        }
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        for (w9.b bVar2 : list) {
            if (j.b(bVar2, b.a.f18329a)) {
                obj = new s3.j();
            } else if (j.b(bVar2, b.C0217b.f18330a)) {
                obj = new k();
            } else if (j.b(bVar2, b.m.f18345a)) {
                obj = new x9.b(0, (int) this.f13973a.getResources().getDimension(w9.c.two_dp), -1);
            } else {
                if (bVar2 instanceof b.d) {
                    b.d dVar2 = (b.d) bVar2;
                    dVar = new x9.b(dVar2.c(), dVar2.b(), dVar2.a());
                } else if (j.b(bVar2, b.c.f18331a)) {
                    obj = new x9.b(0, 0, 0);
                } else if (bVar2 instanceof b.i) {
                    b.i iVar = (b.i) bVar2;
                    dVar = new x9.c(iVar.b(), iVar.a());
                } else if (bVar2 instanceof b.k) {
                    dVar = new x9.c(((b.k) bVar2).a(), 0);
                } else if (bVar2 instanceof b.l) {
                    dVar = new e(((b.l) bVar2).a());
                } else if (bVar2 instanceof b.j) {
                    dVar = new x9.d(((b.j) bVar2).a());
                } else if (j.b(bVar2, b.h.f18338a)) {
                    gVar.F0(s3.g.j());
                    obj = null;
                } else if (j.b(bVar2, b.e.f18335a)) {
                    RenderScript f10 = f();
                    j.f(f10, "renderScript");
                    obj = new x9.a(1.5d, 25.0f, f10);
                } else if (j.b(bVar2, b.g.f18337a)) {
                    RenderScript f11 = f();
                    j.f(f11, "renderScript");
                    obj = new x9.a(1.0d, 25.0f, f11);
                } else if (j.b(bVar2, b.f.f18336a)) {
                    RenderScript f12 = f();
                    j.f(f12, "renderScript");
                    obj = new x9.a(0.5d, 25.0f, f12);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                obj = dVar;
            }
            arrayList.add(obj);
        }
        List K = CollectionsKt___CollectionsKt.K(arrayList);
        if (!K.isEmpty()) {
            cVar.i0(new i3.c(K));
        }
        if (l.v(memoryConfigArr, ImageLoaderContract.MemoryConfig.NO_CACHE) && l.v(memoryConfigArr, ImageLoaderContract.MemoryConfig.NO_STORE)) {
            cVar.g0(true);
        }
        if (config != null) {
            if (b.f13976a[config.ordinal()] == 1) {
                b4.c cVar3 = (b4.c) cVar.j(DecodeFormat.PREFER_RGB_565);
            } else {
                b4.c cVar4 = (b4.c) cVar.j(DecodeFormat.PREFER_ARGB_8888);
            }
        }
        g<Bitmap> n02 = gVar.a(cVar);
        j.f(n02, "requestBuilder.apply(requestOptions)");
        if (imageView != null) {
            new Handler(Looper.getMainLooper()).post(new a(n02, new c(function0, this, function1), imageView));
            return;
        }
        j.f((d) n02.u0(new d(function0, function1)), "run {\n            val ta…er.into(target)\n        }");
    }

    /* access modifiers changed from: private */
    public static final void h(g gVar, c cVar, ImageView imageView) {
        j.g(gVar, "$finalRequestBuilder");
        j.g(cVar, "$requestListener");
        j.g(imageView, "$it");
        gVar.z0(cVar).x0(imageView);
    }

    public void a(Context context, int i10, ImageView imageView, ImageLoaderContract.b bVar, List<? extends w9.b> list, Function0<Unit> function0, Function1<? super Bitmap, Unit> function1) {
        Context context2 = context;
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(list, "transformations");
        fa.a.f40771d.l("GlideImageLoader", "loadImage");
        g<Bitmap> A0 = com.bumptech.glide.c.t(context).h().A0(Integer.valueOf(i10));
        j.f(A0, "with(context)\n          …        .load(drawableId)");
        g(A0, bVar, list, imageView, function1, function0, (Bitmap.Config) null, new ImageLoaderContract.MemoryConfig[0]);
    }

    public void b(Context context, String str, ImageView imageView, Integer num, Integer num2, ImageLoaderContract.b bVar, List<? extends w9.b> list, Map<String, String> map, Function0<Unit> function0, Function1<? super Bitmap, Unit> function1, Bitmap.Config config, ImageLoaderContract.ImageBucketSize imageBucketSize, ImageLoaderContract.MemoryConfig... memoryConfigArr) {
        String str2 = str;
        ImageLoaderContract.MemoryConfig[] memoryConfigArr2 = memoryConfigArr;
        Context context2 = context;
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(str, "url");
        j.g(list, "transformations");
        j.g(map, "extraParams");
        j.g(memoryConfigArr2, "memoryConfig");
        fa.a.f40771d.l("GlideImageLoader", "loadImage");
        g<Bitmap> C0 = com.bumptech.glide.c.t(context).h().C0(str);
        j.f(C0, "with(context)\n          …()\n            .load(url)");
        if (num != null) {
            g gVar = (g) C0.X(num.intValue());
        }
        if (num2 != null) {
            g gVar2 = (g) C0.i(num2.intValue());
        }
        g(C0, bVar, list, imageView, function1, function0, config, (ImageLoaderContract.MemoryConfig[]) Arrays.copyOf(memoryConfigArr2, memoryConfigArr2.length));
    }
}
