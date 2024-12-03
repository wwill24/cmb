package sm;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import rm.a;

public class e implements a {

    /* renamed from: a  reason: collision with root package name */
    private MessageDigest f33862a;

    public e(String str) throws NoSuchAlgorithmException {
        this.f33862a = MessageDigest.getInstance(str);
    }

    public byte[] a(byte[] bArr) {
        return this.f33862a.digest(bArr);
    }
}
