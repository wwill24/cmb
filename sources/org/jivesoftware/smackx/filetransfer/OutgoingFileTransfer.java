package org.jivesoftware.smackx.filetransfer;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Logger;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smack.util.CloseableUtil;
import org.jivesoftware.smackx.filetransfer.FileTransfer;
import org.jxmpp.jid.Jid;

public class OutgoingFileTransfer extends FileTransfer {
    /* access modifiers changed from: private */
    public static final Logger LOGGER = Logger.getLogger(OutgoingFileTransfer.class.getName());
    private static int RESPONSE_TIMEOUT = 60000;
    private NegotiationProgress callback;
    private Jid initiator;
    /* access modifiers changed from: private */
    public OutputStream outputStream;
    private Thread transferThread;

    /* renamed from: org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$packet$StanzaError$Condition;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                org.jivesoftware.smack.packet.StanzaError$Condition[] r0 = org.jivesoftware.smack.packet.StanzaError.Condition.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jivesoftware$smack$packet$StanzaError$Condition = r0
                org.jivesoftware.smack.packet.StanzaError$Condition r1 = org.jivesoftware.smack.packet.StanzaError.Condition.forbidden     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$jivesoftware$smack$packet$StanzaError$Condition     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jivesoftware.smack.packet.StanzaError$Condition r1 = org.jivesoftware.smack.packet.StanzaError.Condition.bad_request     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer.AnonymousClass4.<clinit>():void");
        }
    }

    public interface NegotiationProgress {
        void errorEstablishingStream(Exception exc);

        void outputStreamEstablished(OutputStream outputStream);

        void statusUpdated(FileTransfer.Status status, FileTransfer.Status status2);
    }

    protected OutgoingFileTransfer(Jid jid, Jid jid2, String str, FileTransferNegotiator fileTransferNegotiator) {
        super(jid2, str, fileTransferNegotiator);
        this.initiator = jid;
    }

    private void checkTransferThread() {
        Thread thread = this.transferThread;
        if ((thread != null && thread.isAlive()) || isDone()) {
            throw new IllegalStateException("File transfer in progress or has already completed.");
        }
    }

    public static int getResponseTimeout() {
        return RESPONSE_TIMEOUT;
    }

    /* access modifiers changed from: private */
    public void handleXMPPException(XMPPException.XMPPErrorException xMPPErrorException) {
        StanzaError stanzaError = xMPPErrorException.getStanzaError();
        if (stanzaError != null) {
            int i10 = AnonymousClass4.$SwitchMap$org$jivesoftware$smack$packet$StanzaError$Condition[stanzaError.getCondition().ordinal()];
            if (i10 == 1) {
                setStatus(FileTransfer.Status.refused);
                return;
            } else if (i10 != 2) {
                setStatus(FileTransfer.Status.error);
            } else {
                setStatus(FileTransfer.Status.error);
                setError(FileTransfer.Error.not_acceptable);
            }
        }
        setException(xMPPErrorException);
    }

    /* access modifiers changed from: private */
    public OutputStream negotiateStream(String str, long j10, String str2) throws SmackException, XMPPException, InterruptedException {
        FileTransfer.Status status = FileTransfer.Status.initial;
        FileTransfer.Status status2 = FileTransfer.Status.negotiating_transfer;
        if (updateStatus(status, status2)) {
            StreamNegotiator negotiateOutgoingTransfer = this.negotiator.negotiateOutgoingTransfer(getPeer(), this.streamID, str, j10, str2, RESPONSE_TIMEOUT);
            FileTransfer.Status status3 = FileTransfer.Status.negotiating_stream;
            if (updateStatus(status2, status3)) {
                this.outputStream = negotiateOutgoingTransfer.createOutgoingStream(this.streamID, this.initiator, getPeer());
                if (updateStatus(status3, FileTransfer.Status.negotiated)) {
                    return this.outputStream;
                }
                throw new SmackException.IllegalStateChangeException();
            }
            throw new SmackException.IllegalStateChangeException();
        }
        throw new SmackException.IllegalStateChangeException();
    }

    public static void setResponseTimeout(int i10) {
        RESPONSE_TIMEOUT = i10;
    }

    public void cancel() {
        setStatus(FileTransfer.Status.cancelled);
    }

    public long getBytesSent() {
        return this.amountWritten;
    }

