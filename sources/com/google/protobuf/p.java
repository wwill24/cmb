package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.WireFormat;
import com.google.protobuf.l0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class p extends o<GeneratedMessageLite.d> {

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f21927a;

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|(3:35|36|38)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(38:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|38) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.protobuf.WireFormat$FieldType[] r0 = com.google.protobuf.WireFormat.FieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f21927a = r0
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f21927a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f21927a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f21927a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f21927a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f21927a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f21927a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f21927a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.BOOL     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f21927a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f21927a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f21927a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f21927a     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f21927a     // Catch:{ NoSuchFieldError -> 0x009c }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f21927a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f21927a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.BYTES     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f21927a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = f21927a     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.GROUP     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r0 = f21927a     // Catch:{ NoSuchFieldError -> 0x00d8 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.p.a.<clinit>():void");
        }
    }

    p() {
    }

    /* access modifiers changed from: package-private */
    public int a(Map.Entry<?, ?> entry) {
        return ((GeneratedMessageLite.d) entry.getKey()).getNumber();
    }

    /* access modifiers changed from: package-private */
    public Object b(n nVar, l0 l0Var, int i10) {
        return nVar.a(l0Var, i10);
    }

    /* access modifiers changed from: package-private */
    public s<GeneratedMessageLite.d> c(Object obj) {
        return ((GeneratedMessageLite.c) obj).extensions;
    }

    /* access modifiers changed from: package-private */
    public s<GeneratedMessageLite.d> d(Object obj) {
        return ((GeneratedMessageLite.c) obj).a();
    }

    /* access modifiers changed from: package-private */
    public boolean e(l0 l0Var) {
        return l0Var instanceof GeneratedMessageLite.c;
    }

    /* access modifiers changed from: package-private */
    public void f(Object obj) {
        c(obj).u();
    }

    /* access modifiers changed from: package-private */
    public <UT, UB> UB g(Object obj, y0 y0Var, Object obj2, n nVar, s<GeneratedMessageLite.d> sVar, UB ub2, f1<UT, UB> f1Var) throws IOException {
        Object i10;
        ArrayList arrayList;
        GeneratedMessageLite.e eVar = (GeneratedMessageLite.e) obj2;
        int d10 = eVar.d();
        if (!eVar.f21678d.f() || !eVar.f21678d.n()) {
            Object obj3 = null;
            if (eVar.b() != WireFormat.FieldType.ENUM) {
                switch (a.f21927a[eVar.b().ordinal()]) {
                    case 1:
                        obj3 = Double.valueOf(y0Var.readDouble());
                        break;
                    case 2:
                        obj3 = Float.valueOf(y0Var.readFloat());
                        break;
                    case 3:
                        obj3 = Long.valueOf(y0Var.H());
                        break;
                    case 4:
                        obj3 = Long.valueOf(y0Var.s());
                        break;
                    case 5:
                        obj3 = Integer.valueOf(y0Var.p());
                        break;
                    case 6:
                        obj3 = Long.valueOf(y0Var.b());
                        break;
                    case 7:
                        obj3 = Integer.valueOf(y0Var.u());
                        break;
                    case 8:
                        obj3 = Boolean.valueOf(y0Var.e());
                        break;
                    case 9:
                        obj3 = Integer.valueOf(y0Var.h());
                        break;
                    case 10:
                        obj3 = Integer.valueOf(y0Var.E());
                        break;
                    case 11:
                        obj3 = Long.valueOf(y0Var.f());
                        break;
                    case 12:
                        obj3 = Integer.valueOf(y0Var.l());
                        break;
                    case 13:
                        obj3 = Long.valueOf(y0Var.y());
                        break;
                    case 14:
                        throw new IllegalStateException("Shouldn't reach here.");
                    case 15:
                        obj3 = y0Var.o();
                        break;
                    case 16:
                        obj3 = y0Var.z();
                        break;
                    case 17:
                        if (!eVar.e()) {
                            Object i11 = sVar.i(eVar.f21678d);
                            if (i11 instanceof GeneratedMessageLite) {
                                z0 d11 = v0.a().d(i11);
                                if (!((GeneratedMessageLite) i11).isMutable()) {
                                    Object newInstance = d11.newInstance();
                                    d11.a(newInstance, i11);
                                    sVar.y(eVar.f21678d, newInstance);
                                    i11 = newInstance;
                                }
                                y0Var.O(i11, d11, nVar);
                                return ub2;
                            }
                        }
                        obj3 = y0Var.L(eVar.c().getClass(), nVar);
                        break;
                    case 18:
                        if (!eVar.e()) {
                            Object i12 = sVar.i(eVar.f21678d);
                            if (i12 instanceof GeneratedMessageLite) {
                                z0 d12 = v0.a().d(i12);
                                if (!((GeneratedMessageLite) i12).isMutable()) {
                                    Object newInstance2 = d12.newInstance();
                                    d12.a(newInstance2, i12);
                                    sVar.y(eVar.f21678d, newInstance2);
                                    i12 = newInstance2;
                                }
                                y0Var.P(i12, d12, nVar);
                                return ub2;
                            }
                        }
                        obj3 = y0Var.N(eVar.c().getClass(), nVar);
                        break;
                }
            } else {
                int p10 = y0Var.p();
                if (eVar.f21678d.b().findValueByNumber(p10) == null) {
                    return b1.L(obj, d10, p10, ub2, f1Var);
                }
                obj3 = Integer.valueOf(p10);
            }
            if (eVar.e()) {
                sVar.a(eVar.f21678d, obj3);
            } else {
                int i13 = a.f21927a[eVar.b().ordinal()];
                if ((i13 == 17 || i13 == 18) && (i10 = sVar.i(eVar.f21678d)) != null) {
                    obj3 = w.h(i10, obj3);
                }
                sVar.y(eVar.f21678d, obj3);
            }
        } else {
            switch (a.f21927a[eVar.b().ordinal()]) {
                case 1:
                    arrayList = new ArrayList();
                    y0Var.G(arrayList);
                    break;
                case 2:
                    arrayList = new ArrayList();
                    y0Var.C(arrayList);
                    break;
                case 3:
                    arrayList = new ArrayList();
                    y0Var.i(arrayList);
                    break;
                case 4:
                    arrayList = new ArrayList();
                    y0Var.g(arrayList);
                    break;
                case 5:
                    arrayList = new ArrayList();
                    y0Var.w(arrayList);
                    break;
                case 6:
                    arrayList = new ArrayList();
                    y0Var.q(arrayList);
                    break;
                case 7:
                    arrayList = new ArrayList();
                    y0Var.x(arrayList);
                    break;
                case 8:
                    arrayList = new ArrayList();
                    y0Var.m(arrayList);
                    break;
                case 9:
                    arrayList = new ArrayList();
                    y0Var.t(arrayList);
                    break;
                case 10:
                    arrayList = new ArrayList();
                    y0Var.c(arrayList);
                    break;
                case 11:
                    arrayList = new ArrayList();
                    y0Var.v(arrayList);
                    break;
                case 12:
                    arrayList = new ArrayList();
                    y0Var.r(arrayList);
                    break;
                case 13:
                    arrayList = new ArrayList();
                    y0Var.d(arrayList);
                    break;
                case 14:
                    arrayList = new ArrayList();
                    y0Var.j(arrayList);
                    ub2 = b1.z(obj, d10, arrayList, eVar.f21678d.b(), ub2, f1Var);
                    break;
                default:
                    throw new IllegalStateException("Type cannot be packed: " + eVar.f21678d.g());
            }
            sVar.y(eVar.f21678d, arrayList);
        }
        return ub2;
    }

    /* access modifiers changed from: package-private */
    public void h(y0 y0Var, Object obj, n nVar, s<GeneratedMessageLite.d> sVar) throws IOException {
        GeneratedMessageLite.e eVar = (GeneratedMessageLite.e) obj;
        sVar.y(eVar.f21678d, y0Var.N(eVar.c().getClass(), nVar));
    }

    /* access modifiers changed from: package-private */
    public void i(ByteString byteString, Object obj, n nVar, s<GeneratedMessageLite.d> sVar) throws IOException {
        GeneratedMessageLite.e eVar = (GeneratedMessageLite.e) obj;
        l0.a newBuilderForType = eVar.c().newBuilderForType();
        h D = byteString.D();
        newBuilderForType.mergeFrom(D, nVar);
        sVar.y(eVar.f21678d, newBuilderForType.buildPartial());
        D.a(0);
    }

    /* access modifiers changed from: package-private */
    public void j(Writer writer, Map.Entry<?, ?> entry) throws IOException {
        GeneratedMessageLite.d dVar = (GeneratedMessageLite.d) entry.getKey();
        if (dVar.f()) {
            switch (a.f21927a[dVar.g().ordinal()]) {
                case 1:
                    b1.P(dVar.getNumber(), (List) entry.getValue(), writer, dVar.n());
                    return;
                case 2:
                    b1.T(dVar.getNumber(), (List) entry.getValue(), writer, dVar.n());
                    return;
                case 3:
                    b1.W(dVar.getNumber(), (List) entry.getValue(), writer, dVar.n());
                    return;
                case 4:
                    b1.e0(dVar.getNumber(), (List) entry.getValue(), writer, dVar.n());
                    return;
                case 5:
                    b1.V(dVar.getNumber(), (List) entry.getValue(), writer, dVar.n());
                    return;
                case 6:
                    b1.S(dVar.getNumber(), (List) entry.getValue(), writer, dVar.n());
                    return;
                case 7:
                    b1.R(dVar.getNumber(), (List) entry.getValue(), writer, dVar.n());
                    return;
                case 8:
                    b1.N(dVar.getNumber(), (List) entry.getValue(), writer, dVar.n());
                    return;
                case 9:
                    b1.d0(dVar.getNumber(), (List) entry.getValue(), writer, dVar.n());
                    return;
                case 10:
                    b1.Y(dVar.getNumber(), (List) entry.getValue(), writer, dVar.n());
                    return;
                case 11:
                    b1.Z(dVar.getNumber(), (List) entry.getValue(), writer, dVar.n());
                    return;
                case 12:
                    b1.a0(dVar.getNumber(), (List) entry.getValue(), writer, dVar.n());
                    return;
                case 13:
                    b1.b0(dVar.getNumber(), (List) entry.getValue(), writer, dVar.n());
                    return;
                case 14:
                    b1.V(dVar.getNumber(), (List) entry.getValue(), writer, dVar.n());
                    return;
                case 15:
                    b1.O(dVar.getNumber(), (List) entry.getValue(), writer);
                    return;
                case 16:
                    b1.c0(dVar.getNumber(), (List) entry.getValue(), writer);
                    return;
                case 17:
                    List list = (List) entry.getValue();
                    if (list != null && !list.isEmpty()) {
                        b1.U(dVar.getNumber(), (List) entry.getValue(), writer, v0.a().c(list.get(0).getClass()));
                        return;
                    }
                    return;
                case 18:
                    List list2 = (List) entry.getValue();
                    if (list2 != null && !list2.isEmpty()) {
                        b1.X(dVar.getNumber(), (List) entry.getValue(), writer, v0.a().c(list2.get(0).getClass()));
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else {
            switch (a.f21927a[dVar.g().ordinal()]) {
                case 1:
                    writer.p(dVar.getNumber(), ((Double) entry.getValue()).doubleValue());
                    return;
                case 2:
                    writer.B(dVar.getNumber(), ((Float) entry.getValue()).floatValue());
                    return;
                case 3:
                    writer.u(dVar.getNumber(), ((Long) entry.getValue()).longValue());
                    return;
                case 4:
                    writer.f(dVar.getNumber(), ((Long) entry.getValue()).longValue());
                    return;
                case 5:
                    writer.h(dVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    return;
                case 6:
                    writer.s(dVar.getNumber(), ((Long) entry.getValue()).longValue());
                    return;
                case 7:
                    writer.c(dVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    return;
                case 8:
                    writer.v(dVar.getNumber(), ((Boolean) entry.getValue()).booleanValue());
                    return;
                case 9:
                    writer.o(dVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    return;
                case 10:
                    writer.w(dVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    return;
                case 11:
                    writer.i(dVar.getNumber(), ((Long) entry.getValue()).longValue());
                    return;
                case 12:
                    writer.H(dVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    return;
                case 13:
                    writer.m(dVar.getNumber(), ((Long) entry.getValue()).longValue());
                    return;
                case 14:
                    writer.h(dVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    return;
                case 15:
                    writer.L(dVar.getNumber(), (ByteString) entry.getValue());
                    return;
                case 16:
                    writer.e(dVar.getNumber(), (String) entry.getValue());
                    return;
                case 17:
                    writer.K(dVar.getNumber(), entry.getValue(), v0.a().c(entry.getValue().getClass()));
                    return;
                case 18:
                    writer.N(dVar.getNumber(), entry.getValue(), v0.a().c(entry.getValue().getClass()));
                    return;
                default:
                    return;
            }
        }
    }
}
