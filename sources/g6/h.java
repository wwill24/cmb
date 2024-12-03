package g6;

import com.coffeemeetsbagel.models.enums.MessageStatus;
import kotlin.jvm.internal.j;

public final class h {
    public final String a(MessageStatus messageStatus) {
        j.g(messageStatus, "messageStatus");
        String messageStatusName = messageStatus.getMessageStatusName();
        j.f(messageStatusName, "messageStatus.messageStatusName");
        return messageStatusName;
    }

    public final MessageStatus b(String str) {
        j.g(str, "messageStatusString");
        MessageStatus messageStatus = MessageStatus.getMessageStatus(str);
        j.f(messageStatus, "getMessageStatus(messageStatusString)");
        return messageStatus;
    }
}
