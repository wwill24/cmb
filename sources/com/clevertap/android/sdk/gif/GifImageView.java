package com.clevertap.android.sdk.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;

public class GifImageView extends AppCompatImageView implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private boolean f10222a;

    /* renamed from: b  reason: collision with root package name */
    private c f10223b = null;

    /* renamed from: c  reason: collision with root package name */
    private d f10224c = null;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Thread f10225d;

    /* renamed from: e  reason: collision with root package name */
    private e f10226e = null;

    /* renamed from: f  reason: collision with root package name */
    private long f10227f = -1;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public a f10228g;

    /* renamed from: h  reason: collision with root package name */
    private final Handler f10229h = new Handler(Looper.getMainLooper());

    /* renamed from: j  reason: collision with root package name */
    private boolean f10230j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public boolean f10231k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public Bitmap f10232l;

    /* renamed from: m  reason: collision with root package name */
    private final Runnable f10233m = new a();

    /* renamed from: n  reason: collision with root package name */
    private final Runnable f10234n = new b();

    class a implements Runnable {
        a() {
        }

        public void run() {
            Bitmap unused = GifImageView.this.f10232l = null;
            a unused2 = GifImageView.this.f10228g = null;
            Thread unused3 = GifImageView.this.f10225d = null;
            boolean unused4 = GifImageView.this.f10231k = false;
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            if (GifImageView.this.f10232l != null && !GifImageView.this.f10232l.isRecycled()) {
                GifImageView gifImageView = GifImageView.this;
                gifImageView.setImageBitmap(gifImageView.f10232l);
                GifImageView.this.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
        }
    }

    public interface c {
        void a();
    }

    public interface d {
        void a();
    }

    public interface e {
        Bitmap a(Bitmap bitmap);
    }

    public GifImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private boolean h() {
        return (this.f10222a || this.f10230j) && this.f10228g != null && this.f10225d == null;
    }

    private void l() {
        if (h()) {
            Thread thread = new Thread(this);
            this.f10225d = thread;
            thread.start();
        }
    }

    public int getFrameCount() {
        return this.f10228g.g();
    }

    public long getFramesDisplayDuration() {
        return this.f10227f;
    }

    public int getGifHeight() {
        return this.f10228g.i();
    }

    public int getGifWidth() {
        return this.f10228g.m();
    }

    public d getOnAnimationStop() {
        return this.f10224c;
    }

    public e getOnFrameAvailable() {
        return this.f10226e;
    }

    public void i() {
        this.f10222a = false;
        this.f10230j = false;
        this.f10231k = true;
        m();
        this.f10229h.post(this.f10233m);
    }

    public void j(int i10) {
        if (this.f10228g.e() != i10 && this.f10228g.w(i10 - 1) && !this.f10222a) {
            this.f10230j = true;
            l();
        }
    }

    public void k() {
        this.f10222a = true;
        l();
    }

    public void m() {
        this.f10222a = false;
        Thread thread = this.f10225d;
        if (thread != null) {
            thread.interrupt();
            this.f10225d = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i();
    }

    public void run() {
        long j10;
        c cVar = this.f10223b;
        if (cVar != null) {
            cVar.a();
        }
        while (true) {
            if (!this.f10222a && !this.f10230j) {
                break;
            }
            boolean a10 = this.f10228g.a();
            try {
                long nanoTime = System.nanoTime();
                Bitmap l10 = this.f10228g.l();
                this.f10232l = l10;
                e eVar = this.f10226e;
                if (eVar != null) {
                    this.f10232l = eVar.a(l10);
                }
                j10 = (System.nanoTime() - nanoTime) / 1000000;
                try {
                    this.f10229h.post(this.f10234n);
                } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException unused) {
                }
            } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException unused2) {
                j10 = 0;
            }
            this.f10230j = false;
            if (this.f10222a && a10) {
                try {
                    int k10 = (int) (((long) this.f10228g.k()) - j10);
                    if (k10 > 0) {
                        long j11 = this.f10227f;
                        if (j11 <= 0) {
                            j11 = (long) k10;
                        }
                        Thread.sleep(j11);
                    }
                } catch (InterruptedException unused3) {
                }
                if (!this.f10222a) {
                    break;
                }
            } else {
                this.f10222a = false;
            }
        }
        if (this.f10231k) {
            this.f10229h.post(this.f10233m);
        }
        this.f10225d = null;
        d dVar = this.f10224c;
        if (dVar != null) {
            dVar.a();
        }
    }

    public void setBytes(byte[] bArr) {
        a aVar = new a();
        this.f10228g = aVar;
        try {
            aVar.n(bArr);
            if (this.f10222a) {
                l();
            } else {
                j(0);
            }
        } catch (Exception unused) {
            this.f10228g = null;
        }
    }

    public void setFramesDisplayDuration(long j10) {
        this.f10227f = j10;
    }

    public void setOnAnimationStart(c cVar) {
        this.f10223b = cVar;
    }

    public void setOnAnimationStop(d dVar) {
        this.f10224c = dVar;
    }

    public void setOnFrameAvailable(e eVar) {
        this.f10226e = eVar;
    }
}
