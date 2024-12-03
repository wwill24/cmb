package com.coffeemeetsbagel.feature.mongoose.enums;

import android.text.TextUtils;
import com.coffeemeetsbagel.models.util.ComparisonUtils;
import org.jivesoftware.smackx.blocking.element.BlockedErrorExtension;
import org.jivesoftware.smackx.csi.packet.ClientStateIndication;

public enum RosterGroup {
    ACTIVE(ClientStateIndication.Active.ELEMENT),
    INACTIVE(ClientStateIndication.Inactive.ELEMENT),
    BLOCKED(BlockedErrorExtension.ELEMENT);
    
    private String group;

    private RosterGroup(String str) {
        this.group = str;
    }

    public static RosterGroup b(String str) {
        for (RosterGroup rosterGroup : values()) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (ComparisonUtils.equalsWithNullCheck(rosterGroup.a(), str)) {
                return rosterGroup;
            }
        }
        return null;
    }

    public String a() {
        return this.group;
    }
}
