package com.facebook.stetho.websocket;

public interface SimpleSession {
    void close(int i10, String str);

    boolean isOpen();

    void sendBinary(byte[] bArr);

    void sendText(String str);
}
