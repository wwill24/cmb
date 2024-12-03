package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.h;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import i3.f;
import j3.k;
import j3.m;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import m3.b;
import m3.d;
import p3.a;
import p3.b;
import p3.d;
import p3.e;
import p3.f;
import p3.g;
import p3.k;
import p3.s;
import p3.t;
import p3.u;
import p3.v;
import p3.w;
import p3.x;
import q3.a;
import q3.b;
import q3.c;
import q3.d;
import q3.e;
import q3.h;
import s3.i;
import s3.n;
import s3.p;
import s3.r;
import s3.u;
import s3.w;
import t3.a;
import w3.j;
import y3.l;

public class c implements ComponentCallbacks2 {

    /* renamed from: m  reason: collision with root package name */
    private static volatile c f9152m;

    /* renamed from: n  reason: collision with root package name */
    private static volatile boolean f9153n;

    /* renamed from: a  reason: collision with root package name */
    private final h f9154a;

    /* renamed from: b  reason: collision with root package name */
    private final d f9155b;

    /* renamed from: c  reason: collision with root package name */
    private final n3.h f9156c;

    /* renamed from: d  reason: collision with root package name */
    private final e f9157d;

    /* renamed from: e  reason: collision with root package name */
    private final Registry f9158e;

    /* renamed from: f  reason: collision with root package name */
    private final b f9159f;

    /* renamed from: g  reason: collision with root package name */
    private final l f9160g;

    /* renamed from: h  reason: collision with root package name */
    private final y3.d f9161h;

    /* renamed from: j  reason: collision with root package name */
    private final List<h> f9162j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    private final a f9163k;

    /* renamed from: l  reason: collision with root package name */
    private MemoryCategory f9164l = MemoryCategory.NORMAL;

    public interface a {
        @NonNull
        b4.c build();
    }

