package nc;

import android.content.res.Resources;
import com.leanplum.messagetemplates.MessageTemplateConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.j;
import net.bytebuddy.jar.asm.Opcodes;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f41301a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f41302b = {8, 16, 40, 80, 160, 240, 320, 400};

    /* renamed from: c  reason: collision with root package name */
    private final int[] f41303c = {5, 10, 25, 50, 100, Opcodes.FCMPG, 200, MessageTemplateConstants.Values.CENTER_POPUP_HEIGHT};

    public d(Resources resources) {
        j.g(resources, "resources");
        this.f41301a = resources;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0048  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a(boolean r7, int r8, boolean r9) {
        /*
            r6 = this;
            r0 = -1
            r1 = 1
            r2 = 0
            if (r9 == 0) goto L_0x0018
            int[] r9 = r6.f41302b
            int r3 = r9.length
            r4 = r2
        L_0x0009:
            if (r4 >= r3) goto L_0x002c
            r5 = r9[r4]
            if (r5 < r8) goto L_0x0011
            r5 = r1
            goto L_0x0012
        L_0x0011:
            r5 = r2
        L_0x0012:
            if (r5 == 0) goto L_0x0015
            goto L_0x0027
        L_0x0015:
            int r4 = r4 + 1
            goto L_0x0009
        L_0x0018:
            int[] r9 = r6.f41303c
            int r3 = r9.length
            r4 = r2
        L_0x001c:
            if (r4 >= r3) goto L_0x002c
            r5 = r9[r4]
            if (r5 < r8) goto L_0x0024
            r5 = r1
            goto L_0x0025
        L_0x0024:
            r5 = r2
        L_0x0025:
            if (r5 == 0) goto L_0x0029
        L_0x0027:
            r0 = r4
            goto L_0x002c
        L_0x0029:
            int r4 = r4 + 1
            goto L_0x001c
        L_0x002c:
            java.lang.String r8 = "{\n            resources.…anonicalIndex])\n        }"
            if (r7 == 0) goto L_0x0048
            android.content.res.Resources r7 = r6.f41301a
            int r9 = nc.e.distance_km
            java.lang.Object[] r1 = new java.lang.Object[r1]
            int[] r3 = r6.f41302b
            r0 = r3[r0]
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1[r2] = r0
            java.lang.String r7 = r7.getString(r9, r1)
            kotlin.jvm.internal.j.f(r7, r8)
            goto L_0x005f
        L_0x0048:
            android.content.res.Resources r7 = r6.f41301a
            int r9 = nc.e.distance_miles
            java.lang.Object[] r1 = new java.lang.Object[r1]
            int[] r3 = r6.f41303c
            r0 = r3[r0]
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1[r2] = r0
            java.lang.String r7 = r7.getString(r9, r1)
            kotlin.jvm.internal.j.f(r7, r8)
        L_0x005f:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: nc.d.a(boolean, int, boolean):java.lang.String");
    }

    public final List<String> b(boolean z10) {
        int[] iArr;
        String str;
        if (z10) {
            iArr = this.f41302b;
        } else {
            iArr = this.f41303c;
        }
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i10 : iArr) {
            if (z10) {
                str = this.f41301a.getString(e.distance_km, new Object[]{Integer.valueOf(i10)});
            } else {
                str = this.f41301a.getString(e.distance_miles, new Object[]{Integer.valueOf(i10)});
            }
            arrayList.add(str);
        }
        return arrayList;
    }

    public final int c(int i10, boolean z10) {
        int i11;
        boolean z11;
        boolean z12;
        if (z10) {
            int[] iArr = this.f41302b;
            int length = iArr.length;
            i11 = 0;
            while (i11 < length) {
                if (iArr[i11] >= i10) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (!z12) {
                    i11++;
                }
            }
            return -1;
        }
        int[] iArr2 = this.f41303c;
        int length2 = iArr2.length;
        int i12 = 0;
        while (i11 < length2) {
            if (iArr2[i11] >= i10) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                i12 = i11 + 1;
            }
        }
        return -1;
        return i11;
    }

    public final int d(int i10) {
        return this.f41302b[i10];
    }

    public final int e() {
        return l.B(this.f41302b);
    }

    public final int f(int i10) {
        return this.f41303c[i10];
    }
}
