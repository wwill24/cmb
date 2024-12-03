package okio.internal;

import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import okio.Buffer;
import okio.ByteString;
import okio.Path;

@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u001a\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002\u001a\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0000H\u0002\u001a\u001c\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0003H\u0000\u001a\u0014\u0010\t\u001a\u00020\u0000*\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0003H\u0000\u001a\u0014\u0010\u000b\u001a\u00020\u0000*\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0003H\u0000\u001a\f\u0010\r\u001a\u00020\f*\u00020\bH\u0002\u001a\f\u0010\u000f\u001a\u00020\f*\u00020\u000eH\u0002\u001a\u0014\u0010\u0011\u001a\u00020\u0003*\u00020\n2\u0006\u0010\u0010\u001a\u00020\fH\u0002\"\u001a\u0010\u0016\u001a\u00020\f8\u0002X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u0012\u0004\b\u0014\u0010\u0015\"\u001a\u0010\u0019\u001a\u00020\f8\u0002X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u0012\u0004\b\u0018\u0010\u0015\"\u001a\u0010\u001c\u001a\u00020\f8\u0002X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0013\u0012\u0004\b\u001b\u0010\u0015\"\u001a\u0010\u001f\u001a\u00020\f8\u0002X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0013\u0012\u0004\b\u001e\u0010\u0015\"\u001a\u0010\"\u001a\u00020\f8\u0002X\u0004¢\u0006\f\n\u0004\b \u0010\u0013\u0012\u0004\b!\u0010\u0015\"\u0018\u0010%\u001a\u00020\u0001*\u00020\u00008BX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$\"\u001a\u0010\u0010\u001a\u0004\u0018\u00010\f*\u00020\u00008BX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006("}, d2 = {"Lokio/Path;", "", "o", "", "n", "child", "normalize", "j", "", "k", "Lokio/Buffer;", "q", "Lokio/ByteString;", "s", "", "r", "slash", "p", "a", "Lokio/ByteString;", "getSLASH$annotations", "()V", "SLASH", "b", "getBACKSLASH$annotations", "BACKSLASH", "c", "getANY_SLASH$annotations", "ANY_SLASH", "d", "getDOT$annotations", "DOT", "e", "getDOT_DOT$annotations", "DOT_DOT", "l", "(Lokio/Path;)I", "indexOfLastSlash", "m", "(Lokio/Path;)Lokio/ByteString;", "okio"}, k = 2, mv = {1, 6, 0})
public final class g {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final ByteString f33466a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final ByteString f33467b;

    /* renamed from: c  reason: collision with root package name */
    private static final ByteString f33468c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final ByteString f33469d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final ByteString f33470e;

    static {
        ByteString.Companion companion = ByteString.f33308c;
        f33466a = companion.c(RemoteSettings.FORWARD_SLASH_STRING);
        f33467b = companion.c("\\");
        f33468c = companion.c("/\\");
        f33469d = companion.c(".");
        f33470e = companion.c("..");
    }

    public static final Path j(Path path, Path path2, boolean z10) {
        j.g(path, "<this>");
        j.g(path2, "child");
        if (path2.isAbsolute() || path2.p() != null) {
            return path2;
        }
        ByteString m10 = m(path);
        if (m10 == null && (m10 = m(path2)) == null) {
            m10 = s(Path.f33380c);
        }
        Buffer buffer = new Buffer();
        buffer.K1(path.b());
        if (buffer.size() > 0) {
            buffer.K1(m10);
        }
        buffer.K1(path2.b());
        return q(buffer, z10);
    }

    public static final Path k(String str, boolean z10) {
        j.g(str, "<this>");
        return q(new Buffer().h0(str), z10);
    }