    /* access modifiers changed from: protected */
    public OutputStream getOutputStream() {
        if (getStatus().equals(FileTransfer.Status.negotiated)) {
            return this.outputStream;
        }
        return null;
    }

    public synchronized OutputStream sendFile(String str, long j10, String str2) throws XMPPException, SmackException, InterruptedException {
        OutputStream negotiateStream;
        if (isDone() || this.outputStream != null) {
            throw new IllegalStateException("The negotiation process has already been attempted on this file transfer");
        }
        try {
            setFileInfo(str, j10);
            negotiateStream = negotiateStream(str, j10, str2);
            this.outputStream = negotiateStream;
        } catch (XMPPException.XMPPErrorException e10) {
            handleXMPPException(e10);
            throw e10;
        }
        return negotiateStream;
    }

    public synchronized void sendStream(InputStream inputStream, String str, long j10, String str2) {
        checkTransferThread();
        setFileInfo(str, j10);
        final String str3 = str;
        final long j11 = j10;
        final String str4 = str2;
        final InputStream inputStream2 = inputStream;
        AnonymousClass3 r12 = new Runnable() {
            public void run() {
                try {
                    OutgoingFileTransfer outgoingFileTransfer = OutgoingFileTransfer.this;
                    OutputStream unused = outgoingFileTransfer.outputStream = outgoingFileTransfer.negotiateStream(str3, j11, str4);
                } catch (XMPPException.XMPPErrorException e10) {
                    OutgoingFileTransfer.this.handleXMPPException(e10);
                    return;
                } catch (Exception e11) {
                    OutgoingFileTransfer.this.setException(e11);
                }
                if (OutgoingFileTransfer.this.outputStream != null && OutgoingFileTransfer.this.updateStatus(FileTransfer.Status.negotiated, FileTransfer.Status.in_progress)) {
                    try {
                        OutgoingFileTransfer outgoingFileTransfer2 = OutgoingFileTransfer.this;
                        outgoingFileTransfer2.writeToStream(inputStream2, outgoingFileTransfer2.outputStream);
                    } catch (IOException e12) {
                        OutgoingFileTransfer.this.setStatus(FileTransfer.Status.error);
                        OutgoingFileTransfer.this.setException(e12);
                    } catch (Throwable th2) {
                        CloseableUtil.maybeClose(inputStream2, OutgoingFileTransfer.LOGGER);
                        CloseableUtil.maybeClose(OutgoingFileTransfer.this.outputStream, OutgoingFileTransfer.LOGGER);
                        throw th2;
                    }
                    CloseableUtil.maybeClose(inputStream2, OutgoingFileTransfer.LOGGER);
                    CloseableUtil.maybeClose(OutgoingFileTransfer.this.outputStream, OutgoingFileTransfer.LOGGER);
                    OutgoingFileTransfer.this.updateStatus(FileTransfer.Status.in_progress, FileTransfer.Status.complete);
                }
            }
        };
        Thread thread = new Thread(r12, "File Transfer " + this.streamID);
        this.transferThread = thread;
        thread.start();
    }

    public void setCallback(NegotiationProgress negotiationProgress) {
        this.callback = negotiationProgress;
    }

    /* access modifiers changed from: protected */
    public void setException(Exception exc) {
        super.setException(exc);
        NegotiationProgress negotiationProgress = this.callback;
        if (negotiationProgress != null) {
            negotiationProgress.errorEstablishingStream(exc);
        }
    }

    /* access modifiers changed from: protected */
    public void setOutputStream(OutputStream outputStream2) {
        if (this.outputStream == null) {
            this.outputStream = outputStream2;
        }
    }

    /* access modifiers changed from: protected */
    public void setStatus(FileTransfer.Status status) {
        FileTransfer.Status status2 = getStatus();
        super.setStatus(status);
        NegotiationProgress negotiationProgress = this.callback;
        if (negotiationProgress != null) {
            negotiationProgress.statusUpdated(status2, status);
        }
    }

    /* access modifiers changed from: protected */
    public boolean updateStatus(FileTransfer.Status status, FileTransfer.Status status2) {
        boolean updateStatus = super.updateStatus(status, status2);
        NegotiationProgress negotiationProgress = this.callback;
        if (negotiationProgress != null && updateStatus) {
            negotiationProgress.statusUpdated(status, status2);
        }
        return updateStatus;
    }

