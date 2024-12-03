package com.google.protobuf;

import com.google.protobuf.l0;

public abstract class b<MessageType extends l0> implements t0<MessageType> {

    /* renamed from: a  reason: collision with root package name */
    private static final n f21742a = n.b();

    private MessageType c(MessageType messagetype) throws InvalidProtocolBufferException {
        if (messagetype == null || messagetype.isInitialized()) {
            return messagetype;
        }
        throw d(messagetype).a().k(messagetype);
    }

    private UninitializedMessageException d(MessageType messagetype) {
        if (messagetype instanceof a) {
            return ((a) messagetype).newUninitializedMessageException();
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
            h D = byteString.D();
            messagetype = (l0) b(D, nVar);
            D.a(0);
            return messagetype;
        } catch (InvalidProtocolBufferException e10) {
            throw e10.k(messagetype);
        } catch (InvalidProtocolBufferException e11) {
            throw e11;
        }
    }
}
