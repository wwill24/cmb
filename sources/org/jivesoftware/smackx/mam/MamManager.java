package org.jivesoftware.smackx.mam;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.apache.commons.beanutils.PropertyUtils;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaCollector;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.IQReplyFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smackx.commands.AdHocCommandManager;
import org.jivesoftware.smackx.commands.RemoteCommand;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;
import org.jivesoftware.smackx.forward.packet.Forwarded;
import org.jivesoftware.smackx.mam.element.MamElements;
import org.jivesoftware.smackx.mam.element.MamFinIQ;
import org.jivesoftware.smackx.mam.element.MamPrefsIQ;
import org.jivesoftware.smackx.mam.element.MamQueryIQ;
import org.jivesoftware.smackx.mam.filter.MamResultFilter;
import org.jivesoftware.smackx.muc.MultiUserChat;
import org.jivesoftware.smackx.rsm.packet.RSMSet;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.TextSingleFormField;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.jxmpp.jid.EntityFullJid;
import org.jxmpp.jid.Jid;

public final class MamManager extends Manager {
    private static final String ADVANCED_CONFIG_NODE = "urn:xmpp:mam#configure";
    private static final String FORM_FIELD_END = "end";
    private static final String FORM_FIELD_START = "start";
    private static final String FORM_FIELD_WITH = "with";
    private static final Map<XMPPConnection, Map<Jid, MamManager>> INSTANCES = new WeakHashMap();
    private final AdHocCommandManager adHocCommandManager;
    /* access modifiers changed from: private */
    public final Jid archiveAddress;
    private final ServiceDiscoveryManager serviceDiscoveryManager;

    public static final class MamPrefs {
        private final List<Jid> alwaysJids;
        private MamPrefsIQ.DefaultBehavior defaultBehavior;
        private final List<Jid> neverJids;

        /* access modifiers changed from: private */
        public MamPrefsIQ constructMamPrefsIq() {
            return new MamPrefsIQ(this.alwaysJids, this.neverJids, this.defaultBehavior);
        }

        public List<Jid> getAlwaysJids() {
            return this.alwaysJids;
        }

        public MamPrefsIQ.DefaultBehavior getDefaultBehavior() {
            return this.defaultBehavior;
        }

        public List<Jid> getNeverJids() {
            return this.neverJids;
        }

        public void setDefaultBehavior(MamPrefsIQ.DefaultBehavior defaultBehavior2) {
            this.defaultBehavior = (MamPrefsIQ.DefaultBehavior) Objects.requireNonNull(defaultBehavior2, "defaultBehavior must not be null");
        }

        private MamPrefs(MamPrefsResult mamPrefsResult) {
            MamPrefsIQ mamPrefsIQ = mamPrefsResult.mamPrefs;
            this.alwaysJids = new ArrayList(mamPrefsIQ.getAlwaysJids());
            this.neverJids = new ArrayList(mamPrefsIQ.getNeverJids());
            this.defaultBehavior = mamPrefsIQ.getDefault();
        }
    }

    public static final class MamPrefsResult {
        public final DataForm form;
        public final MamPrefsIQ mamPrefs;

        public MamPrefs asMamPrefs() {
            return new MamPrefs(this);
        }

        private MamPrefsResult(MamPrefsIQ mamPrefsIQ, DataForm dataForm) {
            this.mamPrefs = mamPrefsIQ;
            this.form = dataForm;
        }
    }

    public final class MamQuery {
        private final DataForm form;
        private MamQueryPage mamQueryPage;
        private final String node;

        private RSMSet getPreviousRsmSet() {
            return this.mamQueryPage.getMamFinIq().getRSMSet();
        }

        private List<Message> page(RSMSet rSMSet) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, SmackException.NotLoggedInException, InterruptedException {
            MamQueryIQ mamQueryIQ = new MamQueryIQ(StringUtils.secureUniqueRandomString(), this.node, this.form);
            mamQueryIQ.setType(IQ.Type.set);
            mamQueryIQ.setTo(MamManager.this.archiveAddress);
            mamQueryIQ.addExtension(rSMSet);
            MamQueryPage access$1400 = MamManager.this.queryArchivePage(mamQueryIQ);
            this.mamQueryPage = access$1400;
            return access$1400.messages;
        }

