package org.jivesoftware.smackx.muclight;

import java.util.HashMap;
import org.jxmpp.jid.Jid;

public class MUCLightRoomInfo {
    private final MUCLightRoomConfiguration configuration;
    private final HashMap<Jid, MUCLightAffiliation> occupants;
    private final Jid room;
    private final String version;

    public MUCLightRoomInfo(String str, Jid jid, MUCLightRoomConfiguration mUCLightRoomConfiguration, HashMap<Jid, MUCLightAffiliation> hashMap) {
        this.version = str;
        this.room = jid;
        this.configuration = mUCLightRoomConfiguration;
        this.occupants = hashMap;
    }

    public MUCLightRoomConfiguration getConfiguration() {
        return this.configuration;
    }

    public HashMap<Jid, MUCLightAffiliation> getOccupants() {
        return this.occupants;
    }

    public Jid getRoom() {
        return this.room;
    }

    public String getVersion() {
        return this.version;
    }
}
