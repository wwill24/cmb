package org.jivesoftware.smackx.commands;

import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.commands.AdHocCommand;
import org.jivesoftware.smackx.commands.packet.AdHocCommandData;
import org.jivesoftware.smackx.xdata.form.FillableForm;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.jxmpp.jid.Jid;

public class RemoteCommand extends AdHocCommand {
    private final XMPPConnection connection;
    private final Jid jid;
    private String sessionID;

    protected RemoteCommand(XMPPConnection xMPPConnection, String str, Jid jid2) {
        this.connection = xMPPConnection;
        this.jid = jid2;
        setNode(str);
    }

    private void executeAction(AdHocCommand.Action action) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        executeAction(action, (DataForm) null);
    }

    public void cancel() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        executeAction(AdHocCommand.Action.cancel);
    }

    public void complete(FillableForm fillableForm) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        executeAction(AdHocCommand.Action.complete, fillableForm.getDataFormToSubmit());
    }

    public void execute() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        executeAction(AdHocCommand.Action.execute);
    }

    public Jid getOwnerJID() {
        return this.jid;
    }

    public void next(FillableForm fillableForm) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        executeAction(AdHocCommand.Action.next, fillableForm.getDataFormToSubmit());
    }

    public void prev() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        executeAction(AdHocCommand.Action.prev);
    }

    private void executeAction(AdHocCommand.Action action, DataForm dataForm) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        AdHocCommandData adHocCommandData = new AdHocCommandData();
        adHocCommandData.setType(IQ.Type.set);
        adHocCommandData.setTo(getOwnerJID());
        adHocCommandData.setNode(getNode());
        adHocCommandData.setSessionID(this.sessionID);
        adHocCommandData.setAction(action);
        adHocCommandData.setForm(dataForm);
        AdHocCommandData adHocCommandData2 = (AdHocCommandData) this.connection.createStanzaCollectorAndSend(adHocCommandData).nextResultOrThrow();
        if (adHocCommandData2 != null) {
            this.sessionID = adHocCommandData2.getSessionID();
            super.setData(adHocCommandData2);
        }
    }

    public void execute(FillableForm fillableForm) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        executeAction(AdHocCommand.Action.execute, fillableForm.getDataFormToSubmit());
    }
}
