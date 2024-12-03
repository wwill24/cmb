package androidx.camera.camera2.internal;

import androidx.annotation.NonNull;
import androidx.camera.core.CameraState;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.a0;
import androidx.camera.core.v1;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.t;
import java.util.Objects;

class j1 {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final a0 f1817a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final t<CameraState> f1818b;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1819a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.camera.core.impl.CameraInternal$State[] r0 = androidx.camera.core.impl.CameraInternal.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1819a = r0
                androidx.camera.core.impl.CameraInternal$State r1 = androidx.camera.core.impl.CameraInternal.State.PENDING_OPEN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f1819a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.camera.core.impl.CameraInternal$State r1 = androidx.camera.core.impl.CameraInternal.State.OPENING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f1819a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.camera.core.impl.CameraInternal$State r1 = androidx.camera.core.impl.CameraInternal.State.OPEN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f1819a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.camera.core.impl.CameraInternal$State r1 = androidx.camera.core.impl.CameraInternal.State.CLOSING     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f1819a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.camera.core.impl.CameraInternal$State r1 = androidx.camera.core.impl.CameraInternal.State.RELEASING     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f1819a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.camera.core.impl.CameraInternal$State r1 = androidx.camera.core.impl.CameraInternal.State.CLOSED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f1819a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.camera.core.impl.CameraInternal$State r1 = androidx.camera.core.impl.CameraInternal.State.RELEASED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.j1.a.<clinit>():void");
        }
    }

    j1(@NonNull a0 a0Var) {
        this.f1817a = a0Var;
        t<CameraState> tVar = new t<>();
        this.f1818b = tVar;
        tVar.m(CameraState.a(CameraState.Type.CLOSED));
    }

    private CameraState b() {
        if (this.f1817a.a()) {
            return CameraState.a(CameraState.Type.OPENING);
        }
        return CameraState.a(CameraState.Type.PENDING_OPEN);
    }

    @NonNull
    public LiveData<CameraState> a() {
        return this.f1818b;
    }

    public void c(@NonNull CameraInternal.State state, CameraState.a aVar) {
        CameraState cameraState;
        switch (a.f1819a[state.ordinal()]) {
            case 1:
                cameraState = b();
                break;
            case 2:
                cameraState = CameraState.b(CameraState.Type.OPENING, aVar);
                break;
            case 3:
                cameraState = CameraState.b(CameraState.Type.OPEN, aVar);
                break;
            case 4:
            case 5:
                cameraState = CameraState.b(CameraState.Type.CLOSING, aVar);
                break;
            case 6:
            case 7:
                cameraState = CameraState.b(CameraState.Type.CLOSED, aVar);
                break;
            default:
                throw new IllegalStateException("Unknown internal camera state: " + state);
        }
        v1.a("CameraStateMachine", "New public camera state " + cameraState + " from " + state + " and " + aVar);
        if (!Objects.equals(this.f1818b.f(), cameraState)) {
            v1.a("CameraStateMachine", "Publishing new public camera state " + cameraState);
            this.f1818b.m(cameraState);
        }
    }
}
