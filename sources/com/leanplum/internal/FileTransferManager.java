package com.leanplum.internal;

import com.leanplum.internal.Constants;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.b;

public class FileTransferManager {
    private static final FileTransferManager INSTANCE = new FileTransferManager();
    private final Map<String, Boolean> fileTransferStatus = new HashMap();
    /* access modifiers changed from: private */
    public final Map<File, Double> fileUploadProgress = new HashMap();
    private String fileUploadProgressString = "";
    private final Map<File, Long> fileUploadSize = new HashMap();
    private NoPendingDownloadsCallback noPendingDownloadsBlock;
    private int pendingDownloads;
    /* access modifiers changed from: private */
    public final Object uploadFileLock = new Object();

    public interface NoPendingDownloadsCallback {
        void noPendingDownloads();
    }

    private FileTransferManager() {
    }

    /* JADX WARNING: type inference failed for: r7v1, types: [java.net.URL] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00e8, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00e9, code lost:
        r9 = r4;
        r3 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ec, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ed, code lost:
        r3 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0106, code lost:
        downloadHelper(r17, (java.lang.String) null, r9.getURL().toString(), r20, r21, new java.util.HashMap());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x011f, code lost:
        r9.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0122, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0140, code lost:
        r1.error(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0150, code lost:
        r9.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0158, code lost:
        r3.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ec A[ExcHandler: all (th java.lang.Throwable), Splitter:B:12:0x0050] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00fa A[ADDED_TO_REGION, Catch:{ all -> 0x0154 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0140 A[Catch:{ all -> 0x0154 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void downloadHelper(com.leanplum.internal.Request r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.util.Map<java.lang.String, java.lang.Object> r22) {
        /*
            r16 = this;
            r8 = r16
            r2 = r17
            r5 = r20
            r6 = r21
            java.lang.String r13 = r17.getHttpMethod()
            r1 = 1
            java.lang.String r0 = "https://"
            r3 = 0
            if (r6 != 0) goto L_0x0045
            if (r5 == 0) goto L_0x002e
            java.lang.String r4 = "http://"
            boolean r4 = r5.startsWith(r4)     // Catch:{ Exception -> 0x00f4, all -> 0x00f2 }
            if (r4 != 0) goto L_0x0022
            boolean r4 = r5.startsWith(r0)     // Catch:{ Exception -> 0x00f4, all -> 0x00f2 }
            if (r4 == 0) goto L_0x002e
        L_0x0022:
            com.leanplum.internal.http.NetworkOperation r4 = new com.leanplum.internal.http.NetworkOperation     // Catch:{ Exception -> 0x00f4, all -> 0x00f2 }
            boolean r0 = r5.startsWith(r0)     // Catch:{ Exception -> 0x00f4, all -> 0x00f2 }
            int r7 = com.leanplum.internal.Constants.NETWORK_TIMEOUT_SECONDS_FOR_DOWNLOADS     // Catch:{ Exception -> 0x00f4, all -> 0x00f2 }
            r4.<init>(r5, r13, r0, r7)     // Catch:{ Exception -> 0x00f4, all -> 0x00f2 }
            goto L_0x0050
        L_0x002e:
            com.leanplum.internal.http.NetworkOperation r4 = new com.leanplum.internal.http.NetworkOperation     // Catch:{ Exception -> 0x00f4, all -> 0x00f2 }
            com.leanplum.internal.APIConfig r0 = com.leanplum.internal.APIConfig.getInstance()     // Catch:{ Exception -> 0x00f4, all -> 0x00f2 }
            boolean r14 = r0.getApiSSL()     // Catch:{ Exception -> 0x00f4, all -> 0x00f2 }
            int r15 = com.leanplum.internal.Constants.NETWORK_TIMEOUT_SECONDS_FOR_DOWNLOADS     // Catch:{ Exception -> 0x00f4, all -> 0x00f2 }
            r9 = r4
            r10 = r18
            r11 = r19
            r12 = r22
            r9.<init>(r10, r11, r12, r13, r14, r15)     // Catch:{ Exception -> 0x00f4, all -> 0x00f2 }
            goto L_0x0050
        L_0x0045:
            com.leanplum.internal.http.NetworkOperation r4 = new com.leanplum.internal.http.NetworkOperation     // Catch:{ Exception -> 0x00f4, all -> 0x00f2 }
            boolean r0 = r6.startsWith(r0)     // Catch:{ Exception -> 0x00f4, all -> 0x00f2 }
            int r7 = com.leanplum.internal.Constants.NETWORK_TIMEOUT_SECONDS_FOR_DOWNLOADS     // Catch:{ Exception -> 0x00f4, all -> 0x00f2 }
            r4.<init>(r6, r13, r0, r7)     // Catch:{ Exception -> 0x00f4, all -> 0x00f2 }
        L_0x0050:
            java.net.URL r7 = r4.getURL()     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
            r4.connect()     // Catch:{ Exception -> 0x00e8, all -> 0x00ec }
            int r0 = r4.getResponseCode()     // Catch:{ Exception -> 0x00e8, all -> 0x00ec }
            r9 = 200(0xc8, float:2.8E-43)
            if (r0 != r9) goto L_0x00c7
            java.util.Stack r0 = new java.util.Stack     // Catch:{ Exception -> 0x00e8, all -> 0x00ec }
            r0.<init>()     // Catch:{ Exception -> 0x00e8, all -> 0x00ec }
            r9 = r5
        L_0x0065:
            java.io.File r10 = new java.io.File     // Catch:{ Exception -> 0x00e8, all -> 0x00ec }
            r10.<init>(r9)     // Catch:{ Exception -> 0x00e8, all -> 0x00ec }
            java.lang.String r9 = r10.getParent()     // Catch:{ Exception -> 0x00e8, all -> 0x00ec }
            if (r9 == 0) goto L_0x0074
            r0.push(r9)     // Catch:{ Exception -> 0x00e8, all -> 0x00ec }
            goto L_0x0065
        L_0x0074:
            boolean r9 = r0.isEmpty()     // Catch:{ Exception -> 0x00e8, all -> 0x00ec }
            if (r9 != 0) goto L_0x009a
            java.lang.Object r9 = r0.pop()     // Catch:{ Exception -> 0x00e8, all -> 0x00ec }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x00e8, all -> 0x00ec }
            java.lang.String r9 = com.leanplum.internal.FileManager.fileRelativeToDocuments(r9)     // Catch:{ Exception -> 0x00e8, all -> 0x00ec }
            java.io.File r10 = new java.io.File     // Catch:{ Exception -> 0x00e8, all -> 0x00ec }
            r10.<init>(r9)     // Catch:{ Exception -> 0x00e8, all -> 0x00ec }
            boolean r10 = r10.mkdir()     // Catch:{ Exception -> 0x00e8, all -> 0x00ec }
            if (r10 != 0) goto L_0x0074
            java.lang.String r10 = "Failed to create directory: "
            java.lang.Object[] r11 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x00e8, all -> 0x00ec }
            r12 = 0
            r11[r12] = r9     // Catch:{ Exception -> 0x00e8, all -> 0x00ec }
            com.leanplum.internal.Log.d(r10, r11)     // Catch:{ Exception -> 0x00e8, all -> 0x00ec }
            goto L_0x0074
        L_0x009a:
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00e8, all -> 0x00ec }
            java.io.File r9 = new java.io.File     // Catch:{ Exception -> 0x00e8, all -> 0x00ec }
            java.lang.String r10 = com.leanplum.internal.FileManager.fileRelativeToDocuments(r20)     // Catch:{ Exception -> 0x00e8, all -> 0x00ec }
            r9.<init>(r10)     // Catch:{ Exception -> 0x00e8, all -> 0x00ec }
            r0.<init>(r9)     // Catch:{ Exception -> 0x00e8, all -> 0x00ec }
            r4.saveResponse(r0)     // Catch:{ Exception -> 0x00e8, all -> 0x00ec }
            int r0 = r8.pendingDownloads     // Catch:{ Exception -> 0x00e8, all -> 0x00ec }
            int r0 = r0 - r1
            r8.pendingDownloads = r0     // Catch:{ Exception -> 0x00e8, all -> 0x00ec }
            com.leanplum.internal.Request$ResponseCallback r0 = r2.response     // Catch:{ Exception -> 0x00e8, all -> 0x00ec }
            if (r0 == 0) goto L_0x00b7
            r0.response(r3)     // Catch:{ Exception -> 0x00e8, all -> 0x00ec }
        L_0x00b7:
            int r0 = r8.pendingDownloads     // Catch:{ Exception -> 0x00e8, all -> 0x00ec }
            if (r0 != 0) goto L_0x00c2
            com.leanplum.internal.FileTransferManager$NoPendingDownloadsCallback r0 = r8.noPendingDownloadsBlock     // Catch:{ Exception -> 0x00e8, all -> 0x00ec }
            if (r0 == 0) goto L_0x00c2
            r0.noPendingDownloads()     // Catch:{ Exception -> 0x00e8, all -> 0x00ec }
        L_0x00c2:
            r4.disconnect()
            goto L_0x0153
        L_0x00c7:
            java.lang.Exception r3 = new java.lang.Exception     // Catch:{ Exception -> 0x00e8, all -> 0x00ec }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e8, all -> 0x00ec }
            r9.<init>()     // Catch:{ Exception -> 0x00e8, all -> 0x00ec }
            java.lang.String r10 = "Leanplum: Error sending request to: "
            r9.append(r10)     // Catch:{ Exception -> 0x00e8, all -> 0x00ec }
            r10 = r18
            r9.append(r10)     // Catch:{ Exception -> 0x00e8, all -> 0x00ec }
            java.lang.String r10 = ", HTTP status code: "
            r9.append(r10)     // Catch:{ Exception -> 0x00e8, all -> 0x00ec }
            r9.append(r0)     // Catch:{ Exception -> 0x00e8, all -> 0x00ec }
            java.lang.String r0 = r9.toString()     // Catch:{ Exception -> 0x00e8, all -> 0x00ec }
            r3.<init>(r0)     // Catch:{ Exception -> 0x00e8, all -> 0x00ec }
            throw r3     // Catch:{ Exception -> 0x00e8, all -> 0x00ec }
        L_0x00e8:
            r0 = move-exception
            r9 = r4
            r3 = r7
            goto L_0x00f6
        L_0x00ec:
            r0 = move-exception
            r3 = r4
            goto L_0x0156
        L_0x00ef:
            r0 = move-exception
            r9 = r4
            goto L_0x00f6
        L_0x00f2:
            r0 = move-exception
            goto L_0x0156
        L_0x00f4:
            r0 = move-exception
            r9 = r3
        L_0x00f6:
            boolean r4 = r0 instanceof java.io.EOFException     // Catch:{ all -> 0x0154 }
            if (r4 == 0) goto L_0x0123
            if (r9 == 0) goto L_0x0123
            java.net.URL r4 = r9.getURL()     // Catch:{ all -> 0x0154 }
            boolean r3 = r4.equals(r3)     // Catch:{ all -> 0x0154 }
            if (r3 != 0) goto L_0x0123
            r3 = 0
            java.net.URL r0 = r9.getURL()     // Catch:{ all -> 0x0154 }
            java.lang.String r4 = r0.toString()     // Catch:{ all -> 0x0154 }
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ all -> 0x0154 }
            r7.<init>()     // Catch:{ all -> 0x0154 }
            r1 = r16
            r2 = r17
            r5 = r20
            r6 = r21
            r1.downloadHelper(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0154 }
            r9.disconnect()
            return
        L_0x0123:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0154 }
            r3.<init>()     // Catch:{ all -> 0x0154 }
            java.lang.String r4 = "Error downloading resource:"
            r3.append(r4)     // Catch:{ all -> 0x0154 }
            r3.append(r5)     // Catch:{ all -> 0x0154 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0154 }
            com.leanplum.internal.Log.e((java.lang.String) r3, (java.lang.Throwable) r0)     // Catch:{ all -> 0x0154 }
            int r3 = r8.pendingDownloads     // Catch:{ all -> 0x0154 }
            int r3 = r3 - r1
            r8.pendingDownloads = r3     // Catch:{ all -> 0x0154 }
            com.leanplum.internal.Request$ErrorCallback r1 = r2.error     // Catch:{ all -> 0x0154 }
            if (r1 == 0) goto L_0x0143
            r1.error(r0)     // Catch:{ all -> 0x0154 }
        L_0x0143:
            int r0 = r8.pendingDownloads     // Catch:{ all -> 0x0154 }
            if (r0 != 0) goto L_0x014e
            com.leanplum.internal.FileTransferManager$NoPendingDownloadsCallback r0 = r8.noPendingDownloadsBlock     // Catch:{ all -> 0x0154 }
            if (r0 == 0) goto L_0x014e
            r0.noPendingDownloads()     // Catch:{ all -> 0x0154 }
        L_0x014e:
            if (r9 == 0) goto L_0x0153
            r9.disconnect()
        L_0x0153:
            return
        L_0x0154:
            r0 = move-exception
            r3 = r9
        L_0x0156:
            if (r3 == 0) goto L_0x015b
            r3.disconnect()
        L_0x015b:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.leanplum.internal.FileTransferManager.downloadHelper(com.leanplum.internal.Request, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Map):void");
    }

    public static FileTransferManager getInstance() {
        return INSTANCE;
    }

    private static String getSizeAsString(int i10) {
        if (i10 < 1024) {
            return i10 + " B";
        } else if (i10 < 1048576) {
            return (i10 >> 10) + " KB";
        } else {
            return (i10 >> 20) + " MB";
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$downloadFile$0(Runnable runnable, b bVar) {
        if (runnable != null) {
            runnable.run();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$downloadFile$1(Runnable runnable, Exception exc) {
        if (runnable != null) {
            runnable.run();
        }
    }

    /* access modifiers changed from: private */
    public void printUploadProgress() {
        int size = this.fileUploadSize.size();
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        for (Map.Entry next : this.fileUploadSize.entrySet()) {
            long longValue = ((Long) next.getValue()).longValue();
            double doubleValue = this.fileUploadProgress.get((File) next.getKey()).doubleValue();
            if (doubleValue == 1.0d) {
                i10++;
            }
            i11 += (int) (((double) longValue) * doubleValue);
            i12 = (int) (((long) i12) + longValue);
        }
        String str = "Uploading resources. " + i10 + '/' + size + " files completed; " + getSizeAsString(i11) + '/' + getSizeAsString(i12) + " transferred.";
        if (!this.fileUploadProgressString.equals(str)) {
            this.fileUploadProgressString = str;
            Log.d(str, new Object[0]);
        }
    }

