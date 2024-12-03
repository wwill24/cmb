package com.google.firebase.database.tubesock;

import com.google.firebase.database.tubesock.MessageBuilderFactory;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.SocketTimeoutException;

class WebSocketReceiver {
    private WebSocketEventHandler eventHandler = null;
    private DataInputStream input = null;
    private byte[] inputHeader = new byte[112];
    private MessageBuilderFactory.Builder pendingBuilder;
    private volatile boolean stop = false;
    private WebSocket websocket = null;

    WebSocketReceiver(WebSocket webSocket) {
        this.websocket = webSocket;
    }

    private void appendBytes(boolean z10, byte b10, byte[] bArr) {
        if (b10 != 9) {
            MessageBuilderFactory.Builder builder = this.pendingBuilder;
            if (builder != null && b10 != 0) {
                throw new WebSocketException("Failed to continue outstanding frame");
            } else if (builder == null && b10 == 0) {
                throw new WebSocketException("Received continuing frame, but there's nothing to continue");
            } else {
                if (builder == null) {
                    this.pendingBuilder = MessageBuilderFactory.builder(b10);
                }
                if (!this.pendingBuilder.appendBytes(bArr)) {
                    throw new WebSocketException("Failed to decode frame");
                } else if (z10) {
                    WebSocketMessage message = this.pendingBuilder.toMessage();
                    this.pendingBuilder = null;
                    if (message != null) {
                        this.eventHandler.onMessage(message);
                        return;
                    }
                    throw new WebSocketException("Failed to decode whole message");
                }
            }
        } else if (z10) {
            handlePing(bArr);
        } else {
            throw new WebSocketException("PING must not fragment across frames");
        }
    }

    private void handleError(WebSocketException webSocketException) {
        stopit();
        this.websocket.handleReceiverError(webSocketException);
    }

    private void handlePing(byte[] bArr) {
        if (bArr.length <= 125) {
            this.websocket.pong(bArr);
            return;
        }
        throw new WebSocketException("PING frame too long");
    }

    private long parseLong(byte[] bArr, int i10) {
        return (((long) bArr[i10 + 0]) << 56) + (((long) (bArr[i10 + 1] & 255)) << 48) + (((long) (bArr[i10 + 2] & 255)) << 40) + (((long) (bArr[i10 + 3] & 255)) << 32) + (((long) (bArr[i10 + 4] & 255)) << 24) + ((long) ((bArr[i10 + 5] & 255) << Tnaf.POW_2_WIDTH)) + ((long) ((bArr[i10 + 6] & 255) << 8)) + ((long) ((bArr[i10 + 7] & 255) << 0));
    }

    private int read(byte[] bArr, int i10, int i11) throws IOException {
        this.input.readFully(bArr, i10, i11);
        return i11;
    }

    /* access modifiers changed from: package-private */
    public boolean isRunning() {
        return !this.stop;
    }

    /* access modifiers changed from: package-private */
    public void run() {
        boolean z10;
        boolean z11;
        this.eventHandler = this.websocket.getEventHandler();
        while (!this.stop) {
            try {
                int read = read(this.inputHeader, 0, 1) + 0;
                byte[] bArr = this.inputHeader;
                byte b10 = bArr[0];
                if ((b10 & 128) != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if ((b10 & 112) != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!z11) {
                    byte b11 = (byte) (b10 & 15);
                    int read2 = read + read(bArr, read, 1);
                    byte[] bArr2 = this.inputHeader;
                    byte b12 = bArr2[1];
                    long j10 = 0;
                    if (b12 < 126) {
                        j10 = (long) b12;
                    } else if (b12 == 126) {
                        read(bArr2, read2, 2);
                        byte[] bArr3 = this.inputHeader;
                        j10 = (((long) (bArr3[2] & 255)) << 8) | ((long) (bArr3[3] & 255));
                    } else if (b12 == Byte.MAX_VALUE) {
                        j10 = parseLong(this.inputHeader, (read2 + read(bArr2, read2, 8)) - 8);
                    }
                    int i10 = (int) j10;
                    byte[] bArr4 = new byte[i10];
                    read(bArr4, 0, i10);
                    if (b11 == 8) {
                        this.websocket.onCloseOpReceived();
                    } else if (b11 != 10) {
                        if (!(b11 == 1 || b11 == 2 || b11 == 9)) {
                            if (b11 != 0) {
                                throw new WebSocketException("Unsupported opcode: " + b11);
                            }
                        }
                        appendBytes(z10, b11, bArr4);
                    }
                } else {
                    throw new WebSocketException("Invalid frame received");
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException e10) {
                handleError(new WebSocketException("IO Error", e10));
            } catch (WebSocketException e11) {
                handleError(e11);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setInput(DataInputStream dataInputStream) {
        this.input = dataInputStream;
    }

    /* access modifiers changed from: package-private */
    public void stopit() {
        this.stop = true;
    }
}
