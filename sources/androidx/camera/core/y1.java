package androidx.camera.core;

import android.media.ImageReader;
import android.util.LongSparseArray;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.core.h0;
import androidx.camera.core.impl.n;
import androidx.camera.core.impl.p;
import androidx.camera.core.impl.x0;
import androidx.core.util.h;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import v.c;

public class y1 implements x0, h0.a {

    /* renamed from: a  reason: collision with root package name */
    private final Object f2941a;

    /* renamed from: b  reason: collision with root package name */
    private n f2942b;

    /* renamed from: c  reason: collision with root package name */
    private int f2943c;

    /* renamed from: d  reason: collision with root package name */
    private x0.a f2944d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f2945e;

    /* renamed from: f  reason: collision with root package name */
    private final x0 f2946f;

    /* renamed from: g  reason: collision with root package name */
    x0.a f2947g;

    /* renamed from: h  reason: collision with root package name */
    private Executor f2948h;

    /* renamed from: i  reason: collision with root package name */
    private final LongSparseArray<l1> f2949i;

    /* renamed from: j  reason: collision with root package name */
    private final LongSparseArray<o1> f2950j;

    /* renamed from: k  reason: collision with root package name */
    private int f2951k;

    /* renamed from: l  reason: collision with root package name */
    private final List<o1> f2952l;

    /* renamed from: m  reason: collision with root package name */
    private final List<o1> f2953m;

    class a extends n {
        a() {
        }

        public void b(@NonNull p pVar) {
            super.b(pVar);
            y1.this.s(pVar);
        }
    }

    public y1(int i10, int i11, int i12, int i13) {
        this(j(i10, i11, i12, i13));
    }

    private static x0 j(int i10, int i11, int i12, int i13) {
        return new d(ImageReader.newInstance(i10, i11, i12, i13));
    }

    private void k(o1 o1Var) {
        synchronized (this.f2941a) {
            int indexOf = this.f2952l.indexOf(o1Var);
            if (indexOf >= 0) {
                this.f2952l.remove(indexOf);
                int i10 = this.f2951k;
                if (indexOf <= i10) {
                    this.f2951k = i10 - 1;
                }
            }
            this.f2953m.remove(o1Var);
            if (this.f2943c > 0) {
                n(this.f2946f);
            }
        }
    }

