package androidx.camera.core;

import android.media.AudioRecord;
import android.media.CamcorderProfile;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.f2;
import androidx.camera.core.impl.g2;
import androidx.camera.core.impl.h1;
import androidx.camera.core.impl.i1;
import androidx.camera.core.impl.n1;
import androidx.camera.core.impl.v0;
import androidx.camera.core.impl.y0;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.cli.HelpFormatter;
import v.h;

@Deprecated
public final class VideoCapture extends UseCase {
    public static final d K = new d();
    private static final int[] L = {8, 6, 5, 4};
    private volatile AudioRecord A;
    private volatile int B;
    private volatile boolean C;
    private int D;
    private int E;
    private int F;
    private DeferrableSurface G;
    private final AtomicBoolean H;
    private VideoEncoderInitStatus I;
    private Throwable J;

    /* renamed from: m  reason: collision with root package name */
    private final Object f2142m;

    /* renamed from: n  reason: collision with root package name */
    private final AtomicBoolean f2143n;

    /* renamed from: o  reason: collision with root package name */
    private final AtomicBoolean f2144o;

    /* renamed from: p  reason: collision with root package name */
    private HandlerThread f2145p;

    /* renamed from: q  reason: collision with root package name */
    private Handler f2146q;

    /* renamed from: r  reason: collision with root package name */
    private HandlerThread f2147r;

    /* renamed from: s  reason: collision with root package name */
    private Handler f2148s;
    @NonNull

    /* renamed from: t  reason: collision with root package name */
    MediaCodec f2149t;
    @NonNull

    /* renamed from: u  reason: collision with root package name */
    private MediaCodec f2150u;

    /* renamed from: v  reason: collision with root package name */
    private zf.a<Void> f2151v;
    @NonNull

    /* renamed from: w  reason: collision with root package name */
    private SessionConfig.b f2152w;

    /* renamed from: x  reason: collision with root package name */
    private int f2153x;

    /* renamed from: y  reason: collision with root package name */
    private int f2154y;

    /* renamed from: z  reason: collision with root package name */
    Surface f2155z;

    enum VideoEncoderInitStatus {
        VIDEO_ENCODER_INIT_STATUS_UNINITIALIZED,
        VIDEO_ENCODER_INIT_STATUS_INITIALIZED_FAILED,
        VIDEO_ENCODER_INIT_STATUS_INSUFFICIENT_RESOURCE,
        VIDEO_ENCODER_INIT_STATUS_RESOURCE_RECLAIMED
    }

    class a implements SessionConfig.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f2161a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Size f2162b;

        a(String str, Size size) {
            this.f2161a = str;
            this.f2162b = size;
        }

