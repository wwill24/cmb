package dn;

import cn.h;
import cn.k;
import en.a;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bouncycastle.bcpg.ArmoredOutputStream;
import org.bouncycastle.bcpg.BCPGOutputStream;
import org.bouncycastle.openpgp.PGPCompressedDataGenerator;
import org.bouncycastle.openpgp.PGPEncryptedDataGenerator;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPLiteralDataGenerator;
import org.bouncycastle.openpgp.PGPPrivateKey;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPSignature;
import org.bouncycastle.openpgp.PGPSignatureGenerator;
import org.bouncycastle.openpgp.operator.bc.BcPGPContentSignerBuilder;
import org.bouncycastle.openpgp.operator.bc.BcPGPDataEncryptorBuilder;
import org.bouncycastle.openpgp.operator.bc.BcPublicKeyKeyEncryptionMethodGenerator;
import org.pgpainless.algorithm.CompressionAlgorithm;
import org.pgpainless.algorithm.HashAlgorithm;
import org.pgpainless.algorithm.SymmetricKeyAlgorithm;

public final class g extends OutputStream {

    /* renamed from: x  reason: collision with root package name */
    private static final Logger f40617x = Logger.getLogger(g.class.getName());

    /* renamed from: y  reason: collision with root package name */
    private static final Level f40618y = Level.FINE;

    /* renamed from: a  reason: collision with root package name */
    private final SymmetricKeyAlgorithm f40619a;

    /* renamed from: b  reason: collision with root package name */
    private final HashAlgorithm f40620b;

    /* renamed from: c  reason: collision with root package name */
    private final CompressionAlgorithm f40621c;

    /* renamed from: d  reason: collision with root package name */
    private final Set<PGPPublicKey> f40622d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f40623e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<a, PGPPrivateKey> f40624f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f40625g;

    /* renamed from: h  reason: collision with root package name */
    private final k.a f40626h = k.a();

    /* renamed from: j  reason: collision with root package name */
    private Map<a, PGPSignatureGenerator> f40627j = new ConcurrentHashMap();

    /* renamed from: k  reason: collision with root package name */
    private boolean f40628k = false;

    /* renamed from: l  reason: collision with root package name */
    OutputStream f40629l = null;

    /* renamed from: m  reason: collision with root package name */
    private ArmoredOutputStream f40630m = null;

    /* renamed from: n  reason: collision with root package name */
    private OutputStream f40631n = null;

    /* renamed from: p  reason: collision with root package name */
    private PGPCompressedDataGenerator f40632p;

    /* renamed from: q  reason: collision with root package name */
    private BCPGOutputStream f40633q;

    /* renamed from: t  reason: collision with root package name */
    private PGPLiteralDataGenerator f40634t;

    /* renamed from: w  reason: collision with root package name */
    private OutputStream f40635w;

    g(OutputStream outputStream, Set<PGPPublicKey> set, boolean z10, Map<a, PGPPrivateKey> map, SymmetricKeyAlgorithm symmetricKeyAlgorithm, HashAlgorithm hashAlgorithm, CompressionAlgorithm compressionAlgorithm, boolean z11) throws IOException, PGPException {
        this.f40619a = symmetricKeyAlgorithm;
        this.f40620b = hashAlgorithm;
        this.f40621c = compressionAlgorithm;
        this.f40622d = Collections.unmodifiableSet(set);
        this.f40623e = z10;
        this.f40624f = Collections.unmodifiableMap(map);
        this.f40625g = z11;
        this.f40629l = outputStream;
        b();
        e();
        k();
        c();
        g();
        f();
        h();
    }

    private void b() {
        if (!this.f40625g) {
            f40617x.log(f40618y, "Encryption output will be binary");
            return;
        }
        f40617x.log(f40618y, "Wrap encryption output in ASCII armor");
        ArmoredOutputStream armoredOutputStream = new ArmoredOutputStream(this.f40629l);
        this.f40630m = armoredOutputStream;
        this.f40629l = armoredOutputStream;
    }

    private void c() throws IOException {
        Logger logger = f40617x;
        Level level = f40618y;
        logger.log(level, "Compress using " + this.f40621c);
        this.f40632p = new PGPCompressedDataGenerator(this.f40621c.b());
        this.f40633q = new BCPGOutputStream(this.f40632p.open(this.f40629l));
    }

