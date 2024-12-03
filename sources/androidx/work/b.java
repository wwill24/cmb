package androidx.work;

import androidx.annotation.NonNull;
import b2.f;
import com.leanplum.internal.Constants;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class b {

    /* renamed from: b  reason: collision with root package name */
    private static final String f7397b = f.i(Constants.Keys.DATA);

    /* renamed from: c  reason: collision with root package name */
    public static final b f7398c = new a().a();

    /* renamed from: a  reason: collision with root package name */
    Map<String, Object> f7399a;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private Map<String, Object> f7400a = new HashMap();

        @NonNull
        public b a() {
            b bVar = new b((Map<String, ?>) this.f7400a);
            b.k(bVar);
            return bVar;
        }

        @NonNull
        public a b(@NonNull String str, Object obj) {
            if (obj == null) {
                this.f7400a.put(str, (Object) null);
            } else {
                Class<?> cls = obj.getClass();
                if (cls == Boolean.class || cls == Byte.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == String.class || cls == Boolean[].class || cls == Byte[].class || cls == Integer[].class || cls == Long[].class || cls == Float[].class || cls == Double[].class || cls == String[].class) {
                    this.f7400a.put(str, obj);
                } else if (cls == boolean[].class) {
                    this.f7400a.put(str, b.a((boolean[]) obj));
                } else if (cls == byte[].class) {
                    this.f7400a.put(str, b.b((byte[]) obj));
                } else if (cls == int[].class) {
                    this.f7400a.put(str, b.e((int[]) obj));
                } else if (cls == long[].class) {
                    this.f7400a.put(str, b.f((long[]) obj));
                } else if (cls == float[].class) {
                    this.f7400a.put(str, b.d((float[]) obj));
                } else if (cls == double[].class) {
                    this.f7400a.put(str, b.c((double[]) obj));
                } else {
                    throw new IllegalArgumentException("Key " + str + "has invalid type " + cls);
                }
            }
            return this;
        }

        @NonNull
        public a c(@NonNull b bVar) {
            d(bVar.f7399a);
            return this;
        }

        @NonNull
        public a d(@NonNull Map<String, Object> map) {
            for (Map.Entry next : map.entrySet()) {
                b((String) next.getKey(), next.getValue());
            }
            return this;
        }

        @NonNull
        public a e(@NonNull String str, boolean z10) {
            this.f7400a.put(str, Boolean.valueOf(z10));
            return this;
        }

        @NonNull
        public a f(@NonNull String str, double d10) {
            this.f7400a.put(str, Double.valueOf(d10));
            return this;
        }

        @NonNull
        public a g(@NonNull String str, float f10) {
            this.f7400a.put(str, Float.valueOf(f10));
            return this;
        }

        @NonNull
        public a h(@NonNull String str, int i10) {
            this.f7400a.put(str, Integer.valueOf(i10));
            return this;
        }

        @NonNull
        public a i(@NonNull String str, long j10) {
            this.f7400a.put(str, Long.valueOf(j10));
            return this;
        }

        @NonNull
        public a j(@NonNull String str, String str2) {
            this.f7400a.put(str, str2);
            return this;
        }
    }

    b() {
    }

    @NonNull
    public static Boolean[] a(@NonNull boolean[] zArr) {
        Boolean[] boolArr = new Boolean[zArr.length];
        for (int i10 = 0; i10 < zArr.length; i10++) {
            boolArr[i10] = Boolean.valueOf(zArr[i10]);
        }
        return boolArr;
    }

    @NonNull
    public static Byte[] b(@NonNull byte[] bArr) {
        Byte[] bArr2 = new Byte[bArr.length];
        for (int i10 = 0; i10 < bArr.length; i10++) {
            bArr2[i10] = Byte.valueOf(bArr[i10]);
        }
        return bArr2;
    }

    @NonNull
    public static Double[] c(@NonNull double[] dArr) {
        Double[] dArr2 = new Double[dArr.length];
        for (int i10 = 0; i10 < dArr.length; i10++) {
            dArr2[i10] = Double.valueOf(dArr[i10]);
        }
        return dArr2;
    }

    @NonNull
    public static Float[] d(@NonNull float[] fArr) {
        Float[] fArr2 = new Float[fArr.length];
        for (int i10 = 0; i10 < fArr.length; i10++) {
            fArr2[i10] = Float.valueOf(fArr[i10]);
        }
        return fArr2;
    }

    @NonNull
    public static Integer[] e(@NonNull int[] iArr) {
        Integer[] numArr = new Integer[iArr.length];
        for (int i10 = 0; i10 < iArr.length; i10++) {
            numArr[i10] = Integer.valueOf(iArr[i10]);
        }
        return numArr;
    }

    @NonNull
    public static Long[] f(@NonNull long[] jArr) {
        Long[] lArr = new Long[jArr.length];
        for (int i10 = 0; i10 < jArr.length; i10++) {
            lArr[i10] = Long.valueOf(jArr[i10]);
        }
        return lArr;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x002c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x003c */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0039 A[SYNTHETIC, Splitter:B:20:0x0039] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0042 A[SYNTHETIC, Splitter:B:28:0x0042] */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.work.b g(@androidx.annotation.NonNull byte[] r5) {
        /*
            int r0 = r5.length
            r1 = 10240(0x2800, float:1.4349E-41)
            if (r0 > r1) goto L_0x004c
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream
            r1.<init>(r5)
            r5 = 0
            java.io.ObjectInputStream r2 = new java.io.ObjectInputStream     // Catch:{ IOException | ClassNotFoundException -> 0x0040, all -> 0x0034 }
            r2.<init>(r1)     // Catch:{ IOException | ClassNotFoundException -> 0x0040, all -> 0x0034 }
            int r5 = r2.readInt()     // Catch:{ IOException | ClassNotFoundException -> 0x0032, all -> 0x0030 }
        L_0x0019:
            if (r5 <= 0) goto L_0x0029
            java.lang.String r3 = r2.readUTF()     // Catch:{ IOException | ClassNotFoundException -> 0x0032, all -> 0x0030 }
            java.lang.Object r4 = r2.readObject()     // Catch:{ IOException | ClassNotFoundException -> 0x0032, all -> 0x0030 }
            r0.put(r3, r4)     // Catch:{ IOException | ClassNotFoundException -> 0x0032, all -> 0x0030 }
            int r5 = r5 + -1
            goto L_0x0019
        L_0x0029:
            r2.close()     // Catch:{ IOException -> 0x002c }
        L_0x002c:
            r1.close()     // Catch:{ IOException -> 0x0046 }
            goto L_0x0046
        L_0x0030:
            r5 = move-exception
            goto L_0x0037
        L_0x0032:
            r5 = r2
            goto L_0x0040
        L_0x0034:
            r0 = move-exception
            r2 = r5
            r5 = r0
        L_0x0037:
            if (r2 == 0) goto L_0x003c
            r2.close()     // Catch:{ IOException -> 0x003c }
        L_0x003c:
            r1.close()     // Catch:{ IOException -> 0x003f }
        L_0x003f:
            throw r5
        L_0x0040:
            if (r5 == 0) goto L_0x002c
            r5.close()     // Catch:{ IOException -> 0x002c }
            goto L_0x002c
        L_0x0046:
            androidx.work.b r5 = new androidx.work.b
            r5.<init>((java.util.Map<java.lang.String, ?>) r0)
            return r5
        L_0x004c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "Data cannot occupy more than 10240 bytes when serialized"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.b.g(byte[]):androidx.work.b");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:23|(2:34|35)|36|37|38) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:24|25|(0)|29|30|31) */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x003c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x005b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0064 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x006d */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0061 A[SYNTHETIC, Splitter:B:27:0x0061] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006a A[SYNTHETIC, Splitter:B:34:0x006a] */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] k(@androidx.annotation.NonNull androidx.work.b r4) {
        /*
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 0
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x005b }
            r2.<init>(r0)     // Catch:{ IOException -> 0x005b }
            int r1 = r4.j()     // Catch:{ IOException -> 0x0057, all -> 0x0054 }
            r2.writeInt(r1)     // Catch:{ IOException -> 0x0057, all -> 0x0054 }
            java.util.Map<java.lang.String, java.lang.Object> r4 = r4.f7399a     // Catch:{ IOException -> 0x0057, all -> 0x0054 }
            java.util.Set r4 = r4.entrySet()     // Catch:{ IOException -> 0x0057, all -> 0x0054 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ IOException -> 0x0057, all -> 0x0054 }
        L_0x001c:
            boolean r1 = r4.hasNext()     // Catch:{ IOException -> 0x0057, all -> 0x0054 }
            if (r1 == 0) goto L_0x0039
            java.lang.Object r1 = r4.next()     // Catch:{ IOException -> 0x0057, all -> 0x0054 }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ IOException -> 0x0057, all -> 0x0054 }
            java.lang.Object r3 = r1.getKey()     // Catch:{ IOException -> 0x0057, all -> 0x0054 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ IOException -> 0x0057, all -> 0x0054 }
            r2.writeUTF(r3)     // Catch:{ IOException -> 0x0057, all -> 0x0054 }
            java.lang.Object r1 = r1.getValue()     // Catch:{ IOException -> 0x0057, all -> 0x0054 }
            r2.writeObject(r1)     // Catch:{ IOException -> 0x0057, all -> 0x0054 }
            goto L_0x001c
        L_0x0039:
            r2.close()     // Catch:{ IOException -> 0x003c }
        L_0x003c:
            r0.close()     // Catch:{ IOException -> 0x003f }
        L_0x003f:
            int r4 = r0.size()
            r1 = 10240(0x2800, float:1.4349E-41)
            if (r4 > r1) goto L_0x004c
            byte[] r4 = r0.toByteArray()
            return r4
        L_0x004c:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "Data cannot occupy more than 10240 bytes when serialized"
            r4.<init>(r0)
            throw r4
        L_0x0054:
            r4 = move-exception
            r1 = r2
            goto L_0x0068
        L_0x0057:
            r1 = r2
            goto L_0x005b
        L_0x0059:
            r4 = move-exception
            goto L_0x0068
        L_0x005b:
            byte[] r4 = r0.toByteArray()     // Catch:{ all -> 0x0059 }
            if (r1 == 0) goto L_0x0064
            r1.close()     // Catch:{ IOException -> 0x0064 }
        L_0x0064:
            r0.close()     // Catch:{ IOException -> 0x0067 }
        L_0x0067:
            return r4
        L_0x0068:
            if (r1 == 0) goto L_0x006d
            r1.close()     // Catch:{ IOException -> 0x006d }
        L_0x006d:
            r0.close()     // Catch:{ IOException -> 0x0070 }
        L_0x0070:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.b.k(androidx.work.b):byte[]");
    }

    public boolean equals(Object obj) {
        boolean z10;
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        Set<String> keySet = this.f7399a.keySet();
        if (!keySet.equals(bVar.f7399a.keySet())) {
            return false;
        }
        for (String next : keySet) {
            Object obj2 = this.f7399a.get(next);
            Object obj3 = bVar.f7399a.get(next);
            if (obj2 == null || obj3 == null) {
                if (obj2 == obj3) {
                    z10 = true;
                    continue;
                } else {
                    z10 = false;
                    continue;
                }
            } else if (!(obj2 instanceof Object[]) || !(obj3 instanceof Object[])) {
                z10 = obj2.equals(obj3);
                continue;
            } else {
                z10 = Arrays.deepEquals((Object[]) obj2, (Object[]) obj3);
                continue;
            }
            if (!z10) {
                return false;
            }
        }
        return true;
    }

    @NonNull
    public Map<String, Object> h() {
        return Collections.unmodifiableMap(this.f7399a);
    }

    public int hashCode() {
        return this.f7399a.hashCode() * 31;
    }

    public String i(@NonNull String str) {
        Object obj = this.f7399a.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public int j() {
        return this.f7399a.size();
    }

    @NonNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder("Data {");
        if (!this.f7399a.isEmpty()) {
            for (String next : this.f7399a.keySet()) {
                sb2.append(next);
                sb2.append(" : ");
                Object obj = this.f7399a.get(next);
                if (obj instanceof Object[]) {
                    sb2.append(Arrays.toString((Object[]) obj));
                } else {
                    sb2.append(obj);
                }
                sb2.append(", ");
            }
        }
        sb2.append("}");
        return sb2.toString();
    }

    public b(@NonNull b bVar) {
        this.f7399a = new HashMap(bVar.f7399a);
    }

    public b(@NonNull Map<String, ?> map) {
        this.f7399a = new HashMap(map);
    }
}
