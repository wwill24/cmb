package androidx.profileinstaller;

import androidx.annotation.NonNull;
import com.facebook.internal.security.CertificateUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Map;
import java.util.TreeMap;

class m {

    /* renamed from: a  reason: collision with root package name */
    static final byte[] f6175a = {112, 114, 111, 0};

    /* renamed from: b  reason: collision with root package name */
    static final byte[] f6176b = {112, 114, 109, 0};

    private static void A(@NonNull InputStream inputStream) throws IOException {
        e.h(inputStream);
        int j10 = e.j(inputStream);
        if (j10 != 6 && j10 != 7) {
            while (j10 > 0) {
                e.j(inputStream);
                for (int j11 = e.j(inputStream); j11 > 0; j11--) {
                    e.h(inputStream);
                }
                j10--;
            }
        }
    }

    static boolean B(@NonNull OutputStream outputStream, @NonNull byte[] bArr, @NonNull d[] dVarArr) throws IOException {
        if (Arrays.equals(bArr, o.f6187a)) {
            N(outputStream, dVarArr);
            return true;
        } else if (Arrays.equals(bArr, o.f6188b)) {
            M(outputStream, dVarArr);
            return true;
        } else if (Arrays.equals(bArr, o.f6190d)) {
            K(outputStream, dVarArr);
            return true;
        } else if (Arrays.equals(bArr, o.f6189c)) {
            L(outputStream, dVarArr);
            return true;
        } else if (!Arrays.equals(bArr, o.f6191e)) {
            return false;
        } else {
            J(outputStream, dVarArr);
            return true;
        }
    }

    private static void C(@NonNull OutputStream outputStream, @NonNull d dVar) throws IOException {
        int i10 = 0;
        for (int valueOf : dVar.f6163h) {
            Integer valueOf2 = Integer.valueOf(valueOf);
            e.p(outputStream, valueOf2.intValue() - i10);
            i10 = valueOf2.intValue();
        }
    }