    public synchronized void sendFile(String str, long j10, String str2, NegotiationProgress negotiationProgress) {
        if (negotiationProgress != null) {
            try {
                checkTransferThread();
                if (isDone() || this.outputStream != null) {
                    throw new IllegalStateException("The negotiation process has already been attempted for this file transfer");
                }
                setFileInfo(str, j10);
                this.callback = negotiationProgress;
                final String str3 = str;
                final long j11 = j10;
                final String str4 = str2;
                final NegotiationProgress negotiationProgress2 = negotiationProgress;
                AnonymousClass1 r12 = new Runnable() {
                    public void run() {
                        try {
                            OutgoingFileTransfer outgoingFileTransfer = OutgoingFileTransfer.this;
                            OutputStream unused = outgoingFileTransfer.outputStream = outgoingFileTransfer.negotiateStream(str3, j11, str4);
                            negotiationProgress2.outputStreamEstablished(OutgoingFileTransfer.this.outputStream);
                        } catch (XMPPException.XMPPErrorException e10) {
                            OutgoingFileTransfer.this.handleXMPPException(e10);
                        } catch (Exception e11) {
                            OutgoingFileTransfer.this.setException(e11);
                        }
                    }
                };
                Thread thread = new Thread(r12, "File Transfer Negotiation " + this.streamID);
                this.transferThread = thread;
                thread.start();
            } catch (Throwable th2) {
                throw th2;
            }
        } else {
            throw new IllegalArgumentException("Callback progress cannot be null.");
        }
    }

