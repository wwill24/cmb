package cn;

import cn.k;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bouncycastle.openpgp.PGPException;

public class f extends InputStream {

    /* renamed from: d  reason: collision with root package name */
    private static final Logger f34081d = Logger.getLogger(f.class.getName());

    /* renamed from: a  reason: collision with root package name */
    private final InputStream f34082a;

    /* renamed from: b  reason: collision with root package name */
    private final k.a f34083b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f34084c = false;

    f(InputStream inputStream, k.a aVar) {
        this.f34082a = inputStream;
        this.f34083b = aVar;
    }

    private void b(int i10) {
        for (h next : this.f34083b.e()) {
            if (i10 != -1) {
                next.b().update((byte) i10);
            }
        }
    }

    public k a() {
        if (this.f34084c) {
            return this.f34083b.d();
        }
        throw new IllegalStateException("DecryptionStream MUST be closed before the result can be accessed.");
    }

    /* access modifiers changed from: package-private */
    public void c() {
        for (h next : this.f34083b.e()) {
            try {
                next.c(next.b().verify());
            } catch (PGPException e10) {
                Logger logger = f34081d;
                Level level = Level.WARNING;
                logger.log(level, "Could not verify signature of key " + next.a(), e10);
            }
        }
    }

    public void close() throws IOException {
        this.f34082a.close();
        c();
        this.f34084c = true;
    }

    public int read() throws IOException {
        int read = this.f34082a.read();
        b(read);
        return read;
    }
}