    private static p D(@NonNull d[] dVarArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            e.p(byteArrayOutputStream, dVarArr.length);
            int i10 = 2;
            for (d dVar : dVarArr) {
                e.q(byteArrayOutputStream, dVar.f6158c);
                e.q(byteArrayOutputStream, dVar.f6159d);
                e.q(byteArrayOutputStream, (long) dVar.f6162g);
                String j10 = j(dVar.f6156a, dVar.f6157b, o.f6187a);
                int k10 = e.k(j10);
                e.p(byteArrayOutputStream, k10);
                i10 = i10 + 4 + 4 + 4 + 2 + (k10 * 1);
                e.n(byteArrayOutputStream, j10);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (i10 == byteArray.length) {
                p pVar = new p(FileSectionType.DEX_FILES, i10, byteArray, false);
                byteArrayOutputStream.close();
                return pVar;
            }
            throw e.c("Expected size " + i10 + ", does not match actual size " + byteArray.length);
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    static void E(@NonNull OutputStream outputStream, byte[] bArr) throws IOException {
        outputStream.write(f6175a);
        outputStream.write(bArr);
    }

    private static void F(@NonNull OutputStream outputStream, @NonNull d dVar) throws IOException {
        I(outputStream, dVar);
        C(outputStream, dVar);
        H(outputStream, dVar);
    }

    private static void G(@NonNull OutputStream outputStream, @NonNull d dVar, @NonNull String str) throws IOException {
        e.p(outputStream, e.k(str));
        e.p(outputStream, dVar.f6160e);
        e.q(outputStream, (long) dVar.f6161f);
        e.q(outputStream, dVar.f6158c);
        e.q(outputStream, (long) dVar.f6162g);
        e.n(outputStream, str);
    }

    private static void H(@NonNull OutputStream outputStream, @NonNull d dVar) throws IOException {
        byte[] bArr = new byte[k(dVar.f6162g)];
        for (Map.Entry next : dVar.f6164i.entrySet()) {
            int intValue = ((Integer) next.getKey()).intValue();
            int intValue2 = ((Integer) next.getValue()).intValue();
            if ((intValue2 & 2) != 0) {
                z(bArr, 2, intValue, dVar);
            }
            if ((intValue2 & 4) != 0) {
                z(bArr, 4, intValue, dVar);
            }
        }
        outputStream.write(bArr);
    }

    private static void I(@NonNull OutputStream outputStream, @NonNull d dVar) throws IOException {
        int i10 = 0;
        for (Map.Entry next : dVar.f6164i.entrySet()) {
            int intValue = ((Integer) next.getKey()).intValue();
            if ((((Integer) next.getValue()).intValue() & 1) != 0) {
                e.p(outputStream, intValue - i10);
                e.p(outputStream, 0);
                i10 = intValue;
            }
        }
    }

    private static void J(@NonNull OutputStream outputStream, @NonNull d[] dVarArr) throws IOException {
        e.p(outputStream, dVarArr.length);
        for (d dVar : dVarArr) {
            String j10 = j(dVar.f6156a, dVar.f6157b, o.f6191e);
            e.p(outputStream, e.k(j10));
            e.p(outputStream, dVar.f6164i.size());
            e.p(outputStream, dVar.f6163h.length);
            e.q(outputStream, dVar.f6158c);
            e.n(outputStream, j10);
            for (Integer intValue : dVar.f6164i.keySet()) {
                e.p(outputStream, intValue.intValue());
            }
            for (int p10 : dVar.f6163h) {
                e.p(outputStream, p10);
            }
        }
    }

    private static void K(@NonNull OutputStream outputStream, @NonNull d[] dVarArr) throws IOException {
        e.r(outputStream, dVarArr.length);
        for (d dVar : dVarArr) {
            String j10 = j(dVar.f6156a, dVar.f6157b, o.f6190d);
            e.p(outputStream, e.k(j10));
            e.p(outputStream, dVar.f6163h.length);
            e.q(outputStream, (long) (dVar.f6164i.size() * 4));
            e.q(outputStream, dVar.f6158c);
            e.n(outputStream, j10);
            for (Integer intValue : dVar.f6164i.keySet()) {
                e.p(outputStream, intValue.intValue());
                e.p(outputStream, 0);
            }
            for (int p10 : dVar.f6163h) {
                e.p(outputStream, p10);
            }
        }
    }

    private static void L(@NonNull OutputStream outputStream, @NonNull d[] dVarArr) throws IOException {
        byte[] b10 = b(dVarArr, o.f6189c);
        e.r(outputStream, dVarArr.length);
        e.m(outputStream, b10);
    }

    private static void M(@NonNull OutputStream outputStream, @NonNull d[] dVarArr) throws IOException {
        byte[] b10 = b(dVarArr, o.f6188b);
        e.r(outputStream, dVarArr.length);
        e.m(outputStream, b10);
    }

    private static void N(@NonNull OutputStream outputStream, @NonNull d[] dVarArr) throws IOException {
        O(outputStream, dVarArr);
    }

    private static void O(@NonNull OutputStream outputStream, @NonNull d[] dVarArr) throws IOException {
        int i10;
        ArrayList arrayList = new ArrayList(3);
        ArrayList arrayList2 = new ArrayList(3);
        arrayList.add(D(dVarArr));
        arrayList.add(c(dVarArr));
        arrayList.add(d(dVarArr));
        long length = ((long) o.f6187a.length) + ((long) f6175a.length) + 4 + ((long) (arrayList.size() * 16));
        e.q(outputStream, (long) arrayList.size());
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            p pVar = (p) arrayList.get(i11);
            e.q(outputStream, pVar.f6194a.b());
            e.q(outputStream, length);
            if (pVar.f6197d) {
                byte[] bArr = pVar.f6196c;
                byte[] b10 = e.b(bArr);
                arrayList2.add(b10);
                e.q(outputStream, (long) b10.length);
                e.q(outputStream, (long) bArr.length);
                i10 = b10.length;
            } else {
                arrayList2.add(pVar.f6196c);
                e.q(outputStream, (long) pVar.f6196c.length);
                e.q(outputStream, 0);
                i10 = pVar.f6196c.length;
            }
            length += (long) i10;
        }
        for (int i12 = 0; i12 < arrayList2.size(); i12++) {
            outputStream.write((byte[]) arrayList2.get(i12));
        }
    }

    private static int a(@NonNull d dVar) {
        int i10 = 0;
        for (Map.Entry<Integer, Integer> value : dVar.f6164i.entrySet()) {
            i10 |= ((Integer) value.getValue()).intValue();
        }
        return i10;
    }

    @NonNull
    private static byte[] b(@NonNull d[] dVarArr, @NonNull byte[] bArr) throws IOException {
        int i10 = 0;
        int i11 = 0;
        for (d dVar : dVarArr) {
            i11 += e.k(j(dVar.f6156a, dVar.f6157b, bArr)) + 16 + (dVar.f6160e * 2) + dVar.f6161f + k(dVar.f6162g);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i11);
        if (Arrays.equals(bArr, o.f6189c)) {
            int length = dVarArr.length;
            while (i10 < length) {
                d dVar2 = dVarArr[i10];
                G(byteArrayOutputStream, dVar2, j(dVar2.f6156a, dVar2.f6157b, bArr));
                F(byteArrayOutputStream, dVar2);
                i10++;
            }
        } else {
            for (d dVar3 : dVarArr) {
                G(byteArrayOutputStream, dVar3, j(dVar3.f6156a, dVar3.f6157b, bArr));
            }
            int length2 = dVarArr.length;
            while (i10 < length2) {
                F(byteArrayOutputStream, dVarArr[i10]);
                i10++;
            }
        }
        if (byteArrayOutputStream.size() == i11) {
            return byteArrayOutputStream.toByteArray();
        }
        throw e.c("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + i11);
    }

    private static p c(@NonNull d[] dVarArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i10 = 0;
        int i11 = 0;
        while (i10 < dVarArr.length) {
            try {
                d dVar = dVarArr[i10];
                e.p(byteArrayOutputStream, i10);
                e.p(byteArrayOutputStream, dVar.f6160e);
                i11 = i11 + 2 + 2 + (dVar.f6160e * 2);
                C(byteArrayOutputStream, dVar);
                i10++;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i11 == byteArray.length) {
            p pVar = new p(FileSectionType.CLASSES, i11, byteArray, true);
            byteArrayOutputStream.close();
            return pVar;
        }
        throw e.c("Expected size " + i11 + ", does not match actual size " + byteArray.length);
        throw th;
    }

    private static p d(@NonNull d[] dVarArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i10 = 0;
        int i11 = 0;
        while (i10 < dVarArr.length) {
            try {
                d dVar = dVarArr[i10];
                int a10 = a(dVar);
                byte[] e10 = e(dVar);
                byte[] f10 = f(dVar);
                e.p(byteArrayOutputStream, i10);
                int length = e10.length + 2 + f10.length;
                e.q(byteArrayOutputStream, (long) length);
                e.p(byteArrayOutputStream, a10);
                byteArrayOutputStream.write(e10);
                byteArrayOutputStream.write(f10);
                i11 = i11 + 2 + 4 + length;
                i10++;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i11 == byteArray.length) {
            p pVar = new p(FileSectionType.METHODS, i11, byteArray, true);
            byteArrayOutputStream.close();
            return pVar;
        }
        throw e.c("Expected size " + i11 + ", does not match actual size " + byteArray.length);
        throw th;
    }

    private static byte[] e(@NonNull d dVar) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            H(byteArrayOutputStream, dVar);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    private static byte[] f(@NonNull d dVar) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            I(byteArrayOutputStream, dVar);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    @NonNull
    private static String g(@NonNull String str, @NonNull String str2) {
        if ("!".equals(str2)) {
            return str.replace(CertificateUtil.DELIMITER, "!");
        }
        if (CertificateUtil.DELIMITER.equals(str2)) {
            return str.replace("!", CertificateUtil.DELIMITER);
        }
        return str;
    }

    @NonNull
    private static String h(@NonNull String str) {
        int indexOf = str.indexOf("!");
        if (indexOf < 0) {
            indexOf = str.indexOf(CertificateUtil.DELIMITER);
        }
        if (indexOf > 0) {
            return str.substring(indexOf + 1);
        }
        return str;
    }

    private static d i(@NonNull d[] dVarArr, @NonNull String str) {
        if (dVarArr.length <= 0) {
            return null;
        }
        String h10 = h(str);
        for (int i10 = 0; i10 < dVarArr.length; i10++) {
            if (dVarArr[i10].f6157b.equals(h10)) {
                return dVarArr[i10];
            }
        }
        return null;
    }

    @NonNull
    private static String j(@NonNull String str, @NonNull String str2, @NonNull byte[] bArr) {
        String a10 = o.a(bArr);
        if (str.length() <= 0) {
            return g(str2, a10);
        }
        if (str2.equals("classes.dex")) {
            return str;
        }
        if (str2.contains("!") || str2.contains(CertificateUtil.DELIMITER)) {
            return g(str2, a10);
        }
        if (str2.endsWith(".apk")) {
            return str2;
        }
        return str + o.a(bArr) + str2;
    }

    private static int k(int i10) {
        return y(i10 * 2) / 8;
    }

    private static int l(int i10, int i11, int i12) {
        if (i10 == 1) {
            throw e.c("HOT methods are not stored in the bitmap");
        } else if (i10 == 2) {
            return i11;
        } else {
            if (i10 == 4) {
                return i11 + i12;
            }
            throw e.c("Unexpected flag: " + i10);
        }
    }

    private static int[] m(@NonNull InputStream inputStream, int i10) throws IOException {
        int[] iArr = new int[i10];
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            i11 += e.h(inputStream);
            iArr[i12] = i11;
        }
        return iArr;
    }

    private static int n(@NonNull BitSet bitSet, int i10, int i11) {
        int i12 = 2;
        if (!bitSet.get(l(2, i10, i11))) {
            i12 = 0;
        }
        if (bitSet.get(l(4, i10, i11))) {
            return i12 | 4;
        }
        return i12;
    }

    static byte[] o(@NonNull InputStream inputStream, @NonNull byte[] bArr) throws IOException {
        if (Arrays.equals(bArr, e.d(inputStream, bArr.length))) {
            return e.d(inputStream, o.f6188b.length);
        }
        throw e.c("Invalid magic");
    }

    private static void p(@NonNull InputStream inputStream, @NonNull d dVar) throws IOException {
        int available = inputStream.available() - dVar.f6161f;
        int i10 = 0;
        while (inputStream.available() > available) {
            i10 += e.h(inputStream);
            dVar.f6164i.put(Integer.valueOf(i10), 1);
            for (int h10 = e.h(inputStream); h10 > 0; h10--) {
                A(inputStream);
            }
        }
        if (inputStream.available() != available) {
            throw e.c("Read too much data during profile line parse");
        }
    }

    @NonNull
    static d[] q(@NonNull InputStream inputStream, @NonNull byte[] bArr, @NonNull byte[] bArr2, d[] dVarArr) throws IOException {
        if (Arrays.equals(bArr, o.f6192f)) {
            if (!Arrays.equals(o.f6187a, bArr2)) {
                return r(inputStream, bArr, dVarArr);
            }
            throw e.c("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
        } else if (Arrays.equals(bArr, o.f6193g)) {
            return t(inputStream, bArr2, dVarArr);
        } else {
            throw e.c("Unsupported meta version");
        }
    }

    @NonNull
    static d[] r(@NonNull InputStream inputStream, @NonNull byte[] bArr, d[] dVarArr) throws IOException {
        if (Arrays.equals(bArr, o.f6192f)) {
            int j10 = e.j(inputStream);
            byte[] e10 = e.e(inputStream, (int) e.i(inputStream), (int) e.i(inputStream));
            if (inputStream.read() <= 0) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(e10);
                try {
                    d[] s10 = s(byteArrayInputStream, j10, dVarArr);
                    byteArrayInputStream.close();
                    return s10;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            } else {
                throw e.c("Content found after the end of file");
            }
        } else {
            throw e.c("Unsupported meta version");
        }
        throw th;
    }

    @NonNull
    private static d[] s(@NonNull InputStream inputStream, int i10, d[] dVarArr) throws IOException {
        int i11 = 0;
        if (inputStream.available() == 0) {
            return new d[0];
        }
        if (i10 == dVarArr.length) {
            String[] strArr = new String[i10];
            int[] iArr = new int[i10];
            for (int i12 = 0; i12 < i10; i12++) {
                int h10 = e.h(inputStream);
                iArr[i12] = e.h(inputStream);
                strArr[i12] = e.f(inputStream, h10);
            }
            while (i11 < i10) {
                d dVar = dVarArr[i11];
                if (dVar.f6157b.equals(strArr[i11])) {
                    int i13 = iArr[i11];
                    dVar.f6160e = i13;
                    dVar.f6163h = m(inputStream, i13);
                    i11++;
                } else {
                    throw e.c("Order of dexfiles in metadata did not match baseline");
                }
            }
            return dVarArr;
        }
        throw e.c("Mismatched number of dex files found in metadata");
    }

    @NonNull
    static d[] t(@NonNull InputStream inputStream, @NonNull byte[] bArr, d[] dVarArr) throws IOException {
        int h10 = e.h(inputStream);
        byte[] e10 = e.e(inputStream, (int) e.i(inputStream), (int) e.i(inputStream));
        if (inputStream.read() <= 0) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(e10);
            try {
                d[] u10 = u(byteArrayInputStream, bArr, h10, dVarArr);
                byteArrayInputStream.close();
                return u10;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        } else {
            throw e.c("Content found after the end of file");
        }
        throw th;
    }

    @NonNull
    private static d[] u(@NonNull InputStream inputStream, @NonNull byte[] bArr, int i10, d[] dVarArr) throws IOException {
        int i11 = 0;
        if (inputStream.available() == 0) {
            return new d[0];
        }
        if (i10 == dVarArr.length) {
            while (i11 < i10) {
                e.h(inputStream);
                String f10 = e.f(inputStream, e.h(inputStream));
                long i12 = e.i(inputStream);
                int h10 = e.h(inputStream);
                d i13 = i(dVarArr, f10);
                if (i13 != null) {
                    i13.f6159d = i12;
                    int[] m10 = m(inputStream, h10);
                    if (Arrays.equals(bArr, o.f6191e)) {
                        i13.f6160e = h10;
                        i13.f6163h = m10;
                    }
                    i11++;
                } else {
                    throw e.c("Missing profile key: " + f10);
                }
            }
            return dVarArr;
        }
        throw e.c("Mismatched number of dex files found in metadata");
    }

    private static void v(@NonNull InputStream inputStream, @NonNull d dVar) throws IOException {
        BitSet valueOf = BitSet.valueOf(e.d(inputStream, e.a(dVar.f6162g * 2)));
        int i10 = 0;
        while (true) {
            int i11 = dVar.f6162g;
            if (i10 < i11) {
                int n10 = n(valueOf, i10, i11);
                if (n10 != 0) {
                    Integer num = dVar.f6164i.get(Integer.valueOf(i10));
                    if (num == null) {
                        num = 0;
                    }
                    dVar.f6164i.put(Integer.valueOf(i10), Integer.valueOf(n10 | num.intValue()));
                }
                i10++;
            } else {
                return;
            }
        }
    }

    @NonNull
    static d[] w(@NonNull InputStream inputStream, @NonNull byte[] bArr, @NonNull String str) throws IOException {
        if (Arrays.equals(bArr, o.f6188b)) {
            int j10 = e.j(inputStream);
            byte[] e10 = e.e(inputStream, (int) e.i(inputStream), (int) e.i(inputStream));
            if (inputStream.read() <= 0) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(e10);
                try {
                    d[] x10 = x(byteArrayInputStream, str, j10);
                    byteArrayInputStream.close();
                    return x10;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            } else {
                throw e.c("Content found after the end of file");
            }
        } else {
            throw e.c("Unsupported version");
        }
        throw th;
    }

    @NonNull
    private static d[] x(@NonNull InputStream inputStream, @NonNull String str, int i10) throws IOException {
        InputStream inputStream2 = inputStream;
        int i11 = i10;
        if (inputStream.available() == 0) {
            return new d[0];
        }
        d[] dVarArr = new d[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            int h10 = e.h(inputStream);
            int h11 = e.h(inputStream);
            long i13 = e.i(inputStream);
            String str2 = str;
            dVarArr[i12] = new d(str2, e.f(inputStream2, h10), e.i(inputStream), 0, h11, (int) i13, (int) e.i(inputStream), new int[h11], new TreeMap());
        }
        for (int i14 = 0; i14 < i11; i14++) {
            d dVar = dVarArr[i14];
            p(inputStream2, dVar);
            dVar.f6163h = m(inputStream2, dVar.f6160e);
            v(inputStream2, dVar);
        }
        return dVarArr;
    }

    private static int y(int i10) {
        return ((i10 + 8) - 1) & -8;
    }

    private static void z(@NonNull byte[] bArr, int i10, int i11, @NonNull d dVar) {
        int l10 = l(i10, i11, dVar.f6162g);
        int i12 = l10 / 8;
        bArr[i12] = (byte) ((1 << (l10 % 8)) | bArr[i12]);
    }
}
