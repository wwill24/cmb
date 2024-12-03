package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.mparticle.kits.AppsFlyerKit;
import fe.a;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import me.b;
import me.c;
import me.n;
import me.o;

public class SafeParcelResponse extends FastSafeParcelableJsonResponse {
    @NonNull
    public static final Parcelable.Creator<SafeParcelResponse> CREATOR = new e();

    /* renamed from: a  reason: collision with root package name */
    private final int f39153a;

    /* renamed from: b  reason: collision with root package name */
    private final Parcel f39154b;

    /* renamed from: c  reason: collision with root package name */
    private final int f39155c = 2;

    /* renamed from: d  reason: collision with root package name */
    private final zan f39156d;

    /* renamed from: e  reason: collision with root package name */
    private final String f39157e;

    /* renamed from: f  reason: collision with root package name */
    private int f39158f;

    /* renamed from: g  reason: collision with root package name */
    private int f39159g;

    SafeParcelResponse(int i10, Parcel parcel, zan zan) {
        this.f39153a = i10;
        this.f39154b = (Parcel) p.k(parcel);
        this.f39156d = zan;
        this.f39157e = zan == null ? null : zan.S();
        this.f39158f = 2;
    }

    private final void c(FastJsonResponse.Field field) {
        if (field.f39148g != -1) {
            Parcel parcel = this.f39154b;
            if (parcel != null) {
                int i10 = this.f39158f;
                if (i10 == 0) {
                    this.f39159g = a.a(parcel);
                    this.f39158f = 1;
                } else if (i10 != 1) {
                    throw new IllegalStateException("Attempted to parse JSON with a SafeParcelResponse object that is already filled with data.");
                }
            } else {
                throw new IllegalStateException("Internal Parcel object is null.");
            }
        } else {
            throw new IllegalStateException("Field does not have a valid safe parcelable field id.");
        }
    }

