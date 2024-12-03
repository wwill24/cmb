package org.jivesoftware.smackx.commands;

import org.jivesoftware.smackx.commands.packet.AdHocCommandData;
import org.jxmpp.jid.Jid;

public abstract class LocalCommand extends AdHocCommand {
    private final long creationDate = System.currentTimeMillis();
    private int currentStage = -1;
    private Jid ownerJID;
    private String sessionID;

    /* access modifiers changed from: package-private */
    public void decrementStage() {
        this.currentStage--;
    }

    public long getCreationDate() {
        return this.creationDate;
    }

    public int getCurrentStage() {
        return this.currentStage;
    }

    public Jid getOwnerJID() {
        return this.ownerJID;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public abstract boolean hasPermission(Jid jid);

    /* access modifiers changed from: package-private */
    public void incrementStage() {
        this.currentStage++;
    }

    public abstract boolean isLastStage();

    /* access modifiers changed from: package-private */
    public void setData(AdHocCommandData adHocCommandData) {
        adHocCommandData.setSessionID(this.sessionID);
        super.setData(adHocCommandData);
    }

    public void setOwnerJID(Jid jid) {
        this.ownerJID = jid;
    }

    public void setSessionID(String str) {
        this.sessionID = str;
        getData().setSessionID(str);
    }
}
