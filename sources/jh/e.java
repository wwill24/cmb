package jh;

import com.google.android.gms.common.api.a;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import org.apache.commons.beanutils.PropertyUtils;

public class e implements d {

    /* renamed from: a  reason: collision with root package name */
    private final int[] f23586a;

    /* renamed from: b  reason: collision with root package name */
    private final int f23587b;

    private static final class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final char f23588a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final int f23589b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final b f23590c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final int f23591d;

        /* access modifiers changed from: package-private */
        public boolean e() {
            return this.f23588a == 1000;
        }

        private b(char c10, c cVar, int i10, b bVar, int i11) {
            int i12;
            int i13;
            char c11 = c10 == i11 ? 1000 : c10;
            this.f23588a = c11;
            this.f23589b = i10;
            this.f23590c = bVar;
            if (c11 == 1000) {
                i12 = 1;
            } else {
                i12 = cVar.b(c10, i10).length;
            }
            if (bVar == null) {
                i13 = 0;
            } else {
                i13 = bVar.f23589b;
            }
            i12 = i13 != i10 ? i12 + 3 : i12;
            this.f23591d = bVar != null ? i12 + bVar.f23591d : i12;
        }
    }

    public e(String str, Charset charset, int i10) {
        this.f23587b = i10;
        c cVar = new c(str, charset, i10);
        if (cVar.g() == 1) {
            this.f23586a = new int[str.length()];
            for (int i11 = 0; i11 < this.f23586a.length; i11++) {
                int charAt = str.charAt(i11);
                int[] iArr = this.f23586a;
                if (charAt == i10) {
                    charAt = 1000;
                }
                iArr[i11] = charAt;
            }
            return;
        }
        this.f23586a = e(str, cVar, i10);
    }

    static void c(b[][] bVarArr, int i10, b bVar) {
        if (bVarArr[i10][bVar.f23589b] == null || bVarArr[i10][bVar.f23589b].f23591d > bVar.f23591d) {
            bVarArr[i10][bVar.f23589b] = bVar;
        }
    }

    static void d(String str, c cVar, b[][] bVarArr, int i10, b bVar, int i11) {
        int i12;
        int i13;
        c cVar2 = cVar;
        int i14 = i10;
        String str2 = str;
        int i15 = i11;
        char charAt = str.charAt(i14);
        int g10 = cVar.g();
        if (cVar.f() < 0 || (charAt != i15 && !cVar2.a(charAt, cVar.f()))) {
            i12 = g10;
            i13 = 0;
        } else {
            i13 = cVar.f();
            i12 = i13 + 1;
        }
        for (int i16 = i13; i16 < i12; i16++) {
            if (charAt == i15 || cVar2.a(charAt, i16)) {
                c(bVarArr, i14 + 1, new b(charAt, cVar, i16, bVar, i11));
            } else {
                b[][] bVarArr2 = bVarArr;
            }
        }
    }

    static int[] e(String str, c cVar, int i10) {
        int i11;
        int length = str.length();
        int[] iArr = new int[2];
        iArr[1] = cVar.g();
        iArr[0] = length + 1;
        b[][] bVarArr = (b[][]) Array.newInstance(b.class, iArr);
        d(str, cVar, bVarArr, 0, (b) null, i10);
        for (int i12 = 1; i12 <= length; i12++) {
            for (int i13 = 0; i13 < cVar.g(); i13++) {
                b bVar = bVarArr[i12][i13];
                if (bVar != null && i12 < length) {
                    d(str, cVar, bVarArr, i12, bVar, i10);
                }
            }
            for (int i14 = 0; i14 < cVar.g(); i14++) {
                bVarArr[i12 - 1][i14] = null;
            }
        }
        int i15 = a.e.API_PRIORITY_OTHER;
        int i16 = -1;
        for (int i17 = 0; i17 < cVar.g(); i17++) {
            b bVar2 = bVarArr[length][i17];
            if (bVar2 != null && bVar2.f23591d < i15) {
                i15 = bVar2.f23591d;
                i16 = i17;
            }
        }
        if (i16 >= 0) {
            ArrayList arrayList = new ArrayList();
            for (b bVar3 = bVarArr[length][i16]; bVar3 != null; bVar3 = bVar3.f23590c) {
                if (bVar3.e()) {
                    arrayList.add(0, 1000);
                } else {
                    byte[] b10 = cVar.b(bVar3.f23588a, bVar3.f23589b);
                    for (int length2 = b10.length - 1; length2 >= 0; length2--) {
                        arrayList.add(0, Integer.valueOf(b10[length2] & 255));
                    }
                }
                if (bVar3.f23590c == null) {
                    i11 = 0;
                } else {
                    i11 = bVar3.f23590c.f23589b;
                }
                if (i11 != bVar3.f23589b) {
                    arrayList.add(0, Integer.valueOf(cVar.e(bVar3.f23589b) + 256));
                }
            }
            int size = arrayList.size();
            int[] iArr2 = new int[size];
            for (int i18 = 0; i18 < size; i18++) {
                iArr2[i18] = ((Integer) arrayList.get(i18)).intValue();
            }
            return iArr2;
        }
        throw new IllegalStateException("Failed to encode \"" + str + "\"");
    }

    public boolean a(int i10) {
        if (i10 < 0 || i10 >= length()) {
            throw new IndexOutOfBoundsException("" + i10);
        }
        int i11 = this.f23586a[i10];
        if (i11 <= 255 || i11 > 999) {
            return false;
        }
        return true;
    }

    public int b(int i10) {
        if (i10 < 0 || i10 >= length()) {
            throw new IndexOutOfBoundsException("" + i10);
        } else if (a(i10)) {
            return this.f23586a[i10] - 256;
        } else {
            throw new IllegalArgumentException("value at " + i10 + " is not an ECI but a character");
        }
    }

    public char charAt(int i10) {
        int i11;
        if (i10 < 0 || i10 >= length()) {
            throw new IndexOutOfBoundsException("" + i10);
        } else if (!a(i10)) {
            if (h(i10)) {
                i11 = this.f23587b;
            } else {
                i11 = this.f23586a[i10];
            }
            return (char) i11;
        } else {
            throw new IllegalArgumentException("value at " + i10 + " is not a character but an ECI");
        }
    }

    public int f() {
        return this.f23587b;
    }

    public boolean g(int i10, int i11) {
        if ((i10 + i11) - 1 >= this.f23586a.length) {
            return false;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            if (a(i10 + i12)) {
                return false;
            }
        }
        return true;
    }

    public boolean h(int i10) {
        if (i10 < 0 || i10 >= length()) {
            throw new IndexOutOfBoundsException("" + i10);
        } else if (this.f23586a[i10] == 1000) {
            return true;
        } else {
            return false;
        }
    }

    public int length() {
        return this.f23586a.length;
    }

    public CharSequence subSequence(int i10, int i11) {
        if (i10 < 0 || i10 > i11 || i11 > length()) {
            throw new IndexOutOfBoundsException("" + i10);
        }
        StringBuilder sb2 = new StringBuilder();
        while (i10 < i11) {
            if (!a(i10)) {
                sb2.append(charAt(i10));
                i10++;
            } else {
                throw new IllegalArgumentException("value at " + i10 + " is not a character but an ECI");
            }
        }
        return sb2;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < length(); i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            if (a(i10)) {
                sb2.append("ECI(");
                sb2.append(b(i10));
                sb2.append(PropertyUtils.MAPPED_DELIM2);
            } else if (charAt(i10) < 128) {
                sb2.append('\'');
                sb2.append(charAt(i10));
                sb2.append('\'');
            } else {
                sb2.append(charAt(i10));
            }
        }
        return sb2.toString();
    }
}
