package ag;

import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.l0;
import java.security.GeneralSecurityException;

public interface d<P> {
    boolean a(String str);

    KeyData b(ByteString byteString) throws GeneralSecurityException;

    P c(ByteString byteString) throws GeneralSecurityException;

    l0 d(ByteString byteString) throws GeneralSecurityException;
}
