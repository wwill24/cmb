package com.google.android.recaptcha.internal;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.b0;
import kotlin.ranges.IntRange;
import kotlin.text.d;

public final class zzcg implements zzby {
    public static final zzcg zza = new zzcg();

    private zzcg() {
    }

    private final Object zzb(Object obj, Object obj2) throws zzt, ArithmeticException {
        boolean z10 = obj instanceof Byte;
        if (z10 && (obj2 instanceof Byte)) {
            return Integer.valueOf(((Number) obj).intValue() % ((Number) obj2).intValue());
        }
        boolean z11 = obj instanceof Short;
        if (z11 && (obj2 instanceof Short)) {
            return Integer.valueOf(((Number) obj).intValue() % ((Number) obj2).intValue());
        }
        boolean z12 = obj instanceof Integer;
        if (z12 && (obj2 instanceof Integer)) {
            return Integer.valueOf(((Number) obj).intValue() % ((Number) obj2).intValue());
        }
        boolean z13 = obj instanceof Long;
        if (z13 && (obj2 instanceof Long)) {
            return Long.valueOf(((Number) obj).longValue() % ((Number) obj2).longValue());
        }
        boolean z14 = obj instanceof Float;
        if (z14 && (obj2 instanceof Float)) {
            return Float.valueOf(((Number) obj).floatValue() % ((Number) obj2).floatValue());
        }
        boolean z15 = obj instanceof Double;
        if (z15 && (obj2 instanceof Double)) {
            return Double.valueOf(((Number) obj).doubleValue() % ((Number) obj2).doubleValue());
        }
        int i10 = 0;
        if (obj instanceof String) {
            if (obj2 instanceof Byte) {
                byte[] bytes = ((String) obj).getBytes(d.f32216b);
                int length = bytes.length;
                ArrayList arrayList = new ArrayList(length);
                while (i10 < length) {
                    arrayList.add(Byte.valueOf((byte) (bytes[i10] % ((Number) obj2).intValue())));
                    i10++;
                }
                return new String(CollectionsKt___CollectionsKt.u0(arrayList), d.f32216b);
            } else if (obj2 instanceof Integer) {
                char[] charArray = ((String) obj).toCharArray();
                int length2 = charArray.length;
                ArrayList arrayList2 = new ArrayList(length2);
                while (i10 < length2) {
                    arrayList2.add(Integer.valueOf(charArray[i10] % ((Number) obj2).intValue()));
                    i10++;
                }
                return CollectionsKt___CollectionsKt.w0(arrayList2);
            }
        }
        if (z10 && (obj2 instanceof byte[])) {
            ArrayList arrayList3 = new ArrayList(r0);
            for (byte intValue : (byte[]) obj2) {
                arrayList3.add(Integer.valueOf(intValue % ((Number) obj).intValue()));
            }
            return arrayList3.toArray(new Integer[0]);
        } else if (z11 && (obj2 instanceof short[])) {
            ArrayList arrayList4 = new ArrayList(r0);
            for (short intValue2 : (short[]) obj2) {
                arrayList4.add(Integer.valueOf(intValue2 % ((Number) obj).intValue()));
            }
            return arrayList4.toArray(new Integer[0]);
        } else if (z12 && (obj2 instanceof int[])) {
            ArrayList arrayList5 = new ArrayList(r0);
            for (int intValue3 : (int[]) obj2) {
                arrayList5.add(Integer.valueOf(intValue3 % ((Number) obj).intValue()));
            }
            return arrayList5.toArray(new Integer[0]);
        } else if (z13 && (obj2 instanceof long[])) {
            ArrayList arrayList6 = new ArrayList(r0);
            for (long longValue : (long[]) obj2) {
                arrayList6.add(Long.valueOf(longValue % ((Number) obj).longValue()));
            }
            return arrayList6.toArray(new Long[0]);
        } else if (z14 && (obj2 instanceof float[])) {
            ArrayList arrayList7 = new ArrayList(r0);
            for (float floatValue : (float[]) obj2) {
                arrayList7.add(Float.valueOf(floatValue % ((Number) obj).floatValue()));
            }
            return arrayList7.toArray(new Float[0]);
        } else if (!z15 || !(obj2 instanceof double[])) {
            boolean z16 = obj instanceof byte[];
            if (!z16 || !(obj2 instanceof Byte)) {
                boolean z17 = obj instanceof short[];
                if (!z17 || !(obj2 instanceof Short)) {
                    boolean z18 = obj instanceof int[];
                    if (!z18 || !(obj2 instanceof Integer)) {
                        boolean z19 = obj instanceof long[];
                        if (!z19 || !(obj2 instanceof Long)) {
                            boolean z20 = obj instanceof float[];
                            if (!z20 || !(obj2 instanceof Float)) {
                                boolean z21 = obj instanceof double[];
                                if (z21 && (obj2 instanceof Double)) {
                                    ArrayList arrayList8 = new ArrayList(r0);
                                    for (double doubleValue : (double[]) obj) {
                                        arrayList8.add(Double.valueOf(doubleValue % ((Number) obj2).doubleValue()));
                                    }
                                    return arrayList8.toArray(new Double[0]);
                                } else if (z16 && (obj2 instanceof byte[])) {
                                    byte[] bArr = (byte[]) obj;
                                    int length3 = bArr.length;
                                    byte[] bArr2 = (byte[]) obj2;
                                    zzbx.zzb(this, length3, bArr2.length);
                                    IntRange o10 = j.o(0, length3);
                                    ArrayList arrayList9 = new ArrayList(r.t(o10, 10));
                                    Iterator it = o10.iterator();
                                    while (it.hasNext()) {
                                        int nextInt = ((b0) it).nextInt();
                                        arrayList9.add(Integer.valueOf(bArr[nextInt] % bArr2[nextInt]));
                                    }
                                    return arrayList9.toArray(new Integer[0]);
                                } else if (z17 && (obj2 instanceof short[])) {
                                    short[] sArr = (short[]) obj;
                                    int length4 = sArr.length;
                                    short[] sArr2 = (short[]) obj2;
                                    zzbx.zzb(this, length4, sArr2.length);
                                    IntRange o11 = j.o(0, length4);
                                    ArrayList arrayList10 = new ArrayList(r.t(o11, 10));
                                    Iterator it2 = o11.iterator();
                                    while (it2.hasNext()) {
                                        int nextInt2 = ((b0) it2).nextInt();
                                        arrayList10.add(Integer.valueOf(sArr[nextInt2] % sArr2[nextInt2]));
                                    }
                                    return arrayList10.toArray(new Integer[0]);
                                } else if (z18 && (obj2 instanceof int[])) {
                                    int[] iArr = (int[]) obj;
                                    int length5 = iArr.length;
                                    int[] iArr2 = (int[]) obj2;
                                    zzbx.zzb(this, length5, iArr2.length);
                                    IntRange o12 = j.o(0, length5);
                                    ArrayList arrayList11 = new ArrayList(r.t(o12, 10));
                                    Iterator it3 = o12.iterator();
                                    while (it3.hasNext()) {
                                        int nextInt3 = ((b0) it3).nextInt();
                                        arrayList11.add(Integer.valueOf(iArr[nextInt3] % iArr2[nextInt3]));
                                    }
                                    return arrayList11.toArray(new Integer[0]);
                                } else if (z19 && (obj2 instanceof long[])) {
                                    long[] jArr = (long[]) obj;
                                    int length6 = jArr.length;
                                    long[] jArr2 = (long[]) obj2;
                                    zzbx.zzb(this, length6, jArr2.length);
                                    IntRange o13 = j.o(0, length6);
                                    ArrayList arrayList12 = new ArrayList(r.t(o13, 10));
                                    Iterator it4 = o13.iterator();
                                    while (it4.hasNext()) {
                                        int nextInt4 = ((b0) it4).nextInt();
                                        arrayList12.add(Long.valueOf(jArr[nextInt4] % jArr2[nextInt4]));
                                    }
                                    return arrayList12.toArray(new Long[0]);
                                } else if (z20 && (obj2 instanceof float[])) {
                                    float[] fArr = (float[]) obj;
                                    int length7 = fArr.length;
                                    float[] fArr2 = (float[]) obj2;
                                    zzbx.zzb(this, length7, fArr2.length);
                                    IntRange o14 = j.o(0, length7);
                                    ArrayList arrayList13 = new ArrayList(r.t(o14, 10));
                                    Iterator it5 = o14.iterator();
                                    while (it5.hasNext()) {
                                        int nextInt5 = ((b0) it5).nextInt();
                                        arrayList13.add(Float.valueOf(fArr[nextInt5] % fArr2[nextInt5]));
                                    }
                                    return arrayList13.toArray(new Float[0]);
                                } else if (!z21 || !(obj2 instanceof double[])) {
                                    throw new zzt(4, 5, (Throwable) null);
                                } else {
                                    double[] dArr = (double[]) obj;
                                    int length8 = dArr.length;
                                    double[] dArr2 = (double[]) obj2;
                                    zzbx.zzb(this, length8, dArr2.length);
                                    IntRange o15 = j.o(0, length8);
                                    ArrayList arrayList14 = new ArrayList(r.t(o15, 10));
                                    Iterator it6 = o15.iterator();
                                    while (it6.hasNext()) {
                                        int nextInt6 = ((b0) it6).nextInt();
                                        arrayList14.add(Double.valueOf(dArr[nextInt6] % dArr2[nextInt6]));
                                    }
                                    return arrayList14.toArray(new Double[0]);
                                }
                            } else {
                                ArrayList arrayList15 = new ArrayList(r0);
                                for (float floatValue2 : (float[]) obj) {
                                    arrayList15.add(Float.valueOf(floatValue2 % ((Number) obj2).floatValue()));
                                }
                                return arrayList15.toArray(new Float[0]);
                            }
                        } else {
                            ArrayList arrayList16 = new ArrayList(r0);
                            for (long longValue2 : (long[]) obj) {
                                arrayList16.add(Long.valueOf(longValue2 % ((Number) obj2).longValue()));
                            }
                            return arrayList16.toArray(new Long[0]);
                        }
                    } else {
                        int[] iArr3 = (int[]) obj;
                        int length9 = iArr3.length;
                        ArrayList arrayList17 = new ArrayList(length9);
                        while (i10 < length9) {
                            arrayList17.add(Integer.valueOf(iArr3[i10] % ((Number) obj2).intValue()));
                            i10++;
                        }
                        return CollectionsKt___CollectionsKt.w0(arrayList17);
                    }
                } else {
                    ArrayList arrayList18 = new ArrayList(r0);
                    for (short intValue4 : (short[]) obj) {
                        arrayList18.add(Integer.valueOf(intValue4 % ((Number) obj2).intValue()));
                    }
                    return arrayList18.toArray(new Integer[0]);
                }
            } else {
                ArrayList arrayList19 = new ArrayList(r0);
                for (byte intValue5 : (byte[]) obj) {
                    arrayList19.add(Integer.valueOf(intValue5 % ((Number) obj2).intValue()));
                }
                return arrayList19.toArray(new Integer[0]);
            }
        } else {
            ArrayList arrayList20 = new ArrayList(r0);
            for (double doubleValue2 : (double[]) obj2) {
                arrayList20.add(Double.valueOf(doubleValue2 % ((Number) obj).doubleValue()));
            }
            return arrayList20.toArray(new Double[0]);
        }
    }

    public final void zza(int i10, zzbl zzbl, Object... objArr) throws zzt {
        if (objArr.length == 2) {
            Object obj = objArr[0];
            if (true != (obj instanceof Object)) {
                obj = null;
            }
            if (obj != null) {
                Object obj2 = objArr[1];
                if (true != (obj2 instanceof Object)) {
                    obj2 = null;
                }
                if (obj2 != null) {
                    try {
                        zzbl.zzc().zzf(i10, zzb(obj, obj2));
                    } catch (ArithmeticException e10) {
                        throw new zzt(4, 6, e10);
                    }
                } else {
                    throw new zzt(4, 5, (Throwable) null);
                }
            } else {
                throw new zzt(4, 5, (Throwable) null);
            }
        } else {
            throw new zzt(4, 3, (Throwable) null);
        }
    }
}
