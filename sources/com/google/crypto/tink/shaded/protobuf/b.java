package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.l0;

public abstract class b<MessageType extends l0> implements t0<MessageType> {

    /* renamed from: a  reason: collision with root package name */
    private static final o f20742a = o.b();

    private MessageType c(MessageType messagetype) throws InvalidProtocolBufferException {
        if (messagetype == null || messagetype.isInitialized()) {
            return messagetype;
        }
        throw d(messagetype).a().i(messagetype);
    }

    private UninitializedMessageException d(MessageType messagetype) {
        if (messagetype instanceof a) {
            return ((a) messagetype).e();
        }
        return new UninitializedMessageException(messagetype);
    }

    /* renamed from: e */
    public MessageType b(ByteString byteString, o oVar) throws InvalidProtocolBufferException {
        return c(f(byteString, oVar));
    }

    public MessageType f(ByteString byteString, o oVar) throws InvalidProtocolBufferException {
        MessageType messagetype;
        try {
            i s10 = byteString.s();
            messagetype = (l0) a(s10, oVar);
            s10.a(0);
            return messagetype;
        } catch (InvalidProtocolBufferException e10) {
            throw e10.i(messagetype);
        } catch (InvalidProtocolBufferException e11) {
            throw e11;
        }
    }
}
