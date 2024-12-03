package org.jivesoftware.smackx.filetransfer;

import com.google.android.gms.common.api.a;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Random;
import java.util.WeakHashMap;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smackx.bytestreams.socks5.packet.Bytestream;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.filetransfer.FileTransferException;
import org.jivesoftware.smackx.formtypes.FormFieldRegistry;
import org.jivesoftware.smackx.hoxt.packet.AbstractHttpOverXmpp;
import org.jivesoftware.smackx.si.packet.StreamInitiation;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.ListSingleFormField;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.jxmpp.jid.Jid;

public final class FileTransferNegotiator extends Manager {
    public static boolean IBB_ONLY = false;
    private static final Map<XMPPConnection, FileTransferNegotiator> INSTANCES = new WeakHashMap();
    private static final String[] NAMESPACE = {"http://jabber.org/protocol/si", SI_PROFILE_FILE_TRANSFER_NAMESPACE};
    public static final String SI_NAMESPACE = "http://jabber.org/protocol/si";
    public static final String SI_PROFILE_FILE_TRANSFER_NAMESPACE = "http://jabber.org/protocol/si/profile/file-transfer";
    protected static final String STREAM_DATA_FIELD_NAME = "stream-method";
    private static final String STREAM_INIT_PREFIX = "jsi_";
    private static final Random randomGenerator = new Random();
    private final StreamNegotiator byteStreamTransferManager;
    private final StreamNegotiator inbandTransferManager;

    static {
        boolean z10;
        FormFieldRegistry.addLookasideFieldRegistryEntry(STREAM_DATA_FIELD_NAME, FormField.Type.list_single);
        if (System.getProperty(AbstractHttpOverXmpp.Ibb.ELEMENT) != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        IBB_ONLY = z10;
    }

    private FileTransferNegotiator(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.byteStreamTransferManager = new Socks5TransferNegotiator(xMPPConnection);
        this.inbandTransferManager = new IBBTransferNegotiator(xMPPConnection);
        setServiceEnabled(xMPPConnection, true);
    }

    private static DataForm createDefaultInitiationForm() {
        DataForm.Builder builder = DataForm.builder(DataForm.Type.form);
        ListSingleFormField.Builder listSingleBuilder = FormField.listSingleBuilder(STREAM_DATA_FIELD_NAME);
        if (!IBB_ONLY) {
            listSingleBuilder.addOption(Bytestream.NAMESPACE);
        }
        listSingleBuilder.addOption("http://jabber.org/protocol/ibb");
        builder.addField(listSingleBuilder.build());
        return builder.build();
    }

    public static synchronized FileTransferNegotiator getInstanceFor(XMPPConnection xMPPConnection) {
        FileTransferNegotiator fileTransferNegotiator;
        synchronized (FileTransferNegotiator.class) {
            Map<XMPPConnection, FileTransferNegotiator> map = INSTANCES;
            fileTransferNegotiator = map.get(xMPPConnection);
            if (fileTransferNegotiator == null) {
                fileTransferNegotiator = new FileTransferNegotiator(xMPPConnection);
                map.put(xMPPConnection, fileTransferNegotiator);
            }
        }
        return fileTransferNegotiator;
    }

    private StreamNegotiator getNegotiator(ListSingleFormField listSingleFormField) throws FileTransferException.NoAcceptableTransferMechanisms {
        boolean z10 = false;
        boolean z11 = false;
        for (FormField.Option valueString : listSingleFormField.getOptions()) {
            String valueString2 = valueString.getValueString();
            if (valueString2.equals(Bytestream.NAMESPACE) && !IBB_ONLY) {
                z10 = true;
            } else if (valueString2.equals("http://jabber.org/protocol/ibb")) {
                z11 = true;
            }
        }
        if (!z10 && !z11) {
            throw new FileTransferException.NoAcceptableTransferMechanisms();
        } else if (z10) {
            return this.byteStreamTransferManager;
        } else {
            return this.inbandTransferManager;
        }
    }

    public static String getNextStreamID() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(STREAM_INIT_PREFIX);
        Random random = randomGenerator;
        sb2.append(random.nextInt(a.e.API_PRIORITY_OTHER) + random.nextInt(a.e.API_PRIORITY_OTHER));
        return sb2.toString();
    }

