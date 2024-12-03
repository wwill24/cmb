package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class y1 {

    /* renamed from: a  reason: collision with root package name */
    private final List<SurfaceConfig> f2717a = new ArrayList();

    private static void b(List<int[]> list, int i10, int[] iArr, int i11) {
        boolean z10;
        if (i11 >= iArr.length) {
            list.add((int[]) iArr.clone());
            return;
        }
        for (int i12 = 0; i12 < i10; i12++) {
            int i13 = 0;
            while (true) {
                if (i13 >= i11) {
                    z10 = false;
                    break;
                } else if (i12 == iArr[i13]) {
                    z10 = true;
                    break;
                } else {
                    i13++;
                }
            }
            if (!z10) {
                iArr[i11] = i12;
                b(list, i10, iArr, i11 + 1);
            }
        }
    }

    private List<int[]> c(int i10) {
        ArrayList arrayList = new ArrayList();
        b(arrayList, i10, new int[i10], 0);
        return arrayList;
    }

    public boolean a(@NonNull SurfaceConfig surfaceConfig) {
        return this.f2717a.add(surfaceConfig);
    }

    public boolean d(@NonNull List<SurfaceConfig> list) {
        if (list.isEmpty()) {
            return true;
        }
        if (list.size() > this.f2717a.size()) {
            return false;
        }
        Iterator<int[]> it = c(this.f2717a.size()).iterator();
        while (it.hasNext()) {
            int[] next = it.next();
            boolean z10 = true;
            int i10 = 0;
            while (i10 < this.f2717a.size() && (next[i10] >= list.size() || ((z10 = z10 & this.f2717a.get(i10).e(list.get(next[i10])))))) {
                i10++;
            }
            if (z10) {
                return true;
            }
        }
        return false;
    }
}
