package okio;

import kotlin.Metadata;
import kotlin.jvm.internal.j;
import okio.ByteString;

@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u001a\u0016\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\b\b\u0002\u0010\u0001\u001a\u00020\u0000H\u0000\" \u0010\t\u001a\u00020\u00008\u0000X\u0004¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\" \u0010\r\u001a\u00020\u00008\u0000X\u0004¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u0012\u0004\b\f\u0010\b\u001a\u0004\b\u000b\u0010\u0006¨\u0006\u000e"}, d2 = {"", "map", "", "a", "[B", "getBASE64", "()[B", "getBASE64$annotations", "()V", "BASE64", "b", "getBASE64_URL_SAFE", "getBASE64_URL_SAFE$annotations", "BASE64_URL_SAFE", "okio"}, k = 2, mv = {1, 6, 0})
public final class _Base64Kt {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f33440a;

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f33441b;

    static {
        ByteString.Companion companion = ByteString.f33308c;
        f33440a = companion.c("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").j();
        f33441b = companion.c("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").j();
    }

    public static final String a(byte[] bArr, byte[] bArr2) {
        j.g(bArr, "<this>");
        j.g(bArr2, "map");
        byte[] bArr3 = new byte[(((bArr.length + 2) / 3) * 4)];
        int length = bArr.length - (bArr.length % 3);
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int i12 = i10 + 1;
            byte b10 = bArr[i10];
            int i13 = i12 + 1;
            byte b11 = bArr[i12];
            int i14 = i13 + 1;
            byte b12 = bArr[i13];
            int i15 = i11 + 1;
            bArr3[i11] = bArr2[(b10 & 255) >> 2];
            int i16 = i15 + 1;
            bArr3[i15] = bArr2[((b10 & 3) << 4) | ((b11 & 255) >> 4)];
            int i17 = i16 + 1;
            bArr3[i16] = bArr2[((b11 & 15) << 2) | ((b12 & 255) >> 6)];
            i11 = i17 + 1;
            bArr3[i17] = bArr2[b12 & 63];
            i10 = i14;
        }
        int length2 = bArr.length - length;
        if (length2 == 1) {
            byte b13 = bArr[i10];
            int i18 = i11 + 1;
            bArr3[i11] = bArr2[(b13 & 255) >> 2];
            int i19 = i18 + 1;
            bArr3[i18] = bArr2[(b13 & 3) << 4];
            byte b14 = (byte) 61;
            bArr3[i19] = b14;
            bArr3[i19 + 1] = b14;
        } else if (length2 == 2) {
            int i20 = i10 + 1;
            byte b15 = bArr[i10];
            byte b16 = bArr[i20];
            int i21 = i11 + 1;
            bArr3[i11] = bArr2[(b15 & 255) >> 2];
            int i22 = i21 + 1;
            bArr3[i21] = bArr2[((b15 & 3) << 4) | ((b16 & 255) >> 4)];
            bArr3[i22] = bArr2[(b16 & 15) << 2];
            bArr3[i22 + 1] = (byte) 61;
        }
        return _JvmPlatformKt.b(bArr3);
    }

    public static /* synthetic */ String b(byte[] bArr, byte[] bArr2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            bArr2 = f33440a;
        }
        return a(bArr, bArr2);
    }
}
