package androidx.camera.core;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.w0;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class u2 implements w0 {

    /* renamed from: a  reason: collision with root package name */
    final Object f2915a = new Object();

    /* renamed from: b  reason: collision with root package name */
    final SparseArray<CallbackToFutureAdapter.a<o1>> f2916b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    private final SparseArray<zf.a<o1>> f2917c = new SparseArray<>();

    /* renamed from: d  reason: collision with root package name */
    private final List<o1> f2918d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private final List<Integer> f2919e;

    /* renamed from: f  reason: collision with root package name */
    private String f2920f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f2921g = false;

    class a implements CallbackToFutureAdapter.b<o1> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f2922a;

        a(int i10) {
            this.f2922a = i10;
        }

        public Object a(@NonNull CallbackToFutureAdapter.a<o1> aVar) {
            synchronized (u2.this.f2915a) {
                u2.this.f2916b.put(this.f2922a, aVar);
            }
            return "getImageProxy(id: " + this.f2922a + ")";
        }
    }

    u2(List<Integer> list, String str) {
        this.f2919e = list;
        this.f2920f = str;
        f();
    }

    private void f() {
        synchronized (this.f2915a) {
            for (Integer intValue : this.f2919e) {
                int intValue2 = intValue.intValue();
                this.f2917c.put(intValue2, CallbackToFutureAdapter.a(new a(intValue2)));
            }
        }
    }

    @NonNull
    public List<Integer> a() {
        return Collections.unmodifiableList(this.f2919e);
    }

    @NonNull
    public zf.a<o1> b(int i10) {
        zf.a<o1> aVar;
        synchronized (this.f2915a) {
            if (!this.f2921g) {
                aVar = this.f2917c.get(i10);
                if (aVar == null) {
                    throw new IllegalArgumentException("ImageProxyBundle does not contain this id: " + i10);
                }
            } else {
                throw new IllegalStateException("ImageProxyBundle already closed.");
            }
        }
        return aVar;
    }

    /* access modifiers changed from: package-private */
    public void c(o1 o1Var) {
        synchronized (this.f2915a) {
            if (!this.f2921g) {
                Integer num = (Integer) o1Var.z1().c().c(this.f2920f);
                if (num != null) {
                    CallbackToFutureAdapter.a aVar = this.f2916b.get(num.intValue());
                    if (aVar != null) {
                        this.f2918d.add(o1Var);
                        aVar.c(o1Var);
                        return;
                    }
                    throw new IllegalArgumentException("ImageProxyBundle does not contain this id: " + num);
                }
                throw new IllegalArgumentException("CaptureId is null.");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void d() {
        synchronized (this.f2915a) {
            if (!this.f2921g) {
                for (o1 close : this.f2918d) {
                    close.close();
                }
                this.f2918d.clear();
                this.f2917c.clear();
                this.f2916b.clear();
                this.f2921g = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void e() {
        synchronized (this.f2915a) {
            if (!this.f2921g) {
                for (o1 close : this.f2918d) {
                    close.close();
                }
                this.f2918d.clear();
                this.f2917c.clear();
                this.f2916b.clear();
                f();
            }
        }
    }
}
