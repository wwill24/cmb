package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import com.google.firebase.perf.util.Constants;
import java.io.File;

public final class b {

    /* renamed from: f  reason: collision with root package name */
    private static final File f9486f = new File("/proc/self/fd");

    /* renamed from: g  reason: collision with root package name */
    private static volatile b f9487g;

    /* renamed from: a  reason: collision with root package name */
    private final boolean f9488a = d();

    /* renamed from: b  reason: collision with root package name */
    private final int f9489b;

    /* renamed from: c  reason: collision with root package name */
    private final int f9490c;

    /* renamed from: d  reason: collision with root package name */
    private int f9491d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f9492e = true;

    b() {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f9489b = 20000;
            this.f9490c = 0;
            return;
        }
        this.f9489b = Constants.FROZEN_FRAME_TIME;
        this.f9490c = 128;
    }

    public static b a() {
        if (f9487g == null) {
            synchronized (b.class) {
                if (f9487g == null) {
                    f9487g = new b();
                }
            }
        }
        return f9487g;
    }

    private synchronized boolean b() {
        boolean z10 = true;
        int i10 = this.f9491d + 1;
        this.f9491d = i10;
        if (i10 >= 50) {
            this.f9491d = 0;
            int length = f9486f.list().length;
            if (length >= this.f9489b) {
                z10 = false;
            }
            this.f9492e = z10;
            if (!z10 && Log.isLoggable("Downsampler", 5)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors ");
                sb2.append(length);
                sb2.append(", limit ");
                sb2.append(this.f9489b);
            }
        }
        return this.f9492e;
    }

    private static boolean d() {
        String str = Build.MODEL;
        if (str == null || str.length() < 7) {
            return true;
        }
        String substring = str.substring(0, 7);
        substring.hashCode();
        char c10 = 65535;
        switch (substring.hashCode()) {
            case -1398613787:
                if (substring.equals("SM-A520")) {
                    c10 = 0;
                    break;
                }
                break;
            case -1398431166:
                if (substring.equals("SM-G930")) {
                    c10 = 1;
                    break;
                }
                break;
            case -1398431161:
                if (substring.equals("SM-G935")) {
                    c10 = 2;
                    break;
                }
                break;
            case -1398431073:
                if (substring.equals("SM-G960")) {
                    c10 = 3;
                    break;
                }
                break;
            case -1398431068:
                if (substring.equals("SM-G965")) {
                    c10 = 4;
                    break;
                }
                break;
            case -1398343746:
                if (substring.equals("SM-J720")) {
                    c10 = 5;
                    break;
                }
                break;
            case -1398222624:
                if (substring.equals("SM-N935")) {
                    c10 = 6;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                if (Build.VERSION.SDK_INT != 26) {
                    return true;
                }
                return false;
            default:
                return true;
        }
    }

    public boolean c(int i10, int i11, boolean z10, boolean z11) {
        int i12;
        if (!z10 || !this.f9488a || Build.VERSION.SDK_INT < 26 || z11 || i10 < (i12 = this.f9490c) || i11 < i12 || !b()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    @TargetApi(26)
    public boolean e(int i10, int i11, BitmapFactory.Options options, boolean z10, boolean z11) {
        boolean c10 = c(i10, i11, z10, z11);
        if (c10) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return c10;
    }
}