    /* access modifiers changed from: private */
    public static final int l(Path path) {
        int y10 = ByteString.y(path.b(), f33466a, 0, 2, (Object) null);
        if (y10 != -1) {
            return y10;
        }
        return ByteString.y(path.b(), f33467b, 0, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final ByteString m(Path path) {
        ByteString b10 = path.b();
        ByteString byteString = f33466a;
        if (ByteString.s(b10, byteString, 0, 2, (Object) null) != -1) {
            return byteString;
        }
        ByteString b11 = path.b();
        ByteString byteString2 = f33467b;
        if (ByteString.s(b11, byteString2, 0, 2, (Object) null) != -1) {
            return byteString2;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static final boolean n(Path path) {
        if (!path.b().h(f33470e) || (path.b().H() != 2 && !path.b().z(path.b().H() - 3, f33466a, 0, 1) && !path.b().z(path.b().H() - 3, f33467b, 0, 1))) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static final int o(Path path) {
        boolean z10;
        if (path.b().H() == 0) {
            return -1;
        }
        boolean z11 = false;
        if (path.b().i(0) == ((byte) 47)) {
            return 1;
        }
        byte b10 = (byte) 92;
        if (path.b().i(0) == b10) {
            if (path.b().H() <= 2 || path.b().i(1) != b10) {
                return 1;
            }
            int q10 = path.b().q(f33467b, 2);
            if (q10 == -1) {
                return path.b().H();
            }
            return q10;
        } else if (path.b().H() <= 2 || path.b().i(1) != ((byte) 58) || path.b().i(2) != b10) {
            return -1;
        } else {
            char i10 = (char) path.b().i(0);
            if ('a' > i10 || i10 >= '{') {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                return 3;
            }
            if ('A' <= i10 && i10 < '[') {
                z11 = true;
            }
            if (!z11) {
                return -1;
            }
            return 3;
        }
    }

    private static final boolean p(Buffer buffer, ByteString byteString) {
        boolean z10;
        boolean z11;
        if (!j.b(byteString, f33467b) || buffer.size() < 2 || buffer.l(1) != ((byte) 58)) {
            return false;
        }
        char l10 = (char) buffer.l(0);
        if ('a' > l10 || l10 >= '{') {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!z10) {
            if ('A' > l10 || l10 >= '[') {
                z11 = false;
            } else {
                z11 = true;
            }
            if (!z11) {
                return false;
            }
        }
        return true;
    }

    public static final Path q(Buffer buffer, boolean z10) {
        ByteString byteString;
        boolean z11;
        boolean z12;
        ByteString byteString2;
        Buffer buffer2 = buffer;
        j.g(buffer2, "<this>");
        Buffer buffer3 = new Buffer();
        ByteString byteString3 = null;
        int i10 = 0;
        while (true) {
            if (!buffer2.j0(0, f33466a)) {
                byteString = f33467b;
                if (!buffer2.j0(0, byteString)) {
                    break;
                }
            }
            byte readByte = buffer.readByte();
            if (byteString3 == null) {
                byteString3 = r(readByte);
            }
            i10++;
        }
        if (i10 < 2 || !j.b(byteString3, byteString)) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            j.d(byteString3);
            buffer3.K1(byteString3);
            buffer3.K1(byteString3);
        } else if (i10 > 0) {
            j.d(byteString3);
            buffer3.K1(byteString3);
        } else {
            long U = buffer2.U(f33468c);
            if (byteString3 == null) {
                if (U == -1) {
                    byteString3 = s(Path.f33380c);
                } else {
                    byteString3 = r(buffer2.l(U));
                }
            }
            if (p(buffer2, byteString3)) {
                if (U == 2) {
                    buffer3.k0(buffer2, 3);
                } else {
                    buffer3.k0(buffer2, 2);
                }
            }
        }
        if (buffer3.size() > 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        ArrayList arrayList = new ArrayList();
        while (!buffer.Y0()) {
            long U2 = buffer2.U(f33468c);
            if (U2 == -1) {
                byteString2 = buffer.y1();
            } else {
                byteString2 = buffer2.O0(U2);
                buffer.readByte();
            }
            ByteString byteString4 = f33470e;
            if (j.b(byteString2, byteString4)) {
                if (!z12 || !arrayList.isEmpty()) {
                    if (!z10 || (!z12 && (arrayList.isEmpty() || j.b(CollectionsKt___CollectionsKt.Y(arrayList), byteString4)))) {
                        arrayList.add(byteString2);
                    } else if (!z11 || arrayList.size() != 1) {
                        Object unused = v.B(arrayList);
                    }
                }
            } else if (!j.b(byteString2, f33469d) && !j.b(byteString2, ByteString.f33309d)) {
                arrayList.add(byteString2);
            }
        }
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (i11 > 0) {
                buffer3.K1(byteString3);
            }
            buffer3.K1((ByteString) arrayList.get(i11));
        }
        if (buffer3.size() == 0) {
            buffer3.K1(f33469d);
        }
        return new Path(buffer3.y1());
    }

    private static final ByteString r(byte b10) {
        if (b10 == 47) {
            return f33466a;
        }
        if (b10 == 92) {
            return f33467b;
        }
        throw new IllegalArgumentException("not a directory separator: " + b10);
    }

    /* access modifiers changed from: private */
    public static final ByteString s(String str) {
        if (j.b(str, RemoteSettings.FORWARD_SLASH_STRING)) {
            return f33466a;
        }
        if (j.b(str, "\\")) {
            return f33467b;
        }
        throw new IllegalArgumentException("not a directory separator: " + str);
    }
}
