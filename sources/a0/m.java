package a0;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.core.v1;
import androidx.core.util.h;
import com.facebook.internal.security.CertificateUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public final class m {

    /* renamed from: n  reason: collision with root package name */
    private static final String f65n;

    /* renamed from: o  reason: collision with root package name */
    private static final String f66o;

    /* renamed from: p  reason: collision with root package name */
    private static final float[] f67p;

    /* renamed from: q  reason: collision with root package name */
    private static final FloatBuffer f68q;

    /* renamed from: r  reason: collision with root package name */
    private static final float[] f69r;

    /* renamed from: s  reason: collision with root package name */
    private static final FloatBuffer f70s;

    /* renamed from: a  reason: collision with root package name */
    private final AtomicBoolean f71a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    private final Map<Surface, a> f72b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private Thread f73c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private EGLDisplay f74d = EGL14.EGL_NO_DISPLAY;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private EGLContext f75e = EGL14.EGL_NO_CONTEXT;

    /* renamed from: f  reason: collision with root package name */
    private EGLConfig f76f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private EGLSurface f77g = EGL14.EGL_NO_SURFACE;

    /* renamed from: h  reason: collision with root package name */
    private a f78h;

    /* renamed from: i  reason: collision with root package name */
    private int f79i = -1;

    /* renamed from: j  reason: collision with root package name */
    private int f80j = -1;

    /* renamed from: k  reason: collision with root package name */
    private int f81k = -1;

    /* renamed from: l  reason: collision with root package name */
    private int f82l = -1;

    /* renamed from: m  reason: collision with root package name */
    private int f83m = -1;

    static abstract class a {
        a() {
        }

        @NonNull
        static a d(@NonNull EGLSurface eGLSurface, int i10, int i11) {
            return new a(eGLSurface, i10, i11);
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public abstract EGLSurface a();

        /* access modifiers changed from: package-private */
        public abstract int b();

        /* access modifiers changed from: package-private */
        public abstract int c();
    }

    static {
        Locale locale = Locale.US;
        f65n = String.format(locale, "uniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 %s;\nvoid main() {\n    gl_Position = aPosition;\n    %s = (uTexMatrix * aTextureCoord).xy;\n}\n", new Object[]{"vTextureCoord", "vTextureCoord"});
        f66o = String.format(locale, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 %s;\nuniform samplerExternalOES %s;\nvoid main() {\n    gl_FragColor = texture2D(%s, %s);\n}\n", new Object[]{"vTextureCoord", "sTexture", "sTexture", "vTextureCoord"});
        float[] fArr = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        f67p = fArr;
        f68q = g(fArr);
        float[] fArr2 = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        f69r = fArr2;
        f70s = g(fArr2);
    }

    private static void a(@NonNull String str) {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError != 12288) {
            throw new IllegalStateException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
        }
    }

    private static void b(@NonNull String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            throw new IllegalStateException(str + ": GL error 0x" + Integer.toHexString(glGetError));
        }
    }

    private void c() {
        h.j(this.f73c == Thread.currentThread(), "Method call must be called on the GL thread.");
    }

    private void d(boolean z10) {
        boolean z11;
        String str;
        if (z10 == this.f71a.get()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10) {
            str = "OpenGlRenderer is not initialized";
        } else {
            str = "OpenGlRenderer is already initialized";
        }
        h.j(z11, str);
    }

    private static void e(int i10, @NonNull String str) {
        if (i10 < 0) {
            throw new IllegalStateException("Unable to locate '" + str + "' in program");
        }
    }

    private void f() {
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        this.f74d = eglGetDisplay;
        if (!Objects.equals(eglGetDisplay, EGL14.EGL_NO_DISPLAY)) {
            int[] iArr = new int[2];
            if (EGL14.eglInitialize(this.f74d, iArr, 0, iArr, 1)) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                if (EGL14.eglChooseConfig(this.f74d, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12610, 1, 12339, 5, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                    EGLConfig eGLConfig = eGLConfigArr[0];
                    EGLContext eglCreateContext = EGL14.eglCreateContext(this.f74d, eGLConfig, EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
                    a("eglCreateContext");
                    this.f76f = eGLConfig;
                    this.f75e = eglCreateContext;
                    int[] iArr2 = new int[1];
                    EGL14.eglQueryContext(this.f74d, eglCreateContext, 12440, iArr2, 0);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("EGLContext created, client version ");
                    sb2.append(iArr2[0]);
                    return;
                }
                throw new IllegalStateException("Unable to find a suitable EGLConfig");
            }
            this.f74d = EGL14.EGL_NO_DISPLAY;
            throw new IllegalStateException("Unable to initialize EGL14");
        }
        throw new IllegalStateException("Unable to get EGL14 display");
    }

    @NonNull
    public static FloatBuffer g(@NonNull float[] fArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        return asFloatBuffer;
    }

    @NonNull
    private static EGLSurface h(@NonNull EGLDisplay eGLDisplay, @NonNull EGLConfig eGLConfig, int i10, int i11) {
        EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eGLDisplay, eGLConfig, new int[]{12375, i10, 12374, i11, 12344}, 0);
        a("eglCreatePbufferSurface");
        if (eglCreatePbufferSurface != null) {
            return eglCreatePbufferSurface;
        }
        throw new IllegalStateException("surface was null");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0075  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void i(@androidx.annotation.NonNull a0.v r8) {
        /*
            r7 = this;
            java.lang.String r0 = "glAttachShader"
            r1 = 35633(0x8b31, float:4.9932E-41)
            r2 = -1
            java.lang.String r3 = f65n     // Catch:{ IllegalStateException -> 0x0065, IllegalArgumentException -> 0x0063 }
            int r1 = r(r1, r3)     // Catch:{ IllegalStateException -> 0x0065, IllegalArgumentException -> 0x0063 }
            int r8 = r7.p(r8)     // Catch:{ IllegalStateException -> 0x005f, IllegalArgumentException -> 0x005d }
            int r3 = android.opengl.GLES20.glCreateProgram()     // Catch:{ IllegalStateException -> 0x005a, IllegalArgumentException -> 0x0058 }
            java.lang.String r4 = "glCreateProgram"
            b(r4)     // Catch:{ IllegalStateException -> 0x0056, IllegalArgumentException -> 0x0054 }
            android.opengl.GLES20.glAttachShader(r3, r1)     // Catch:{ IllegalStateException -> 0x0056, IllegalArgumentException -> 0x0054 }
            b(r0)     // Catch:{ IllegalStateException -> 0x0056, IllegalArgumentException -> 0x0054 }
            android.opengl.GLES20.glAttachShader(r3, r8)     // Catch:{ IllegalStateException -> 0x0056, IllegalArgumentException -> 0x0054 }
            b(r0)     // Catch:{ IllegalStateException -> 0x0056, IllegalArgumentException -> 0x0054 }
            android.opengl.GLES20.glLinkProgram(r3)     // Catch:{ IllegalStateException -> 0x0056, IllegalArgumentException -> 0x0054 }
            r0 = 1
            int[] r4 = new int[r0]     // Catch:{ IllegalStateException -> 0x0056, IllegalArgumentException -> 0x0054 }
            r5 = 35714(0x8b82, float:5.0046E-41)
            r6 = 0
            android.opengl.GLES20.glGetProgramiv(r3, r5, r4, r6)     // Catch:{ IllegalStateException -> 0x0056, IllegalArgumentException -> 0x0054 }
            r4 = r4[r6]     // Catch:{ IllegalStateException -> 0x0056, IllegalArgumentException -> 0x0054 }
            if (r4 != r0) goto L_0x0039
            r7.f80j = r3     // Catch:{ IllegalStateException -> 0x0056, IllegalArgumentException -> 0x0054 }
            return
        L_0x0039:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ IllegalStateException -> 0x0056, IllegalArgumentException -> 0x0054 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IllegalStateException -> 0x0056, IllegalArgumentException -> 0x0054 }
            r4.<init>()     // Catch:{ IllegalStateException -> 0x0056, IllegalArgumentException -> 0x0054 }
            java.lang.String r5 = "Could not link program: "
            r4.append(r5)     // Catch:{ IllegalStateException -> 0x0056, IllegalArgumentException -> 0x0054 }
            java.lang.String r5 = android.opengl.GLES20.glGetProgramInfoLog(r3)     // Catch:{ IllegalStateException -> 0x0056, IllegalArgumentException -> 0x0054 }
            r4.append(r5)     // Catch:{ IllegalStateException -> 0x0056, IllegalArgumentException -> 0x0054 }
            java.lang.String r4 = r4.toString()     // Catch:{ IllegalStateException -> 0x0056, IllegalArgumentException -> 0x0054 }
            r0.<init>(r4)     // Catch:{ IllegalStateException -> 0x0056, IllegalArgumentException -> 0x0054 }
            throw r0     // Catch:{ IllegalStateException -> 0x0056, IllegalArgumentException -> 0x0054 }
        L_0x0054:
            r0 = move-exception
            goto L_0x0069
        L_0x0056:
            r0 = move-exception
            goto L_0x0069
        L_0x0058:
            r0 = move-exception
            goto L_0x005b
        L_0x005a:
            r0 = move-exception
        L_0x005b:
            r3 = r2
            goto L_0x0069
        L_0x005d:
            r0 = move-exception
            goto L_0x0060
        L_0x005f:
            r0 = move-exception
        L_0x0060:
            r8 = r2
            r3 = r8
            goto L_0x0069
        L_0x0063:
            r0 = move-exception
            goto L_0x0066
        L_0x0065:
            r0 = move-exception
        L_0x0066:
            r8 = r2
            r1 = r8
            r3 = r1
        L_0x0069:
            if (r1 == r2) goto L_0x006e
            android.opengl.GLES20.glDeleteShader(r1)
        L_0x006e:
            if (r8 == r2) goto L_0x0073
            android.opengl.GLES20.glDeleteShader(r8)
        L_0x0073:
            if (r3 == r2) goto L_0x0078
            android.opengl.GLES20.glDeleteProgram(r3)
        L_0x0078:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a0.m.i(a0.v):void");
    }

    private void j() {
        EGLDisplay eGLDisplay = this.f74d;
        EGLConfig eGLConfig = this.f76f;
        Objects.requireNonNull(eGLConfig);
        EGLConfig eGLConfig2 = eGLConfig;
        this.f77g = h(eGLDisplay, eGLConfig, 1, 1);
    }

    private void k() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        b("glGenTextures");
        int i10 = iArr[0];
        GLES20.glBindTexture(36197, i10);
        b("glBindTexture " + i10);
        GLES20.glTexParameterf(36197, 10241, 9728.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        b("glTexParameter");
        this.f79i = i10;
    }

    @NonNull
    private static EGLSurface l(@NonNull EGLDisplay eGLDisplay, @NonNull EGLConfig eGLConfig, @NonNull Surface surface) {
        EGLSurface eglCreateWindowSurface = EGL14.eglCreateWindowSurface(eGLDisplay, eGLConfig, surface, new int[]{12344}, 0);
        a("eglCreateWindowSurface");
        if (eglCreateWindowSurface != null) {
            return eglCreateWindowSurface;
        }
        throw new IllegalStateException("surface was null");
    }

    @NonNull
    private Size m(@NonNull EGLSurface eGLSurface) {
        return new Size(t(this.f74d, eGLSurface, 12375), t(this.f74d, eGLSurface, 12374));
    }

    private int p(@NonNull v vVar) {
        if (vVar == v.f107a) {
            return r(35632, f66o);
        }
        try {
            String a10 = vVar.a("sTexture", "vTextureCoord");
            if (a10 != null && a10.contains("vTextureCoord") && a10.contains("sTexture")) {
                return r(35632, a10);
            }
            throw new IllegalArgumentException("Invalid fragment shader");
        } catch (Throwable th2) {
            if (th2 instanceof IllegalArgumentException) {
                throw th2;
            }
            throw new IllegalArgumentException("Unable to compile fragment shader", th2);
        }
    }

    private void q() {
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.f80j, "aPosition");
        this.f82l = glGetAttribLocation;
        e(glGetAttribLocation, "aPosition");
        int glGetAttribLocation2 = GLES20.glGetAttribLocation(this.f80j, "aTextureCoord");
        this.f83m = glGetAttribLocation2;
        e(glGetAttribLocation2, "aTextureCoord");
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.f80j, "uTexMatrix");
        this.f81k = glGetUniformLocation;
        e(glGetUniformLocation, "uTexMatrix");
    }

    private static int r(int i10, @NonNull String str) {
        int glCreateShader = GLES20.glCreateShader(i10);
        b("glCreateShader type=" + i10);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        v1.l("OpenGlRenderer", "Could not compile shader: " + str);
        GLES20.glDeleteShader(glCreateShader);
        throw new IllegalStateException("Could not compile shader type " + i10 + CertificateUtil.DELIMITER + GLES20.glGetShaderInfoLog(glCreateShader));
    }

    private void s(@NonNull EGLSurface eGLSurface) {
        h.g(this.f74d);
        h.g(this.f75e);
        if (!EGL14.eglMakeCurrent(this.f74d, eGLSurface, eGLSurface, this.f75e)) {
            throw new IllegalStateException("eglMakeCurrent failed");
        }
    }

    private static int t(@NonNull EGLDisplay eGLDisplay, @NonNull EGLSurface eGLSurface, int i10) {
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(eGLDisplay, eGLSurface, i10, iArr, 0);
        return iArr[0];
    }

    private void v() {
        int i10 = this.f80j;
        if (i10 != -1) {
            GLES20.glDeleteProgram(i10);
            this.f80j = -1;
        }
        for (a a10 : this.f72b.values()) {
            EGL14.eglDestroySurface(this.f74d, a10.a());
        }
        this.f72b.clear();
        if (!Objects.equals(this.f77g, EGL14.EGL_NO_SURFACE)) {
            EGL14.eglDestroySurface(this.f74d, this.f77g);
            this.f77g = EGL14.EGL_NO_SURFACE;
        }
        if (!Objects.equals(this.f74d, EGL14.EGL_NO_DISPLAY)) {
            if (!Objects.equals(this.f75e, EGL14.EGL_NO_CONTEXT)) {
                EGLDisplay eGLDisplay = this.f74d;
                EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f75e);
                EGL14.eglDestroyContext(this.f74d, this.f75e);
                this.f75e = EGL14.EGL_NO_CONTEXT;
            }
            EGL14.eglTerminate(this.f74d);
            this.f74d = EGL14.EGL_NO_DISPLAY;
        }
        this.f76f = null;
        this.f80j = -1;
        this.f81k = -1;
        this.f82l = -1;
        this.f83m = -1;
        this.f79i = -1;
        this.f78h = null;
        this.f73c = null;
    }

    public int n() {
        d(true);
        c();
        return this.f79i;
    }

    public void o(@NonNull v vVar) {
        d(false);
        try {
            f();
            j();
            s(this.f77g);
            i(vVar);
            q();
            k();
            this.f73c = Thread.currentThread();
            this.f71a.set(true);
        } catch (IllegalArgumentException | IllegalStateException e10) {
            v();
            throw e10;
        }
    }

    public void u() {
        if (this.f71a.getAndSet(false)) {
            c();
            v();
        }
    }

    public void w(long j10, @NonNull float[] fArr) {
        d(true);
        c();
        if (this.f78h != null) {
            GLES20.glUseProgram(this.f80j);
            b("glUseProgram");
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(36197, this.f79i);
            GLES20.glUniformMatrix4fv(this.f81k, 1, false, fArr, 0);
            b("glUniformMatrix4fv");
            GLES20.glEnableVertexAttribArray(this.f82l);
            b("glEnableVertexAttribArray");
            GLES20.glVertexAttribPointer(this.f82l, 2, 5126, false, 0, f68q);
            b("glVertexAttribPointer");
            GLES20.glEnableVertexAttribArray(this.f83m);
            b("glEnableVertexAttribArray");
            GLES20.glVertexAttribPointer(this.f83m, 2, 5126, false, 0, f70s);
            b("glVertexAttribPointer");
            GLES20.glDrawArrays(5, 0, 4);
            b("glDrawArrays");
            GLES20.glDisableVertexAttribArray(this.f82l);
            GLES20.glDisableVertexAttribArray(this.f83m);
            GLES20.glUseProgram(0);
            GLES20.glBindTexture(36197, 0);
            EGLExt.eglPresentationTimeANDROID(this.f74d, this.f78h.a(), j10);
            if (!EGL14.eglSwapBuffers(this.f74d, this.f78h.a())) {
                v1.l("OpenGlRenderer", "Failed to swap buffers with EGL error: 0x" + Integer.toHexString(EGL14.eglGetError()));
            }
        }
    }

    public void x(@NonNull Surface surface) {
        d(true);
        c();
        if (!this.f72b.containsKey(surface)) {
            EGLDisplay eGLDisplay = this.f74d;
            EGLConfig eGLConfig = this.f76f;
            Objects.requireNonNull(eGLConfig);
            EGLConfig eGLConfig2 = eGLConfig;
            EGLSurface l10 = l(eGLDisplay, eGLConfig, surface);
            Size m10 = m(l10);
            this.f72b.put(surface, a.d(l10, m10.getWidth(), m10.getHeight()));
        }
        a aVar = this.f72b.get(surface);
        Objects.requireNonNull(aVar);
        this.f78h = aVar;
        s(aVar.a());
        GLES20.glViewport(0, 0, this.f78h.c(), this.f78h.b());
        GLES20.glScissor(0, 0, this.f78h.c(), this.f78h.b());
    }
}
