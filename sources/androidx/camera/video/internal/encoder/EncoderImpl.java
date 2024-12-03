package androidx.camera.video.internal.encoder;

import android.annotation.SuppressLint;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.util.Range;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.Timebase;
import androidx.camera.core.impl.l1;
import androidx.camera.core.v1;
import androidx.camera.video.internal.BufferProvider;
import androidx.camera.video.internal.encoder.j;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.h;
import f0.g;
import f0.r;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReference;

public class EncoderImpl implements j {
    private static final Range<Long> C = Range.create(Long.MAX_VALUE, Long.MAX_VALUE);
    private boolean A = false;
    final i0.b B;

    /* renamed from: a  reason: collision with root package name */
    final String f3192a;

    /* renamed from: b  reason: collision with root package name */
    final Object f3193b = new Object();

    /* renamed from: c  reason: collision with root package name */
    final boolean f3194c;

    /* renamed from: d  reason: collision with root package name */
    private final MediaFormat f3195d;

    /* renamed from: e  reason: collision with root package name */
    final MediaCodec f3196e;

    /* renamed from: f  reason: collision with root package name */
    final j.b f3197f;

    /* renamed from: g  reason: collision with root package name */
    private final z0 f3198g;

    /* renamed from: h  reason: collision with root package name */
    final Executor f3199h;

    /* renamed from: i  reason: collision with root package name */
    private final zf.a<Void> f3200i;

    /* renamed from: j  reason: collision with root package name */
    private final CallbackToFutureAdapter.a<Void> f3201j;

    /* renamed from: k  reason: collision with root package name */
    final Queue<Integer> f3202k = new ArrayDeque();

    /* renamed from: l  reason: collision with root package name */
    private final Queue<CallbackToFutureAdapter.a<b1>> f3203l = new ArrayDeque();

    /* renamed from: m  reason: collision with root package name */
    private final Set<b1> f3204m = new HashSet();

    /* renamed from: n  reason: collision with root package name */
    final Set<i> f3205n = new HashSet();

    /* renamed from: o  reason: collision with root package name */
    final Deque<Range<Long>> f3206o = new ArrayDeque();

    /* renamed from: p  reason: collision with root package name */
    final Timebase f3207p;

    /* renamed from: q  reason: collision with root package name */
    final g1 f3208q = new f1();

    /* renamed from: r  reason: collision with root package name */
    k f3209r = k.f3326a;

    /* renamed from: s  reason: collision with root package name */
    Executor f3210s = androidx.camera.core.impl.utils.executor.a.a();

    /* renamed from: t  reason: collision with root package name */
    InternalState f3211t;

    /* renamed from: u  reason: collision with root package name */
    Range<Long> f3212u = C;

    /* renamed from: v  reason: collision with root package name */
    long f3213v = 0;

    /* renamed from: w  reason: collision with root package name */
    boolean f3214w = false;

    /* renamed from: x  reason: collision with root package name */
    Long f3215x = null;

    /* renamed from: y  reason: collision with root package name */
    Future<?> f3216y = null;

    /* renamed from: z  reason: collision with root package name */
    private boolean f3217z = false;

    enum InternalState {
        CONFIGURED,
        STARTED,
        PAUSED,
        STOPPING,
        PENDING_START,
        PENDING_START_PAUSED,
        PENDING_RELEASE,
        ERROR,
        RELEASED
    }

    class a implements u.c<b1> {

        /* renamed from: androidx.camera.video.internal.encoder.EncoderImpl$a$a  reason: collision with other inner class name */
        class C0023a implements u.c<Void> {
            C0023a() {
            }

            /* renamed from: a */
            public void onSuccess(Void voidR) {
            }

            public void onFailure(@NonNull Throwable th2) {
                if (th2 instanceof MediaCodec.CodecException) {
                    EncoderImpl.this.z((MediaCodec.CodecException) th2);
                } else {
                    EncoderImpl.this.y(0, th2.getMessage(), th2);
                }
            }
        }

        a() {
        }

        /* renamed from: a */
        public void onSuccess(b1 b1Var) {
            b1Var.c(EncoderImpl.this.w());
            b1Var.a(true);
            b1Var.b();
            u.f.b(b1Var.d(), new C0023a(), EncoderImpl.this.f3199h);
        }

        public void onFailure(@NonNull Throwable th2) {
            EncoderImpl.this.y(0, "Unable to acquire InputBuffer.", th2);
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3230a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|(3:17|18|20)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.camera.video.internal.encoder.EncoderImpl$InternalState[] r0 = androidx.camera.video.internal.encoder.EncoderImpl.InternalState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3230a = r0
                androidx.camera.video.internal.encoder.EncoderImpl$InternalState r1 = androidx.camera.video.internal.encoder.EncoderImpl.InternalState.CONFIGURED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f3230a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.camera.video.internal.encoder.EncoderImpl$InternalState r1 = androidx.camera.video.internal.encoder.EncoderImpl.InternalState.STARTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f3230a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.camera.video.internal.encoder.EncoderImpl$InternalState r1 = androidx.camera.video.internal.encoder.EncoderImpl.InternalState.PAUSED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f3230a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.camera.video.internal.encoder.EncoderImpl$InternalState r1 = androidx.camera.video.internal.encoder.EncoderImpl.InternalState.STOPPING     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f3230a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.camera.video.internal.encoder.EncoderImpl$InternalState r1 = androidx.camera.video.internal.encoder.EncoderImpl.InternalState.PENDING_START_PAUSED     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f3230a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.camera.video.internal.encoder.EncoderImpl$InternalState r1 = androidx.camera.video.internal.encoder.EncoderImpl.InternalState.PENDING_START     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f3230a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.camera.video.internal.encoder.EncoderImpl$InternalState r1 = androidx.camera.video.internal.encoder.EncoderImpl.InternalState.PENDING_RELEASE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f3230a     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.camera.video.internal.encoder.EncoderImpl$InternalState r1 = androidx.camera.video.internal.encoder.EncoderImpl.InternalState.ERROR     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f3230a     // Catch:{ NoSuchFieldError -> 0x006c }
                androidx.camera.video.internal.encoder.EncoderImpl$InternalState r1 = androidx.camera.video.internal.encoder.EncoderImpl.InternalState.RELEASED     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.internal.encoder.EncoderImpl.b.<clinit>():void");
        }
    }

