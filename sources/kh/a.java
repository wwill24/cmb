package kh;

import net.bytebuddy.jar.asm.Opcodes;
import org.apache.commons.beanutils.PropertyUtils;

public final class a {

    /* renamed from: h  reason: collision with root package name */
    public static final a f23608h = new a(4201, Opcodes.ACC_SYNTHETIC, 1);

    /* renamed from: i  reason: collision with root package name */
    public static final a f23609i = new a(1033, 1024, 1);

    /* renamed from: j  reason: collision with root package name */
    public static final a f23610j;

    /* renamed from: k  reason: collision with root package name */
    public static final a f23611k = new a(19, 16, 1);

    /* renamed from: l  reason: collision with root package name */
    public static final a f23612l = new a(285, 256, 0);

    /* renamed from: m  reason: collision with root package name */
    public static final a f23613m;

    /* renamed from: n  reason: collision with root package name */
    public static final a f23614n;

    /* renamed from: o  reason: collision with root package name */
    public static final a f23615o;

    /* renamed from: a  reason: collision with root package name */
    private final int[] f23616a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f23617b;

    /* renamed from: c  reason: collision with root package name */
    private final b f23618c;

    /* renamed from: d  reason: collision with root package name */
    private final b f23619d;

    /* renamed from: e  reason: collision with root package name */
    private final int f23620e;

    /* renamed from: f  reason: collision with root package name */
    private final int f23621f;

    /* renamed from: g  reason: collision with root package name */
    private final int f23622g;

    static {
        a aVar = new a(67, 64, 1);
        f23610j = aVar;
        a aVar2 = new a(301, 256, 1);
        f23613m = aVar2;
        f23614n = aVar2;
        f23615o = aVar;
    }

    public a(int i10, int i11, int i12) {
        this.f23621f = i10;
        this.f23620e = i11;
        this.f23622g = i12;
        this.f23616a = new int[i11];
        this.f23617b = new int[i11];
        int i13 = 1;
        for (int i14 = 0; i14 < i11; i14++) {
            this.f23616a[i14] = i13;
            i13 *= 2;
            if (i13 >= i11) {
                i13 = (i13 ^ i10) & (i11 - 1);
            }
        }
        for (int i15 = 0; i15 < i11 - 1; i15++) {
            this.f23617b[this.f23616a[i15]] = i15;
        }
        this.f23618c = new b(this, new int[]{0});
        this.f23619d = new b(this, new int[]{1});
    }

    static int a(int i10, int i11) {
        return i10 ^ i11;
    }

    /* access modifiers changed from: package-private */
    public b b(int i10, int i11) {
        if (i10 < 0) {
            throw new IllegalArgumentException();
        } else if (i11 == 0) {
            return this.f23618c;
        } else {
            int[] iArr = new int[(i10 + 1)];
            iArr[0] = i11;
            return new b(this, iArr);
        }
    }

    /* access modifiers changed from: package-private */
    public int c(int i10) {
        return this.f23616a[i10];
    }

    public int d() {
        return this.f23622g;
    }

    /* access modifiers changed from: package-private */
    public b e() {
        return this.f23618c;
    }

    /* access modifiers changed from: package-private */
    public int f(int i10) {
        if (i10 != 0) {
            return this.f23616a[(this.f23620e - this.f23617b[i10]) - 1];
        }
        throw new ArithmeticException();
    }

    /* access modifiers changed from: package-private */
    public int g(int i10) {
        if (i10 != 0) {
            return this.f23617b[i10];
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: package-private */
    public int h(int i10, int i11) {
        if (i10 == 0 || i11 == 0) {
            return 0;
        }
        int[] iArr = this.f23616a;
        int[] iArr2 = this.f23617b;
        return iArr[(iArr2[i10] + iArr2[i11]) % (this.f23620e - 1)];
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.f23621f) + ',' + this.f23620e + PropertyUtils.MAPPED_DELIM2;
    }
}
