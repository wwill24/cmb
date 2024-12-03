package sm;

import com.facebook.internal.security.OidcSecurityUtil;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.minidns.constants.DnssecConstants;
import org.minidns.dnssec.DnssecValidatorInitializationException;
import org.minidns.record.NSEC3;
import rm.b;
import sm.c;

public final class a {

    /* renamed from: e  reason: collision with root package name */
    public static final a f33852e = new a();

    /* renamed from: a  reason: collision with root package name */
    private Logger f33853a = Logger.getLogger(a.class.getName());

    /* renamed from: b  reason: collision with root package name */
    private final Map<DnssecConstants.DigestAlgorithm, rm.a> f33854b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<DnssecConstants.SignatureAlgorithm, b> f33855c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<NSEC3.HashAlgorithm, rm.a> f33856d;

    private a() {
        HashMap hashMap = new HashMap();
        this.f33854b = hashMap;
        HashMap hashMap2 = new HashMap();
        this.f33855c = hashMap2;
        HashMap hashMap3 = new HashMap();
        this.f33856d = hashMap3;
        try {
            hashMap.put(DnssecConstants.DigestAlgorithm.SHA1, new e("SHA-1"));
            hashMap3.put(NSEC3.HashAlgorithm.SHA1, new e("SHA-1"));
            try {
                hashMap.put(DnssecConstants.DigestAlgorithm.SHA256, new e("SHA-256"));
                try {
                    hashMap2.put(DnssecConstants.SignatureAlgorithm.RSAMD5, new g("MD5withRSA"));
                } catch (NoSuchAlgorithmException e10) {
                    this.f33853a.log(Level.FINER, "Platform does not support RSA/MD5", e10);
                }
                try {
                    b bVar = new b("SHA1withDSA");
                    this.f33855c.put(DnssecConstants.SignatureAlgorithm.DSA, bVar);
                    this.f33855c.put(DnssecConstants.SignatureAlgorithm.DSA_NSEC3_SHA1, bVar);
                } catch (NoSuchAlgorithmException e11) {
                    this.f33853a.log(Level.FINE, "Platform does not support DSA/SHA-1", e11);
                }
                try {
                    g gVar = new g("SHA1withRSA");
                    this.f33855c.put(DnssecConstants.SignatureAlgorithm.RSASHA1, gVar);
                    this.f33855c.put(DnssecConstants.SignatureAlgorithm.RSASHA1_NSEC3_SHA1, gVar);
                    try {
                        this.f33855c.put(DnssecConstants.SignatureAlgorithm.RSASHA256, new g(OidcSecurityUtil.SIGNATURE_ALGORITHM_SHA256));
                    } catch (NoSuchAlgorithmException e12) {
                        this.f33853a.log(Level.INFO, "Platform does not support RSA/SHA-256", e12);
                    }
                    try {
                        this.f33855c.put(DnssecConstants.SignatureAlgorithm.RSASHA512, new g("SHA512withRSA"));
                    } catch (NoSuchAlgorithmException e13) {
                        this.f33853a.log(Level.INFO, "Platform does not support RSA/SHA-512", e13);
                    }
                    try {
                        this.f33855c.put(DnssecConstants.SignatureAlgorithm.ECC_GOST, new d());
                    } catch (NoSuchAlgorithmException e14) {
                        this.f33853a.log(Level.FINE, "Platform does not support GOST R 34.10-2001", e14);
                    }
                    try {
                        this.f33855c.put(DnssecConstants.SignatureAlgorithm.ECDSAP256SHA256, new c.a());
                    } catch (NoSuchAlgorithmException e15) {
                        this.f33853a.log(Level.INFO, "Platform does not support ECDSA/SHA-256", e15);
                    }
                    try {
                        this.f33855c.put(DnssecConstants.SignatureAlgorithm.ECDSAP384SHA384, new c.b());
                    } catch (NoSuchAlgorithmException e16) {
                        this.f33853a.log(Level.INFO, "Platform does not support ECDSA/SHA-384", e16);
                    }
                } catch (NoSuchAlgorithmException e17) {
                    throw new DnssecValidatorInitializationException("Platform does not support RSA/SHA-1", e17);
                }
            } catch (NoSuchAlgorithmException e18) {
                throw new DnssecValidatorInitializationException("SHA-256 is mandatory", e18);
            }
        } catch (NoSuchAlgorithmException e19) {
            throw new DnssecValidatorInitializationException("SHA-1 is mandatory", e19);
        }
    }

    public rm.a a(DnssecConstants.DigestAlgorithm digestAlgorithm) {
        return this.f33854b.get(digestAlgorithm);
    }

    public rm.a b(NSEC3.HashAlgorithm hashAlgorithm) {
        return this.f33856d.get(hashAlgorithm);
    }

    public b c(DnssecConstants.SignatureAlgorithm signatureAlgorithm) {
        return this.f33855c.get(signatureAlgorithm);
    }
}
