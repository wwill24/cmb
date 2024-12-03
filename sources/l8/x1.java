package l8;

import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.models.SavedMessage;
import java.util.List;
import lc.t;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.chat_markers.element.ChatMarkersElements;

public class x1 {
    public static SavedMessage c(Message message) {
        String str;
        String j10 = t.j(message.getTo());
        String j11 = t.j(message.getFrom());
        boolean equals = Bakery.w().G().j().getId().equals(j10);
        if (equals) {
            str = j11;
        } else {
            str = j10;
        }
        return new SavedMessage(str, message.getBody(), t.k(message), message.getStanzaId(), t.c(message), t.l(message), d(message), equals);
    }

    private static String d(Message message) {
        String str = ChatMarkersElements.DisplayedExtension.ELEMENT;
        if (message.hasExtension(str, ChatMarkersElements.NAMESPACE)) {
            return ((ChatMarkersElements.DisplayedExtension) message.getExtension(str, ChatMarkersElements.NAMESPACE)).getId();
        }
        return null;
    }

    public static qj.t<List<Message>, List<SavedMessage>> g() {
        return new s1();
    }
}
