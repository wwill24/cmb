package hl;

import bl.d;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import okio.ByteString;

@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J.\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J\u0017\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\r\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004R\u0014\u0010\u0010\u001a\u00020\u000e8\u0006X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u000fR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u00118\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0012R\u001c\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00118\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u00118\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012¨\u0006\u001a"}, d2 = {"Lhl/c;", "", "", "inbound", "", "streamId", "length", "type", "flags", "", "c", "b", "(I)Ljava/lang/String;", "a", "Lokio/ByteString;", "Lokio/ByteString;", "CONNECTION_PREFACE", "", "[Ljava/lang/String;", "FRAME_NAMES", "d", "FLAGS", "e", "BINARY", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f29781a = new c();

    /* renamed from: b  reason: collision with root package name */
    public static final ByteString f29782b = ByteString.f33308c.c("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f29783c = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* renamed from: d  reason: collision with root package name */
    private static final String[] f29784d = new String[64];

    /* renamed from: e  reason: collision with root package name */
    private static final String[] f29785e;

    static {
        String[] strArr = new String[256];
        int i10 = 0;
        for (int i11 = 0; i11 < 256; i11++) {
            String binaryString = Integer.toBinaryString(i11);
            j.f(binaryString, "toBinaryString(it)");
            strArr[i11] = r.C(d.t("%8s", binaryString), ' ', '0', false, 4, (Object) null);
        }
        f29785e = strArr;
        String[] strArr2 = f29784d;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        int i12 = 0;
        while (i12 < 1) {
            int i13 = iArr[i12];
            i12++;
            String[] strArr3 = f29784d;
            strArr3[i13 | 8] = j.p(strArr3[i13], "|PADDED");
        }
        String[] strArr4 = f29784d;
        strArr4[4] = "END_HEADERS";
        strArr4[32] = "PRIORITY";
        strArr4[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        int i14 = 0;
        while (i14 < 3) {
            int i15 = iArr2[i14];
            i14++;
            int i16 = 0;
            while (i16 < 1) {
                int i17 = iArr[i16];
                i16++;
                String[] strArr5 = f29784d;
                int i18 = i17 | i15;
                strArr5[i18] = strArr5[i17] + '|' + strArr5[i15];
                strArr5[i18 | 8] = strArr5[i17] + '|' + strArr5[i15] + "|PADDED";
            }
        }
        int length = f29784d.length;
        while (i10 < length) {
            int i19 = i10 + 1;
            String[] strArr6 = f29784d;
            if (strArr6[i10] == null) {
                strArr6[i10] = f29785e[i10];
            }
            i10 = i19;
        }
    }

    private c() {
    }

    public final String a(int i10, int i11) {
        String str;
        if (i11 == 0) {
            return "";
        }
        if (!(i10 == 2 || i10 == 3)) {
            if (i10 == 4 || i10 == 6) {
                if (i11 == 1) {
                    return "ACK";
                }
                return f29785e[i11];
            } else if (!(i10 == 7 || i10 == 8)) {
                String[] strArr = f29784d;
                if (i11 < strArr.length) {
                    str = strArr[i11];
                    j.d(str);
                } else {
                    str = f29785e[i11];
                }
                String str2 = str;
                if (i10 == 5 && (i11 & 4) != 0) {
                    return r.D(str2, "HEADERS", "PUSH_PROMISE", false, 4, (Object) null);
                }
                if (i10 != 0 || (i11 & 32) == 0) {
                    return str2;
                }
                return r.D(str2, "PRIORITY", "COMPRESSED", false, 4, (Object) null);
            }
        }
        return f29785e[i11];
    }

    public final String b(int i10) {
        String[] strArr = f29783c;
        if (i10 < strArr.length) {
            return strArr[i10];
        }
        return d.t("0x%02x", Integer.valueOf(i10));
    }

    public final String c(boolean z10, int i10, int i11, int i12, int i13) {
        String str;
        String b10 = b(i12);
        String a10 = a(i12, i13);
        if (z10) {
            str = "<<";
        } else {
            str = ">>";
        }
        return d.t("%s 0x%08x %5d %-13s %s", str, Integer.valueOf(i10), Integer.valueOf(i11), b10, a10);
    }
}
