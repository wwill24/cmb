package ed;

import com.google.firebase.encoders.annotations.Encodable;
import com.google.firebase.encoders.proto.ProtobufEncoder;
import hd.a;

@Encodable
public abstract class m {

    /* renamed from: a  reason: collision with root package name */
    private static final ProtobufEncoder f40748a = ProtobufEncoder.builder().configureWith(a.f40681a).build();

    private m() {
    }

    public static byte[] a(Object obj) {
        return f40748a.encode(obj);
    }

    public abstract a b();
}
