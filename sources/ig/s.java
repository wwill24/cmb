package ig;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;

public final class s implements gg.a {

    /* renamed from: a  reason: collision with root package name */
    private final ThreadLocal<Mac> f23541a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final String f23542b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Key f23543c;

    /* renamed from: d  reason: collision with root package name */
    private final int f23544d;

    class a extends ThreadLocal<Mac> {
        a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Mac initialValue() {
            try {
                Mac a10 = m.f23529g.a(s.this.f23542b);
                a10.init(s.this.f23543c);
                return a10;
            } catch (GeneralSecurityException e10) {
                throw new IllegalStateException(e10);
            }
        }
    }

    public s(String str, Key key) throws GeneralSecurityException {
        a aVar = new a();
        this.f23541a = aVar;
        this.f23542b = str;
        this.f23543c = key;
        if (key.getEncoded().length >= 16) {
            str.hashCode();
            char c10 = 65535;
            switch (str.hashCode()) {
                case -1823053428:
                    if (str.equals("HMACSHA1")) {
                        c10 = 0;
                        break;
                    }
                    break;
                case 392315118:
                    if (str.equals("HMACSHA256")) {
                        c10 = 1;
                        break;
                    }
                    break;
                case 392316170:
                    if (str.equals("HMACSHA384")) {
                        c10 = 2;
                        break;
                    }
                    break;
                case 392317873:
                    if (str.equals("HMACSHA512")) {
                        c10 = 3;
                        break;
                    }
                    break;
            }
            switch (c10) {
                case 0:
                    this.f23544d = 20;
                    break;
                case 1:
                    this.f23544d = 32;
                    break;
                case 2:
                    this.f23544d = 48;
                    break;
                case 3:
                    this.f23544d = 64;
                    break;
                default:
                    throw new NoSuchAlgorithmException("unknown Hmac algorithm: " + str);
            }
            aVar.get();
            return;
        }
        throw new InvalidAlgorithmParameterException("key size too small, need at least 16 bytes");
    }

    public byte[] a(byte[] bArr, int i10) throws GeneralSecurityException {
        if (i10 <= this.f23544d) {
            this.f23541a.get().update(bArr);
            return Arrays.copyOf(this.f23541a.get().doFinal(), i10);
        }
        throw new InvalidAlgorithmParameterException("tag size too big");
    }
}
