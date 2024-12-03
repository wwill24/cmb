package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.converter.zaa;
import com.mparticle.kits.AppsFlyerKit;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import me.c;
import me.n;
import me.o;

public abstract class FastJsonResponse {

    public interface a<I, O> {
        Object E(@NonNull Object obj);

        @NonNull
        Object u(@NonNull Object obj);
    }

    @NonNull
    protected static final Object zaD(@NonNull Field field, Object obj) {
        if (field.f39152l != null) {
            return field.H0(obj);
        }
        return obj;
    }

    private final void zaE(Field field, Object obj) {
        String str = field.f39147f;
        Object E0 = field.E0(obj);
        int i10 = field.f39145d;
        switch (i10) {
            case 0:
                if (E0 != null) {
                    setIntegerInternal(field, str, ((Integer) E0).intValue());
                    return;
                } else {
                    zaG(str);
                    return;
                }
            case 1:
                zaf(field, str, (BigInteger) E0);
                return;
            case 2:
                if (E0 != null) {
                    setLongInternal(field, str, ((Long) E0).longValue());
                    return;
                } else {
                    zaG(str);
                    return;
                }
            case 4:
                if (E0 != null) {
                    zan(field, str, ((Double) E0).doubleValue());
                    return;
                } else {
                    zaG(str);
                    return;
                }
            case 5:
                zab(field, str, (BigDecimal) E0);
                return;
            case 6:
                if (E0 != null) {
                    setBooleanInternal(field, str, ((Boolean) E0).booleanValue());
                    return;
                } else {
                    zaG(str);
                    return;
                }
            case 7:
                setStringInternal(field, str, (String) E0);
                return;
            case 8:
            case 9:
                if (E0 != null) {
                    setDecodedBytesInternal(field, str, (byte[]) E0);
                    return;
                } else {
                    zaG(str);
                    return;
                }
            default:
                throw new IllegalStateException("Unsupported type for conversion: " + i10);
        }
    }

    private static final void zaF(StringBuilder sb2, Field field, Object obj) {
        int i10 = field.f39143b;
        if (i10 == 11) {
            Class cls = field.f39149h;
            p.k(cls);
            sb2.append(((FastJsonResponse) cls.cast(obj)).toString());
        } else if (i10 == 7) {
            sb2.append("\"");
            sb2.append(n.a((String) obj));
            sb2.append("\"");
        } else {
            sb2.append(obj);
        }
    }

