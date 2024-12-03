package com.leanplum.internal.http;

import com.facebook.stetho.server.http.HttpHeaders;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class UploadOperation extends LeanplumHttpConnection {
    private static final String BOUNDARY = "==================================leanplum";
    private static final String CONTENT_TYPE = "Content-Type: application/octet-stream";
    private static final String LINE_END = "\r\n";
    private static final String TWO_HYPHENS = "--";

    public UploadOperation(String str, String str2, String str3, boolean z10, int i10) throws IOException {
        initConnection(str, str2, str3, z10, i10);
    }

    private void writeEnd(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeBytes("--==================================leanplum--\r\n");
    }

    private boolean writeFile(DataOutputStream dataOutputStream, String str, String str2, InputStream inputStream, int i10) throws IOException {
        writeFileHeader(dataOutputStream, str, i10);
        if (!writeFileContent(dataOutputStream, str2, inputStream)) {
            return false;
        }
        writeFileEnd(dataOutputStream);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002d, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        com.leanplum.internal.Log.d("Unable to read file while uploading " + r7, new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0060, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0061, code lost:
        if (r8 != null) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0067, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0068, code lost:
        com.leanplum.internal.Log.d("Failed to close InputStream: " + r7, new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007c, code lost:
        throw r6;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean writeFileContent(java.io.DataOutputStream r6, java.lang.String r7, java.io.InputStream r8) throws java.io.IOException {
        /*
            r5 = this;
            java.lang.String r0 = "Failed to close InputStream: "
            r1 = 4096(0x1000, float:5.74E-42)
            byte[] r1 = new byte[r1]
        L_0x0006:
            r2 = 0
            int r3 = r8.read(r1)     // Catch:{ NullPointerException -> 0x002f }
            r4 = -1
            if (r3 == r4) goto L_0x0012
            r6.write(r1, r2, r3)     // Catch:{ NullPointerException -> 0x002f }
            goto L_0x0006
        L_0x0012:
            r8.close()     // Catch:{ IOException -> 0x0016 }
            goto L_0x002b
        L_0x0016:
            r6 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r0)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            java.lang.Object[] r7 = new java.lang.Object[r2]
            com.leanplum.internal.Log.d(r6, r7)
        L_0x002b:
            r6 = 1
            return r6
        L_0x002d:
            r6 = move-exception
            goto L_0x0061
        L_0x002f:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x002d }
            r6.<init>()     // Catch:{ all -> 0x002d }
            java.lang.String r1 = "Unable to read file while uploading "
            r6.append(r1)     // Catch:{ all -> 0x002d }
            r6.append(r7)     // Catch:{ all -> 0x002d }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x002d }
            java.lang.Object[] r7 = new java.lang.Object[r2]     // Catch:{ all -> 0x002d }
            com.leanplum.internal.Log.d(r6, r7)     // Catch:{ all -> 0x002d }
            if (r8 == 0) goto L_0x0060
            r8.close()     // Catch:{ IOException -> 0x004b }
            goto L_0x0060
        L_0x004b:
            r6 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r0)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            java.lang.Object[] r7 = new java.lang.Object[r2]
            com.leanplum.internal.Log.d(r6, r7)
        L_0x0060:
            return r2
        L_0x0061:
            if (r8 == 0) goto L_0x007c
            r8.close()     // Catch:{ IOException -> 0x0067 }
            goto L_0x007c
        L_0x0067:
            r7 = move-exception
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r0)
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            java.lang.Object[] r8 = new java.lang.Object[r2]
            com.leanplum.internal.Log.d(r7, r8)
        L_0x007c:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.leanplum.internal.http.UploadOperation.writeFileContent(java.io.DataOutputStream, java.lang.String, java.io.InputStream):boolean");
    }

    private void writeFileEnd(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeBytes(LINE_END);
    }

    private void writeFileHeader(DataOutputStream dataOutputStream, String str, int i10) throws IOException {
        String format2 = String.format(Locale.getDefault(), "Content-Disposition: form-data; name=\"%s%d\";filename=\"%s\"", new Object[]{"file", Integer.valueOf(i10), str});
        dataOutputStream.writeBytes("--==================================leanplum\r\n" + format2 + LINE_END + CONTENT_TYPE + LINE_END + LINE_END);
    }

    private void writeHeader(DataOutputStream dataOutputStream, Map<String, Object> map) throws IOException {
        for (Map.Entry next : map.entrySet()) {
            dataOutputStream.writeBytes("--==================================leanplum\r\nContent-Disposition: form-data; name=\"" + ((String) next.getKey()) + "\"" + LINE_END + LINE_END + next.getValue() + LINE_END);
        }
    }

    public boolean uploadFiles(List<File> list, List<InputStream> list2, Map<String, Object> map) throws IOException {
        InputStream inputStream;
        this.urlConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "multipart/form-data; boundary===================================leanplum");
        this.urlConnection.setRequestProperty("Connection", "Keep-Alive");
        DataOutputStream dataOutputStream = new DataOutputStream(this.urlConnection.getOutputStream());
        writeHeader(dataOutputStream, map);
        for (int i10 = 0; i10 < list.size(); i10++) {
            File file = list.get(i10);
            if (i10 < list2.size()) {
                inputStream = list2.get(i10);
            } else {
                inputStream = new FileInputStream(file);
            }
            if (!writeFile(dataOutputStream, file.getName(), file.getPath(), inputStream, i10)) {
                return false;
            }
        }
        writeEnd(dataOutputStream);
        dataOutputStream.flush();
        dataOutputStream.close();
        return true;
    }
}
