package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.k0;

public abstract class b<MessageType extends k0> implements s0<MessageType> {

    /* renamed from: a  reason: collision with root package name */
    private static final n f5197a = n.b();

    private MessageType c(MessageType messagetype) throws InvalidProtocolBufferException {
        if (messagetype == null || messagetype.isInitialized()) {
            return messagetype;
        }
        throw d(messagetype).a().i(messagetype);
    }

    private UninitializedMessageException d(MessageType messagetype) {
        if (messagetype instanceof a) {
            return ((a) messagetype).f();
        }
        return new UninitializedMessageException(messagetype);
    }

    /* renamed from: e */
    public MessageType a(ByteString byteString, n nVar) throws InvalidProtocolBufferException {
        return c(f(byteString, nVar));
    }

    public MessageType f(ByteString byteString, n nVar) throws InvalidProtocolBufferException {
        MessageType messagetype;
        try {
            h s10 = byteString.s();
            messagetype = (k0) b(s10, nVar);
            s10.a(0);
            return messagetype;
        } catch (InvalidProtocolBufferException e10) {
            throw e10.i(messagetype);
        } catch (InvalidProtocolBufferException e11) {
            throw e11;
        }
    }
}
