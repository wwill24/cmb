package org.jivesoftware.smackx.admin;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.commands.AdHocCommandManager;
import org.jivesoftware.smackx.commands.RemoteCommand;
import org.jivesoftware.smackx.xdata.form.FillableForm;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.Jid;

public class ServiceAdministrationManager extends Manager {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String COMMAND_NODE = "http://jabber.org/protocol/admin";
    private static final String COMMAND_NODE_HASHSIGN = "http://jabber.org/protocol/admin#";
    private static final Map<XMPPConnection, ServiceAdministrationManager> INSTANCES = new WeakHashMap();
    private final AdHocCommandManager adHocCommandManager;

    public ServiceAdministrationManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.adHocCommandManager = AdHocCommandManager.getAddHocCommandsManager(xMPPConnection);
    }

    public static synchronized ServiceAdministrationManager getInstanceFor(XMPPConnection xMPPConnection) {
        ServiceAdministrationManager serviceAdministrationManager;
        synchronized (ServiceAdministrationManager.class) {
            Map<XMPPConnection, ServiceAdministrationManager> map = INSTANCES;
            serviceAdministrationManager = map.get(xMPPConnection);
            if (serviceAdministrationManager == null) {
                serviceAdministrationManager = new ServiceAdministrationManager(xMPPConnection);
                map.put(xMPPConnection, serviceAdministrationManager);
            }
        }
        return serviceAdministrationManager;
    }

    public RemoteCommand addUser() {
        return addUser(connection().getXMPPServiceDomain());
    }

    public RemoteCommand deleteUser() {
        return deleteUser((Jid) connection().getXMPPServiceDomain());
    }

    public RemoteCommand addUser(Jid jid) {
        return this.adHocCommandManager.getRemoteCommand(jid, "http://jabber.org/protocol/admin#add-user");
    }

    public RemoteCommand deleteUser(Jid jid) {
        return this.adHocCommandManager.getRemoteCommand(jid, "http://jabber.org/protocol/admin#delete-user");
    }

    public void addUser(EntityBareJid entityBareJid, String str) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        RemoteCommand addUser = addUser();
        addUser.execute();
        FillableForm fillableForm = new FillableForm(addUser.getForm());
        fillableForm.setAnswer("accountjid", (CharSequence) entityBareJid);
        fillableForm.setAnswer("password", (CharSequence) str);
        fillableForm.setAnswer("password-verify", (CharSequence) str);
        addUser.execute(fillableForm);
    }

    public void deleteUser(EntityBareJid entityBareJid) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        deleteUser((Set<EntityBareJid>) Collections.singleton(entityBareJid));
    }

    public void deleteUser(Set<EntityBareJid> set) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        RemoteCommand deleteUser = deleteUser();
        deleteUser.execute();
        FillableForm fillableForm = new FillableForm(deleteUser.getForm());
        fillableForm.setAnswer("accountjids", (Collection<? extends CharSequence>) set);
        deleteUser.execute(fillableForm);
    }
}
