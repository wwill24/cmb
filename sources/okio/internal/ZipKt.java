package okio.internal;

import com.google.firebase.sessions.settings.RemoteSettings;
import gk.h;
import java.io.IOException;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.j;
import net.bytebuddy.jar.asm.Opcodes;
import okio.BufferedSource;
import okio.FileMetadata;
import okio.Path;
import org.jivesoftware.smack.datatypes.UInt32;

@Metadata(bv = {}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a.\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0000\u001a\"\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00050\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\u0002\u001a\f\u0010\u000f\u001a\u00020\u0005*\u00020\u000eH\u0000\u001a\f\u0010\u0011\u001a\u00020\u0010*\u00020\u000eH\u0002\u001a\u0014\u0010\u0013\u001a\u00020\u0010*\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0010H\u0002\u001a.\u0010\u001a\u001a\u00020\u0018*\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00142\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016H\u0002\u001a\f\u0010\u001b\u001a\u00020\u0018*\u00020\u000eH\u0000\u001a\u0014\u0010\u001e\u001a\u00020\u001c*\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0000\u001a\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c*\u00020\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002\u001a!\u0010\"\u001a\u0004\u0018\u00010\u00172\u0006\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\"\u0010#\"\u0018\u0010'\u001a\u00020$*\u00020\u00148BX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006("}, d2 = {"Lokio/Path;", "zipPath", "Lokio/FileSystem;", "fileSystem", "Lkotlin/Function1;", "Lokio/internal/c;", "", "predicate", "Lokio/ZipFileSystem;", "d", "", "entries", "", "a", "Lokio/BufferedSource;", "e", "Lokio/internal/a;", "f", "regularRecord", "j", "", "extraSize", "Lkotlin/Function2;", "", "", "block", "g", "k", "Lokio/FileMetadata;", "basicMetadata", "h", "i", "date", "time", "b", "(II)Ljava/lang/Long;", "", "c", "(I)Ljava/lang/String;", "hex", "okio"}, k = 2, mv = {1, 6, 0})
public final class ZipKt {

    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "kotlin.jvm.PlatformType", "a", "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    public static final class a<T> implements Comparator {
        public final int compare(T t10, T t11) {
            return b.a(((c) t10).a(), ((c) t11).a());
        }
    }

    private static final Map<Path, c> a(List<c> list) {
        Path e10 = Path.Companion.e(Path.f33379b, RemoteSettings.FORWARD_SLASH_STRING, false, 1, (Object) null);
        Map<Path, c> m10 = h0.m(h.a(e10, new c(e10, true, (String) null, 0, 0, 0, 0, (Long) null, 0, 508, (DefaultConstructorMarker) null)));
        for (c cVar : CollectionsKt___CollectionsKt.q0(list, new a())) {
            if (m10.put(cVar.a(), cVar) == null) {
                while (true) {
                    Path i10 = cVar.a().i();
                    if (i10 == null) {
                        break;
                    }
                    c cVar2 = m10.get(i10);
                    if (cVar2 != null) {
                        cVar2.b().add(cVar.a());
                        break;
                    }
                    c cVar3 = r4;
                    c cVar4 = new c(i10, true, (String) null, 0, 0, 0, 0, (Long) null, 0, 508, (DefaultConstructorMarker) null);
                    c cVar5 = cVar3;
                    m10.put(i10, cVar5);
                    cVar5.b().add(cVar.a());
                    cVar = cVar5;
                }
            }
        }
        return m10;
    }

    private static final Long b(int i10, int i11) {
        if (i11 == -1) {
            return null;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(14, 0);
        GregorianCalendar gregorianCalendar2 = gregorianCalendar;
        gregorianCalendar2.set(((i10 >> 9) & Opcodes.LAND) + 1980, ((i10 >> 5) & 15) - 1, i10 & 31, (i11 >> 11) & 31, (i11 >> 5) & 63, (i11 & 31) << 1);
        return Long.valueOf(gregorianCalendar.getTime().getTime());
    }

    private static final String c(int i10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("0x");
        String num = Integer.toString(i10, b.a(16));
        j.f(num, "toString(this, checkRadix(radix))");
        sb2.append(num);
        return sb2.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r10.close();
        r4 = r4 - ((long) 20);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0058, code lost:
        if (r4 <= 0) goto L_0x00de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005a, code lost:
        r4 = okio.Okio.c(r3.u(r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0069, code lost:
        if (r4.D1() != 117853008) goto L_0x00cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x006b, code lost:
        r5 = r4.D1();
        r12 = r4.D0();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0078, code lost:
        if (r4.D1() != 1) goto L_0x00c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x007a, code lost:
        if (r5 != 0) goto L_0x00c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x007c, code lost:
        r5 = okio.Okio.c(r3.u(r12));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r10 = r5.D1();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008b, code lost:
        if (r10 != 101075792) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008d, code lost:
        r8 = j(r5, r8);
        r10 = kotlin.Unit.f32013a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        kotlin.io.b.a(r5, (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00bd, code lost:
        throw new java.io.IOException("bad zip: expected " + c(101075792) + " but was " + c(r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00be, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c1, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c2, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        kotlin.io.b.a(r5, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c6, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ce, code lost:
        throw new java.io.IOException("unsupported zip: spanned");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00cf, code lost:
        r5 = kotlin.Unit.f32013a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        kotlin.io.b.a(r4, (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00d5, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00d6, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d8, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d9, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        kotlin.io.b.a(r4, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00dd, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00de, code lost:
        r4 = new java.util.ArrayList();
        r5 = okio.Okio.c(r3.u(r8.a()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        r12 = r8.c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00f5, code lost:
        if (r6 >= r12) goto L_0x0122;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00f7, code lost:
        r10 = e(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0105, code lost:
        if (r10.f() >= r8.a()) goto L_0x011a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0111, code lost:
        if (r2.invoke(r10).booleanValue() == false) goto L_0x0116;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0113, code lost:
        r4.add(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0116, code lost:
        r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0121, code lost:
        throw new java.io.IOException("bad zip: local file header offset >= central directory offset");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0122, code lost:
        r2 = kotlin.Unit.f32013a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        kotlin.io.b.a(r5, (java.lang.Throwable) null);
        r4 = new okio.ZipFileSystem(r0, r1, a(r4), r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0130, code lost:
        kotlin.io.b.a(r3, (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0133, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0134, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0135, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0137, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0138, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:?, code lost:
        kotlin.io.b.a(r5, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x013c, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0041, code lost:
        r8 = f(r10);
        r9 = r10.L0((long) r8.b());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final okio.ZipFileSystem d(okio.Path r18, okio.FileSystem r19, kotlin.jvm.functions.Function1<? super okio.internal.c, java.lang.Boolean> r20) throws java.io.IOException {
        /*
            r0 = r18
            r1 = r19
            r2 = r20
            java.lang.String r3 = "zipPath"
            kotlin.jvm.internal.j.g(r0, r3)
            java.lang.String r3 = "fileSystem"
            kotlin.jvm.internal.j.g(r1, r3)
            java.lang.String r3 = "predicate"
            kotlin.jvm.internal.j.g(r2, r3)
            okio.FileHandle r3 = r1.n(r0)
            long r4 = r3.size()     // Catch:{ all -> 0x0171 }
            r6 = 22
            long r6 = (long) r6     // Catch:{ all -> 0x0171 }
            long r4 = r4 - r6
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 < 0) goto L_0x0156
            r8 = 65536(0x10000, double:3.2379E-319)
            long r8 = r4 - r8
            long r8 = java.lang.Math.max(r8, r6)     // Catch:{ all -> 0x0171 }
        L_0x0030:
            okio.Source r10 = r3.u(r4)     // Catch:{ all -> 0x0171 }
            okio.BufferedSource r10 = okio.Okio.c(r10)     // Catch:{ all -> 0x0171 }
            int r11 = r10.D1()     // Catch:{ all -> 0x0151 }
            r12 = 101010256(0x6054b50, float:2.506985E-35)
            if (r11 != r12) goto L_0x013d
            okio.internal.a r8 = f(r10)     // Catch:{ all -> 0x0151 }
            int r9 = r8.b()     // Catch:{ all -> 0x0151 }
            long r11 = (long) r9     // Catch:{ all -> 0x0151 }
            java.lang.String r9 = r10.L0(r11)     // Catch:{ all -> 0x0151 }
            r10.close()     // Catch:{ all -> 0x0171 }
            r10 = 20
            long r10 = (long) r10     // Catch:{ all -> 0x0171 }
            long r4 = r4 - r10
            int r10 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            r11 = 0
            if (r10 <= 0) goto L_0x00de
            okio.Source r4 = r3.u(r4)     // Catch:{ all -> 0x0171 }
            okio.BufferedSource r4 = okio.Okio.c(r4)     // Catch:{ all -> 0x0171 }
            int r5 = r4.D1()     // Catch:{ all -> 0x00d5 }
            r10 = 117853008(0x7064b50, float:1.0103172E-34)
            if (r5 != r10) goto L_0x00cf
            int r5 = r4.D1()     // Catch:{ all -> 0x00d5 }
            long r12 = r4.D0()     // Catch:{ all -> 0x00d5 }
            int r10 = r4.D1()     // Catch:{ all -> 0x00d5 }
            r14 = 1
            if (r10 != r14) goto L_0x00c7
            if (r5 != 0) goto L_0x00c7
            okio.Source r5 = r3.u(r12)     // Catch:{ all -> 0x00d5 }
            okio.BufferedSource r5 = okio.Okio.c(r5)     // Catch:{ all -> 0x00d5 }
            int r10 = r5.D1()     // Catch:{ all -> 0x00be }
            r12 = 101075792(0x6064b50, float:2.525793E-35)
            if (r10 != r12) goto L_0x0097
            okio.internal.a r8 = j(r5, r8)     // Catch:{ all -> 0x00be }
            kotlin.Unit r10 = kotlin.Unit.f32013a     // Catch:{ all -> 0x00be }
            kotlin.io.b.a(r5, r11)     // Catch:{ all -> 0x00d5 }
            goto L_0x00cf
        L_0x0097:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x00be }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00be }
            r1.<init>()     // Catch:{ all -> 0x00be }
            java.lang.String r2 = "bad zip: expected "
            r1.append(r2)     // Catch:{ all -> 0x00be }
            java.lang.String r2 = c(r12)     // Catch:{ all -> 0x00be }
            r1.append(r2)     // Catch:{ all -> 0x00be }
            java.lang.String r2 = " but was "
            r1.append(r2)     // Catch:{ all -> 0x00be }
            java.lang.String r2 = c(r10)     // Catch:{ all -> 0x00be }
            r1.append(r2)     // Catch:{ all -> 0x00be }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00be }
            r0.<init>(r1)     // Catch:{ all -> 0x00be }
            throw r0     // Catch:{ all -> 0x00be }
        L_0x00be:
            r0 = move-exception
            r1 = r0
            throw r1     // Catch:{ all -> 0x00c1 }
        L_0x00c1:
            r0 = move-exception
            r2 = r0
            kotlin.io.b.a(r5, r1)     // Catch:{ all -> 0x00d5 }
            throw r2     // Catch:{ all -> 0x00d5 }
        L_0x00c7:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x00d5 }
            java.lang.String r1 = "unsupported zip: spanned"
            r0.<init>(r1)     // Catch:{ all -> 0x00d5 }
            throw r0     // Catch:{ all -> 0x00d5 }
        L_0x00cf:
            kotlin.Unit r5 = kotlin.Unit.f32013a     // Catch:{ all -> 0x00d5 }
            kotlin.io.b.a(r4, r11)     // Catch:{ all -> 0x0171 }
            goto L_0x00de
        L_0x00d5:
            r0 = move-exception
            r1 = r0
            throw r1     // Catch:{ all -> 0x00d8 }
        L_0x00d8:
            r0 = move-exception
            r2 = r0
            kotlin.io.b.a(r4, r1)     // Catch:{ all -> 0x0171 }
            throw r2     // Catch:{ all -> 0x0171 }
        L_0x00de:
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x0171 }
            r4.<init>()     // Catch:{ all -> 0x0171 }
            long r12 = r8.a()     // Catch:{ all -> 0x0171 }
            okio.Source r5 = r3.u(r12)     // Catch:{ all -> 0x0171 }
            okio.BufferedSource r5 = okio.Okio.c(r5)     // Catch:{ all -> 0x0171 }
            long r12 = r8.c()     // Catch:{ all -> 0x0134 }
        L_0x00f3:
            int r10 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r10 >= 0) goto L_0x0122
            okio.internal.c r10 = e(r5)     // Catch:{ all -> 0x0134 }
            long r14 = r10.f()     // Catch:{ all -> 0x0134 }
            long r16 = r8.a()     // Catch:{ all -> 0x0134 }
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 >= 0) goto L_0x011a
            java.lang.Object r14 = r2.invoke(r10)     // Catch:{ all -> 0x0134 }
            java.lang.Boolean r14 = (java.lang.Boolean) r14     // Catch:{ all -> 0x0134 }
            boolean r14 = r14.booleanValue()     // Catch:{ all -> 0x0134 }
            if (r14 == 0) goto L_0x0116
            r4.add(r10)     // Catch:{ all -> 0x0134 }
        L_0x0116:
            r14 = 1
            long r6 = r6 + r14
            goto L_0x00f3
        L_0x011a:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0134 }
            java.lang.String r1 = "bad zip: local file header offset >= central directory offset"
            r0.<init>(r1)     // Catch:{ all -> 0x0134 }
            throw r0     // Catch:{ all -> 0x0134 }
        L_0x0122:
            kotlin.Unit r2 = kotlin.Unit.f32013a     // Catch:{ all -> 0x0134 }
            kotlin.io.b.a(r5, r11)     // Catch:{ all -> 0x0171 }
            java.util.Map r2 = a(r4)     // Catch:{ all -> 0x0171 }
            okio.ZipFileSystem r4 = new okio.ZipFileSystem     // Catch:{ all -> 0x0171 }
            r4.<init>(r0, r1, r2, r9)     // Catch:{ all -> 0x0171 }
            kotlin.io.b.a(r3, r11)
            return r4
        L_0x0134:
            r0 = move-exception
            r1 = r0
            throw r1     // Catch:{ all -> 0x0137 }
        L_0x0137:
            r0 = move-exception
            r2 = r0
            kotlin.io.b.a(r5, r1)     // Catch:{ all -> 0x0171 }
            throw r2     // Catch:{ all -> 0x0171 }
        L_0x013d:
            r10.close()     // Catch:{ all -> 0x0171 }
            r10 = -1
            long r4 = r4 + r10
            int r10 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r10 < 0) goto L_0x0149
            goto L_0x0030
        L_0x0149:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0171 }
            java.lang.String r1 = "not a zip: end of central directory signature not found"
            r0.<init>(r1)     // Catch:{ all -> 0x0171 }
            throw r0     // Catch:{ all -> 0x0171 }
        L_0x0151:
            r0 = move-exception
            r10.close()     // Catch:{ all -> 0x0171 }
            throw r0     // Catch:{ all -> 0x0171 }
        L_0x0156:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0171 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0171 }
            r1.<init>()     // Catch:{ all -> 0x0171 }
            java.lang.String r2 = "not a zip: size="
            r1.append(r2)     // Catch:{ all -> 0x0171 }
            long r4 = r3.size()     // Catch:{ all -> 0x0171 }
            r1.append(r4)     // Catch:{ all -> 0x0171 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0171 }
            r0.<init>(r1)     // Catch:{ all -> 0x0171 }
            throw r0     // Catch:{ all -> 0x0171 }
        L_0x0171:
            r0 = move-exception
            r1 = r0
            throw r1     // Catch:{ all -> 0x0174 }
        L_0x0174:
            r0 = move-exception
            r2 = r0
            kotlin.io.b.a(r3, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.ZipKt.d(okio.Path, okio.FileSystem, kotlin.jvm.functions.Function1):okio.ZipFileSystem");
    }

    public static final c e(BufferedSource bufferedSource) throws IOException {
        Ref$LongRef ref$LongRef;
        long j10;
        BufferedSource bufferedSource2 = bufferedSource;
        j.g(bufferedSource2, "<this>");
        int D1 = bufferedSource.D1();
        if (D1 == 33639248) {
            bufferedSource2.skip(4);
            short C0 = bufferedSource.C0() & 65535;
            if ((C0 & 1) == 0) {
                short C02 = bufferedSource.C0() & 65535;
                Long b10 = b(bufferedSource.C0() & 65535, bufferedSource.C0() & 65535);
                long D12 = ((long) bufferedSource.D1()) & UInt32.MAX_VALUE_LONG;
                Ref$LongRef ref$LongRef2 = new Ref$LongRef();
                ref$LongRef2.element = ((long) bufferedSource.D1()) & UInt32.MAX_VALUE_LONG;
                Ref$LongRef ref$LongRef3 = new Ref$LongRef();
                ref$LongRef3.element = ((long) bufferedSource.D1()) & UInt32.MAX_VALUE_LONG;
                short C03 = bufferedSource.C0() & 65535;
                short C04 = bufferedSource.C0() & 65535;
                bufferedSource2.skip(8);
                Ref$LongRef ref$LongRef4 = new Ref$LongRef();
                ref$LongRef4.element = ((long) bufferedSource.D1()) & UInt32.MAX_VALUE_LONG;
                String L0 = bufferedSource2.L0((long) (bufferedSource.C0() & 65535));
                if (!StringsKt__StringsKt.N(L0, 0, false, 2, (Object) null)) {
                    if (ref$LongRef3.element == UInt32.MAX_VALUE_LONG) {
                        j10 = ((long) 8) + 0;
                        ref$LongRef = ref$LongRef4;
                    } else {
                        ref$LongRef = ref$LongRef4;
                        j10 = 0;
                    }
                    if (ref$LongRef2.element == UInt32.MAX_VALUE_LONG) {
                        j10 += (long) 8;
                    }
                    String str = L0;
                    Ref$LongRef ref$LongRef5 = ref$LongRef;
                    if (ref$LongRef5.element == UInt32.MAX_VALUE_LONG) {
                        j10 += (long) 8;
                    }
                    long j11 = j10;
                    Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
                    Long l10 = b10;
                    ZipKt$readEntry$1 zipKt$readEntry$1 = r0;
                    long j12 = D12;
                    short s10 = C02;
                    Ref$BooleanRef ref$BooleanRef2 = ref$BooleanRef;
                    String str2 = str;
                    Ref$LongRef ref$LongRef6 = ref$LongRef5;
                    short s11 = C04;
                    ZipKt$readEntry$1 zipKt$readEntry$12 = new ZipKt$readEntry$1(ref$BooleanRef, j11, ref$LongRef3, bufferedSource, ref$LongRef2, ref$LongRef6);
                    g(bufferedSource2, C03, zipKt$readEntry$1);
                    if (j11 <= 0 || ref$BooleanRef2.element) {
                        String str3 = str2;
                        return new c(Path.Companion.e(Path.f33379b, RemoteSettings.FORWARD_SLASH_STRING, false, 1, (Object) null).k(str3), r.s(str3, RemoteSettings.FORWARD_SLASH_STRING, false, 2, (Object) null), bufferedSource2.L0((long) s11), j12, ref$LongRef2.element, ref$LongRef3.element, s10, l10, ref$LongRef6.element);
                    }
                    throw new IOException("bad zip: zip64 extra required but absent");
                }
                throw new IOException("bad zip: filename contains 0x00");
            }
            throw new IOException("unsupported zip: general purpose bit flag=" + c(C0));
        }
        throw new IOException("bad zip: expected " + c(33639248) + " but was " + c(D1));
    }

    private static final a f(BufferedSource bufferedSource) throws IOException {
        short C0 = bufferedSource.C0() & 65535;
        short C02 = bufferedSource.C0() & 65535;
        long C03 = (long) (bufferedSource.C0() & 65535);
        if (C03 == ((long) (bufferedSource.C0() & 65535)) && C0 == 0 && C02 == 0) {
            bufferedSource.skip(4);
            return new a(C03, UInt32.MAX_VALUE_LONG & ((long) bufferedSource.D1()), bufferedSource.C0() & 65535);
        }
        throw new IOException("unsupported zip: spanned");
    }

    private static final void g(BufferedSource bufferedSource, int i10, Function2<? super Integer, ? super Long, Unit> function2) {
        long j10 = (long) i10;
        while (j10 != 0) {
            if (j10 >= 4) {
                short C0 = bufferedSource.C0() & 65535;
                long C02 = ((long) bufferedSource.C0()) & 65535;
                long j11 = j10 - ((long) 4);
                if (j11 >= C02) {
                    bufferedSource.G0(C02);
                    long size = bufferedSource.d().size();
                    function2.invoke(Integer.valueOf(C0), Long.valueOf(C02));
                    long size2 = (bufferedSource.d().size() + C02) - size;
                    int i11 = (size2 > 0 ? 1 : (size2 == 0 ? 0 : -1));
                    if (i11 >= 0) {
                        if (i11 > 0) {
                            bufferedSource.d().skip(size2);
                        }
                        j10 = j11 - C02;
                    } else {
                        throw new IOException("unsupported zip: too many bytes processed for " + C0);
                    }
                } else {
                    throw new IOException("bad zip: truncated value in extra field");
                }
            } else {
                throw new IOException("bad zip: truncated header in extra field");
            }
        }
    }

    public static final FileMetadata h(BufferedSource bufferedSource, FileMetadata fileMetadata) {
        j.g(bufferedSource, "<this>");
        j.g(fileMetadata, "basicMetadata");
        FileMetadata i10 = i(bufferedSource, fileMetadata);
        j.d(i10);
        return i10;
    }

    private static final FileMetadata i(BufferedSource bufferedSource, FileMetadata fileMetadata) {
        T t10;
        BufferedSource bufferedSource2 = bufferedSource;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        if (fileMetadata != null) {
            t10 = fileMetadata.c();
        } else {
            t10 = null;
        }
        ref$ObjectRef.element = t10;
        Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
        int D1 = bufferedSource.D1();
        if (D1 == 67324752) {
            bufferedSource2.skip(2);
            short C0 = bufferedSource.C0() & 65535;
            if ((C0 & 1) == 0) {
                bufferedSource2.skip(18);
                short C02 = bufferedSource.C0() & 65535;
                bufferedSource2.skip(((long) bufferedSource.C0()) & 65535);
                if (fileMetadata == null) {
                    bufferedSource2.skip((long) C02);
                    return null;
                }
                g(bufferedSource2, C02, new ZipKt$readOrSkipLocalHeader$1(bufferedSource2, ref$ObjectRef, ref$ObjectRef2, ref$ObjectRef3));
                return new FileMetadata(fileMetadata.g(), fileMetadata.f(), (Path) null, fileMetadata.d(), (Long) ref$ObjectRef3.element, (Long) ref$ObjectRef.element, (Long) ref$ObjectRef2.element, (Map) null, 128, (DefaultConstructorMarker) null);
            }
            throw new IOException("unsupported zip: general purpose bit flag=" + c(C0));
        }
        throw new IOException("bad zip: expected " + c(67324752) + " but was " + c(D1));
    }

    private static final a j(BufferedSource bufferedSource, a aVar) throws IOException {
        bufferedSource.skip(12);
        int D1 = bufferedSource.D1();
        int D12 = bufferedSource.D1();
        long D0 = bufferedSource.D0();
        if (D0 == bufferedSource.D0() && D1 == 0 && D12 == 0) {
            bufferedSource.skip(8);
            return new a(D0, bufferedSource.D0(), aVar.b());
        }
        throw new IOException("unsupported zip: spanned");
    }

    public static final void k(BufferedSource bufferedSource) {
        j.g(bufferedSource, "<this>");
        i(bufferedSource, (FileMetadata) null);
    }
}
