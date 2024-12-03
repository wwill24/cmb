package androidx.camera.video.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioRecordingConfiguration;
import android.media.AudioTimestamp;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.l1;
import androidx.camera.core.v1;
import androidx.camera.video.internal.BufferProvider;
import androidx.camera.video.internal.b;
import androidx.camera.video.internal.encoder.b1;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.h;
import d0.g;
import e0.i;
import e0.m;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public final class AudioSource {

    /* renamed from: q  reason: collision with root package name */
    public static final List<Integer> f3152q = Collections.unmodifiableList(Arrays.asList(new Integer[]{48000, 44100, 22050, 11025, 8000, 4800}));

    /* renamed from: a  reason: collision with root package name */
    final Executor f3153a;

    /* renamed from: b  reason: collision with root package name */
    private AudioManager.AudioRecordingCallback f3154b;

    /* renamed from: c  reason: collision with root package name */
    AtomicBoolean f3155c = new AtomicBoolean(false);

    /* renamed from: d  reason: collision with root package name */
    final AudioRecord f3156d;

    /* renamed from: e  reason: collision with root package name */
    final int f3157e;

    /* renamed from: f  reason: collision with root package name */
    final int f3158f;

    /* renamed from: g  reason: collision with root package name */
    final int f3159g;

    /* renamed from: h  reason: collision with root package name */
    long f3160h = 0;

    /* renamed from: i  reason: collision with root package name */
    InternalState f3161i = InternalState.CONFIGURED;

    /* renamed from: j  reason: collision with root package name */
    BufferProvider.State f3162j = BufferProvider.State.INACTIVE;

    /* renamed from: k  reason: collision with root package name */
    boolean f3163k;

    /* renamed from: l  reason: collision with root package name */
    Executor f3164l;

    /* renamed from: m  reason: collision with root package name */
    e f3165m;

    /* renamed from: n  reason: collision with root package name */
    BufferProvider<b1> f3166n;

    /* renamed from: o  reason: collision with root package name */
    private u.c<b1> f3167o;

    /* renamed from: p  reason: collision with root package name */
    private l1.a<BufferProvider.State> f3168p;

    enum InternalState {
        CONFIGURED,
        STARTED,
        RELEASED
    }

    class a implements l1.a<BufferProvider.State> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BufferProvider f3173a;

        a(BufferProvider bufferProvider) {
            this.f3173a = bufferProvider;
        }

        /* renamed from: b */
        public void a(BufferProvider.State state) {
            if (AudioSource.this.f3166n == this.f3173a) {
                v1.a("AudioSource", "Receive BufferProvider state change: " + AudioSource.this.f3162j + " to " + state);
                AudioSource audioSource = AudioSource.this;
                audioSource.f3162j = state;
                audioSource.H();
            }
        }

        public void onError(@NonNull Throwable th2) {
            AudioSource audioSource = AudioSource.this;
            if (audioSource.f3166n == this.f3173a) {
                audioSource.w(th2);
            }
        }
    }

    class b implements u.c<b1> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BufferProvider f3175a;

        b(BufferProvider bufferProvider) {
            this.f3175a = bufferProvider;
        }

        /* renamed from: a */
        public void onSuccess(b1 b1Var) {
            AudioSource audioSource = AudioSource.this;
            if (!audioSource.f3163k || audioSource.f3166n != this.f3175a) {
                b1Var.cancel();
                return;
            }
            ByteBuffer q10 = b1Var.q();
            AudioSource audioSource2 = AudioSource.this;
            int read = audioSource2.f3156d.read(q10, audioSource2.f3157e);
            if (read > 0) {
                q10.limit(read);
                b1Var.c(AudioSource.this.k());
                b1Var.b();
                AudioSource audioSource3 = AudioSource.this;
                audioSource3.f3160h += (long) (read / audioSource3.f3159g);
            } else {
                v1.l("AudioSource", "Unable to read data from AudioRecord.");
                b1Var.cancel();
            }
            AudioSource.this.z();
        }

        public void onFailure(@NonNull Throwable th2) {
            if (AudioSource.this.f3166n != this.f3175a) {
                v1.a("AudioSource", "Unable to get input buffer, the BufferProvider could be transitioning to INACTIVE state.");
                AudioSource.this.w(th2);
            }
        }
    }

    static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3177a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                androidx.camera.video.internal.AudioSource$InternalState[] r0 = androidx.camera.video.internal.AudioSource.InternalState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3177a = r0
                androidx.camera.video.internal.AudioSource$InternalState r1 = androidx.camera.video.internal.AudioSource.InternalState.CONFIGURED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f3177a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.camera.video.internal.AudioSource$InternalState r1 = androidx.camera.video.internal.AudioSource.InternalState.STARTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f3177a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.camera.video.internal.AudioSource$InternalState r1 = androidx.camera.video.internal.AudioSource.InternalState.RELEASED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.internal.AudioSource.c.<clinit>():void");
        }
    }

    class d extends AudioManager.AudioRecordingCallback {
        d() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(boolean z10) {
            AudioSource.this.f3165m.a(z10);
        }

        public void onRecordingConfigChanged(List<AudioRecordingConfiguration> list) {
            super.onRecordingConfigChanged(list);
            AudioSource audioSource = AudioSource.this;
            if (audioSource.f3164l != null && audioSource.f3165m != null) {
                for (AudioRecordingConfiguration next : list) {
                    if (e0.b.a(next) == AudioSource.this.f3156d.getAudioSessionId()) {
                        boolean a10 = i.a(next);
                        if (AudioSource.this.f3155c.getAndSet(a10) != a10) {
                            AudioSource.this.f3164l.execute(new a(this, a10));
                            return;
                        }
                        return;
                    }
                }
            }
        }
    }

    public interface e {
        void a(boolean z10);

        void onError(@NonNull Throwable th2);
    }

    public static abstract class f {

        public static abstract class a {
            a() {
            }

            /* access modifiers changed from: package-private */
            public abstract f a();

            @NonNull
            public final f b() {
                f a10 = a();
                String str = "";
                if (a10.c() == -1) {
                    str = str + " audioSource";
                }
                if (a10.e() <= 0) {
                    str = str + " sampleRate";
                }
                if (a10.d() <= 0) {
                    str = str + " channelCount";
                }
                if (a10.b() == -1) {
                    str = str + " audioFormat";
                }
                if (str.isEmpty()) {
                    return a10;
                }
                throw new IllegalArgumentException("Required settings missing or non-positive:" + str);
            }

            @NonNull
            public abstract a c(int i10);

            @NonNull
            public abstract a d(int i10);

            @NonNull
            public abstract a e(int i10);

            @NonNull
            public abstract a f(int i10);
        }

        f() {
        }

        @SuppressLint({"Range"})
        @NonNull
        public static a a() {
            return new b.C0022b().d(-1).f(-1).e(-1).c(-1);
        }

        public abstract int b();

        public abstract int c();

        public abstract int d();

        public abstract int e();
    }

    public AudioSource(@NonNull f fVar, @NonNull Executor executor, Context context) throws AudioSourceAccessException {
        boolean z10 = false;
        if (o(fVar.e(), fVar.d(), fVar.b())) {
            int m10 = m(fVar.e(), fVar.d(), fVar.b());
            h.i(m10 > 0 ? true : z10);
            Executor f10 = androidx.camera.core.impl.utils.executor.a.f(executor);
            this.f3153a = f10;
            int i10 = m10 * 2;
            this.f3157e = i10;
            this.f3158f = fVar.e();
            try {
                this.f3159g = l(fVar.b(), fVar.d());
                int i11 = Build.VERSION.SDK_INT;
                AudioFormat build = new AudioFormat.Builder().setSampleRate(fVar.e()).setChannelMask(i(fVar.d())).setEncoding(fVar.b()).build();
                AudioRecord.Builder b10 = e0.a.b();
                if (i11 >= 31 && context != null) {
                    m.c(b10, context);
                }
                e0.a.d(b10, fVar.c());
                e0.a.c(b10, build);
                e0.a.e(b10, i10);
                AudioRecord a10 = e0.a.a(b10);
                this.f3156d = a10;
                if (a10.getState() != 1) {
                    a10.release();
                    throw new AudioSourceAccessException("Unable to initialize AudioRecord");
                } else if (i11 >= 29) {
                    d dVar = new d();
                    this.f3154b = dVar;
                    i.b(a10, f10, dVar);
                }
            } catch (IllegalArgumentException e10) {
                throw new AudioSourceAccessException("Unable to create AudioRecord", e10);
            }
        } else {
            throw new UnsupportedOperationException(String.format("The combination of sample rate %d, channel count %d and audio format %d is not supported.", new Object[]{Integer.valueOf(fVar.e()), Integer.valueOf(fVar.d()), Integer.valueOf(fVar.b())}));
        }
    }

    private void E() {
        if (!this.f3163k) {
            try {
                v1.a("AudioSource", "startSendingAudio");
                this.f3156d.startRecording();
                if (this.f3156d.getRecordingState() == 3) {
                    this.f3160h = 0;
                    this.f3163k = true;
                    z();
                    return;
                }
                throw new IllegalStateException("Unable to start AudioRecord with state: " + this.f3156d.getRecordingState());
            } catch (IllegalStateException e10) {
                v1.m("AudioSource", "Failed to start AudioRecord", e10);
                C(InternalState.CONFIGURED);
                w(new AudioSourceAccessException("Unable to start the audio record.", e10));
            }
        }
    }

    private void G() {
        if (this.f3163k) {
            this.f3163k = false;
            try {
                v1.a("AudioSource", "stopSendingAudio");
                this.f3156d.stop();
                if (this.f3156d.getRecordingState() != 1) {
                    throw new IllegalStateException("Unable to stop AudioRecord with state: " + this.f3156d.getRecordingState());
                }
            } catch (IllegalStateException e10) {
                v1.m("AudioSource", "Failed to stop AudioRecord", e10);
                w(e10);
            }
        }
    }

    private static int h(int i10) {
        return i10 == 1 ? 16 : 12;
    }

    private static int i(int i10) {
        return i10 == 1 ? 16 : 12;
    }

    private static long j(int i10, long j10, @NonNull AudioTimestamp audioTimestamp) {
        long nanos = audioTimestamp.nanoTime + ((TimeUnit.SECONDS.toNanos(1) * (j10 - audioTimestamp.framePosition)) / ((long) i10));
        if (nanos < 0) {
            return 0;
        }
        return TimeUnit.NANOSECONDS.toMicros(nanos);
    }

    private static int l(int i10, int i11) {
        boolean z10;
        if (i11 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        h.i(z10);
        if (i10 == 2) {
            return i11 * 2;
        }
        if (i10 == 3) {
            return i11;
        }
        if (i10 != 4) {
            if (i10 == 21) {
                return i11 * 3;
            }
            if (i10 != 22) {
                throw new IllegalArgumentException("Invalid audio format: " + i10);
            }
        }
        return i11 * 4;
    }

    private static int m(int i10, int i11, int i12) {
        return AudioRecord.getMinBufferSize(i10, h(i11), i12);
    }

    private static boolean n() {
        return f0.e.a(f0.b.class) != null;
    }

    public static boolean o(int i10, int i11, int i12) {
        return i10 > 0 && i11 > 0 && m(i10, i11, i12) > 0;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p(Throwable th2) {
        this.f3165m.onError(th2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q(CallbackToFutureAdapter.a aVar) {
        try {
            int i10 = c.f3177a[this.f3161i.ordinal()];
            if (i10 == 1 || i10 == 2) {
                y((BufferProvider<b1>) null);
                if (Build.VERSION.SDK_INT >= 29) {
                    i.c(this.f3156d, this.f3154b);
                }
                this.f3156d.release();
                G();
                C(InternalState.RELEASED);
            }
            aVar.c(null);
        } catch (Throwable th2) {
            aVar.f(th2);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object r(CallbackToFutureAdapter.a aVar) throws Exception {
        this.f3153a.execute(new g(this, aVar));
        return "AudioSource-release";
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void s(Executor executor, e eVar) {
        int i10 = c.f3177a[this.f3161i.ordinal()];
        if (i10 == 1) {
            this.f3164l = executor;
            this.f3165m = eVar;
        } else if (i10 == 2 || i10 == 3) {
            throw new AssertionError("The audio recording callback must be registered before the audio source is started.");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t(BufferProvider bufferProvider) {
        int i10 = c.f3177a[this.f3161i.ordinal()];
        if (i10 == 1 || i10 == 2) {
            if (this.f3166n != bufferProvider) {
                y(bufferProvider);
            }
        } else if (i10 == 3) {
            throw new AssertionError("AudioRecorder is released");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void u() {
        int i10 = c.f3177a[this.f3161i.ordinal()];
        if (i10 == 1) {
            C(InternalState.STARTED);
            H();
        } else if (i10 == 3) {
            throw new AssertionError("AudioRecorder is released");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void v() {
        int i10 = c.f3177a[this.f3161i.ordinal()];
        if (i10 == 2) {
            C(InternalState.CONFIGURED);
            H();
        } else if (i10 == 3) {
            v1.l("AudioSource", "AudioRecorder is released. Calling stop() is a no-op.");
        }
    }

    private void y(BufferProvider<b1> bufferProvider) {
        BufferProvider<b1> bufferProvider2 = this.f3166n;
        if (bufferProvider2 != null) {
            bufferProvider2.d(this.f3168p);
            this.f3166n = null;
            this.f3168p = null;
            this.f3167o = null;
        }
        this.f3162j = BufferProvider.State.INACTIVE;
        H();
        if (bufferProvider != null) {
            this.f3166n = bufferProvider;
            this.f3168p = new a(bufferProvider);
            this.f3167o = new b(bufferProvider);
            this.f3166n.c(this.f3153a, this.f3168p);
        }
    }

    public void A(@NonNull Executor executor, @NonNull e eVar) {
        this.f3153a.execute(new d0.e(this, executor, eVar));
    }

    public void B(@NonNull BufferProvider<b1> bufferProvider) {
        this.f3153a.execute(new d0.b(this, bufferProvider));
    }

    /* access modifiers changed from: package-private */
    public void C(InternalState internalState) {
        v1.a("AudioSource", "Transitioning internal state: " + this.f3161i + " --> " + internalState);
        this.f3161i = internalState;
    }

    public void D() {
        this.f3153a.execute(new d0.a(this));
    }

    public void F() {
        this.f3153a.execute(new d0.d(this));
    }

    /* access modifiers changed from: package-private */
    public void H() {
        if (this.f3161i == InternalState.STARTED && this.f3162j == BufferProvider.State.ACTIVE) {
            E();
        } else {
            G();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long k() {
        /*
            r6 = this;
            boolean r0 = n()
            r1 = -1
            if (r0 != 0) goto L_0x0026
            android.media.AudioTimestamp r0 = new android.media.AudioTimestamp
            r0.<init>()
            android.media.AudioRecord r3 = r6.f3156d
            r4 = 0
            int r3 = e0.b.b(r3, r0, r4)
            if (r3 != 0) goto L_0x001f
            int r3 = r6.f3158f
            long r4 = r6.f3160h
            long r3 = j(r3, r4, r0)
            goto L_0x0027
        L_0x001f:
            java.lang.String r0 = "AudioSource"
            java.lang.String r3 = "Unable to get audio timestamp"
            androidx.camera.core.v1.l(r0, r3)
        L_0x0026:
            r3 = r1
        L_0x0027:
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0035
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r1 = java.lang.System.nanoTime()
            long r3 = r0.toMicros(r1)
        L_0x0035:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.internal.AudioSource.k():long");
    }

    /* access modifiers changed from: package-private */
    public void w(Throwable th2) {
        Executor executor = this.f3164l;
        if (executor != null && this.f3165m != null) {
            executor.execute(new d0.f(this, th2));
        }
    }

    @NonNull
    public zf.a<Void> x() {
        return CallbackToFutureAdapter.a(new d0.c(this));
    }

    /* access modifiers changed from: package-private */
    public void z() {
        u.f.b(this.f3166n.e(), this.f3167o, this.f3153a);
    }
}
