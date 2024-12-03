package androidx.camera.camera2.internal;

import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.CaptureSession;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.t1;
import androidx.camera.core.impl.v1;
import androidx.core.util.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class c1 implements t1 {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CaptureSession f1693a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final List<v1> f1694b;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f1695c = false;

    /* renamed from: d  reason: collision with root package name */
    private volatile SessionConfig f1696d;

    public c1(@NonNull CaptureSession captureSession, @NonNull List<v1> list) {
        boolean z10 = false;
        z10 = captureSession.f1618l == CaptureSession.State.OPENED ? true : z10;
        h.b(z10, "CaptureSession state must be OPENED. Current state:" + captureSession.f1618l);
        this.f1693a = captureSession;
        this.f1694b = Collections.unmodifiableList(new ArrayList(list));
    }

    public void a() {
        this.f1695c = true;
    }

    public void b(SessionConfig sessionConfig) {
        this.f1696d = sessionConfig;
    }
}
