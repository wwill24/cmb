package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.core.CameraState;
import androidx.camera.core.impl.Timebase;
import androidx.camera.core.impl.l;
import androidx.camera.core.impl.n;
import androidx.camera.core.impl.r1;
import androidx.camera.core.impl.utils.c;
import androidx.camera.core.impl.x;
import androidx.camera.core.l3;
import androidx.camera.core.v1;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.r;
import androidx.lifecycle.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import o.c0;
import o.q0;
import q.g;
import s.h;

public final class i0 implements x {

    /* renamed from: a  reason: collision with root package name */
    private final String f1792a;

    /* renamed from: b  reason: collision with root package name */
    private final c0 f1793b;

    /* renamed from: c  reason: collision with root package name */
    private final h f1794c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f1795d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private t f1796e;

    /* renamed from: f  reason: collision with root package name */
    private a<Integer> f1797f = null;

    /* renamed from: g  reason: collision with root package name */
    private a<l3> f1798g = null;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final a<CameraState> f1799h;

    /* renamed from: i  reason: collision with root package name */
    private List<Pair<n, Executor>> f1800i = null;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private final r1 f1801j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    private final l f1802k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    private final q0 f1803l;

    static class a<T> extends r<T> {

        /* renamed from: m  reason: collision with root package name */
        private LiveData<T> f1804m;

        /* renamed from: n  reason: collision with root package name */
        private final T f1805n;

        a(T t10) {
            this.f1805n = t10;
        }

        public T f() {
            LiveData<T> liveData = this.f1804m;
            return liveData == null ? this.f1805n : liveData.f();
        }

        public <S> void p(@NonNull LiveData<S> liveData, @NonNull u<? super S> uVar) {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: package-private */
        public void r(@NonNull LiveData<T> liveData) {
            LiveData<T> liveData2 = this.f1804m;
            if (liveData2 != null) {
                super.q(liveData2);
            }
            this.f1804m = liveData;
            super.p(liveData, new h0(this));
        }
    }

    i0(@NonNull String str, @NonNull q0 q0Var) throws CameraAccessExceptionCompat {
        String str2 = (String) androidx.core.util.h.g(str);
        this.f1792a = str2;
        this.f1803l = q0Var;
        c0 c10 = q0Var.c(str2);
        this.f1793b = c10;
        this.f1794c = new h(this);
        this.f1801j = g.a(str, c10);
        this.f1802k = new d(str, c10);
        this.f1799h = new a<>(CameraState.a(CameraState.Type.CLOSED));
    }

    private void n() {
        o();
    }

    private void o() {
        String str;
        int l10 = l();
        if (l10 == 0) {
            str = "INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED";
        } else if (l10 == 1) {
            str = "INFO_SUPPORTED_HARDWARE_LEVEL_FULL";
        } else if (l10 == 2) {
            str = "INFO_SUPPORTED_HARDWARE_LEVEL_LEGACY";
        } else if (l10 == 3) {
            str = "INFO_SUPPORTED_HARDWARE_LEVEL_3";
        } else if (l10 != 4) {
            str = "Unknown value: " + l10;
        } else {
            str = "INFO_SUPPORTED_HARDWARE_LEVEL_EXTERNAL";
        }
        v1.e("Camera2CameraInfo", "Device Level: " + str);
    }

    @NonNull
    public String a() {
        return this.f1792a;
    }

    public void b(@NonNull Executor executor, @NonNull n nVar) {
        synchronized (this.f1795d) {
            t tVar = this.f1796e;
            if (tVar == null) {
                if (this.f1800i == null) {
                    this.f1800i = new ArrayList();
                }
                this.f1800i.add(new Pair(nVar, executor));
                return;
            }
            tVar.u(executor, nVar);
        }
    }

    public Integer c() {
        Integer num = (Integer) this.f1793b.a(CameraCharacteristics.LENS_FACING);
        androidx.core.util.h.g(num);
        int intValue = num.intValue();
        if (intValue == 0) {
            return 0;
        }
        if (intValue != 1) {
            return null;
        }
        return 1;
    }

    @NonNull
    public l d() {
        return this.f1802k;
    }

    @NonNull
    public r1 e() {
        return this.f1801j;
    }

    public void f(@NonNull n nVar) {
        synchronized (this.f1795d) {
            t tVar = this.f1796e;
            if (tVar == null) {
                List<Pair<n, Executor>> list = this.f1800i;
                if (list != null) {
                    Iterator<Pair<n, Executor>> it = list.iterator();
                    while (it.hasNext()) {
                        if (it.next().first == nVar) {
                            it.remove();
                        }
                    }
                    return;
                }
                return;
            }
            tVar.c0(nVar);
        }
    }

    @NonNull
    public Timebase g() {
        Integer num = (Integer) this.f1793b.a(CameraCharacteristics.SENSOR_INFO_TIMESTAMP_SOURCE);
        androidx.core.util.h.g(num);
        if (num.intValue() != 1) {
            return Timebase.UPTIME;
        }
        return Timebase.REALTIME;
    }

    @NonNull
    public String h() {
        return l() == 2 ? "androidx.camera.camera2.legacy" : "androidx.camera.camera2";
    }

    public int i(int i10) {
        int k10 = k();
        int b10 = c.b(i10);
        Integer c10 = c();
        boolean z10 = true;
        if (c10 == null || 1 != c10.intValue()) {
            z10 = false;
        }
        return c.a(b10, k10, z10);
    }

    @NonNull
    public c0 j() {
        return this.f1793b;
    }

    /* access modifiers changed from: package-private */
    public int k() {
        Integer num = (Integer) this.f1793b.a(CameraCharacteristics.SENSOR_ORIENTATION);
        androidx.core.util.h.g(num);
        return num.intValue();
    }

    /* access modifiers changed from: package-private */
    public int l() {
        Integer num = (Integer) this.f1793b.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        androidx.core.util.h.g(num);
        return num.intValue();
    }

    /* access modifiers changed from: package-private */
    public void m(@NonNull t tVar) {
        synchronized (this.f1795d) {
            this.f1796e = tVar;
            a<l3> aVar = this.f1798g;
            if (aVar != null) {
                aVar.r(tVar.K().e());
            }
            a<Integer> aVar2 = this.f1797f;
            if (aVar2 != null) {
                aVar2.r(this.f1796e.I().f());
            }
            List<Pair<n, Executor>> list = this.f1800i;
            if (list != null) {
                for (Pair next : list) {
                    this.f1796e.u((Executor) next.second, (n) next.first);
                }
                this.f1800i = null;
            }
        }
        n();
    }

    /* access modifiers changed from: package-private */
    public void p(@NonNull LiveData<CameraState> liveData) {
        this.f1799h.r(liveData);
    }
}
