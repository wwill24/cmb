package com.google.protobuf;

import java.io.IOException;

public interface l0 extends m0 {

    public interface a extends m0, Cloneable {
        l0 build();

        l0 buildPartial();

        a mergeFrom(h hVar, n nVar) throws IOException;

        a mergeFrom(l0 l0Var);
    }

    t0<? extends l0> getParserForType();

    int getSerializedSize();

    a newBuilderForType();

    a toBuilder();

    ByteString toByteString();

    void writeTo(CodedOutputStream codedOutputStream) throws IOException;
}
