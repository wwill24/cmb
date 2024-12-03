package cn;

import cn.k;
import en.a;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.SignatureException;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPObjectFactory;
import org.bouncycastle.openpgp.PGPSignature;
import org.bouncycastle.openpgp.PGPSignatureList;

public class l extends FilterInputStream {

    /* renamed from: e  reason: collision with root package name */
    private static final Logger f34116e = Logger.getLogger(l.class.getName());

    /* renamed from: f  reason: collision with root package name */
    private static final Level f34117f = Level.FINE;

    /* renamed from: a  reason: collision with root package name */
    private final PGPObjectFactory f34118a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<a, j> f34119b;

    /* renamed from: c  reason: collision with root package name */
    private final k.a f34120c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f34121d = false;

    protected l(InputStream inputStream, PGPObjectFactory pGPObjectFactory, Map<a, j> map, k.a aVar) {
        super(inputStream);
        this.f34118a = pGPObjectFactory;
        this.f34120c = aVar;
        this.f34119b = map;
        f34116e.log(f34117f, "Begin verifying OnePassSignatures");
    }

    private a a(PGPSignature pGPSignature) {
        for (a next : this.f34119b.keySet()) {
            if (next.b() == pGPSignature.getKeyID()) {
                return next;
            }
        }
        return null;
    }

    private j b(a aVar) {
        if (aVar != null) {
            return this.f34119b.get(aVar);
        }
        return null;
    }

    private PGPSignatureList c() throws IOException {
        Object nextObject = this.f34118a.nextObject();
        PGPSignatureList pGPSignatureList = null;
        while (nextObject != null && pGPSignatureList == null) {
            if (nextObject instanceof PGPSignatureList) {
                pGPSignatureList = (PGPSignatureList) nextObject;
            } else {
                nextObject = this.f34118a.nextObject();
            }
        }
        if (pGPSignatureList != null && !pGPSignatureList.isEmpty()) {
            return pGPSignatureList;
        }
        throw new IOException("Verification failed - No Signatures found");
    }

    private void e(byte b10) {
        for (j a10 : this.f34119b.values()) {
            a10.a().update(b10);
        }
    }

    private void f(byte[] bArr, int i10, int i11) {
        for (j a10 : this.f34119b.values()) {
            a10.a().update(bArr, i10, i11);
        }
    }

    private void g() throws IOException {
        try {
            Iterator it = c().iterator();
            while (it.hasNext()) {
                PGPSignature pGPSignature = (PGPSignature) it.next();
                a a10 = a(pGPSignature);
                j b10 = b(a10);
                if (b10 == null) {
                    f34116e.log(f34117f, "Found Signature without respective OnePassSignature packet -> skip");
                } else {
                    l(pGPSignature, a10, b10);
                }
            }
        } catch (SignatureException | PGPException e10) {
            throw new IOException(e10.getMessage(), e10);
        }
    }

    private void h() throws IOException {
        if (this.f34119b.isEmpty()) {
            f34116e.log(f34117f, "No One-Pass-Signatures found -> No validation");
        } else {
            g();
        }
    }

    private void k() throws IOException {
        if (!this.f34121d) {
            this.f34121d = true;
            h();
        }
    }

    private void l(PGPSignature pGPSignature, a aVar, j jVar) throws PGPException, SignatureException {
        if (jVar.c(pGPSignature)) {
            Logger logger = f34116e;
            Level level = f34117f;
            logger.log(level, "Verified signature of key " + Long.toHexString(pGPSignature.getKeyID()));
            return;
        }
        throw new SignatureException("Bad Signature of key " + pGPSignature.getKeyID());
    }

    public synchronized void mark(int i10) {
        throw new UnsupportedOperationException("mark() not supported");
    }

    public boolean markSupported() {
        return false;
    }

    public int read() throws IOException {
        int read = super.read();
        if (read == -1) {
            k();
        } else {
            e((byte) read);
        }
        return read;
    }

    public synchronized void reset() {
        throw new UnsupportedOperationException("reset() is not supported");
    }

    public long skip(long j10) {
        throw new UnsupportedOperationException("skip() is not supported");
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i10, int i11) throws IOException {
        int read = super.read(bArr, i10, i11);
        if (read == -1) {
            k();
        } else {
            f(bArr, i10, read);
        }
        return read;
    }
}
