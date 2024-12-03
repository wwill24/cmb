package androidx.constraintlayout.core;

import java.util.Arrays;
import java.util.HashSet;

public class SolverVariable implements Comparable<SolverVariable> {

    /* renamed from: x  reason: collision with root package name */
    private static int f3637x = 1;

    /* renamed from: a  reason: collision with root package name */
    public boolean f3638a;

    /* renamed from: b  reason: collision with root package name */
    private String f3639b;

    /* renamed from: c  reason: collision with root package name */
    public int f3640c = -1;

    /* renamed from: d  reason: collision with root package name */
    int f3641d = -1;

    /* renamed from: e  reason: collision with root package name */
    public int f3642e = 0;

    /* renamed from: f  reason: collision with root package name */
    public float f3643f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f3644g = false;

    /* renamed from: h  reason: collision with root package name */
    float[] f3645h = new float[9];

    /* renamed from: j  reason: collision with root package name */
    float[] f3646j = new float[9];

    /* renamed from: k  reason: collision with root package name */
    Type f3647k;

    /* renamed from: l  reason: collision with root package name */
    b[] f3648l = new b[16];

    /* renamed from: m  reason: collision with root package name */
    int f3649m = 0;

    /* renamed from: n  reason: collision with root package name */
    public int f3650n = 0;

    /* renamed from: p  reason: collision with root package name */
    boolean f3651p = false;

    /* renamed from: q  reason: collision with root package name */
    int f3652q = -1;

    /* renamed from: t  reason: collision with root package name */
    float f3653t = 0.0f;

    /* renamed from: w  reason: collision with root package name */
    HashSet<b> f3654w = null;

    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public SolverVariable(Type type, String str) {
        this.f3647k = type;
    }

    static void c() {
        f3637x++;
    }

    public final void a(b bVar) {
        int i10 = 0;
        while (true) {
            int i11 = this.f3649m;
            if (i10 >= i11) {
                b[] bVarArr = this.f3648l;
                if (i11 >= bVarArr.length) {
                    this.f3648l = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.f3648l;
                int i12 = this.f3649m;
                bVarArr2[i12] = bVar;
                this.f3649m = i12 + 1;
                return;
            } else if (this.f3648l[i10] != bVar) {
                i10++;
            } else {
                return;
            }
        }
    }

    /* renamed from: b */
    public int compareTo(SolverVariable solverVariable) {
        return this.f3640c - solverVariable.f3640c;
    }

    public final void d(b bVar) {
        int i10 = this.f3649m;
        int i11 = 0;
        while (i11 < i10) {
            if (this.f3648l[i11] == bVar) {
                while (i11 < i10 - 1) {
                    b[] bVarArr = this.f3648l;
                    int i12 = i11 + 1;
                    bVarArr[i11] = bVarArr[i12];
                    i11 = i12;
                }
                this.f3649m--;
                return;
            }
            i11++;
        }
    }

    public void e() {
        this.f3639b = null;
        this.f3647k = Type.UNKNOWN;
        this.f3642e = 0;
        this.f3640c = -1;
        this.f3641d = -1;
        this.f3643f = 0.0f;
        this.f3644g = false;
        this.f3651p = false;
        this.f3652q = -1;
        this.f3653t = 0.0f;
        int i10 = this.f3649m;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f3648l[i11] = null;
        }
        this.f3649m = 0;
        this.f3650n = 0;
        this.f3638a = false;
        Arrays.fill(this.f3646j, 0.0f);
    }

    public void h(d dVar, float f10) {
        this.f3643f = f10;
        this.f3644g = true;
        this.f3651p = false;
        this.f3652q = -1;
        this.f3653t = 0.0f;
        int i10 = this.f3649m;
        this.f3641d = -1;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f3648l[i11].A(dVar, this, false);
        }
        this.f3649m = 0;
    }

    public void i(Type type, String str) {
        this.f3647k = type;
    }

    public final void j(d dVar, b bVar) {
        int i10 = this.f3649m;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f3648l[i11].B(dVar, bVar, false);
        }
        this.f3649m = 0;
    }

    public String toString() {
        if (this.f3639b != null) {
            return "" + this.f3639b;
        }
        return "" + this.f3640c;
    }
}
