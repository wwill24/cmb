package androidx.camera.core;

import android.graphics.Rect;
import android.media.Image;
import androidx.annotation.NonNull;
import androidx.camera.core.o1;
import java.util.HashSet;
import java.util.Set;

public abstract class h0 implements o1 {

    /* renamed from: a  reason: collision with root package name */
    private final Object f2269a = new Object();

    /* renamed from: b  reason: collision with root package name */
    protected final o1 f2270b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<a> f2271c = new HashSet();

    public interface a {
        void a(@NonNull o1 o1Var);
    }

    protected h0(@NonNull o1 o1Var) {
        this.f2270b = o1Var;
    }

    @NonNull
    public o1.a[] M0() {
        return this.f2270b.M0();
    }

    @NonNull
    public Rect X0() {
        return this.f2270b.X0();
    }

    public void a(@NonNull a aVar) {
        synchronized (this.f2269a) {
            this.f2271c.add(aVar);
        }
    }

    /* access modifiers changed from: protected */
    public void b() {
        HashSet<a> hashSet;
        synchronized (this.f2269a) {
            hashSet = new HashSet<>(this.f2271c);
        }
        for (a a10 : hashSet) {
            a10.a(this);
        }
    }

    public void close() {
        this.f2270b.close();
        b();
    }

    public int getFormat() {
        return this.f2270b.getFormat();
    }

    public int getHeight() {
        return this.f2270b.getHeight();
    }

    public int getWidth() {
        return this.f2270b.getWidth();
    }

    public void p0(Rect rect) {
        this.f2270b.p0(rect);
    }

    public Image t() {
        return this.f2270b.t();
    }

    @NonNull
    public l1 z1() {
        return this.f2270b.z1();
    }
}