        public void a(@NonNull SessionConfig sessionConfig, @NonNull SessionConfig.SessionError sessionError) {
            if (VideoCapture.this.q(this.f2161a)) {
                VideoCapture.this.Y(this.f2161a, this.f2162b);
                VideoCapture.this.u();
            }
        }
    }

    private static class b {
        static int a(MediaCodec.CodecException codecException) {
            return codecException.getErrorCode();
        }
    }

    public static final class c implements f2.a<VideoCapture, g2, c> {

        /* renamed from: a  reason: collision with root package name */
        private final i1 f2164a;

        public c() {
            this(i1.O());
        }

        @NonNull
        static c c(@NonNull Config config) {
            return new c(i1.P(config));
        }

        @NonNull
        public h1 a() {
            return this.f2164a;
        }

        @NonNull
        /* renamed from: d */
        public g2 b() {
            return new g2(n1.M(this.f2164a));
        }

        @NonNull
        public c e(int i10) {
            a().p(g2.E, Integer.valueOf(i10));
            return this;
        }

        @NonNull
        public c f(int i10) {
            a().p(g2.G, Integer.valueOf(i10));
            return this;
        }

        @NonNull
        public c g(int i10) {
            a().p(g2.H, Integer.valueOf(i10));
            return this;
        }

        @NonNull
        public c h(int i10) {
            a().p(g2.F, Integer.valueOf(i10));
            return this;
        }

        @NonNull
        public c i(int i10) {
            a().p(g2.C, Integer.valueOf(i10));
            return this;
        }

        @NonNull
        public c j(int i10) {
            a().p(g2.D, Integer.valueOf(i10));
            return this;
        }

        @NonNull
        public c k(@NonNull Size size) {
            a().p(v0.f2694l, size);
            return this;
        }

        @NonNull
        public c l(int i10) {
            a().p(f2.f2528r, Integer.valueOf(i10));
            return this;
        }

        @NonNull
        public c m(int i10) {
            a().p(v0.f2689g, Integer.valueOf(i10));
            return this;
        }

        @NonNull
        public c n(@NonNull Class<VideoCapture> cls) {
            a().p(h.f18039x, cls);
            if (a().g(h.f18038w, null) == null) {
                o(cls.getCanonicalName() + HelpFormatter.DEFAULT_OPT_PREFIX + UUID.randomUUID());
            }
            return this;
        }

        @NonNull
        public c o(@NonNull String str) {
            a().p(h.f18038w, str);
            return this;
        }

        @NonNull
        public c p(int i10) {
            a().p(g2.B, Integer.valueOf(i10));
            return this;
        }

        private c(@NonNull i1 i1Var) {
            Class<VideoCapture> cls = VideoCapture.class;
            this.f2164a = i1Var;
            Class cls2 = (Class) i1Var.g(h.f18039x, null);
            if (cls2 == null || cls2.equals(cls)) {
                n(cls);
                return;
            }
            throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls2);
        }
    }

    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        private static final Size f2165a;

        /* renamed from: b  reason: collision with root package name */
        private static final g2 f2166b;

        static {
            Size size = new Size(1920, 1080);
            f2165a = size;
            f2166b = new c().p(30).i(8388608).j(1).e(64000).h(8000).f(1).g(1024).k(size).l(3).m(1).b();
        }

        @NonNull
        public g2 a() {
            return f2166b;
        }
    }

    private AudioRecord O(g2 g2Var) {
        int i10;
        if (this.D == 1) {
            i10 = 16;
        } else {
            i10 = 12;
        }
        try {
            int minBufferSize = AudioRecord.getMinBufferSize(this.E, i10, 2);
            if (minBufferSize <= 0) {
                minBufferSize = g2Var.M();
            }
            int i11 = minBufferSize;
            AudioRecord audioRecord = new AudioRecord(5, this.E, i10, 2, i11 * 2);
            if (audioRecord.getState() != 1) {
                return null;
            }
            this.B = i11;
            v1.e("VideoCapture", "source: 5 audioSampleRate: " + this.E + " channelConfig: " + i10 + " audioFormat: " + 2 + " bufferSize: " + i11);
            return audioRecord;
        } catch (Exception e10) {
            v1.d("VideoCapture", "Exception, keep trying.", e10);
            return null;
        }
    }

    private MediaFormat P() {
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", this.E, this.D);
        createAudioFormat.setInteger("aac-profile", 2);
        createAudioFormat.setInteger("bitrate", this.F);
        return createAudioFormat;
    }

    private static MediaFormat Q(g2 g2Var, Size size) {
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", size.getWidth(), size.getHeight());
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger("bitrate", g2Var.O());
        createVideoFormat.setInteger("frame-rate", g2Var.Q());
        createVideoFormat.setInteger("i-frame-interval", g2Var.P());
        return createVideoFormat;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void S(boolean z10, MediaCodec mediaCodec) {
        if (z10 && mediaCodec != null) {
            mediaCodec.release();
        }
    }

    private void U() {
        this.f2147r.quitSafely();
        MediaCodec mediaCodec = this.f2150u;
        if (mediaCodec != null) {
            mediaCodec.release();
            this.f2150u = null;
        }
        if (this.A != null) {
            this.A.release();
            this.A = null;
        }
    }

    private void V(boolean z10) {
        DeferrableSurface deferrableSurface = this.G;
        if (deferrableSurface != null) {
            MediaCodec mediaCodec = this.f2149t;
            deferrableSurface.c();
            this.G.i().addListener(new h3(z10, mediaCodec), androidx.camera.core.impl.utils.executor.a.d());
            if (z10) {
                this.f2149t = null;
            }
            this.f2155z = null;
            this.G = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: W */
    public void R() {
        this.f2145p.quitSafely();
        U();
        if (this.f2155z != null) {
            V(true);
        }
    }

    private void X(Size size, String str) {
        boolean z10 = false;
        try {
            int[] iArr = L;
            int length = iArr.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    break;
                }
                int i11 = iArr[i10];
                if (CamcorderProfile.hasProfile(Integer.parseInt(str), i11)) {
                    CamcorderProfile camcorderProfile = CamcorderProfile.get(Integer.parseInt(str), i11);
                    if (size.getWidth() == camcorderProfile.videoFrameWidth && size.getHeight() == camcorderProfile.videoFrameHeight) {
                        this.D = camcorderProfile.audioChannels;
                        this.E = camcorderProfile.audioSampleRate;
                        this.F = camcorderProfile.audioBitRate;
                        z10 = true;
                        break;
                    }
                }
                i10++;
            }
        } catch (NumberFormatException unused) {
            v1.e("VideoCapture", "The camera Id is not an integer because the camera may be a removable device. Use the default values for the audio related settings.");
        }
        if (!z10) {
            g2 g2Var = (g2) g();
            this.D = g2Var.L();
            this.E = g2Var.N();
            this.F = g2Var.K();
        }
    }

    public void B() {
        T();
        zf.a<Void> aVar = this.f2151v;
        if (aVar != null) {
            aVar.addListener(new i3(this), androidx.camera.core.impl.utils.executor.a.d());
        } else {
            R();
        }
    }

    public void E() {
        T();
    }

    /* access modifiers changed from: protected */
    @NonNull
    public Size F(@NonNull Size size) {
        if (this.f2155z != null) {
            this.f2149t.stop();
            this.f2149t.release();
            this.f2150u.stop();
            this.f2150u.release();
            V(false);
        }
        try {
            this.f2149t = MediaCodec.createEncoderByType("video/avc");
            this.f2150u = MediaCodec.createEncoderByType("audio/mp4a-latm");
            Y(f(), size);
            s();
            return size;
        } catch (IOException e10) {
            throw new IllegalStateException("Unable to create MediaCodec due to: " + e10.getCause());
        }
    }

    /* access modifiers changed from: package-private */
    public void Y(@NonNull String str, @NonNull Size size) {
        g2 g2Var = (g2) g();
        this.f2149t.reset();
        this.I = VideoEncoderInitStatus.VIDEO_ENCODER_INIT_STATUS_UNINITIALIZED;
        try {
            this.f2149t.configure(Q(g2Var, size), (Surface) null, (MediaCrypto) null, 1);
            if (this.f2155z != null) {
                V(false);
            }
            Surface createInputSurface = this.f2149t.createInputSurface();
            this.f2155z = createInputSurface;
            this.f2152w = SessionConfig.b.o(g2Var);
            DeferrableSurface deferrableSurface = this.G;
            if (deferrableSurface != null) {
                deferrableSurface.c();
            }
            y0 y0Var = new y0(this.f2155z, size, i());
            this.G = y0Var;
            zf.a<Void> i10 = y0Var.i();
            Objects.requireNonNull(createInputSurface);
            i10.addListener(new j3(createInputSurface), androidx.camera.core.impl.utils.executor.a.d());
            this.f2152w.h(this.G);
            this.f2152w.f(new a(str, size));
            J(this.f2152w.m());
            this.H.set(true);
            X(size, str);
            this.f2150u.reset();
            this.f2150u.configure(P(), (Surface) null, (MediaCrypto) null, 1);
            if (this.A != null) {
                this.A.release();
            }
            this.A = O(g2Var);
            if (this.A == null) {
                v1.c("VideoCapture", "AudioRecord object cannot initialized correctly!");
                this.H.set(false);
            }
            synchronized (this.f2142m) {
                this.f2153x = -1;
                this.f2154y = -1;
            }
            this.C = false;
        } catch (MediaCodec.CodecException e10) {
            int a10 = b.a(e10);
            String diagnosticInfo = e10.getDiagnosticInfo();
            if (a10 == 1100) {
                v1.e("VideoCapture", "CodecException: code: " + a10 + " diagnostic: " + diagnosticInfo);
                this.I = VideoEncoderInitStatus.VIDEO_ENCODER_INIT_STATUS_INSUFFICIENT_RESOURCE;
            } else if (a10 == 1101) {
                v1.e("VideoCapture", "CodecException: code: " + a10 + " diagnostic: " + diagnosticInfo);
                this.I = VideoEncoderInitStatus.VIDEO_ENCODER_INIT_STATUS_RESOURCE_RECLAIMED;
            }
            this.J = e10;
        } catch (IllegalArgumentException | IllegalStateException e11) {
            this.I = VideoEncoderInitStatus.VIDEO_ENCODER_INIT_STATUS_INITIALIZED_FAILED;
            this.J = e11;
        }
    }

    /* renamed from: Z */
    public void T() {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            androidx.camera.core.impl.utils.executor.a.d().execute(new g3(this));
            return;
        }
        v1.e("VideoCapture", "stopRecording");
        this.f2152w.n();
        this.f2152w.h(this.G);
        J(this.f2152w.m());
        w();
        if (!this.C) {
            return;
        }
        if (this.H.get()) {
            this.f2144o.set(true);
        } else {
            this.f2143n.set(true);
        }
    }

    public f2<?> h(boolean z10, @NonNull UseCaseConfigFactory useCaseConfigFactory) {
        Config a10 = useCaseConfigFactory.a(UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE, 1);
        if (z10) {
            a10 = Config.D(a10, K.a());
        }
        if (a10 == null) {
            return null;
        }
        return o(a10).b();
    }

    @NonNull
    public f2.a<?, ?, ?> o(@NonNull Config config) {
        return c.c(config);
    }

    public void y() {
        this.f2145p = new HandlerThread("CameraX-video encoding thread");
        this.f2147r = new HandlerThread("CameraX-audio encoding thread");
        this.f2145p.start();
        this.f2146q = new Handler(this.f2145p.getLooper());
        this.f2147r.start();
        this.f2148s = new Handler(this.f2147r.getLooper());
    }
}
