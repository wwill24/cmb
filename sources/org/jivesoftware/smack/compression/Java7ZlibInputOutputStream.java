package org.jivesoftware.smack.compression;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

public class Java7ZlibInputOutputStream extends XMPPInputOutputStream {
    private static final int compressionLevel = -1;

    /* renamed from: org.jivesoftware.smack.compression.Java7ZlibInputOutputStream$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$compression$XMPPInputOutputStream$FlushMethod;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                org.jivesoftware.smack.compression.XMPPInputOutputStream$FlushMethod[] r0 = org.jivesoftware.smack.compression.XMPPInputOutputStream.FlushMethod.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jivesoftware$smack$compression$XMPPInputOutputStream$FlushMethod = r0
                org.jivesoftware.smack.compression.XMPPInputOutputStream$FlushMethod r1 = org.jivesoftware.smack.compression.XMPPInputOutputStream.FlushMethod.SYNC_FLUSH     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$jivesoftware$smack$compression$XMPPInputOutputStream$FlushMethod     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jivesoftware.smack.compression.XMPPInputOutputStream$FlushMethod r1 = org.jivesoftware.smack.compression.XMPPInputOutputStream.FlushMethod.FULL_FLUSH     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.compression.Java7ZlibInputOutputStream.AnonymousClass3.<clinit>():void");
        }
    }

    public Java7ZlibInputOutputStream() {
        super("zlib");
    }

    public InputStream getInputStream(InputStream inputStream) {
        return new InflaterInputStream(inputStream, new Inflater(), 512) {
            public int available() throws IOException {
                if (this.inf.needsInput()) {
                    return 0;
                }
                return super.available();
            }
        };
    }

    public OutputStream getOutputStream(OutputStream outputStream) {
        int i10 = AnonymousClass3.$SwitchMap$org$jivesoftware$smack$compression$XMPPInputOutputStream$FlushMethod[XMPPInputOutputStream.flushMethod.ordinal()];
        final int i11 = 2;
        if (i10 != 1) {
            if (i10 == 2) {
                i11 = 3;
            } else {
                throw new AssertionError();
            }
        }
        return new DeflaterOutputStream(outputStream, new Deflater(-1)) {
            public void flush() throws IOException {
                while (true) {
                    Deflater deflater = this.def;
                    byte[] bArr = this.buf;
                    int deflate = deflater.deflate(bArr, 0, bArr.length, i11);
                    if (deflate > 0) {
                        this.out.write(this.buf, 0, deflate);
                    } else {
                        super.flush();
                        return;
                    }
                }
            }
        };
    }

    public boolean isSupported() {
        return true;
    }
}
