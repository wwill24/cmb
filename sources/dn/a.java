package dn;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;
import org.bouncycastle.openpgp.PGPSecretKey;
import org.bouncycastle.openpgp.PGPSecretKeyRing;
import org.pgpainless.algorithm.CompressionAlgorithm;
import org.pgpainless.algorithm.HashAlgorithm;
import org.pgpainless.algorithm.SymmetricKeyAlgorithm;

public class a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public OutputStream f40603a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Set<PGPPublicKey> f40604b = new HashSet();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f40605c = false;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final Set<PGPSecretKey> f40606d = new HashSet();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public jn.a f40607e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public SymmetricKeyAlgorithm f40608f = SymmetricKeyAlgorithm.AES_128;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public HashAlgorithm f40609g = HashAlgorithm.SHA256;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public CompressionAlgorithm f40610h = CompressionAlgorithm.UNCOMPRESSED;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public boolean f40611i = false;

    /* renamed from: dn.a$a  reason: collision with other inner class name */
    class C0486a implements b {
        C0486a() {
        }

        private g b() throws IOException, PGPException {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (PGPSecretKey pGPSecretKey : a.this.f40606d) {
                concurrentHashMap.put(new en.a(pGPSecretKey), pGPSecretKey.extractPrivateKey(a.this.f40607e.a(Long.valueOf(pGPSecretKey.getKeyID()))));
            }
            return new g(a.this.f40603a, a.this.f40604b, a.this.f40605c, concurrentHashMap, a.this.f40608f, a.this.f40609g, a.this.f40610h, a.this.f40611i);
        }

        public g a() throws IOException, PGPException {
            boolean unused = a.this.f40611i = false;
            return b();
        }
    }

    class b implements c {
        b() {
        }

        public b a() {
            return new C0486a();
        }

        public b b(jn.a aVar, PGPSecretKeyRing... pGPSecretKeyRingArr) {
            return new c().b(aVar, pGPSecretKeyRingArr);
        }
    }

    class c implements d {
        c() {
        }

        public b b(jn.a aVar, PGPSecretKeyRing... pGPSecretKeyRingArr) {
            if (pGPSecretKeyRingArr.length != 0) {
                for (PGPSecretKeyRing secretKeys : pGPSecretKeyRingArr) {
                    Iterator secretKeys2 = secretKeys.getSecretKeys();
                    while (secretKeys2.hasNext()) {
                        PGPSecretKey pGPSecretKey = (PGPSecretKey) secretKeys2.next();
                        if (a.this.q().accept(null, pGPSecretKey)) {
                            a.this.f40606d.add(pGPSecretKey);
                        }
                    }
                }
                jn.a unused = a.this.f40607e = aVar;
                return new C0486a();
            }
            throw new IllegalArgumentException("Recipient list MUST NOT be empty.");
        }
    }

    class d implements e {
        d() {
        }

        public f a(PGPPublicKeyRingCollection... pGPPublicKeyRingCollectionArr) {
            for (PGPPublicKeyRingCollection it : pGPPublicKeyRingCollectionArr) {
                Iterator it2 = it.iterator();
                while (it2.hasNext()) {
                    Iterator it3 = ((PGPPublicKeyRing) it2.next()).iterator();
                    while (it3.hasNext()) {
                        PGPPublicKey pGPPublicKey = (PGPPublicKey) it3.next();
                        if (a.this.o().accept(null, pGPPublicKey)) {
                            a.this.f40604b.add(pGPPublicKey);
                        }
                    }
                }
            }
            if (!a.this.f40604b.isEmpty()) {
                return new e();
            }
            throw new IllegalStateException("No valid encryption keys found!");
        }

        public c b() {
            return new b();
        }
    }

    class e implements f {
        e() {
        }

        public f a(PGPPublicKeyRingCollection pGPPublicKeyRingCollection) {
            Iterator it = pGPPublicKeyRingCollection.iterator();
            while (it.hasNext()) {
                Iterator publicKeys = ((PGPPublicKeyRing) it.next()).getPublicKeys();
                while (publicKeys.hasNext()) {
                    PGPPublicKey pGPPublicKey = (PGPPublicKey) publicKeys.next();
                    if (a.this.o().accept(null, pGPPublicKey)) {
                        a.this.f40604b.add(pGPPublicKey);
                    }
                }
            }
            return this;
        }

        public c b() {
            SymmetricKeyAlgorithm unused = a.this.f40608f = SymmetricKeyAlgorithm.AES_256;
            HashAlgorithm unused2 = a.this.f40609g = HashAlgorithm.SHA512;
            CompressionAlgorithm unused3 = a.this.f40610h = CompressionAlgorithm.UNCOMPRESSED;
            return new b();
        }
    }

    /* access modifiers changed from: package-private */
    public <O> kn.b<O> o() {
        return new mn.a(new ln.b(), new ln.a());
    }

    public e p(OutputStream outputStream) {
        this.f40603a = outputStream;
        return new d();
    }

    /* access modifiers changed from: package-private */
    public <O> kn.c<O> q() {
        return new mn.b(new ln.c(), new ln.d());
    }
}