        public List<MamElements.MamResultExtension> getMamResultExtensions() {
            return this.mamQueryPage.mamResultExtensions;
        }

        public int getMessageCount() {
            return getMessages().size();
        }

        public List<Message> getMessages() {
            return this.mamQueryPage.messages;
        }

        public MamQueryPage getPage() {
            return this.mamQueryPage;
        }

        public boolean isComplete() {
            return this.mamQueryPage.getMamFinIq().isComplete();
        }

        public List<Message> pageNext(int i10) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, SmackException.NotLoggedInException, InterruptedException {
            return page(new RSMSet(i10, getPreviousRsmSet().getLast(), RSMSet.PageDirection.after));
        }

        public List<Message> pagePrevious(int i10) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, SmackException.NotLoggedInException, InterruptedException {
            return page(new RSMSet(i10, getPreviousRsmSet().getFirst(), RSMSet.PageDirection.before));
        }

        private MamQuery(MamQueryPage mamQueryPage2, String str, DataForm dataForm) {
            this.node = str;
            this.form = dataForm;
            this.mamQueryPage = mamQueryPage2;
        }
    }

    public static final class MamQueryArgs {
        private final String afterUid;
        private final String beforeUid;
        private DataForm dataForm;
        private final Map<String, FormField> formFields;
        private final Integer maxResults;
        /* access modifiers changed from: private */
        public final String node;

        public static final class Builder {
            /* access modifiers changed from: private */
            public String afterUid;
            /* access modifiers changed from: private */
            public String beforeUid;
            /* access modifiers changed from: private */
            public final Map<String, FormField> formFields = new LinkedHashMap(8);
            /* access modifiers changed from: private */
            public int maxResults = -1;
            /* access modifiers changed from: private */
            public String node;

            public Builder afterUid(String str) {
                this.afterUid = (String) StringUtils.requireNullOrNotEmpty(str, "afterUid must not be empty");
                return this;
            }

            public Builder beforeUid(String str) {
                this.beforeUid = str;
                return this;
            }

            public MamQueryArgs build() {
                return new MamQueryArgs(this);
            }

            public Builder limitResultsBefore(Date date) {
                if (date == null) {
                    return this;
                }
                TextSingleFormField build = ((TextSingleFormField.Builder) FormField.builder("end").setValue(date)).build();
                this.formFields.put(build.getFieldName(), build);
                FormField formField = this.formFields.get("start");
                if (formField != null) {
                    try {
                        Date firstValueAsDate = formField.getFirstValueAsDate();
                        if (date.getTime() <= firstValueAsDate.getTime()) {
                            throw new IllegalArgumentException("Given end date (" + date + ") is before the existing start date (" + firstValueAsDate + PropertyUtils.MAPPED_DELIM2);
                        }
                    } catch (ParseException e10) {
                        throw new IllegalStateException(e10);
                    }
                }
                return this;
            }

            public Builder limitResultsSince(Date date) {
                if (date == null) {
                    return this;
                }
                TextSingleFormField build = ((TextSingleFormField.Builder) FormField.builder("start").setValue(date)).build();
                this.formFields.put(build.getFieldName(), build);
                FormField formField = this.formFields.get("end");
                if (formField != null) {
                    try {
                        Date firstValueAsDate = formField.getFirstValueAsDate();
                        if (firstValueAsDate.getTime() <= date.getTime()) {
                            throw new IllegalArgumentException("Given start date (" + date + ") is after the existing end date (" + firstValueAsDate + PropertyUtils.MAPPED_DELIM2);
                        }
                    } catch (ParseException e10) {
                        throw new IllegalStateException(e10);
                    }
                }
                return this;
            }

            public Builder limitResultsToJid(Jid jid) {
                if (jid == null) {
                    return this;
                }
                FormField access$600 = MamManager.getWithFormField(jid);
                this.formFields.put(access$600.getFieldName(), access$600);
                return this;
            }

            public Builder onlyReturnMessageCount() {
                return setResultPageSizeTo(0);
            }

            public Builder queryLastPage() {
                return beforeUid("");
            }

            public Builder queryNode(String str) {
                if (str == null) {
                    return this;
                }
                this.node = str;
                return this;
            }

