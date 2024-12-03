package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;

public interface l0 extends m0 {

    public interface a extends m0, Cloneable {
        l0 build();

        l0 buildPartial();

        a e0(l0 l0Var);
    }

    void a(CodedOutputStream codedOutputStream) throws IOException;

    t0<? extends l0> getParserForType();

    int getSerializedSize();

    a newBuilderForType();

    a toBuilder();

    byte[] toByteArray();

    ByteString toByteString();
}
