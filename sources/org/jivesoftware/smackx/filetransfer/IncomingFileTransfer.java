package org.jivesoftware.smackx.filetransfer;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.filetransfer.FileTransfer;

public class IncomingFileTransfer extends FileTransfer {
    /* access modifiers changed from: private */
    public static final Logger LOGGER = Logger.getLogger(IncomingFileTransfer.class.getName());
    /* access modifiers changed from: private */
    public InputStream inputStream;
    /* access modifiers changed from: private */
    public FileTransferRequest receiveRequest;

    protected IncomingFileTransfer(FileTransferRequest fileTransferRequest, FileTransferNegotiator fileTransferNegotiator) {
        super(fileTransferRequest.getRequestor(), fileTransferRequest.getStreamID(), fileTransferNegotiator);
        this.receiveRequest = fileTransferRequest;
    }

    /* access modifiers changed from: private */
    public InputStream negotiateStream() throws SmackException, XMPPException.XMPPErrorException, InterruptedException {
        setStatus(FileTransfer.Status.negotiating_transfer);
        final StreamNegotiator selectStreamNegotiator = this.negotiator.selectStreamNegotiator(this.receiveRequest);
        setStatus(FileTransfer.Status.negotiating_stream);
        FutureTask futureTask = new FutureTask(new Callable<InputStream>() {
            public InputStream call() throws Exception {
                return selectStreamNegotiator.createIncomingStream(IncomingFileTransfer.this.receiveRequest.getStreamInitiation());
            }
        });
        futureTask.run();
        try {
            InputStream inputStream2 = (InputStream) futureTask.get(15, TimeUnit.SECONDS);
            futureTask.cancel(true);
            setStatus(FileTransfer.Status.negotiated);
            return inputStream2;
        } catch (ExecutionException e10) {
            Throwable cause = e10.getCause();
            if (cause instanceof XMPPException.XMPPErrorException) {
                throw ((XMPPException.XMPPErrorException) cause);
            } else if (cause instanceof InterruptedException) {
                throw ((InterruptedException) cause);
            } else if (cause instanceof SmackException.NoResponseException) {
                throw ((SmackException.NoResponseException) cause);
            } else if (cause instanceof SmackException) {
                throw ((SmackException) cause);
            } else {
                throw new SmackException.SmackWrappedException("Error in execution", e10);
            }
        } catch (TimeoutException e11) {
            throw new SmackException.SmackWrappedException("Request timed out", e11);
        } catch (Throwable th2) {
            futureTask.cancel(true);
            throw th2;
        }
    }

    public void cancel() {
        setStatus(FileTransfer.Status.cancelled);
    }

    public InputStream receiveFile() throws SmackException, XMPPException.XMPPErrorException, InterruptedException {
        if (this.inputStream == null) {
            try {
                InputStream negotiateStream = negotiateStream();
                this.inputStream = negotiateStream;
                return negotiateStream;
            } catch (XMPPException.XMPPErrorException e10) {
                setException(e10);
                throw e10;
            }
        } else {
            throw new IllegalStateException("Transfer already negotiated!");
        }
    }

