package org.jivesoftware.smackx.privacy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.ConnectionListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.IQResultReplyFilter;
import org.jivesoftware.smack.filter.IQTypeFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.filter.StanzaTypeFilter;
import org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler;
import org.jivesoftware.smack.iqrequest.IQRequestHandler;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.privacy.filter.SetActiveListFilter;
import org.jivesoftware.smackx.privacy.filter.SetDefaultListFilter;
import org.jivesoftware.smackx.privacy.packet.Privacy;
import org.jivesoftware.smackx.privacy.packet.PrivacyItem;

public final class PrivacyListManager extends Manager {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Map<XMPPConnection, PrivacyListManager> INSTANCES = new WeakHashMap();
    public static final String NAMESPACE = "jabber:iq:privacy";
    public static final StanzaFilter PRIVACY_FILTER;
    private static final StanzaFilter PRIVACY_RESULT;
    /* access modifiers changed from: private */
    public volatile String cachedActiveListName;
    /* access modifiers changed from: private */
    public volatile String cachedDefaultListName;
    /* access modifiers changed from: private */
    public final Set<PrivacyListListener> listeners = new CopyOnWriteArraySet();

    static {
        StanzaTypeFilter stanzaTypeFilter = new StanzaTypeFilter(Privacy.class);
        PRIVACY_FILTER = stanzaTypeFilter;
        PRIVACY_RESULT = new AndFilter(IQTypeFilter.RESULT, stanzaTypeFilter);
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() {
            public void connectionCreated(XMPPConnection xMPPConnection) {
                PrivacyListManager.getInstanceFor(xMPPConnection);
            }
        });
    }

    private PrivacyListManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        xMPPConnection.registerIQRequestHandler(new AbstractIqRequestHandler("query", "jabber:iq:privacy", IQ.Type.set, IQRequestHandler.Mode.sync) {
            public IQ handleIQRequest(IQ iq) {
                Privacy privacy = (Privacy) iq;
                for (PrivacyListListener privacyListListener : PrivacyListManager.this.listeners) {
                    for (Map.Entry next : privacy.getItemLists().entrySet()) {
                        String str = (String) next.getKey();
                        List list = (List) next.getValue();
                        if (list.isEmpty()) {
                            privacyListListener.updatedPrivacyList(str);
                        } else {
                            privacyListListener.setPrivacyList(str, list);
                        }
                    }
                }
                return IQ.createResultIQ(privacy);
            }
        });
        xMPPConnection.addStanzaSendingListener(new StanzaListener() {
            public void processStanza(Stanza stanza) throws SmackException.NotConnectedException {
                XMPPConnection access$100 = PrivacyListManager.this.connection();
                Privacy privacy = (Privacy) stanza;
                IQResultReplyFilter iQResultReplyFilter = new IQResultReplyFilter(privacy, access$100);
                final String activeName = privacy.getActiveName();
                final boolean isDeclineActiveList = privacy.isDeclineActiveList();
                access$100.addOneTimeSyncCallback(new StanzaListener() {
                    public void processStanza(Stanza stanza) throws SmackException.NotConnectedException {
                        if (isDeclineActiveList) {
                            String unused = PrivacyListManager.this.cachedActiveListName = null;
                        } else {
                            String unused2 = PrivacyListManager.this.cachedActiveListName = activeName;
                        }
                    }
                }, iQResultReplyFilter);
            }
        }, SetActiveListFilter.INSTANCE);
        xMPPConnection.addStanzaSendingListener(new StanzaListener() {
            public void processStanza(Stanza stanza) throws SmackException.NotConnectedException {
                XMPPConnection access$300 = PrivacyListManager.this.connection();
                Privacy privacy = (Privacy) stanza;
                IQResultReplyFilter iQResultReplyFilter = new IQResultReplyFilter(privacy, access$300);
                final String defaultName = privacy.getDefaultName();
                final boolean isDeclineDefaultList = privacy.isDeclineDefaultList();
                access$300.addOneTimeSyncCallback(new StanzaListener() {
                    public void processStanza(Stanza stanza) throws SmackException.NotConnectedException {
                        if (isDeclineDefaultList) {
                            String unused = PrivacyListManager.this.cachedDefaultListName = null;
                        } else {
                            String unused2 = PrivacyListManager.this.cachedDefaultListName = defaultName;
                        }
                    }
                }, iQResultReplyFilter);
            }
        }, SetDefaultListFilter.INSTANCE);
        xMPPConnection.addSyncStanzaListener(new StanzaListener() {
            public void processStanza(Stanza stanza) throws SmackException.NotConnectedException {
                Privacy privacy = (Privacy) stanza;
                String activeName = privacy.getActiveName();
                if (activeName != null) {
                    String unused = PrivacyListManager.this.cachedActiveListName = activeName;
                }
                String defaultName = privacy.getDefaultName();
                if (defaultName != null) {
                    String unused2 = PrivacyListManager.this.cachedDefaultListName = defaultName;
                }
            }
        }, PRIVACY_RESULT);
        xMPPConnection.addConnectionListener(new ConnectionListener() {
            public void authenticated(XMPPConnection xMPPConnection, boolean z10) {
                if (!z10) {
                    PrivacyListManager privacyListManager = PrivacyListManager.this;
                    String unused = privacyListManager.cachedActiveListName = privacyListManager.cachedDefaultListName = null;
                }
            }
        });
        ServiceDiscoveryManager.getInstanceFor(xMPPConnection).addFeature("jabber:iq:privacy");
    }

    public static synchronized PrivacyListManager getInstanceFor(XMPPConnection xMPPConnection) {
        PrivacyListManager privacyListManager;
        synchronized (PrivacyListManager.class) {
            Map<XMPPConnection, PrivacyListManager> map = INSTANCES;
            privacyListManager = map.get(xMPPConnection);
            if (privacyListManager == null) {
                privacyListManager = new PrivacyListManager(xMPPConnection);
                map.put(xMPPConnection, privacyListManager);
            }
        }
        return privacyListManager;
    }

    private List<PrivacyItem> getPrivacyListItems(String str) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        Privacy privacy = new Privacy();
        privacy.setPrivacyList(str, new ArrayList());
        return getRequest(privacy).getPrivacyList(str);
    }

    private Privacy getPrivacyWithListNames() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return getRequest(new Privacy());
    }

    private Privacy getRequest(Privacy privacy) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        privacy.setType(IQ.Type.get);
        return (Privacy) connection().createStanzaCollectorAndSend(privacy).nextResultOrThrow();
    }

    private Stanza setRequest(Privacy privacy) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        privacy.setType(IQ.Type.set);
        return connection().createStanzaCollectorAndSend(privacy).nextResultOrThrow();
    }

    public boolean addListener(PrivacyListListener privacyListListener) {
        return this.listeners.add(privacyListListener);
    }

    public void createPrivacyList(String str, List<PrivacyItem> list) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        updatePrivacyList(str, list);
    }

    public void declineActiveList() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        Privacy privacy = new Privacy();
        privacy.setDeclineActiveList(true);
        setRequest(privacy);
    }

    public void declineDefaultList() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        Privacy privacy = new Privacy();
        privacy.setDeclineDefaultList(true);
        setRequest(privacy);
    }

    public void deletePrivacyList(String str) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        Privacy privacy = new Privacy();
        privacy.setPrivacyList(str, new ArrayList());
        setRequest(privacy);
    }

    public PrivacyList getActiveList() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        boolean z10;
        Privacy privacyWithListNames = getPrivacyWithListNames();
        String activeName = privacyWithListNames.getActiveName();
        if (StringUtils.isNullOrEmpty((CharSequence) activeName)) {
            return null;
        }
        if (activeName == null || !activeName.equals(privacyWithListNames.getDefaultName())) {
            z10 = false;
        } else {
            z10 = true;
        }
        return new PrivacyList(true, z10, activeName, getPrivacyListItems(activeName));
    }

    public String getActiveListName() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        if (this.cachedActiveListName != null) {
            return this.cachedActiveListName;
        }
        return getPrivacyWithListNames().getActiveName();
    }

    public PrivacyList getDefaultList() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        Privacy privacyWithListNames = getPrivacyWithListNames();
        String defaultName = privacyWithListNames.getDefaultName();
        if (StringUtils.isNullOrEmpty((CharSequence) defaultName)) {
            return null;
        }
        return new PrivacyList(defaultName.equals(privacyWithListNames.getActiveName()), true, defaultName, getPrivacyListItems(defaultName));
    }

    public String getDefaultListName() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        if (this.cachedDefaultListName != null) {
            return this.cachedDefaultListName;
        }
        return getPrivacyWithListNames().getDefaultName();
    }

    public String getEffectiveListName() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        String activeListName = getActiveListName();
        if (activeListName != null) {
            return activeListName;
        }
        return getDefaultListName();
    }

    public PrivacyList getPrivacyList(String str) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        String str2 = (String) StringUtils.requireNotNullNorEmpty(str, "List name must not be null");
        return new PrivacyList(false, false, str2, getPrivacyListItems(str2));
    }

    public List<PrivacyList> getPrivacyLists() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        Privacy privacyWithListNames = getPrivacyWithListNames();
        Set<String> privacyListNames = privacyWithListNames.getPrivacyListNames();
        ArrayList arrayList = new ArrayList(privacyListNames.size());
        for (String next : privacyListNames) {
            arrayList.add(new PrivacyList(next.equals(privacyWithListNames.getActiveName()), next.equals(privacyWithListNames.getDefaultName()), next, getPrivacyListItems(next)));
        }
        return arrayList;
    }

    public boolean isSupported() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return ServiceDiscoveryManager.getInstanceFor(connection()).serverSupportsFeature("jabber:iq:privacy");
    }

    public boolean removeListener(PrivacyListListener privacyListListener) {
        return this.listeners.remove(privacyListListener);
    }

    public void setActiveListName(String str) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        Privacy privacy = new Privacy();
        privacy.setActiveName(str);
        setRequest(privacy);
    }

    public void setDefaultListName(String str) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        Privacy privacy = new Privacy();
        privacy.setDefaultName(str);
        setRequest(privacy);
    }

    public void updatePrivacyList(String str, List<PrivacyItem> list) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        Privacy privacy = new Privacy();
        privacy.setPrivacyList(str, list);
        setRequest(privacy);
    }
}