            public Builder setResultPageSize(Integer num) {
                if (num != null) {
                    return setResultPageSizeTo(num.intValue());
                }
                this.maxResults = -1;
                return this;
            }

            public Builder setResultPageSizeTo(int i10) {
                if (i10 >= 0) {
                    this.maxResults = i10;
                    return this;
                }
                throw new IllegalArgumentException();
            }

            public Builder withAdditionalFormField(FormField formField) {
                this.formFields.put(formField.getFieldName(), formField);
                return this;
            }

            public Builder withAdditionalFormFields(List<FormField> list) {
                for (FormField withAdditionalFormField : list) {
                    withAdditionalFormField(withAdditionalFormField);
                }
                return this;
            }
        }

        public static Builder builder() {
            return new Builder();
        }

        /* access modifiers changed from: package-private */
        public DataForm getDataForm() {
            DataForm dataForm2 = this.dataForm;
            if (dataForm2 != null) {
                return dataForm2;
            }
            DataForm.Builder access$500 = MamManager.getNewMamForm();
            access$500.addFields(this.formFields.values());
            DataForm build = access$500.build();
            this.dataForm = build;
            return build;
        }

        /* access modifiers changed from: package-private */
        public void maybeAddRsmSet(MamQueryIQ mamQueryIQ) {
            int i10;
            Integer num = this.maxResults;
            if (num != null || this.afterUid != null || this.beforeUid != null) {
                if (num != null) {
                    i10 = num.intValue();
                } else {
                    i10 = -1;
                }
                mamQueryIQ.addExtension(new RSMSet(this.afterUid, this.beforeUid, -1, -1, (String) null, i10, (String) null, -1));
            }
        }

        private MamQueryArgs(Builder builder) {
            this.node = builder.node;
            this.formFields = builder.formFields;
            if (builder.maxResults > 0) {
                this.maxResults = Integer.valueOf(builder.maxResults);
            } else {
                this.maxResults = null;
            }
            this.afterUid = builder.afterUid;
            this.beforeUid = builder.beforeUid;
        }
    }

    public static final class MamQueryPage {
        private final List<Forwarded<Message>> forwardedMessages;
        private final MamFinIQ mamFin;
        private final List<Message> mamResultCarrierMessages;
        /* access modifiers changed from: private */
        public final List<MamElements.MamResultExtension> mamResultExtensions;
        /* access modifiers changed from: private */
        public final List<Message> messages;

        public List<Forwarded<Message>> getForwarded() {
            return this.forwardedMessages;
        }

        public MamFinIQ getMamFinIq() {
            return this.mamFin;
        }

        public List<Message> getMamResultCarrierMessages() {
            return this.mamResultCarrierMessages;
        }

        public List<MamElements.MamResultExtension> getMamResultExtensions() {
            return this.mamResultExtensions;
        }

        public List<Message> getMessages() {
            return this.messages;
        }

