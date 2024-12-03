package com.withpersona.sdk2.camera.camera2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.media.Image;
import android.media.ImageReader;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Size;
import android.view.SurfaceHolder;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.mparticle.identity.IdentityHttpResponse;
import gk.g;
import java.io.File;
import java.util.concurrent.CancellationException;
import kotlin.KotlinNothingValueException;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.h;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.m;
import kotlinx.coroutines.flow.r;
import kotlinx.coroutines.flow.s;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;
import kotlinx.coroutines.o2;
import kotlinx.coroutines.s1;
import kotlinx.coroutines.x0;
import org.apache.commons.beanutils.PropertyUtils;

public final class Camera2Manager {
    public static final a B = new a((DefaultConstructorMarker) null);
    private ConditionVariable A;

    /* renamed from: a  reason: collision with root package name */
    private final Context f14262a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final f f14263b;

    /* renamed from: c  reason: collision with root package name */
    private final Camera2PreviewView f14264c;

    /* renamed from: d  reason: collision with root package name */
    private final a f14265d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final k0 f14266e;

    /* renamed from: f  reason: collision with root package name */
    private final String f14267f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final CameraManager f14268g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final CameraCharacteristics f14269h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final int f14270i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final MediaRecorderWrapper f14271j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public CameraDevice f14272k;

    /* renamed from: l  reason: collision with root package name */
    private final HandlerThread f14273l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public final Handler f14274m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public CameraCaptureSessionWrapper f14275n;

    /* renamed from: o  reason: collision with root package name */
    private volatile boolean f14276o;

    /* renamed from: p  reason: collision with root package name */
    private volatile boolean f14277p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public volatile boolean f14278q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public volatile boolean f14279r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public final i<Result<File>> f14280s;

    /* renamed from: t  reason: collision with root package name */
    private final i<b> f14281t;

    /* renamed from: u  reason: collision with root package name */
    private final r<b> f14282u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f14283v;

    /* renamed from: w  reason: collision with root package name */
    private SurfaceHolder.Callback f14284w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public float f14285x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public ImageReader f14286y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public h<Image> f14287z;

    @d(c = "com.withpersona.sdk2.camera.camera2.Camera2Manager$1", f = "Camera2Manager.kt", l = {131}, m = "invokeSuspend")
    /* renamed from: com.withpersona.sdk2.camera.camera2.Camera2Manager$1  reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, kotlin.coroutines.c<? super Unit>, Object> {
        int label;
        final /* synthetic */ Camera2Manager this$0;

        /* renamed from: com.withpersona.sdk2.camera.camera2.Camera2Manager$1$a */
        static final class a<T> implements kotlinx.coroutines.flow.c {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Camera2Manager f14288a;

            a(Camera2Manager camera2Manager) {
                this.f14288a = camera2Manager;
            }

            /* renamed from: a */
            public final Object c(Image image, kotlin.coroutines.c<? super Unit> cVar) {
                this.f14288a.H(image);
                return Unit.f32013a;
            }
        }

        {
            this.this$0 = r1;
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new AnonymousClass1(this.this$0, cVar);
        }

