package org.jivesoftware.smackx.pubsub;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Locale;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.jivesoftware.smackx.message_retraction.element.RetractElement;
import org.jivesoftware.smackx.pubsub.packet.PubSubNamespace;

public enum PubSubElementType {
    CREATE("create", r1),
    DELETE("delete", r4),
    DELETE_EVENT("delete", r8),
    CONFIGURE("configure", r1),
    CONFIGURE_OWNER("configure", r4),
    CONFIGURATION("configuration", r8),
    OPTIONS(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, r1),
    DEFAULT("default", r4),
    ITEMS(FirebaseAnalytics.Param.ITEMS, r1),
    ITEMS_EVENT(FirebaseAnalytics.Param.ITEMS, r8),
    ITEM("item", r1),
    ITEM_EVENT("item", r8),
    PUBLISH("publish", r1),
    PUBLISH_OPTIONS("publish-options", r1),
    PURGE_OWNER("purge", r4),
    PURGE_EVENT("purge", r8),
    RETRACT(RetractElement.ELEMENT, r1),
    AFFILIATIONS("affiliations", r1),
    AFFILIATIONS_OWNER("affiliations", r4),
    SUBSCRIBE("subscribe", r1),
    SUBSCRIPTION("subscription", r1),
    SUBSCRIPTIONS("subscriptions", r1),
    SUBSCRIPTIONS_OWNER("subscriptions", r4),
    UNSUBSCRIBE("unsubscribe", r1);
    
    private final String eName;
    private final PubSubNamespace nSpace;

    private PubSubElementType(String str, PubSubNamespace pubSubNamespace) {
        this.eName = str;
        this.nSpace = pubSubNamespace;
    }

    public static PubSubElementType valueOfFromElemName(String str, String str2) {
        String str3;
        int lastIndexOf = str2.lastIndexOf(35);
        if (lastIndexOf == -1) {
            str3 = null;
        } else {
            str3 = str2.substring(lastIndexOf + 1);
        }
        if (str3 == null) {
            return valueOf(str.toUpperCase(Locale.US).replace(SignatureVisitor.SUPER, '_'));
        }
        return valueOf((str + '_' + str3).toUpperCase(Locale.US));
    }

    public String getElementName() {
        return this.eName;
    }

    public PubSubNamespace getNamespace() {
        return this.nSpace;
    }
}
