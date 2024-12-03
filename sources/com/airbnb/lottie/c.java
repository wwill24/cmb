package com.airbnb.lottie;

import a3.b;
import a3.d;
import a3.e;
import a3.f;
import a3.g;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.os.m;
import java.io.File;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f8524a = false;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f8525b = false;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f8526c = true;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f8527d = true;

    /* renamed from: e  reason: collision with root package name */
    private static String[] f8528e;

    /* renamed from: f  reason: collision with root package name */
    private static long[] f8529f;

    /* renamed from: g  reason: collision with root package name */
    private static int f8530g;

    /* renamed from: h  reason: collision with root package name */
    private static int f8531h;

    /* renamed from: i  reason: collision with root package name */
    private static e f8532i;

    /* renamed from: j  reason: collision with root package name */
    private static d f8533j;

    /* renamed from: k  reason: collision with root package name */
    private static volatile g f8534k;

    /* renamed from: l  reason: collision with root package name */
    private static volatile f f8535l;

    class a implements d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f8536a;

        a(Context context) {
            this.f8536a = context;
        }

        @NonNull
        public File a() {
            return new File(this.f8536a.getCacheDir(), "lottie_network_cache");
        }
    }

    public static void a(String str) {
        if (f8525b) {
            int i10 = f8530g;
            if (i10 == 20) {
                f8531h++;
                return;
            }
            f8528e[i10] = str;
            f8529f[i10] = System.nanoTime();
            m.a(str);
            f8530g++;
        }
    }

    public static float b(String str) {
        int i10 = f8531h;
        if (i10 > 0) {
            f8531h = i10 - 1;
            return 0.0f;
        } else if (!f8525b) {
            return 0.0f;
        } else {
            int i11 = f8530g - 1;
            f8530g = i11;
            if (i11 == -1) {
                throw new IllegalStateException("Can't end trace section. There are none.");
            } else if (str.equals(f8528e[i11])) {
                m.b();
                return ((float) (System.nanoTime() - f8529f[f8530g])) / 1000000.0f;
            } else {
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + f8528e[f8530g] + ".");
            }
        }
    }

    public static boolean c() {
        return f8527d;
    }

    public static f d(@NonNull Context context) {
        if (!f8526c) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        f fVar = f8535l;
        if (fVar == null) {
            synchronized (f.class) {
                fVar = f8535l;
                if (fVar == null) {
                    d dVar = f8533j;
                    if (dVar == null) {
                        dVar = new a(applicationContext);
                    }
                    fVar = new f(dVar);
                    f8535l = fVar;
                }
            }
        }
        return fVar;
    }

    @NonNull
    public static g e(@NonNull Context context) {
        g gVar = f8534k;
        if (gVar == null) {
            synchronized (g.class) {
                gVar = f8534k;
                if (gVar == null) {
                    f d10 = d(context);
                    e eVar = f8532i;
                    if (eVar == null) {
                        eVar = new b();
                    }
                    gVar = new g(d10, eVar);
                    f8534k = gVar;
                }
            }
        }
        return gVar;
    }
}