    private void e() throws IOException, PGPException {
        if (!this.f40622d.isEmpty()) {
            Logger logger = f40617x;
            Level level = f40618y;
            logger.log(level, "At least one encryption key is available -> encrypt using " + this.f40619a);
            BcPGPDataEncryptorBuilder bcPGPDataEncryptorBuilder = new BcPGPDataEncryptorBuilder(this.f40619a.b());
            bcPGPDataEncryptorBuilder.setWithIntegrityPacket(true);
            PGPEncryptedDataGenerator pGPEncryptedDataGenerator = new PGPEncryptedDataGenerator(bcPGPDataEncryptorBuilder);
            for (PGPPublicKey next : this.f40622d) {
                Logger logger2 = f40617x;
                Level level2 = f40618y;
                logger2.log(level2, "Encrypt for key " + Long.toHexString(next.getKeyID()));
                pGPEncryptedDataGenerator.addMethod(new BcPublicKeyKeyEncryptionMethodGenerator(next));
            }
            OutputStream open = pGPEncryptedDataGenerator.open(this.f40629l, new byte[256]);
            this.f40631n = open;
            this.f40629l = open;
        }
    }

    private void f() throws IOException {
        PGPLiteralDataGenerator pGPLiteralDataGenerator = new PGPLiteralDataGenerator();
        this.f40634t = pGPLiteralDataGenerator;
        this.f40635w = pGPLiteralDataGenerator.open(this.f40633q, 'b', "_CONSOLE", new Date(), new byte[256]);
    }

    private void g() throws IOException, PGPException {
        for (PGPSignatureGenerator generateOnePassVersion : this.f40627j.values()) {
            generateOnePassVersion.generateOnePassVersion(false).encode(this.f40633q);
        }
    }

    private void h() {
        for (PGPPublicKey keyID : this.f40622d) {
            this.f40626h.c(Long.valueOf(keyID.getKeyID()));
        }
        this.f40626h.i(this.f40619a);
        this.f40626h.f(this.f40621c);
    }

    private void k() throws PGPException {
        if (!this.f40624f.isEmpty()) {
            Logger logger = f40617x;
            Level level = f40618y;
            logger.log(level, "At least one signing key is available -> sign " + this.f40620b + " hash of message");
            for (a next : this.f40624f.keySet()) {
                PGPPrivateKey pGPPrivateKey = this.f40624f.get(next);
                Logger logger2 = f40617x;
                Level level2 = f40618y;
                logger2.log(level2, "Sign using key " + next);
                PGPSignatureGenerator pGPSignatureGenerator = new PGPSignatureGenerator(new BcPGPContentSignerBuilder(pGPPrivateKey.getPublicKeyPacket().getAlgorithm(), this.f40620b.a()));
                pGPSignatureGenerator.init(0, pGPPrivateKey);
                this.f40627j.put(next, pGPSignatureGenerator);
            }
        }
    }

    private void l() throws IOException {
        for (a next : this.f40627j.keySet()) {
            try {
                PGPSignature generate = this.f40627j.get(next).generate();
                if (!this.f40623e) {
                    generate.encode(this.f40633q);
                }
                this.f40626h.a(new h(generate, next));
            } catch (PGPException e10) {
                throw new IOException(e10);
            }
        }
    }

    public k a() {
        if (this.f40628k) {
            return this.f40626h.d();
        }
        throw new IllegalStateException("EncryptionStream must be closed before accessing the Result.");
    }

    public void close() throws IOException {
        if (!this.f40628k) {
            this.f40635w.flush();
            this.f40635w.close();
            this.f40634t.close();
            l();
            this.f40632p.close();
            OutputStream outputStream = this.f40631n;
            if (outputStream != null) {
                outputStream.flush();
                this.f40631n.close();
            }
            ArmoredOutputStream armoredOutputStream = this.f40630m;
            if (armoredOutputStream != null) {
                armoredOutputStream.flush();
                this.f40630m.close();
            }
            this.f40628k = true;
        }
    }

    public void flush() throws IOException {
        this.f40635w.flush();
    }

    public void write(int i10) throws IOException {
        this.f40635w.write(i10);
        for (PGPSignatureGenerator update : this.f40627j.values()) {
            update.update((byte) (i10 & 255));
        }
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i10, int i11) throws IOException {
        this.f40635w.write(bArr, 0, i11);
        for (PGPSignatureGenerator update : this.f40627j.values()) {
            update.update(bArr, 0, i11);
        }
    }
}
