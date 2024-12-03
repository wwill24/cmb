package mh;

import com.coffeemeetsbagel.models.Height;
import com.google.zxing.datamatrix.encoder.SymbolShapeHint;
import gh.a;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

public class d {

    /* renamed from: i  reason: collision with root package name */
    static final d[] f23786i;

    /* renamed from: j  reason: collision with root package name */
    private static d[] f23787j;

    /* renamed from: a  reason: collision with root package name */
    private final boolean f23788a;

    /* renamed from: b  reason: collision with root package name */
    private final int f23789b;

    /* renamed from: c  reason: collision with root package name */
    private final int f23790c;

    /* renamed from: d  reason: collision with root package name */
    public final int f23791d;

    /* renamed from: e  reason: collision with root package name */
    public final int f23792e;

    /* renamed from: f  reason: collision with root package name */
    private final int f23793f;

    /* renamed from: g  reason: collision with root package name */
    private final int f23794g;

    /* renamed from: h  reason: collision with root package name */
    private final int f23795h;

    static {
        d[] dVarArr = {new d(false, 3, 5, 8, 8, 1), new d(false, 5, 7, 10, 10, 1), new d(true, 5, 7, 16, 6, 1), new d(false, 8, 10, 12, 12, 1), new d(true, 10, 11, 14, 6, 2), new d(false, 12, 12, 14, 14, 1), new d(true, 16, 14, 24, 10, 1), new d(false, 18, 14, 16, 16, 1), new d(false, 22, 18, 18, 18, 1), new d(true, 22, 18, 16, 10, 2), new d(false, 30, 20, 20, 20, 1), new d(true, 32, 24, 16, 14, 2), new d(false, 36, 24, 22, 22, 1), new d(false, 44, 28, 24, 24, 1), new d(true, 49, 28, 22, 14, 2), new d(false, 62, 36, 14, 14, 4), new d(false, 86, 42, 16, 16, 4), new d(false, 114, 48, 18, 18, 4), new d(false, Opcodes.D2F, 56, 20, 20, 4), new d(false, Opcodes.FRETURN, 68, 22, 22, 4), new d(false, 204, 84, 24, 24, 4, 102, 42), new d(false, 280, 112, 14, 14, 16, Opcodes.F2L, 56), new d(false, 368, Opcodes.D2F, 16, 16, 16, 92, 36), new d(false, 456, 192, 18, 18, 16, 114, 48), new d(false, 576, 224, 20, 20, 16, Opcodes.D2F, 56), new d(false, 696, Height.CENTIMETRES_MAX, 22, 22, 16, Opcodes.FRETURN, 68), new d(false, 816, 336, 24, 24, 16, 136, 56), new d(false, 1050, 408, 18, 18, 36, Opcodes.DRETURN, 68), new d(false, 1304, 496, 20, 20, 36, Opcodes.IF_ICMPGT, 62), new a()};
        f23786i = dVarArr;
        f23787j = dVarArr;
    }

    public d(boolean z10, int i10, int i11, int i12, int i13, int i14) {
        this(z10, i10, i11, i12, i13, i14, i10, i11);
    }

    private int e() {
        int i10 = this.f23793f;
        int i11 = 1;
        if (i10 != 1) {
            i11 = 2;
            if (!(i10 == 2 || i10 == 4)) {
                if (i10 == 16) {
                    return 4;
                }
                if (i10 == 36) {
                    return 6;
                }
                throw new IllegalStateException("Cannot handle this number of data regions");
            }
        }
        return i11;
    }

    private int k() {
        int i10 = this.f23793f;
        if (i10 == 1 || i10 == 2) {
            return 1;
        }
        if (i10 == 4) {
            return 2;
        }
        if (i10 == 16) {
            return 4;
        }
        if (i10 == 36) {
            return 6;
        }
        throw new IllegalStateException("Cannot handle this number of data regions");
    }

    public static d l(int i10, SymbolShapeHint symbolShapeHint, a aVar, a aVar2, boolean z10) {
        for (d dVar : f23787j) {
            if ((symbolShapeHint != SymbolShapeHint.FORCE_SQUARE || !dVar.f23788a) && ((symbolShapeHint != SymbolShapeHint.FORCE_RECTANGLE || dVar.f23788a) && ((aVar == null || (dVar.j() >= aVar.b() && dVar.i() >= aVar.a())) && ((aVar2 == null || (dVar.j() <= aVar2.b() && dVar.i() <= aVar2.a())) && i10 <= dVar.f23789b)))) {
                return dVar;
            }
        }
        if (!z10) {
            return null;
        }
        throw new IllegalArgumentException("Can't find a symbol arrangement that matches the message. Data codewords: " + i10);
    }

    public final int a() {
        return this.f23789b;
    }

    public int b(int i10) {
        return this.f23794g;
    }

    public final int c() {
        return this.f23790c;
    }

    public final int d(int i10) {
        return this.f23795h;
    }

    public int f() {
        return this.f23789b / this.f23794g;
    }

    public final int g() {
        return k() * this.f23792e;
    }

    public final int h() {
        return e() * this.f23791d;
    }

    public final int i() {
        return g() + (k() * 2);
    }

    public final int j() {
        return h() + (e() * 2);
    }

    public final String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        if (this.f23788a) {
            str = "Rectangular Symbol:";
        } else {
            str = "Square Symbol:";
        }
        sb2.append(str);
        sb2.append(" data region ");
        sb2.append(this.f23791d);
        sb2.append('x');
        sb2.append(this.f23792e);
        sb2.append(", symbol size ");
        sb2.append(j());
        sb2.append('x');
        sb2.append(i());
        sb2.append(", symbol data size ");
        sb2.append(h());
        sb2.append('x');
        sb2.append(g());
        sb2.append(", codewords ");
        sb2.append(this.f23789b);
        sb2.append(SignatureVisitor.EXTENDS);
        sb2.append(this.f23790c);
        return sb2.toString();
    }

    d(boolean z10, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        this.f23788a = z10;
        this.f23789b = i10;
        this.f23790c = i11;
        this.f23791d = i12;
        this.f23792e = i13;
        this.f23793f = i14;
        this.f23794g = i15;
        this.f23795h = i16;
    }
}
