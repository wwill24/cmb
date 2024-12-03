package t2;

import android.annotation.TargetApi;
import android.graphics.Path;
import com.airbnb.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;

@TargetApi(19)
public class l implements m, j {

    /* renamed from: a  reason: collision with root package name */
    private final Path f17729a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final Path f17730b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private final Path f17731c = new Path();

    /* renamed from: d  reason: collision with root package name */
    private final String f17732d;

    /* renamed from: e  reason: collision with root package name */
    private final List<m> f17733e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private final MergePaths f17734f;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f17735a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.airbnb.lottie.model.content.MergePaths$MergePathsMode[] r0 = com.airbnb.lottie.model.content.MergePaths.MergePathsMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f17735a = r0
                com.airbnb.lottie.model.content.MergePaths$MergePathsMode r1 = com.airbnb.lottie.model.content.MergePaths.MergePathsMode.MERGE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f17735a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.airbnb.lottie.model.content.MergePaths$MergePathsMode r1 = com.airbnb.lottie.model.content.MergePaths.MergePathsMode.ADD     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f17735a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.airbnb.lottie.model.content.MergePaths$MergePathsMode r1 = com.airbnb.lottie.model.content.MergePaths.MergePathsMode.SUBTRACT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f17735a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.airbnb.lottie.model.content.MergePaths$MergePathsMode r1 = com.airbnb.lottie.model.content.MergePaths.MergePathsMode.INTERSECT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f17735a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.airbnb.lottie.model.content.MergePaths$MergePathsMode r1 = com.airbnb.lottie.model.content.MergePaths.MergePathsMode.EXCLUDE_INTERSECTIONS     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: t2.l.a.<clinit>():void");
        }
    }

    public l(MergePaths mergePaths) {
        this.f17732d = mergePaths.c();
        this.f17734f = mergePaths;
    }

    private void a() {
        for (int i10 = 0; i10 < this.f17733e.size(); i10++) {
            this.f17731c.addPath(this.f17733e.get(i10).getPath());
        }
    }

    @TargetApi(19)
    private void c(Path.Op op) {
        this.f17730b.reset();
        this.f17729a.reset();
        for (int size = this.f17733e.size() - 1; size >= 1; size--) {
            m mVar = this.f17733e.get(size);
            if (mVar instanceof d) {
                d dVar = (d) mVar;
                List<m> k10 = dVar.k();
                for (int size2 = k10.size() - 1; size2 >= 0; size2--) {
                    Path path = k10.get(size2).getPath();
                    path.transform(dVar.l());
                    this.f17730b.addPath(path);
                }
            } else {
                this.f17730b.addPath(mVar.getPath());
            }
        }
        m mVar2 = this.f17733e.get(0);
        if (mVar2 instanceof d) {
            d dVar2 = (d) mVar2;
            List<m> k11 = dVar2.k();
            for (int i10 = 0; i10 < k11.size(); i10++) {
                Path path2 = k11.get(i10).getPath();
                path2.transform(dVar2.l());
                this.f17729a.addPath(path2);
            }
        } else {
            this.f17729a.set(mVar2.getPath());
        }
        this.f17731c.op(this.f17729a, this.f17730b, op);
    }

    public void b(List<c> list, List<c> list2) {
        for (int i10 = 0; i10 < this.f17733e.size(); i10++) {
            this.f17733e.get(i10).b(list, list2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:3:0x000a, LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g(java.util.ListIterator<t2.c> r3) {
        /*
            r2 = this;
        L_0x0000:
            boolean r0 = r3.hasPrevious()
            if (r0 == 0) goto L_0x000d
            java.lang.Object r0 = r3.previous()
            if (r0 == r2) goto L_0x000d
            goto L_0x0000
        L_0x000d:
            boolean r0 = r3.hasPrevious()
            if (r0 == 0) goto L_0x0028
            java.lang.Object r0 = r3.previous()
            t2.c r0 = (t2.c) r0
            boolean r1 = r0 instanceof t2.m
            if (r1 == 0) goto L_0x000d
            java.util.List<t2.m> r1 = r2.f17733e
            t2.m r0 = (t2.m) r0
            r1.add(r0)
            r3.remove()
            goto L_0x000d
        L_0x0028:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: t2.l.g(java.util.ListIterator):void");
    }

    public Path getPath() {
        this.f17731c.reset();
        if (this.f17734f.d()) {
            return this.f17731c;
        }
        int i10 = a.f17735a[this.f17734f.b().ordinal()];
        if (i10 == 1) {
            a();
        } else if (i10 == 2) {
            c(Path.Op.UNION);
        } else if (i10 == 3) {
            c(Path.Op.REVERSE_DIFFERENCE);
        } else if (i10 == 4) {
            c(Path.Op.INTERSECT);
        } else if (i10 == 5) {
            c(Path.Op.XOR);
        }
        return this.f17731c;
    }
}