    private final void d(StringBuilder sb2, Map map, Parcel parcel) {
        SparseArray sparseArray = new SparseArray();
        for (Map.Entry entry : map.entrySet()) {
            sparseArray.put(((FastJsonResponse.Field) entry.getValue()).q0(), entry);
        }
        sb2.append('{');
        int K = SafeParcelReader.K(parcel);
        boolean z10 = false;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            Map.Entry entry2 = (Map.Entry) sparseArray.get(SafeParcelReader.u(B));
            if (entry2 != null) {
                if (z10) {
                    sb2.append(AppsFlyerKit.COMMA);
                }
                FastJsonResponse.Field field = (FastJsonResponse.Field) entry2.getValue();
                sb2.append("\"");
                sb2.append((String) entry2.getKey());
                sb2.append("\":");
                if (field.d1()) {
                    int i10 = field.f39145d;
                    switch (i10) {
                        case 0:
                            f(sb2, field, FastJsonResponse.zaD(field, Integer.valueOf(SafeParcelReader.D(parcel, B))));
                            break;
                        case 1:
                            f(sb2, field, FastJsonResponse.zaD(field, SafeParcelReader.c(parcel, B)));
                            break;
                        case 2:
                            f(sb2, field, FastJsonResponse.zaD(field, Long.valueOf(SafeParcelReader.F(parcel, B))));
                            break;
                        case 3:
                            f(sb2, field, FastJsonResponse.zaD(field, Float.valueOf(SafeParcelReader.z(parcel, B))));
                            break;
                        case 4:
                            f(sb2, field, FastJsonResponse.zaD(field, Double.valueOf(SafeParcelReader.x(parcel, B))));
                            break;
                        case 5:
                            f(sb2, field, FastJsonResponse.zaD(field, SafeParcelReader.a(parcel, B)));
                            break;
                        case 6:
                            f(sb2, field, FastJsonResponse.zaD(field, Boolean.valueOf(SafeParcelReader.v(parcel, B))));
                            break;
                        case 7:
                            f(sb2, field, FastJsonResponse.zaD(field, SafeParcelReader.o(parcel, B)));
                            break;
                        case 8:
                        case 9:
                            f(sb2, field, FastJsonResponse.zaD(field, SafeParcelReader.g(parcel, B)));
                            break;
                        case 10:
                            Bundle f10 = SafeParcelReader.f(parcel, B);
                            HashMap hashMap = new HashMap();
                            for (String next : f10.keySet()) {
                                hashMap.put(next, (String) p.k(f10.getString(next)));
                            }
                            f(sb2, field, FastJsonResponse.zaD(field, hashMap));
                            break;
                        case 11:
                            throw new IllegalArgumentException("Method does not accept concrete type.");
                        default:
                            throw new IllegalArgumentException("Unknown field out type = " + i10);
                    }
                } else if (field.f39146e) {
                    sb2.append("[");
                    switch (field.f39145d) {
                        case 0:
                            b.e(sb2, SafeParcelReader.j(parcel, B));
                            break;
                        case 1:
                            b.g(sb2, SafeParcelReader.d(parcel, B));
                            break;
                        case 2:
                            b.f(sb2, SafeParcelReader.k(parcel, B));
                            break;
                        case 3:
                            b.d(sb2, SafeParcelReader.i(parcel, B));
                            break;
                        case 4:
                            b.c(sb2, SafeParcelReader.h(parcel, B));
                            break;
                        case 5:
                            b.g(sb2, SafeParcelReader.b(parcel, B));
                            break;
                        case 6:
                            b.h(sb2, SafeParcelReader.e(parcel, B));
                            break;
                        case 7:
                            b.i(sb2, SafeParcelReader.p(parcel, B));
                            break;
                        case 8:
                        case 9:
                        case 10:
                            throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                        case 11:
                            Parcel[] m10 = SafeParcelReader.m(parcel, B);
                            int length = m10.length;
                            for (int i11 = 0; i11 < length; i11++) {
                                if (i11 > 0) {
                                    sb2.append(AppsFlyerKit.COMMA);
                                }
                                m10[i11].setDataPosition(0);
                                d(sb2, field.W0(), m10[i11]);
                            }
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out.");
                    }
                    sb2.append("]");
                } else {
                    switch (field.f39145d) {
                        case 0:
                            sb2.append(SafeParcelReader.D(parcel, B));
                            break;
                        case 1:
                            sb2.append(SafeParcelReader.c(parcel, B));
                            break;
                        case 2:
                            sb2.append(SafeParcelReader.F(parcel, B));
                            break;
                        case 3:
                            sb2.append(SafeParcelReader.z(parcel, B));
                            break;
                        case 4:
                            sb2.append(SafeParcelReader.x(parcel, B));
                            break;
                        case 5:
                            sb2.append(SafeParcelReader.a(parcel, B));
                            break;
                        case 6:
                            sb2.append(SafeParcelReader.v(parcel, B));
                            break;
                        case 7:
                            String o10 = SafeParcelReader.o(parcel, B);
                            sb2.append("\"");
                            sb2.append(n.a(o10));
                            sb2.append("\"");
                            break;
                        case 8:
                            byte[] g10 = SafeParcelReader.g(parcel, B);
                            sb2.append("\"");
                            sb2.append(c.c(g10));
                            sb2.append("\"");
                            break;
                        case 9:
                            byte[] g11 = SafeParcelReader.g(parcel, B);
                            sb2.append("\"");
                            sb2.append(c.d(g11));
                            sb2.append("\"");
                            break;
                        case 10:
                            Bundle f11 = SafeParcelReader.f(parcel, B);
                            Set<String> keySet = f11.keySet();
                            sb2.append("{");
                            boolean z11 = true;
                            for (String next2 : keySet) {
                                if (!z11) {
                                    sb2.append(AppsFlyerKit.COMMA);
                                }
                                sb2.append("\"");
                                sb2.append(next2);
                                sb2.append("\":\"");
                                sb2.append(n.a(f11.getString(next2)));
                                sb2.append("\"");
                                z11 = false;
                            }
                            sb2.append("}");
                            break;
                        case 11:
                            Parcel l10 = SafeParcelReader.l(parcel, B);
                            l10.setDataPosition(0);
                            d(sb2, field.W0(), l10);
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out");
                    }
                }
                z10 = true;
            }
        }
        if (parcel.dataPosition() == K) {
            sb2.append('}');
            return;
        }
        throw new SafeParcelReader.ParseException("Overread allowed size end=" + K, parcel);
    }

    private static final void e(StringBuilder sb2, int i10, Object obj) {
        switch (i10) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb2.append(obj);
                return;
            case 7:
                sb2.append("\"");
                sb2.append(n.a(p.k(obj).toString()));
                sb2.append("\"");
                return;
            case 8:
                sb2.append("\"");
                sb2.append(c.c((byte[]) obj));
                sb2.append("\"");
                return;
            case 9:
                sb2.append("\"");
                sb2.append(c.d((byte[]) obj));
                sb2.append("\"");
                return;
            case 10:
                o.a(sb2, (HashMap) p.k(obj));
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown type = " + i10);
        }
    }

    private static final void f(StringBuilder sb2, FastJsonResponse.Field field, Object obj) {
        if (field.f39144c) {
            ArrayList arrayList = (ArrayList) obj;
            sb2.append("[");
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (i10 != 0) {
                    sb2.append(AppsFlyerKit.COMMA);
                }
                e(sb2, field.f39143b, arrayList.get(i10));
            }
            sb2.append("]");
            return;
        }
        e(sb2, field.f39143b, obj);
    }

    @NonNull
    public final Parcel a() {
        int i10 = this.f39158f;
        if (i10 == 0) {
            int a10 = a.a(this.f39154b);
            this.f39159g = a10;
            a.b(this.f39154b, a10);
            this.f39158f = 2;
        } else if (i10 == 1) {
            a.b(this.f39154b, this.f39159g);
            this.f39158f = 2;
        }
        return this.f39154b;
    }

    public final <T extends FastJsonResponse> void addConcreteTypeArrayInternal(@NonNull FastJsonResponse.Field field, @NonNull String str, ArrayList<T> arrayList) {
        c(field);
        ArrayList arrayList2 = new ArrayList();
        ((ArrayList) p.k(arrayList)).size();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList2.add(((SafeParcelResponse) ((FastJsonResponse) arrayList.get(i10))).a());
        }
        a.z(this.f39154b, field.q0(), arrayList2, true);
    }

    public final <T extends FastJsonResponse> void addConcreteTypeInternal(@NonNull FastJsonResponse.Field field, @NonNull String str, @NonNull T t10) {
        c(field);
        a.y(this.f39154b, field.q0(), ((SafeParcelResponse) t10).a(), true);
    }

    public final Map<String, FastJsonResponse.Field<?, ?>> getFieldMappings() {
        zan zan = this.f39156d;
        if (zan == null) {
            return null;
        }
        return zan.Y((String) p.k(this.f39157e));
    }

    @NonNull
    public final Object getValueObject(@NonNull String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public final boolean isPrimitiveFieldSet(@NonNull String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    /* access modifiers changed from: protected */
    public final void setBooleanInternal(@NonNull FastJsonResponse.Field<?, ?> field, @NonNull String str, boolean z10) {
        c(field);
        a.g(this.f39154b, field.q0(), z10);
    }

    /* access modifiers changed from: protected */
    public final void setDecodedBytesInternal(@NonNull FastJsonResponse.Field<?, ?> field, @NonNull String str, byte[] bArr) {
        c(field);
        a.k(this.f39154b, field.q0(), bArr, true);
    }

    /* access modifiers changed from: protected */
    public final void setIntegerInternal(@NonNull FastJsonResponse.Field<?, ?> field, @NonNull String str, int i10) {
        c(field);
        a.s(this.f39154b, field.q0(), i10);
    }

    /* access modifiers changed from: protected */
    public final void setLongInternal(@NonNull FastJsonResponse.Field<?, ?> field, @NonNull String str, long j10) {
        c(field);
        a.v(this.f39154b, field.q0(), j10);
    }

    /* access modifiers changed from: protected */
    public final void setStringInternal(@NonNull FastJsonResponse.Field<?, ?> field, @NonNull String str, String str2) {
        c(field);
        a.C(this.f39154b, field.q0(), str2, true);
    }

    /* access modifiers changed from: protected */
    public final void setStringMapInternal(@NonNull FastJsonResponse.Field<?, ?> field, @NonNull String str, Map<String, String> map) {
        c(field);
        Bundle bundle = new Bundle();
        for (String str2 : ((Map) p.k(map)).keySet()) {
            bundle.putString(str2, map.get(str2));
        }
        a.j(this.f39154b, field.q0(), bundle, true);
    }

    /* access modifiers changed from: protected */
    public final void setStringsInternal(@NonNull FastJsonResponse.Field<?, ?> field, @NonNull String str, ArrayList<String> arrayList) {
        c(field);
        int size = ((ArrayList) p.k(arrayList)).size();
        String[] strArr = new String[size];
        for (int i10 = 0; i10 < size; i10++) {
            strArr[i10] = arrayList.get(i10);
        }
        a.D(this.f39154b, field.q0(), strArr, true);
    }

    @NonNull
    public final String toString() {
        p.l(this.f39156d, "Cannot convert to JSON on client side.");
        Parcel a10 = a();
        a10.setDataPosition(0);
        StringBuilder sb2 = new StringBuilder(100);
        d(sb2, (Map) p.k(this.f39156d.Y((String) p.k(this.f39157e))), a10);
        return sb2.toString();
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        zan zan;
        int a10 = a.a(parcel);
        a.s(parcel, 1, this.f39153a);
        a.y(parcel, 2, a(), false);
        int i11 = this.f39155c;
        if (i11 == 0) {
            zan = null;
        } else if (i11 != 1) {
            zan = this.f39156d;
        } else {
            zan = this.f39156d;
        }
        a.A(parcel, 3, zan, i10, false);
        a.b(parcel, a10);
    }

    /* access modifiers changed from: protected */
    public final void zab(@NonNull FastJsonResponse.Field field, @NonNull String str, BigDecimal bigDecimal) {
        c(field);
        a.c(this.f39154b, field.q0(), bigDecimal, true);
    }

    /* access modifiers changed from: protected */
    public final void zad(@NonNull FastJsonResponse.Field field, @NonNull String str, ArrayList arrayList) {
        c(field);
        int size = ((ArrayList) p.k(arrayList)).size();
        BigDecimal[] bigDecimalArr = new BigDecimal[size];
        for (int i10 = 0; i10 < size; i10++) {
            bigDecimalArr[i10] = (BigDecimal) arrayList.get(i10);
        }
        a.d(this.f39154b, field.q0(), bigDecimalArr, true);
    }

    /* access modifiers changed from: protected */
    public final void zaf(@NonNull FastJsonResponse.Field field, @NonNull String str, BigInteger bigInteger) {
        c(field);
        a.e(this.f39154b, field.q0(), bigInteger, true);
    }

    /* access modifiers changed from: protected */
    public final void zah(@NonNull FastJsonResponse.Field field, @NonNull String str, ArrayList arrayList) {
        c(field);
        int size = ((ArrayList) p.k(arrayList)).size();
        BigInteger[] bigIntegerArr = new BigInteger[size];
        for (int i10 = 0; i10 < size; i10++) {
            bigIntegerArr[i10] = (BigInteger) arrayList.get(i10);
        }
        a.f(this.f39154b, field.q0(), bigIntegerArr, true);
    }

    /* access modifiers changed from: protected */
    public final void zak(@NonNull FastJsonResponse.Field field, @NonNull String str, ArrayList arrayList) {
        c(field);
        int size = ((ArrayList) p.k(arrayList)).size();
        boolean[] zArr = new boolean[size];
        for (int i10 = 0; i10 < size; i10++) {
            zArr[i10] = ((Boolean) arrayList.get(i10)).booleanValue();
        }
        a.h(this.f39154b, field.q0(), zArr, true);
    }

    /* access modifiers changed from: protected */
    public final void zan(@NonNull FastJsonResponse.Field field, @NonNull String str, double d10) {
        c(field);
        a.l(this.f39154b, field.q0(), d10);
    }

    /* access modifiers changed from: protected */
    public final void zap(@NonNull FastJsonResponse.Field field, @NonNull String str, ArrayList arrayList) {
        c(field);
        int size = ((ArrayList) p.k(arrayList)).size();
        double[] dArr = new double[size];
        for (int i10 = 0; i10 < size; i10++) {
            dArr[i10] = ((Double) arrayList.get(i10)).doubleValue();
        }
        a.m(this.f39154b, field.q0(), dArr, true);
    }

    /* access modifiers changed from: protected */
    public final void zar(@NonNull FastJsonResponse.Field field, @NonNull String str, float f10) {
        c(field);
        a.o(this.f39154b, field.q0(), f10);
    }

    /* access modifiers changed from: protected */
    public final void zat(@NonNull FastJsonResponse.Field field, @NonNull String str, ArrayList arrayList) {
        c(field);
        int size = ((ArrayList) p.k(arrayList)).size();
        float[] fArr = new float[size];
        for (int i10 = 0; i10 < size; i10++) {
            fArr[i10] = ((Float) arrayList.get(i10)).floatValue();
        }
        a.p(this.f39154b, field.q0(), fArr, true);
    }

    /* access modifiers changed from: protected */
    public final void zaw(@NonNull FastJsonResponse.Field field, @NonNull String str, ArrayList arrayList) {
        c(field);
        int size = ((ArrayList) p.k(arrayList)).size();
        int[] iArr = new int[size];
        for (int i10 = 0; i10 < size; i10++) {
            iArr[i10] = ((Integer) arrayList.get(i10)).intValue();
        }
        a.t(this.f39154b, field.q0(), iArr, true);
    }

    /* access modifiers changed from: protected */
    public final void zaz(@NonNull FastJsonResponse.Field field, @NonNull String str, ArrayList arrayList) {
        c(field);
        int size = ((ArrayList) p.k(arrayList)).size();
        long[] jArr = new long[size];
        for (int i10 = 0; i10 < size; i10++) {
            jArr[i10] = ((Long) arrayList.get(i10)).longValue();
        }
        a.w(this.f39154b, field.q0(), jArr, true);
    }
}
