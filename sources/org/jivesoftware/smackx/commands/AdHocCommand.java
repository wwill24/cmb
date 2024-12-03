package org.jivesoftware.smackx.commands;

import java.util.List;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smackx.commands.packet.AdHocCommandData;
import org.jivesoftware.smackx.xdata.form.FillableForm;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.jxmpp.jid.Jid;

public abstract class AdHocCommand {
    private AdHocCommandData data = new AdHocCommandData();

    public enum Action {
        execute,
        cancel,
        prev,
        next,
        complete,
        unknown
    }

    public enum SpecificErrorCondition {
        badAction("bad-action"),
        malformedAction("malformed-action"),
        badLocale("bad-locale"),
        badPayload("bad-payload"),
        badSessionid("bad-sessionid"),
        sessionExpired("session-expired");
        
        private final String value;

        private SpecificErrorCondition(String str) {
            this.value = str;
        }

        public String toString() {
            return this.value;
        }
    }

    public enum Status {
        executing,
        completed,
        canceled
    }

    public static SpecificErrorCondition getSpecificErrorCondition(StanzaError stanzaError) {
        for (SpecificErrorCondition specificErrorCondition : SpecificErrorCondition.values()) {
            if (stanzaError.getExtension(specificErrorCondition.toString(), "http://jabber.org/protocol/commands") != null) {
                return specificErrorCondition;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void addActionAvailable(Action action) {
        this.data.addAction(action);
    }

    /* access modifiers changed from: protected */
    public void addNote(AdHocCommandNote adHocCommandNote) {
        this.data.addNote(adHocCommandNote);
    }

    public abstract void cancel() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException;

    public abstract void complete(FillableForm fillableForm) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException;

    public abstract void execute() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException;

    /* access modifiers changed from: protected */
    public List<Action> getActions() {
        return this.data.getActions();
    }

    /* access modifiers changed from: package-private */
    public AdHocCommandData getData() {
        return this.data;
    }

    /* access modifiers changed from: protected */
    public Action getExecuteAction() {
        return this.data.getExecuteAction();
    }

    public DataForm getForm() {
        return this.data.getForm();
    }

    public String getName() {
        return this.data.getName();
    }

    public String getNode() {
        return this.data.getNode();
    }

    public List<AdHocCommandNote> getNotes() {
        return this.data.getNotes();
    }

    public abstract Jid getOwnerJID();

    public String getRaw() {
        return this.data.getChildElementXML().toString();
    }

    public Status getStatus() {
        return this.data.getStatus();
    }

    public boolean isCompleted() {
        return getStatus() == Status.completed;
    }

    /* access modifiers changed from: protected */
    public boolean isValidAction(Action action) {
        return getActions().contains(action) || Action.cancel.equals(action);
    }

    public abstract void next(FillableForm fillableForm) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException;

    public abstract void prev() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException;

    /* access modifiers changed from: package-private */
    public void setData(AdHocCommandData adHocCommandData) {
        this.data = adHocCommandData;
    }

    /* access modifiers changed from: protected */
    public void setExecuteAction(Action action) {
        this.data.setExecuteAction(action);
    }

    /* access modifiers changed from: protected */
    public void setForm(DataForm dataForm) {
        this.data.setForm(dataForm);
    }

    public void setName(String str) {
        this.data.setName(str);
    }

    public void setNode(String str) {
        this.data.setNode(str);
    }
}
