package com.withpersona.sdk2.camera;

import android.content.Context;
import androidx.camera.video.Recorder;
import androidx.camera.video.d0;
import androidx.camera.video.i0;
import androidx.camera.video.p;
import androidx.core.content.g;
import b0.c;
import com.mparticle.identity.IdentityHttpResponse;
import java.io.File;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.s;

public final class RecordingHelper {

    /* renamed from: f  reason: collision with root package name */
    public static final a f14179f = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final Context f14180a;

    /* renamed from: b  reason: collision with root package name */
    private final Recorder f14181b;

    /* renamed from: c  reason: collision with root package name */
    private final Executor f14182c;

    /* renamed from: d  reason: collision with root package name */
    private final i<RecordingState> f14183d = s.a(RecordingState.NotStarted);

    /* renamed from: e  reason: collision with root package name */
    private b f14184e;

    public enum RecordingState {
        NotStarted,
        Started,
        Finalized
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RecordingHelper a(Recorder recorder, Context context) {
            j.g(recorder, "<this>");
            j.g(context, IdentityHttpResponse.CONTEXT);
            RecordingHelper recordingHelper = new RecordingHelper(context, recorder);
            recordingHelper.c();
            return recordingHelper;
        }
    }

    private static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final d0 f14189a;

        /* renamed from: b  reason: collision with root package name */
        private final File f14190b;

        /* renamed from: c  reason: collision with root package name */
        private Throwable f14191c;

        public b(d0 d0Var, File file) {
            j.g(d0Var, "recording");
            j.g(file, "outputFile");
            this.f14189a = d0Var;
            this.f14190b = file;
        }

        public final void a() {
            this.f14189a.close();
        }

        public final Throwable b() {
            return this.f14191c;
        }

        public final File c() {
            return this.f14190b;
        }

        public final void d(Throwable th2) {
            this.f14191c = th2;
        }

        public final void e() {
            this.f14189a.f();
        }
    }

    public RecordingHelper(Context context, Recorder recorder) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(recorder, "recorder");
        this.f14180a = context;
        this.f14181b = recorder;
        Executor mainExecutor = androidx.core.content.a.getMainExecutor(context);
        j.f(mainExecutor, "getMainExecutor(context)");
        this.f14182c = mainExecutor;
    }

    /* access modifiers changed from: private */
    public final void c() {
        boolean z10;
        File cacheDir = this.f14180a.getCacheDir();
        File file = new File(cacheDir, "persona_video_capture_" + System.currentTimeMillis() + ".mp4");
        if (g.b(this.f14180a, "android.permission.RECORD_AUDIO") == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        p g02 = this.f14181b.g0(this.f14180a, new c.a(file).a());
        if (z10) {
            g02.h();
        }
        j.f(g02, "recorder\n      .prepareR…abled()\n        }\n      }");
        d0 g10 = g02.g(this.f14182c, new u(this));
        j.f(g10, "pendingRecording.start(\n…  recordingListener\n    )");
        this.f14184e = new b(g10, file);
    }

    /* access modifiers changed from: private */
    public static final void d(RecordingHelper recordingHelper, i0 i0Var) {
        File c10;
        j.g(recordingHelper, "this$0");
        b bVar = recordingHelper.f14184e;
        if (i0Var instanceof i0.c) {
            recordingHelper.f14183d.setValue(RecordingState.Started);
        } else if (i0Var instanceof i0.a) {
            i0.a aVar = (i0.a) i0Var;
            if (aVar.j()) {
                if (bVar != null) {
                    bVar.d(new FinalizeRecordingError("Recording completed with error code " + aVar.i(), aVar.h()));
                }
                if (!(bVar == null || (c10 = bVar.c()) == null)) {
                    c10.delete();
                }
            }
            recordingHelper.f14183d.setValue(RecordingState.Finalized);
            if (bVar != null) {
                bVar.a();
            }
            recordingHelper.f14184e = null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object e(kotlin.coroutines.c<? super kotlin.Result<? extends java.io.File>> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.withpersona.sdk2.camera.RecordingHelper$stop$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.withpersona.sdk2.camera.RecordingHelper$stop$1 r0 = (com.withpersona.sdk2.camera.RecordingHelper$stop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.withpersona.sdk2.camera.RecordingHelper$stop$1 r0 = new com.withpersona.sdk2.camera.RecordingHelper$stop$1
            r0.<init>(r7, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r1 = r0.L$1
            java.io.File r1 = (java.io.File) r1
            java.lang.Object r0 = r0.L$0
            com.withpersona.sdk2.camera.RecordingHelper$b r0 = (com.withpersona.sdk2.camera.RecordingHelper.b) r0
            gk.g.b(r8)
            goto L_0x0072
        L_0x0031:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0039:
            gk.g.b(r8)
            com.withpersona.sdk2.camera.RecordingHelper$b r8 = r7.f14184e
            if (r8 != 0) goto L_0x0050
            kotlin.Result$a r8 = kotlin.Result.f32010a
            com.withpersona.sdk2.camera.NoActiveRecordingError r8 = new com.withpersona.sdk2.camera.NoActiveRecordingError
            r8.<init>()
            java.lang.Object r8 = gk.g.a(r8)
            java.lang.Object r8 = kotlin.Result.b(r8)
            return r8
        L_0x0050:
            java.io.File r2 = r8.c()
            r8.e()
            kotlinx.coroutines.flow.i<com.withpersona.sdk2.camera.RecordingHelper$RecordingState> r4 = r7.f14183d
            com.withpersona.sdk2.camera.RecordingHelper$stop$2 r5 = new com.withpersona.sdk2.camera.RecordingHelper$stop$2
            r6 = 0
            r5.<init>(r6)
            kotlinx.coroutines.flow.b r4 = kotlinx.coroutines.flow.d.H(r4, r5)
            r0.L$0 = r8
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r0 = kotlinx.coroutines.flow.d.g(r4, r0)
            if (r0 != r1) goto L_0x0070
            return r1
        L_0x0070:
            r0 = r8
            r1 = r2
        L_0x0072:
            java.lang.Throwable r8 = r0.b()
            if (r8 == 0) goto L_0x0083
            kotlin.Result$a r0 = kotlin.Result.f32010a
            java.lang.Object r8 = gk.g.a(r8)
            java.lang.Object r8 = kotlin.Result.b(r8)
            goto L_0x0087
        L_0x0083:
            java.lang.Object r8 = kotlin.Result.b(r1)
        L_0x0087:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.camera.RecordingHelper.e(kotlin.coroutines.c):java.lang.Object");
    }
}
