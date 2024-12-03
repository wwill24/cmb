package g6;

import com.coffeemeetsbagel.models.enums.MessageType;
import kotlin.jvm.internal.j;

public final class i {
    public final String a(MessageType messageType) {
        j.g(messageType, "messageType");
        String typeName = messageType.getTypeName();
        j.f(typeName, "messageType.typeName");
        return typeName;
    }

    public final MessageType b(String str) {
        j.g(str, "messageTypeString");
        MessageType messageType = MessageType.getMessageType(str);
        j.f(messageType, "getMessageType(messageTypeString)");
        return messageType;
    }
}
