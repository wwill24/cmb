package com.google.firebase.database.tubesock;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import net.bytebuddy.jar.asm.Opcodes;

class WebSocketWriter {
    private WritableByteChannel channel;
    private boolean closeSent = false;
    private final Thread innerThread = WebSocket.getThreadFactory().newThread(new Runnable() {
        public void run() {
            WebSocketWriter.this.runWriter();
        }
    });
    private BlockingQueue<ByteBuffer> pendingBuffers;
    private final Random random = new Random();
    private volatile boolean stop = false;
    private WebSocket websocket;

    WebSocketWriter(WebSocket webSocket, String str, int i10) {
        ThreadInitializer intializer = WebSocket.getIntializer();
        Thread innerThread2 = getInnerThread();
        intializer.setName(innerThread2, str + "Writer-" + i10);
        this.websocket = webSocket;
        this.pendingBuffers = new LinkedBlockingQueue();
    }

    private ByteBuffer frameInBuffer(byte b10, boolean z10, byte[] bArr) throws IOException {
        int i10;
        if (z10) {
            i10 = 6;
        } else {
            i10 = 2;
        }
        int length = bArr.length;
        int i11 = 126;
        if (length >= 126) {
            if (length <= 65535) {
                i10 += 2;
            } else {
                i10 += 8;
            }
        }
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length + i10);
        allocate.put((byte) (b10 | Byte.MIN_VALUE));
        if (length < 126) {
            if (z10) {
                length |= 128;
            }
            allocate.put((byte) length);
        } else if (length <= 65535) {
            if (z10) {
                i11 = 254;
            }
            allocate.put((byte) i11);
            allocate.putShort((short) length);
        } else {
            int i12 = Opcodes.LAND;
            if (z10) {
                i12 = 255;
            }
            allocate.put((byte) i12);
            allocate.putInt(0);
            allocate.putInt(length);
        }
        if (z10) {
            byte[] generateMask = generateMask();
            allocate.put(generateMask);
            for (int i13 = 0; i13 < bArr.length; i13++) {
                allocate.put((byte) (bArr[i13] ^ generateMask[i13 % 4]));
            }
        }
        allocate.flip();
        return allocate;
    }

    private byte[] generateMask() {
        byte[] bArr = new byte[4];
        this.random.nextBytes(bArr);
        return bArr;
    }

    private void handleError(WebSocketException webSocketException) {
        this.websocket.handleReceiverError(webSocketException);
    }

    /* access modifiers changed from: private */
    public void runWriter() {
        while (!this.stop && !Thread.interrupted()) {
            try {
                writeMessage();
            } catch (IOException e10) {
                handleError(new WebSocketException("IO Exception", e10));
                return;
            } catch (InterruptedException unused) {
                return;
            }
        }
        for (int i10 = 0; i10 < this.pendingBuffers.size(); i10++) {
            writeMessage();
        }
    }

    private void writeMessage() throws InterruptedException, IOException {
        this.channel.write(this.pendingBuffers.take());
    }

    /* access modifiers changed from: package-private */
    public Thread getInnerThread() {
        return this.innerThread;
    }

    /* access modifiers changed from: package-private */
    public synchronized void send(byte b10, boolean z10, byte[] bArr) throws IOException {
        ByteBuffer frameInBuffer = frameInBuffer(b10, z10, bArr);
        if (this.stop) {
            if (this.closeSent || b10 != 8) {
                throw new WebSocketException("Shouldn't be sending");
            }
        }
        if (b10 == 8) {
            this.closeSent = true;
        }
        this.pendingBuffers.add(frameInBuffer);
    }

    /* access modifiers changed from: package-private */
    public void setOutput(OutputStream outputStream) {
        this.channel = Channels.newChannel(outputStream);
    }

    /* access modifiers changed from: package-private */
    public void stopIt() {
        this.stop = true;
    }
}
