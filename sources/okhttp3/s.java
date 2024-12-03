package okhttp3;

import bl.d;
import gk.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import kk.c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.o;
import org.jivesoftware.smackx.shim.packet.HeadersExtension;

@Metadata(bv = {}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\b\u0018\u0000 \u00052\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0002\u001b\u0005B\u0017\b\u0002\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a¢\u0006\u0004\b \u0010!J\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bJ\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\fJ\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010\u0004\u001a\u00020\u0003J\u001b\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0010H\u0002J\u0006\u0010\u0013\u001a\u00020\u0012J\u0013\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001e\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lokhttp3/s;", "", "Lkotlin/Pair;", "", "name", "b", "Ljava/util/Date;", "d", "", "index", "f", "n", "", "g", "", "o", "", "iterator", "Lokhttp3/s$a;", "j", "", "other", "", "equals", "hashCode", "toString", "", "a", "[Ljava/lang/String;", "namesAndValues", "size", "()I", "<init>", "([Ljava/lang/String;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class s implements Iterable<Pair<? extends String, ? extends String>>, qk.a {

    /* renamed from: b  reason: collision with root package name */
    public static final b f33166b = new b((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final String[] f33167a;

    @Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002J\u0016\u0010\t\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nJ\u001f\u0010\r\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0002J\u0019\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u0006\u0010\u0011\u001a\u00020\nR \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00128\u0000X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lokhttp3/s$a;", "", "", "line", "c", "(Ljava/lang/String;)Lokhttp3/s$a;", "name", "value", "a", "e", "Lokhttp3/s;", "headers", "b", "d", "(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/s$a;", "h", "i", "f", "", "Ljava/util/List;", "g", "()Ljava/util/List;", "namesAndValues", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List<String> f33168a = new ArrayList(20);

        public final a a(String str, String str2) {
            j.g(str, "name");
            j.g(str2, "value");
            b bVar = s.f33166b;
            bVar.d(str);
            bVar.e(str2, str);
            d(str, str2);
            return this;
        }

        public final a b(s sVar) {
            j.g(sVar, HeadersExtension.ELEMENT);
            int size = sVar.size();
            for (int i10 = 0; i10 < size; i10++) {
                d(sVar.f(i10), sVar.n(i10));
            }
            return this;
        }

        public final a c(String str) {
            j.g(str, "line");
            int a02 = StringsKt__StringsKt.a0(str, ':', 1, false, 4, (Object) null);
            if (a02 != -1) {
                String substring = str.substring(0, a02);
                j.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                String substring2 = str.substring(a02 + 1);
                j.f(substring2, "this as java.lang.String).substring(startIndex)");
                d(substring, substring2);
            } else if (str.charAt(0) == ':') {
                String substring3 = str.substring(1);
                j.f(substring3, "this as java.lang.String).substring(startIndex)");
                d("", substring3);
            } else {
                d("", str);
            }
            return this;
        }

        public final a d(String str, String str2) {
            j.g(str, "name");
            j.g(str2, "value");
            g().add(str);
            g().add(StringsKt__StringsKt.W0(str2).toString());
            return this;
        }

        public final a e(String str, String str2) {
            j.g(str, "name");
            j.g(str2, "value");
            s.f33166b.d(str);
            d(str, str2);
            return this;
        }

        public final s f() {
            Object[] array2 = this.f33168a.toArray(new String[0]);
            if (array2 != null) {
                return new s((String[]) array2, (DefaultConstructorMarker) null);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }

        public final List<String> g() {
            return this.f33168a;
        }

        public final a h(String str) {
            j.g(str, "name");
            int i10 = 0;
            while (i10 < g().size()) {
                if (r.t(str, g().get(i10), true)) {
                    g().remove(i10);
                    g().remove(i10);
                    i10 -= 2;
                }
                i10 += 2;
            }
            return this;
        }

        public final a i(String str, String str2) {
            j.g(str, "name");
            j.g(str2, "value");
            b bVar = s.f33166b;
            bVar.d(str);
            bVar.e(str2, str);
            h(str);
            d(str, str2);
            return this;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J#\u0010\r\u001a\u00020\f2\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003H\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lokhttp3/s$b;", "", "", "", "namesAndValues", "name", "f", "([Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "", "d", "value", "e", "Lokhttp3/s;", "g", "([Ljava/lang/String;)Lokhttp3/s;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final void d(String str) {
            boolean z10;
            boolean z11;
            if (str.length() > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                int length = str.length();
                int i10 = 0;
                while (i10 < length) {
                    int i11 = i10 + 1;
                    char charAt = str.charAt(i10);
                    if ('!' > charAt || charAt >= 127) {
                        z11 = false;
                    } else {
                        z11 = true;
                    }
                    if (z11) {
                        i10 = i11;
                    } else {
                        throw new IllegalArgumentException(d.t("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i10), str).toString());
                    }
                }
                return;
            }
            throw new IllegalArgumentException("name is empty".toString());
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x005b A[LOOP:0: B:1:0x0006->B:20:0x005b, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0026 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void e(java.lang.String r8, java.lang.String r9) {
            /*
                r7 = this;
                int r0 = r8.length()
                r1 = 0
                r2 = r1
            L_0x0006:
                if (r2 >= r0) goto L_0x005d
                int r3 = r2 + 1
                char r4 = r8.charAt(r2)
                r5 = 9
                r6 = 1
                if (r4 == r5) goto L_0x0023
                r5 = 32
                if (r5 > r4) goto L_0x001d
                r5 = 127(0x7f, float:1.78E-43)
                if (r4 >= r5) goto L_0x001d
                r5 = r6
                goto L_0x001e
            L_0x001d:
                r5 = r1
            L_0x001e:
                if (r5 == 0) goto L_0x0021
                goto L_0x0023
            L_0x0021:
                r5 = r1
                goto L_0x0024
            L_0x0023:
                r5 = r6
            L_0x0024:
                if (r5 != 0) goto L_0x005b
                r0 = 3
                java.lang.Object[] r0 = new java.lang.Object[r0]
                java.lang.Integer r3 = java.lang.Integer.valueOf(r4)
                r0[r1] = r3
                java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
                r0[r6] = r1
                r1 = 2
                r0[r1] = r9
                java.lang.String r1 = "Unexpected char %#04x at %d in %s value"
                java.lang.String r0 = bl.d.t(r1, r0)
                boolean r9 = bl.d.G(r9)
                if (r9 == 0) goto L_0x0047
                java.lang.String r8 = ""
                goto L_0x004d
            L_0x0047:
                java.lang.String r9 = ": "
                java.lang.String r8 = kotlin.jvm.internal.j.p(r9, r8)
            L_0x004d:
                java.lang.String r8 = kotlin.jvm.internal.j.p(r0, r8)
                java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
                java.lang.String r8 = r8.toString()
                r9.<init>(r8)
                throw r9
            L_0x005b:
                r2 = r3
                goto L_0x0006
            L_0x005d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.s.b.e(java.lang.String, java.lang.String):void");
        }

        /* access modifiers changed from: private */
        public final String f(String[] strArr, String str) {
            int length = strArr.length - 2;
            int c10 = c.c(length, 0, -2);
            if (c10 > length) {
                return null;
            }
            while (true) {
                int i10 = length - 2;
                if (r.t(str, strArr[length], true)) {
                    return strArr[length + 1];
                }
                if (length == c10) {
                    return null;
                }
                length = i10;
            }
        }

        public final s g(String... strArr) {
            boolean z10;
            boolean z11;
            j.g(strArr, "namesAndValues");
            int i10 = 0;
            if (strArr.length % 2 == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                String[] strArr2 = (String[]) strArr.clone();
                int length = strArr2.length;
                int i11 = 0;
                while (i11 < length) {
                    int i12 = i11 + 1;
                    String str = strArr2[i11];
                    if (str != null) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (z11) {
                        strArr2[i11] = StringsKt__StringsKt.W0(str).toString();
                        i11 = i12;
                    } else {
                        throw new IllegalArgumentException("Headers cannot be null".toString());
                    }
                }
                int c10 = c.c(0, strArr2.length - 1, 2);
                if (c10 >= 0) {
                    while (true) {
                        int i13 = i10 + 2;
                        String str2 = strArr2[i10];
                        String str3 = strArr2[i10 + 1];
                        d(str2);
                        e(str3, str2);
                        if (i10 == c10) {
                            break;
                        }
                        i10 = i13;
                    }
                }
                return new s(strArr2, (DefaultConstructorMarker) null);
            }
            throw new IllegalArgumentException("Expected alternating header names and values".toString());
        }
    }

    private s(String[] strArr) {
        this.f33167a = strArr;
    }

    public /* synthetic */ s(String[] strArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(strArr);
    }

    public static final s m(String... strArr) {
        return f33166b.g(strArr);
    }

    public final String b(String str) {
        j.g(str, "name");
        return f33166b.f(this.f33167a, str);
    }

    public final Date d(String str) {
        j.g(str, "name");
        String b10 = b(str);
        if (b10 == null) {
            return null;
        }
        return fl.c.a(b10);
    }

    public boolean equals(Object obj) {
        return (obj instanceof s) && Arrays.equals(this.f33167a, ((s) obj).f33167a);
    }

    public final String f(int i10) {
        return this.f33167a[i10 * 2];
    }

    public final Set<String> g() {
        TreeSet treeSet = new TreeSet(r.v(o.f32141a));
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            treeSet.add(f(i10));
        }
        Set<String> unmodifiableSet = Collections.unmodifiableSet(treeSet);
        j.f(unmodifiableSet, "unmodifiableSet(result)");
        return unmodifiableSet;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f33167a);
    }

    public Iterator<Pair<String, String>> iterator() {
        int size = size();
        Pair[] pairArr = new Pair[size];
        for (int i10 = 0; i10 < size; i10++) {
            pairArr[i10] = h.a(f(i10), n(i10));
        }
        return kotlin.jvm.internal.b.a(pairArr);
    }

    public final a j() {
        a aVar = new a();
        boolean unused = v.y(aVar.g(), this.f33167a);
        return aVar;
    }

    public final String n(int i10) {
        return this.f33167a[(i10 * 2) + 1];
    }

    public final List<String> o(String str) {
        j.g(str, "name");
        int size = size();
        ArrayList arrayList = null;
        int i10 = 0;
        while (i10 < size) {
            int i11 = i10 + 1;
            if (r.t(str, f(i10), true)) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(n(i10));
            }
            i10 = i11;
        }
        if (arrayList == null) {
            return q.j();
        }
        List<String> unmodifiableList = Collections.unmodifiableList(arrayList);
        j.f(unmodifiableList, "{\n      Collections.unmodifiableList(result)\n    }");
        return unmodifiableList;
    }

    public final int size() {
        return this.f33167a.length / 2;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        int size = size();
        int i10 = 0;
        while (i10 < size) {
            int i11 = i10 + 1;
            String f10 = f(i10);
            String n10 = n(i10);
            sb2.append(f10);
            sb2.append(": ");
            if (d.G(f10)) {
                n10 = "██";
            }
            sb2.append(n10);
            sb2.append("\n");
            i10 = i11;
        }
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }
}