    private StreamNegotiator getOutgoingNegotiator(FormField formField) throws FileTransferException.NoAcceptableTransferMechanisms {
        boolean z10 = false;
        boolean z11 = false;
        for (CharSequence charSequence : formField.getValues()) {
            String charSequence2 = charSequence.toString();
            if (charSequence2.equals(Bytestream.NAMESPACE) && !IBB_ONLY) {
                z10 = true;
            } else if (charSequence2.equals("http://jabber.org/protocol/ibb")) {
                z11 = true;
            }
        }
        if (!z10 && !z11) {
            throw new FileTransferException.NoAcceptableTransferMechanisms();
        } else if (z10) {
            return this.byteStreamTransferManager;
        } else {
            return this.inbandTransferManager;
        }
    }

    private static ListSingleFormField getStreamMethodField(DataForm dataForm) {
        return (ListSingleFormField) dataForm.getField(STREAM_DATA_FIELD_NAME);
    }

    public static Collection<String> getSupportedProtocols() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("http://jabber.org/protocol/ibb");
        if (!IBB_ONLY) {
            arrayList.add(Bytestream.NAMESPACE);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static boolean isServiceEnabled(XMPPConnection xMPPConnection) {
        ServiceDiscoveryManager instanceFor = ServiceDiscoveryManager.getInstanceFor(xMPPConnection);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(NAMESPACE));
        arrayList.add("http://jabber.org/protocol/ibb");
        if (!IBB_ONLY) {
            arrayList.add(Bytestream.NAMESPACE);
        }
        for (String includesFeature : arrayList) {
            if (!instanceFor.includesFeature(includesFeature)) {
                return false;
            }
        }
        return true;
    }

    private static void setServiceEnabled(XMPPConnection xMPPConnection, boolean z10) {
        ServiceDiscoveryManager instanceFor = ServiceDiscoveryManager.getInstanceFor(xMPPConnection);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(NAMESPACE));
        arrayList.add("http://jabber.org/protocol/ibb");
        if (!IBB_ONLY) {
            arrayList.add(Bytestream.NAMESPACE);
        }
        for (String str : arrayList) {
            if (z10) {
                instanceFor.addFeature(str);
            } else {
                instanceFor.removeFeature(str);
            }
        }
    }

    public StreamNegotiator negotiateOutgoingTransfer(Jid jid, String str, String str2, long j10, String str3, int i10) throws XMPPException.XMPPErrorException, SmackException.NotConnectedException, SmackException.NoResponseException, FileTransferException.NoAcceptableTransferMechanisms, InterruptedException {
        StreamInitiation streamInitiation = new StreamInitiation();
        streamInitiation.setSessionID(str);
        streamInitiation.setMimeType(URLConnection.guessContentTypeFromName(str2));
        StreamInitiation.File file = new StreamInitiation.File(str2, j10);
        file.setDesc(str3);
        streamInitiation.setFile(file);
        streamInitiation.setFeatureNegotiationForm(createDefaultInitiationForm());
        streamInitiation.setFrom(connection().getUser());
        streamInitiation.setTo(jid);
        streamInitiation.setType(IQ.Type.set);
        Stanza nextResultOrThrow = connection().createStanzaCollectorAndSend(streamInitiation).nextResultOrThrow((long) i10);
        if (!(nextResultOrThrow instanceof IQ)) {
            return null;
        }
        IQ iq = (IQ) nextResultOrThrow;
        if (iq.getType().equals(IQ.Type.result)) {
            return getOutgoingNegotiator(getStreamMethodField(((StreamInitiation) nextResultOrThrow).getFeatureNegotiationForm()));
        }
        throw new XMPPException.XMPPErrorException(iq, iq.getError());
    }

    public StreamNegotiator selectStreamNegotiator(FileTransferRequest fileTransferRequest) throws SmackException.NotConnectedException, FileTransferException.NoStreamMethodsOfferedException, FileTransferException.NoAcceptableTransferMechanisms, InterruptedException {
        StreamInitiation streamInitiation = fileTransferRequest.getStreamInitiation();
        ListSingleFormField streamMethodField = getStreamMethodField(streamInitiation.getFeatureNegotiationForm());
        if (streamMethodField != null) {
            try {
                return getNegotiator(streamMethodField);
            } catch (FileTransferException.NoAcceptableTransferMechanisms e10) {
                connection().sendStanza(IQ.createErrorResponse((IQ) streamInitiation, StanzaError.from(StanzaError.Condition.bad_request, "No acceptable transfer mechanism").build()));
                throw e10;
            }
        } else {
            connection().sendStanza(IQ.createErrorResponse((IQ) streamInitiation, StanzaError.from(StanzaError.Condition.bad_request, "No stream methods contained in stanza.").build()));
            throw new FileTransferException.NoStreamMethodsOfferedException();
        }
    }
}