    private static final void zaG(String str) {
        if (Log.isLoggable("FastJsonResponse", 6)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Output field (");
            sb2.append(str);
            sb2.append(") has a null value, but expected a primitive");
        }
    }

    public <T extends FastJsonResponse> void addConcreteTypeArrayInternal(@NonNull Field field, @NonNull String str, ArrayList<T> arrayList) {
        throw new UnsupportedOperationException("Concrete type array not supported");
    }

    public <T extends FastJsonResponse> void addConcreteTypeInternal(@NonNull Field field, @NonNull String str, @NonNull T t10) {
        throw new UnsupportedOperationException("Concrete type not supported");
    }

    @NonNull
    public abstract Map<String, Field<?, ?>> getFieldMappings();

    /* access modifiers changed from: protected */
    public Object getFieldValue(@NonNull Field field) {
        boolean z10;
        String str = field.f39147f;
        if (field.f39149h == null) {
            return getValueObject(str);
        }
        if (getValueObject(str) == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        p.q(z10, "Concrete field shouldn't be value object: %s", field.f39147f);
        try {
            return getClass().getMethod("get" + Character.toUpperCase(str.charAt(0)) + str.substring(1), new Class[0]).invoke(this, new Object[0]);
        } catch (Exception e10) {
            throw new RuntimeException(e10);
        }
    }

    /* access modifiers changed from: protected */
    public abstract Object getValueObject(@NonNull String str);

    /* access modifiers changed from: protected */
    public boolean isFieldSet(@NonNull Field field) {
        if (field.f39145d != 11) {
            return isPrimitiveFieldSet(field.f39147f);
        }
        if (field.f39146e) {
            throw new UnsupportedOperationException("Concrete type arrays not supported");
        }
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    /* access modifiers changed from: protected */
    public abstract boolean isPrimitiveFieldSet(@NonNull String str);

    /* access modifiers changed from: protected */
    public void setBooleanInternal(@NonNull Field<?, ?> field, @NonNull String str, boolean z10) {
        throw new UnsupportedOperationException("Boolean not supported");
    }

    /* access modifiers changed from: protected */
    public void setDecodedBytesInternal(@NonNull Field<?, ?> field, @NonNull String str, byte[] bArr) {
        throw new UnsupportedOperationException("byte[] not supported");
    }

    /* access modifiers changed from: protected */
    public void setIntegerInternal(@NonNull Field<?, ?> field, @NonNull String str, int i10) {
        throw new UnsupportedOperationException("Integer not supported");
    }

    /* access modifiers changed from: protected */
    public void setLongInternal(@NonNull Field<?, ?> field, @NonNull String str, long j10) {
        throw new UnsupportedOperationException("Long not supported");
    }

    /* access modifiers changed from: protected */
    public void setStringInternal(@NonNull Field<?, ?> field, @NonNull String str, String str2) {
        throw new UnsupportedOperationException("String not supported");
    }

    /* access modifiers changed from: protected */
    public void setStringMapInternal(@NonNull Field<?, ?> field, @NonNull String str, Map<String, String> map) {
        throw new UnsupportedOperationException("String map not supported");
    }

    /* access modifiers changed from: protected */
    public void setStringsInternal(@NonNull Field<?, ?> field, @NonNull String str, ArrayList<String> arrayList) {
        throw new UnsupportedOperationException("String list not supported");
    }

    @NonNull
    public String toString() {
        Map<String, Field<?, ?>> fieldMappings = getFieldMappings();
        StringBuilder sb2 = new StringBuilder(100);
        for (String next : fieldMappings.keySet()) {
            Field field = fieldMappings.get(next);
            if (isFieldSet(field)) {
                Object zaD = zaD(field, getFieldValue(field));
                if (sb2.length() == 0) {
                    sb2.append("{");
                } else {
                    sb2.append(AppsFlyerKit.COMMA);
                }
                sb2.append("\"");
                sb2.append(next);
                sb2.append("\":");
                if (zaD != null) {
                    switch (field.f39145d) {
                        case 8:
                            sb2.append("\"");
                            sb2.append(c.c((byte[]) zaD));
                            sb2.append("\"");
                            break;
                        case 9:
                            sb2.append("\"");
                            sb2.append(c.d((byte[]) zaD));
                            sb2.append("\"");
                            break;
                        case 10:
                            o.a(sb2, (HashMap) zaD);
                            break;
                        default:
                            if (!field.f39144c) {
                                zaF(sb2, field, zaD);
                                break;
                            } else {
                                ArrayList arrayList = (ArrayList) zaD;
                                sb2.append("[");
                                int size = arrayList.size();
                                for (int i10 = 0; i10 < size; i10++) {
                                    if (i10 > 0) {
                                        sb2.append(AppsFlyerKit.COMMA);
                                    }
                                    Object obj = arrayList.get(i10);
                                    if (obj != null) {
                                        zaF(sb2, field, obj);
                                    }
                                }
                                sb2.append("]");
                                break;
                            }
                    }
                } else {
                    sb2.append("null");
                }
            }
        }
        if (sb2.length() > 0) {
            sb2.append("}");
        } else {
            sb2.append("{}");
        }
        return sb2.toString();
    }

    public final void zaA(@NonNull Field field, String str) {
        if (field.f39152l != null) {
            zaE(field, str);
        } else {
            setStringInternal(field, field.f39147f, str);
        }
    }

    public final void zaB(@NonNull Field field, Map map) {
        if (field.f39152l != null) {
            zaE(field, map);
        } else {
            setStringMapInternal(field, field.f39147f, map);
        }
    }

    public final void zaC(@NonNull Field field, ArrayList arrayList) {
        if (field.f39152l != null) {
            zaE(field, arrayList);
        } else {
            setStringsInternal(field, field.f39147f, arrayList);
        }
    }

    public final void zaa(@NonNull Field field, BigDecimal bigDecimal) {
        if (field.f39152l != null) {
            zaE(field, bigDecimal);
        } else {
            zab(field, field.f39147f, bigDecimal);
        }
    }

    /* access modifiers changed from: protected */
    public void zab(@NonNull Field field, @NonNull String str, BigDecimal bigDecimal) {
        throw new UnsupportedOperationException("BigDecimal not supported");
    }

    public final void zac(@NonNull Field field, ArrayList arrayList) {
        if (field.f39152l != null) {
            zaE(field, arrayList);
        } else {
            zad(field, field.f39147f, arrayList);
        }
    }

    /* access modifiers changed from: protected */
    public void zad(@NonNull Field field, @NonNull String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("BigDecimal list not supported");
    }

    public final void zae(@NonNull Field field, BigInteger bigInteger) {
        if (field.f39152l != null) {
            zaE(field, bigInteger);
        } else {
            zaf(field, field.f39147f, bigInteger);
        }
    }

    /* access modifiers changed from: protected */
    public void zaf(@NonNull Field field, @NonNull String str, BigInteger bigInteger) {
        throw new UnsupportedOperationException("BigInteger not supported");
    }

    public final void zag(@NonNull Field field, ArrayList arrayList) {
        if (field.f39152l != null) {
            zaE(field, arrayList);
        } else {
            zah(field, field.f39147f, arrayList);
        }
    }

    /* access modifiers changed from: protected */
    public void zah(@NonNull Field field, @NonNull String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("BigInteger list not supported");
    }

    public final void zai(@NonNull Field field, boolean z10) {
        if (field.f39152l != null) {
            zaE(field, Boolean.valueOf(z10));
        } else {
            setBooleanInternal(field, field.f39147f, z10);
        }
    }

    public final void zaj(@NonNull Field field, ArrayList arrayList) {
        if (field.f39152l != null) {
            zaE(field, arrayList);
        } else {
            zak(field, field.f39147f, arrayList);
        }
    }

    /* access modifiers changed from: protected */
    public void zak(@NonNull Field field, @NonNull String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Boolean list not supported");
    }

    public final void zal(@NonNull Field field, byte[] bArr) {
        if (field.f39152l != null) {
            zaE(field, bArr);
        } else {
            setDecodedBytesInternal(field, field.f39147f, bArr);
        }
    }

    public final void zam(@NonNull Field field, double d10) {
        if (field.f39152l != null) {
            zaE(field, Double.valueOf(d10));
        } else {
            zan(field, field.f39147f, d10);
        }
    }

    /* access modifiers changed from: protected */
    public void zan(@NonNull Field field, @NonNull String str, double d10) {
        throw new UnsupportedOperationException("Double not supported");
    }

    public final void zao(@NonNull Field field, ArrayList arrayList) {
        if (field.f39152l != null) {
            zaE(field, arrayList);
        } else {
            zap(field, field.f39147f, arrayList);
        }
    }

    /* access modifiers changed from: protected */
    public void zap(@NonNull Field field, @NonNull String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Double list not supported");
    }

    public final void zaq(@NonNull Field field, float f10) {
        if (field.f39152l != null) {
            zaE(field, Float.valueOf(f10));
        } else {
            zar(field, field.f39147f, f10);
        }
    }

    /* access modifiers changed from: protected */
    public void zar(@NonNull Field field, @NonNull String str, float f10) {
        throw new UnsupportedOperationException("Float not supported");
    }

    public final void zas(@NonNull Field field, ArrayList arrayList) {
        if (field.f39152l != null) {
            zaE(field, arrayList);
        } else {
            zat(field, field.f39147f, arrayList);
        }
    }

    /* access modifiers changed from: protected */
    public void zat(@NonNull Field field, @NonNull String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Float list not supported");
    }

    public final void zau(@NonNull Field field, int i10) {
        if (field.f39152l != null) {
            zaE(field, Integer.valueOf(i10));
        } else {
            setIntegerInternal(field, field.f39147f, i10);
        }
    }

    public final void zav(@NonNull Field field, ArrayList arrayList) {
        if (field.f39152l != null) {
            zaE(field, arrayList);
        } else {
            zaw(field, field.f39147f, arrayList);
        }
    }

    /* access modifiers changed from: protected */
    public void zaw(@NonNull Field field, @NonNull String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Integer list not supported");
    }

    public final void zax(@NonNull Field field, long j10) {
        if (field.f39152l != null) {
            zaE(field, Long.valueOf(j10));
        } else {
            setLongInternal(field, field.f39147f, j10);
        }
    }

    public final void zay(@NonNull Field field, ArrayList arrayList) {
        if (field.f39152l != null) {
            zaE(field, arrayList);
        } else {
            zaz(field, field.f39147f, arrayList);
        }
    }

    /* access modifiers changed from: protected */
    public void zaz(@NonNull Field field, @NonNull String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Long list not supported");
    }

    public static class Field<I, O> extends AbstractSafeParcelable {
        public static final a CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final int f39142a;

        /* renamed from: b  reason: collision with root package name */
        protected final int f39143b;

        /* renamed from: c  reason: collision with root package name */
        protected final boolean f39144c;

        /* renamed from: d  reason: collision with root package name */
        protected final int f39145d;

        /* renamed from: e  reason: collision with root package name */
        protected final boolean f39146e;
        @NonNull

        /* renamed from: f  reason: collision with root package name */
        protected final String f39147f;

        /* renamed from: g  reason: collision with root package name */
        protected final int f39148g;

        /* renamed from: h  reason: collision with root package name */
        protected final Class f39149h;

        /* renamed from: j  reason: collision with root package name */
        protected final String f39150j;

        /* renamed from: k  reason: collision with root package name */
        private zan f39151k;
        /* access modifiers changed from: private */

        /* renamed from: l  reason: collision with root package name */
        public a f39152l;

        Field(int i10, int i11, boolean z10, int i12, boolean z11, String str, int i13, String str2, zaa zaa) {
            this.f39142a = i10;
            this.f39143b = i11;
            this.f39144c = z10;
            this.f39145d = i12;
            this.f39146e = z11;
            this.f39147f = str;
            this.f39148g = i13;
            if (str2 == null) {
                this.f39149h = null;
                this.f39150j = null;
            } else {
                this.f39149h = SafeParcelResponse.class;
                this.f39150j = str2;
            }
            if (zaa == null) {
                this.f39152l = null;
            } else {
                this.f39152l = zaa.Y();
            }
        }

        @NonNull
        public static Field<byte[], byte[]> S(@NonNull String str, int i10) {
            return new Field(8, false, 8, false, str, i10, (Class) null, (a) null);
        }

        @NonNull
        public static <T extends FastJsonResponse> Field<T, T> Y(@NonNull String str, int i10, @NonNull Class<T> cls) {
            return new Field(11, false, 11, false, str, i10, cls, (a) null);
        }

        @NonNull
        public static <T extends FastJsonResponse> Field<ArrayList<T>, ArrayList<T>> c0(@NonNull String str, int i10, @NonNull Class<T> cls) {
            return new Field(11, true, 11, true, str, i10, cls, (a) null);
        }

        @NonNull
        public static Field<Integer, Integer> f0(@NonNull String str, int i10) {
            return new Field(0, false, 0, false, str, i10, (Class) null, (a) null);
        }

        @NonNull
        public static Field<String, String> i0(@NonNull String str, int i10) {
            return new Field(7, false, 7, false, str, i10, (Class) null, (a) null);
        }

        @NonNull
        public static Field<ArrayList<String>, ArrayList<String>> m0(@NonNull String str, int i10) {
            return new Field(7, true, 7, true, str, i10, (Class) null, (a) null);
        }

        @NonNull
        public final Object E0(Object obj) {
            p.k(this.f39152l);
            return p.k(this.f39152l.E(obj));
        }

        @NonNull
        public final Object H0(@NonNull Object obj) {
            p.k(this.f39152l);
            return this.f39152l.u(obj);
        }

        /* access modifiers changed from: package-private */
        public final String R0() {
            String str = this.f39150j;
            if (str == null) {
                return null;
            }
            return str;
        }

        @NonNull
        public final Map W0() {
            p.k(this.f39150j);
            p.k(this.f39151k);
            return (Map) p.k(this.f39151k.Y(this.f39150j));
        }

        public final void c1(zan zan) {
            this.f39151k = zan;
        }

        public final boolean d1() {
            return this.f39152l != null;
        }

        public int q0() {
            return this.f39148g;
        }

        /* access modifiers changed from: package-private */
        public final zaa t0() {
            a aVar = this.f39152l;
            if (aVar == null) {
                return null;
            }
            return zaa.S(aVar);
        }

        @NonNull
        public final String toString() {
            n.a a10 = com.google.android.gms.common.internal.n.d(this).a("versionCode", Integer.valueOf(this.f39142a)).a("typeIn", Integer.valueOf(this.f39143b)).a("typeInArray", Boolean.valueOf(this.f39144c)).a("typeOut", Integer.valueOf(this.f39145d)).a("typeOutArray", Boolean.valueOf(this.f39146e)).a("outputFieldName", this.f39147f).a("safeParcelFieldId", Integer.valueOf(this.f39148g)).a("concreteTypeName", R0());
            Class cls = this.f39149h;
            if (cls != null) {
                a10.a("concreteType.class", cls.getCanonicalName());
            }
            a aVar = this.f39152l;
            if (aVar != null) {
                a10.a("converterName", aVar.getClass().getCanonicalName());
            }
            return a10.toString();
        }

        public final void writeToParcel(@NonNull Parcel parcel, int i10) {
            int a10 = fe.a.a(parcel);
            fe.a.s(parcel, 1, this.f39142a);
            fe.a.s(parcel, 2, this.f39143b);
            fe.a.g(parcel, 3, this.f39144c);
            fe.a.s(parcel, 4, this.f39145d);
            fe.a.g(parcel, 5, this.f39146e);
            fe.a.C(parcel, 6, this.f39147f, false);
            fe.a.s(parcel, 7, q0());
            fe.a.C(parcel, 8, R0(), false);
            fe.a.A(parcel, 9, t0(), i10, false);
            fe.a.b(parcel, a10);
        }

        protected Field(int i10, boolean z10, int i11, boolean z11, @NonNull String str, int i12, Class cls, a aVar) {
            this.f39142a = 1;
            this.f39143b = i10;
            this.f39144c = z10;
            this.f39145d = i11;
            this.f39146e = z11;
            this.f39147f = str;
            this.f39148g = i12;
            this.f39149h = cls;
            if (cls == null) {
                this.f39150j = null;
            } else {
                this.f39150j = cls.getCanonicalName();
            }
            this.f39152l = aVar;
        }
    }
}
