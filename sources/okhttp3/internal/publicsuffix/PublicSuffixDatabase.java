package okhttp3.internal.publicsuffix;

import bl.d;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00138\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u000b\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\n\u0010\u0014¨\u0006\u0019"}, d2 = {"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "", "", "domain", "", "f", "domainLabels", "b", "", "e", "d", "c", "Ljava/util/concurrent/atomic/AtomicBoolean;", "a", "Ljava/util/concurrent/atomic/AtomicBoolean;", "listRead", "Ljava/util/concurrent/CountDownLatch;", "Ljava/util/concurrent/CountDownLatch;", "readCompleteLatch", "", "[B", "publicSuffixListBytes", "publicSuffixExceptionListBytes", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class PublicSuffixDatabase {

    /* renamed from: e  reason: collision with root package name */
    public static final a f33105e = new a((DefaultConstructorMarker) null);

    /* renamed from: f  reason: collision with root package name */
    private static final byte[] f33106f = {42};

    /* renamed from: g  reason: collision with root package name */
    private static final List<String> f33107g = p.e("*");
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static final PublicSuffixDatabase f33108h = new PublicSuffixDatabase();

    /* renamed from: a  reason: collision with root package name */
    private final AtomicBoolean f33109a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    private final CountDownLatch f33110b = new CountDownLatch(1);

    /* renamed from: c  reason: collision with root package name */
    private byte[] f33111c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f33112d;

    @Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J+\u0010\b\u001a\u0004\u0018\u00010\u0007*\u00020\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u000b\u001a\u00020\nR\u0014\u0010\r\u001a\u00020\f8\u0002XT¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00078\u0006XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase$a;", "", "", "", "labels", "", "labelIndex", "", "b", "([B[[BI)Ljava/lang/String;", "Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "c", "", "EXCEPTION_MARKER", "C", "", "PREVAILING_RULE", "Ljava/util/List;", "PUBLIC_SUFFIX_RESOURCE", "Ljava/lang/String;", "WILDCARD_LABEL", "[B", "instance", "Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final String b(byte[] bArr, byte[][] bArr2, int i10) {
            int i11;
            boolean z10;
            int i12;
            int d10;
            byte[] bArr3 = bArr;
            byte[][] bArr4 = bArr2;
            int length = bArr3.length;
            int i13 = 0;
            while (i13 < length) {
                int i14 = (i13 + length) / 2;
                while (i14 > -1 && bArr3[i14] != 10) {
                    i14--;
                }
                int i15 = i14 + 1;
                int i16 = 1;
                while (true) {
                    i11 = i15 + i16;
                    if (bArr3[i11] == 10) {
                        break;
                    }
                    i16++;
                }
                int i17 = i11 - i15;
                int i18 = i10;
                boolean z11 = false;
                int i19 = 0;
                int i20 = 0;
                while (true) {
                    if (z11) {
                        i12 = 46;
                        z10 = false;
                    } else {
                        z10 = z11;
                        i12 = d.d(bArr4[i18][i19], 255);
                    }
                    d10 = i12 - d.d(bArr3[i15 + i20], 255);
                    if (d10 == 0) {
                        i20++;
                        i19++;
                        if (i20 == i17) {
                            break;
                        } else if (bArr4[i18].length != i19) {
                            z11 = z10;
                        } else if (i18 == bArr4.length - 1) {
                            break;
                        } else {
                            i18++;
                            i19 = -1;
                            z11 = true;
                        }
                    } else {
                        break;
                    }
                }
                if (d10 >= 0) {
                    if (d10 <= 0) {
                        int i21 = i17 - i20;
                        int length2 = bArr4[i18].length - i19;
                        int length3 = bArr4.length;
                        for (int i22 = i18 + 1; i22 < length3; i22++) {
                            length2 += bArr4[i22].length;
                        }
                        if (length2 >= i21) {
                            if (length2 <= i21) {
                                Charset charset = StandardCharsets.UTF_8;
                                j.f(charset, "UTF_8");
                                return new String(bArr3, i15, i17, charset);
                            }
                        }
                    }
                    i13 = i11 + 1;
                }
                length = i15 - 1;
            }
            return null;
        }

        public final PublicSuffixDatabase c() {
            return PublicSuffixDatabase.f33108h;
        }
    }

    private final List<String> b(List<String> list) {
        boolean z10;
        List<String> list2;
        String str;
        String str2;
        String str3;
        List<String> list3;
        if (this.f33109a.get() || !this.f33109a.compareAndSet(false, true)) {
            try {
                this.f33110b.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            e();
        }
        if (this.f33111c != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            int size = list.size();
            byte[][] bArr = new byte[size][];
            for (int i10 = 0; i10 < size; i10++) {
                Charset charset = StandardCharsets.UTF_8;
                j.f(charset, "UTF_8");
                byte[] bytes = list.get(i10).getBytes(charset);
                j.f(bytes, "this as java.lang.String).getBytes(charset)");
                bArr[i10] = bytes;
            }
            int i11 = 0;
            while (true) {
                list2 = null;
                if (i11 >= size) {
                    str = null;
                    break;
                }
                int i12 = i11 + 1;
                a aVar = f33105e;
                byte[] bArr2 = this.f33111c;
                if (bArr2 == null) {
                    j.y("publicSuffixListBytes");
                    bArr2 = null;
                }
                String a10 = aVar.b(bArr2, bArr, i11);
                if (a10 != null) {
                    str = a10;
                    break;
                }
                i11 = i12;
            }
            if (size > 1) {
                byte[][] bArr3 = (byte[][]) bArr.clone();
                int length = bArr3.length - 1;
                int i13 = 0;
                while (true) {
                    if (i13 >= length) {
                        break;
                    }
                    int i14 = i13 + 1;
                    bArr3[i13] = f33106f;
                    a aVar2 = f33105e;
                    byte[] bArr4 = this.f33111c;
                    if (bArr4 == null) {
                        j.y("publicSuffixListBytes");
                        bArr4 = null;
                    }
                    String a11 = aVar2.b(bArr4, bArr3, i13);
                    if (a11 != null) {
                        str2 = a11;
                        break;
                    }
                    i13 = i14;
                }
            }
            str2 = null;
            if (str2 != null) {
                int i15 = size - 1;
                int i16 = 0;
                while (true) {
                    if (i16 >= i15) {
                        break;
                    }
                    int i17 = i16 + 1;
                    a aVar3 = f33105e;
                    byte[] bArr5 = this.f33112d;
                    if (bArr5 == null) {
                        j.y("publicSuffixExceptionListBytes");
                        bArr5 = null;
                    }
                    str3 = aVar3.b(bArr5, bArr, i16);
                    if (str3 != null) {
                        break;
                    }
                    i16 = i17;
                }
            }
            str3 = null;
            if (str3 != null) {
                return StringsKt__StringsKt.B0(j.p("!", str3), new char[]{'.'}, false, 0, 6, (Object) null);
            } else if (str == null && str2 == null) {
                return f33107g;
            } else {
                if (str == null) {
                    list3 = null;
                } else {
                    list3 = StringsKt__StringsKt.B0(str, new char[]{'.'}, false, 0, 6, (Object) null);
                }
                if (list3 == null) {
                    list3 = q.j();
                }
                if (str2 != null) {
                    list2 = StringsKt__StringsKt.B0(str2, new char[]{'.'}, false, 0, 6, (Object) null);
                }
                if (list2 == null) {
                    list2 = q.j();
                }
                if (list3.size() > list2.size()) {
                    return list3;
                }
                return list2;
            }
        } else {
            throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.".toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0047, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0048, code lost:
        kotlin.io.b.a(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004b, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void d() throws java.io.IOException {
        /*
            r5 = this;
            java.lang.Class<okhttp3.internal.publicsuffix.PublicSuffixDatabase> r0 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.class
            java.lang.String r1 = "publicsuffixes.gz"
            java.io.InputStream r0 = r0.getResourceAsStream(r1)
            if (r0 != 0) goto L_0x000b
            return
        L_0x000b:
            okio.GzipSource r1 = new okio.GzipSource
            okio.Source r0 = okio.Okio.j(r0)
            r1.<init>(r0)
            okio.BufferedSource r0 = okio.Okio.c(r1)
            r1 = 0
            int r2 = r0.readInt()     // Catch:{ all -> 0x0045 }
            long r2 = (long) r2     // Catch:{ all -> 0x0045 }
            byte[] r2 = r0.y0(r2)     // Catch:{ all -> 0x0045 }
            int r3 = r0.readInt()     // Catch:{ all -> 0x0045 }
            long r3 = (long) r3     // Catch:{ all -> 0x0045 }
            byte[] r3 = r0.y0(r3)     // Catch:{ all -> 0x0045 }
            kotlin.Unit r4 = kotlin.Unit.f32013a     // Catch:{ all -> 0x0045 }
            kotlin.io.b.a(r0, r1)
            monitor-enter(r5)
            kotlin.jvm.internal.j.d(r2)     // Catch:{ all -> 0x0042 }
            r5.f33111c = r2     // Catch:{ all -> 0x0042 }
            kotlin.jvm.internal.j.d(r3)     // Catch:{ all -> 0x0042 }
            r5.f33112d = r3     // Catch:{ all -> 0x0042 }
            monitor-exit(r5)
            java.util.concurrent.CountDownLatch r0 = r5.f33110b
            r0.countDown()
            return
        L_0x0042:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        L_0x0045:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0047 }
        L_0x0047:
            r2 = move-exception
            kotlin.io.b.a(r0, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.publicsuffix.PublicSuffixDatabase.d():void");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0027 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void e() {
        /*
            r5 = this;
            r0 = 0
        L_0x0001:
            r5.d()     // Catch:{ InterruptedIOException -> 0x0027, IOException -> 0x0010 }
            if (r0 == 0) goto L_0x000d
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x000d:
            return
        L_0x000e:
            r1 = move-exception
            goto L_0x002c
        L_0x0010:
            r1 = move-exception
            il.j$a r2 = il.j.f30050a     // Catch:{ all -> 0x000e }
            il.j r2 = r2.g()     // Catch:{ all -> 0x000e }
            java.lang.String r3 = "Failed to read public suffix list"
            r4 = 5
            r2.j(r3, r4, r1)     // Catch:{ all -> 0x000e }
            if (r0 == 0) goto L_0x0026
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x0026:
            return
        L_0x0027:
            java.lang.Thread.interrupted()     // Catch:{ all -> 0x000e }
            r0 = 1
            goto L_0x0001
        L_0x002c:
            if (r0 == 0) goto L_0x0035
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x0035:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.publicsuffix.PublicSuffixDatabase.e():void");
    }

    private final List<String> f(String str) {
        List<String> B0 = StringsKt__StringsKt.B0(str, new char[]{'.'}, false, 0, 6, (Object) null);
        if (j.b(CollectionsKt___CollectionsKt.Y(B0), "")) {
            return CollectionsKt___CollectionsKt.H(B0, 1);
        }
        return B0;
    }

    public final String c(String str) {
        int i10;
        int i11;
        j.g(str, "domain");
        String unicode = IDN.toUnicode(str);
        j.f(unicode, "unicodeDomain");
        List<String> f10 = f(unicode);
        List<String> b10 = b(f10);
        if (f10.size() == b10.size() && b10.get(0).charAt(0) != '!') {
            return null;
        }
        if (b10.get(0).charAt(0) == '!') {
            i11 = f10.size();
            i10 = b10.size();
        } else {
            i11 = f10.size();
            i10 = b10.size() + 1;
        }
        return SequencesKt___SequencesKt.p(SequencesKt___SequencesKt.h(CollectionsKt___CollectionsKt.D(f(str)), i11 - i10), ".", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }
}
