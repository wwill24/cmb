package okio;

import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import wk.c;

@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0016\u0018\u00002\u00020\u0001Bq\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\u0018\b\u0002\u0010\u000e\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0004\b%\u0010&Jw\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0018\b\u0002\u0010\u000e\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u001eR\u0019\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001d\u001a\u0004\b\u001f\u0010\u001eR\u0019\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u001d\u001a\u0004\b\u0018\u0010\u001eR\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u001d\u001a\u0004\b \u0010\u001eR'\u0010\u000e\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0004\u0012\u00020\u00010\f8\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lokio/FileMetadata;", "", "", "isRegularFile", "isDirectory", "Lokio/Path;", "symlinkTarget", "", "size", "createdAtMillis", "lastModifiedAtMillis", "lastAccessedAtMillis", "", "Lwk/c;", "extras", "a", "(ZZLokio/Path;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/Map;)Lokio/FileMetadata;", "", "toString", "Z", "g", "()Z", "b", "f", "c", "Lokio/Path;", "e", "()Lokio/Path;", "d", "Ljava/lang/Long;", "()Ljava/lang/Long;", "getCreatedAtMillis", "getLastAccessedAtMillis", "h", "Ljava/util/Map;", "getExtras", "()Ljava/util/Map;", "<init>", "(ZZLokio/Path;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/Map;)V", "okio"}, k = 1, mv = {1, 6, 0})
public final class FileMetadata {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f33334a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f33335b;

    /* renamed from: c  reason: collision with root package name */
    private final Path f33336c;

    /* renamed from: d  reason: collision with root package name */
    private final Long f33337d;

    /* renamed from: e  reason: collision with root package name */
    private final Long f33338e;

    /* renamed from: f  reason: collision with root package name */
    private final Long f33339f;

    /* renamed from: g  reason: collision with root package name */
    private final Long f33340g;

    /* renamed from: h  reason: collision with root package name */
    private final Map<c<?>, Object> f33341h;

    public FileMetadata() {
        this(false, false, (Path) null, (Long) null, (Long) null, (Long) null, (Long) null, (Map) null, 255, (DefaultConstructorMarker) null);
    }

    public FileMetadata(boolean z10, boolean z11, Path path, Long l10, Long l11, Long l12, Long l13, Map<c<?>, ? extends Object> map) {
        j.g(map, "extras");
        this.f33334a = z10;
        this.f33335b = z11;
        this.f33336c = path;
        this.f33337d = l10;
        this.f33338e = l11;
        this.f33339f = l12;
        this.f33340g = l13;
        this.f33341h = h0.u(map);
    }

    public static /* synthetic */ FileMetadata b(FileMetadata fileMetadata, boolean z10, boolean z11, Path path, Long l10, Long l11, Long l12, Long l13, Map map, int i10, Object obj) {
        boolean z12;
        boolean z13;
        Path path2;
        Long l14;
        Long l15;
        Long l16;
        Long l17;
        Map map2;
        FileMetadata fileMetadata2 = fileMetadata;
        int i11 = i10;
        if ((i11 & 1) != 0) {
            z12 = fileMetadata2.f33334a;
        } else {
            z12 = z10;
        }
        if ((i11 & 2) != 0) {
            z13 = fileMetadata2.f33335b;
        } else {
            z13 = z11;
        }
        if ((i11 & 4) != 0) {
            path2 = fileMetadata2.f33336c;
        } else {
            path2 = path;
        }
        if ((i11 & 8) != 0) {
            l14 = fileMetadata2.f33337d;
        } else {
            l14 = l10;
        }
        if ((i11 & 16) != 0) {
            l15 = fileMetadata2.f33338e;
        } else {
            l15 = l11;
        }
        if ((i11 & 32) != 0) {
            l16 = fileMetadata2.f33339f;
        } else {
            l16 = l12;
        }
        if ((i11 & 64) != 0) {
            l17 = fileMetadata2.f33340g;
        } else {
            l17 = l13;
        }
        if ((i11 & 128) != 0) {
            map2 = fileMetadata2.f33341h;
        } else {
            map2 = map;
        }
        return fileMetadata.a(z12, z13, path2, l14, l15, l16, l17, map2);
    }

    public final FileMetadata a(boolean z10, boolean z11, Path path, Long l10, Long l11, Long l12, Long l13, Map<c<?>, ? extends Object> map) {
        Map<c<?>, ? extends Object> map2 = map;
        j.g(map2, "extras");
        return new FileMetadata(z10, z11, path, l10, l11, l12, l13, map2);
    }

    public final Long c() {
        return this.f33339f;
    }

    public final Long d() {
        return this.f33337d;
    }

    public final Path e() {
        return this.f33336c;
    }

    public final boolean f() {
        return this.f33335b;
    }

    public final boolean g() {
        return this.f33334a;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        if (this.f33334a) {
            arrayList.add("isRegularFile");
        }
        if (this.f33335b) {
            arrayList.add("isDirectory");
        }
        if (this.f33337d != null) {
            arrayList.add("byteCount=" + this.f33337d);
        }
        if (this.f33338e != null) {
            arrayList.add("createdAt=" + this.f33338e);
        }
        if (this.f33339f != null) {
            arrayList.add("lastModifiedAt=" + this.f33339f);
        }
        if (this.f33340g != null) {
            arrayList.add("lastAccessedAt=" + this.f33340g);
        }
        if (!this.f33341h.isEmpty()) {
            arrayList.add("extras=" + this.f33341h);
        }
        return CollectionsKt___CollectionsKt.W(arrayList, ", ", "FileMetadata(", ")", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ FileMetadata(boolean r10, boolean r11, okio.Path r12, java.lang.Long r13, java.lang.Long r14, java.lang.Long r15, java.lang.Long r16, java.util.Map r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r9 = this;
            r0 = r18
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r10
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x000f
            goto L_0x0010
        L_0x000f:
            r2 = r11
        L_0x0010:
            r3 = r0 & 4
            r4 = 0
            if (r3 == 0) goto L_0x0017
            r3 = r4
            goto L_0x0018
        L_0x0017:
            r3 = r12
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r4
            goto L_0x001f
        L_0x001e:
            r5 = r13
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = r4
            goto L_0x0026
        L_0x0025:
            r6 = r14
        L_0x0026:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002c
            r7 = r4
            goto L_0x002d
        L_0x002c:
            r7 = r15
        L_0x002d:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0032
            goto L_0x0034
        L_0x0032:
            r4 = r16
        L_0x0034:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x003d
            java.util.Map r0 = kotlin.collections.h0.i()
            goto L_0x003f
        L_0x003d:
            r0 = r17
        L_0x003f:
            r10 = r9
            r11 = r1
            r12 = r2
            r13 = r3
            r14 = r5
            r15 = r6
            r16 = r7
            r17 = r4
            r18 = r0
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.FileMetadata.<init>(boolean, boolean, okio.Path, java.lang.Long, java.lang.Long, java.lang.Long, java.lang.Long, java.util.Map, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
