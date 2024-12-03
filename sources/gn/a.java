package gn;

import gn.b;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPKeyPair;
import org.bouncycastle.openpgp.PGPKeyRingGenerator;
import org.bouncycastle.openpgp.PGPSignatureSubpacketVector;
import org.bouncycastle.openpgp.operator.PBESecretKeyEncryptor;
import org.bouncycastle.openpgp.operator.PGPContentSignerBuilder;
import org.bouncycastle.openpgp.operator.PGPDigestCalculator;
import org.bouncycastle.openpgp.operator.jcajce.JcaPGPContentSignerBuilder;
import org.bouncycastle.openpgp.operator.jcajce.JcaPGPDigestCalculatorProviderBuilder;
import org.bouncycastle.openpgp.operator.jcajce.JcaPGPKeyPair;
import org.bouncycastle.openpgp.operator.jcajce.JcePBESecretKeyEncryptorBuilder;
import org.pgpainless.algorithm.HashAlgorithm;
import org.pgpainless.algorithm.KeyFlag;
import org.pgpainless.key.generation.type.curve.EllipticCurve;
import qn.c;

public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private final Charset f40872a = Charset.forName("UTF-8");
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public List<c> f40873b = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f40874c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public c f40875d;

    /* renamed from: gn.a$a  reason: collision with other inner class name */
    class C0494a implements b.C0496b {

        /* renamed from: gn.a$a$a  reason: collision with other inner class name */
        class C0495a implements b.a {

            /* renamed from: a  reason: collision with root package name */
            private PGPDigestCalculator f40877a;

            /* renamed from: b  reason: collision with root package name */
            private PBESecretKeyEncryptor f40878b;

            C0495a() {
            }

            private void a(PGPKeyRingGenerator pGPKeyRingGenerator) throws NoSuchAlgorithmException, PGPException, InvalidAlgorithmParameterException {
                for (c cVar : a.this.f40873b) {
                    PGPKeyPair f10 = f(cVar);
                    if (cVar.d()) {
                        pGPKeyRingGenerator.addSubKey(f10);
                    } else {
                        pGPKeyRingGenerator.addSubKey(f10, cVar.c(), (PGPSignatureSubpacketVector) null);
                    }
                }
            }

            private PGPContentSignerBuilder b(PGPKeyPair pGPKeyPair) {
                return new JcaPGPContentSignerBuilder(pGPKeyPair.getPublicKey().getAlgorithm(), HashAlgorithm.SHA512.a()).setProvider(on.b.b());
            }

            private PGPDigestCalculator c() throws PGPException {
                return new JcaPGPDigestCalculatorProviderBuilder().setProvider(on.b.b()).build().get(HashAlgorithm.SHA1.a());
            }

            private PGPKeyRingGenerator d(PGPKeyPair pGPKeyPair, PGPContentSignerBuilder pGPContentSignerBuilder, PGPSignatureSubpacketVector pGPSignatureSubpacketVector) throws PGPException {
                return new PGPKeyRingGenerator(19, pGPKeyPair, a.this.f40874c, this.f40877a, pGPSignatureSubpacketVector, (PGPSignatureSubpacketVector) null, pGPContentSignerBuilder, this.f40878b);
            }

            private PBESecretKeyEncryptor e() {
                PBESecretKeyEncryptor pBESecretKeyEncryptor;
                if (a.this.f40875d == null) {
                    pBESecretKeyEncryptor = null;
                } else {
                    pBESecretKeyEncryptor = new JcePBESecretKeyEncryptorBuilder(9, this.f40877a).setProvider(on.b.b()).build(a.this.f40875d.b());
                }
                if (a.this.f40875d != null) {
                    a.this.f40875d.a();
                }
                return pBESecretKeyEncryptor;
            }

            private PGPKeyPair f(c cVar) throws NoSuchAlgorithmException, PGPException, InvalidAlgorithmParameterException {
                hn.c b10 = cVar.b();
                KeyPairGenerator instance = KeyPairGenerator.getInstance(b10.getName(), on.b.b());
                instance.initialize(b10.a());
                return new JcaPGPKeyPair(b10.getAlgorithm().a(), instance.generateKeyPair(), new Date());
            }

            public fn.a build() throws NoSuchAlgorithmException, PGPException, InvalidAlgorithmParameterException {
                this.f40877a = c();
                this.f40878b = e();
                c cVar = (c) a.this.f40873b.remove(0);
                PGPKeyPair f10 = f(cVar);
                PGPKeyRingGenerator d10 = d(f10, b(f10), cVar.c());
                a(d10);
                return new fn.a(d10.generatePublicKeyRing(), d10.generateSecretKeyRing());
            }
        }

        C0494a() {
        }

        public b.a a() {
            c unused = a.this.f40875d = null;
            return new C0495a();
        }

        public b.a b(c cVar) {
            c unused = a.this.f40875d = cVar;
            return new C0495a();
        }
    }

    class b implements b.c {
        b() {
        }

        public b.C0496b a(String str) {
            String unused = a.this.f40874c = str;
            return new C0494a();
        }
    }

    private boolean g(c cVar) {
        return KeyFlag.b(cVar.c().getKeyFlags(), KeyFlag.CERTIFY_OTHER);
    }

    private void j(c cVar) {
        if (!g(cVar)) {
            throw new IllegalArgumentException("Certification Key MUST have KeyFlag CERTIFY_OTHER");
        }
    }

    public b.c a(c cVar) {
        j(cVar);
        this.f40873b.add(0, cVar);
        return new b();
    }

    public fn.a h(String str) throws InvalidAlgorithmParameterException, NoSuchAlgorithmException, PGPException {
        return i(str, (String) null);
    }

    public fn.a i(String str, String str2) throws PGPException, NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        EllipticCurve ellipticCurve = EllipticCurve._P256;
        b.C0496b a10 = k(c.a(hn.a.b(ellipticCurve)).c(KeyFlag.ENCRYPT_STORAGE, KeyFlag.ENCRYPT_COMMS).a()).a(c.a(hn.b.c(ellipticCurve)).c(KeyFlag.AUTHENTICATION, KeyFlag.CERTIFY_OTHER, KeyFlag.SIGN_DATA).a()).a(str);
        if (str2 == null) {
            return a10.a().build();
        }
        return a10.b(new c(str2.toCharArray())).build();
    }

    public b k(c cVar) {
        this.f40873b.add(cVar);
        return this;
    }
}