    private static class c {
        @NonNull
        static Surface a() {
            return MediaCodec.createPersistentInputSurface();
        }

        static void b(@NonNull MediaCodec mediaCodec, @NonNull Surface surface) {
            mediaCodec.setInputSurface(surface);
        }
    }

    class d implements j.a {

        /* renamed from: a  reason: collision with root package name */
        private final Map<l1.a<? super BufferProvider.State>, Executor> f3231a = new LinkedHashMap();

        /* renamed from: b  reason: collision with root package name */
        private BufferProvider.State f3232b = BufferProvider.State.INACTIVE;

        /* renamed from: c  reason: collision with root package name */
        private final List<zf.a<b1>> f3233c = new ArrayList();

        d() {
        }

        /* access modifiers changed from: private */
        /* renamed from: p */
        public void q(@NonNull zf.a<b1> aVar) {
            if (!aVar.cancel(true)) {
                h.i(aVar.isDone());
                try {
                    aVar.get().cancel();
                } catch (InterruptedException | CancellationException | ExecutionException e10) {
                    String str = EncoderImpl.this.f3192a;
                    v1.l(str, "Unable to cancel the input buffer: " + e10);
                }
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void r(zf.a aVar) {
            this.f3233c.remove(aVar);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void s(CallbackToFutureAdapter.a aVar) {
            BufferProvider.State state = this.f3232b;
            if (state == BufferProvider.State.ACTIVE) {
                zf.a<b1> u10 = EncoderImpl.this.u();
                u.f.k(u10, aVar);
                aVar.a(new d0(this, u10), androidx.camera.core.impl.utils.executor.a.a());
                this.f3233c.add(u10);
                u10.addListener(new e0(this, u10), EncoderImpl.this.f3199h);
            } else if (state == BufferProvider.State.INACTIVE) {
                aVar.f(new IllegalStateException("BufferProvider is not active."));
            } else {
                aVar.f(new IllegalStateException("Unknown state: " + this.f3232b));
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ Object t(CallbackToFutureAdapter.a aVar) throws Exception {
            EncoderImpl.this.f3199h.execute(new m0(this, aVar));
            return "acquireBuffer";
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void v(l1.a aVar, Executor executor) {
            this.f3231a.put((l1.a) h.g(aVar), (Executor) h.g(executor));
            executor.execute(new j0(aVar, this.f3232b));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void w(CallbackToFutureAdapter.a aVar) {
            aVar.c(this.f3232b);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ Object x(CallbackToFutureAdapter.a aVar) throws Exception {
            EncoderImpl.this.f3199h.execute(new l0(this, aVar));
            return "fetchData";
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void y(l1.a aVar) {
            this.f3231a.remove(h.g(aVar));
        }

        /* access modifiers changed from: package-private */
        public void A(boolean z10) {
            BufferProvider.State state;
            if (z10) {
                state = BufferProvider.State.ACTIVE;
            } else {
                state = BufferProvider.State.INACTIVE;
            }
            if (this.f3232b != state) {
                this.f3232b = state;
                if (state == BufferProvider.State.INACTIVE) {
                    for (zf.a<b1> cancel : this.f3233c) {
                        cancel.cancel(true);
                    }
                    this.f3233c.clear();
                }
                for (Map.Entry next : this.f3231a.entrySet()) {
                    try {
                        ((Executor) next.getValue()).execute(new f0(next, state));
                    } catch (RejectedExecutionException e10) {
                        v1.d(EncoderImpl.this.f3192a, "Unable to post to the supplied executor.", e10);
                    }
                }
            }
        }

        @NonNull
        public zf.a<BufferProvider.State> b() {
            return CallbackToFutureAdapter.a(new h0(this));
        }

        public void c(@NonNull Executor executor, @NonNull l1.a<? super BufferProvider.State> aVar) {
            EncoderImpl.this.f3199h.execute(new i0(this, aVar, executor));
        }

        public void d(@NonNull l1.a<? super BufferProvider.State> aVar) {
            EncoderImpl.this.f3199h.execute(new g0(this, aVar));
        }

        @NonNull
        public zf.a<b1> e() {
            return CallbackToFutureAdapter.a(new k0(this));
        }
    }

    class e extends MediaCodec.Callback {

        /* renamed from: a  reason: collision with root package name */
        private final i0.d f3235a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f3236b = false;

        /* renamed from: c  reason: collision with root package name */
        private boolean f3237c = false;

        /* renamed from: d  reason: collision with root package name */
        private boolean f3238d = false;

        /* renamed from: e  reason: collision with root package name */
        private long f3239e = 0;

        /* renamed from: f  reason: collision with root package name */
        private long f3240f = 0;

        /* renamed from: g  reason: collision with root package name */
        private boolean f3241g = false;

        /* renamed from: h  reason: collision with root package name */
        private boolean f3242h = false;

        class a implements u.c<Void> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ i f3244a;

            a(i iVar) {
                this.f3244a = iVar;
            }

            /* renamed from: a */
            public void onSuccess(Void voidR) {
                EncoderImpl.this.f3205n.remove(this.f3244a);
            }

            public void onFailure(@NonNull Throwable th2) {
                EncoderImpl.this.f3205n.remove(this.f3244a);
                if (th2 instanceof MediaCodec.CodecException) {
                    EncoderImpl.this.z((MediaCodec.CodecException) th2);
                } else {
                    EncoderImpl.this.y(0, th2.getMessage(), th2);
                }
            }
        }

        e() {
            Timebase timebase = null;
            if (EncoderImpl.this.f3194c) {
                this.f3235a = new i0.d(EncoderImpl.this.f3208q, f0.e.a(f0.c.class) == null ? EncoderImpl.this.f3207p : timebase);
            } else {
                this.f3235a = null;
            }
        }

        private boolean i(@NonNull MediaCodec.BufferInfo bufferInfo) {
            if (this.f3238d) {
                v1.a(EncoderImpl.this.f3192a, "Drop buffer by already reach end of stream.");
                return false;
            } else if (bufferInfo.size <= 0) {
                v1.a(EncoderImpl.this.f3192a, "Drop buffer by invalid buffer size.");
                return false;
            } else if ((bufferInfo.flags & 2) != 0) {
                v1.a(EncoderImpl.this.f3192a, "Drop buffer by codec config.");
                return false;
            } else {
                i0.d dVar = this.f3235a;
                if (dVar != null) {
                    bufferInfo.presentationTimeUs = dVar.b(bufferInfo.presentationTimeUs);
                }
                long j10 = bufferInfo.presentationTimeUs;
                if (j10 <= this.f3239e) {
                    v1.a(EncoderImpl.this.f3192a, "Drop buffer by out of order buffer from MediaCodec.");
                    return false;
                }
                this.f3239e = j10;
                if (!EncoderImpl.this.f3212u.contains(Long.valueOf(j10))) {
                    v1.a(EncoderImpl.this.f3192a, "Drop buffer by not in start-stop range.");
                    EncoderImpl encoderImpl = EncoderImpl.this;
                    if (encoderImpl.f3214w && bufferInfo.presentationTimeUs >= encoderImpl.f3212u.getUpper().longValue()) {
                        Future<?> future = EncoderImpl.this.f3216y;
                        if (future != null) {
                            future.cancel(true);
                        }
                        EncoderImpl.this.f3215x = Long.valueOf(bufferInfo.presentationTimeUs);
                        EncoderImpl.this.a0();
                        EncoderImpl.this.f3214w = false;
                    }
                    return false;
                } else if (s(bufferInfo)) {
                    v1.a(EncoderImpl.this.f3192a, "Drop buffer by pause.");
                    return false;
                } else if (EncoderImpl.this.x(bufferInfo) <= this.f3240f) {
                    v1.a(EncoderImpl.this.f3192a, "Drop buffer by adjusted time is less than the last sent time.");
                    if (EncoderImpl.this.f3194c && EncoderImpl.D(bufferInfo)) {
                        this.f3242h = true;
                    }
                    return false;
                } else {
                    if (!this.f3237c && !this.f3242h && EncoderImpl.this.f3194c) {
                        this.f3242h = true;
                    }
                    if (this.f3242h) {
                        if (!EncoderImpl.D(bufferInfo)) {
                            v1.a(EncoderImpl.this.f3192a, "Drop buffer by not a key frame.");
                            EncoderImpl.this.W();
                            return false;
                        }
                        this.f3242h = false;
                    }
                    return true;
                }
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void j(MediaCodec.CodecException codecException) {
            switch (b.f3230a[EncoderImpl.this.f3211t.ordinal()]) {
                case 1:
                case 8:
                case 9:
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    EncoderImpl.this.z(codecException);
                    return;
                default:
                    throw new IllegalStateException("Unknown state: " + EncoderImpl.this.f3211t);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void k(int i10) {
            switch (b.f3230a[EncoderImpl.this.f3211t.ordinal()]) {
                case 1:
                case 8:
                case 9:
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    EncoderImpl.this.f3202k.offer(Integer.valueOf(i10));
                    EncoderImpl.this.T();
                    return;
                default:
                    throw new IllegalStateException("Unknown state: " + EncoderImpl.this.f3211t);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void l(Executor executor, k kVar) {
            if (EncoderImpl.this.f3211t != InternalState.ERROR) {
                try {
                    Objects.requireNonNull(kVar);
                    executor.execute(new x0(kVar));
                } catch (RejectedExecutionException e10) {
                    v1.d(EncoderImpl.this.f3192a, "Unable to post to the supplied executor.", e10);
                }
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void m(MediaCodec.BufferInfo bufferInfo, MediaCodec mediaCodec, int i10) {
            k kVar;
            Executor executor;
            switch (b.f3230a[EncoderImpl.this.f3211t.ordinal()]) {
                case 1:
                case 8:
                case 9:
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    synchronized (EncoderImpl.this.f3193b) {
                        EncoderImpl encoderImpl = EncoderImpl.this;
                        kVar = encoderImpl.f3209r;
                        executor = encoderImpl.f3210s;
                    }
                    if (!this.f3236b) {
                        this.f3236b = true;
                        try {
                            Objects.requireNonNull(kVar);
                            executor.execute(new t0(kVar));
                        } catch (RejectedExecutionException e10) {
                            v1.d(EncoderImpl.this.f3192a, "Unable to post to the supplied executor.", e10);
                        }
                    }
                    boolean z10 = false;
                    if (i(bufferInfo)) {
                        if (!this.f3237c) {
                            this.f3237c = true;
                        }
                        long x10 = EncoderImpl.this.x(bufferInfo);
                        if (bufferInfo.presentationTimeUs != x10) {
                            if (x10 > this.f3240f) {
                                z10 = true;
                            }
                            h.i(z10);
                            bufferInfo.presentationTimeUs = x10;
                        }
                        this.f3240f = bufferInfo.presentationTimeUs;
                        try {
                            r(new i(mediaCodec, i10, bufferInfo), kVar, executor);
                        } catch (MediaCodec.CodecException e11) {
                            EncoderImpl.this.z(e11);
                            return;
                        }
                    } else {
                        try {
                            EncoderImpl.this.f3196e.releaseOutputBuffer(i10, false);
                        } catch (MediaCodec.CodecException e12) {
                            EncoderImpl.this.z(e12);
                            return;
                        }
                    }
                    if (!this.f3238d && EncoderImpl.B(bufferInfo)) {
                        this.f3238d = true;
                        EncoderImpl.this.d0(new u0(this, executor, kVar));
                        return;
                    }
                    return;
                default:
                    throw new IllegalStateException("Unknown state: " + EncoderImpl.this.f3211t);
            }
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ MediaFormat n(MediaFormat mediaFormat) {
            return mediaFormat;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void p(MediaFormat mediaFormat) {
            k kVar;
            Executor executor;
            switch (b.f3230a[EncoderImpl.this.f3211t.ordinal()]) {
                case 1:
                case 8:
                case 9:
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    synchronized (EncoderImpl.this.f3193b) {
                        EncoderImpl encoderImpl = EncoderImpl.this;
                        kVar = encoderImpl.f3209r;
                        executor = encoderImpl.f3210s;
                    }
                    try {
                        executor.execute(new s0(kVar, mediaFormat));
                        return;
                    } catch (RejectedExecutionException e10) {
                        v1.d(EncoderImpl.this.f3192a, "Unable to post to the supplied executor.", e10);
                        return;
                    }
                default:
                    throw new IllegalStateException("Unknown state: " + EncoderImpl.this.f3211t);
            }
        }

        private void r(@NonNull i iVar, @NonNull k kVar, @NonNull Executor executor) {
            EncoderImpl.this.f3205n.add(iVar);
            u.f.b(iVar.b(), new a(iVar), EncoderImpl.this.f3199h);
            try {
                executor.execute(new o0(kVar, iVar));
            } catch (RejectedExecutionException e10) {
                v1.d(EncoderImpl.this.f3192a, "Unable to post to the supplied executor.", e10);
                iVar.close();
            }
        }

        private boolean s(@NonNull MediaCodec.BufferInfo bufferInfo) {
            Executor executor;
            k kVar;
            EncoderImpl.this.e0(bufferInfo.presentationTimeUs);
            boolean C = EncoderImpl.this.C(bufferInfo.presentationTimeUs);
            boolean z10 = this.f3241g;
            if (!z10 && C) {
                v1.a(EncoderImpl.this.f3192a, "Switch to pause state");
                this.f3241g = true;
                synchronized (EncoderImpl.this.f3193b) {
                    EncoderImpl encoderImpl = EncoderImpl.this;
                    executor = encoderImpl.f3210s;
                    kVar = encoderImpl.f3209r;
                }
                Objects.requireNonNull(kVar);
                executor.execute(new v0(kVar));
                EncoderImpl encoderImpl2 = EncoderImpl.this;
                if (encoderImpl2.f3211t == InternalState.PAUSED && ((encoderImpl2.f3194c || f0.e.a(f0.a.class) == null) && (!EncoderImpl.this.f3194c || f0.e.a(r.class) == null))) {
                    j.b bVar = EncoderImpl.this.f3197f;
                    if (bVar instanceof d) {
                        ((d) bVar).A(false);
                    }
                    EncoderImpl.this.Y(true);
                }
                EncoderImpl.this.f3215x = Long.valueOf(bufferInfo.presentationTimeUs);
                EncoderImpl encoderImpl3 = EncoderImpl.this;
                if (encoderImpl3.f3214w) {
                    Future<?> future = encoderImpl3.f3216y;
                    if (future != null) {
                        future.cancel(true);
                    }
                    EncoderImpl.this.a0();
                    EncoderImpl.this.f3214w = false;
                }
            } else if (z10 && !C) {
                v1.a(EncoderImpl.this.f3192a, "Switch to resume state");
                this.f3241g = false;
                if (EncoderImpl.this.f3194c && !EncoderImpl.D(bufferInfo)) {
                    this.f3242h = true;
                }
            }
            return this.f3241g;
        }

        public void onError(@NonNull MediaCodec mediaCodec, @NonNull MediaCodec.CodecException codecException) {
            EncoderImpl.this.f3199h.execute(new n0(this, codecException));
        }

        public void onInputBufferAvailable(MediaCodec mediaCodec, int i10) {
            EncoderImpl.this.f3199h.execute(new q0(this, i10));
        }

        public void onOutputBufferAvailable(@NonNull MediaCodec mediaCodec, int i10, @NonNull MediaCodec.BufferInfo bufferInfo) {
            EncoderImpl.this.f3199h.execute(new p0(this, bufferInfo, mediaCodec, i10));
        }

        public void onOutputFormatChanged(@NonNull MediaCodec mediaCodec, @NonNull MediaFormat mediaFormat) {
            EncoderImpl.this.f3199h.execute(new r0(this, mediaFormat));
        }
    }

    class f implements j.c {

        /* renamed from: a  reason: collision with root package name */
        private final Object f3246a = new Object();

        /* renamed from: b  reason: collision with root package name */
        private Surface f3247b;

        /* renamed from: c  reason: collision with root package name */
        private final Set<Surface> f3248c = new HashSet();

        /* renamed from: d  reason: collision with root package name */
        private j.c.a f3249d;

        /* renamed from: e  reason: collision with root package name */
        private Executor f3250e;

        f() {
        }

        private void d(@NonNull Executor executor, @NonNull j.c.a aVar, @NonNull Surface surface) {
            try {
                executor.execute(new y0(aVar, surface));
            } catch (RejectedExecutionException e10) {
                v1.d(EncoderImpl.this.f3192a, "Unable to post to the supplied executor.", e10);
            }
        }

        public void a(@NonNull Executor executor, @NonNull j.c.a aVar) {
            Surface surface;
            synchronized (this.f3246a) {
                this.f3249d = (j.c.a) h.g(aVar);
                this.f3250e = (Executor) h.g(executor);
                surface = this.f3247b;
            }
            if (surface != null) {
                d(executor, aVar, surface);
            }
        }

        /* access modifiers changed from: package-private */
        public void e() {
            Surface surface;
            HashSet<Surface> hashSet;
            synchronized (this.f3246a) {
                surface = this.f3247b;
                this.f3247b = null;
                hashSet = new HashSet<>(this.f3248c);
                this.f3248c.clear();
            }
            if (surface != null) {
                surface.release();
            }
            for (Surface release : hashSet) {
                release.release();
            }
        }

        /* access modifiers changed from: package-private */
        @SuppressLint({"NewApi"})
        public void f() {
            Surface surface;
            j.c.a aVar;
            Executor executor;
            g gVar = (g) f0.e.a(g.class);
            synchronized (this.f3246a) {
                if (gVar == null) {
                    if (this.f3247b == null) {
                        surface = c.a();
                        this.f3247b = surface;
                    } else {
                        surface = null;
                    }
                    c.b(EncoderImpl.this.f3196e, this.f3247b);
                } else {
                    Surface surface2 = this.f3247b;
                    if (surface2 != null) {
                        this.f3248c.add(surface2);
                    }
                    surface = EncoderImpl.this.f3196e.createInputSurface();
                    this.f3247b = surface;
                }
                aVar = this.f3249d;
                executor = this.f3250e;
            }
            if (surface != null && aVar != null && executor != null) {
                d(executor, aVar, surface);
            }
        }
    }

    public EncoderImpl(@NonNull Executor executor, @NonNull l lVar) throws InvalidConfigException {
        i0.b bVar = new i0.b();
        this.B = bVar;
        h.g(executor);
        h.g(lVar);
        this.f3199h = androidx.camera.core.impl.utils.executor.a.f(executor);
        if (lVar instanceof a) {
            this.f3192a = "AudioEncoder";
            this.f3194c = false;
            this.f3197f = new d();
        } else if (lVar instanceof h1) {
            this.f3192a = "VideoEncoder";
            this.f3194c = true;
            this.f3197f = new f();
        } else {
            throw new InvalidConfigException("Unknown encoder config type");
        }
        Timebase c10 = lVar.c();
        this.f3207p = c10;
        String str = this.f3192a;
        v1.a(str, "mInputTimebase = " + c10);
        MediaFormat a10 = lVar.a();
        this.f3195d = a10;
        String str2 = this.f3192a;
        v1.a(str2, "mMediaFormat = " + a10);
        MediaCodec a11 = bVar.a(a10);
        this.f3196e = a11;
        String str3 = this.f3192a;
        v1.e(str3, "Selected encoder: " + a11.getName());
        this.f3198g = v(this.f3194c, a11.getCodecInfo(), lVar.b());
        try {
            X();
            AtomicReference atomicReference = new AtomicReference();
            this.f3200i = u.f.j(CallbackToFutureAdapter.a(new z(atomicReference)));
            this.f3201j = (CallbackToFutureAdapter.a) h.g((CallbackToFutureAdapter.a) atomicReference.get());
            Z(InternalState.CONFIGURED);
        } catch (MediaCodec.CodecException e10) {
            throw new InvalidConfigException((Throwable) e10);
        }
    }

    static boolean B(@NonNull MediaCodec.BufferInfo bufferInfo) {
        return (bufferInfo.flags & 4) != 0;
    }

    static boolean D(@NonNull MediaCodec.BufferInfo bufferInfo) {
        return (bufferInfo.flags & 1) != 0;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void F(CallbackToFutureAdapter.a aVar) {
        this.f3203l.remove(aVar);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void H(d1 d1Var) {
        this.f3204m.remove(d1Var);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void K(long j10) {
        switch (b.f3230a[this.f3211t.ordinal()]) {
            case 1:
            case 3:
            case 4:
            case 5:
            case 8:
                return;
            case 2:
                String str = this.f3192a;
                v1.a(str, "Pause on " + d0.h.j(j10));
                this.f3206o.addLast(Range.create(Long.valueOf(j10), Long.MAX_VALUE));
                Z(InternalState.PAUSED);
                return;
            case 6:
                Z(InternalState.PENDING_START_PAUSED);
                return;
            case 7:
            case 9:
                throw new IllegalStateException("Encoder is released");
            default:
                throw new IllegalStateException("Unknown state: " + this.f3211t);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L() {
        switch (b.f3230a[this.f3211t.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 8:
                V();
                return;
            case 4:
            case 5:
            case 6:
                Z(InternalState.PENDING_RELEASE);
                return;
            case 7:
            case 9:
                return;
            default:
                throw new IllegalStateException("Unknown state: " + this.f3211t);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void M() {
        int i10 = b.f3230a[this.f3211t.ordinal()];
        if (i10 == 2) {
            W();
        } else if (i10 == 7 || i10 == 9) {
            throw new IllegalStateException("Encoder is released");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void N() {
        this.A = true;
        if (this.f3217z) {
            this.f3196e.stop();
            X();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O(long j10) {
        boolean z10;
        switch (b.f3230a[this.f3211t.ordinal()]) {
            case 1:
                this.f3215x = null;
                v1.a(this.f3192a, "Start on " + d0.h.j(j10));
                try {
                    if (this.f3217z) {
                        X();
                    }
                    this.f3212u = Range.create(Long.valueOf(j10), Long.MAX_VALUE);
                    this.f3196e.start();
                    j.b bVar = this.f3197f;
                    if (bVar instanceof d) {
                        ((d) bVar).A(true);
                    }
                    Z(InternalState.STARTED);
                    return;
                } catch (MediaCodec.CodecException e10) {
                    z(e10);
                    return;
                }
            case 2:
            case 6:
            case 8:
                return;
            case 3:
                this.f3215x = null;
                Range removeLast = this.f3206o.removeLast();
                if (removeLast == null || ((Long) removeLast.getUpper()).longValue() != Long.MAX_VALUE) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                h.j(z10, "There should be a \"pause\" before \"resume\"");
                long longValue = ((Long) removeLast.getLower()).longValue();
                this.f3206o.addLast(Range.create(Long.valueOf(longValue), Long.valueOf(j10)));
                v1.a(this.f3192a, "Resume on " + d0.h.j(j10) + "\nPaused duration = " + d0.h.j(j10 - longValue));
                if ((this.f3194c || f0.e.a(f0.a.class) == null) && (!this.f3194c || f0.e.a(r.class) == null)) {
                    Y(false);
                    j.b bVar2 = this.f3197f;
                    if (bVar2 instanceof d) {
                        ((d) bVar2).A(true);
                    }
                }
                if (this.f3194c) {
                    W();
                }
                Z(InternalState.STARTED);
                return;
            case 4:
            case 5:
                Z(InternalState.PENDING_START);
                return;
            case 7:
            case 9:
                throw new IllegalStateException("Encoder is released");
            default:
                throw new IllegalStateException("Unknown state: " + this.f3211t);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void P() {
        if (this.f3214w) {
            v1.l(this.f3192a, "The data didn't reach the expected timestamp before timeout, stop the codec.");
            this.f3215x = null;
            a0();
            this.f3214w = false;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Q() {
        this.f3199h.execute(new v(this));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00b3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void R(long r6, long r8) {
        /*
            r5 = this;
            int[] r0 = androidx.camera.video.internal.encoder.EncoderImpl.b.f3230a
            androidx.camera.video.internal.encoder.EncoderImpl$InternalState r1 = r5.f3211t
            int r1 = r1.ordinal()
            r0 = r0[r1]
            switch(r0) {
                case 1: goto L_0x00c3;
                case 2: goto L_0x0035;
                case 3: goto L_0x0035;
                case 4: goto L_0x00c3;
                case 5: goto L_0x002e;
                case 6: goto L_0x002e;
                case 7: goto L_0x0026;
                case 8: goto L_0x00c3;
                case 9: goto L_0x0026;
                default: goto L_0x000d;
            }
        L_0x000d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Unknown state: "
            r7.append(r8)
            androidx.camera.video.internal.encoder.EncoderImpl$InternalState r8 = r5.f3211t
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        L_0x0026:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "Encoder is released"
            r6.<init>(r7)
            throw r6
        L_0x002e:
            androidx.camera.video.internal.encoder.EncoderImpl$InternalState r6 = androidx.camera.video.internal.encoder.EncoderImpl.InternalState.CONFIGURED
            r5.Z(r6)
            goto L_0x00c3
        L_0x0035:
            androidx.camera.video.internal.encoder.EncoderImpl$InternalState r0 = r5.f3211t
            androidx.camera.video.internal.encoder.EncoderImpl$InternalState r1 = androidx.camera.video.internal.encoder.EncoderImpl.InternalState.STOPPING
            r5.Z(r1)
            android.util.Range<java.lang.Long> r1 = r5.f3212u
            java.lang.Comparable r1 = r1.getLower()
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 == 0) goto L_0x00bb
            r3 = -1
            int r3 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r3 != 0) goto L_0x0058
            goto L_0x0063
        L_0x0058:
            int r3 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r3 >= 0) goto L_0x0064
            java.lang.String r6 = r5.f3192a
            java.lang.String r7 = "The expected stop time is less than the start time. Use current time as stop time."
            androidx.camera.core.v1.l(r6, r7)
        L_0x0063:
            r6 = r8
        L_0x0064:
            int r8 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r8 < 0) goto L_0x00b3
            java.lang.Long r8 = java.lang.Long.valueOf(r1)
            java.lang.Long r9 = java.lang.Long.valueOf(r6)
            android.util.Range r8 = android.util.Range.create(r8, r9)
            r5.f3212u = r8
            java.lang.String r8 = r5.f3192a
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r1 = "Stop on "
            r9.append(r1)
            java.lang.String r6 = d0.h.j(r6)
            r9.append(r6)
            java.lang.String r6 = r9.toString()
            androidx.camera.core.v1.a(r8, r6)
            androidx.camera.video.internal.encoder.EncoderImpl$InternalState r6 = androidx.camera.video.internal.encoder.EncoderImpl.InternalState.PAUSED
            if (r0 != r6) goto L_0x009c
            java.lang.Long r6 = r5.f3215x
            if (r6 == 0) goto L_0x009c
            r5.a0()
            goto L_0x00c3
        L_0x009c:
            r6 = 1
            r5.f3214w = r6
            java.util.concurrent.ScheduledExecutorService r6 = androidx.camera.core.impl.utils.executor.a.d()
            androidx.camera.video.internal.encoder.t r7 = new androidx.camera.video.internal.encoder.t
            r7.<init>(r5)
            r8 = 1000(0x3e8, double:4.94E-321)
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.MILLISECONDS
            java.util.concurrent.ScheduledFuture r6 = r6.schedule(r7, r8, r0)
            r5.f3216y = r6
            goto L_0x00c3
        L_0x00b3:
            java.lang.AssertionError r6 = new java.lang.AssertionError
            java.lang.String r7 = "The start time should be before the stop time."
            r6.<init>(r7)
            throw r6
        L_0x00bb:
            java.lang.AssertionError r6 = new java.lang.AssertionError
            java.lang.String r7 = "There should be a \"start\" before \"stop\""
            r6.<init>(r7)
            throw r6
        L_0x00c3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.internal.encoder.EncoderImpl.R(long, long):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void S(List list, Runnable runnable) {
        if (!list.isEmpty()) {
            v1.a(this.f3192a, "encoded data and input buffers are returned");
        }
        if (!(this.f3197f instanceof f) || this.A) {
            this.f3196e.stop();
        } else {
            this.f3196e.flush();
            this.f3217z = true;
        }
        if (runnable != null) {
            runnable.run();
        }
        A();
    }

    private void V() {
        if (this.f3217z) {
            this.f3196e.stop();
            this.f3217z = false;
        }
        this.f3196e.release();
        j.b bVar = this.f3197f;
        if (bVar instanceof f) {
            ((f) bVar).e();
        }
        Z(InternalState.RELEASED);
        this.f3201j.c(null);
    }

    private void X() {
        this.f3212u = C;
        this.f3213v = 0;
        this.f3206o.clear();
        this.f3202k.clear();
        for (CallbackToFutureAdapter.a<b1> d10 : this.f3203l) {
            d10.d();
        }
        this.f3203l.clear();
        this.f3196e.reset();
        this.f3217z = false;
        this.A = false;
        this.f3214w = false;
        Future<?> future = this.f3216y;
        if (future != null) {
            future.cancel(true);
            this.f3216y = null;
        }
        this.f3196e.setCallback(new e());
        this.f3196e.configure(this.f3195d, (Surface) null, (MediaCrypto) null, 1);
        j.b bVar = this.f3197f;
        if (bVar instanceof f) {
            ((f) bVar).f();
        }
    }

    private void Z(InternalState internalState) {
        if (this.f3211t != internalState) {
            String str = this.f3192a;
            v1.a(str, "Transitioning encoder internal state: " + this.f3211t + " --> " + internalState);
            this.f3211t = internalState;
        }
    }

    /* access modifiers changed from: private */
    public void b0() {
        u.f.b(u(), new a(), this.f3199h);
    }

    @NonNull
    private static z0 v(boolean z10, @NonNull MediaCodecInfo mediaCodecInfo, @NonNull String str) throws InvalidConfigException {
        if (z10) {
            return new j1(mediaCodecInfo, str);
        }
        return new b(mediaCodecInfo, str);
    }

    /* access modifiers changed from: package-private */
    public void A() {
        InternalState internalState = this.f3211t;
        if (internalState == InternalState.PENDING_RELEASE) {
            V();
            return;
        }
        if (!this.f3217z) {
            X();
        }
        Z(InternalState.CONFIGURED);
        if (internalState == InternalState.PENDING_START || internalState == InternalState.PENDING_START_PAUSED) {
            start();
            if (internalState == InternalState.PENDING_START_PAUSED) {
                pause();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean C(long j10) {
        for (Range next : this.f3206o) {
            if (!next.contains(Long.valueOf(j10))) {
                if (j10 < ((Long) next.getLower()).longValue()) {
                    break;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void T() {
        while (!this.f3203l.isEmpty() && !this.f3202k.isEmpty()) {
            CallbackToFutureAdapter.a poll = this.f3203l.poll();
            try {
                d1 d1Var = new d1(this.f3196e, this.f3202k.poll().intValue());
                if (poll.c(d1Var)) {
                    this.f3204m.add(d1Var);
                    d1Var.d().addListener(new p(this, d1Var), this.f3199h);
                } else {
                    d1Var.cancel();
                }
            } catch (MediaCodec.CodecException e10) {
                z(e10);
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: U */
    public void G(int i10, String str, Throwable th2) {
        k kVar;
        Executor executor;
        synchronized (this.f3193b) {
            kVar = this.f3209r;
            executor = this.f3210s;
        }
        try {
            executor.execute(new r(kVar, i10, str, th2));
        } catch (RejectedExecutionException e10) {
            v1.d(this.f3192a, "Unable to post to the supplied executor.", e10);
        }
    }

    /* access modifiers changed from: package-private */
    public void W() {
        Bundle bundle = new Bundle();
        bundle.putInt("request-sync", 0);
        this.f3196e.setParameters(bundle);
    }

    /* access modifiers changed from: package-private */
    public void Y(boolean z10) {
        Bundle bundle = new Bundle();
        bundle.putInt("drop-input-frames", z10 ? 1 : 0);
        this.f3196e.setParameters(bundle);
    }

    @NonNull
    public j.b a() {
        return this.f3197f;
    }

    /* access modifiers changed from: package-private */
    public void a0() {
        j.b bVar = this.f3197f;
        if (bVar instanceof d) {
            ((d) bVar).A(false);
            ArrayList arrayList = new ArrayList();
            for (b1 d10 : this.f3204m) {
                arrayList.add(d10.d());
            }
            u.f.n(arrayList).addListener(new s(this), this.f3199h);
        } else if (bVar instanceof f) {
            try {
                this.f3196e.signalEndOfInputStream();
            } catch (MediaCodec.CodecException e10) {
                z(e10);
            }
        }
    }

    public void b(@NonNull k kVar, @NonNull Executor executor) {
        synchronized (this.f3193b) {
            this.f3209r = kVar;
            this.f3210s = executor;
        }
    }

    public void c(long j10) {
        this.f3199h.execute(new o(this, j10, w()));
    }

    public void c0() {
        this.f3199h.execute(new a0(this));
    }

    public void d() {
        this.f3199h.execute(new w(this));
    }

    /* access modifiers changed from: package-private */
    public void d0(Runnable runnable) {
        ArrayList arrayList = new ArrayList();
        for (i b10 : this.f3205n) {
            arrayList.add(b10.b());
        }
        for (b1 d10 : this.f3204m) {
            arrayList.add(d10.d());
        }
        if (!arrayList.isEmpty()) {
            String str = this.f3192a;
            v1.a(str, "Waiting for resources to return. encoded data = " + this.f3205n.size() + ", input buffers = " + this.f3204m.size());
        }
        u.f.n(arrayList).addListener(new q(this, arrayList, runnable), this.f3199h);
    }

    /* access modifiers changed from: package-private */
    public void e0(long j10) {
        while (!this.f3206o.isEmpty()) {
            Range first = this.f3206o.getFirst();
            if (j10 > ((Long) first.getUpper()).longValue()) {
                this.f3206o.removeFirst();
                this.f3213v += ((Long) first.getUpper()).longValue() - ((Long) first.getLower()).longValue();
                v1.a(this.f3192a, "Total paused duration = " + d0.h.j(this.f3213v));
            } else {
                return;
            }
        }
    }

    public void pause() {
        this.f3199h.execute(new x(this, w()));
    }

    public void release() {
        this.f3199h.execute(new c0(this));
    }

    public void start() {
        this.f3199h.execute(new y(this, w()));
    }

    public void stop() {
        c(-1);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public zf.a<b1> u() {
        switch (b.f3230a[this.f3211t.ordinal()]) {
            case 1:
                return u.f.f(new IllegalStateException("Encoder is not started yet."));
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                AtomicReference atomicReference = new AtomicReference();
                zf.a<b1> a10 = CallbackToFutureAdapter.a(new n(atomicReference));
                CallbackToFutureAdapter.a aVar = (CallbackToFutureAdapter.a) h.g((CallbackToFutureAdapter.a) atomicReference.get());
                this.f3203l.offer(aVar);
                aVar.a(new u(this, aVar), this.f3199h);
                T();
                return a10;
            case 8:
                return u.f.f(new IllegalStateException("Encoder is in error state."));
            case 9:
                return u.f.f(new IllegalStateException("Encoder is released."));
            default:
                throw new IllegalStateException("Unknown state: " + this.f3211t);
        }
    }

    /* access modifiers changed from: package-private */
    public long w() {
        return this.f3208q.b();
    }

    /* access modifiers changed from: package-private */
    public long x(@NonNull MediaCodec.BufferInfo bufferInfo) {
        long j10 = this.f3213v;
        if (j10 > 0) {
            return bufferInfo.presentationTimeUs - j10;
        }
        return bufferInfo.presentationTimeUs;
    }

    /* access modifiers changed from: package-private */
    public void y(int i10, String str, Throwable th2) {
        switch (b.f3230a[this.f3211t.ordinal()]) {
            case 1:
                G(i10, str, th2);
                X();
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                Z(InternalState.ERROR);
                d0(new b0(this, i10, str, th2));
                return;
            case 8:
                String str2 = this.f3192a;
                v1.m(str2, "Get more than one error: " + str + "(" + i10 + ")", th2);
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: package-private */
    public void z(@NonNull MediaCodec.CodecException codecException) {
        y(1, codecException.getMessage(), codecException);
    }
}
