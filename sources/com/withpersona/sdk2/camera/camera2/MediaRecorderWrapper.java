package com.withpersona.sdk2.camera.camera2;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaRecorder;
import android.os.Build;
import android.view.Surface;
import com.mparticle.identity.IdentityHttpResponse;
import com.withpersona.sdk2.camera.c;
import com.withpersona.sdk2.camera.d;
import java.io.File;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.h;
import kotlinx.coroutines.x0;

public final class MediaRecorderWrapper {

    /* renamed from: j  reason: collision with root package name */
    public static final a f14315j = new a((DefaultConstructorMarker) null);

    /* renamed from: k  reason: collision with root package name */
    private static final boolean f14316k = true;

    /* renamed from: a  reason: collision with root package name */
    private final Context f14317a;

    /* renamed from: b  reason: collision with root package name */
    private final f f14318b;

    /* renamed from: c  reason: collision with root package name */
    private final int f14319c;

    /* renamed from: d  reason: collision with root package name */
    private final int f14320d;

    /* renamed from: e  reason: collision with root package name */
    private Function0<Unit> f14321e;

    /* renamed from: f  reason: collision with root package name */
    private final Surface f14322f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public File f14323g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public MediaRecorder f14324h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f14325i;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public MediaRecorderWrapper(Context context, f fVar, int i10, int i11) {
        Surface surface;
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(fVar, "cameraChoice");
        this.f14317a = context;
        this.f14318b = fVar;
        this.f14319c = i10;
        this.f14320d = i11;
        if (f14316k) {
            surface = MediaCodec.createPersistentInputSurface();
        } else {
            surface = null;
        }
        this.f14322f = surface;
        this.f14323g = i();
        this.f14324h = j();
    }

    private final int g() {
        int width = this.f14318b.c().getWidth() * this.f14318b.c().getHeight();
        if (width <= 172800) {
            return 400000;
        }
        if (width <= 409920) {
            return 500000;
        }
        if (width <= 921600) {
            return 1500000;
        }
        if (width <= 2073600) {
            return 3000000;
        }
        return width <= 3686400 ? 6000000 : 10000000;
    }

    private final File i() {
        File cacheDir = this.f14317a.getCacheDir();
        return new File(cacheDir, "video_recording_" + System.currentTimeMillis() + ".mp4");
    }

    /* access modifiers changed from: private */
    public final MediaRecorder j() {
        if (Build.VERSION.SDK_INT >= 31) {
            return new MediaRecorder(this.f14317a);
        }
        return new MediaRecorder();
    }

    /* access modifiers changed from: private */
    public final void k(boolean z10) {
        if (!z10) {
            this.f14323g = i();
        }
        m(z10);
    }

    private final void m(boolean z10) {
        Function0<Unit> function0;
        this.f14324h.setVideoEncodingBitRate(g());
        this.f14324h.setAudioSource(1);
        this.f14324h.setVideoSource(2);
        this.f14324h.setOutputFormat(2);
        this.f14324h.setVideoFrameRate(this.f14319c);
        this.f14324h.setVideoSize(this.f14318b.c().getWidth(), this.f14318b.c().getHeight());
        this.f14324h.setVideoEncoder(2);
        c a10 = d.a();
        if (a10 != null) {
            this.f14324h.setAudioSamplingRate(a10.a());
            this.f14324h.setAudioChannels(1);
        }
        this.f14324h.setAudioEncoder(3);
        this.f14324h.setOrientationHint(this.f14320d);
        boolean z11 = f14316k;
        if (z11) {
            this.f14324h.setInputSurface(h());
        }
        this.f14324h.setOutputFile(this.f14323g.getAbsolutePath());
        this.f14324h.prepare();
        if (!z11 && !z10 && (function0 = this.f14321e) != null) {
            function0.invoke();
        }
    }

    public final void f() {
        h().release();
        try {
            this.f14324h.stop();
        } catch (RuntimeException unused) {
        } catch (Throwable th2) {
            this.f14323g.delete();
            throw th2;
        }
        this.f14323g.delete();
    }

    public final Surface h() {
        Surface surface = this.f14322f;
        return surface == null ? this.f14324h.getSurface() : surface;
    }

    public final void l() {
        if (!this.f14325i) {
            this.f14325i = true;
            k(true);
        }
    }

    public final void n(Function0<Unit> function0) {
        this.f14321e = function0;
    }

    public final Object o(kotlin.coroutines.c<? super Unit> cVar) {
        Object g10 = h.g(x0.a(), new MediaRecorderWrapper$startRecording$2(this, (kotlin.coroutines.c<? super MediaRecorderWrapper$startRecording$2>) null), cVar);
        return g10 == b.d() ? g10 : Unit.f32013a;
    }

    public final Object p(kotlin.coroutines.c<? super File> cVar) {
        return h.g(x0.a(), new MediaRecorderWrapper$stopRecording$2(this, (kotlin.coroutines.c<? super MediaRecorderWrapper$stopRecording$2>) null), cVar);
    }
}
