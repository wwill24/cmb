package cn;

import cn.k;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import jn.a;
import org.bouncycastle.openpgp.PGPCompressedData;
import org.bouncycastle.openpgp.PGPEncryptedDataList;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPLiteralData;
import org.bouncycastle.openpgp.PGPObjectFactory;
import org.bouncycastle.openpgp.PGPOnePassSignature;
import org.bouncycastle.openpgp.PGPOnePassSignatureList;
import org.bouncycastle.openpgp.PGPPrivateKey;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPPublicKeyEncryptedData;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPSecretKey;
import org.bouncycastle.openpgp.PGPSecretKeyRingCollection;
import org.bouncycastle.openpgp.PGPSignature;
import org.bouncycastle.openpgp.PGPUtil;
import org.bouncycastle.openpgp.operator.KeyFingerPrintCalculator;
import org.bouncycastle.openpgp.operator.PGPContentVerifierBuilderProvider;
import org.bouncycastle.openpgp.operator.bc.BcKeyFingerprintCalculator;
import org.bouncycastle.openpgp.operator.bc.BcPGPContentVerifierBuilderProvider;
import org.bouncycastle.openpgp.operator.bc.BcPublicKeyDataDecryptorFactory;
import org.pgpainless.algorithm.CompressionAlgorithm;
import org.pgpainless.algorithm.SymmetricKeyAlgorithm;

public final class g {

    /* renamed from: i  reason: collision with root package name */
    private static final Logger f34085i = Logger.getLogger(g.class.getName());

    /* renamed from: j  reason: collision with root package name */
    private static final Level f34086j = Level.FINE;

    /* renamed from: a  reason: collision with root package name */
    private final PGPSecretKeyRingCollection f34087a;

    /* renamed from: b  reason: collision with root package name */
    private final a f34088b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<PGPPublicKeyRing> f34089c;

    /* renamed from: d  reason: collision with root package name */
    private final i f34090d;

    /* renamed from: e  reason: collision with root package name */
    private final k.a f34091e = k.a();

    /* renamed from: f  reason: collision with root package name */
    private final PGPContentVerifierBuilderProvider f34092f = new BcPGPContentVerifierBuilderProvider();

    /* renamed from: g  reason: collision with root package name */
    private final KeyFingerPrintCalculator f34093g = new BcKeyFingerprintCalculator();

    /* renamed from: h  reason: collision with root package name */
    private final Map<en.a, j> f34094h = new HashMap();

    private g(PGPSecretKeyRingCollection pGPSecretKeyRingCollection, a aVar, Set<PGPPublicKeyRing> set, i iVar) {
        HashSet hashSet = new HashSet();
        this.f34089c = hashSet;
        this.f34087a = pGPSecretKeyRingCollection;
        this.f34088b = aVar;
        hashSet.addAll(set == null ? Collections.emptyList() : set);
        this.f34090d = iVar;
    }

    public static f a(InputStream inputStream, PGPSecretKeyRingCollection pGPSecretKeyRingCollection, a aVar, List<PGPSignature> list, Set<PGPPublicKeyRing> set, i iVar) throws IOException, PGPException {
        g gVar = new g(pGPSecretKeyRingCollection, aVar, set, iVar);
        if (list != null) {
            for (PGPSignature next : list) {
                PGPPublicKey c10 = gVar.c(next.getKeyID());
                next.init(new BcPGPContentVerifierBuilderProvider(), c10);
                gVar.f34091e.a(new h(next, new en.a(c10)));
            }
        } else {
            inputStream = gVar.l(new PGPObjectFactory(PGPUtil.getDecoderStream(inputStream), new BcKeyFingerprintCalculator()));
        }
        return new f(inputStream, gVar.f34091e);
    }

    private InputStream b(PGPEncryptedDataList pGPEncryptedDataList) throws PGPException {
        Iterator encryptedDataObjects = pGPEncryptedDataList.getEncryptedDataObjects();
        if (encryptedDataObjects.hasNext()) {
            PGPPrivateKey pGPPrivateKey = null;
            PGPPublicKeyEncryptedData pGPPublicKeyEncryptedData = null;
            while (encryptedDataObjects.hasNext()) {
                PGPPublicKeyEncryptedData pGPPublicKeyEncryptedData2 = (PGPPublicKeyEncryptedData) encryptedDataObjects.next();
                long keyID = pGPPublicKeyEncryptedData2.getKeyID();
                this.f34091e.c(Long.valueOf(keyID));
                Logger logger = f34085i;
                Level level = f34086j;
                logger.log(level, "PGPEncryptedData is encrypted for key " + Long.toHexString(keyID));
                PGPSecretKey secretKey = this.f34087a.getSecretKey(keyID);
                if (secretKey != null) {
                    logger.log(level, "Found respective secret key " + Long.toHexString(keyID));
                    pGPPrivateKey = secretKey.extractPrivateKey(this.f34088b.a(Long.valueOf(keyID)));
                    this.f34091e.g(new en.a(secretKey));
                    pGPPublicKeyEncryptedData = pGPPublicKeyEncryptedData2;
                }
            }
            if (pGPPrivateKey != null) {
                BcPublicKeyDataDecryptorFactory bcPublicKeyDataDecryptorFactory = new BcPublicKeyDataDecryptorFactory(pGPPrivateKey);
                SymmetricKeyAlgorithm a10 = SymmetricKeyAlgorithm.a(pGPPublicKeyEncryptedData.getSymmetricAlgorithm(bcPublicKeyDataDecryptorFactory));
                f34085i.log(f34086j, "Message is encrypted using " + a10);
                this.f34091e.i(a10);
                this.f34091e.h(pGPPublicKeyEncryptedData.isIntegrityProtected());
                return pGPPublicKeyEncryptedData.getDataStream(bcPublicKeyDataDecryptorFactory);
            }
            throw new PGPException("Decryption failed - No suitable decryption key found");
        }
        throw new PGPException("Decryption failed - EncryptedDataList has no items");
    }