    private void l(t2 t2Var) {
        x0.a aVar;
        Executor executor;
        synchronized (this.f2941a) {
            aVar = null;
            if (this.f2952l.size() < e()) {
                t2Var.a(this);
                this.f2952l.add(t2Var);
                aVar = this.f2947g;
                executor = this.f2948h;
            } else {
                v1.a("TAG", "Maximum image number reached.");
                t2Var.close();
                executor = null;
            }
        }
        if (aVar == null) {
            return;
        }
        if (executor != null) {
            executor.execute(new x1(this, aVar));
        } else {
            aVar.a(this);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o(x0.a aVar) {
        aVar.a(this);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p(x0 x0Var) {
        synchronized (this.f2941a) {
            this.f2943c++;
        }
        n(x0Var);
    }

    private void q() {
        synchronized (this.f2941a) {
            for (int size = this.f2949i.size() - 1; size >= 0; size--) {
                l1 valueAt = this.f2949i.valueAt(size);
                long timestamp = valueAt.getTimestamp();
                o1 o1Var = this.f2950j.get(timestamp);
                if (o1Var != null) {
                    this.f2950j.remove(timestamp);
                    this.f2949i.removeAt(size);
                    l(new t2(o1Var, valueAt));
                }
            }
            r();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void r() {
        /*
            r10 = this;
            java.lang.Object r0 = r10.f2941a
            monitor-enter(r0)
            android.util.LongSparseArray<androidx.camera.core.o1> r1 = r10.f2950j     // Catch:{ all -> 0x008e }
            int r1 = r1.size()     // Catch:{ all -> 0x008e }
            if (r1 == 0) goto L_0x008c
            android.util.LongSparseArray<androidx.camera.core.l1> r1 = r10.f2949i     // Catch:{ all -> 0x008e }
            int r1 = r1.size()     // Catch:{ all -> 0x008e }
            if (r1 != 0) goto L_0x0015
            goto L_0x008c
        L_0x0015:
            android.util.LongSparseArray<androidx.camera.core.o1> r1 = r10.f2950j     // Catch:{ all -> 0x008e }
            r2 = 0
            long r3 = r1.keyAt(r2)     // Catch:{ all -> 0x008e }
            java.lang.Long r1 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x008e }
            android.util.LongSparseArray<androidx.camera.core.l1> r3 = r10.f2949i     // Catch:{ all -> 0x008e }
            long r3 = r3.keyAt(r2)     // Catch:{ all -> 0x008e }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x008e }
            boolean r4 = r3.equals(r1)     // Catch:{ all -> 0x008e }
            r5 = 1
            if (r4 != 0) goto L_0x0032
            r2 = r5
        L_0x0032:
            androidx.core.util.h.a(r2)     // Catch:{ all -> 0x008e }
            long r6 = r3.longValue()     // Catch:{ all -> 0x008e }
            long r8 = r1.longValue()     // Catch:{ all -> 0x008e }
            int r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r2 <= 0) goto L_0x006b
            android.util.LongSparseArray<androidx.camera.core.o1> r1 = r10.f2950j     // Catch:{ all -> 0x008e }
            int r1 = r1.size()     // Catch:{ all -> 0x008e }
            int r1 = r1 - r5
        L_0x0048:
            if (r1 < 0) goto L_0x008a
            android.util.LongSparseArray<androidx.camera.core.o1> r2 = r10.f2950j     // Catch:{ all -> 0x008e }
            long r4 = r2.keyAt(r1)     // Catch:{ all -> 0x008e }
            long r6 = r3.longValue()     // Catch:{ all -> 0x008e }
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 >= 0) goto L_0x0068
            android.util.LongSparseArray<androidx.camera.core.o1> r2 = r10.f2950j     // Catch:{ all -> 0x008e }
            java.lang.Object r2 = r2.valueAt(r1)     // Catch:{ all -> 0x008e }
            androidx.camera.core.o1 r2 = (androidx.camera.core.o1) r2     // Catch:{ all -> 0x008e }
            r2.close()     // Catch:{ all -> 0x008e }
            android.util.LongSparseArray<androidx.camera.core.o1> r2 = r10.f2950j     // Catch:{ all -> 0x008e }
            r2.removeAt(r1)     // Catch:{ all -> 0x008e }
        L_0x0068:
            int r1 = r1 + -1
            goto L_0x0048
        L_0x006b:
            android.util.LongSparseArray<androidx.camera.core.l1> r2 = r10.f2949i     // Catch:{ all -> 0x008e }
            int r2 = r2.size()     // Catch:{ all -> 0x008e }
            int r2 = r2 - r5
        L_0x0072:
            if (r2 < 0) goto L_0x008a
            android.util.LongSparseArray<androidx.camera.core.l1> r3 = r10.f2949i     // Catch:{ all -> 0x008e }
            long r3 = r3.keyAt(r2)     // Catch:{ all -> 0x008e }
            long r5 = r1.longValue()     // Catch:{ all -> 0x008e }
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 >= 0) goto L_0x0087
            android.util.LongSparseArray<androidx.camera.core.l1> r3 = r10.f2949i     // Catch:{ all -> 0x008e }
            r3.removeAt(r2)     // Catch:{ all -> 0x008e }
        L_0x0087:
            int r2 = r2 + -1
            goto L_0x0072
        L_0x008a:
            monitor-exit(r0)     // Catch:{ all -> 0x008e }
            return
        L_0x008c:
            monitor-exit(r0)     // Catch:{ all -> 0x008e }
            return
        L_0x008e:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x008e }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.y1.r():void");
    }

    public void a(@NonNull o1 o1Var) {
        synchronized (this.f2941a) {
            k(o1Var);
        }
    }

    public o1 b() {
        synchronized (this.f2941a) {
            if (this.f2952l.isEmpty()) {
                return null;
            }
            if (this.f2951k < this.f2952l.size()) {
                ArrayList<o1> arrayList = new ArrayList<>();
                for (int i10 = 0; i10 < this.f2952l.size() - 1; i10++) {
                    if (!this.f2953m.contains(this.f2952l.get(i10))) {
                        arrayList.add(this.f2952l.get(i10));
                    }
                }
                for (o1 close : arrayList) {
                    close.close();
                }
                int size = this.f2952l.size() - 1;
                List<o1> list = this.f2952l;
                this.f2951k = size + 1;
                o1 o1Var = list.get(size);
                this.f2953m.add(o1Var);
                return o1Var;
            }
            throw new IllegalStateException("Maximum image number reached.");
        }
    }

    public int c() {
        int c10;
        synchronized (this.f2941a) {
            c10 = this.f2946f.c();
        }
        return c10;
    }

    public void close() {
        synchronized (this.f2941a) {
            if (!this.f2945e) {
                for (o1 close : new ArrayList(this.f2952l)) {
                    close.close();
                }
                this.f2952l.clear();
                this.f2946f.close();
                this.f2945e = true;
            }
        }
    }

    public void d() {
        synchronized (this.f2941a) {
            this.f2946f.d();
            this.f2947g = null;
            this.f2948h = null;
            this.f2943c = 0;
        }
    }

    public int e() {
        int e10;
        synchronized (this.f2941a) {
            e10 = this.f2946f.e();
        }
        return e10;
    }

    public void f(@NonNull x0.a aVar, @NonNull Executor executor) {
        synchronized (this.f2941a) {
            this.f2947g = (x0.a) h.g(aVar);
            this.f2948h = (Executor) h.g(executor);
            this.f2946f.f(this.f2944d, executor);
        }
    }

    public o1 g() {
        synchronized (this.f2941a) {
            if (this.f2952l.isEmpty()) {
                return null;
            }
            if (this.f2951k < this.f2952l.size()) {
                List<o1> list = this.f2952l;
                int i10 = this.f2951k;
                this.f2951k = i10 + 1;
                o1 o1Var = list.get(i10);
                this.f2953m.add(o1Var);
                return o1Var;
            }
            throw new IllegalStateException("Maximum image number reached.");
        }
    }

    public int getHeight() {
        int height;
        synchronized (this.f2941a) {
            height = this.f2946f.getHeight();
        }
        return height;
    }

    public Surface getSurface() {
        Surface surface;
        synchronized (this.f2941a) {
            surface = this.f2946f.getSurface();
        }
        return surface;
    }

    public int getWidth() {
        int width;
        synchronized (this.f2941a) {
            width = this.f2946f.getWidth();
        }
        return width;
    }

    @NonNull
    public n m() {
        return this.f2942b;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x005c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void n(androidx.camera.core.impl.x0 r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.f2941a
            monitor-enter(r0)
            boolean r1 = r6.f2945e     // Catch:{ all -> 0x005e }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x005e }
            return
        L_0x0009:
            android.util.LongSparseArray<androidx.camera.core.o1> r1 = r6.f2950j     // Catch:{ all -> 0x005e }
            int r1 = r1.size()     // Catch:{ all -> 0x005e }
            java.util.List<androidx.camera.core.o1> r2 = r6.f2952l     // Catch:{ all -> 0x005e }
            int r2 = r2.size()     // Catch:{ all -> 0x005e }
            int r1 = r1 + r2
            int r2 = r7.e()     // Catch:{ all -> 0x005e }
            if (r1 < r2) goto L_0x0025
            java.lang.String r7 = "MetadataImageReader"
            java.lang.String r1 = "Skip to acquire the next image because the acquired image count has reached the max images count."
            androidx.camera.core.v1.a(r7, r1)     // Catch:{ all -> 0x005e }
            monitor-exit(r0)     // Catch:{ all -> 0x005e }
            return
        L_0x0025:
            r2 = 0
            androidx.camera.core.o1 r2 = r7.g()     // Catch:{ IllegalStateException -> 0x0047 }
            if (r2 == 0) goto L_0x004f
            int r3 = r6.f2943c     // Catch:{ all -> 0x005e }
            int r3 = r3 + -1
            r6.f2943c = r3     // Catch:{ all -> 0x005e }
            int r1 = r1 + 1
            android.util.LongSparseArray<androidx.camera.core.o1> r3 = r6.f2950j     // Catch:{ all -> 0x005e }
            androidx.camera.core.l1 r4 = r2.z1()     // Catch:{ all -> 0x005e }
            long r4 = r4.getTimestamp()     // Catch:{ all -> 0x005e }
            r3.put(r4, r2)     // Catch:{ all -> 0x005e }
            r6.q()     // Catch:{ all -> 0x005e }
            goto L_0x004f
        L_0x0045:
            r7 = move-exception
            goto L_0x005d
        L_0x0047:
            r3 = move-exception
            java.lang.String r4 = "MetadataImageReader"
            java.lang.String r5 = "Failed to acquire next image."
            androidx.camera.core.v1.b(r4, r5, r3)     // Catch:{ all -> 0x0045 }
        L_0x004f:
            if (r2 == 0) goto L_0x005b
            int r2 = r6.f2943c     // Catch:{ all -> 0x005e }
            if (r2 <= 0) goto L_0x005b
            int r2 = r7.e()     // Catch:{ all -> 0x005e }
            if (r1 < r2) goto L_0x0025
        L_0x005b:
            monitor-exit(r0)     // Catch:{ all -> 0x005e }
            return
        L_0x005d:
            throw r7     // Catch:{ all -> 0x005e }
        L_0x005e:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x005e }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.y1.n(androidx.camera.core.impl.x0):void");
    }

    /* access modifiers changed from: package-private */
    public void s(p pVar) {
        synchronized (this.f2941a) {
            if (!this.f2945e) {
                this.f2949i.put(pVar.getTimestamp(), new c(pVar));
                q();
            }
        }
    }

    y1(@NonNull x0 x0Var) {
        this.f2941a = new Object();
        this.f2942b = new a();
        this.f2943c = 0;
        this.f2944d = new w1(this);
        this.f2945e = false;
        this.f2949i = new LongSparseArray<>();
        this.f2950j = new LongSparseArray<>();
        this.f2953m = new ArrayList();
        this.f2946f = x0Var;
        this.f2951k = 0;
        this.f2952l = new ArrayList(e());
    }
}
