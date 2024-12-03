package lc;

import android.text.TextUtils;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.models.RosterElement;
import com.coffeemeetsbagel.models.SavedMessage;
import com.coffeemeetsbagel.models.enums.MessageType;
import com.coffeemeetsbagel.models.util.DateUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;
import o8.a;
import o8.b;
import o8.c;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.StandardExtensionElement;
import org.jivesoftware.smack.roster.RosterEntry;
import org.jivesoftware.smack.roster.RosterGroup;
import org.jivesoftware.smackx.chat_markers.element.ChatMarkersElements;
import org.jivesoftware.smackx.chatstates.ChatState;
import org.jivesoftware.smackx.chatstates.packet.ChatStateExtension;
import org.jxmpp.jid.BareJid;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.Jid;

public class t {
    public static RosterElement a(RosterEntry rosterEntry) {
        String f10 = f(rosterEntry);
        if (TextUtils.isEmpty(f10)) {
            return null;
        }
        BareJid jid = rosterEntry.getJid();
        return new RosterElement(j(jid), jid.toString(), f10);
    }

    private static String b() {
        String uuid = UUID.randomUUID().toString();
        Bakery.w().M().a().edit().putString("mongoose_manager_device_uuid", uuid).apply();
        return uuid;
    }

    public static String c(Message message) {
        StandardExtensionElement standardExtensionElement = (StandardExtensionElement) message.getExtension("category", "jabber:client");
        if (standardExtensionElement == null || TextUtils.isEmpty(standardExtensionElement.getText())) {
            return null;
        }
        return standardExtensionElement.getText();
    }

    public static String d(Message message) {
        a aVar;
        Iterator<ExtensionElement> it = message.getExtensions().iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = null;
                break;
            }
            ExtensionElement next = it.next();
            if (next.getElementName().equals("category")) {
                aVar = (a) next;
                break;
            }
        }
        if (aVar == null || TextUtils.isEmpty(aVar.b())) {
            return null;
        }
        return aVar.b();
    }

    public static String e() {
        return DateUtils.getFormattedUtcDate(new Date(), DateUtils.DATE_WITH_TIME_PATTERN_ISO_8601_Z_MS);
    }

    public static String f(RosterEntry rosterEntry) {
        String str = null;
        if (rosterEntry == null) {
            return null;
        }
        if (rosterEntry.getGroups().size() > 1) {
            for (RosterGroup next : rosterEntry.getGroups()) {
                String name = next.getName();
                if (next.getName().equals(com.coffeemeetsbagel.feature.mongoose.enums.RosterGroup.INACTIVE.a()) || next.getName().equals(com.coffeemeetsbagel.feature.mongoose.enums.RosterGroup.BLOCKED.a())) {
                    return name;
                }
                str = name;
            }
            return str;
        } else if (rosterEntry.getGroups().size() <= 0) {
            return null;
        } else {
            return rosterEntry.getGroups().get(0).getName();
        }
    }

    public static EntityBareJid g(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return org.jxmpp.jid.impl.a.h(str + "@" + i());
            } catch (Exception e10) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed to create jid ");
                sb2.append(e10.toString());
            }
        }
        return null;
    }

    public static ArrayList<ExtensionElement> h(Message message, MessageType messageType, String str, boolean z10) {
        ArrayList<ExtensionElement> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new c(str));
        }
        if (z10) {
            arrayList.add(ChatMarkersElements.MarkableExtension.from(message));
        }
        a aVar = new a(messageType.getTypeName());
        ChatStateExtension chatStateExtension = new ChatStateExtension(ChatState.active);
        arrayList.add(aVar);
        arrayList.add(chatStateExtension);
        return arrayList;
    }

    public static String i() {
        return x4.a.f18541e;
    }

    public static String j(Jid jid) {
        if (jid != null) {
            return jid.toString().split("\\@")[0];
        }
        return null;
    }

    public static String k(Message message) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getTimeStampFromMessage(): ");
        sb2.append(message.toXML());
        String str = null;
        for (ExtensionElement next : message.getExtensions()) {
            if (next.getElementName().equals("timestamp")) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("\tTimeStamp: ");
                sb3.append(next.getClass());
                if (next instanceof b) {
                    str = ((b) next).b();
                } else if (next instanceof StandardExtensionElement) {
                    str = ((StandardExtensionElement) next).getText();
                }
                if (!TextUtils.isEmpty(str)) {
                    break;
                }
            }
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append("\tTimeStamp: ");
        sb4.append(str);
        return str;
    }

    public static String l(Message message) {
        StandardExtensionElement standardExtensionElement = (StandardExtensionElement) message.getExtension("x", "jabber:x:oob");
        if (standardExtensionElement != null && !TextUtils.isEmpty(standardExtensionElement.getText())) {
            return standardExtensionElement.getText();
        }
        if (standardExtensionElement != null) {
            standardExtensionElement.getElements("x", "jabber:x:oob");
            for (StandardExtensionElement next : standardExtensionElement.getElements()) {
                if (next.getElementName().equals("url") && next.getNamespace().equals("jabber:x:oob")) {
                    return next.getText();
                }
            }
        }
        return null;
    }

    public static String m(Message message) {
        c cVar = (c) message.getExtension("x", "jabber:x:oob");
        if (cVar == null || TextUtils.isEmpty(cVar.b())) {
            return null;
        }
        return cVar.b();
    }

    public static String n() {
        String r10 = Bakery.w().M().r("mongoose_manager_device_uuid");
        if (TextUtils.isEmpty(r10)) {
            return b();
        }
        return r10;
    }

    private static boolean o(String str) {
        if (MessageType.UNRECOGNIZED != MessageType.getMessageType(str)) {
            return true;
        }
        Iterator<String> it = Bakery.w().J().a().iterator();
        while (it.hasNext()) {
            if (it.next().equals(str)) {
                return true;
            }
        }
        return false;
    }

    private static boolean p(Message message) {
        StandardExtensionElement standardExtensionElement = (StandardExtensionElement) message.getExtension("category", "jabber:client");
        if (standardExtensionElement == null || TextUtils.isEmpty(standardExtensionElement.getText())) {
            return false;
        }
        return o(standardExtensionElement.getText());
    }

    public static boolean q(SavedMessage savedMessage) {
        return o(savedMessage.getCategory());
    }

    public static boolean r(Message message) {
        if (message.getBody() == null && !message.hasExtension(ChatMarkersElements.DisplayedExtension.ELEMENT, ChatMarkersElements.NAMESPACE)) {
            return p(message);
        }
        return true;
    }
}