    private PGPPublicKey c(long j10) {
        Iterator<PGPPublicKeyRing> it = this.f34089c.iterator();
        PGPPublicKey pGPPublicKey = null;
        while (true) {
            if (it.hasNext()) {
                pGPPublicKey = it.next().getPublicKey(j10);
                if (pGPPublicKey != null) {
                    Logger logger = f34085i;
                    Level level = f34086j;
                    logger.log(level, "Found public key " + Long.toHexString(j10) + " for signature verification");
                    break;
                }
            } else {
                break;
            }
        }
        if (pGPPublicKey == null) {
            return d(j10);
        }
        return pGPPublicKey;
    }

    private PGPPublicKey d(long j10) {
        Logger logger = f34085i;
        Level level = Level.FINER;
        logger.log(level, "No public key found for signature of " + Long.toHexString(j10));
        i iVar = this.f34090d;
        if (iVar == null) {
            logger.log(level, "No MissingPublicKeyCallback registered. Skip signature of " + Long.toHexString(j10));
            return null;
        }
        PGPPublicKey onMissingPublicKeyEncountered = iVar.onMissingPublicKeyEncountered(Long.valueOf(j10));
        if (onMissingPublicKeyEncountered == null) {
            logger.log(level, "MissingPublicKeyCallback did not provider key. Skip signature of " + Long.toHexString(j10));
            return null;
        } else if (onMissingPublicKeyEncountered.getKeyID() == j10) {
            return onMissingPublicKeyEncountered;
        } else {
            throw new IllegalArgumentException("KeyID of the provided public key differs from the signatures keyId. The signature was created from " + Long.toHexString(j10) + " while the provided key has ID " + Long.toHexString(onMissingPublicKeyEncountered.getKeyID()));
        }
    }

    private void e(PGPOnePassSignatureList pGPOnePassSignatureList) throws PGPException {
        Iterator it = pGPOnePassSignatureList.iterator();
        if (it.hasNext()) {
            h(it);
            return;
        }
        throw new PGPException("Verification failed - No OnePassSignatures found");
    }

    private void f(PGPOnePassSignature pGPOnePassSignature) throws PGPException {
        long keyID = pGPOnePassSignature.getKeyID();
        Logger logger = f34085i;
        Level level = f34086j;
        logger.log(level, "Message contains OnePassSignature from " + Long.toHexString(keyID));
        PGPPublicKey c10 = c(keyID);
        if (c10 == null) {
            logger.log(level, "Missing verification key from " + Long.toHexString(keyID));
            return;
        }
        pGPOnePassSignature.init(this.f34092f, c10);
        j jVar = new j(pGPOnePassSignature, new en.a(c10));
        this.f34091e.b(jVar);
        this.f34094h.put(new en.a(c10), jVar);
    }

    private InputStream g(PGPObjectFactory pGPObjectFactory, PGPOnePassSignatureList pGPOnePassSignatureList) throws PGPException, IOException {
        Logger logger = f34085i;
        Level level = f34086j;
        logger.log(level, "Encountered PGPOnePassSignatureList of size " + pGPOnePassSignatureList.size());
        e(pGPOnePassSignatureList);
        return l(pGPObjectFactory);
    }

    private void h(Iterator<PGPOnePassSignature> it) throws PGPException {
        while (it.hasNext()) {
            f(it.next());
        }
    }

    private InputStream i(PGPCompressedData pGPCompressedData) throws PGPException, IOException {
        CompressionAlgorithm a10 = CompressionAlgorithm.a(pGPCompressedData.getAlgorithm());
        Logger logger = f34085i;
        Level level = f34086j;
        logger.log(level, "Encountered PGPCompressedData: " + a10);
        this.f34091e.f(a10);
        return l(new PGPObjectFactory(PGPUtil.getDecoderStream(pGPCompressedData.getDataStream()), this.f34093g));
    }

    private InputStream j(PGPEncryptedDataList pGPEncryptedDataList) throws PGPException, IOException {
        f34085i.log(f34086j, "Encountered PGPEncryptedDataList");
        return l(new PGPObjectFactory(PGPUtil.getDecoderStream(b(pGPEncryptedDataList)), this.f34093g));
    }

    private InputStream k(PGPObjectFactory pGPObjectFactory, PGPLiteralData pGPLiteralData) {
        Logger logger = f34085i;
        Level level = f34086j;
        logger.log(level, "Found PGPLiteralData");
        InputStream inputStream = pGPLiteralData.getInputStream();
        if (!this.f34094h.isEmpty()) {
            return new l(inputStream, pGPObjectFactory, this.f34094h, this.f34091e);
        }
        logger.log(level, "No OnePassSignatures found -> We are done");
        return inputStream;
    }

    private InputStream l(PGPObjectFactory pGPObjectFactory) throws IOException, PGPException {
        Object nextObject;
        do {
            nextObject = pGPObjectFactory.nextObject();
            if (nextObject == null) {
                throw new PGPException("No Literal Data Packet found");
            } else if (nextObject instanceof PGPEncryptedDataList) {
                return j((PGPEncryptedDataList) nextObject);
            } else {
                if (nextObject instanceof PGPCompressedData) {
                    return i((PGPCompressedData) nextObject);
                }
                if (nextObject instanceof PGPOnePassSignatureList) {
                    return g(pGPObjectFactory, (PGPOnePassSignatureList) nextObject);
                }
            }
        } while (!(nextObject instanceof PGPLiteralData));
        return k(pGPObjectFactory, (PGPLiteralData) nextObject);
    }
}
