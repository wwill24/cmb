package com.facebook.stetho.websocket;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicBoolean;

class WebSocketSession implements SimpleSession {
    /* access modifiers changed from: private */
    public final SimpleEndpoint mEndpoint;
    private final WriteCallback mErrorForwardingWriteCallback = new WriteCallback() {
        public void onFailure(IOException iOException) {
            WebSocketSession.this.signalError(iOException);
        }

        public void onSuccess() {
        }
    };
    private AtomicBoolean mIsOpen = new AtomicBoolean(false);
    private final ReadCallback mReadCallback = new ReadCallback() {
        private void handleBinaryFrame(byte[] bArr, int i10) {
            WebSocketSession.this.mEndpoint.onMessage(WebSocketSession.this, bArr, i10);
        }

        private void handleClose(byte[] bArr, int i10) {
            String str;
            byte b10;
            if (i10 >= 2) {
                b10 = ((bArr[0] & 255) << 8) | (bArr[1] & 255);
                if (i10 > 2) {
                    str = new String(bArr, 2, i10 - 2);
                } else {
                    str = null;
                }
            } else {
                b10 = 1006;
                str = "Unparseable close frame";
            }
            if (!WebSocketSession.this.mSentClose) {
                WebSocketSession.this.sendClose(1000, "Received close frame");
            }
            WebSocketSession.this.markAndSignalClosed(b10, str);
        }

        private void handlePing(byte[] bArr, int i10) {
            WebSocketSession.this.doWrite(FrameHelper.createPongFrame(bArr, i10));
        }

        private void handlePong(byte[] bArr, int i10) {
        }

        private void handleTextFrame(byte[] bArr, int i10) {
            WebSocketSession.this.mEndpoint.onMessage(WebSocketSession.this, new String(bArr, 0, i10));
        }

        public void onCompleteFrame(byte b10, byte[] bArr, int i10) {
            if (b10 == 1) {
                handleTextFrame(bArr, i10);
            } else if (b10 != 2) {
                switch (b10) {
                    case 8:
                        handleClose(bArr, i10);
                        return;
                    case 9:
                        handlePing(bArr, i10);
                        return;
                    case 10:
                        handlePong(bArr, i10);
                        return;
                    default:
                        WebSocketSession webSocketSession = WebSocketSession.this;
                        webSocketSession.signalError(new IOException("Unsupported frame opcode=" + b10));
                        return;
                }
            } else {
                handleBinaryFrame(bArr, i10);
            }
        }
    };
    private final ReadHandler mReadHandler;
    /* access modifiers changed from: private */
    public volatile boolean mSentClose;
    private final WriteHandler mWriteHandler;

    public WebSocketSession(InputStream inputStream, OutputStream outputStream, SimpleEndpoint simpleEndpoint) {
        this.mReadHandler = new ReadHandler(inputStream, simpleEndpoint);
        this.mWriteHandler = new WriteHandler(outputStream);
        this.mEndpoint = simpleEndpoint;
    }

    /* access modifiers changed from: private */
    public void doWrite(Frame frame) {
        if (!signalErrorIfNotOpen()) {
            this.mWriteHandler.write(frame, this.mErrorForwardingWriteCallback);
        }
    }

    /* access modifiers changed from: private */
    public void sendClose(int i10, String str) {
        doWrite(FrameHelper.createCloseFrame(i10, str));
        markSentClose();
    }

    /* access modifiers changed from: private */
    public void signalError(IOException iOException) {
        this.mEndpoint.onError(this, iOException);
    }

    private boolean signalErrorIfNotOpen() {
        if (isOpen()) {
            return false;
        }
        signalError(new IOException("Session is closed"));
        return true;
    }

    public void close(int i10, String str) {
        sendClose(i10, str);
        markAndSignalClosed(i10, str);
    }

    public void handle() throws IOException {
        markAndSignalOpen();
        try {
            this.mReadHandler.readLoop(this.mReadCallback);
        } catch (EOFException unused) {
            markAndSignalClosed(CloseCodes.UNEXPECTED_CONDITION, "EOF while reading");
        } catch (IOException e10) {
            markAndSignalClosed(CloseCodes.CLOSED_ABNORMALLY, (String) null);
            throw e10;
        }
    }

    public boolean isOpen() {
        return this.mIsOpen.get();
    }

    /* access modifiers changed from: package-private */
    public void markAndSignalClosed(int i10, String str) {
        if (this.mIsOpen.getAndSet(false)) {
            this.mEndpoint.onClose(this, i10, str);
        }
    }

    /* access modifiers changed from: package-private */
    public void markAndSignalOpen() {
        if (!this.mIsOpen.getAndSet(true)) {
            this.mEndpoint.onOpen(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void markSentClose() {
        this.mSentClose = true;
    }

    public void sendBinary(byte[] bArr) {
        doWrite(FrameHelper.createBinaryFrame(bArr));
    }

    public void sendText(String str) {
        doWrite(FrameHelper.createTextFrame(str));
    }
}