        private MamQueryPage(StanzaCollector stanzaCollector, MamFinIQ mamFinIQ) {
            this.mamFin = mamFinIQ;
            List<Stanza> collectedStanzasAfterCancelled = stanzaCollector.getCollectedStanzasAfterCancelled();
            ArrayList arrayList = new ArrayList(collectedStanzasAfterCancelled.size());
            ArrayList arrayList2 = new ArrayList(collectedStanzasAfterCancelled.size());
            ArrayList arrayList3 = new ArrayList(collectedStanzasAfterCancelled.size());
            Iterator<Stanza> it = collectedStanzasAfterCancelled.iterator();
            while (it.hasNext()) {
                Message message = (Message) it.next();
                arrayList.add(message);
                MamElements.MamResultExtension from = MamElements.MamResultExtension.from(message);
                arrayList2.add(from);
                arrayList3.add(from.getForwarded());
            }
            this.mamResultCarrierMessages = Collections.unmodifiableList(arrayList);
            this.mamResultExtensions = Collections.unmodifiableList(arrayList2);
            this.forwardedMessages = Collections.unmodifiableList(arrayList3);
            this.messages = Collections.unmodifiableList(Forwarded.extractMessagesFrom(arrayList3));
        }
    }

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() {
            public void connectionCreated(XMPPConnection xMPPConnection) {
                MamManager.getInstanceFor(xMPPConnection);
            }
        });
    }

    private MamManager(XMPPConnection xMPPConnection, Jid jid) {
        super(xMPPConnection);
        this.archiveAddress = jid;
        this.serviceDiscoveryManager = ServiceDiscoveryManager.getInstanceFor(xMPPConnection);
        this.adHocCommandManager = AdHocCommandManager.getAddHocCommandsManager(xMPPConnection);
    }

    public static MamManager getInstanceFor(XMPPConnection xMPPConnection) {
        return getInstanceFor(xMPPConnection, (Jid) null);
    }

    /* access modifiers changed from: private */
    public static DataForm.Builder getNewMamForm() {
        TextSingleFormField buildHiddenFormType = FormField.buildHiddenFormType("urn:xmpp:mam:2");
        DataForm.Builder builder = DataForm.builder();
        builder.addField(buildHiddenFormType);
        return builder;
    }

    /* access modifiers changed from: private */
    public static FormField getWithFormField(Jid jid) {
        return ((TextSingleFormField.Builder) FormField.builder(FORM_FIELD_WITH).setValue((CharSequence) jid.toString())).build();
    }

    /* access modifiers changed from: private */
    public MamQueryPage queryArchivePage(MamQueryIQ mamQueryIQ) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException, SmackException.NotLoggedInException {
        XMPPConnection authenticatedConnectionOrThrow = getAuthenticatedConnectionOrThrow();
        StanzaCollector createStanzaCollector = authenticatedConnectionOrThrow.createStanzaCollector((StanzaFilter) new IQReplyFilter(mamQueryIQ, authenticatedConnectionOrThrow));
        StanzaCollector createStanzaCollector2 = authenticatedConnectionOrThrow.createStanzaCollector(StanzaCollector.newConfiguration().setStanzaFilter(new MamResultFilter(mamQueryIQ)).setCollectorToReset(createStanzaCollector));
        try {
            authenticatedConnectionOrThrow.sendStanza(mamQueryIQ);
            MamFinIQ mamFinIQ = (MamFinIQ) createStanzaCollector.nextResultOrThrow();
            if (createStanzaCollector2 != null) {
                createStanzaCollector2.close();
            }
            return new MamQueryPage(createStanzaCollector2, mamFinIQ);
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    private MamPrefsResult queryMamPrefs(MamPrefsIQ mamPrefsIQ) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException, SmackException.NotLoggedInException {
        return new MamPrefsResult((MamPrefsIQ) getAuthenticatedConnectionOrThrow().createStanzaCollectorAndSend(mamPrefsIQ).nextResultOrThrow(), DataForm.from(mamPrefsIQ));
    }

    public MamPrefsResult enableMamForAllMessages() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, SmackException.NotLoggedInException, InterruptedException {
        return setDefaultBehavior(MamPrefsIQ.DefaultBehavior.always);
    }

    public MamPrefsResult enableMamForRosterMessages() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, SmackException.NotLoggedInException, InterruptedException {
        return setDefaultBehavior(MamPrefsIQ.DefaultBehavior.roster);
    }

    public RemoteCommand getAdvancedConfigurationCommand() throws InterruptedException, XMPPException, SmackException {
        for (DiscoverItems.Item next : this.adHocCommandManager.discoverCommands(this.archiveAddress).getItems()) {
            if (next.getNode().equals(ADVANCED_CONFIG_NODE)) {
                return this.adHocCommandManager.getRemoteCommand(this.archiveAddress, next.getNode());
            }
        }
        throw new SmackException.FeatureNotSupportedException(ADVANCED_CONFIG_NODE, this.archiveAddress);
    }

    public Jid getArchiveAddress() {
        Jid jid = this.archiveAddress;
        if (jid != null) {
            return jid;
        }
        EntityFullJid user = connection().getUser();
        if (user == null) {
            return null;
        }
        return user.i1();
    }

    public String getMessageUidOfLatestMessage() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, SmackException.NotLoggedInException, InterruptedException {
        MamQuery queryArchive = queryArchive(MamQueryArgs.builder().setResultPageSize(1).queryLastPage().build());
        if (queryArchive.getMessages().isEmpty()) {
            return null;
        }
        return queryArchive.getMamResultExtensions().get(0).getId();
    }

    public boolean isAdvancedConfigurationSupported() throws InterruptedException, XMPPException, SmackException {
        for (DiscoverItems.Item node : this.adHocCommandManager.discoverCommands(this.archiveAddress).getItems()) {
            if (node.getNode().equals(ADVANCED_CONFIG_NODE)) {
                return true;
            }
        }
        return false;
    }

    public boolean isSupported() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return this.serviceDiscoveryManager.supportsFeature(getArchiveAddress(), "urn:xmpp:mam:2");
    }

    public MamQuery queryArchive(MamQueryArgs mamQueryArgs) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, SmackException.NotLoggedInException, InterruptedException {
        MamQueryIQ mamQueryIQ = new MamQueryIQ(StringUtils.secureUniqueRandomString(), mamQueryArgs.node, mamQueryArgs.getDataForm());
        mamQueryIQ.setType(IQ.Type.set);
        mamQueryIQ.setTo(this.archiveAddress);
        mamQueryArgs.maybeAddRsmSet(mamQueryIQ);
        return queryArchive(mamQueryIQ);
    }

    public MamQuery queryMostRecentPage(Jid jid, int i10) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, SmackException.NotLoggedInException, InterruptedException {
        return queryArchive(MamQueryArgs.builder().queryLastPage().limitResultsToJid(jid).setResultPageSize(Integer.valueOf(i10)).build());
    }

    public MamPrefsResult retrieveArchivingPreferences() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException, SmackException.NotLoggedInException {
        return queryMamPrefs(new MamPrefsIQ());
    }

    public List<FormField> retrieveFormFields() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException, SmackException.NotLoggedInException {
        return retrieveFormFields((String) null);
    }

    public MamPrefsResult setDefaultBehavior(MamPrefsIQ.DefaultBehavior defaultBehavior) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, SmackException.NotLoggedInException, InterruptedException {
        MamPrefsResult retrieveArchivingPreferences = retrieveArchivingPreferences();
        if (retrieveArchivingPreferences.mamPrefs.getDefault() == defaultBehavior) {
            return retrieveArchivingPreferences;
        }
        MamPrefs asMamPrefs = retrieveArchivingPreferences.asMamPrefs();
        asMamPrefs.setDefaultBehavior(defaultBehavior);
        return updateArchivingPreferences(asMamPrefs);
    }

    public MamPrefsResult updateArchivingPreferences(MamPrefs mamPrefs) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException, SmackException.NotLoggedInException {
        return queryMamPrefs(mamPrefs.constructMamPrefsIq());
    }

    public static MamManager getInstanceFor(MultiUserChat multiUserChat) {
        return getInstanceFor(multiUserChat.getXmppConnection(), multiUserChat.getRoom());
    }

    public List<FormField> retrieveFormFields(String str) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException, SmackException.NotLoggedInException {
        MamQueryIQ mamQueryIQ = new MamQueryIQ(StringUtils.secureUniqueRandomString(), str, (DataForm) null);
        mamQueryIQ.setTo(this.archiveAddress);
        return ((MamQueryIQ) connection().createStanzaCollectorAndSend(mamQueryIQ).nextResultOrThrow()).getDataForm().getFields();
    }

    public static synchronized MamManager getInstanceFor(XMPPConnection xMPPConnection, Jid jid) {
        MamManager mamManager;
        synchronized (MamManager.class) {
            Map<XMPPConnection, Map<Jid, MamManager>> map = INSTANCES;
            Map map2 = map.get(xMPPConnection);
            if (map2 == null) {
                map2 = new HashMap();
                map.put(xMPPConnection, map2);
            }
            mamManager = (MamManager) map2.get(jid);
            if (mamManager == null) {
                mamManager = new MamManager(xMPPConnection, jid);
                map2.put(jid, mamManager);
            }
        }
        return mamManager;
    }

    private MamQuery queryArchive(MamQueryIQ mamQueryIQ) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException, SmackException.NotLoggedInException {
        return new MamQuery(queryArchivePage(mamQueryIQ), mamQueryIQ.getNode(), DataForm.from(mamQueryIQ));
    }
}