    /* access modifiers changed from: package-private */
    public void downloadFile(String str, String str2, Runnable runnable, Runnable runnable2) {
        if (!Constants.isTestMode) {
            Boolean bool = Boolean.TRUE;
            if (!bool.equals(this.fileTransferStatus.get(str))) {
                final Request create = RequestBuilder.withDownloadFileAction().create();
                create.onResponse(new b(runnable));
                create.onError(new c(runnable2));
                this.pendingDownloads++;
                Log.d("Downloading resource: %s", str);
                this.fileTransferStatus.put(str, bool);
                final Map<String, Object> createArgsDictionary = RequestSender.createArgsDictionary(create);
                createArgsDictionary.put(Constants.Keys.FILENAME, str);
                if (APIConfig.getInstance().attachApiKeys(createArgsDictionary)) {
                    final String str3 = str;
                    final String str4 = str2;
                    OperationQueue.sharedInstance().addParallelOperation(new Runnable() {
                        public void run() {
                            try {
                                FileTransferManager.this.downloadHelper(create, APIConfig.getInstance().getApiHost(), APIConfig.getInstance().getApiPath(), str3, str4, createArgsDictionary);
                            } catch (Throwable th2) {
                                Log.exception(th2);
                            }
                        }
                    });
                }
            }
        }
    }

