package org.jivesoftware.smack;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.cert.CertificateException;
import org.jivesoftware.smack.SmackException;

public interface XmppInputOutputFilter {

    public static class OutputResult {
        public static final OutputResult NO_OUTPUT = new OutputResult(false, (ByteBuffer) null);
        public final ByteBuffer filteredOutputData;
        public final boolean pendingFilterData;

        public OutputResult(ByteBuffer byteBuffer) {
            this(false, byteBuffer);
        }

        public OutputResult(boolean z10, ByteBuffer byteBuffer) {
            this.pendingFilterData = z10;
            this.filteredOutputData = byteBuffer;
        }
    }

    void closeInputOutput() {
    }

    String getFilterName();

    Object getStats();

    ByteBuffer input(ByteBuffer byteBuffer) throws IOException;

    OutputResult output(ByteBuffer byteBuffer, boolean z10, boolean z11, boolean z12) throws IOException;

    void waitUntilInputOutputClosed() throws IOException, SmackException.NoResponseException, CertificateException, InterruptedException, SmackException, XMPPException {
    }
}
