package p;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.InputConfiguration;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.SessionConfiguration;
import android.os.Build;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    private final c f16895a;

    private static final class b implements c {

        /* renamed from: a  reason: collision with root package name */
        private final List<b> f16898a;

        /* renamed from: b  reason: collision with root package name */
        private final CameraCaptureSession.StateCallback f16899b;

        /* renamed from: c  reason: collision with root package name */
        private final Executor f16900c;

        /* renamed from: d  reason: collision with root package name */
        private final int f16901d;

        /* renamed from: e  reason: collision with root package name */
        private a f16902e = null;

        /* renamed from: f  reason: collision with root package name */
        private CaptureRequest f16903f = null;

        b(int i10, @NonNull List<b> list, @NonNull Executor executor, @NonNull CameraCaptureSession.StateCallback stateCallback) {
            this.f16901d = i10;
            this.f16898a = Collections.unmodifiableList(new ArrayList(list));
            this.f16899b = stateCallback;
            this.f16900c = executor;
        }

        @NonNull
        public Executor a() {
            return this.f16900c;
        }

        public a b() {
            return this.f16902e;
        }

        @NonNull
        public CameraCaptureSession.StateCallback c() {
            return this.f16899b;
        }

        @NonNull
        public List<b> d() {
            return this.f16898a;
        }

        public void e(@NonNull a aVar) {
            if (this.f16901d != 1) {
                this.f16902e = aVar;
                return;
            }
            throw new UnsupportedOperationException("Method not supported for high speed session types");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (Objects.equals(this.f16902e, bVar.f16902e) && this.f16901d == bVar.f16901d && this.f16898a.size() == bVar.f16898a.size()) {
                    for (int i10 = 0; i10 < this.f16898a.size(); i10++) {
                        if (!this.f16898a.get(i10).equals(bVar.f16898a.get(i10))) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            return false;
        }

        public Object f() {
            return null;
        }

        public int g() {
            return this.f16901d;
        }

        public void h(@NonNull CaptureRequest captureRequest) {
            this.f16903f = captureRequest;
        }

        public int hashCode() {
            int i10;
            int hashCode = this.f16898a.hashCode() ^ 31;
            int i11 = (hashCode << 5) - hashCode;
            a aVar = this.f16902e;
            if (aVar == null) {
                i10 = 0;
            } else {
                i10 = aVar.hashCode();
            }
            int i12 = i10 ^ i11;
            return this.f16901d ^ ((i12 << 5) - i12);
        }
    }

    private interface c {
        @NonNull
        Executor a();

        a b();

        @NonNull
        CameraCaptureSession.StateCallback c();

        @NonNull
        List<b> d();

        void e(@NonNull a aVar);

        Object f();

        int g();

        void h(@NonNull CaptureRequest captureRequest);
    }

    public k(int i10, @NonNull List<b> list, @NonNull Executor executor, @NonNull CameraCaptureSession.StateCallback stateCallback) {
        if (Build.VERSION.SDK_INT < 28) {
            this.f16895a = new b(i10, list, executor, stateCallback);
        } else {
            this.f16895a = new a(i10, list, executor, stateCallback);
        }
    }

    @NonNull
    public static List<OutputConfiguration> h(@NonNull List<b> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (b g10 : list) {
            arrayList.add((OutputConfiguration) g10.g());
        }
        return arrayList;
    }

    static List<b> i(@NonNull List<OutputConfiguration> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (OutputConfiguration h10 : list) {
            arrayList.add(b.h(h10));
        }
        return arrayList;
    }

    @NonNull
    public Executor a() {
        return this.f16895a.a();
    }

    public a b() {
        return this.f16895a.b();
    }

    @NonNull
    public List<b> c() {
        return this.f16895a.d();
    }

    public int d() {
        return this.f16895a.g();
    }

    @NonNull
    public CameraCaptureSession.StateCallback e() {
        return this.f16895a.c();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        return this.f16895a.equals(((k) obj).f16895a);
    }

    public void f(@NonNull a aVar) {
        this.f16895a.e(aVar);
    }

    public void g(@NonNull CaptureRequest captureRequest) {
        this.f16895a.h(captureRequest);
    }

    public int hashCode() {
        return this.f16895a.hashCode();
    }

    public Object j() {
        return this.f16895a.f();
    }

    private static final class a implements c {

        /* renamed from: a  reason: collision with root package name */
        private final SessionConfiguration f16896a;

        /* renamed from: b  reason: collision with root package name */
        private final List<b> f16897b;

        a(@NonNull Object obj) {
            SessionConfiguration sessionConfiguration = (SessionConfiguration) obj;
            this.f16896a = sessionConfiguration;
            this.f16897b = Collections.unmodifiableList(k.i(sessionConfiguration.getOutputConfigurations()));
        }

        @NonNull
        public Executor a() {
            return this.f16896a.getExecutor();
        }

        public a b() {
            return a.b(this.f16896a.getInputConfiguration());
        }

        @NonNull
        public CameraCaptureSession.StateCallback c() {
            return this.f16896a.getStateCallback();
        }

        @NonNull
        public List<b> d() {
            return this.f16897b;
        }

        public void e(@NonNull a aVar) {
            this.f16896a.setInputConfiguration((InputConfiguration) aVar.a());
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            return Objects.equals(this.f16896a, ((a) obj).f16896a);
        }

        public Object f() {
            return this.f16896a;
        }

        public int g() {
            return this.f16896a.getSessionType();
        }

        public void h(@NonNull CaptureRequest captureRequest) {
            this.f16896a.setSessionParameters(captureRequest);
        }

        public int hashCode() {
            return this.f16896a.hashCode();
        }

        a(int i10, @NonNull List<b> list, @NonNull Executor executor, @NonNull CameraCaptureSession.StateCallback stateCallback) {
            this(new SessionConfiguration(i10, k.h(list), executor, stateCallback));
        }
    }
}
