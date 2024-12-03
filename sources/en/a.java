package en;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPSecretKey;
import org.bouncycastle.openpgp.PGPSecretKeyRing;
import org.bouncycastle.util.encoders.Hex;

public class a implements CharSequence, Comparable<a> {

    /* renamed from: b  reason: collision with root package name */
    private static final Charset f40769b = Charset.forName("UTF-8");

    /* renamed from: a  reason: collision with root package name */
    private final String f40770a;

    public a(String str) {
        String upperCase = str.trim().toUpperCase();
        if (c(upperCase)) {
            this.f40770a = upperCase;
            return;
        }
        throw new IllegalArgumentException("Fingerprint " + str + " does not appear to be a valid OpenPGP v4 fingerprint.");
    }

    private static boolean c(String str) {
        return str.matches("[0-9A-F]{40}");
    }

    /* renamed from: a */
    public int compareTo(a aVar) {
        return this.f40770a.compareTo(aVar.f40770a);
    }

    public long b() {
        ByteBuffer wrap = ByteBuffer.wrap(Hex.decode(toString().getBytes(f40769b)));
        wrap.position(12);
        return wrap.getLong();
    }

    public char charAt(int i10) {
        return this.f40770a.charAt(i10);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof CharSequence)) {
            return toString().equals(obj.toString());
        }
        return false;
    }

    public int hashCode() {
        return this.f40770a.hashCode();
    }

    public int length() {
        return this.f40770a.length();
    }

    public CharSequence subSequence(int i10, int i11) {
        return this.f40770a.subSequence(i10, i11);
    }

    public String toString() {
        return this.f40770a;
    }

    public a(byte[] bArr) {
        this(new String(bArr, f40769b));
    }

    public a(PGPPublicKey pGPPublicKey) {
        this(Hex.encode(pGPPublicKey.getFingerprint()));
        if (pGPPublicKey.getVersion() != 4) {
            throw new IllegalArgumentException("Key is not a v4 OpenPgp key.");
        }
    }

    public a(PGPSecretKey pGPSecretKey) {
        this(pGPSecretKey.getPublicKey());
    }

    public a(PGPPublicKeyRing pGPPublicKeyRing) {
        this(pGPPublicKeyRing.getPublicKey());
    }

    public a(PGPSecretKeyRing pGPSecretKeyRing) {
        this(pGPSecretKeyRing.getPublicKey());
    }
}
