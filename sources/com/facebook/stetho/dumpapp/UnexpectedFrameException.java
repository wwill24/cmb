package com.facebook.stetho.dumpapp;

class UnexpectedFrameException extends DumpappFramingException {
    public UnexpectedFrameException(byte b10, byte b11) {
        super("Expected '" + b10 + "', got: '" + b11 + "'");
    }
}