    public int numPendingDownloads() {
        return this.pendingDownloads;
    }

    public void onNoPendingDownloads(NoPendingDownloadsCallback noPendingDownloadsCallback) {
        this.noPendingDownloadsBlock = noPendingDownloadsCallback;
    }

    public void sendFilesNow(List<b> list, List<String> list2, List<InputStream> list3) {
        long j10;
        final Request create = RequestBuilder.withUploadFileAction().andParam("data", list.toString()).create();
        if (!Constants.isTestMode) {
            final Map<String, Object> createArgsDictionary = RequestSender.createArgsDictionary(create);
            if (APIConfig.getInstance().attachApiKeys(createArgsDictionary)) {
                final ArrayList arrayList = new ArrayList();
                for (int i10 = 0; i10 < list2.size(); i10++) {
                    String str = list2.get(i10);
                    if (str != null && !Boolean.TRUE.equals(this.fileTransferStatus.get(str))) {
                        File file = new File(str);
                        try {
                            j10 = (long) list3.get(i10).available();
                        } catch (IOException unused) {
                            j10 = file.length();
                        } catch (NullPointerException unused2) {
                            Log.e("Unable to read file " + str, new Object[0]);
                        }
                        this.fileTransferStatus.put(str, Boolean.TRUE);
                        arrayList.add(file);
                        this.fileUploadSize.put(file, Long.valueOf(j10));
                        this.fileUploadProgress.put(file, Double.valueOf(0.0d));
                    }
                }
                if (arrayList.size() != 0) {
                    printUploadProgress();
                    final List<InputStream> list4 = list3;
                    OperationQueue.sharedInstance().addParallelOperation(new Runnable() {
                        /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c2, code lost:
                            if (r8 == null) goto L_0x00c5;
                         */
                        /* JADX WARNING: Removed duplicated region for block: B:31:0x0094 A[Catch:{ JSONException -> 0x00b1, SocketTimeoutException -> 0x009a, Exception -> 0x0086, all -> 0x0081, all -> 0x00ee }] */
                        /* JADX WARNING: Removed duplicated region for block: B:33:0x0099 A[Catch:{ JSONException -> 0x00b1, SocketTimeoutException -> 0x009a, Exception -> 0x0086, all -> 0x0081, all -> 0x00ee }] */
                        /* JADX WARNING: Removed duplicated region for block: B:38:0x00ab A[Catch:{ JSONException -> 0x00b1, SocketTimeoutException -> 0x009a, Exception -> 0x0086, all -> 0x0081, all -> 0x00ee }] */
                        /* JADX WARNING: Removed duplicated region for block: B:40:0x00b0 A[Catch:{ JSONException -> 0x00b1, SocketTimeoutException -> 0x009a, Exception -> 0x0086, all -> 0x0081, all -> 0x00ee }] */
                        /* JADX WARNING: Removed duplicated region for block: B:45:0x00bf A[Catch:{ JSONException -> 0x00b1, SocketTimeoutException -> 0x009a, Exception -> 0x0086, all -> 0x0081, all -> 0x00ee }] */
                        /* JADX WARNING: Removed duplicated region for block: B:51:0x00d1 A[LOOP:0: B:49:0x00cb->B:51:0x00d1, LOOP_END] */
                        /* JADX WARNING: Removed duplicated region for block: B:57:0x00f1  */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public void run() {
                            /*
                                r9 = this;
                                com.leanplum.internal.FileTransferManager r0 = com.leanplum.internal.FileTransferManager.this
                                java.lang.Object r0 = r0.uploadFileLock
                                monitor-enter(r0)
                                r1 = 0
                                com.leanplum.internal.http.UploadOperation r8 = new com.leanplum.internal.http.UploadOperation     // Catch:{ JSONException -> 0x00b1, SocketTimeoutException -> 0x009a, Exception -> 0x0086, all -> 0x0081 }
                                com.leanplum.internal.APIConfig r2 = com.leanplum.internal.APIConfig.getInstance()     // Catch:{ JSONException -> 0x00b1, SocketTimeoutException -> 0x009a, Exception -> 0x0086, all -> 0x0081 }
                                java.lang.String r3 = r2.getApiHost()     // Catch:{ JSONException -> 0x00b1, SocketTimeoutException -> 0x009a, Exception -> 0x0086, all -> 0x0081 }
                                com.leanplum.internal.APIConfig r2 = com.leanplum.internal.APIConfig.getInstance()     // Catch:{ JSONException -> 0x00b1, SocketTimeoutException -> 0x009a, Exception -> 0x0086, all -> 0x0081 }
                                java.lang.String r4 = r2.getApiPath()     // Catch:{ JSONException -> 0x00b1, SocketTimeoutException -> 0x009a, Exception -> 0x0086, all -> 0x0081 }
                                com.leanplum.internal.Request r2 = r2     // Catch:{ JSONException -> 0x00b1, SocketTimeoutException -> 0x009a, Exception -> 0x0086, all -> 0x0081 }
                                java.lang.String r5 = r2.getHttpMethod()     // Catch:{ JSONException -> 0x00b1, SocketTimeoutException -> 0x009a, Exception -> 0x0086, all -> 0x0081 }
                                com.leanplum.internal.APIConfig r2 = com.leanplum.internal.APIConfig.getInstance()     // Catch:{ JSONException -> 0x00b1, SocketTimeoutException -> 0x009a, Exception -> 0x0086, all -> 0x0081 }
                                boolean r6 = r2.getApiSSL()     // Catch:{ JSONException -> 0x00b1, SocketTimeoutException -> 0x009a, Exception -> 0x0086, all -> 0x0081 }
                                r7 = 60
                                r2 = r8
                                r2.<init>(r3, r4, r5, r6, r7)     // Catch:{ JSONException -> 0x00b1, SocketTimeoutException -> 0x009a, Exception -> 0x0086, all -> 0x0081 }
                                java.util.List r1 = r3     // Catch:{ JSONException -> 0x007f, SocketTimeoutException -> 0x007d, Exception -> 0x007b }
                                java.util.List r2 = r4     // Catch:{ JSONException -> 0x007f, SocketTimeoutException -> 0x007d, Exception -> 0x007b }
                                java.util.Map r3 = r5     // Catch:{ JSONException -> 0x007f, SocketTimeoutException -> 0x007d, Exception -> 0x007b }
                                boolean r1 = r8.uploadFiles(r1, r2, r3)     // Catch:{ JSONException -> 0x007f, SocketTimeoutException -> 0x007d, Exception -> 0x007b }
                                if (r1 == 0) goto L_0x0067
                                org.json.b r1 = r8.getJsonResponse()     // Catch:{ JSONException -> 0x007f, SocketTimeoutException -> 0x007d, Exception -> 0x007b }
                                int r2 = r8.getResponseCode()     // Catch:{ JSONException -> 0x007f, SocketTimeoutException -> 0x007d, Exception -> 0x007b }
                                r3 = 200(0xc8, float:2.8E-43)
                                if (r2 != r3) goto L_0x0050
                                com.leanplum.internal.Request r2 = r2     // Catch:{ JSONException -> 0x007f, SocketTimeoutException -> 0x007d, Exception -> 0x007b }
                                com.leanplum.internal.Request$ResponseCallback r2 = r2.response     // Catch:{ JSONException -> 0x007f, SocketTimeoutException -> 0x007d, Exception -> 0x007b }
                                if (r2 == 0) goto L_0x0077
                                r2.response(r1)     // Catch:{ JSONException -> 0x007f, SocketTimeoutException -> 0x007d, Exception -> 0x007b }
                                goto L_0x0077
                            L_0x0050:
                                java.lang.Exception r1 = new java.lang.Exception     // Catch:{ JSONException -> 0x007f, SocketTimeoutException -> 0x007d, Exception -> 0x007b }
                                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x007f, SocketTimeoutException -> 0x007d, Exception -> 0x007b }
                                r3.<init>()     // Catch:{ JSONException -> 0x007f, SocketTimeoutException -> 0x007d, Exception -> 0x007b }
                                java.lang.String r4 = "Leanplum: Error sending request: "
                                r3.append(r4)     // Catch:{ JSONException -> 0x007f, SocketTimeoutException -> 0x007d, Exception -> 0x007b }
                                r3.append(r2)     // Catch:{ JSONException -> 0x007f, SocketTimeoutException -> 0x007d, Exception -> 0x007b }
                                java.lang.String r2 = r3.toString()     // Catch:{ JSONException -> 0x007f, SocketTimeoutException -> 0x007d, Exception -> 0x007b }
                                r1.<init>(r2)     // Catch:{ JSONException -> 0x007f, SocketTimeoutException -> 0x007d, Exception -> 0x007b }
                                throw r1     // Catch:{ JSONException -> 0x007f, SocketTimeoutException -> 0x007d, Exception -> 0x007b }
                            L_0x0067:
                                com.leanplum.internal.Request r1 = r2     // Catch:{ JSONException -> 0x007f, SocketTimeoutException -> 0x007d, Exception -> 0x007b }
                                com.leanplum.internal.Request$ErrorCallback r1 = r1.error     // Catch:{ JSONException -> 0x007f, SocketTimeoutException -> 0x007d, Exception -> 0x007b }
                                if (r1 == 0) goto L_0x0077
                                java.lang.Exception r2 = new java.lang.Exception     // Catch:{ JSONException -> 0x007f, SocketTimeoutException -> 0x007d, Exception -> 0x007b }
                                java.lang.String r3 = "Leanplum: Unable to read file."
                                r2.<init>(r3)     // Catch:{ JSONException -> 0x007f, SocketTimeoutException -> 0x007d, Exception -> 0x007b }
                                r1.error(r2)     // Catch:{ JSONException -> 0x007f, SocketTimeoutException -> 0x007d, Exception -> 0x007b }
                            L_0x0077:
                                r8.disconnect()     // Catch:{ all -> 0x00f5 }
                                goto L_0x00c5
                            L_0x007b:
                                r1 = move-exception
                                goto L_0x0089
                            L_0x007d:
                                r1 = move-exception
                                goto L_0x009d
                            L_0x007f:
                                r1 = move-exception
                                goto L_0x00b4
                            L_0x0081:
                                r2 = move-exception
                                r8 = r1
                                r1 = r2
                                goto L_0x00ef
                            L_0x0086:
                                r2 = move-exception
                                r8 = r1
                                r1 = r2
                            L_0x0089:
                                java.lang.String r2 = "Unable to send file."
                                com.leanplum.internal.Log.e((java.lang.String) r2, (java.lang.Throwable) r1)     // Catch:{ all -> 0x00ee }
                                com.leanplum.internal.Request r2 = r2     // Catch:{ all -> 0x00ee }
                                com.leanplum.internal.Request$ErrorCallback r2 = r2.error     // Catch:{ all -> 0x00ee }
                                if (r2 == 0) goto L_0x0097
                                r2.error(r1)     // Catch:{ all -> 0x00ee }
                            L_0x0097:
                                if (r8 == 0) goto L_0x00c5
                                goto L_0x0077
                            L_0x009a:
                                r2 = move-exception
                                r8 = r1
                                r1 = r2
                            L_0x009d:
                                java.lang.String r2 = "Timeout uploading files. Try again or limit the number of files to upload with parameters to syncResourcesAsync."
                                r3 = 0
                                java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x00ee }
                                com.leanplum.internal.Log.e((java.lang.String) r2, (java.lang.Object[]) r3)     // Catch:{ all -> 0x00ee }
                                com.leanplum.internal.Request r2 = r2     // Catch:{ all -> 0x00ee }
                                com.leanplum.internal.Request$ErrorCallback r2 = r2.error     // Catch:{ all -> 0x00ee }
                                if (r2 == 0) goto L_0x00ae
                                r2.error(r1)     // Catch:{ all -> 0x00ee }
                            L_0x00ae:
                                if (r8 == 0) goto L_0x00c5
                                goto L_0x0077
                            L_0x00b1:
                                r2 = move-exception
                                r8 = r1
                                r1 = r2
                            L_0x00b4:
                                java.lang.String r2 = "Unable to convert to JSON."
                                com.leanplum.internal.Log.e((java.lang.String) r2, (java.lang.Throwable) r1)     // Catch:{ all -> 0x00ee }
                                com.leanplum.internal.Request r2 = r2     // Catch:{ all -> 0x00ee }
                                com.leanplum.internal.Request$ErrorCallback r2 = r2.error     // Catch:{ all -> 0x00ee }
                                if (r2 == 0) goto L_0x00c2
                                r2.error(r1)     // Catch:{ all -> 0x00ee }
                            L_0x00c2:
                                if (r8 == 0) goto L_0x00c5
                                goto L_0x0077
                            L_0x00c5:
                                java.util.List r1 = r3     // Catch:{ all -> 0x00f5 }
                                java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x00f5 }
                            L_0x00cb:
                                boolean r2 = r1.hasNext()     // Catch:{ all -> 0x00f5 }
                                if (r2 == 0) goto L_0x00e7
                                java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x00f5 }
                                java.io.File r2 = (java.io.File) r2     // Catch:{ all -> 0x00f5 }
                                com.leanplum.internal.FileTransferManager r3 = com.leanplum.internal.FileTransferManager.this     // Catch:{ all -> 0x00f5 }
                                java.util.Map r3 = r3.fileUploadProgress     // Catch:{ all -> 0x00f5 }
                                r4 = 4607182418800017408(0x3ff0000000000000, double:1.0)
                                java.lang.Double r4 = java.lang.Double.valueOf(r4)     // Catch:{ all -> 0x00f5 }
                                r3.put(r2, r4)     // Catch:{ all -> 0x00f5 }
                                goto L_0x00cb
                            L_0x00e7:
                                com.leanplum.internal.FileTransferManager r1 = com.leanplum.internal.FileTransferManager.this     // Catch:{ all -> 0x00f5 }
                                r1.printUploadProgress()     // Catch:{ all -> 0x00f5 }
                                monitor-exit(r0)     // Catch:{ all -> 0x00f5 }
                                return
                            L_0x00ee:
                                r1 = move-exception
                            L_0x00ef:
                                if (r8 == 0) goto L_0x00f4
                                r8.disconnect()     // Catch:{ all -> 0x00f5 }
                            L_0x00f4:
                                throw r1     // Catch:{ all -> 0x00f5 }
                            L_0x00f5:
                                r1 = move-exception
                                monitor-exit(r0)     // Catch:{ all -> 0x00f5 }
                                throw r1
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.leanplum.internal.FileTransferManager.AnonymousClass2.run():void");
                        }
                    });
                }
            }
        }
    }
}
