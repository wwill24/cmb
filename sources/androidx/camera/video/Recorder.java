package androidx.camera.video;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.location.Location;
import android.media.MediaMuxer;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Pair;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.Timebase;
import androidx.camera.core.impl.j1;
import androidx.camera.core.impl.l1;
import androidx.camera.core.impl.x1;
import androidx.camera.core.v1;
import androidx.camera.video.StreamInfo;
import androidx.camera.video.VideoOutput;
import androidx.camera.video.i0;
import androidx.camera.video.internal.AudioSource;
import androidx.camera.video.internal.AudioSourceAccessException;
import androidx.camera.video.internal.ResourceCreationException;
import androidx.camera.video.internal.encoder.EncodeException;
import androidx.camera.video.internal.encoder.EncoderImpl;
import androidx.camera.video.internal.encoder.InvalidConfigException;
import androidx.camera.video.internal.encoder.e1;
import androidx.camera.video.internal.encoder.j;
import androidx.camera.video.internal.encoder.k;
import androidx.camera.video.internal.encoder.m;
import androidx.camera.video.n;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import b0.l;
import b0.n;
import b0.o;
import b0.p;
import b0.q;
import b0.r;
import b0.s;
import g0.i;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class Recorder implements VideoOutput {
    private static final Set<State> V = Collections.unmodifiableSet(EnumSet.of(State.PENDING_RECORDING, State.PENDING_PAUSED));
    private static final Set<State> W = Collections.unmodifiableSet(EnumSet.of(State.INITIALIZING, State.IDLING, State.RESETTING, State.STOPPING, State.ERROR));
    public static final r X;
    private static final j0 Y;
    private static final n Z;

    /* renamed from: a0  reason: collision with root package name */
    private static final Exception f2994a0 = new RuntimeException("The video frame producer became inactive before any data was received.");

    /* renamed from: b0  reason: collision with root package name */
    static final m f2995b0 = new n();

    /* renamed from: c0  reason: collision with root package name */
    private static final Executor f2996c0 = androidx.camera.core.impl.utils.executor.a.f(androidx.camera.core.impl.utils.executor.a.c());
    final j1<n> A;
    AudioSource B = null;
    j C = null;
    e1 D = null;
    j E = null;
    e1 F = null;
    AudioState G = AudioState.INITIALIZING;
    @NonNull
    Uri H = Uri.EMPTY;
    long I = 0;
    long J = 0;
    long K = 0;
    long L = 0;
    long M = 0;
    int N = 1;
    Throwable O = null;
    androidx.camera.video.internal.encoder.g P = null;
    @NonNull
    final z.b<androidx.camera.video.internal.encoder.g> Q = new z.a(60);
    Throwable R = null;
    boolean S = false;
    VideoOutput.SourceState T = VideoOutput.SourceState.INACTIVE;
    private ScheduledFuture<?> U = null;

    /* renamed from: a  reason: collision with root package name */
    private final j1<StreamInfo> f2997a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f2998b;

    /* renamed from: c  reason: collision with root package name */
    private final Executor f2999c;

    /* renamed from: d  reason: collision with root package name */
    final Executor f3000d;

    /* renamed from: e  reason: collision with root package name */
    private final m f3001e;

    /* renamed from: f  reason: collision with root package name */
    private final m f3002f;

    /* renamed from: g  reason: collision with root package name */
    private final Object f3003g = new Object();

    /* renamed from: h  reason: collision with root package name */
    private State f3004h = State.INITIALIZING;

    /* renamed from: i  reason: collision with root package name */
    private State f3005i = null;

    /* renamed from: j  reason: collision with root package name */
    int f3006j = 0;

    /* renamed from: k  reason: collision with root package name */
    h f3007k = null;

    /* renamed from: l  reason: collision with root package name */
    h f3008l = null;

    /* renamed from: m  reason: collision with root package name */
    private long f3009m = 0;

    /* renamed from: n  reason: collision with root package name */
    private h f3010n = null;

    /* renamed from: o  reason: collision with root package name */
    private boolean f3011o;

    /* renamed from: p  reason: collision with root package name */
    boolean f3012p = false;

    /* renamed from: q  reason: collision with root package name */
    private SurfaceRequest.f f3013q = null;

    /* renamed from: r  reason: collision with root package name */
    private androidx.camera.core.impl.m f3014r = null;

    /* renamed from: s  reason: collision with root package name */
    final List<zf.a<Void>> f3015s = new ArrayList();

    /* renamed from: t  reason: collision with root package name */
    Integer f3016t = null;

    /* renamed from: u  reason: collision with root package name */
    Integer f3017u = null;

    /* renamed from: v  reason: collision with root package name */
    SurfaceRequest f3018v;

    /* renamed from: w  reason: collision with root package name */
    Timebase f3019w;

    /* renamed from: x  reason: collision with root package name */
    Surface f3020x = null;

    /* renamed from: y  reason: collision with root package name */
    Surface f3021y = null;

    /* renamed from: z  reason: collision with root package name */
    MediaMuxer f3022z = null;

    enum AudioState {
        INITIALIZING,
        IDLING,
        DISABLED,
        ACTIVE,
        ERROR
    }

    enum State {
        INITIALIZING,
        PENDING_RECORDING,
        PENDING_PAUSED,
        IDLING,
        RECORDING,
        PAUSED,
        STOPPING,
        RESETTING,
        ERROR
    }

    class a implements u.c<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AudioSource f3039a;

        a(AudioSource audioSource) {
            this.f3039a = audioSource;
        }

        /* renamed from: a */
        public void onSuccess(Void voidR) {
            v1.a("Recorder", String.format("Released audio source successfully: 0x%x", new Object[]{Integer.valueOf(this.f3039a.hashCode())}));
        }

        public void onFailure(@NonNull Throwable th2) {
            v1.a("Recorder", String.format("An error occurred while attempting to release audio source: 0x%x", new Object[]{Integer.valueOf(this.f3039a.hashCode())}));
        }
    }

    class b implements k {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CallbackToFutureAdapter.a f3041b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ h f3042c;

        b(CallbackToFutureAdapter.a aVar, h hVar) {
            this.f3041b = aVar;
            this.f3042c = hVar;
        }

        public void a(@NonNull e1 e1Var) {
            Recorder.this.D = e1Var;
        }

        public void b() {
            this.f3041b.c(null);
        }

        public void c(@NonNull androidx.camera.video.internal.encoder.g gVar) {
            Recorder recorder = Recorder.this;
            if (recorder.f3022z != null) {
                try {
                    recorder.E0(gVar, this.f3042c);
                    if (gVar != null) {
                        gVar.close();
                        return;
                    }
                    return;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            } else if (!recorder.f3012p) {
                boolean z10 = false;
                androidx.camera.video.internal.encoder.g gVar2 = recorder.P;
                if (gVar2 != null) {
                    z10 = true;
                    gVar2.close();
                    Recorder.this.P = null;
                }
                if (gVar.d0()) {
                    Recorder recorder2 = Recorder.this;
                    recorder2.P = gVar;
                    if (!recorder2.F() || !Recorder.this.Q.isEmpty()) {
                        v1.a("Recorder", "Received video keyframe. Starting muxer...");
                        Recorder.this.q0(this.f3042c);
                        return;
                    } else if (z10) {
                        v1.a("Recorder", "Replaced cached video keyframe with newer keyframe.");
                        return;
                    } else {
                        v1.a("Recorder", "Cached video keyframe while we wait for first audio sample before starting muxer.");
                        return;
                    }
                } else {
                    if (z10) {
                        v1.a("Recorder", "Dropped cached keyframe since we have new video data and have not yet received audio data.");
                    }
                    v1.a("Recorder", "Dropped video data since muxer has not yet started and data is not a keyframe.");
                    Recorder.this.C.d();
                    gVar.close();
                    return;
                }
            } else {
                v1.a("Recorder", "Drop video data since recording is stopping.");
                gVar.close();
                return;
            }
            throw th;
        }

        public void e() {
        }

        public void f(@NonNull EncodeException encodeException) {
            this.f3041b.f(encodeException);
        }
    }

    class c implements AudioSource.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ androidx.core.util.a f3044a;

        c(androidx.core.util.a aVar) {
            this.f3044a = aVar;
        }

        public void a(boolean z10) {
            IllegalStateException illegalStateException;
            Recorder recorder = Recorder.this;
            if (recorder.S != z10) {
                recorder.S = z10;
                if (z10) {
                    illegalStateException = new IllegalStateException("The audio source has been silenced.");
                } else {
                    illegalStateException = null;
                }
                recorder.R = illegalStateException;
                Recorder.this.B0();
                return;
            }
            v1.l("Recorder", "Audio source silenced transitions to the same state " + z10);
        }

        public void onError(@NonNull Throwable th2) {
            v1.d("Recorder", "Error occurred after audio source started.", th2);
            if (th2 instanceof AudioSourceAccessException) {
                this.f3044a.accept(th2);
            }
        }
    }

    class d implements k {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CallbackToFutureAdapter.a f3046b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ androidx.core.util.a f3047c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ h f3048d;

        d(CallbackToFutureAdapter.a aVar, androidx.core.util.a aVar2, h hVar) {
            this.f3046b = aVar;
            this.f3047c = aVar2;
            this.f3048d = hVar;
        }

        public void a(@NonNull e1 e1Var) {
            Recorder.this.F = e1Var;
        }

        public void b() {
            this.f3046b.c(null);
        }

        public void c(@NonNull androidx.camera.video.internal.encoder.g gVar) {
            Recorder recorder = Recorder.this;
            if (recorder.G == AudioState.DISABLED) {
                throw new AssertionError("Audio is not enabled but audio encoded data is produced.");
            } else if (recorder.f3022z == null) {
                if (!recorder.f3012p) {
                    recorder.Q.b(new androidx.camera.video.internal.encoder.f(gVar));
                    if (Recorder.this.P != null) {
                        v1.a("Recorder", "Received audio data. Starting muxer...");
                        Recorder.this.q0(this.f3048d);
                    } else {
                        v1.a("Recorder", "Cached audio data while we wait for video keyframe before starting muxer.");
                    }
                } else {
                    v1.a("Recorder", "Drop audio data since recording is stopping.");
                }
                gVar.close();
                return;
            } else {
                try {
                    recorder.D0(gVar, this.f3048d);
                    if (gVar != null) {
                        gVar.close();
                        return;
                    }
                    return;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }

        public void e() {
        }

        public void f(@NonNull EncodeException encodeException) {
            if (Recorder.this.R == null) {
                this.f3047c.accept(encodeException);
            }
        }
    }

    class e implements u.c<List<Void>> {
        e() {
        }

        /* renamed from: a */
        public void onSuccess(List<Void> list) {
            v1.a("Recorder", "Encodings end successfully.");
            Recorder recorder = Recorder.this;
            recorder.w(recorder.N, recorder.O);
        }

        public void onFailure(@NonNull Throwable th2) {
            v1.a("Recorder", "Encodings end with error: " + th2);
            Recorder.this.w(6, th2);
        }
    }

    static /* synthetic */ class f {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3051a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f3052b;

        /* JADX WARNING: Can't wrap try/catch for region: R(31:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|(2:17|18)|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|40) */
        /* JADX WARNING: Can't wrap try/catch for region: R(33:0|(2:1|2)|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|40) */
        /* JADX WARNING: Can't wrap try/catch for region: R(35:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|40) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x004f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0059 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0063 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x006d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0077 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0082 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x008d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0099 */
        static {
            /*
                androidx.camera.video.Recorder$AudioState[] r0 = androidx.camera.video.Recorder.AudioState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3052b = r0
                r1 = 1
                androidx.camera.video.Recorder$AudioState r2 = androidx.camera.video.Recorder.AudioState.ERROR     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f3052b     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.camera.video.Recorder$AudioState r3 = androidx.camera.video.Recorder.AudioState.ACTIVE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f3052b     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.camera.video.Recorder$AudioState r4 = androidx.camera.video.Recorder.AudioState.DISABLED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f3052b     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.camera.video.Recorder$AudioState r5 = androidx.camera.video.Recorder.AudioState.IDLING     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = f3052b     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.camera.video.Recorder$AudioState r6 = androidx.camera.video.Recorder.AudioState.INITIALIZING     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                androidx.camera.video.Recorder$State[] r5 = androidx.camera.video.Recorder.State.values()
                int r5 = r5.length
                int[] r5 = new int[r5]
                f3051a = r5
                androidx.camera.video.Recorder$State r6 = androidx.camera.video.Recorder.State.STOPPING     // Catch:{ NoSuchFieldError -> 0x004f }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x004f }
                r5[r6] = r1     // Catch:{ NoSuchFieldError -> 0x004f }
            L_0x004f:
                int[] r1 = f3051a     // Catch:{ NoSuchFieldError -> 0x0059 }
                androidx.camera.video.Recorder$State r5 = androidx.camera.video.Recorder.State.RESETTING     // Catch:{ NoSuchFieldError -> 0x0059 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0059 }
                r1[r5] = r0     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                int[] r0 = f3051a     // Catch:{ NoSuchFieldError -> 0x0063 }
                androidx.camera.video.Recorder$State r1 = androidx.camera.video.Recorder.State.PENDING_RECORDING     // Catch:{ NoSuchFieldError -> 0x0063 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0063 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0063 }
            L_0x0063:
                int[] r0 = f3051a     // Catch:{ NoSuchFieldError -> 0x006d }
                androidx.camera.video.Recorder$State r1 = androidx.camera.video.Recorder.State.PENDING_PAUSED     // Catch:{ NoSuchFieldError -> 0x006d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                int[] r0 = f3051a     // Catch:{ NoSuchFieldError -> 0x0077 }
                androidx.camera.video.Recorder$State r1 = androidx.camera.video.Recorder.State.INITIALIZING     // Catch:{ NoSuchFieldError -> 0x0077 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0077 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0077 }
            L_0x0077:
                int[] r0 = f3051a     // Catch:{ NoSuchFieldError -> 0x0082 }
                androidx.camera.video.Recorder$State r1 = androidx.camera.video.Recorder.State.IDLING     // Catch:{ NoSuchFieldError -> 0x0082 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0082 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0082 }
            L_0x0082:
                int[] r0 = f3051a     // Catch:{ NoSuchFieldError -> 0x008d }
                androidx.camera.video.Recorder$State r1 = androidx.camera.video.Recorder.State.RECORDING     // Catch:{ NoSuchFieldError -> 0x008d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008d }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x008d }
            L_0x008d:
                int[] r0 = f3051a     // Catch:{ NoSuchFieldError -> 0x0099 }
                androidx.camera.video.Recorder$State r1 = androidx.camera.video.Recorder.State.PAUSED     // Catch:{ NoSuchFieldError -> 0x0099 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0099 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0099 }
            L_0x0099:
                int[] r0 = f3051a     // Catch:{ NoSuchFieldError -> 0x00a5 }
                androidx.camera.video.Recorder$State r1 = androidx.camera.video.Recorder.State.ERROR     // Catch:{ NoSuchFieldError -> 0x00a5 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a5 }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a5 }
            L_0x00a5:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.Recorder.f.<clinit>():void");
        }
    }

    public static final class g {

        /* renamed from: a  reason: collision with root package name */
        private final n.a f3053a;

        /* renamed from: b  reason: collision with root package name */
        private Executor f3054b = null;

        /* renamed from: c  reason: collision with root package name */
        private m f3055c;

        /* renamed from: d  reason: collision with root package name */
        private m f3056d;

        public g() {
            m mVar = Recorder.f2995b0;
            this.f3055c = mVar;
            this.f3056d = mVar;
            this.f3053a = n.a();
        }

        @NonNull
        public Recorder b() {
            return new Recorder(this.f3054b, this.f3053a.a(), this.f3055c, this.f3056d);
        }

        @NonNull
        public g d(@NonNull Executor executor) {
            androidx.core.util.h.h(executor, "The specified executor can't be null.");
            this.f3054b = executor;
            return this;
        }

        @NonNull
        public g e(@NonNull r rVar) {
            androidx.core.util.h.h(rVar, "The specified quality selector can't be null.");
            this.f3053a.b(new s(rVar));
            return this;
        }
    }

    static abstract class h implements AutoCloseable {

        /* renamed from: a  reason: collision with root package name */
        private final androidx.camera.core.impl.utils.d f3057a = androidx.camera.core.impl.utils.d.b();

        /* renamed from: b  reason: collision with root package name */
        private final AtomicBoolean f3058b = new AtomicBoolean(false);

        /* renamed from: c  reason: collision with root package name */
        private final AtomicReference<d> f3059c = new AtomicReference<>((Object) null);

        /* renamed from: d  reason: collision with root package name */
        private final AtomicReference<c> f3060d = new AtomicReference<>((Object) null);

        /* renamed from: e  reason: collision with root package name */
        private final AtomicReference<androidx.core.util.a<Uri>> f3061e = new AtomicReference<>(new b0());

        class a implements c {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Context f3062a;

            a(Context context) {
                this.f3062a = context;
            }

            @NonNull
            public AudioSource a(@NonNull AudioSource.f fVar, @NonNull Executor executor) throws AudioSourceAccessException {
                return new AudioSource(fVar, executor, this.f3062a);
            }
        }

        class b implements c {
            b() {
            }

            @NonNull
            public AudioSource a(@NonNull AudioSource.f fVar, @NonNull Executor executor) throws AudioSourceAccessException {
                return new AudioSource(fVar, executor, (Context) null);
            }
        }

        private interface c {
            @NonNull
            AudioSource a(@NonNull AudioSource.f fVar, @NonNull Executor executor) throws AudioSourceAccessException;
        }

        private interface d {
            @NonNull
            MediaMuxer a(int i10, @NonNull androidx.core.util.a<Uri> aVar) throws IOException;
        }

        h() {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ MediaMuxer E(b0.e eVar, ParcelFileDescriptor parcelFileDescriptor, int i10, androidx.core.util.a aVar) throws IOException {
            MediaMuxer mediaMuxer;
            MediaMuxer mediaMuxer2;
            Uri uri = Uri.EMPTY;
            if (eVar instanceof b0.c) {
                File c10 = ((b0.c) eVar).c();
                if (!h0.a.a(c10)) {
                    v1.l("Recorder", "Failed to create folder for " + c10.getAbsolutePath());
                }
                mediaMuxer = new MediaMuxer(c10.getAbsolutePath(), i10);
                uri = Uri.fromFile(c10);
            } else if (eVar instanceof b0.b) {
                if (Build.VERSION.SDK_INT >= 26) {
                    mediaMuxer = e0.c.a(parcelFileDescriptor.getFileDescriptor(), i10);
                } else {
                    throw new IOException("MediaMuxer doesn't accept FileDescriptor as output destination.");
                }
            } else if (eVar instanceof b0.d) {
                b0.d dVar = (b0.d) eVar;
                ContentValues contentValues = new ContentValues(dVar.e());
                int i11 = Build.VERSION.SDK_INT;
                if (i11 >= 29) {
                    contentValues.put("is_pending", 1);
                }
                Uri insert = dVar.d().insert(dVar.c(), contentValues);
                if (insert != null) {
                    if (i11 < 26) {
                        String b10 = h0.a.b(dVar.d(), insert, "_data");
                        if (b10 != null) {
                            if (!h0.a.a(new File(b10))) {
                                v1.l("Recorder", "Failed to create folder for " + b10);
                            }
                            mediaMuxer2 = new MediaMuxer(b10, i10);
                        } else {
                            throw new IOException("Unable to get path from uri " + insert);
                        }
                    } else {
                        ParcelFileDescriptor openFileDescriptor = dVar.d().openFileDescriptor(insert, "rw");
                        mediaMuxer2 = e0.c.a(openFileDescriptor.getFileDescriptor(), i10);
                        openFileDescriptor.close();
                    }
                    uri = insert;
                    mediaMuxer = mediaMuxer2;
                } else {
                    throw new IOException("Unable to create MediaStore entry.");
                }
            } else {
                throw new AssertionError("Invalid output options type: " + eVar.getClass().getSimpleName());
            }
            aVar.accept(uri);
            return mediaMuxer;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void F(b0.d dVar, Uri uri) {
            if (!uri.equals(Uri.EMPTY)) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("is_pending", 0);
                dVar.d().update(uri, contentValues, (String) null, (String[]) null);
            }
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void G(String str, Uri uri) {
            if (uri == null) {
                v1.c("Recorder", String.format("File scanning operation failed [path: %s]", new Object[]{str}));
                return;
            }
            v1.a("Recorder", String.format("File scan completed successfully [path: %s, URI: %s]", new Object[]{str, uri}));
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void I(b0.d dVar, Context context, Uri uri) {
            if (!uri.equals(Uri.EMPTY)) {
                String b10 = h0.a.b(dVar.d(), uri, "_data");
                if (b10 != null) {
                    MediaScannerConnection.scanFile(context, new String[]{b10}, (String[]) null, new c0());
                    return;
                }
                v1.a("Recorder", "Skipping media scanner scan. Unable to retrieve file path from URI: " + uri);
            }
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void J(ParcelFileDescriptor parcelFileDescriptor, Uri uri) {
            try {
                parcelFileDescriptor.close();
            } catch (IOException e10) {
                v1.d("Recorder", "Failed to close dup'd ParcelFileDescriptor", e10);
            }
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void L(Uri uri) {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void N(i0 i0Var) {
            u().accept(i0Var);
        }

        private void l(androidx.core.util.a<Uri> aVar, @NonNull Uri uri) {
            if (aVar != null) {
                this.f3057a.a();
                aVar.accept(uri);
                return;
            }
            throw new AssertionError("Recording " + this + " has already been finalized");
        }

        @NonNull
        static h m(@NonNull p pVar, long j10) {
            return new i(pVar.d(), pVar.c(), pVar.b(), pVar.f(), j10);
        }

        /* access modifiers changed from: package-private */
        public void C(@NonNull Context context) throws IOException {
            ParcelFileDescriptor parcelFileDescriptor;
            if (!this.f3058b.getAndSet(true)) {
                b0.e v10 = v();
                boolean z10 = v10 instanceof b0.b;
                Object obj = null;
                if (z10) {
                    parcelFileDescriptor = ((b0.b) v10).c().dup();
                } else {
                    parcelFileDescriptor = null;
                }
                this.f3057a.c("finalizeRecording");
                this.f3059c.set(new w(v10, parcelFileDescriptor));
                if (y()) {
                    if (Build.VERSION.SDK_INT >= 31) {
                        this.f3060d.set(new a(context));
                    } else {
                        this.f3060d.set(new b());
                    }
                }
                if (v10 instanceof b0.d) {
                    b0.d dVar = (b0.d) v10;
                    if (Build.VERSION.SDK_INT >= 29) {
                        obj = new x(dVar);
                    } else {
                        obj = new y(dVar, context);
                    }
                } else if (z10) {
                    obj = new z(parcelFileDescriptor);
                }
                if (obj != null) {
                    this.f3061e.set(obj);
                    return;
                }
                return;
            }
            throw new AssertionError("Recording " + this + " has already been initialized");
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public AudioSource O(@NonNull AudioSource.f fVar, @NonNull Executor executor) throws AudioSourceAccessException {
            if (y()) {
                c andSet = this.f3060d.getAndSet((Object) null);
                if (andSet != null) {
                    return andSet.a(fVar, executor);
                }
                throw new AssertionError("One-time audio source creation has already occurred for recording " + this);
            }
            throw new AssertionError("Recording does not have audio enabled. Unable to create audio source for recording " + this);
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public MediaMuxer P(int i10, @NonNull androidx.core.util.a<Uri> aVar) throws IOException {
            if (this.f3058b.get()) {
                d andSet = this.f3059c.getAndSet((Object) null);
                if (andSet != null) {
                    return andSet.a(i10, aVar);
                }
                throw new AssertionError("One-time media muxer creation has already occurred for recording " + this);
            }
            throw new AssertionError("Recording " + this + " has not been initialized");
        }

        /* access modifiers changed from: package-private */
        public void S(@NonNull i0 i0Var) {
            if (Objects.equals(i0Var.c(), v())) {
                String str = "Sending VideoRecordEvent " + i0Var.getClass().getSimpleName();
                if (i0Var instanceof i0.a) {
                    i0.a aVar = (i0.a) i0Var;
                    if (aVar.j()) {
                        str = str + String.format(" [error: %s]", new Object[]{i0.a.g(aVar.i())});
                    }
                }
                v1.a("Recorder", str);
                if (n() != null && u() != null) {
                    try {
                        n().execute(new a0(this, i0Var));
                    } catch (RejectedExecutionException e10) {
                        v1.d("Recorder", "The callback executor is invalid.", e10);
                    }
                }
            } else {
                throw new AssertionError("Attempted to update event listener with event from incorrect recording [Recording: " + i0Var.c() + ", Expected: " + v() + "]");
            }
        }

        public void close() {
            k(Uri.EMPTY);
        }

        /* access modifiers changed from: protected */
        public void finalize() throws Throwable {
            try {
                this.f3057a.d();
                androidx.core.util.a andSet = this.f3061e.getAndSet((Object) null);
                if (andSet != null) {
                    l(andSet, Uri.EMPTY);
                }
            } finally {
                super.finalize();
            }
        }

        /* access modifiers changed from: package-private */
        public void k(@NonNull Uri uri) {
            if (this.f3058b.get()) {
                l(this.f3061e.getAndSet((Object) null), uri);
            }
        }

        /* access modifiers changed from: package-private */
        public abstract Executor n();

        /* access modifiers changed from: package-private */
        public abstract androidx.core.util.a<i0> u();

        /* access modifiers changed from: package-private */
        @NonNull
        public abstract b0.e v();

        /* access modifiers changed from: package-private */
        public abstract long x();

        /* access modifiers changed from: package-private */
        public abstract boolean y();
    }

    static {
        q qVar = q.f3405c;
        r f10 = r.f(Arrays.asList(new q[]{qVar, q.f3404b, q.f3403a}), m.a(qVar));
        X = f10;
        j0 a10 = j0.a().e(f10).b(1).a();
        Y = a10;
        Z = n.a().e(-1).f(a10).a();
    }

    Recorder(Executor executor, @NonNull n nVar, @NonNull m mVar, @NonNull m mVar2) {
        this.f2998b = executor;
        executor = executor == null ? androidx.camera.core.impl.utils.executor.a.c() : executor;
        this.f2999c = executor;
        this.f3000d = androidx.camera.core.impl.utils.executor.a.f(executor);
        this.A = j1.i(v(nVar));
        this.f2997a = j1.i(StreamInfo.c(this.f3006j, E(this.f3004h)));
        this.f3001e = mVar;
        this.f3002f = mVar2;
    }

    private void B(@NonNull h hVar) {
        this.f3015s.add(CallbackToFutureAdapter.a(new u(this, hVar)));
        if (F()) {
            this.f3015s.add(CallbackToFutureAdapter.a(new v(this, hVar)));
        }
        u.f.b(u.f.c(this.f3015s), new e(), androidx.camera.core.impl.utils.executor.a.a());
    }

    private void C(@NonNull SurfaceRequest surfaceRequest, @NonNull Timebase timebase) {
        Surface surface = this.f3020x;
        if (surface != null) {
            this.f3021y = surface;
            surfaceRequest.w(surface, this.f3000d, new q(this));
            b0();
            return;
        }
        surfaceRequest.x(this.f3000d, new r(this));
        this.f3014r = f0.d(surfaceRequest.j().b()).b(surfaceRequest.m());
        t0(surfaceRequest, timebase);
    }

    private void C0(@NonNull State state) {
        if (!V.contains(this.f3004h)) {
            throw new AssertionError("Can only updated non-pending state from a pending state, but state is " + this.f3004h);
        } else if (!W.contains(state)) {
            throw new AssertionError("Invalid state transition. State is not a valid non-pending state while in a pending state: " + state);
        } else if (this.f3005i != state) {
            this.f3005i = state;
            this.f2997a.h(StreamInfo.c(this.f3006j, E(state)));
        }
    }

    private int D(@NonNull AudioState audioState) {
        int i10 = f.f3052b[audioState.ordinal()];
        if (i10 == 1) {
            return 3;
        }
        if (i10 != 2) {
            if (i10 == 3 || i10 == 5) {
                return 1;
            }
            throw new AssertionError("Invalid internal audio state: " + audioState);
        } else if (this.S) {
            return 2;
        } else {
            return 0;
        }
    }

    @NonNull
    private StreamInfo.StreamState E(@NonNull State state) {
        f0.d dVar = (f0.d) f0.e.a(f0.d.class);
        if (state == State.RECORDING || (state == State.STOPPING && dVar == null)) {
            return StreamInfo.StreamState.ACTIVE;
        }
        return StreamInfo.StreamState.INACTIVE;
    }

    private static boolean H(@NonNull d0 d0Var, h hVar) {
        return hVar != null && d0Var.e() == hVar.x();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object J(h hVar, CallbackToFutureAdapter.a aVar) throws Exception {
        this.C.b(new b(aVar, hVar), this.f3000d);
        return "videoEncodingFuture";
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void K(CallbackToFutureAdapter.a aVar, Throwable th2) {
        if (this.R == null) {
            m0(AudioState.ERROR);
            this.R = th2;
            B0();
            aVar.c(null);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object L(h hVar, CallbackToFutureAdapter.a aVar) throws Exception {
        b0.j jVar = new b0.j(this, aVar);
        this.B.A(this.f3000d, new c(jVar));
        this.E.b(new d(aVar, jVar, hVar), this.f3000d);
        return "audioEncodingFuture";
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void M(SurfaceRequest.f fVar) {
        this.f3013q = fVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O(SurfaceRequest surfaceRequest, Timebase timebase) {
        this.f3018v = surfaceRequest;
        this.f3019w = timebase;
        C(surfaceRequest, timebase);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void P(SurfaceRequest surfaceRequest, Timebase timebase) {
        SurfaceRequest surfaceRequest2 = this.f3018v;
        if (surfaceRequest2 != null) {
            surfaceRequest2.z();
        }
        this.f3018v = surfaceRequest;
        this.f3019w = timebase;
        C(surfaceRequest, timebase);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Q(Uri uri) {
        this.H = uri;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void R(SurfaceRequest surfaceRequest, Surface surface) {
        synchronized (this.f3003g) {
            v1.a("Recorder", "Encoder surface updated: " + surface.hashCode() + ", Current surface: " + this.f3006j);
            switch (f.f3051a[this.f3004h.ordinal()]) {
                case 1:
                case 3:
                case 4:
                case 5:
                case 6:
                    Z(surface, surfaceRequest);
                    break;
                case 7:
                case 8:
                    throw new AssertionError("Unexpected state on update of encoder surface " + this.f3004h);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void S() {
        SurfaceRequest surfaceRequest = this.f3018v;
        if (surfaceRequest != null) {
            C(surfaceRequest, this.f3019w);
            return;
        }
        throw new AssertionError("surface request is required to retry initialization.");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void T(h hVar, long j10) {
        y0(hVar, Long.valueOf(j10), 0, (Throwable) null);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void U(j jVar) {
        v1.a("Recorder", "The source didn't become non-streaming before timeout. Waited 1000ms");
        if (f0.e.a(f0.d.class) != null) {
            X(jVar);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void V(j jVar) {
        this.f3000d.execute(new l(jVar));
    }

    @NonNull
    private h W(@NonNull State state) {
        boolean z10;
        if (state == State.PENDING_PAUSED) {
            z10 = true;
        } else if (state == State.PENDING_RECORDING) {
            z10 = false;
        } else {
            throw new AssertionError("makePendingRecordingActiveLocked() can only be called from a pending state.");
        }
        if (this.f3007k == null) {
            h hVar = this.f3008l;
            if (hVar != null) {
                this.f3007k = hVar;
                this.f3008l = null;
                if (z10) {
                    o0(State.PAUSED);
                } else {
                    o0(State.RECORDING);
                }
                return hVar;
            }
            throw new AssertionError("Pending recording should exist when in a PENDING state.");
        }
        throw new AssertionError("Cannot make pending recording active because another recording is already active.");
    }

    private static void X(@NonNull j jVar) {
        if (jVar instanceof EncoderImpl) {
            ((EncoderImpl) jVar).c0();
        }
    }

    private void Y(Throwable th2) {
        h hVar;
        synchronized (this.f3003g) {
            hVar = null;
            switch (f.f3051a[this.f3004h.ordinal()]) {
                case 1:
                case 2:
                case 6:
                case 7:
                case 8:
                    throw new AssertionError("Encountered encoder setup error while in unexpected state " + this.f3004h + ": " + th2);
                case 3:
                case 4:
                    h hVar2 = this.f3008l;
                    this.f3008l = null;
                    hVar = hVar2;
                    break;
                case 5:
                    break;
            }
            p0(-1);
            o0(State.ERROR);
        }
        if (hVar != null) {
            x(hVar, 7, th2);
        }
    }

    private void Z(@NonNull Surface surface, @NonNull SurfaceRequest surfaceRequest) {
        Surface surface2 = this.f3020x;
        if (surface2 != surface) {
            n0(surface);
            if (surface2 == null) {
                this.f3021y = surface;
                surfaceRequest.w(surface, this.f3000d, new q(this));
                b0();
                return;
            }
            return;
        }
        v1.a("Recorder", "Video encoder provides the same surface.");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: androidx.camera.video.Recorder$h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: androidx.camera.video.Recorder$h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: androidx.camera.video.Recorder$h} */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0028, code lost:
        if (r7.f3007k == null) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002a, code lost:
        r4 = 0;
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
        r2 = r1;
        r1 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0033, code lost:
        if (r7.T != androidx.camera.video.VideoOutput.SourceState.INACTIVE) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0035, code lost:
        r2 = r7.f3008l;
        r7.f3008l = null;
        l0();
        r4 = 4;
        r5 = f2994a0;
        r6 = r2;
        r2 = r1;
        r1 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0043, code lost:
        r5 = null;
        r3 = W(r7.f3004h);
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0075, code lost:
        r4 = 0;
        r1 = null;
        r5 = null;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b0() {
        /*
            r7 = this;
            java.lang.Object r0 = r7.f3003g
            monitor-enter(r0)
            int[] r1 = androidx.camera.video.Recorder.f.f3051a     // Catch:{ all -> 0x0085 }
            androidx.camera.video.Recorder$State r2 = r7.f3004h     // Catch:{ all -> 0x0085 }
            int r2 = r2.ordinal()     // Catch:{ all -> 0x0085 }
            r1 = r1[r2]     // Catch:{ all -> 0x0085 }
            r2 = 0
            r3 = 0
            switch(r1) {
                case 1: goto L_0x0066;
                case 2: goto L_0x004d;
                case 3: goto L_0x0025;
                case 4: goto L_0x0023;
                case 5: goto L_0x001d;
                case 6: goto L_0x004d;
                case 7: goto L_0x004d;
                case 8: goto L_0x004d;
                case 9: goto L_0x0014;
                default: goto L_0x0012;
            }     // Catch:{ all -> 0x0085 }
        L_0x0012:
            goto L_0x0075
        L_0x0014:
            java.lang.String r1 = "Recorder"
            java.lang.String r4 = "onInitialized() was invoked when the Recorder had encountered error"
            androidx.camera.core.v1.c(r1, r4)     // Catch:{ all -> 0x0085 }
            goto L_0x0075
        L_0x001d:
            androidx.camera.video.Recorder$State r1 = androidx.camera.video.Recorder.State.IDLING     // Catch:{ all -> 0x0085 }
            r7.o0(r1)     // Catch:{ all -> 0x0085 }
            goto L_0x0075
        L_0x0023:
            r1 = 1
            goto L_0x0026
        L_0x0025:
            r1 = r2
        L_0x0026:
            androidx.camera.video.Recorder$h r4 = r7.f3007k     // Catch:{ all -> 0x0085 }
            if (r4 == 0) goto L_0x002f
            r4 = r2
            r5 = r3
        L_0x002c:
            r2 = r1
            r1 = r5
            goto L_0x0078
        L_0x002f:
            androidx.camera.video.VideoOutput$SourceState r4 = r7.T     // Catch:{ all -> 0x0085 }
            androidx.camera.video.VideoOutput$SourceState r5 = androidx.camera.video.VideoOutput.SourceState.INACTIVE     // Catch:{ all -> 0x0085 }
            if (r4 != r5) goto L_0x0043
            androidx.camera.video.Recorder$h r2 = r7.f3008l     // Catch:{ all -> 0x0085 }
            r7.f3008l = r3     // Catch:{ all -> 0x0085 }
            r7.l0()     // Catch:{ all -> 0x0085 }
            r4 = 4
            java.lang.Exception r5 = f2994a0     // Catch:{ all -> 0x0085 }
            r6 = r2
            r2 = r1
            r1 = r6
            goto L_0x0078
        L_0x0043:
            androidx.camera.video.Recorder$State r4 = r7.f3004h     // Catch:{ all -> 0x0085 }
            androidx.camera.video.Recorder$h r4 = r7.W(r4)     // Catch:{ all -> 0x0085 }
            r5 = r3
            r3 = r4
            r4 = r2
            goto L_0x002c
        L_0x004d:
            java.lang.AssertionError r1 = new java.lang.AssertionError     // Catch:{ all -> 0x0085 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0085 }
            r2.<init>()     // Catch:{ all -> 0x0085 }
            java.lang.String r3 = "Incorrectly invoke onInitialized() in state "
            r2.append(r3)     // Catch:{ all -> 0x0085 }
            androidx.camera.video.Recorder$State r3 = r7.f3004h     // Catch:{ all -> 0x0085 }
            r2.append(r3)     // Catch:{ all -> 0x0085 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0085 }
            r1.<init>(r2)     // Catch:{ all -> 0x0085 }
            throw r1     // Catch:{ all -> 0x0085 }
        L_0x0066:
            boolean r1 = r7.f3011o     // Catch:{ all -> 0x0085 }
            if (r1 == 0) goto L_0x006d
            r7.f3011o = r2     // Catch:{ all -> 0x0085 }
            goto L_0x0075
        L_0x006d:
            java.lang.AssertionError r1 = new java.lang.AssertionError     // Catch:{ all -> 0x0085 }
            java.lang.String r2 = "Unexpectedly invoke onInitialized() in a STOPPING state when it's not waiting for a new surface."
            r1.<init>(r2)     // Catch:{ all -> 0x0085 }
            throw r1     // Catch:{ all -> 0x0085 }
        L_0x0075:
            r4 = r2
            r1 = r3
            r5 = r1
        L_0x0078:
            monitor-exit(r0)     // Catch:{ all -> 0x0085 }
            if (r3 == 0) goto L_0x007f
            r7.w0(r3, r2)
            goto L_0x0084
        L_0x007f:
            if (r1 == 0) goto L_0x0084
            r7.x(r1, r4, r5)
        L_0x0084:
            return
        L_0x0085:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0085 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.Recorder.b0():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0039, code lost:
        if (r7.T != androidx.camera.video.VideoOutput.SourceState.INACTIVE) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003b, code lost:
        r1 = r7.f3008l;
        r7.f3008l = null;
        o0(androidx.camera.video.Recorder.State.f3029a);
        r5 = f2994a0;
        r4 = r2;
        r2 = false;
        r3 = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004e, code lost:
        if (r7.f3011o == false) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0050, code lost:
        C0(androidx.camera.video.Recorder.State.f3029a);
        r1 = null;
        r5 = null;
        r4 = r2;
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005a, code lost:
        r5 = null;
        r4 = r2;
        r2 = false;
        r8 = W(r7.f3004h);
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007e, code lost:
        r1 = null;
        r5 = null;
        r2 = false;
        r4 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c0(@androidx.annotation.NonNull androidx.camera.video.Recorder.h r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.f3003g
            monitor-enter(r0)
            androidx.camera.video.Recorder$h r1 = r7.f3007k     // Catch:{ all -> 0x00a9 }
            if (r1 != r8) goto L_0x00a1
            r8 = 0
            r7.f3007k = r8     // Catch:{ all -> 0x00a9 }
            int[] r1 = androidx.camera.video.Recorder.f.f3051a     // Catch:{ all -> 0x00a9 }
            androidx.camera.video.Recorder$State r2 = r7.f3004h     // Catch:{ all -> 0x00a9 }
            int r2 = r2.ordinal()     // Catch:{ all -> 0x00a9 }
            r1 = r1[r2]     // Catch:{ all -> 0x00a9 }
            r2 = 1
            r3 = 0
            switch(r1) {
                case 1: goto L_0x006f;
                case 2: goto L_0x0066;
                case 3: goto L_0x0034;
                case 4: goto L_0x0035;
                case 5: goto L_0x001b;
                case 6: goto L_0x001b;
                case 7: goto L_0x006f;
                case 8: goto L_0x006f;
                default: goto L_0x0019;
            }     // Catch:{ all -> 0x00a9 }
        L_0x0019:
            goto L_0x007e
        L_0x001b:
            java.lang.AssertionError r8 = new java.lang.AssertionError     // Catch:{ all -> 0x00a9 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a9 }
            r1.<init>()     // Catch:{ all -> 0x00a9 }
            java.lang.String r2 = "Unexpected state on finalize of recording: "
            r1.append(r2)     // Catch:{ all -> 0x00a9 }
            androidx.camera.video.Recorder$State r2 = r7.f3004h     // Catch:{ all -> 0x00a9 }
            r1.append(r2)     // Catch:{ all -> 0x00a9 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00a9 }
            r8.<init>(r1)     // Catch:{ all -> 0x00a9 }
            throw r8     // Catch:{ all -> 0x00a9 }
        L_0x0034:
            r2 = r3
        L_0x0035:
            androidx.camera.video.VideoOutput$SourceState r1 = r7.T     // Catch:{ all -> 0x00a9 }
            androidx.camera.video.VideoOutput$SourceState r4 = androidx.camera.video.VideoOutput.SourceState.INACTIVE     // Catch:{ all -> 0x00a9 }
            if (r1 != r4) goto L_0x004c
            androidx.camera.video.Recorder$h r1 = r7.f3008l     // Catch:{ all -> 0x00a9 }
            r7.f3008l = r8     // Catch:{ all -> 0x00a9 }
            androidx.camera.video.Recorder$State r4 = androidx.camera.video.Recorder.State.INITIALIZING     // Catch:{ all -> 0x00a9 }
            r7.o0(r4)     // Catch:{ all -> 0x00a9 }
            r4 = 4
            java.lang.Exception r5 = f2994a0     // Catch:{ all -> 0x00a9 }
            r6 = r4
            r4 = r2
            r2 = r3
            r3 = r6
            goto L_0x0082
        L_0x004c:
            boolean r1 = r7.f3011o     // Catch:{ all -> 0x00a9 }
            if (r1 == 0) goto L_0x005a
            androidx.camera.video.Recorder$State r1 = androidx.camera.video.Recorder.State.INITIALIZING     // Catch:{ all -> 0x00a9 }
            r7.C0(r1)     // Catch:{ all -> 0x00a9 }
            r1 = r8
            r5 = r1
            r4 = r2
            r2 = r3
            goto L_0x0082
        L_0x005a:
            androidx.camera.video.Recorder$State r1 = r7.f3004h     // Catch:{ all -> 0x00a9 }
            androidx.camera.video.Recorder$h r1 = r7.W(r1)     // Catch:{ all -> 0x00a9 }
            r5 = r8
            r4 = r2
            r2 = r3
            r8 = r1
            r1 = r5
            goto L_0x0082
        L_0x0066:
            androidx.camera.video.Recorder$State r1 = androidx.camera.video.Recorder.State.INITIALIZING     // Catch:{ all -> 0x00a9 }
            r7.o0(r1)     // Catch:{ all -> 0x00a9 }
            r1 = r8
            r5 = r1
            r4 = r3
            goto L_0x0082
        L_0x006f:
            boolean r1 = r7.f3011o     // Catch:{ all -> 0x00a9 }
            if (r1 == 0) goto L_0x0079
            androidx.camera.video.Recorder$State r1 = androidx.camera.video.Recorder.State.INITIALIZING     // Catch:{ all -> 0x00a9 }
            r7.o0(r1)     // Catch:{ all -> 0x00a9 }
            goto L_0x007e
        L_0x0079:
            androidx.camera.video.Recorder$State r1 = androidx.camera.video.Recorder.State.IDLING     // Catch:{ all -> 0x00a9 }
            r7.o0(r1)     // Catch:{ all -> 0x00a9 }
        L_0x007e:
            r1 = r8
            r5 = r1
            r2 = r3
            r4 = r2
        L_0x0082:
            monitor-exit(r0)     // Catch:{ all -> 0x00a9 }
            if (r2 == 0) goto L_0x0089
            r7.k0()
            goto L_0x00a0
        L_0x0089:
            if (r8 == 0) goto L_0x009b
            boolean r0 = r7.f3011o
            if (r0 != 0) goto L_0x0093
            r7.w0(r8, r4)
            goto L_0x00a0
        L_0x0093:
            java.lang.AssertionError r8 = new java.lang.AssertionError
            java.lang.String r0 = "Attempt to start a pending recording while the Recorder is waiting for a new surface request."
            r8.<init>(r0)
            throw r8
        L_0x009b:
            if (r1 == 0) goto L_0x00a0
            r7.x(r1, r3, r5)
        L_0x00a0:
            return
        L_0x00a1:
            java.lang.AssertionError r8 = new java.lang.AssertionError     // Catch:{ all -> 0x00a9 }
            java.lang.String r1 = "Active recording did not match finalized recording on finalize."
            r8.<init>(r1)     // Catch:{ all -> 0x00a9 }
            throw r8     // Catch:{ all -> 0x00a9 }
        L_0x00a9:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00a9 }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.Recorder.c0(androidx.camera.video.Recorder$h):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e0(@androidx.annotation.NonNull androidx.camera.core.SurfaceRequest.e r5) {
        /*
            r4 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Surface closed: "
            r0.append(r1)
            android.view.Surface r1 = r5.b()
            int r1 = r1.hashCode()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "Recorder"
            androidx.camera.core.v1.a(r1, r0)
            android.view.Surface r5 = r5.b()
            android.view.Surface r0 = r4.f3021y
            if (r5 != r0) goto L_0x005f
            java.util.concurrent.ScheduledFuture<?> r5 = r4.U
            r0 = 0
            if (r5 == 0) goto L_0x0038
            boolean r5 = r5.cancel(r0)
            if (r5 == 0) goto L_0x0038
            androidx.camera.video.internal.encoder.j r5 = r4.C
            if (r5 == 0) goto L_0x0038
            X(r5)
        L_0x0038:
            androidx.camera.video.VideoOutput$SourceState r5 = r4.T
            androidx.camera.video.VideoOutput$SourceState r2 = androidx.camera.video.VideoOutput.SourceState.INACTIVE
            r3 = 1
            if (r5 != r2) goto L_0x0046
            java.lang.String r5 = "Latest active surface no longer in use and source state is INACTIVE. Resetting recorder..."
            androidx.camera.core.v1.a(r1, r5)
        L_0x0044:
            r0 = r3
            goto L_0x0052
        L_0x0046:
            android.view.Surface r5 = r4.f3021y
            android.view.Surface r2 = r4.f3020x
            if (r5 != r2) goto L_0x0052
            java.lang.String r5 = "Source has stopped producing frames into active surface, yet source state is still active. Stopping any in-progress recordings and resetting encoders in case a new surface is required."
            androidx.camera.core.v1.l(r1, r5)
            goto L_0x0044
        L_0x0052:
            r5 = 0
            r4.f3021y = r5
            if (r0 == 0) goto L_0x0062
            r0 = 4
            r4.j0(r0, r5)
            r4.n0(r5)
            goto L_0x0062
        L_0x005f:
            r5.release()
        L_0x0062:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.Recorder.e0(androidx.camera.core.SurfaceRequest$e):void");
    }

    private void f0(@NonNull h hVar) {
        if (this.f3010n == hVar && !this.f3012p) {
            if (F()) {
                this.E.pause();
            }
            this.C.pause();
            h hVar2 = this.f3010n;
            hVar2.S(i0.d(hVar2.v(), z()));
        }
    }

    @NonNull
    private p h0(@NonNull Context context, @NonNull b0.e eVar) {
        androidx.core.util.h.h(eVar, "The OutputOptions cannot be null.");
        return new p(context, this, eVar);
    }

    private void i0() {
        AudioSource audioSource = this.B;
        if (audioSource != null) {
            this.B = null;
            v1.a("Recorder", String.format("Releasing audio source: 0x%x", new Object[]{Integer.valueOf(audioSource.hashCode())}));
            u.f.b(audioSource.x(), new a(audioSource), androidx.camera.core.impl.utils.executor.a.a());
            return;
        }
        throw new AssertionError("Cannot release null audio source.");
    }

    private void k0() {
        if (this.E != null) {
            v1.a("Recorder", "Releasing audio encoder.");
            this.E.release();
            this.E = null;
            this.F = null;
        }
        if (this.C != null) {
            v1.a("Recorder", "Releasing video encoder.");
            this.C.release();
            this.C = null;
            this.D = null;
        }
        if (this.B != null) {
            i0();
        }
        m0(AudioState.INITIALIZING);
    }

    private void l0() {
        if (V.contains(this.f3004h)) {
            o0(this.f3005i);
            return;
        }
        throw new AssertionError("Cannot restore non-pending state when in state " + this.f3004h);
    }

    private void n0(Surface surface) {
        int i10;
        if (this.f3020x != surface) {
            this.f3020x = surface;
            synchronized (this.f3003g) {
                if (surface != null) {
                    try {
                        i10 = surface.hashCode();
                    } catch (Throwable th2) {
                        throw th2;
                    }
                } else {
                    i10 = 0;
                }
                p0(i10);
            }
        }
    }

    private void p0(int i10) {
        if (this.f3006j != i10) {
            v1.a("Recorder", "Transitioning streamId: " + this.f3006j + " --> " + i10);
            this.f3006j = i10;
            this.f2997a.h(StreamInfo.c(i10, E(this.f3004h)));
        }
    }

    private void r0(@NonNull h hVar) throws ResourceCreationException {
        n nVar = (n) A(this.A);
        g0.h d10 = g0.b.d(nVar, this.f3014r);
        Timebase timebase = Timebase.UPTIME;
        AudioSource.f g10 = g0.b.g(d10, nVar.b());
        try {
            if (this.B != null) {
                i0();
            }
            AudioSource s02 = s0(hVar, g10);
            this.B = s02;
            v1.a("Recorder", String.format("Set up new audio source: 0x%x", new Object[]{Integer.valueOf(s02.hashCode())}));
            try {
                j a10 = this.f3002f.a(this.f2999c, g0.b.c(d10, timebase, g10, nVar.b()));
                this.E = a10;
                j.b a11 = a10.a();
                if (a11 instanceof j.a) {
                    this.B.B((j.a) a11);
                    return;
                }
                throw new AssertionError("The EncoderInput of audio isn't a ByteBufferInput.");
            } catch (InvalidConfigException e10) {
                throw new ResourceCreationException(e10);
            }
        } catch (AudioSourceAccessException e11) {
            throw new ResourceCreationException(e11);
        }
    }

    @NonNull
    private AudioSource s0(@NonNull h hVar, @NonNull AudioSource.f fVar) throws AudioSourceAccessException {
        return hVar.O(fVar, f2996c0);
    }

    private void t0(@NonNull SurfaceRequest surfaceRequest, @NonNull Timebase timebase) {
        n nVar = (n) A(this.A);
        try {
            j a10 = this.f3001e.a(this.f2999c, i.b(i.c(nVar, this.f3014r), timebase, nVar.d(), surfaceRequest.m(), surfaceRequest.l()));
            this.C = a10;
            j.b a11 = a10.a();
            if (a11 instanceof j.c) {
                ((j.c) a11).a(this.f3000d, new b0.i(this, surfaceRequest));
                return;
            }
            throw new AssertionError("The EncoderInput of video isn't a SurfaceInput.");
        } catch (InvalidConfigException e10) {
            v1.d("Recorder", "Unable to initialize video encoder.", e10);
            Y(new ResourceCreationException(e10));
        }
    }

    private void u() {
        while (!this.Q.isEmpty()) {
            this.Q.a();
        }
    }

    @NonNull
    private n v(@NonNull n nVar) {
        n.a i10 = nVar.i();
        if (nVar.d().b() == -1) {
            i10.b(new o());
        }
        return i10.a();
    }

    @SuppressLint({"MissingPermission"})
    private void v0(@NonNull h hVar) {
        AudioState audioState;
        if (this.f3010n == null) {
            if (hVar.v().a() > 0) {
                this.M = Math.round(((double) hVar.v().a()) * 0.95d);
                v1.a("Recorder", "File size limit in bytes: " + this.M);
            } else {
                this.M = 0;
            }
            this.f3010n = hVar;
            int i10 = f.f3052b[this.G.ordinal()];
            if (i10 == 1 || i10 == 2 || i10 == 3) {
                throw new AssertionError("Incorrectly invoke startInternal in audio state " + this.G);
            }
            if (i10 == 4) {
                if (hVar.y()) {
                    audioState = AudioState.ACTIVE;
                } else {
                    audioState = AudioState.DISABLED;
                }
                m0(audioState);
            } else if (i10 == 5 && hVar.y()) {
                if (G()) {
                    try {
                        r0(hVar);
                        m0(AudioState.ACTIVE);
                    } catch (ResourceCreationException e10) {
                        v1.d("Recorder", "Unable to create audio resource with error: ", e10);
                        m0(AudioState.ERROR);
                        this.R = e10;
                    }
                } else {
                    throw new AssertionError("The Recorder doesn't support recording with audio");
                }
            }
            B(hVar);
            if (F()) {
                this.B.D();
                this.E.start();
            }
            this.C.start();
            h hVar2 = this.f3010n;
            hVar2.S(i0.e(hVar2.v(), z()));
            return;
        }
        throw new AssertionError("Attempted to start a new recording while another was in progress.");
    }

    private void w0(@NonNull h hVar, boolean z10) {
        v0(hVar);
        if (z10) {
            f0(hVar);
        }
    }

    private void x(@NonNull h hVar, int i10, Throwable th2) {
        hVar.k(Uri.EMPTY);
        hVar.S(i0.b(hVar.v(), e0.d(0, 0, b.c(1, this.R)), o.b(Uri.EMPTY), i10, th2));
    }

    @NonNull
    private List<androidx.camera.video.internal.encoder.g> y(long j10) {
        ArrayList arrayList = new ArrayList();
        while (!this.Q.isEmpty()) {
            androidx.camera.video.internal.encoder.g a10 = this.Q.a();
            if (a10.z0() >= j10) {
                arrayList.add(a10);
            }
        }
        return arrayList;
    }

    private static int z0(androidx.camera.core.impl.m mVar, int i10) {
        if (mVar != null) {
            int h10 = mVar.h();
            if (h10 != 1) {
                if (h10 == 2) {
                    return 0;
                }
                if (h10 != 9) {
                    return i10;
                }
                return 1;
            } else if (Build.VERSION.SDK_INT < 26) {
                return 0;
            } else {
                return 2;
            }
        }
        return i10;
    }

    /* access modifiers changed from: package-private */
    public <T> T A(@NonNull x1<T> x1Var) {
        try {
            return x1Var.b().get();
        } catch (InterruptedException | ExecutionException e10) {
            throw new IllegalStateException(e10);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.Exception} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.lang.Exception} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.lang.Exception} */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0020  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void A0() {
        /*
            r8 = this;
            java.lang.Object r0 = r8.f3003g
            monitor-enter(r0)
            int[] r1 = androidx.camera.video.Recorder.f.f3051a     // Catch:{ all -> 0x0050 }
            androidx.camera.video.Recorder$State r2 = r8.f3004h     // Catch:{ all -> 0x0050 }
            int r2 = r2.ordinal()     // Catch:{ all -> 0x0050 }
            r1 = r1[r2]     // Catch:{ all -> 0x0050 }
            r2 = 3
            r3 = 4
            r4 = 0
            r5 = 0
            if (r1 == r2) goto L_0x001b
            if (r1 == r3) goto L_0x0019
            r3 = r4
            r1 = r5
        L_0x0017:
            r2 = r1
            goto L_0x0043
        L_0x0019:
            r1 = 1
            goto L_0x001c
        L_0x001b:
            r1 = r4
        L_0x001c:
            androidx.camera.video.Recorder$h r2 = r8.f3007k     // Catch:{ all -> 0x0050 }
            if (r2 == 0) goto L_0x0025
            r3 = r4
            r2 = r5
            r4 = r1
            r1 = r2
            goto L_0x0043
        L_0x0025:
            androidx.camera.video.VideoOutput$SourceState r2 = r8.T     // Catch:{ all -> 0x0050 }
            androidx.camera.video.VideoOutput$SourceState r6 = androidx.camera.video.VideoOutput.SourceState.INACTIVE     // Catch:{ all -> 0x0050 }
            if (r2 != r6) goto L_0x0038
            androidx.camera.video.Recorder$h r2 = r8.f3008l     // Catch:{ all -> 0x0050 }
            r8.f3008l = r5     // Catch:{ all -> 0x0050 }
            r8.l0()     // Catch:{ all -> 0x0050 }
            java.lang.Exception r4 = f2994a0     // Catch:{ all -> 0x0050 }
            r7 = r4
            r4 = r1
            r1 = r7
            goto L_0x0043
        L_0x0038:
            androidx.camera.video.Recorder$State r2 = r8.f3004h     // Catch:{ all -> 0x0050 }
            androidx.camera.video.Recorder$h r2 = r8.W(r2)     // Catch:{ all -> 0x0050 }
            r3 = r4
            r4 = r1
            r1 = r5
            r5 = r2
            goto L_0x0017
        L_0x0043:
            monitor-exit(r0)     // Catch:{ all -> 0x0050 }
            if (r5 == 0) goto L_0x004a
            r8.w0(r5, r4)
            goto L_0x004f
        L_0x004a:
            if (r2 == 0) goto L_0x004f
            r8.x(r2, r3, r1)
        L_0x004f:
            return
        L_0x0050:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0050 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.Recorder.A0():void");
    }

    /* access modifiers changed from: package-private */
    public void B0() {
        h hVar = this.f3010n;
        if (hVar != null) {
            hVar.S(i0.f(hVar.v(), z()));
        }
    }

    /* access modifiers changed from: package-private */
    public void D0(@NonNull androidx.camera.video.internal.encoder.g gVar, @NonNull h hVar) {
        long size = this.I + gVar.size();
        long j10 = this.M;
        if (j10 == 0 || size <= j10) {
            this.f3022z.writeSampleData(this.f3016t.intValue(), gVar.q(), gVar.W());
            this.I = size;
            if (this.L == 0) {
                long z02 = gVar.z0();
                this.L = z02;
                v1.a("Recorder", String.format("First audio time: %d (%s)", new Object[]{Long.valueOf(z02), d0.h.j(this.L)}));
                return;
            }
            return;
        }
        v1.a("Recorder", String.format("Reach file size limit %d > %d", new Object[]{Long.valueOf(size), Long.valueOf(this.M)}));
        a0(hVar, 2, (Throwable) null);
    }

    /* access modifiers changed from: package-private */
    public void E0(@NonNull androidx.camera.video.internal.encoder.g gVar, @NonNull h hVar) {
        if (this.f3017u != null) {
            long size = this.I + gVar.size();
            long j10 = this.M;
            if (j10 == 0 || size <= j10) {
                this.f3022z.writeSampleData(this.f3017u.intValue(), gVar.q(), gVar.W());
                this.I = size;
                if (this.K == 0) {
                    long z02 = gVar.z0();
                    this.K = z02;
                    v1.a("Recorder", String.format("First video time: %d (%s)", new Object[]{Long.valueOf(z02), d0.h.j(this.K)}));
                }
                this.J = TimeUnit.MICROSECONDS.toNanos(gVar.z0() - this.K);
                B0();
                return;
            }
            v1.a("Recorder", String.format("Reach file size limit %d > %d", new Object[]{Long.valueOf(size), Long.valueOf(this.M)}));
            a0(hVar, 2, (Throwable) null);
            return;
        }
        throw new AssertionError("Video data comes before the track is added to MediaMuxer.");
    }

    /* access modifiers changed from: package-private */
    public boolean F() {
        return this.G == AudioState.ACTIVE;
    }

    /* access modifiers changed from: package-private */
    public boolean G() {
        return ((n) A(this.A)).b().c() != 0;
    }

    public void a(@NonNull SurfaceRequest surfaceRequest) {
        b(surfaceRequest, Timebase.UPTIME);
    }

    /* access modifiers changed from: package-private */
    public void a0(@NonNull h hVar, int i10, Throwable th2) {
        if (hVar == this.f3010n) {
            boolean z10 = false;
            synchronized (this.f3003g) {
                switch (f.f3051a[this.f3004h.ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        break;
                    case 5:
                    case 6:
                    case 9:
                        throw new AssertionError("In-progress recording error occurred while in unexpected state: " + this.f3004h);
                    case 7:
                    case 8:
                        o0(State.STOPPING);
                        z10 = true;
                        break;
                }
                if (hVar != this.f3007k) {
                    throw new AssertionError("Internal error occurred for recording but it is not the active recording.");
                }
            }
            if (z10) {
                y0(hVar, (Long) null, i10, th2);
                return;
            }
            return;
        }
        throw new AssertionError("Internal error occurred on recording that is not the current in-progress recording.");
    }

    public void b(@NonNull SurfaceRequest surfaceRequest, @NonNull Timebase timebase) {
        synchronized (this.f3003g) {
            v1.a("Recorder", "Surface is requested in state: " + this.f3004h + ", Current surface: " + this.f3006j);
            switch (f.f3051a[this.f3004h.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    this.f3000d.execute(new b0.g(this, surfaceRequest, timebase));
                    break;
                case 6:
                case 7:
                case 8:
                    throw new IllegalStateException("Surface was requested when the Recorder had been initialized with state " + this.f3004h);
                case 9:
                    v1.l("Recorder", "Surface was requested when the Recorder had encountered error.");
                    o0(State.INITIALIZING);
                    this.f3000d.execute(new b0.h(this, surfaceRequest, timebase));
                    break;
            }
        }
    }

    @NonNull
    public l1<n> c() {
        return this.A;
    }

    @NonNull
    public l1<StreamInfo> d() {
        return this.f2997a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d0 */
    public void N(@NonNull VideoOutput.SourceState sourceState) {
        ScheduledFuture<?> scheduledFuture;
        j jVar;
        VideoOutput.SourceState sourceState2 = this.T;
        this.T = sourceState;
        if (sourceState2 != sourceState) {
            v1.a("Recorder", "Video source has transitioned to state: " + sourceState);
            if (sourceState == VideoOutput.SourceState.INACTIVE) {
                if (this.f3021y == null) {
                    j0(4, (Throwable) null);
                    n0((Surface) null);
                    return;
                }
                h hVar = this.f3010n;
                if (hVar != null) {
                    a0(hVar, 4, (Throwable) null);
                }
            } else if (sourceState == VideoOutput.SourceState.ACTIVE_NON_STREAMING && (scheduledFuture = this.U) != null && scheduledFuture.cancel(false) && (jVar = this.C) != null) {
                X(jVar);
            }
        } else {
            v1.a("Recorder", "Video source transitions to the same state: " + sourceState);
        }
    }

    public void e(@NonNull VideoOutput.SourceState sourceState) {
        this.f3000d.execute(new p(this, sourceState));
    }

    @NonNull
    public p g0(@NonNull Context context, @NonNull b0.c cVar) {
        return h0(context, cVar);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002c, code lost:
        r3 = false;
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003b, code lost:
        r3 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void j0(int r7, java.lang.Throwable r8) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.f3003g
            monitor-enter(r0)
            int[] r1 = androidx.camera.video.Recorder.f.f3051a     // Catch:{ all -> 0x004c }
            androidx.camera.video.Recorder$State r2 = r6.f3004h     // Catch:{ all -> 0x004c }
            int r2 = r2.ordinal()     // Catch:{ all -> 0x004c }
            r1 = r1[r2]     // Catch:{ all -> 0x004c }
            r2 = 0
            r3 = 1
            switch(r1) {
                case 1: goto L_0x0036;
                case 2: goto L_0x0012;
                case 3: goto L_0x0030;
                case 4: goto L_0x0030;
                case 5: goto L_0x002c;
                case 6: goto L_0x0027;
                case 7: goto L_0x0013;
                case 8: goto L_0x0013;
                case 9: goto L_0x0027;
                default: goto L_0x0012;
            }     // Catch:{ all -> 0x004c }
        L_0x0012:
            goto L_0x003b
        L_0x0013:
            androidx.camera.video.Recorder$h r1 = r6.f3007k     // Catch:{ all -> 0x004c }
            androidx.camera.video.Recorder$h r4 = r6.f3010n     // Catch:{ all -> 0x004c }
            if (r1 != r4) goto L_0x001f
            androidx.camera.video.Recorder$State r1 = androidx.camera.video.Recorder.State.RESETTING     // Catch:{ all -> 0x004c }
            r6.o0(r1)     // Catch:{ all -> 0x004c }
            goto L_0x003c
        L_0x001f:
            java.lang.AssertionError r7 = new java.lang.AssertionError     // Catch:{ all -> 0x004c }
            java.lang.String r8 = "In-progress recording does not match the active recording. Unable to reset encoder."
            r7.<init>(r8)     // Catch:{ all -> 0x004c }
            throw r7     // Catch:{ all -> 0x004c }
        L_0x0027:
            androidx.camera.video.Recorder$State r1 = androidx.camera.video.Recorder.State.INITIALIZING     // Catch:{ all -> 0x004c }
            r6.o0(r1)     // Catch:{ all -> 0x004c }
        L_0x002c:
            r5 = r3
            r3 = r2
            r2 = r5
            goto L_0x003c
        L_0x0030:
            androidx.camera.video.Recorder$State r1 = androidx.camera.video.Recorder.State.RESETTING     // Catch:{ all -> 0x004c }
            r6.C0(r1)     // Catch:{ all -> 0x004c }
            goto L_0x002c
        L_0x0036:
            androidx.camera.video.Recorder$State r1 = androidx.camera.video.Recorder.State.RESETTING     // Catch:{ all -> 0x004c }
            r6.o0(r1)     // Catch:{ all -> 0x004c }
        L_0x003b:
            r3 = r2
        L_0x003c:
            monitor-exit(r0)     // Catch:{ all -> 0x004c }
            if (r2 == 0) goto L_0x0043
            r6.k0()
            goto L_0x004b
        L_0x0043:
            if (r3 == 0) goto L_0x004b
            androidx.camera.video.Recorder$h r0 = r6.f3010n
            r1 = 0
            r6.y0(r0, r1, r7, r8)
        L_0x004b:
            return
        L_0x004c:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004c }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.Recorder.j0(int, java.lang.Throwable):void");
    }

    /* access modifiers changed from: package-private */
    public void m0(AudioState audioState) {
        v1.a("Recorder", "Transitioning audio state: " + this.G + " --> " + audioState);
        this.G = audioState;
    }

    /* access modifiers changed from: package-private */
    public void o0(@NonNull State state) {
        if (this.f3004h != state) {
            v1.a("Recorder", "Transitioning Recorder internal state: " + this.f3004h + " --> " + state);
            Set<State> set = V;
            StreamInfo.StreamState streamState = null;
            if (set.contains(state)) {
                if (!set.contains(this.f3004h)) {
                    if (W.contains(this.f3004h)) {
                        State state2 = this.f3004h;
                        this.f3005i = state2;
                        streamState = E(state2);
                    } else {
                        throw new AssertionError("Invalid state transition. Should not be transitioning to a PENDING state from state " + this.f3004h);
                    }
                }
            } else if (this.f3005i != null) {
                this.f3005i = null;
            }
            this.f3004h = state;
            if (streamState == null) {
                streamState = E(state);
            }
            this.f2997a.h(StreamInfo.c(this.f3006j, streamState));
            return;
        }
        throw new AssertionError("Attempted to transition to state " + state + ", but Recorder is already in state " + state);
    }

    /* access modifiers changed from: package-private */
    public void q0(@NonNull h hVar) {
        int i10;
        MediaMuxer P2;
        if (this.f3022z != null) {
            throw new AssertionError("Unable to set up media muxer when one already exists.");
        } else if (!F() || !this.Q.isEmpty()) {
            androidx.camera.video.internal.encoder.g gVar = this.P;
            if (gVar != null) {
                try {
                    this.P = null;
                    List<androidx.camera.video.internal.encoder.g> y10 = y(gVar.z0());
                    long size = gVar.size();
                    for (androidx.camera.video.internal.encoder.g size2 : y10) {
                        size += size2.size();
                    }
                    long j10 = this.M;
                    if (j10 == 0 || size <= j10) {
                        try {
                            n nVar = (n) A(this.A);
                            if (nVar.c() == -1) {
                                i10 = z0(this.f3014r, n.g(Z.c()));
                            } else {
                                i10 = n.g(nVar.c());
                            }
                            P2 = hVar.P(i10, new b0.f(this));
                            SurfaceRequest.f fVar = this.f3013q;
                            if (fVar != null) {
                                P2.setOrientationHint(fVar.b());
                            }
                            Location b10 = hVar.v().b();
                            if (b10 != null) {
                                Pair<Double, Double> a10 = i0.a.a(b10.getLatitude(), b10.getLongitude());
                                P2.setLocation((float) ((Double) a10.first).doubleValue(), (float) ((Double) a10.second).doubleValue());
                            }
                            this.f3017u = Integer.valueOf(P2.addTrack(this.D.a()));
                            if (F()) {
                                this.f3016t = Integer.valueOf(P2.addTrack(this.F.a()));
                            }
                            P2.start();
                            this.f3022z = P2;
                            E0(gVar, hVar);
                            for (androidx.camera.video.internal.encoder.g D0 : y10) {
                                D0(D0, hVar);
                            }
                            gVar.close();
                        } catch (IOException e10) {
                            a0(hVar, 5, e10);
                            gVar.close();
                        }
                    } else {
                        v1.a("Recorder", String.format("Initial data exceeds file size limit %d > %d", new Object[]{Long.valueOf(size), Long.valueOf(this.M)}));
                        a0(hVar, 2, (Throwable) null);
                        gVar.close();
                    }
                } catch (IllegalArgumentException e11) {
                    P2.release();
                    a0(hVar, 5, e11);
                    gVar.close();
                } catch (Throwable th2) {
                    if (gVar != null) {
                        try {
                            gVar.close();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            } else {
                throw new AssertionError("Media muxer cannot be started without an encoded video frame.");
            }
        } else {
            throw new AssertionError("Audio is enabled but no audio sample is ready. Cannot start media muxer.");
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0083, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0022, code lost:
        r5 = r3;
        r3 = null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b0  */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.camera.video.d0 u0(@androidx.annotation.NonNull androidx.camera.video.p r10) {
        /*
            r9 = this;
            java.lang.String r0 = "The given PendingRecording cannot be null."
            androidx.core.util.h.h(r10, r0)
            java.lang.Object r0 = r9.f3003g
            monitor-enter(r0)
            long r1 = r9.f3009m     // Catch:{ all -> 0x00b8 }
            r3 = 1
            long r1 = r1 + r3
            r9.f3009m = r1     // Catch:{ all -> 0x00b8 }
            int[] r3 = androidx.camera.video.Recorder.f.f3051a     // Catch:{ all -> 0x00b8 }
            androidx.camera.video.Recorder$State r4 = r9.f3004h     // Catch:{ all -> 0x00b8 }
            int r4 = r4.ordinal()     // Catch:{ all -> 0x00b8 }
            r3 = r3[r4]     // Catch:{ all -> 0x00b8 }
            r4 = 0
            r5 = 0
            switch(r3) {
                case 1: goto L_0x002f;
                case 2: goto L_0x002f;
                case 3: goto L_0x0026;
                case 4: goto L_0x0026;
                case 5: goto L_0x002f;
                case 6: goto L_0x002f;
                case 7: goto L_0x0020;
                case 8: goto L_0x0020;
                case 9: goto L_0x002f;
                default: goto L_0x001e;
            }     // Catch:{ all -> 0x00b8 }
        L_0x001e:
            goto L_0x0083
        L_0x0020:
            androidx.camera.video.Recorder$h r3 = r9.f3007k     // Catch:{ all -> 0x00b8 }
        L_0x0022:
            r8 = r5
            r5 = r3
            r3 = r8
            goto L_0x0084
        L_0x0026:
            androidx.camera.video.Recorder$h r3 = r9.f3008l     // Catch:{ all -> 0x00b8 }
            java.lang.Object r3 = androidx.core.util.h.g(r3)     // Catch:{ all -> 0x00b8 }
            androidx.camera.video.Recorder$h r3 = (androidx.camera.video.Recorder.h) r3     // Catch:{ all -> 0x00b8 }
            goto L_0x0022
        L_0x002f:
            androidx.camera.video.Recorder$State r3 = r9.f3004h     // Catch:{ all -> 0x00b8 }
            androidx.camera.video.Recorder$State r6 = androidx.camera.video.Recorder.State.IDLING     // Catch:{ all -> 0x00b8 }
            if (r3 != r6) goto L_0x0045
            androidx.camera.video.Recorder$h r3 = r9.f3007k     // Catch:{ all -> 0x00b8 }
            if (r3 != 0) goto L_0x003f
            androidx.camera.video.Recorder$h r3 = r9.f3008l     // Catch:{ all -> 0x00b8 }
            if (r3 != 0) goto L_0x003f
            r3 = 1
            goto L_0x0040
        L_0x003f:
            r3 = r4
        L_0x0040:
            java.lang.String r7 = "Expected recorder to be idle but a recording is either pending or in progress."
            androidx.core.util.h.j(r3, r7)     // Catch:{ all -> 0x00b8 }
        L_0x0045:
            androidx.camera.video.Recorder$h r3 = androidx.camera.video.Recorder.h.m(r10, r1)     // Catch:{ IOException -> 0x0080 }
            android.content.Context r7 = r10.a()     // Catch:{ IOException -> 0x0080 }
            r3.C(r7)     // Catch:{ IOException -> 0x0080 }
            r9.f3008l = r3     // Catch:{ IOException -> 0x0080 }
            androidx.camera.video.Recorder$State r3 = r9.f3004h     // Catch:{ IOException -> 0x0080 }
            if (r3 != r6) goto L_0x0066
            androidx.camera.video.Recorder$State r3 = androidx.camera.video.Recorder.State.PENDING_RECORDING     // Catch:{ IOException -> 0x0080 }
            r9.o0(r3)     // Catch:{ IOException -> 0x0080 }
            java.util.concurrent.Executor r3 = r9.f3000d     // Catch:{ IOException -> 0x0080 }
            androidx.camera.video.t r6 = new androidx.camera.video.t     // Catch:{ IOException -> 0x0080 }
            r6.<init>(r9)     // Catch:{ IOException -> 0x0080 }
            r3.execute(r6)     // Catch:{ IOException -> 0x0080 }
            goto L_0x0083
        L_0x0066:
            androidx.camera.video.Recorder$State r6 = androidx.camera.video.Recorder.State.ERROR     // Catch:{ IOException -> 0x0080 }
            if (r3 != r6) goto L_0x007a
            androidx.camera.video.Recorder$State r3 = androidx.camera.video.Recorder.State.PENDING_RECORDING     // Catch:{ IOException -> 0x0080 }
            r9.o0(r3)     // Catch:{ IOException -> 0x0080 }
            java.util.concurrent.Executor r3 = r9.f3000d     // Catch:{ IOException -> 0x0080 }
            b0.m r6 = new b0.m     // Catch:{ IOException -> 0x0080 }
            r6.<init>(r9)     // Catch:{ IOException -> 0x0080 }
            r3.execute(r6)     // Catch:{ IOException -> 0x0080 }
            goto L_0x0083
        L_0x007a:
            androidx.camera.video.Recorder$State r3 = androidx.camera.video.Recorder.State.PENDING_RECORDING     // Catch:{ IOException -> 0x0080 }
            r9.o0(r3)     // Catch:{ IOException -> 0x0080 }
            goto L_0x0083
        L_0x0080:
            r3 = move-exception
            r4 = 5
            goto L_0x0084
        L_0x0083:
            r3 = r5
        L_0x0084:
            monitor-exit(r0)     // Catch:{ all -> 0x00b8 }
            if (r5 != 0) goto L_0x00b0
            if (r4 == 0) goto L_0x00ab
            java.lang.String r0 = "Recorder"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Recording was started when the Recorder had encountered error "
            r5.append(r6)
            r5.append(r3)
            java.lang.String r5 = r5.toString()
            androidx.camera.core.v1.c(r0, r5)
            androidx.camera.video.Recorder$h r0 = androidx.camera.video.Recorder.h.m(r10, r1)
            r9.x(r0, r4, r3)
            androidx.camera.video.d0 r10 = androidx.camera.video.d0.a(r10, r1)
            return r10
        L_0x00ab:
            androidx.camera.video.d0 r10 = androidx.camera.video.d0.b(r10, r1)
            return r10
        L_0x00b0:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "A recording is already in progress. Previous recordings must be stopped before a new recording can be started."
            r10.<init>(r0)
            throw r10
        L_0x00b8:
            r10 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00b8 }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.Recorder.u0(androidx.camera.video.p):androidx.camera.video.d0");
    }

    /* access modifiers changed from: package-private */
    public void w(int i10, Throwable th2) {
        i0.a aVar;
        if (this.f3010n != null) {
            MediaMuxer mediaMuxer = this.f3022z;
            if (mediaMuxer != null) {
                try {
                    mediaMuxer.stop();
                    this.f3022z.release();
                } catch (IllegalStateException e10) {
                    v1.c("Recorder", "MediaMuxer failed to stop or release with error: " + e10.getMessage());
                    if (i10 == 0) {
                        i10 = 1;
                    }
                }
                this.f3022z = null;
            } else if (i10 == 0) {
                i10 = 8;
            }
            this.f3010n.k(this.H);
            b0.e v10 = this.f3010n.v();
            e0 z10 = z();
            o b10 = o.b(this.H);
            h hVar = this.f3010n;
            if (i10 == 0) {
                aVar = i0.a(v10, z10, b10);
            } else {
                aVar = i0.b(v10, z10, b10, i10, th2);
            }
            hVar.S(aVar);
            h hVar2 = this.f3010n;
            this.f3010n = null;
            this.f3012p = false;
            this.f3016t = null;
            this.f3017u = null;
            this.f3015s.clear();
            this.H = Uri.EMPTY;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.N = 1;
            this.O = null;
            this.R = null;
            u();
            int i11 = f.f3052b[this.G.ordinal()];
            if (i11 == 1) {
                m0(AudioState.INITIALIZING);
            } else if (i11 == 2 || i11 == 3) {
                m0(AudioState.IDLING);
                this.B.F();
            } else if (i11 == 4) {
                throw new AssertionError("Incorrectly finalize recording when audio state is IDLING");
            }
            c0(hVar2);
            return;
        }
        throw new AssertionError("Attempted to finalize in-progress recording, but no recording is in progress.");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x007e, code lost:
        if (r2 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0080, code lost:
        x(r2, 8, new java.lang.RuntimeException("Recording was stopped before any data could be produced."));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void x0(@androidx.annotation.NonNull androidx.camera.video.d0 r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.f3003g
            monitor-enter(r0)
            androidx.camera.video.Recorder$h r1 = r6.f3008l     // Catch:{ all -> 0x008d }
            boolean r1 = H(r7, r1)     // Catch:{ all -> 0x008d }
            if (r1 != 0) goto L_0x002f
            androidx.camera.video.Recorder$h r1 = r6.f3007k     // Catch:{ all -> 0x008d }
            boolean r1 = H(r7, r1)     // Catch:{ all -> 0x008d }
            if (r1 != 0) goto L_0x002f
            java.lang.String r1 = "Recorder"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x008d }
            r2.<init>()     // Catch:{ all -> 0x008d }
            java.lang.String r3 = "stop() called on a recording that is no longer active: "
            r2.append(r3)     // Catch:{ all -> 0x008d }
            b0.e r7 = r7.c()     // Catch:{ all -> 0x008d }
            r2.append(r7)     // Catch:{ all -> 0x008d }
            java.lang.String r7 = r2.toString()     // Catch:{ all -> 0x008d }
            androidx.camera.core.v1.a(r1, r7)     // Catch:{ all -> 0x008d }
            monitor-exit(r0)     // Catch:{ all -> 0x008d }
            return
        L_0x002f:
            int[] r1 = androidx.camera.video.Recorder.f.f3051a     // Catch:{ all -> 0x008d }
            androidx.camera.video.Recorder$State r2 = r6.f3004h     // Catch:{ all -> 0x008d }
            int r2 = r2.ordinal()     // Catch:{ all -> 0x008d }
            r1 = r1[r2]     // Catch:{ all -> 0x008d }
            r2 = 0
            switch(r1) {
                case 1: goto L_0x0074;
                case 2: goto L_0x0074;
                case 3: goto L_0x0062;
                case 4: goto L_0x0062;
                case 5: goto L_0x005a;
                case 6: goto L_0x005a;
                case 7: goto L_0x003e;
                case 8: goto L_0x003e;
                default: goto L_0x003d;
            }     // Catch:{ all -> 0x008d }
        L_0x003d:
            goto L_0x007d
        L_0x003e:
            androidx.camera.video.Recorder$State r7 = androidx.camera.video.Recorder.State.STOPPING     // Catch:{ all -> 0x008d }
            r6.o0(r7)     // Catch:{ all -> 0x008d }
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch:{ all -> 0x008d }
            long r3 = java.lang.System.nanoTime()     // Catch:{ all -> 0x008d }
            long r3 = r7.toMicros(r3)     // Catch:{ all -> 0x008d }
            androidx.camera.video.Recorder$h r7 = r6.f3007k     // Catch:{ all -> 0x008d }
            java.util.concurrent.Executor r1 = r6.f3000d     // Catch:{ all -> 0x008d }
            androidx.camera.video.s r5 = new androidx.camera.video.s     // Catch:{ all -> 0x008d }
            r5.<init>(r6, r7, r3)     // Catch:{ all -> 0x008d }
            r1.execute(r5)     // Catch:{ all -> 0x008d }
            goto L_0x007d
        L_0x005a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch:{ all -> 0x008d }
            java.lang.String r1 = "Calling stop() while idling or initializing is invalid."
            r7.<init>(r1)     // Catch:{ all -> 0x008d }
            throw r7     // Catch:{ all -> 0x008d }
        L_0x0062:
            androidx.camera.video.Recorder$h r1 = r6.f3008l     // Catch:{ all -> 0x008d }
            boolean r7 = H(r7, r1)     // Catch:{ all -> 0x008d }
            androidx.core.util.h.i(r7)     // Catch:{ all -> 0x008d }
            androidx.camera.video.Recorder$h r7 = r6.f3008l     // Catch:{ all -> 0x008d }
            r6.f3008l = r2     // Catch:{ all -> 0x008d }
            r6.l0()     // Catch:{ all -> 0x008d }
            r2 = r7
            goto L_0x007d
        L_0x0074:
            androidx.camera.video.Recorder$h r1 = r6.f3007k     // Catch:{ all -> 0x008d }
            boolean r7 = H(r7, r1)     // Catch:{ all -> 0x008d }
            androidx.core.util.h.i(r7)     // Catch:{ all -> 0x008d }
        L_0x007d:
            monitor-exit(r0)     // Catch:{ all -> 0x008d }
            if (r2 == 0) goto L_0x008c
            r7 = 8
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "Recording was stopped before any data could be produced."
            r0.<init>(r1)
            r6.x(r2, r7, r0)
        L_0x008c:
            return
        L_0x008d:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x008d }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.Recorder.x0(androidx.camera.video.d0):void");
    }

    /* access modifiers changed from: package-private */
    public void y0(@NonNull h hVar, Long l10, int i10, Throwable th2) {
        boolean z10;
        if (this.f3010n == hVar && !this.f3012p) {
            if (f0.e.a(f0.g.class) != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f3011o = z10;
            this.f3012p = true;
            this.N = i10;
            this.O = th2;
            if (F()) {
                u();
                if (l10 == null) {
                    this.E.stop();
                } else {
                    this.E.c(l10.longValue());
                }
            }
            androidx.camera.video.internal.encoder.g gVar = this.P;
            if (gVar != null) {
                gVar.close();
                this.P = null;
            }
            if (this.T != VideoOutput.SourceState.ACTIVE_NON_STREAMING) {
                this.U = androidx.camera.core.impl.utils.executor.a.d().schedule(new b0.k(this, this.C), 1000, TimeUnit.MILLISECONDS);
            } else {
                X(this.C);
            }
            if (l10 == null) {
                this.C.stop();
            } else {
                this.C.c(l10.longValue());
            }
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public e0 z() {
        return e0.d(this.J, this.I, b.c(D(this.G), this.R));
    }
}
