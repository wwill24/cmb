package androidx.profileinstaller;

import com.facebook.internal.security.CertificateUtil;
import java.util.Arrays;

public class o {

    /* renamed from: a  reason: collision with root package name */
    static final byte[] f6187a = {48, Framer.STDOUT_FRAME_PREFIX, 53, 0};

    /* renamed from: b  reason: collision with root package name */
    static final byte[] f6188b = {48, Framer.STDOUT_FRAME_PREFIX, 48, 0};

    /* renamed from: c  reason: collision with root package name */
    static final byte[] f6189c = {48, 48, 57, 0};

    /* renamed from: d  reason: collision with root package name */
    static final byte[] f6190d = {48, 48, 53, 0};

    /* renamed from: e  reason: collision with root package name */
    static final byte[] f6191e = {48, 48, Framer.STDOUT_FRAME_PREFIX, 0};

    /* renamed from: f  reason: collision with root package name */
    static final byte[] f6192f = {48, 48, Framer.STDOUT_FRAME_PREFIX, 0};

    /* renamed from: g  reason: collision with root package name */
    static final byte[] f6193g = {48, 48, Framer.STDERR_FRAME_PREFIX, 0};

    static String a(byte[] bArr) {
        if (!Arrays.equals(bArr, f6191e) && !Arrays.equals(bArr, f6190d)) {
            return "!";
        }
        return CertificateUtil.DELIMITER;
    }
}
