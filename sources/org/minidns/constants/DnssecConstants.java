package org.minidns.constants;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;

public final class DnssecConstants {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final Map<Byte, SignatureAlgorithm> f33549a = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final Map<Byte, DigestAlgorithm> f33550b = new HashMap();

    public enum DigestAlgorithm {
        SHA1(1, "SHA-1"),
        SHA256(2, "SHA-256"),
        GOST(3, "GOST R 34.11-94"),
        SHA384(4, McElieceCCA2KeyGenParameterSpec.SHA384);
        
        public final String description;
        public final byte value;

        private DigestAlgorithm(int i10, String str) {
            if (i10 < 0 || i10 > 255) {
                throw new IllegalArgumentException();
            }
            byte b10 = (byte) i10;
            this.value = b10;
            this.description = str;
            DnssecConstants.f33550b.put(Byte.valueOf(b10), this);
        }

        public static DigestAlgorithm a(byte b10) {
            return (DigestAlgorithm) DnssecConstants.f33550b.get(Byte.valueOf(b10));
        }
    }

    public enum SignatureAlgorithm {
        RSAMD5(1, "RSA/MD5"),
        DH(2, "Diffie-Hellman"),
        DSA(3, "DSA/SHA1"),
        RSASHA1(5, "RSA/SHA-1"),
        DSA_NSEC3_SHA1(6, "DSA_NSEC3-SHA1"),
        RSASHA1_NSEC3_SHA1(7, "RSASHA1-NSEC3-SHA1"),
        RSASHA256(8, "RSA/SHA-256"),
        RSASHA512(10, "RSA/SHA-512"),
        ECC_GOST(12, "GOST R 34.10-2001"),
        ECDSAP256SHA256(13, "ECDSA Curve P-256 with SHA-256"),
        ECDSAP384SHA384(14, "ECDSA Curve P-384 with SHA-384"),
        INDIRECT(252, "Reserved for Indirect Keys"),
        PRIVATEDNS(253, "private algorithm"),
        PRIVATEOID(254, "private algorithm oid");
        
        public final String description;
        public final byte number;

        private SignatureAlgorithm(int i10, String str) {
            if (i10 < 0 || i10 > 255) {
                throw new IllegalArgumentException();
            }
            byte b10 = (byte) i10;
            this.number = b10;
            this.description = str;
            DnssecConstants.f33549a.put(Byte.valueOf(b10), this);
        }

        public static SignatureAlgorithm a(byte b10) {
            return (SignatureAlgorithm) DnssecConstants.f33549a.get(Byte.valueOf(b10));
        }
    }
}