        public final Object invoke(k0 k0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((AnonymousClass1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d10 = b.d();
            int i10 = this.label;
            if (i10 == 0) {
                g.b(obj);
                h i11 = this.this$0.f14287z;
                a aVar = new a(this.this$0);
                this.label = 1;
                if (i11.a(aVar, this) == d10) {
                    return d10;
                }
            } else if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                g.b(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    public static abstract class Error extends Exception {

        public static final class InitializationError extends Error {
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public InitializationError(String str, Throwable th2) {
                super(str, th2, (DefaultConstructorMarker) null);
                j.g(str, "message");
                j.g(th2, "cause");
            }
        }

        public static final class MissingPermissionsCameraError extends Error {
            public MissingPermissionsCameraError() {
                super((DefaultConstructorMarker) null);
            }
        }

        private Error() {
        }

        public /* synthetic */ Error(String str, Throwable th2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, th2);
        }

        public /* synthetic */ Error(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Error(String str, Throwable th2) {
            super(str, th2);
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public interface b {

        public static final class a implements b {

            /* renamed from: a  reason: collision with root package name */
            public static final a f14289a = new a();

            private a() {
            }
        }

        /* renamed from: com.withpersona.sdk2.camera.camera2.Camera2Manager$b$b  reason: collision with other inner class name */
        public static final class C0151b implements b {

            /* renamed from: a  reason: collision with root package name */
            public static final C0151b f14290a = new C0151b();

            private C0151b() {
            }
        }

        public static final class c implements b {

            /* renamed from: a  reason: collision with root package name */
            private final Error f14291a;

            public c(Error error) {
                j.g(error, "error");
                this.f14291a = error;
            }

            public final Error a() {
                return this.f14291a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof c) && j.b(this.f14291a, ((c) obj).f14291a);
            }

            public int hashCode() {
                return this.f14291a.hashCode();
            }

            public String toString() {
                return "Error(error=" + this.f14291a + PropertyUtils.MAPPED_DELIM2;
            }
        }

        public static final class d implements b {

            /* renamed from: a  reason: collision with root package name */
            public static final d f14292a = new d();

            private d() {
            }
        }
    }

    public static final class c extends CameraDevice.StateCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n<CameraDevice> f14293a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Camera2Manager f14294b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f14295c;

        c(n<? super CameraDevice> nVar, Camera2Manager camera2Manager, String str) {
            this.f14293a = nVar;
            this.f14294b = camera2Manager;
            this.f14295c = str;
        }

        public void onDisconnected(CameraDevice cameraDevice) {
            j.g(cameraDevice, DeviceRequestsHelper.DEVICE_INFO_DEVICE);
            this.f14294b.f14272k = null;
        }

        public void onError(CameraDevice cameraDevice, int i10) {
            String str;
            j.g(cameraDevice, DeviceRequestsHelper.DEVICE_INFO_DEVICE);
            if (i10 == 1) {
                str = "Camera in use";
            } else if (i10 == 2) {
                str = "Maximum cameras in use";
            } else if (i10 == 3) {
                str = "Device policy";
            } else if (i10 == 4) {
                str = "Fatal (device)";
            } else if (i10 != 5) {
                str = "Unknown";
            } else {
                str = "Fatal (service)";
            }
            RuntimeException runtimeException = new RuntimeException("Camera " + this.f14295c + " error: (" + i10 + ") " + str);
            if (this.f14293a.a()) {
                n<CameraDevice> nVar = this.f14293a;
                Result.a aVar = Result.f32010a;
                nVar.resumeWith(Result.b(g.a(runtimeException)));
            }
        }

        public void onOpened(CameraDevice cameraDevice) {
            j.g(cameraDevice, DeviceRequestsHelper.DEVICE_INFO_DEVICE);
            this.f14293a.resumeWith(Result.b(cameraDevice));
        }
    }

    public Camera2Manager(Context context, f fVar, Camera2PreviewView camera2PreviewView, a aVar) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(fVar, "cameraChoice");
        j.g(camera2PreviewView, "previewView");
        j.g(aVar, "analyzer");
        this.f14262a = context;
        this.f14263b = fVar;
        this.f14264c = camera2PreviewView;
        this.f14265d = aVar;
        k0 a10 = l0.a(x0.a().e0(o2.b((s1) null, 1, (Object) null)));
        this.f14266e = a10;
        String b10 = fVar.b();
        this.f14267f = b10;
        Object systemService = context.getSystemService("camera");
        j.e(systemService, "null cannot be cast to non-null type android.hardware.camera2.CameraManager");
        CameraManager cameraManager = (CameraManager) systemService;
        this.f14268g = cameraManager;
        CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(b10);
        j.f(cameraCharacteristics, "cameraManager.getCameraCharacteristics(cameraId)");
        this.f14269h = cameraCharacteristics;
        Object obj = cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION);
        if (obj != null) {
            int intValue = ((Number) obj).intValue();
            this.f14270i = intValue;
            Integer upper = fVar.d().getUpper();
            j.f(upper, "cameraChoice.targetFpsRange.upper");
            this.f14271j = new MediaRecorderWrapper(context, fVar, upper.intValue(), intValue);
            HandlerThread handlerThread = new HandlerThread("CameraThread");
            handlerThread.start();
            this.f14273l = handlerThread;
            this.f14274m = new Handler(handlerThread.getLooper());
            this.f14277p = true;
            this.f14280s = s.a(null);
            i<b> a11 = s.a(b.a.f14289a);
            this.f14281t = a11;
            this.f14282u = a11;
            this.f14285x = 1.0f;
            this.f14286y = E();
            this.f14287z = m.b(0, 1, BufferOverflow.SUSPEND, 1, (Object) null);
            this.A = new ConditionVariable();
            s1 unused = j.d(a10, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this, (kotlin.coroutines.c<? super AnonymousClass1>) null), 3, (Object) null);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final Object D(kotlin.coroutines.c<? super Unit> cVar) {
        Object g10 = kotlinx.coroutines.h.g(x0.c(), new Camera2Manager$initializeCamera$2(this, (kotlin.coroutines.c<? super Camera2Manager$initializeCamera$2>) null), cVar);
        return g10 == b.d() ? g10 : Unit.f32013a;
    }

    /* access modifiers changed from: private */
    public final ImageReader E() {
        ImageReader newInstance = ImageReader.newInstance((int) (((float) this.f14263b.c().getWidth()) * this.f14285x), (int) (((float) this.f14263b.c().getHeight()) * this.f14285x), 35, 3);
        newInstance.setOnImageAvailableListener(new b(this), this.f14274m);
        j.f(newInstance, "newInstance(\n      /* wi…  }, cameraHandler)\n    }");
        return newInstance;
    }

    /* access modifiers changed from: private */
    public static final void F(Camera2Manager camera2Manager, ImageReader imageReader) {
        j.g(camera2Manager, "this$0");
        Image acquireNextImage = imageReader.acquireNextImage();
        h<Image> hVar = camera2Manager.f14287z;
        j.f(acquireNextImage, "image");
        if (!hVar.e(acquireNextImage)) {
            acquireNextImage.close();
        }
    }

    /* access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    public final Object G(CameraManager cameraManager, String str, Handler handler, kotlin.coroutines.c<? super CameraDevice> cVar) {
        o oVar = new o(IntrinsicsKt__IntrinsicsJvmKt.c(cVar), 1);
        oVar.y();
        cameraManager.openCamera(str, new c(oVar, this, str), handler);
        Object v10 = oVar.v();
        if (v10 == b.d()) {
            f.c(cVar);
        }
        return v10;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0054, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0055, code lost:
        nk.a.a(r4, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0058, code lost:
        throw r1;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x004c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void H(android.media.Image r4) {
        /*
            r3 = this;
            kotlinx.coroutines.flow.i<com.withpersona.sdk2.camera.camera2.Camera2Manager$b> r0 = r3.f14281t     // Catch:{ all -> 0x0052 }
            java.lang.Object r0 = r0.getValue()     // Catch:{ all -> 0x0052 }
            com.withpersona.sdk2.camera.camera2.Camera2Manager$b$b r1 = com.withpersona.sdk2.camera.camera2.Camera2Manager.b.C0151b.f14290a     // Catch:{ all -> 0x0052 }
            boolean r0 = kotlin.jvm.internal.j.b(r0, r1)     // Catch:{ all -> 0x0052 }
            r1 = 0
            if (r0 == 0) goto L_0x0018
            android.os.ConditionVariable r0 = r3.A     // Catch:{ all -> 0x0052 }
            r0.open()     // Catch:{ all -> 0x0052 }
            nk.a.a(r4, r1)
            return
        L_0x0018:
            boolean r0 = r3.f14277p     // Catch:{ all -> 0x0052 }
            if (r0 != 0) goto L_0x0023
            boolean r0 = r3.f14278q     // Catch:{ all -> 0x0052 }
            if (r0 == 0) goto L_0x0021
            goto L_0x0023
        L_0x0021:
            r0 = 0
            goto L_0x0024
        L_0x0023:
            r0 = 1
        L_0x0024:
            if (r0 != 0) goto L_0x002a
            nk.a.a(r4, r1)
            return
        L_0x002a:
            boolean r0 = r3.f14278q     // Catch:{ all -> 0x0052 }
            if (r0 == 0) goto L_0x0041
            java.io.File r0 = r3.J(r4)     // Catch:{ all -> 0x0052 }
            if (r0 == 0) goto L_0x0041
            kotlinx.coroutines.flow.i<kotlin.Result<java.io.File>> r2 = r3.f14280s     // Catch:{ all -> 0x0052 }
            java.lang.Object r0 = kotlin.Result.b(r0)     // Catch:{ all -> 0x0052 }
            kotlin.Result r0 = kotlin.Result.a(r0)     // Catch:{ all -> 0x0052 }
            r2.setValue(r0)     // Catch:{ all -> 0x0052 }
        L_0x0041:
            boolean r0 = r3.f14277p     // Catch:{ all -> 0x0052 }
            if (r0 == 0) goto L_0x004c
            com.withpersona.sdk2.camera.camera2.a r0 = r3.f14265d     // Catch:{ Exception -> 0x004c }
            int r2 = r3.f14270i     // Catch:{ Exception -> 0x004c }
            r0.g(r4, r2)     // Catch:{ Exception -> 0x004c }
        L_0x004c:
            kotlin.Unit r0 = kotlin.Unit.f32013a     // Catch:{ all -> 0x0052 }
            nk.a.a(r4, r1)
            return
        L_0x0052:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0054 }
        L_0x0054:
            r1 = move-exception
            nk.a.a(r4, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.camera.camera2.Camera2Manager.H(android.media.Image):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0044, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0045, code lost:
        kotlin.io.b.a(r2, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0048, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.io.File J(android.media.Image r7) {
        /*
            r6 = this;
            int r0 = r6.f14270i
            android.graphics.Bitmap r7 = com.withpersona.sdk2.camera.ImageToAnalyzeKt.c(r7, r0)
            r0 = 0
            if (r7 != 0) goto L_0x000a
            return r0
        L_0x000a:
            java.io.File r1 = new java.io.File
            android.content.Context r2 = r6.f14262a
            java.io.File r2 = r2.getCacheDir()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "persona_camera_"
            r3.append(r4)
            long r4 = java.lang.System.currentTimeMillis()
            r3.append(r4)
            java.lang.String r4 = ".jpg"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r1.<init>(r2, r3)
            java.io.FileOutputStream r2 = new java.io.FileOutputStream
            r2.<init>(r1)
            android.graphics.Bitmap$CompressFormat r3 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ all -> 0x0042 }
            r4 = 80
            r7.compress(r3, r4, r2)     // Catch:{ all -> 0x0042 }
            kotlin.io.b.a(r2, r0)
            r7.recycle()
            return r1
        L_0x0042:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x0044 }
        L_0x0044:
            r0 = move-exception
            kotlin.io.b.a(r2, r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.camera.camera2.Camera2Manager.J(android.media.Image):java.io.File");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object M(com.withpersona.sdk2.camera.camera2.Camera2Manager r4, kotlin.coroutines.c<? super kotlin.Unit> r5) {
        /*
            boolean r0 = r5 instanceof com.withpersona.sdk2.camera.camera2.Camera2Manager$start$initializeCameraAndSetState$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.withpersona.sdk2.camera.camera2.Camera2Manager$start$initializeCameraAndSetState$1 r0 = (com.withpersona.sdk2.camera.camera2.Camera2Manager$start$initializeCameraAndSetState$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.withpersona.sdk2.camera.camera2.Camera2Manager$start$initializeCameraAndSetState$1 r0 = new com.withpersona.sdk2.camera.camera2.Camera2Manager$start$initializeCameraAndSetState$1
            r0.<init>(r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r4 = r0.L$0
            com.withpersona.sdk2.camera.camera2.Camera2Manager r4 = (com.withpersona.sdk2.camera.camera2.Camera2Manager) r4
            gk.g.b(r5)     // Catch:{ Exception -> 0x004b }
            goto L_0x0043
        L_0x002d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0035:
            gk.g.b(r5)
            r0.L$0 = r4     // Catch:{ Exception -> 0x004b }
            r0.label = r3     // Catch:{ Exception -> 0x004b }
            java.lang.Object r5 = r4.D(r0)     // Catch:{ Exception -> 0x004b }
            if (r5 != r1) goto L_0x0043
            return r1
        L_0x0043:
            kotlinx.coroutines.flow.i<com.withpersona.sdk2.camera.camera2.Camera2Manager$b> r5 = r4.f14281t     // Catch:{ Exception -> 0x004b }
            com.withpersona.sdk2.camera.camera2.Camera2Manager$b$d r0 = com.withpersona.sdk2.camera.camera2.Camera2Manager.b.d.f14292a     // Catch:{ Exception -> 0x004b }
            r5.setValue(r0)     // Catch:{ Exception -> 0x004b }
            goto L_0x005d
        L_0x004b:
            r5 = move-exception
            kotlinx.coroutines.flow.i<com.withpersona.sdk2.camera.camera2.Camera2Manager$b> r4 = r4.f14281t
            com.withpersona.sdk2.camera.camera2.Camera2Manager$b$c r0 = new com.withpersona.sdk2.camera.camera2.Camera2Manager$b$c
            com.withpersona.sdk2.camera.camera2.Camera2Manager$Error$InitializationError r1 = new com.withpersona.sdk2.camera.camera2.Camera2Manager$Error$InitializationError
            java.lang.String r2 = "Unable to initialize Camera2 classes"
            r1.<init>(r2, r5)
            r0.<init>(r1)
            r4.setValue(r0)
        L_0x005d:
            kotlin.Unit r4 = kotlin.Unit.f32013a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.camera.camera2.Camera2Manager.M(com.withpersona.sdk2.camera.camera2.Camera2Manager, kotlin.coroutines.c):java.lang.Object");
    }

    public final void A() {
        CameraCaptureSessionWrapper cameraCaptureSessionWrapper = this.f14275n;
        if (cameraCaptureSessionWrapper != null) {
            Size size = new Size((int) (((double) this.f14263b.c().getWidth()) * 0.15d), (int) (((double) this.f14263b.c().getHeight()) * 0.15d));
            cameraCaptureSessionWrapper.j(this.f14263b.c().getWidth() / 2, this.f14263b.c().getHeight() / 2, size, 5000);
            cameraCaptureSessionWrapper.l();
        }
    }

    public final Camera2PreviewView B() {
        return this.f14264c;
    }

    public final r<b> C() {
        return this.f14282u;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object I(kotlin.coroutines.c<? super kotlin.Result<? extends java.io.File>> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.withpersona.sdk2.camera.camera2.Camera2Manager$requestImageCapture$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.withpersona.sdk2.camera.camera2.Camera2Manager$requestImageCapture$1 r0 = (com.withpersona.sdk2.camera.camera2.Camera2Manager$requestImageCapture$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.withpersona.sdk2.camera.camera2.Camera2Manager$requestImageCapture$1 r0 = new com.withpersona.sdk2.camera.camera2.Camera2Manager$requestImageCapture$1
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            gk.g.b(r6)
            goto L_0x0047
        L_0x0029:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0031:
            gk.g.b(r6)
            kotlinx.coroutines.c2 r6 = kotlinx.coroutines.x0.c()
            com.withpersona.sdk2.camera.camera2.Camera2Manager$requestImageCapture$2 r2 = new com.withpersona.sdk2.camera.camera2.Camera2Manager$requestImageCapture$2
            r4 = 0
            r2.<init>(r5, r4)
            r0.label = r3
            java.lang.Object r6 = kotlinx.coroutines.h.g(r6, r2, r0)
            if (r6 != r1) goto L_0x0047
            return r1
        L_0x0047:
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r6 = r6.j()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.camera.camera2.Camera2Manager.I(kotlin.coroutines.c):java.lang.Object");
    }

    public final void K(boolean z10) {
        this.f14277p = z10;
    }

    public final void L() {
        if (androidx.core.content.a.checkSelfPermission(this.f14262a, "android.permission.CAMERA") != 0 || androidx.core.content.a.checkSelfPermission(this.f14262a, "android.permission.RECORD_AUDIO") != 0) {
            this.f14281t.setValue(new b.c(new Error.MissingPermissionsCameraError()));
        } else if (!this.f14283v) {
            this.f14283v = true;
            this.f14279r = false;
            this.f14284w = new Camera2Manager$start$1(this);
            this.f14271j.n(new Camera2Manager$start$2(this));
            this.f14264c.a();
            this.f14264c.getHolder().addCallback(this.f14284w);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object N(kotlin.coroutines.c<? super java.lang.Boolean> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.withpersona.sdk2.camera.camera2.Camera2Manager$startVideo$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.withpersona.sdk2.camera.camera2.Camera2Manager$startVideo$1 r0 = (com.withpersona.sdk2.camera.camera2.Camera2Manager$startVideo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.withpersona.sdk2.camera.camera2.Camera2Manager$startVideo$1 r0 = new com.withpersona.sdk2.camera.camera2.Camera2Manager$startVideo$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r0 = r0.L$0
            com.withpersona.sdk2.camera.camera2.Camera2Manager r0 = (com.withpersona.sdk2.camera.camera2.Camera2Manager) r0
            gk.g.b(r5)
            goto L_0x0050
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0035:
            gk.g.b(r5)
            boolean r5 = r4.f14276o
            if (r5 == 0) goto L_0x0042
            r5 = 0
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.a.a(r5)
            return r5
        L_0x0042:
            com.withpersona.sdk2.camera.camera2.MediaRecorderWrapper r5 = r4.f14271j
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r5.o(r0)
            if (r5 != r1) goto L_0x004f
            return r1
        L_0x004f:
            r0 = r4
        L_0x0050:
            r0.f14276o = r3
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.a.a(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.camera.camera2.Camera2Manager.N(kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object O(kotlin.coroutines.c<? super kotlin.Result<? extends java.io.File>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.withpersona.sdk2.camera.camera2.Camera2Manager$stopVideo$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.withpersona.sdk2.camera.camera2.Camera2Manager$stopVideo$1 r0 = (com.withpersona.sdk2.camera.camera2.Camera2Manager$stopVideo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.withpersona.sdk2.camera.camera2.Camera2Manager$stopVideo$1 r0 = new com.withpersona.sdk2.camera.camera2.Camera2Manager$stopVideo$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            gk.g.b(r5)
            goto L_0x0056
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0031:
            gk.g.b(r5)
            boolean r5 = r4.f14276o
            if (r5 != 0) goto L_0x0048
            kotlin.Result$a r5 = kotlin.Result.f32010a
            com.withpersona.sdk2.camera.NoActiveRecordingError r5 = new com.withpersona.sdk2.camera.NoActiveRecordingError
            r5.<init>()
            java.lang.Object r5 = gk.g.a(r5)
            java.lang.Object r5 = kotlin.Result.b(r5)
            return r5
        L_0x0048:
            r5 = 0
            r4.f14276o = r5
            com.withpersona.sdk2.camera.camera2.MediaRecorderWrapper r5 = r4.f14271j
            r0.label = r3
            java.lang.Object r5 = r5.p(r0)
            if (r5 != r1) goto L_0x0056
            return r1
        L_0x0056:
            java.io.File r5 = (java.io.File) r5
            if (r5 != 0) goto L_0x006c
            kotlin.Result$a r5 = kotlin.Result.f32010a
            java.lang.RuntimeException r5 = new java.lang.RuntimeException
            java.lang.String r0 = "Recording failed."
            r5.<init>(r0)
            java.lang.Object r5 = gk.g.a(r5)
            java.lang.Object r5 = kotlin.Result.b(r5)
            goto L_0x0070
        L_0x006c:
            java.lang.Object r5 = kotlin.Result.b(r5)
        L_0x0070:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.camera.camera2.Camera2Manager.O(kotlin.coroutines.c):java.lang.Object");
    }

    public final void y() {
        b value = this.f14281t.getValue();
        b.C0151b bVar = b.C0151b.f14290a;
        if (!j.b(value, bVar)) {
            this.f14281t.setValue(bVar);
            this.A.block(2000);
            this.f14271j.f();
            this.f14286y.close();
            CameraCaptureSessionWrapper cameraCaptureSessionWrapper = this.f14275n;
            if (cameraCaptureSessionWrapper != null) {
                cameraCaptureSessionWrapper.e();
            }
            this.f14275n = null;
            CameraDevice cameraDevice = this.f14272k;
            if (cameraDevice != null) {
                cameraDevice.close();
            }
            this.f14272k = null;
            l0.f(this.f14266e, (CancellationException) null, 1, (Object) null);
            this.f14264c.getHolder().removeCallback(this.f14284w);
        }
    }

    public final void z(boolean z10) {
        CameraCaptureSessionWrapper cameraCaptureSessionWrapper = this.f14275n;
        if (cameraCaptureSessionWrapper != null) {
            cameraCaptureSessionWrapper.i(z10);
            cameraCaptureSessionWrapper.l();
        }
    }
}