    public void receiveFile(final File file) throws SmackException, IOException {
        if (file != null) {
            if (!file.exists()) {
                file.createNewFile();
            }
            if (file.canWrite()) {
                AnonymousClass1 r12 = new Runnable() {
                    /* JADX WARNING: Removed duplicated region for block: B:17:0x0063  */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void run() {
                        /*
                            r5 = this;
                            org.jivesoftware.smackx.filetransfer.IncomingFileTransfer r0 = org.jivesoftware.smackx.filetransfer.IncomingFileTransfer.this     // Catch:{ Exception -> 0x007f }
                            java.io.InputStream r1 = r0.negotiateStream()     // Catch:{ Exception -> 0x007f }
                            java.io.InputStream unused = r0.inputStream = r1     // Catch:{ Exception -> 0x007f }
                            r0 = 0
                            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x003e, IOException -> 0x0026 }
                            java.io.File r2 = r4     // Catch:{ FileNotFoundException -> 0x003e, IOException -> 0x0026 }
                            r1.<init>(r2)     // Catch:{ FileNotFoundException -> 0x003e, IOException -> 0x0026 }
                            org.jivesoftware.smackx.filetransfer.IncomingFileTransfer r0 = org.jivesoftware.smackx.filetransfer.IncomingFileTransfer.this     // Catch:{ FileNotFoundException -> 0x0024, IOException -> 0x0022 }
                            org.jivesoftware.smackx.filetransfer.FileTransfer$Status r2 = org.jivesoftware.smackx.filetransfer.FileTransfer.Status.in_progress     // Catch:{ FileNotFoundException -> 0x0024, IOException -> 0x0022 }
                            r0.setStatus(r2)     // Catch:{ FileNotFoundException -> 0x0024, IOException -> 0x0022 }
                            org.jivesoftware.smackx.filetransfer.IncomingFileTransfer r0 = org.jivesoftware.smackx.filetransfer.IncomingFileTransfer.this     // Catch:{ FileNotFoundException -> 0x0024, IOException -> 0x0022 }
                            java.io.InputStream r2 = r0.inputStream     // Catch:{ FileNotFoundException -> 0x0024, IOException -> 0x0022 }
                            r0.writeToStream(r2, r1)     // Catch:{ FileNotFoundException -> 0x0024, IOException -> 0x0022 }
                            goto L_0x0055
                        L_0x0022:
                            r0 = move-exception
                            goto L_0x002a
                        L_0x0024:
                            r0 = move-exception
                            goto L_0x0042
                        L_0x0026:
                            r1 = move-exception
                            r4 = r1
                            r1 = r0
                            r0 = r4
                        L_0x002a:
                            org.jivesoftware.smackx.filetransfer.IncomingFileTransfer r2 = org.jivesoftware.smackx.filetransfer.IncomingFileTransfer.this
                            org.jivesoftware.smackx.filetransfer.FileTransfer$Status r3 = org.jivesoftware.smackx.filetransfer.FileTransfer.Status.error
                            r2.setStatus(r3)
                            org.jivesoftware.smackx.filetransfer.IncomingFileTransfer r2 = org.jivesoftware.smackx.filetransfer.IncomingFileTransfer.this
                            org.jivesoftware.smackx.filetransfer.FileTransfer$Error r3 = org.jivesoftware.smackx.filetransfer.FileTransfer.Error.stream
                            r2.setError(r3)
                            org.jivesoftware.smackx.filetransfer.IncomingFileTransfer r2 = org.jivesoftware.smackx.filetransfer.IncomingFileTransfer.this
                            r2.setException(r0)
                            goto L_0x0055
                        L_0x003e:
                            r1 = move-exception
                            r4 = r1
                            r1 = r0
                            r0 = r4
                        L_0x0042:
                            org.jivesoftware.smackx.filetransfer.IncomingFileTransfer r2 = org.jivesoftware.smackx.filetransfer.IncomingFileTransfer.this
                            org.jivesoftware.smackx.filetransfer.FileTransfer$Status r3 = org.jivesoftware.smackx.filetransfer.FileTransfer.Status.error
                            r2.setStatus(r3)
                            org.jivesoftware.smackx.filetransfer.IncomingFileTransfer r2 = org.jivesoftware.smackx.filetransfer.IncomingFileTransfer.this
                            org.jivesoftware.smackx.filetransfer.FileTransfer$Error r3 = org.jivesoftware.smackx.filetransfer.FileTransfer.Error.bad_file
                            r2.setError(r3)
                            org.jivesoftware.smackx.filetransfer.IncomingFileTransfer r2 = org.jivesoftware.smackx.filetransfer.IncomingFileTransfer.this
                            r2.setException(r0)
                        L_0x0055:
                            org.jivesoftware.smackx.filetransfer.IncomingFileTransfer r0 = org.jivesoftware.smackx.filetransfer.IncomingFileTransfer.this
                            org.jivesoftware.smackx.filetransfer.FileTransfer$Status r0 = r0.getStatus()
                            org.jivesoftware.smackx.filetransfer.FileTransfer$Status r2 = org.jivesoftware.smackx.filetransfer.FileTransfer.Status.in_progress
                            boolean r0 = r0.equals(r2)
                            if (r0 == 0) goto L_0x006a
                            org.jivesoftware.smackx.filetransfer.IncomingFileTransfer r0 = org.jivesoftware.smackx.filetransfer.IncomingFileTransfer.this
                            org.jivesoftware.smackx.filetransfer.FileTransfer$Status r2 = org.jivesoftware.smackx.filetransfer.FileTransfer.Status.complete
                            r0.setStatus(r2)
                        L_0x006a:
                            org.jivesoftware.smackx.filetransfer.IncomingFileTransfer r0 = org.jivesoftware.smackx.filetransfer.IncomingFileTransfer.this
                            java.io.InputStream r0 = r0.inputStream
                            java.util.logging.Logger r2 = org.jivesoftware.smackx.filetransfer.IncomingFileTransfer.LOGGER
                            org.jivesoftware.smack.util.CloseableUtil.maybeClose(r0, r2)
                            java.util.logging.Logger r0 = org.jivesoftware.smackx.filetransfer.IncomingFileTransfer.LOGGER
                            org.jivesoftware.smack.util.CloseableUtil.maybeClose(r1, r0)
                            return
                        L_0x007f:
                            r0 = move-exception
                            org.jivesoftware.smackx.filetransfer.IncomingFileTransfer r1 = org.jivesoftware.smackx.filetransfer.IncomingFileTransfer.this
                            org.jivesoftware.smackx.filetransfer.FileTransfer$Status r2 = org.jivesoftware.smackx.filetransfer.FileTransfer.Status.error
                            r1.setStatus(r2)
                            org.jivesoftware.smackx.filetransfer.IncomingFileTransfer r1 = org.jivesoftware.smackx.filetransfer.IncomingFileTransfer.this
                            r1.setException(r0)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.filetransfer.IncomingFileTransfer.AnonymousClass1.run():void");
                    }
                };
                new Thread(r12, "File Transfer " + this.streamID).start();
                return;
            }
            throw new IllegalArgumentException("Cannot write to provided file");
        }
        throw new IllegalArgumentException("File cannot be null");
    }
}