    c(@NonNull Context context, @NonNull h hVar, @NonNull n3.h hVar2, @NonNull d dVar, @NonNull b bVar, @NonNull l lVar, @NonNull y3.d dVar2, int i10, @NonNull a aVar, @NonNull Map<Class<?>, i<?, ?>> map, @NonNull List<b4.b<Object>> list, boolean z10, boolean z11) {
        f fVar;
        f fVar2;
        Context context2 = context;
        d dVar3 = dVar;
        b bVar2 = bVar;
        Class<g3.a> cls = g3.a.class;
        Class<String> cls2 = String.class;
        Class<Integer> cls3 = Integer.class;
        Class<byte[]> cls4 = byte[].class;
        this.f9154a = hVar;
        this.f9155b = dVar3;
        this.f9159f = bVar2;
        this.f9156c = hVar2;
        this.f9160g = lVar;
        this.f9161h = dVar2;
        this.f9163k = aVar;
        Resources resources = context.getResources();
        Registry registry = new Registry();
        this.f9158e = registry;
        registry.o(new DefaultImageHeaderParser());
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 27) {
            registry.o(new n());
        }
        List<ImageHeaderParser> g10 = registry.g();
        w3.a aVar2 = new w3.a(context2, g10, dVar3, bVar2);
        f<ParcelFileDescriptor, Bitmap> h10 = w.h(dVar);
        com.bumptech.glide.load.resource.bitmap.a aVar3 = new com.bumptech.glide.load.resource.bitmap.a(registry.g(), resources.getDisplayMetrics(), dVar3, bVar2);
        if (!z11 || i11 < 28) {
            fVar = new s3.h(aVar3);
            fVar2 = new com.bumptech.glide.load.resource.bitmap.d(aVar3, bVar2);
        } else {
            fVar2 = new p();
            fVar = new i();
        }
        Class<byte[]> cls5 = cls4;
        u3.d dVar4 = new u3.d(context2);
        int i12 = i11;
        s.c cVar = new s.c(resources);
        s.d dVar5 = new s.d(resources);
        Class<String> cls6 = cls2;
        s.b bVar3 = new s.b(resources);
        s.d dVar6 = dVar5;
        s.a aVar4 = new s.a(resources);
        s3.c cVar2 = new s3.c(bVar2);
        Class<Integer> cls7 = cls3;
        x3.a aVar5 = new x3.a();
        x3.d dVar7 = new x3.d();
        ContentResolver contentResolver = context.getContentResolver();
        s.b bVar4 = bVar3;
        s.c cVar3 = cVar;
        u3.d dVar8 = dVar4;
        registry.a(ByteBuffer.class, new p3.c()).a(InputStream.class, new t(bVar2)).e("Bitmap", ByteBuffer.class, Bitmap.class, fVar).e("Bitmap", InputStream.class, Bitmap.class, fVar2);
        if (m.c()) {
            registry.e("Bitmap", ParcelFileDescriptor.class, Bitmap.class, new r(aVar3));
        }
        u3.d dVar9 = dVar8;
        registry.e("Bitmap", ParcelFileDescriptor.class, Bitmap.class, h10).e("Bitmap", AssetFileDescriptor.class, Bitmap.class, w.c(dVar)).d(Bitmap.class, Bitmap.class, v.a.b()).e("Bitmap", Bitmap.class, Bitmap.class, new u()).b(Bitmap.class, cVar2).e("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new s3.a(resources, fVar)).e("BitmapDrawable", InputStream.class, BitmapDrawable.class, new s3.a(resources, fVar2)).e("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new s3.a(resources, h10)).b(BitmapDrawable.class, new s3.b(dVar3, cVar2)).e("Gif", InputStream.class, w3.c.class, new j(g10, aVar2, bVar2)).e("Gif", ByteBuffer.class, w3.c.class, aVar2).b(w3.c.class, new w3.d()).d(cls, cls, v.a.b()).e("Bitmap", cls, Bitmap.class, new w3.h(dVar3)).c(Uri.class, Drawable.class, dVar9).c(Uri.class, Bitmap.class, new s3.s(dVar9, dVar3)).p(new a.C0208a()).d(File.class, ByteBuffer.class, new d.b()).d(File.class, InputStream.class, new f.e()).c(File.class, File.class, new v3.a()).d(File.class, ParcelFileDescriptor.class, new f.b()).d(File.class, File.class, v.a.b()).p(new k.a(bVar2));
        if (m.c()) {
            registry.p(new m.a());
        }
        Class cls8 = Integer.TYPE;
        s.c cVar4 = cVar3;
        s.b bVar5 = bVar4;
        Class<Integer> cls9 = cls7;
        s.d dVar10 = dVar6;
        s.a aVar6 = aVar4;
        Class<String> cls10 = cls6;
        Context context3 = context;
        registry.d(cls8, InputStream.class, cVar4).d(cls8, ParcelFileDescriptor.class, bVar5).d(cls9, InputStream.class, cVar4).d(cls9, ParcelFileDescriptor.class, bVar5).d(cls9, Uri.class, dVar10).d(cls8, AssetFileDescriptor.class, aVar6).d(cls9, AssetFileDescriptor.class, aVar6).d(cls8, Uri.class, dVar10).d(cls10, InputStream.class, new e.c()).d(Uri.class, InputStream.class, new e.c()).d(cls10, InputStream.class, new u.c()).d(cls10, ParcelFileDescriptor.class, new u.b()).d(cls10, AssetFileDescriptor.class, new u.a()).d(Uri.class, InputStream.class, new b.a()).d(Uri.class, InputStream.class, new a.c(context.getAssets())).d(Uri.class, ParcelFileDescriptor.class, new a.b(context.getAssets())).d(Uri.class, InputStream.class, new c.a(context3)).d(Uri.class, InputStream.class, new d.a(context3));
        if (i12 >= 29) {
            registry.d(Uri.class, InputStream.class, new e.c(context3));
            registry.d(Uri.class, ParcelFileDescriptor.class, new e.b(context3));
        }
        ContentResolver contentResolver2 = contentResolver;
        Class<byte[]> cls11 = cls5;
        x3.a aVar7 = aVar5;
        x3.d dVar11 = dVar7;
        registry.d(Uri.class, InputStream.class, new w.d(contentResolver2)).d(Uri.class, ParcelFileDescriptor.class, new w.b(contentResolver2)).d(Uri.class, AssetFileDescriptor.class, new w.a(contentResolver2)).d(Uri.class, InputStream.class, new x.a()).d(URL.class, InputStream.class, new h.a()).d(Uri.class, File.class, new k.a(context3)).d(g.class, InputStream.class, new a.C0193a()).d(cls11, ByteBuffer.class, new b.a()).d(cls11, InputStream.class, new b.d()).d(Uri.class, Uri.class, v.a.b()).d(Drawable.class, Drawable.class, v.a.b()).c(Drawable.class, Drawable.class, new u3.e()).q(Bitmap.class, BitmapDrawable.class, new x3.b(resources)).q(Bitmap.class, cls11, aVar7).q(Drawable.class, cls11, new x3.c(dVar3, aVar7, dVar11)).q(w3.c.class, cls11, dVar11);
        i3.f<ByteBuffer, Bitmap> d10 = s3.w.d(dVar);
        registry.c(ByteBuffer.class, Bitmap.class, d10);
        registry.c(ByteBuffer.class, BitmapDrawable.class, new s3.a(resources, d10));
        this.f9157d = new e(context, bVar, registry, new c4.f(), aVar, map, list, hVar, z10, i10);
    }

    private static void a(@NonNull Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        if (!f9153n) {
            f9153n = true;
            m(context, generatedAppGlideModule);
            f9153n = false;
            return;
        }
        throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
    }

    @NonNull
    public static c c(@NonNull Context context) {
        if (f9152m == null) {
            GeneratedAppGlideModule d10 = d(context.getApplicationContext());
            synchronized (c.class) {
                if (f9152m == null) {
                    a(context, d10);
                }
            }
        }
        return f9152m;
    }

    private static GeneratedAppGlideModule d(Context context) {
        try {
            return GeneratedAppGlideModuleImpl.class.getDeclaredConstructor(new Class[]{Context.class}).newInstance(new Object[]{context.getApplicationContext()});
        } catch (ClassNotFoundException unused) {
            Log.isLoggable("Glide", 5);
        } catch (InstantiationException e10) {
            q(e10);
        } catch (IllegalAccessException e11) {
            q(e11);
        } catch (NoSuchMethodException e12) {
            q(e12);
        } catch (InvocationTargetException e13) {
            q(e13);
        }
        return null;
    }

    @NonNull
    private static l l(Context context) {
        f4.j.e(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return c(context).k();
    }

    private static void m(@NonNull Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        n(context, new d(), generatedAppGlideModule);
    }

    private static void n(@NonNull Context context, @NonNull d dVar, GeneratedAppGlideModule generatedAppGlideModule) {
        l.b bVar;
        Context applicationContext = context.getApplicationContext();
        List<z3.b> emptyList = Collections.emptyList();
        if (generatedAppGlideModule == null || generatedAppGlideModule.c()) {
            emptyList = new z3.d(applicationContext).a();
        }
        if (generatedAppGlideModule != null && !generatedAppGlideModule.d().isEmpty()) {
            Set<Class<?>> d10 = generatedAppGlideModule.d();
            Iterator<z3.b> it = emptyList.iterator();
            while (it.hasNext()) {
                z3.b next = it.next();
                if (d10.contains(next.getClass())) {
                    if (Log.isLoggable("Glide", 3)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("AppGlideModule excludes manifest GlideModule: ");
                        sb2.append(next);
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            for (z3.b bVar2 : emptyList) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Discovered GlideModule from manifest: ");
                sb3.append(bVar2.getClass());
            }
        }
        if (generatedAppGlideModule != null) {
            bVar = generatedAppGlideModule.e();
        } else {
            bVar = null;
        }
        dVar.b(bVar);
        for (z3.b a10 : emptyList) {
            a10.a(applicationContext, dVar);
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.b(applicationContext, dVar);
        }
        c a11 = dVar.a(applicationContext);
        for (z3.b next2 : emptyList) {
            try {
                next2.b(applicationContext, a11, a11.f9158e);
            } catch (AbstractMethodError e10) {
                throw new IllegalStateException("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: " + next2.getClass().getName(), e10);
            }
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.a(applicationContext, a11, a11.f9158e);
        }
        applicationContext.registerComponentCallbacks(a11);
        f9152m = a11;
    }

    private static void q(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    @NonNull
    public static h t(@NonNull Context context) {
        return l(context).e(context);
    }

    public void b() {
        f4.k.a();
        this.f9156c.b();
        this.f9155b.b();
        this.f9159f.b();
    }

    @NonNull
    public m3.b e() {
        return this.f9159f;
    }

    @NonNull
    public m3.d f() {
        return this.f9155b;
    }

    /* access modifiers changed from: package-private */
    public y3.d g() {
        return this.f9161h;
    }

    @NonNull
    public Context h() {
        return this.f9157d.getBaseContext();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public e i() {
        return this.f9157d;
    }

    @NonNull
    public Registry j() {
        return this.f9158e;
    }

    @NonNull
    public l k() {
        return this.f9160g;
    }

    /* access modifiers changed from: package-private */
    public void o(h hVar) {
        synchronized (this.f9162j) {
            if (!this.f9162j.contains(hVar)) {
                this.f9162j.add(hVar);
            } else {
                throw new IllegalStateException("Cannot register already registered manager");
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
        b();
    }

    public void onTrimMemory(int i10) {
        r(i10);
    }

    /* access modifiers changed from: package-private */
    public boolean p(@NonNull c4.h<?> hVar) {
        synchronized (this.f9162j) {
            for (h B : this.f9162j) {
                if (B.B(hVar)) {
                    return true;
                }
            }
            return false;
        }
    }

    public void r(int i10) {
        f4.k.a();
        for (h onTrimMemory : this.f9162j) {
            onTrimMemory.onTrimMemory(i10);
        }
        this.f9156c.a(i10);
        this.f9155b.a(i10);
        this.f9159f.a(i10);
    }

    /* access modifiers changed from: package-private */
    public void s(h hVar) {
        synchronized (this.f9162j) {
            if (this.f9162j.contains(hVar)) {
                this.f9162j.remove(hVar);
            } else {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
        }
    }
}
