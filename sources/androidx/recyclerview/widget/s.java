package androidx.recyclerview.widget;

import androidx.recyclerview.widget.a;
import java.util.List;

class s {

    /* renamed from: a  reason: collision with root package name */
    final a f6706a;

    interface a {
        a.b a(int i10, int i11, int i12, Object obj);

        void b(a.b bVar);
    }

    s(a aVar) {
        this.f6706a = aVar;
    }

    private int a(List<a.b> list) {
        boolean z10 = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).f6459a != 8) {
                z10 = true;
            } else if (z10) {
                return size;
            }
        }
        return -1;
    }

    private void c(List<a.b> list, int i10, a.b bVar, int i11, a.b bVar2) {
        int i12;
        int i13 = bVar.f6462d;
        int i14 = bVar2.f6460b;
        if (i13 < i14) {
            i12 = -1;
        } else {
            i12 = 0;
        }
        int i15 = bVar.f6460b;
        if (i15 < i14) {
            i12++;
        }
        if (i14 <= i15) {
            bVar.f6460b = i15 + bVar2.f6462d;
        }
        int i16 = bVar2.f6460b;
        if (i16 <= i13) {
            bVar.f6462d = i13 + bVar2.f6462d;
        }
        bVar2.f6460b = i16 + i12;
        list.set(i10, bVar2);
        list.set(i11, bVar);
    }

    private void d(List<a.b> list, int i10, int i11) {
        a.b bVar = list.get(i10);
        a.b bVar2 = list.get(i11);
        int i12 = bVar2.f6459a;
        if (i12 == 1) {
            c(list, i10, bVar, i11, bVar2);
        } else if (i12 == 2) {
            e(list, i10, bVar, i11, bVar2);
        } else if (i12 == 4) {
            f(list, i10, bVar, i11, bVar2);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(List<a.b> list) {
        while (true) {
            int a10 = a(list);
            if (a10 != -1) {
                d(list, a10, a10 + 1);
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void e(List<a.b> list, int i10, a.b bVar, int i11, a.b bVar2) {
        boolean z10;
        int i12 = bVar.f6460b;
        int i13 = bVar.f6462d;
        boolean z11 = false;
        if (i12 < i13) {
            if (bVar2.f6460b == i12 && bVar2.f6462d == i13 - i12) {
                z10 = false;
                z11 = true;
            } else {
                z10 = false;
            }
        } else if (bVar2.f6460b == i13 + 1 && bVar2.f6462d == i12 - i13) {
            z10 = true;
            z11 = true;
        } else {
            z10 = true;
        }
        int i14 = bVar2.f6460b;
        if (i13 < i14) {
            bVar2.f6460b = i14 - 1;
        } else {
            int i15 = bVar2.f6462d;
            if (i13 < i14 + i15) {
                bVar2.f6462d = i15 - 1;
                bVar.f6459a = 2;
                bVar.f6462d = 1;
                if (bVar2.f6462d == 0) {
                    list.remove(i11);
                    this.f6706a.b(bVar2);
                    return;
                }
                return;
            }
        }
        int i16 = bVar.f6460b;
        int i17 = bVar2.f6460b;
        a.b bVar3 = null;
        if (i16 <= i17) {
            bVar2.f6460b = i17 + 1;
        } else {
            int i18 = bVar2.f6462d;
            if (i16 < i17 + i18) {
                bVar3 = this.f6706a.a(2, i16 + 1, (i17 + i18) - i16, (Object) null);
                bVar2.f6462d = bVar.f6460b - bVar2.f6460b;
            }
        }
        if (z11) {
            list.set(i10, bVar2);
            list.remove(i11);
            this.f6706a.b(bVar);
            return;
        }
        if (z10) {
            if (bVar3 != null) {
                int i19 = bVar.f6460b;
                if (i19 > bVar3.f6460b) {
                    bVar.f6460b = i19 - bVar3.f6462d;
                }
                int i20 = bVar.f6462d;
                if (i20 > bVar3.f6460b) {
                    bVar.f6462d = i20 - bVar3.f6462d;
                }
            }
            int i21 = bVar.f6460b;
            if (i21 > bVar2.f6460b) {
                bVar.f6460b = i21 - bVar2.f6462d;
            }
            int i22 = bVar.f6462d;
            if (i22 > bVar2.f6460b) {
                bVar.f6462d = i22 - bVar2.f6462d;
            }
        } else {
            if (bVar3 != null) {
                int i23 = bVar.f6460b;
                if (i23 >= bVar3.f6460b) {
                    bVar.f6460b = i23 - bVar3.f6462d;
                }
                int i24 = bVar.f6462d;
                if (i24 >= bVar3.f6460b) {
                    bVar.f6462d = i24 - bVar3.f6462d;
                }
            }
            int i25 = bVar.f6460b;
            if (i25 >= bVar2.f6460b) {
                bVar.f6460b = i25 - bVar2.f6462d;
            }
            int i26 = bVar.f6462d;
            if (i26 >= bVar2.f6460b) {
                bVar.f6462d = i26 - bVar2.f6462d;
            }
        }
        list.set(i10, bVar2);
        if (bVar.f6460b != bVar.f6462d) {
            list.set(i11, bVar);
        } else {
            list.remove(i11);
        }
        if (bVar3 != null) {
            list.add(i10, bVar3);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f(java.util.List<androidx.recyclerview.widget.a.b> r9, int r10, androidx.recyclerview.widget.a.b r11, int r12, androidx.recyclerview.widget.a.b r13) {
        /*
            r8 = this;
            int r0 = r11.f6462d
            int r1 = r13.f6460b
            r2 = 4
            r3 = 0
            r4 = 1
            if (r0 >= r1) goto L_0x000d
            int r1 = r1 - r4
            r13.f6460b = r1
            goto L_0x0020
        L_0x000d:
            int r5 = r13.f6462d
            int r1 = r1 + r5
            if (r0 >= r1) goto L_0x0020
            int r5 = r5 - r4
            r13.f6462d = r5
            androidx.recyclerview.widget.s$a r0 = r8.f6706a
            int r1 = r11.f6460b
            java.lang.Object r5 = r13.f6461c
            androidx.recyclerview.widget.a$b r0 = r0.a(r2, r1, r4, r5)
            goto L_0x0021
        L_0x0020:
            r0 = r3
        L_0x0021:
            int r1 = r11.f6460b
            int r5 = r13.f6460b
            if (r1 > r5) goto L_0x002b
            int r5 = r5 + r4
            r13.f6460b = r5
            goto L_0x0041
        L_0x002b:
            int r6 = r13.f6462d
            int r7 = r5 + r6
            if (r1 >= r7) goto L_0x0041
            int r5 = r5 + r6
            int r5 = r5 - r1
            androidx.recyclerview.widget.s$a r3 = r8.f6706a
            int r1 = r1 + r4
            java.lang.Object r4 = r13.f6461c
            androidx.recyclerview.widget.a$b r3 = r3.a(r2, r1, r5, r4)
            int r1 = r13.f6462d
            int r1 = r1 - r5
            r13.f6462d = r1
        L_0x0041:
            r9.set(r12, r11)
            int r11 = r13.f6462d
            if (r11 <= 0) goto L_0x004c
            r9.set(r10, r13)
            goto L_0x0054
        L_0x004c:
            r9.remove(r10)
            androidx.recyclerview.widget.s$a r11 = r8.f6706a
            r11.b(r13)
        L_0x0054:
            if (r0 == 0) goto L_0x0059
            r9.add(r10, r0)
        L_0x0059:
            if (r3 == 0) goto L_0x005e
            r9.add(r10, r3)
        L_0x005e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.s.f(java.util.List, int, androidx.recyclerview.widget.a$b, int, androidx.recyclerview.widget.a$b):void");
    }
}