    public synchronized void sendFile(final File file, final String str) throws SmackException {
        checkTransferThread();
        if (file == null || !file.exists() || !file.canRead()) {
            throw new IllegalArgumentException("Could not read file");
        }
        setFileInfo(file.getAbsolutePath(), file.getName(), file.length());
        AnonymousClass2 r12 = new Runnable() {
            /* JADX WARNING: Unknown top exception splitter block from list: {B:21:0x0053=Splitter:B:21:0x0053, B:26:0x0078=Splitter:B:26:0x0078} */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r6 = this;
                    org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer r0 = org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer.this     // Catch:{ XMPPErrorException -> 0x00ac, Exception -> 0x0018 }
                    java.io.File r1 = r5     // Catch:{ XMPPErrorException -> 0x00ac, Exception -> 0x0018 }
                    java.lang.String r1 = r1.getName()     // Catch:{ XMPPErrorException -> 0x00ac, Exception -> 0x0018 }
                    java.io.File r2 = r5     // Catch:{ XMPPErrorException -> 0x00ac, Exception -> 0x0018 }
                    long r2 = r2.length()     // Catch:{ XMPPErrorException -> 0x00ac, Exception -> 0x0018 }
                    java.lang.String r4 = r6     // Catch:{ XMPPErrorException -> 0x00ac, Exception -> 0x0018 }
                    java.io.OutputStream r1 = r0.negotiateStream(r1, r2, r4)     // Catch:{ XMPPErrorException -> 0x00ac, Exception -> 0x0018 }
                    java.io.OutputStream unused = r0.outputStream = r1     // Catch:{ XMPPErrorException -> 0x00ac, Exception -> 0x0018 }
                    goto L_0x001e
                L_0x0018:
                    r0 = move-exception
                    org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer r1 = org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer.this
                    r1.setException(r0)
                L_0x001e:
                    org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer r0 = org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer.this
                    java.io.OutputStream r0 = r0.outputStream
                    if (r0 != 0) goto L_0x0027
                    return
                L_0x0027:
                    org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer r0 = org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer.this
                    org.jivesoftware.smackx.filetransfer.FileTransfer$Status r1 = org.jivesoftware.smackx.filetransfer.FileTransfer.Status.negotiated
                    org.jivesoftware.smackx.filetransfer.FileTransfer$Status r2 = org.jivesoftware.smackx.filetransfer.FileTransfer.Status.in_progress
                    boolean r0 = r0.updateStatus(r1, r2)
                    if (r0 != 0) goto L_0x0034
                    return
                L_0x0034:
                    r0 = 0
                    java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0074, IOException -> 0x004f, all -> 0x004a }
                    java.io.File r2 = r5     // Catch:{ FileNotFoundException -> 0x0074, IOException -> 0x004f, all -> 0x004a }
                    r1.<init>(r2)     // Catch:{ FileNotFoundException -> 0x0074, IOException -> 0x004f, all -> 0x004a }
                    org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer r0 = org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer.this     // Catch:{ FileNotFoundException -> 0x0048, IOException -> 0x0046 }
                    java.io.OutputStream r2 = r0.outputStream     // Catch:{ FileNotFoundException -> 0x0048, IOException -> 0x0046 }
                    r0.writeToStream(r1, r2)     // Catch:{ FileNotFoundException -> 0x0048, IOException -> 0x0046 }
                    goto L_0x005f
                L_0x0046:
                    r0 = move-exception
                    goto L_0x0053
                L_0x0048:
                    r0 = move-exception
                    goto L_0x0078
                L_0x004a:
                    r1 = move-exception
                    r5 = r1
                    r1 = r0
                    r0 = r5
                    goto L_0x0097
                L_0x004f:
                    r1 = move-exception
                    r5 = r1
                    r1 = r0
                    r0 = r5
                L_0x0053:
                    org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer r2 = org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer.this     // Catch:{ all -> 0x0096 }
                    org.jivesoftware.smackx.filetransfer.FileTransfer$Status r3 = org.jivesoftware.smackx.filetransfer.FileTransfer.Status.error     // Catch:{ all -> 0x0096 }
                    r2.setStatus(r3)     // Catch:{ all -> 0x0096 }
                    org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer r2 = org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer.this     // Catch:{ all -> 0x0096 }
                    r2.setException(r0)     // Catch:{ all -> 0x0096 }
                L_0x005f:
                    java.util.logging.Logger r0 = org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer.LOGGER
                    org.jivesoftware.smack.util.CloseableUtil.maybeClose(r1, r0)
                    org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer r0 = org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer.this
                    java.io.OutputStream r0 = r0.outputStream
                    java.util.logging.Logger r1 = org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer.LOGGER
                    org.jivesoftware.smack.util.CloseableUtil.maybeClose(r0, r1)
                    goto L_0x008c
                L_0x0074:
                    r1 = move-exception
                    r5 = r1
                    r1 = r0
                    r0 = r5
                L_0x0078:
                    org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer r2 = org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer.this     // Catch:{ all -> 0x0096 }
                    org.jivesoftware.smackx.filetransfer.FileTransfer$Status r3 = org.jivesoftware.smackx.filetransfer.FileTransfer.Status.error     // Catch:{ all -> 0x0096 }
                    r2.setStatus(r3)     // Catch:{ all -> 0x0096 }
                    org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer r2 = org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer.this     // Catch:{ all -> 0x0096 }
                    org.jivesoftware.smackx.filetransfer.FileTransfer$Error r3 = org.jivesoftware.smackx.filetransfer.FileTransfer.Error.bad_file     // Catch:{ all -> 0x0096 }
                    r2.setError(r3)     // Catch:{ all -> 0x0096 }
                    org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer r2 = org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer.this     // Catch:{ all -> 0x0096 }
                    r2.setException(r0)     // Catch:{ all -> 0x0096 }
                    goto L_0x005f
                L_0x008c:
                    org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer r0 = org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer.this
                    org.jivesoftware.smackx.filetransfer.FileTransfer$Status r1 = org.jivesoftware.smackx.filetransfer.FileTransfer.Status.in_progress
                    org.jivesoftware.smackx.filetransfer.FileTransfer$Status r2 = org.jivesoftware.smackx.filetransfer.FileTransfer.Status.complete
                    r0.updateStatus(r1, r2)
                    return
                L_0x0096:
                    r0 = move-exception
                L_0x0097:
                    java.util.logging.Logger r2 = org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer.LOGGER
                    org.jivesoftware.smack.util.CloseableUtil.maybeClose(r1, r2)
                    org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer r1 = org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer.this
                    java.io.OutputStream r1 = r1.outputStream
                    java.util.logging.Logger r2 = org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer.LOGGER
                    org.jivesoftware.smack.util.CloseableUtil.maybeClose(r1, r2)
                    throw r0
                L_0x00ac:
                    r0 = move-exception
                    org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer r1 = org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer.this
                    r1.handleXMPPException(r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer.AnonymousClass2.run():void");
            }
        };
        Thread thread = new Thread(r12, "File Transfer " + this.streamID);
        this.transferThread = thread;
        thread.start();
    }
}
