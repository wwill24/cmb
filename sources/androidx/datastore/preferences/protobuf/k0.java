package androidx.datastore.preferences.protobuf;

import java.io.IOException;

public interface k0 extends l0 {

    public interface a extends l0, Cloneable {
        k0 build();

        k0 buildPartial();

        a n(k0 k0Var);
    }

    void a(CodedOutputStream codedOutputStream) throws IOException;

    s0<? extends k0> getParserForType();

    int getSerializedSize();

    a newBuilderForType();

    a toBuilder();

    ByteString toByteString();
}
