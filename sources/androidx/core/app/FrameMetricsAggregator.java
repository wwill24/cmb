package androidx.core.app;

import android.app.Activity;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseIntArray;
import android.view.FrameMetrics;
import android.view.Window;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class FrameMetricsAggregator {

    /* renamed from: a  reason: collision with root package name */
    private final b f4387a;

    private static class a extends b {

        /* renamed from: e  reason: collision with root package name */
        private static HandlerThread f4388e;

        /* renamed from: f  reason: collision with root package name */
        private static Handler f4389f;

        /* renamed from: a  reason: collision with root package name */
        int f4390a;

        /* renamed from: b  reason: collision with root package name */
        SparseIntArray[] f4391b = new SparseIntArray[9];

        /* renamed from: c  reason: collision with root package name */
        private final ArrayList<WeakReference<Activity>> f4392c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        Window.OnFrameMetricsAvailableListener f4393d = new C0031a();

        /* renamed from: androidx.core.app.FrameMetricsAggregator$a$a  reason: collision with other inner class name */
        class C0031a implements Window.OnFrameMetricsAvailableListener {
            C0031a() {
            }

            public void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i10) {
                a aVar = a.this;
                if ((aVar.f4390a & 1) != 0) {
                    aVar.f(aVar.f4391b[0], frameMetrics.getMetric(8));
                }
                a aVar2 = a.this;
                if ((aVar2.f4390a & 2) != 0) {
                    aVar2.f(aVar2.f4391b[1], frameMetrics.getMetric(1));
                }
                a aVar3 = a.this;
                if ((aVar3.f4390a & 4) != 0) {
                    aVar3.f(aVar3.f4391b[2], frameMetrics.getMetric(3));
                }
                a aVar4 = a.this;
                if ((aVar4.f4390a & 8) != 0) {
                    aVar4.f(aVar4.f4391b[3], frameMetrics.getMetric(4));
                }
                a aVar5 = a.this;
                if ((aVar5.f4390a & 16) != 0) {
                    aVar5.f(aVar5.f4391b[4], frameMetrics.getMetric(5));
                }
                a aVar6 = a.this;
                if ((aVar6.f4390a & 64) != 0) {
                    aVar6.f(aVar6.f4391b[6], frameMetrics.getMetric(7));
                }
                a aVar7 = a.this;
                if ((aVar7.f4390a & 32) != 0) {
                    aVar7.f(aVar7.f4391b[5], frameMetrics.getMetric(6));
                }
                a aVar8 = a.this;
                if ((aVar8.f4390a & 128) != 0) {
                    aVar8.f(aVar8.f4391b[7], frameMetrics.getMetric(0));
                }
                a aVar9 = a.this;
                if ((aVar9.f4390a & 256) != 0) {
                    aVar9.f(aVar9.f4391b[8], frameMetrics.getMetric(2));
                }
            }
        }

        a(int i10) {
            this.f4390a = i10;
        }

        public void a(Activity activity) {
            if (f4388e == null) {
                HandlerThread handlerThread = new HandlerThread("FrameMetricsAggregator");
                f4388e = handlerThread;
                handlerThread.start();
                f4389f = new Handler(f4388e.getLooper());
            }
            for (int i10 = 0; i10 <= 8; i10++) {
                SparseIntArray[] sparseIntArrayArr = this.f4391b;
                if (sparseIntArrayArr[i10] == null && (this.f4390a & (1 << i10)) != 0) {
                    sparseIntArrayArr[i10] = new SparseIntArray();
                }
            }
            activity.getWindow().addOnFrameMetricsAvailableListener(this.f4393d, f4389f);
            this.f4392c.add(new WeakReference(activity));
        }

        public SparseIntArray[] b() {
            return this.f4391b;
        }

        public SparseIntArray[] c(Activity activity) {
            Iterator<WeakReference<Activity>> it = this.f4392c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WeakReference next = it.next();
                if (next.get() == activity) {
                    this.f4392c.remove(next);
                    break;
                }
            }
            activity.getWindow().removeOnFrameMetricsAvailableListener(this.f4393d);
            return this.f4391b;
        }

        public SparseIntArray[] d() {
            SparseIntArray[] sparseIntArrayArr = this.f4391b;
            this.f4391b = new SparseIntArray[9];
            return sparseIntArrayArr;
        }

        public SparseIntArray[] e() {
            for (int size = this.f4392c.size() - 1; size >= 0; size--) {
                WeakReference weakReference = this.f4392c.get(size);
                Activity activity = (Activity) weakReference.get();
                if (weakReference.get() != null) {
                    activity.getWindow().removeOnFrameMetricsAvailableListener(this.f4393d);
                    this.f4392c.remove(size);
                }
            }
            return this.f4391b;
        }

        /* access modifiers changed from: package-private */
        public void f(SparseIntArray sparseIntArray, long j10) {
            if (sparseIntArray != null) {
                int i10 = (int) ((500000 + j10) / 1000000);
                if (j10 >= 0) {
                    sparseIntArray.put(i10, sparseIntArray.get(i10) + 1);
                }
            }
        }
    }

    private static class b {
        b() {
        }

        public void a(Activity activity) {
            throw null;
        }

        public SparseIntArray[] b() {
            throw null;
        }

        public SparseIntArray[] c(Activity activity) {
            throw null;
        }

        public SparseIntArray[] d() {
            throw null;
        }

        public SparseIntArray[] e() {
            throw null;
        }
    }

    public FrameMetricsAggregator() {
        this(1);
    }

    public void a(@NonNull Activity activity) {
        this.f4387a.a(activity);
    }

    public SparseIntArray[] b() {
        return this.f4387a.b();
    }

    public SparseIntArray[] c(@NonNull Activity activity) {
        return this.f4387a.c(activity);
    }

    public SparseIntArray[] d() {
        return this.f4387a.d();
    }

    public SparseIntArray[] e() {
        return this.f4387a.e();
    }

    public FrameMetricsAggregator(int i10) {
        this.f4387a = new a(i10);
    }
}
