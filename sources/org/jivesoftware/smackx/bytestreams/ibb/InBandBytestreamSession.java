package org.jivesoftware.smackx.bytestreams.ibb;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.datatypes.UInt16;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.filter.StanzaTypeFilter;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.StanzaBuilder;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smack.util.stringencoder.Base64;
import org.jivesoftware.smackx.bytestreams.BytestreamSession;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Close;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Data;
import org.jivesoftware.smackx.bytestreams.ibb.packet.DataPacketExtension;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Open;
import org.jxmpp.jid.Jid;

public class InBandBytestreamSession implements BytestreamSession {
    /* access modifiers changed from: private */
    public static final Logger LOGGER = Logger.getLogger(InBandBytestreamSession.class.getName());
    static final String UNEXPECTED_IBB_SEQUENCE = "Unexpected IBB sequence";
    /* access modifiers changed from: private */
    public final Open byteStreamRequest;
    private boolean closeBothStreamsEnabled = false;
    /* access modifiers changed from: private */
    public final XMPPConnection connection;
    private IBBInputStream inputStream;
    private boolean isClosed = false;
    private IBBOutputStream outputStream;
    /* access modifiers changed from: private */
    public Jid remoteJID;

    /* renamed from: org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamSession$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smackx$bytestreams$ibb$InBandBytestreamManager$StanzaType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamManager$StanzaType[] r0 = org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamManager.StanzaType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jivesoftware$smackx$bytestreams$ibb$InBandBytestreamManager$StanzaType = r0
                org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamManager$StanzaType r1 = org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamManager.StanzaType.IQ     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$jivesoftware$smackx$bytestreams$ibb$InBandBytestreamManager$StanzaType     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamManager$StanzaType r1 = org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamManager.StanzaType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamSession.AnonymousClass1.<clinit>():void");
        }
    }

    private class IBBDataPacketFilter implements StanzaFilter {
        private IBBDataPacketFilter() {
        }

        public boolean accept(Stanza stanza) {
            DataPacketExtension dataPacketExtension;
            if (!stanza.getFrom().Y(InBandBytestreamSession.this.remoteJID)) {
                return false;
            }
            if (stanza instanceof Data) {
                dataPacketExtension = ((Data) stanza).getDataPacketExtension();
            } else {
                dataPacketExtension = (DataPacketExtension) stanza.getExtension(DataPacketExtension.class);
                if (dataPacketExtension == null) {
                    return false;
                }
            }
            if (!dataPacketExtension.getSessionID().equals(InBandBytestreamSession.this.byteStreamRequest.getSessionID())) {
                return false;
            }
            return true;
        }

        /* synthetic */ IBBDataPacketFilter(InBandBytestreamSession inBandBytestreamSession, AnonymousClass1 r22) {
            this();
        }
    }

    private abstract class IBBOutputStream extends OutputStream {
        protected final byte[] buffer;
        protected int bufferPointer;
        protected boolean isClosed;
        protected UInt16 seq;

        /* synthetic */ IBBOutputStream(InBandBytestreamSession inBandBytestreamSession, AnonymousClass1 r22) {
            this();
        }

        private synchronized void flushBuffer() throws IOException {
            int i10 = this.bufferPointer;
            if (i10 != 0) {
                try {
                    writeToXML(new DataPacketExtension(InBandBytestreamSession.this.byteStreamRequest.getSessionID(), this.seq, Base64.encodeToString(this.buffer, 0, i10)));
                    this.bufferPointer = 0;
                    this.seq = this.seq.incrementedByOne();
                } catch (InterruptedException | SmackException.NotConnectedException e10) {
                    IOException iOException = new IOException();
                    iOException.initCause(e10);
                    throw iOException;
                }
            }
        }

        private synchronized void writeOut(byte[] bArr, int i10, int i11) throws IOException {
            if (!this.isClosed) {
                int i12 = 0;
                byte[] bArr2 = this.buffer;
                int length = bArr2.length;
                int i13 = this.bufferPointer;
                if (i11 > length - i13) {
                    i12 = bArr2.length - i13;
                    System.arraycopy(bArr, i10, bArr2, i13, i12);
                    this.bufferPointer += i12;
                    flushBuffer();
                }
                int i14 = i11 - i12;
                System.arraycopy(bArr, i10 + i12, this.buffer, this.bufferPointer, i14);
                this.bufferPointer += i14;
            } else {
                throw new IOException("Stream is closed");
            }
        }

        public void close() throws IOException {
            if (!this.isClosed) {
                InBandBytestreamSession.this.closeByLocal(false);
            }
        }

        /* access modifiers changed from: protected */
        public void closeInternal(boolean z10) {
            if (!this.isClosed) {
                this.isClosed = true;
                if (z10) {
                    try {
                        flushBuffer();
                    } catch (IOException unused) {
                    }
                }
            }
        }

        public synchronized void flush() throws IOException {
            if (!this.isClosed) {
                flushBuffer();
            } else {
                throw new IOException("Stream is closed");
            }
        }

        public synchronized void write(int i10) throws IOException {
            if (!this.isClosed) {
                if (this.bufferPointer >= this.buffer.length) {
                    flushBuffer();
                }
                byte[] bArr = this.buffer;
                int i11 = this.bufferPointer;
                this.bufferPointer = i11 + 1;
                bArr[i11] = (byte) i10;
            } else {
                throw new IOException("Stream is closed");
            }
        }

        /* access modifiers changed from: protected */
        public abstract void writeToXML(DataPacketExtension dataPacketExtension) throws IOException, SmackException.NotConnectedException, InterruptedException;

        private IBBOutputStream() {
            this.bufferPointer = 0;
            this.seq = UInt16.from(0);
            this.isClosed = false;
            this.buffer = new byte[InBandBytestreamSession.this.byteStreamRequest.getBlockSize()];
        }

        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0030, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void write(byte[] r3, int r4, int r5) throws java.io.IOException {
            /*
                r2 = this;
                monitor-enter(r2)
                if (r3 == 0) goto L_0x003f
                if (r4 < 0) goto L_0x0039
                int r0 = r3.length     // Catch:{ all -> 0x0045 }
                if (r4 > r0) goto L_0x0039
                if (r5 < 0) goto L_0x0039
                int r0 = r4 + r5
                int r1 = r3.length     // Catch:{ all -> 0x0045 }
                if (r0 > r1) goto L_0x0039
                if (r0 < 0) goto L_0x0039
                if (r5 != 0) goto L_0x0015
                monitor-exit(r2)
                return
            L_0x0015:
                boolean r0 = r2.isClosed     // Catch:{ all -> 0x0045 }
                if (r0 != 0) goto L_0x0031
                byte[] r0 = r2.buffer     // Catch:{ all -> 0x0045 }
                int r1 = r0.length     // Catch:{ all -> 0x0045 }
                if (r5 < r1) goto L_0x002c
                int r0 = r0.length     // Catch:{ all -> 0x0045 }
                r2.writeOut(r3, r4, r0)     // Catch:{ all -> 0x0045 }
                byte[] r0 = r2.buffer     // Catch:{ all -> 0x0045 }
                int r1 = r0.length     // Catch:{ all -> 0x0045 }
                int r4 = r4 + r1
                int r0 = r0.length     // Catch:{ all -> 0x0045 }
                int r5 = r5 - r0
                r2.write(r3, r4, r5)     // Catch:{ all -> 0x0045 }
                goto L_0x002f
            L_0x002c:
                r2.writeOut(r3, r4, r5)     // Catch:{ all -> 0x0045 }
            L_0x002f:
                monitor-exit(r2)
                return
            L_0x0031:
                java.io.IOException r3 = new java.io.IOException     // Catch:{ all -> 0x0045 }
                java.lang.String r4 = "Stream is closed"
                r3.<init>(r4)     // Catch:{ all -> 0x0045 }
                throw r3     // Catch:{ all -> 0x0045 }
            L_0x0039:
                java.lang.IndexOutOfBoundsException r3 = new java.lang.IndexOutOfBoundsException     // Catch:{ all -> 0x0045 }
                r3.<init>()     // Catch:{ all -> 0x0045 }
                throw r3     // Catch:{ all -> 0x0045 }
            L_0x003f:
                java.lang.NullPointerException r3 = new java.lang.NullPointerException     // Catch:{ all -> 0x0045 }
                r3.<init>()     // Catch:{ all -> 0x0045 }
                throw r3     // Catch:{ all -> 0x0045 }
            L_0x0045:
                r3 = move-exception
                monitor-exit(r2)
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamSession.IBBOutputStream.write(byte[], int, int):void");
        }

        public synchronized void write(byte[] bArr) throws IOException {
            write(bArr, 0, bArr.length);
        }
    }

    private class IQIBBInputStream extends IBBInputStream {
        private IQIBBInputStream() {
            super();
        }

        /* access modifiers changed from: protected */
        public StanzaFilter getDataPacketFilter() {
            return new AndFilter(new StanzaTypeFilter(Data.class), new IBBDataPacketFilter(InBandBytestreamSession.this, (AnonymousClass1) null));
        }

        /* access modifiers changed from: protected */
        public StanzaListener getDataPacketListener() {
            return new StanzaListener() {
                private UInt16 expectedSequence = UInt16.MIN_VALUE;

                public void processStanza(Stanza stanza) throws SmackException.NotConnectedException, InterruptedException {
                    Data data = (Data) stanza;
                    DataPacketExtension dataPacketExtension = data.getDataPacketExtension();
                    UInt16 seq = dataPacketExtension.getSeq();
                    if (!this.expectedSequence.equals(seq)) {
                        String str = "Unexpected IBB sequence " + seq + " received, expected " + this.expectedSequence;
                        InBandBytestreamSession.this.connection.sendStanza(IQ.createErrorResponse((IQ) data, ((StanzaError.Builder) StanzaError.getBuilder().setCondition(StanzaError.Condition.unexpected_request).setDescriptiveEnText(str)).build()));
                        try {
                            IQIBBInputStream.this.close();
                        } catch (IOException unused) {
                            InBandBytestreamSession.LOGGER.log(Level.FINER, "Could not close session, because of IOException. Close reason: " + str);
                        }
                    } else if (dataPacketExtension.getDecodedData() == null) {
                        InBandBytestreamSession.this.connection.sendStanza(IQ.createErrorResponse((IQ) stanza, StanzaError.Condition.bad_request));
                    } else {
                        this.expectedSequence = seq.incrementedByOne();
                        IQIBBInputStream.this.dataQueue.offer(dataPacketExtension);
                        InBandBytestreamSession.this.connection.sendStanza(IQ.createResultIQ((IQ) stanza));
                    }
                }
            };
        }

        /* synthetic */ IQIBBInputStream(InBandBytestreamSession inBandBytestreamSession, AnonymousClass1 r22) {
            this();
        }
    }

    private class IQIBBOutputStream extends IBBOutputStream {
        private IQIBBOutputStream() {
            super(InBandBytestreamSession.this, (AnonymousClass1) null);
        }

        /* access modifiers changed from: protected */
        public synchronized void writeToXML(DataPacketExtension dataPacketExtension) throws IOException {
            Data data = new Data(dataPacketExtension);
            data.setTo(InBandBytestreamSession.this.remoteJID);
            try {
                InBandBytestreamSession.this.connection.createStanzaCollectorAndSend(data).nextResultOrThrow();
            } catch (Exception e10) {
                if (!this.isClosed) {
                    InBandBytestreamSession.this.close();
                    IOException iOException = new IOException();
                    iOException.initCause(e10);
                    throw iOException;
                }
            }
        }

        /* synthetic */ IQIBBOutputStream(InBandBytestreamSession inBandBytestreamSession, AnonymousClass1 r22) {
            this();
        }
    }

    private class MessageIBBInputStream extends IBBInputStream {
        private MessageIBBInputStream() {
            super();
        }

        /* access modifiers changed from: protected */
        public StanzaFilter getDataPacketFilter() {
            return new AndFilter(new StanzaTypeFilter(Message.class), new IBBDataPacketFilter(InBandBytestreamSession.this, (AnonymousClass1) null));
        }

        /* access modifiers changed from: protected */
        public StanzaListener getDataPacketListener() {
            return new StanzaListener() {
                public void processStanza(Stanza stanza) {
                    DataPacketExtension dataPacketExtension = (DataPacketExtension) stanza.getExtension(DataPacketExtension.class);
                    if (dataPacketExtension.getDecodedData() != null) {
                        MessageIBBInputStream.this.dataQueue.offer(dataPacketExtension);
                    }
                }
            };
        }

        /* synthetic */ MessageIBBInputStream(InBandBytestreamSession inBandBytestreamSession, AnonymousClass1 r22) {
            this();
        }
    }

    private class MessageIBBOutputStream extends IBBOutputStream {
        private MessageIBBOutputStream() {
            super(InBandBytestreamSession.this, (AnonymousClass1) null);
        }

        /* access modifiers changed from: protected */
        public synchronized void writeToXML(DataPacketExtension dataPacketExtension) throws SmackException.NotConnectedException, InterruptedException {
            InBandBytestreamSession.this.connection.sendStanza(((MessageBuilder) ((MessageBuilder) StanzaBuilder.buildMessage().to(InBandBytestreamSession.this.remoteJID)).addExtension(dataPacketExtension)).build());
        }

        /* synthetic */ MessageIBBOutputStream(InBandBytestreamSession inBandBytestreamSession, AnonymousClass1 r22) {
            this();
        }
    }

    protected InBandBytestreamSession(XMPPConnection xMPPConnection, Open open, Jid jid) {
        this.connection = xMPPConnection;
        this.byteStreamRequest = open;
        this.remoteJID = jid;
        int i10 = AnonymousClass1.$SwitchMap$org$jivesoftware$smackx$bytestreams$ibb$InBandBytestreamManager$StanzaType[open.getStanza().ordinal()];
        if (i10 == 1) {
            this.inputStream = new IQIBBInputStream(this, (AnonymousClass1) null);
            this.outputStream = new IQIBBOutputStream(this, (AnonymousClass1) null);
        } else if (i10 == 2) {
            this.inputStream = new MessageIBBInputStream(this, (AnonymousClass1) null);
            this.outputStream = new MessageIBBOutputStream(this, (AnonymousClass1) null);
        }
    }

    public void close() throws IOException {
        closeByLocal(true);
        closeByLocal(false);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0071, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void closeByLocal(boolean r3) throws java.io.IOException {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.isClosed     // Catch:{ all -> 0x0072 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            boolean r0 = r2.closeBothStreamsEnabled     // Catch:{ all -> 0x0072 }
            r1 = 1
            if (r0 == 0) goto L_0x0017
            org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamSession$IBBInputStream r3 = r2.inputStream     // Catch:{ all -> 0x0072 }
            r3.closeInternal()     // Catch:{ all -> 0x0072 }
            org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamSession$IBBOutputStream r3 = r2.outputStream     // Catch:{ all -> 0x0072 }
            r3.closeInternal(r1)     // Catch:{ all -> 0x0072 }
            goto L_0x0024
        L_0x0017:
            if (r3 == 0) goto L_0x001f
            org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamSession$IBBInputStream r3 = r2.inputStream     // Catch:{ all -> 0x0072 }
            r3.closeInternal()     // Catch:{ all -> 0x0072 }
            goto L_0x0024
        L_0x001f:
            org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamSession$IBBOutputStream r3 = r2.outputStream     // Catch:{ all -> 0x0072 }
            r3.closeInternal(r1)     // Catch:{ all -> 0x0072 }
        L_0x0024:
            org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamSession$IBBInputStream r3 = r2.inputStream     // Catch:{ all -> 0x0072 }
            boolean r3 = r3.isClosed     // Catch:{ all -> 0x0072 }
            if (r3 == 0) goto L_0x0070
            org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamSession$IBBOutputStream r3 = r2.outputStream     // Catch:{ all -> 0x0072 }
            boolean r3 = r3.isClosed     // Catch:{ all -> 0x0072 }
            if (r3 == 0) goto L_0x0070
            r2.isClosed = r1     // Catch:{ all -> 0x0072 }
            org.jivesoftware.smackx.bytestreams.ibb.packet.Close r3 = new org.jivesoftware.smackx.bytestreams.ibb.packet.Close     // Catch:{ all -> 0x0072 }
            org.jivesoftware.smackx.bytestreams.ibb.packet.Open r0 = r2.byteStreamRequest     // Catch:{ all -> 0x0072 }
            java.lang.String r0 = r0.getSessionID()     // Catch:{ all -> 0x0072 }
            r3.<init>(r0)     // Catch:{ all -> 0x0072 }
            org.jxmpp.jid.Jid r0 = r2.remoteJID     // Catch:{ all -> 0x0072 }
            r3.setTo(r0)     // Catch:{ all -> 0x0072 }
            org.jivesoftware.smack.XMPPConnection r0 = r2.connection     // Catch:{ Exception -> 0x0066 }
            org.jivesoftware.smack.StanzaCollector r3 = r0.createStanzaCollectorAndSend(r3)     // Catch:{ Exception -> 0x0066 }
            r3.nextResultOrThrow()     // Catch:{ Exception -> 0x0066 }
            org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamSession$IBBInputStream r3 = r2.inputStream     // Catch:{ all -> 0x0072 }
            r3.cleanup()     // Catch:{ all -> 0x0072 }
            org.jivesoftware.smack.XMPPConnection r3 = r2.connection     // Catch:{ all -> 0x0072 }
            org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamManager r3 = org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamManager.getByteStreamManager(r3)     // Catch:{ all -> 0x0072 }
            java.util.Map r3 = r3.getSessions()     // Catch:{ all -> 0x0072 }
            org.jivesoftware.smackx.bytestreams.ibb.packet.Open r0 = r2.byteStreamRequest     // Catch:{ all -> 0x0072 }
            java.lang.String r0 = r0.getSessionID()     // Catch:{ all -> 0x0072 }
            r3.remove(r0)     // Catch:{ all -> 0x0072 }
            goto L_0x0070
        L_0x0066:
            r3 = move-exception
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0072 }
            r0.<init>()     // Catch:{ all -> 0x0072 }
            r0.initCause(r3)     // Catch:{ all -> 0x0072 }
            throw r0     // Catch:{ all -> 0x0072 }
        L_0x0070:
            monitor-exit(r2)
            return
        L_0x0072:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamSession.closeByLocal(boolean):void");
    }

    /* access modifiers changed from: protected */
    public void closeByPeer(Close close) throws SmackException.NotConnectedException, InterruptedException {
        this.inputStream.closeInternal();
        this.inputStream.cleanup();
        this.outputStream.closeInternal(false);
        this.connection.sendStanza(IQ.createResultIQ(close));
    }

    public InputStream getInputStream() {
        return this.inputStream;
    }

    public OutputStream getOutputStream() {
        return this.outputStream;
    }

    public int getReadTimeout() {
        return this.inputStream.readTimeout;
    }

    public boolean isCloseBothStreamsEnabled() {
        return this.closeBothStreamsEnabled;
    }

    public void processIQPacket(Data data) throws SmackException.NotConnectedException, InterruptedException, SmackException.NotLoggedInException {
        this.inputStream.dataPacketListener.processStanza(data);
    }

    public void setCloseBothStreamsEnabled(boolean z10) {
        this.closeBothStreamsEnabled = z10;
    }

    public void setReadTimeout(int i10) {
        if (i10 >= 0) {
            int unused = this.inputStream.readTimeout = i10;
            return;
        }
        throw new IllegalArgumentException("Timeout must be >= 0");
    }

    private abstract class IBBInputStream extends InputStream {
        private byte[] buffer;
        private int bufferPointer = -1;
        private boolean closeInvoked = false;
        /* access modifiers changed from: private */
        public final StanzaListener dataPacketListener;
        protected final BlockingQueue<DataPacketExtension> dataQueue = new LinkedBlockingQueue();
        private UInt16 expectedSeq = UInt16.MIN_VALUE;
        /* access modifiers changed from: private */
        public boolean isClosed = false;
        /* access modifiers changed from: private */
        public int readTimeout = 0;

        protected IBBInputStream() {
            StanzaListener dataPacketListener2 = getDataPacketListener();
            this.dataPacketListener = dataPacketListener2;
            InBandBytestreamSession.this.connection.addSyncStanzaListener(dataPacketListener2, getDataPacketFilter());
        }

        private void checkClosed() throws IOException {
            if (this.closeInvoked) {
                this.dataQueue.clear();
                throw new IOException("Stream is closed");
            }
        }

        /* access modifiers changed from: private */
        public void cleanup() {
            InBandBytestreamSession.this.connection.removeSyncStanzaListener(this.dataPacketListener);
        }

        /* access modifiers changed from: private */
        public void closeInternal() {
            if (!this.isClosed) {
                this.isClosed = true;
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(4:31|32|33|34) */
        /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
            java.lang.Thread.currentThread().interrupt();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0084, code lost:
            return false;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x007c */
        /* JADX WARNING: Unknown top exception splitter block from list: {B:17:0x0031=Splitter:B:17:0x0031, B:31:0x007c=Splitter:B:31:0x007c} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private synchronized boolean loadBuffer() throws java.io.IOException {
            /*
                r5 = this;
                monitor-enter(r5)
                r0 = 0
                int r1 = r5.readTimeout     // Catch:{ InterruptedException -> 0x007c }
                if (r1 != 0) goto L_0x0024
                r1 = 0
            L_0x0007:
                if (r1 != 0) goto L_0x0031
                boolean r1 = r5.isClosed     // Catch:{ InterruptedException -> 0x007c }
                if (r1 == 0) goto L_0x0017
                java.util.concurrent.BlockingQueue<org.jivesoftware.smackx.bytestreams.ibb.packet.DataPacketExtension> r1 = r5.dataQueue     // Catch:{ InterruptedException -> 0x007c }
                boolean r1 = r1.isEmpty()     // Catch:{ InterruptedException -> 0x007c }
                if (r1 == 0) goto L_0x0017
                monitor-exit(r5)
                return r0
            L_0x0017:
                java.util.concurrent.BlockingQueue<org.jivesoftware.smackx.bytestreams.ibb.packet.DataPacketExtension> r1 = r5.dataQueue     // Catch:{ InterruptedException -> 0x007c }
                r2 = 1000(0x3e8, double:4.94E-321)
                java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ InterruptedException -> 0x007c }
                java.lang.Object r1 = r1.poll(r2, r4)     // Catch:{ InterruptedException -> 0x007c }
                org.jivesoftware.smackx.bytestreams.ibb.packet.DataPacketExtension r1 = (org.jivesoftware.smackx.bytestreams.ibb.packet.DataPacketExtension) r1     // Catch:{ InterruptedException -> 0x007c }
                goto L_0x0007
            L_0x0024:
                java.util.concurrent.BlockingQueue<org.jivesoftware.smackx.bytestreams.ibb.packet.DataPacketExtension> r2 = r5.dataQueue     // Catch:{ InterruptedException -> 0x007c }
                long r3 = (long) r1     // Catch:{ InterruptedException -> 0x007c }
                java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ InterruptedException -> 0x007c }
                java.lang.Object r1 = r2.poll(r3, r1)     // Catch:{ InterruptedException -> 0x007c }
                org.jivesoftware.smackx.bytestreams.ibb.packet.DataPacketExtension r1 = (org.jivesoftware.smackx.bytestreams.ibb.packet.DataPacketExtension) r1     // Catch:{ InterruptedException -> 0x007c }
                if (r1 == 0) goto L_0x0074
            L_0x0031:
                org.jivesoftware.smack.datatypes.UInt16 r2 = r1.getSeq()     // Catch:{ all -> 0x007a }
                org.jivesoftware.smack.datatypes.UInt16 r3 = r5.expectedSeq     // Catch:{ all -> 0x007a }
                boolean r3 = r3.equals(r2)     // Catch:{ all -> 0x007a }
                if (r3 == 0) goto L_0x004e
                org.jivesoftware.smack.datatypes.UInt16 r2 = r2.incrementedByOne()     // Catch:{ all -> 0x007a }
                r5.expectedSeq = r2     // Catch:{ all -> 0x007a }
                byte[] r1 = r1.getDecodedData()     // Catch:{ all -> 0x007a }
                r5.buffer = r1     // Catch:{ all -> 0x007a }
                r5.bufferPointer = r0     // Catch:{ all -> 0x007a }
                r0 = 1
                monitor-exit(r5)
                return r0
            L_0x004e:
                org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamSession r0 = org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamSession.this     // Catch:{ all -> 0x007a }
                r0.close()     // Catch:{ all -> 0x007a }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x007a }
                r0.<init>()     // Catch:{ all -> 0x007a }
                java.lang.String r1 = "Unexpected IBB sequence "
                r0.append(r1)     // Catch:{ all -> 0x007a }
                r0.append(r2)     // Catch:{ all -> 0x007a }
                java.lang.String r1 = " received, expected "
                r0.append(r1)     // Catch:{ all -> 0x007a }
                org.jivesoftware.smack.datatypes.UInt16 r1 = r5.expectedSeq     // Catch:{ all -> 0x007a }
                r0.append(r1)     // Catch:{ all -> 0x007a }
                java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x007a }
                java.io.IOException r1 = new java.io.IOException     // Catch:{ all -> 0x007a }
                r1.<init>(r0)     // Catch:{ all -> 0x007a }
                throw r1     // Catch:{ all -> 0x007a }
            L_0x0074:
                java.net.SocketTimeoutException r1 = new java.net.SocketTimeoutException     // Catch:{ InterruptedException -> 0x007c }
                r1.<init>()     // Catch:{ InterruptedException -> 0x007c }
                throw r1     // Catch:{ InterruptedException -> 0x007c }
            L_0x007a:
                r0 = move-exception
                goto L_0x0085
            L_0x007c:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x007a }
                r1.interrupt()     // Catch:{ all -> 0x007a }
                monitor-exit(r5)
                return r0
            L_0x0085:
                monitor-exit(r5)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamSession.IBBInputStream.loadBuffer():boolean");
        }

        public void close() throws IOException {
            if (!this.closeInvoked) {
                this.closeInvoked = true;
                InBandBytestreamSession.this.closeByLocal(true);
            }
        }

        /* access modifiers changed from: protected */
        public abstract StanzaFilter getDataPacketFilter();

        /* access modifiers changed from: protected */
        public abstract StanzaListener getDataPacketListener();

        public boolean markSupported() {
            return false;
        }

        public synchronized int read() throws IOException {
            checkClosed();
            int i10 = this.bufferPointer;
            if ((i10 == -1 || i10 >= this.buffer.length) && !loadBuffer()) {
                return -1;
            }
            byte[] bArr = this.buffer;
            int i11 = this.bufferPointer;
            this.bufferPointer = i11 + 1;
            return bArr[i11] & 255;
        }

        /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x002b=Splitter:B:23:0x002b, B:30:0x003e=Splitter:B:30:0x003e} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized int read(byte[] r4, int r5, int r6) throws java.io.IOException {
            /*
                r3 = this;
                monitor-enter(r3)
                if (r4 == 0) goto L_0x0044
                if (r5 < 0) goto L_0x003e
                int r0 = r4.length     // Catch:{ all -> 0x004a }
                if (r5 > r0) goto L_0x003e
                if (r6 < 0) goto L_0x003e
                int r0 = r5 + r6
                int r1 = r4.length     // Catch:{ all -> 0x004a }
                if (r0 > r1) goto L_0x003e
                if (r0 < 0) goto L_0x003e
                if (r6 != 0) goto L_0x0016
                r4 = 0
                monitor-exit(r3)
                return r4
            L_0x0016:
                r3.checkClosed()     // Catch:{ all -> 0x004a }
                int r0 = r3.bufferPointer     // Catch:{ all -> 0x004a }
                r1 = -1
                if (r0 == r1) goto L_0x0023
                byte[] r2 = r3.buffer     // Catch:{ all -> 0x004a }
                int r2 = r2.length     // Catch:{ all -> 0x004a }
                if (r0 < r2) goto L_0x002b
            L_0x0023:
                boolean r0 = r3.loadBuffer()     // Catch:{ all -> 0x004a }
                if (r0 != 0) goto L_0x002b
                monitor-exit(r3)
                return r1
            L_0x002b:
                byte[] r0 = r3.buffer     // Catch:{ all -> 0x004a }
                int r1 = r0.length     // Catch:{ all -> 0x004a }
                int r2 = r3.bufferPointer     // Catch:{ all -> 0x004a }
                int r1 = r1 - r2
                if (r6 <= r1) goto L_0x0034
                r6 = r1
            L_0x0034:
                java.lang.System.arraycopy(r0, r2, r4, r5, r6)     // Catch:{ all -> 0x004a }
                int r4 = r3.bufferPointer     // Catch:{ all -> 0x004a }
                int r4 = r4 + r6
                r3.bufferPointer = r4     // Catch:{ all -> 0x004a }
                monitor-exit(r3)
                return r6
            L_0x003e:
                java.lang.IndexOutOfBoundsException r4 = new java.lang.IndexOutOfBoundsException     // Catch:{ all -> 0x004a }
                r4.<init>()     // Catch:{ all -> 0x004a }
                throw r4     // Catch:{ all -> 0x004a }
            L_0x0044:
                java.lang.NullPointerException r4 = new java.lang.NullPointerException     // Catch:{ all -> 0x004a }
                r4.<init>()     // Catch:{ all -> 0x004a }
                throw r4     // Catch:{ all -> 0x004a }
            L_0x004a:
                r4 = move-exception
                monitor-exit(r3)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamSession.IBBInputStream.read(byte[], int, int):int");
        }

        public synchronized int read(byte[] bArr) throws IOException {
            return read(bArr, 0, bArr.length);
        }
    }
}
