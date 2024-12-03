package org.jivesoftware.smackx.commands;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler;
import org.jivesoftware.smack.iqrequest.IQRequestHandler;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smackx.commands.AdHocCommand;
import org.jivesoftware.smackx.commands.packet.AdHocCommandData;
import org.jivesoftware.smackx.disco.AbstractNodeInformationProvider;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.disco.packet.DiscoverInfo;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;
import org.jivesoftware.smackx.xdata.form.FillableForm;
import org.jxmpp.jid.Jid;

public final class AdHocCommandManager extends Manager {
    /* access modifiers changed from: private */
    public static final Logger LOGGER = Logger.getLogger(AdHocCommandManager.class.getName());
    public static final String NAMESPACE = "http://jabber.org/protocol/commands";
    private static final int SESSION_TIMEOUT = 120;
    private static final Map<XMPPConnection, AdHocCommandManager> instances = new WeakHashMap();
    private final Map<String, AdHocCommandInfo> commands = new ConcurrentHashMap();
    private final Map<String, LocalCommand> executingCommands = new ConcurrentHashMap();
    private final ServiceDiscoveryManager serviceDiscoveryManager;
    private boolean sessionSweeperScheduled;

    private static final class AdHocCommandInfo {
        private LocalCommandFactory factory;
        private String name;
        private String node;
        private final Jid ownerJID;

        public LocalCommand getCommandInstance() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
            return this.factory.getInstance();
        }

        public String getName() {
            return this.name;
        }

        public String getNode() {
            return this.node;
        }

        public Jid getOwnerJID() {
            return this.ownerJID;
        }

