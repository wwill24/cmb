package org.jivesoftware.smackx.httpfileupload;

import com.facebook.stetho.server.http.HttpHeaders;
import com.google.firebase.perf.FirebasePerformance;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import net.bytebuddy.jar.asm.Opcodes;
import org.jivesoftware.smack.AbstractXMPPConnection;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.ConnectionListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.proxy.ProxyInfo;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.disco.packet.DiscoverInfo;
import org.jivesoftware.smackx.httpfileupload.UploadService;
import org.jivesoftware.smackx.httpfileupload.element.Slot;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.jxmpp.jid.DomainBareJid;

public final class HttpFileUploadManager extends Manager {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Map<XMPPConnection, HttpFileUploadManager> INSTANCES = new WeakHashMap();
    /* access modifiers changed from: private */
    public static final Logger LOGGER = Logger.getLogger(HttpFileUploadManager.class.getName());
    public static final String NAMESPACE = "urn:xmpp:http:upload:0";
    public static final String NAMESPACE_0_2 = "urn:xmpp:http:upload";
    private UploadService defaultUploadService;
    private SSLSocketFactory tlsSocketFactory;

    /* renamed from: org.jivesoftware.smackx.httpfileupload.HttpFileUploadManager$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smackx$httpfileupload$UploadService$Version;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                org.jivesoftware.smackx.httpfileupload.UploadService$Version[] r0 = org.jivesoftware.smackx.httpfileupload.UploadService.Version.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jivesoftware$smackx$httpfileupload$UploadService$Version = r0
                org.jivesoftware.smackx.httpfileupload.UploadService$Version r1 = org.jivesoftware.smackx.httpfileupload.UploadService.Version.v0_3     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$jivesoftware$smackx$httpfileupload$UploadService$Version     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jivesoftware.smackx.httpfileupload.UploadService$Version r1 = org.jivesoftware.smackx.httpfileupload.UploadService.Version.v0_2     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.httpfileupload.HttpFileUploadManager.AnonymousClass3.<clinit>():void");
        }
    }

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() {
            public void connectionCreated(XMPPConnection xMPPConnection) {
                HttpFileUploadManager.getInstanceFor(xMPPConnection);
            }
        });
    }

    private HttpFileUploadManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        xMPPConnection.addConnectionListener(new ConnectionListener() {
            public void authenticated(XMPPConnection xMPPConnection, boolean z10) {
                if (!z10) {
                    try {
                        HttpFileUploadManager.this.discoverUploadService();
                    } catch (InterruptedException | SmackException.NoResponseException | SmackException.NotConnectedException | XMPPException.XMPPErrorException e10) {
                        HttpFileUploadManager.LOGGER.log(Level.WARNING, "Error during discovering HTTP File Upload service", e10);
                    }
                }
            }
        });
    }

    private static boolean containsHttpFileUploadNamespace(DiscoverInfo discoverInfo) {
        return discoverInfo.containsFeature("urn:xmpp:http:upload:0") || discoverInfo.containsFeature("urn:xmpp:http:upload");
    }

    private static HttpURLConnection createProxiedURLConnection(ProxyInfo proxyInfo, URL url) throws IOException {
        Objects.requireNonNull(proxyInfo);
        Objects.requireNonNull(url);
        return (HttpURLConnection) url.openConnection(proxyInfo.toJavaProxy());
    }

    private static HttpURLConnection createURLConnection(XMPPConnection xMPPConnection, URL url) throws IOException {
        Objects.requireNonNull(xMPPConnection);
        Objects.requireNonNull(url);
        ProxyInfo fetchProxyInfo = fetchProxyInfo(xMPPConnection);
        if (fetchProxyInfo != null) {
            return createProxiedURLConnection(fetchProxyInfo, url);
        }
        return (HttpURLConnection) url.openConnection();
    }

    private static ProxyInfo fetchProxyInfo(XMPPConnection xMPPConnection) {
        if (!(xMPPConnection instanceof AbstractXMPPConnection)) {
            return null;
        }
        return ((AbstractXMPPConnection) xMPPConnection).getConfiguration().getProxyInfo();
    }

    public static synchronized HttpFileUploadManager getInstanceFor(XMPPConnection xMPPConnection) {
        HttpFileUploadManager httpFileUploadManager;
        synchronized (HttpFileUploadManager.class) {
            Map<XMPPConnection, HttpFileUploadManager> map = INSTANCES;
            httpFileUploadManager = map.get(xMPPConnection);
            if (httpFileUploadManager == null) {
                httpFileUploadManager = new HttpFileUploadManager(xMPPConnection);
                map.put(xMPPConnection, httpFileUploadManager);
            }
        }
        return httpFileUploadManager;
    }

    public static UploadService.Version namespaceToVersion(String str) {
        str.hashCode();
        if (str.equals("urn:xmpp:http:upload:0")) {
            return UploadService.Version.v0_3;
        }
        if (!str.equals("urn:xmpp:http:upload")) {
            return null;
        }
        return UploadService.Version.v0_2;
    }

    private void upload(InputStream inputStream, long j10, Slot slot, UploadProgressListener uploadProgressListener) throws IOException {
        OutputStream outputStream;
        BufferedInputStream bufferedInputStream;
        URL putUrl = slot.getPutUrl();
        HttpURLConnection createURLConnection = createURLConnection(connection(), putUrl);
        createURLConnection.setRequestMethod(FirebasePerformance.HttpMethod.PUT);
        createURLConnection.setUseCaches(false);
        createURLConnection.setDoOutput(true);
        createURLConnection.setFixedLengthStreamingMode(j10);
        createURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/octet-stream");
        for (Map.Entry next : slot.getHeaders().entrySet()) {
            createURLConnection.setRequestProperty((String) next.getKey(), (String) next.getValue());
        }
        SSLSocketFactory sSLSocketFactory = this.tlsSocketFactory;
        if (sSLSocketFactory != null && (createURLConnection instanceof HttpsURLConnection)) {
            ((HttpsURLConnection) createURLConnection).setSSLSocketFactory(sSLSocketFactory);
        }
        try {
            outputStream = createURLConnection.getOutputStream();
            long j11 = 0;
            if (uploadProgressListener != null) {
                uploadProgressListener.onUploadProgress(0, j10);
            }
            bufferedInputStream = new BufferedInputStream(inputStream);
            byte[] bArr = new byte[Opcodes.ACC_SYNTHETIC];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                outputStream.write(bArr, 0, read);
                j11 += (long) read;
                if (uploadProgressListener != null) {
                    uploadProgressListener.onUploadProgress(j11, j10);
                }
            }
            bufferedInputStream.close();
        } catch (IOException e10) {
            LOGGER.log(Level.WARNING, "Exception while closing input stream", e10);
        } catch (Throwable th2) {
            createURLConnection.disconnect();
            throw th2;
        }
        try {
            outputStream.close();
        } catch (IOException e11) {
            LOGGER.log(Level.WARNING, "Exception while closing output stream", e11);
        }
        int responseCode = createURLConnection.getResponseCode();
        if (!(responseCode == 200 || responseCode == 201)) {
            if (responseCode != 204) {
                throw new IOException("Error response " + responseCode + " from server during file upload: " + createURLConnection.getResponseMessage() + ", file size: " + j10 + ", put URL: " + putUrl);
            }
        }
        createURLConnection.disconnect();
    }

    private static UploadService uploadServiceFrom(DiscoverInfo discoverInfo) {
        UploadService.Version version;
        if (discoverInfo.containsFeature("urn:xmpp:http:upload:0")) {
            version = UploadService.Version.v0_3;
        } else if (discoverInfo.containsFeature("urn:xmpp:http:upload")) {
            version = UploadService.Version.v0_2;
        } else {
            throw new AssertionError();
        }
        DomainBareJid R0 = discoverInfo.getFrom().R0();
        DataForm from = DataForm.from(discoverInfo);
        if (from == null) {
            return new UploadService(R0, version);
        }
        FormField field = from.getField("max-file-size");
        if (field == null) {
            return new UploadService(R0, version);
        }
        String firstValue = field.getFirstValue();
        if (firstValue == null) {
            return new UploadService(R0, version);
        }
        return new UploadService(R0, version, Long.valueOf(firstValue));
    }

    public boolean discoverUploadService() throws XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException, SmackException.NoResponseException {
        ServiceDiscoveryManager instanceFor = ServiceDiscoveryManager.getInstanceFor(connection());
        List<DiscoverInfo> findServicesDiscoverInfo = instanceFor.findServicesDiscoverInfo("urn:xmpp:http:upload:0", true, true);
        if (findServicesDiscoverInfo.isEmpty()) {
            findServicesDiscoverInfo = instanceFor.findServicesDiscoverInfo("urn:xmpp:http:upload", true, true);
            if (findServicesDiscoverInfo.isEmpty()) {
                return false;
            }
        }
        this.defaultUploadService = uploadServiceFrom(findServicesDiscoverInfo.get(0));
        return true;
    }

    public UploadService getDefaultUploadService() {
        return this.defaultUploadService;
    }

    public boolean isUploadServiceDiscovered() {
        return this.defaultUploadService != null;
    }

    public Slot requestSlot(String str, long j10) throws InterruptedException, XMPPException.XMPPErrorException, SmackException {
        return requestSlot(str, j10, (String) null, (DomainBareJid) null);
    }

    public void setTlsContext(SSLContext sSLContext) {
        if (sSLContext != null) {
            this.tlsSocketFactory = sSLContext.getSocketFactory();
        }
    }

    public URL uploadFile(File file) throws InterruptedException, XMPPException.XMPPErrorException, SmackException, IOException {
        return uploadFile(file, (UploadProgressListener) null);
    }

    public Slot requestSlot(String str, long j10, String str2) throws SmackException, InterruptedException, XMPPException.XMPPErrorException {
        return requestSlot(str, j10, str2, (DomainBareJid) null);
    }

    public URL uploadFile(File file, UploadProgressListener uploadProgressListener) throws InterruptedException, XMPPException.XMPPErrorException, SmackException, IOException {
        if (file.isFile()) {
            Slot requestSlot = requestSlot(file.getName(), file.length(), "application/octet-stream");
            upload(new FileInputStream(file), file.length(), requestSlot, uploadProgressListener);
            return requestSlot.getGetUrl();
        }
        throw new FileNotFoundException("The path " + file.getAbsolutePath() + " is not a file");
    }

    /* JADX WARNING: type inference failed for: r14v5, types: [org.jivesoftware.smack.packet.IQ] */
    /* JADX WARNING: type inference failed for: r1v6, types: [org.jivesoftware.smackx.httpfileupload.element.SlotRequest] */
    /* JADX WARNING: type inference failed for: r3v2, types: [org.jivesoftware.smackx.httpfileupload.element.SlotRequest_V0_2] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.jivesoftware.smackx.httpfileupload.element.Slot requestSlot(java.lang.String r10, long r11, java.lang.String r13, org.jxmpp.jid.DomainBareJid r14) throws org.jivesoftware.smack.SmackException, java.lang.InterruptedException, org.jivesoftware.smack.XMPPException.XMPPErrorException {
        /*
            r9 = this;
            org.jivesoftware.smack.XMPPConnection r0 = r9.connection()
            org.jivesoftware.smackx.httpfileupload.UploadService r1 = r9.defaultUploadService
            if (r14 != 0) goto L_0x0009
            goto L_0x0028
        L_0x0009:
            if (r1 == 0) goto L_0x0016
            org.jxmpp.jid.DomainBareJid r2 = r1.getAddress()
            boolean r2 = r2.Y(r14)
            if (r2 == 0) goto L_0x0016
            goto L_0x0028
        L_0x0016:
            org.jivesoftware.smackx.disco.ServiceDiscoveryManager r1 = org.jivesoftware.smackx.disco.ServiceDiscoveryManager.getInstanceFor(r0)
            org.jivesoftware.smackx.disco.packet.DiscoverInfo r1 = r1.discoverInfo(r14)
            boolean r2 = containsHttpFileUploadNamespace(r1)
            if (r2 == 0) goto L_0x0099
            org.jivesoftware.smackx.httpfileupload.UploadService r1 = uploadServiceFrom(r1)
        L_0x0028:
            if (r1 == 0) goto L_0x0091
            boolean r14 = r1.acceptsFileOfSize(r11)
            if (r14 == 0) goto L_0x006e
            int[] r14 = org.jivesoftware.smackx.httpfileupload.HttpFileUploadManager.AnonymousClass3.$SwitchMap$org$jivesoftware$smackx$httpfileupload$UploadService$Version
            org.jivesoftware.smackx.httpfileupload.UploadService$Version r2 = r1.getVersion()
            int r2 = r2.ordinal()
            r14 = r14[r2]
            r2 = 1
            if (r14 == r2) goto L_0x0056
            r2 = 2
            if (r14 != r2) goto L_0x0050
            org.jivesoftware.smackx.httpfileupload.element.SlotRequest_V0_2 r14 = new org.jivesoftware.smackx.httpfileupload.element.SlotRequest_V0_2
            org.jxmpp.jid.DomainBareJid r4 = r1.getAddress()
            r3 = r14
            r5 = r10
            r6 = r11
            r8 = r13
            r3.<init>(r4, r5, r6, r8)
            goto L_0x0063
        L_0x0050:
            java.lang.AssertionError r10 = new java.lang.AssertionError
            r10.<init>()
            throw r10
        L_0x0056:
            org.jivesoftware.smackx.httpfileupload.element.SlotRequest r14 = new org.jivesoftware.smackx.httpfileupload.element.SlotRequest
            org.jxmpp.jid.DomainBareJid r2 = r1.getAddress()
            r1 = r14
            r3 = r10
            r4 = r11
            r6 = r13
            r1.<init>(r2, r3, r4, r6)
        L_0x0063:
            org.jivesoftware.smack.StanzaCollector r10 = r0.createStanzaCollectorAndSend(r14)
            org.jivesoftware.smack.packet.Stanza r10 = r10.nextResultOrThrow()
            org.jivesoftware.smackx.httpfileupload.element.Slot r10 = (org.jivesoftware.smackx.httpfileupload.element.Slot) r10
            return r10
        L_0x006e:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "Requested file size "
            r13.append(r14)
            r13.append(r11)
            java.lang.String r11 = " is greater than max allowed size "
            r13.append(r11)
            java.lang.Long r11 = r1.getMaxFileSize()
            r13.append(r11)
            java.lang.String r11 = r13.toString()
            r10.<init>(r11)
            throw r10
        L_0x0091:
            org.jivesoftware.smack.SmackException$SmackMessageException r10 = new org.jivesoftware.smack.SmackException$SmackMessageException
            java.lang.String r11 = "No upload service specified and also none discovered."
            r10.<init>(r11)
            throw r10
        L_0x0099:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "There is no HTTP upload service running at the given address '"
            r11.append(r12)
            r11.append(r14)
            r12 = 39
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.httpfileupload.HttpFileUploadManager.requestSlot(java.lang.String, long, java.lang.String, org.jxmpp.jid.DomainBareJid):org.jivesoftware.smackx.httpfileupload.element.Slot");
    }

    public URL uploadFile(InputStream inputStream, String str, long j10) throws XMPPException.XMPPErrorException, InterruptedException, SmackException, IOException {
        return uploadFile(inputStream, str, j10, (UploadProgressListener) null);
    }

    public URL uploadFile(InputStream inputStream, String str, long j10, UploadProgressListener uploadProgressListener) throws XMPPException.XMPPErrorException, InterruptedException, SmackException, IOException {
        Objects.requireNonNull(inputStream, "Input Stream cannot be null");
        Objects.requireNonNull(str, "Filename Stream cannot be null");
        if (j10 >= 0) {
            Slot requestSlot = requestSlot(str, j10, "application/octet-stream");
            upload(inputStream, j10, requestSlot, uploadProgressListener);
            return requestSlot.getGetUrl();
        }
        throw new IllegalArgumentException("File size cannot be negative");
    }
}