        private AdHocCommandInfo(String str, String str2, Jid jid, LocalCommandFactory localCommandFactory) {
            this.node = str;
            this.name = str2;
            this.ownerJID = jid;
            this.factory = localCommandFactory;
        }
    }

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() {
            public void connectionCreated(XMPPConnection xMPPConnection) {
                AdHocCommandManager.getAddHocCommandsManager(xMPPConnection);
            }
        });
    }

    private AdHocCommandManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.serviceDiscoveryManager = ServiceDiscoveryManager.getInstanceFor(xMPPConnection);
        ServiceDiscoveryManager.getInstanceFor(xMPPConnection).addFeature("http://jabber.org/protocol/commands");
        ServiceDiscoveryManager.getInstanceFor(xMPPConnection).setNodeInformationProvider("http://jabber.org/protocol/commands", new AbstractNodeInformationProvider() {
            public List<DiscoverItems.Item> getNodeItems() {
                ArrayList arrayList = new ArrayList();
                for (AdHocCommandInfo adHocCommandInfo : AdHocCommandManager.this.getRegisteredCommands()) {
                    DiscoverItems.Item item = new DiscoverItems.Item(adHocCommandInfo.getOwnerJID());
                    item.setName(adHocCommandInfo.getName());
                    item.setNode(adHocCommandInfo.getNode());
                    arrayList.add(item);
                }
                return arrayList;
            }
        });
        xMPPConnection.registerIQRequestHandler(new AbstractIqRequestHandler(AdHocCommandData.ELEMENT, "http://jabber.org/protocol/commands", IQ.Type.set, IQRequestHandler.Mode.async) {
            public IQ handleIQRequest(IQ iq) {
                try {
                    return AdHocCommandManager.this.processAdHocCommand((AdHocCommandData) iq);
                } catch (InterruptedException | SmackException.NoResponseException | SmackException.NotConnectedException e10) {
                    AdHocCommandManager.LOGGER.log(Level.INFO, "processAdHocCommand threw exception", e10);
                    return null;
                }
            }
        });
    }

    public static synchronized AdHocCommandManager getAddHocCommandsManager(XMPPConnection xMPPConnection) {
        AdHocCommandManager adHocCommandManager;
        synchronized (AdHocCommandManager.class) {
            Map<XMPPConnection, AdHocCommandManager> map = instances;
            adHocCommandManager = map.get(xMPPConnection);
            if (adHocCommandManager == null) {
                adHocCommandManager = new AdHocCommandManager(xMPPConnection);
                map.put(xMPPConnection, adHocCommandManager);
            }
        }
        return adHocCommandManager;
    }

    /* access modifiers changed from: private */
    public Collection<AdHocCommandInfo> getRegisteredCommands() {
        return this.commands.values();
    }

    private synchronized void maybeWindUpSessionSweeper() {
        if (!this.sessionSweeperScheduled) {
            this.sessionSweeperScheduled = true;
            Manager.schedule(new a(this), 10, TimeUnit.SECONDS);
        }
    }

    private LocalCommand newInstanceOfCmd(String str, String str2) throws XMPPException.XMPPErrorException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        AdHocCommandInfo adHocCommandInfo = this.commands.get(str);
        LocalCommand commandInstance = adHocCommandInfo.getCommandInstance();
        commandInstance.setSessionID(str2);
        commandInstance.setName(adHocCommandInfo.getName());
        commandInstance.setNode(adHocCommandInfo.getNode());
        return commandInstance;
    }

    /* access modifiers changed from: private */
    public IQ processAdHocCommand(AdHocCommandData adHocCommandData) throws SmackException.NoResponseException, SmackException.NotConnectedException, InterruptedException {
        AdHocCommandData adHocCommandData2 = new AdHocCommandData();
        adHocCommandData2.setTo(adHocCommandData.getFrom());
        adHocCommandData2.setStanzaId(adHocCommandData.getStanzaId());
        adHocCommandData2.setNode(adHocCommandData.getNode());
        adHocCommandData2.setId(adHocCommandData.getTo());
        String sessionID = adHocCommandData.getSessionID();
        String node = adHocCommandData.getNode();
        if (sessionID != null) {
            LocalCommand localCommand = this.executingCommands.get(sessionID);
            if (localCommand == null) {
                return respondError(adHocCommandData2, StanzaError.Condition.bad_request, AdHocCommand.SpecificErrorCondition.badSessionid);
            }
            if (System.currentTimeMillis() - localCommand.getCreationDate() > 120000) {
                this.executingCommands.remove(sessionID);
                return respondError(adHocCommandData2, StanzaError.Condition.not_allowed, AdHocCommand.SpecificErrorCondition.sessionExpired);
            }
            synchronized (localCommand) {
                AdHocCommand.Action action = adHocCommandData.getAction();
                if (action == null || !action.equals(AdHocCommand.Action.unknown)) {
                    if (action == null || AdHocCommand.Action.execute.equals(action)) {
                        action = localCommand.getExecuteAction();
                    }
                    if (!localCommand.isValidAction(action)) {
                        IQ respondError = respondError(adHocCommandData2, StanzaError.Condition.bad_request, AdHocCommand.SpecificErrorCondition.badAction);
                        return respondError;
                    }
                    try {
                        adHocCommandData2.setType(IQ.Type.result);
                        localCommand.setData(adHocCommandData2);
                        if (AdHocCommand.Action.next.equals(action)) {
                            localCommand.incrementStage();
                            localCommand.next(new FillableForm(adHocCommandData.getForm()));
                            if (localCommand.isLastStage()) {
                                adHocCommandData2.setStatus(AdHocCommand.Status.completed);
                            } else {
                                adHocCommandData2.setStatus(AdHocCommand.Status.executing);
                            }
                        } else if (AdHocCommand.Action.complete.equals(action)) {
                            localCommand.incrementStage();
                            localCommand.complete(new FillableForm(adHocCommandData.getForm()));
                            adHocCommandData2.setStatus(AdHocCommand.Status.completed);
                            this.executingCommands.remove(sessionID);
                        } else if (AdHocCommand.Action.prev.equals(action)) {
                            localCommand.decrementStage();
                            localCommand.prev();
                        } else if (AdHocCommand.Action.cancel.equals(action)) {
                            localCommand.cancel();
                            adHocCommandData2.setStatus(AdHocCommand.Status.canceled);
                            this.executingCommands.remove(sessionID);
                        }
                        return adHocCommandData2;
                    } catch (XMPPException.XMPPErrorException e10) {
                        StanzaError stanzaError = e10.getStanzaError();
                        if (StanzaError.Type.CANCEL.equals(stanzaError.getType())) {
                            adHocCommandData2.setStatus(AdHocCommand.Status.canceled);
                            this.executingCommands.remove(sessionID);
                        }
                        return respondError(adHocCommandData2, stanzaError);
                    }
                } else {
                    IQ respondError2 = respondError(adHocCommandData2, StanzaError.Condition.bad_request, AdHocCommand.SpecificErrorCondition.malformedAction);
                    return respondError2;
                }
            }
        } else if (!this.commands.containsKey(node)) {
            return respondError(adHocCommandData2, StanzaError.Condition.item_not_found);
        } else {
            String randomString = StringUtils.randomString(15);
            try {
                LocalCommand newInstanceOfCmd = newInstanceOfCmd(node, randomString);
                try {
                    adHocCommandData2.setType(IQ.Type.result);
                    newInstanceOfCmd.setData(adHocCommandData2);
                    if (!newInstanceOfCmd.hasPermission(adHocCommandData.getFrom())) {
                        return respondError(adHocCommandData2, StanzaError.Condition.forbidden);
                    }
                    AdHocCommand.Action action2 = adHocCommandData.getAction();
                    if (action2 != null && action2.equals(AdHocCommand.Action.unknown)) {
                        return respondError(adHocCommandData2, StanzaError.Condition.bad_request, AdHocCommand.SpecificErrorCondition.malformedAction);
                    }
                    if (action2 != null && !action2.equals(AdHocCommand.Action.execute)) {
                        return respondError(adHocCommandData2, StanzaError.Condition.bad_request, AdHocCommand.SpecificErrorCondition.badAction);
                    }
                    newInstanceOfCmd.incrementStage();
                    newInstanceOfCmd.execute();
                    if (newInstanceOfCmd.isLastStage()) {
                        adHocCommandData2.setStatus(AdHocCommand.Status.completed);
                    } else {
                        adHocCommandData2.setStatus(AdHocCommand.Status.executing);
                        this.executingCommands.put(randomString, newInstanceOfCmd);
                        maybeWindUpSessionSweeper();
                    }
                    return adHocCommandData2;
                } catch (XMPPException.XMPPErrorException e11) {
                    StanzaError stanzaError2 = e11.getStanzaError();
                    if (StanzaError.Type.CANCEL.equals(stanzaError2.getType())) {
                        adHocCommandData2.setStatus(AdHocCommand.Status.canceled);
                        this.executingCommands.remove(randomString);
                    }
                    return respondError(adHocCommandData2, stanzaError2);
                }
            } catch (InstantiationException e12) {
                e = e12;
                return respondError(adHocCommandData2, ((StanzaError.Builder) StanzaError.getBuilder().setCondition(StanzaError.Condition.internal_server_error).setDescriptiveEnText(e.getMessage())).build());
            } catch (IllegalAccessException e13) {
                e = e13;
                return respondError(adHocCommandData2, ((StanzaError.Builder) StanzaError.getBuilder().setCondition(StanzaError.Condition.internal_server_error).setDescriptiveEnText(e.getMessage())).build());
            } catch (IllegalArgumentException e14) {
                e = e14;
                return respondError(adHocCommandData2, ((StanzaError.Builder) StanzaError.getBuilder().setCondition(StanzaError.Condition.internal_server_error).setDescriptiveEnText(e.getMessage())).build());
            } catch (InvocationTargetException e15) {
                e = e15;
                return respondError(adHocCommandData2, ((StanzaError.Builder) StanzaError.getBuilder().setCondition(StanzaError.Condition.internal_server_error).setDescriptiveEnText(e.getMessage())).build());
            } catch (NoSuchMethodException e16) {
                e = e16;
                return respondError(adHocCommandData2, ((StanzaError.Builder) StanzaError.getBuilder().setCondition(StanzaError.Condition.internal_server_error).setDescriptiveEnText(e.getMessage())).build());
            } catch (SecurityException e17) {
                e = e17;
                return respondError(adHocCommandData2, ((StanzaError.Builder) StanzaError.getBuilder().setCondition(StanzaError.Condition.internal_server_error).setDescriptiveEnText(e.getMessage())).build());
            }
        }
    }

    private static IQ respondError(AdHocCommandData adHocCommandData, StanzaError.Condition condition) {
        return respondError(adHocCommandData, StanzaError.getBuilder(condition).build());
    }

    /* access modifiers changed from: private */
    public void sessionSweeper() {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            Iterator<Map.Entry<String, LocalCommand>> it = this.executingCommands.entrySet().iterator();
            while (it.hasNext()) {
                if (currentTimeMillis - ((LocalCommand) it.next().getValue()).getCreationDate() > 240000) {
                    it.remove();
                }
            }
            this.sessionSweeperScheduled = false;
        }
        if (!this.executingCommands.isEmpty()) {
            maybeWindUpSessionSweeper();
        }
    }

    public DiscoverItems discoverCommands(Jid jid) throws XMPPException, SmackException, InterruptedException {
        return this.serviceDiscoveryManager.discoverItems(jid, "http://jabber.org/protocol/commands");
    }

    public RemoteCommand getRemoteCommand(Jid jid, String str) {
        return new RemoteCommand(connection(), str, jid);
    }

    public void registerCommand(String str, String str2, final Class<? extends LocalCommand> cls) {
        registerCommand(str, str2, (LocalCommandFactory) new LocalCommandFactory() {
            public LocalCommand getInstance() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
                return (LocalCommand) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            }
        });
    }

    private static IQ respondError(AdHocCommandData adHocCommandData, StanzaError.Condition condition, AdHocCommand.SpecificErrorCondition specificErrorCondition) {
        return respondError(adHocCommandData, ((StanzaError.Builder) StanzaError.getBuilder(condition).addExtension(new AdHocCommandData.SpecificError(specificErrorCondition))).build());
    }

    public void registerCommand(String str, final String str2, LocalCommandFactory localCommandFactory) {
        this.commands.put(str, new AdHocCommandInfo(str, str2, connection().getUser(), localCommandFactory));
        this.serviceDiscoveryManager.setNodeInformationProvider(str, new AbstractNodeInformationProvider() {
            public List<String> getNodeFeatures() {
                ArrayList arrayList = new ArrayList();
                arrayList.add("http://jabber.org/protocol/commands");
                arrayList.add("jabber:x:data");
                return arrayList;
            }

            public List<DiscoverInfo.Identity> getNodeIdentities() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new DiscoverInfo.Identity("automation", str2, "command-node"));
                return arrayList;
            }
        });
    }

    private static IQ respondError(AdHocCommandData adHocCommandData, StanzaError stanzaError) {
        adHocCommandData.setType(IQ.Type.error);
        adHocCommandData.setError(stanzaError);
        return adHocCommandData;
    }
}
