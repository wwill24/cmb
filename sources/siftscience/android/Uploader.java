package siftscience.android;

import android.util.Base64;
import com.facebook.stetho.server.http.HttpHeaders;
import com.google.firebase.perf.FirebasePerformance;
import com.sift.api.representations.ListRequestJson;
import com.sift.api.representations.MobileEventJson;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPOutputStream;
import siftscience.android.Sift;

public class Uploader {
    private static final long BACKOFF_EXPONENT = 2;
    private static final long BACKOFF_MULTIPLIER;
    private static final TimeUnit BACKOFF_UNIT;
    private static final int MAX_BYTES = 4096;
    static final int MAX_RETRIES = 3;
    /* access modifiers changed from: private */
    public static final String TAG = "siftscience.android.Uploader";
    private static final Charset US_ASCII = StandardCharsets.US_ASCII;
    private static final Charset UTF8 = StandardCharsets.UTF_8;
    private final ConfigProvider configProvider;
    private final TaskManager taskManager;

    interface ConfigProvider {
        Sift.Config getConfig();
    }

    static class Request {
        /* access modifiers changed from: private */
        public byte[] body;
        /* access modifiers changed from: private */
        public Map<String, String> headers;
        /* access modifiers changed from: private */
        public String method;
        /* access modifiers changed from: private */
        public URL url;

        static class Builder {
            private byte[] body;
            private Map<String, String> headers;
            private String method;
            private URL url;

            Builder() {
            }

            public Request build() {
                return new Request(this.method, this.url, this.headers, this.body);
            }

            /* access modifiers changed from: package-private */
            public Builder withBody(byte[] bArr) {
                this.body = bArr;
                return this;
            }

            /* access modifiers changed from: package-private */
            public Builder withHeaders(Map map) {
                this.headers = map;
                return this;
            }

            /* access modifiers changed from: package-private */
            public Builder withMethod(String str) {
                this.method = str;
                return this;
            }

            /* access modifiers changed from: package-private */
            public Builder withUrl(URL url2) {
                this.url = url2;
                return this;
            }
        }

        Request(String str, URL url2, Map map, byte[] bArr) {
            this.method = str;
            this.url = url2;
            this.headers = map;
            this.body = bArr;
        }
    }

    private class UploadTask implements Runnable {
        private final Request request;
        private int retriesRemaining;
        private Uploader uploader;

        UploadTask(Uploader uploader2, Request request2, int i10) {
            this.uploader = uploader2;
            this.request = request2;
            this.retriesRemaining = i10;
        }

        public void run() {
            OutputStream outputStream;
            InputStream inputStream;
            String unused = Uploader.TAG;
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) this.request.url.openConnection();
                httpURLConnection.setRequestMethod(this.request.method);
                for (Map.Entry entry : this.request.headers.entrySet()) {
                    httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
                httpURLConnection.setFixedLengthStreamingMode(this.request.body.length);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.connect();
                try {
                    outputStream = httpURLConnection.getOutputStream();
                    outputStream.write(this.request.body);
                    outputStream.close();
                    int responseCode = httpURLConnection.getResponseCode();
                    String str = null;
                    if (responseCode >= 400) {
                        inputStream = httpURLConnection.getErrorStream();
                    } else {
                        inputStream = httpURLConnection.getInputStream();
                    }
                    if (inputStream != null) {
                        str = Uploader.this.readInputStreamAsString(inputStream, 4096);
                        inputStream.close();
                    }
                    if (responseCode == 200) {
                        String unused2 = Uploader.TAG;
                    } else if (responseCode == 400) {
                        String unused3 = Uploader.TAG;
                        String.format("HTTP error: status=%d response=%s", new Object[]{Integer.valueOf(responseCode), str});
                    } else {
                        String unused4 = Uploader.TAG;
                        String.format("HTTP error: status=%d response=%s", new Object[]{Integer.valueOf(responseCode), str});
                        this.uploader.doUpload(this.request, this.retriesRemaining - 1);
                    }
                    httpURLConnection.disconnect();
                } catch (Throwable th2) {
                    httpURLConnection.disconnect();
                    throw th2;
                }
            } catch (IOException unused5) {
                String unused6 = Uploader.TAG;
            }
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        BACKOFF_MULTIPLIER = timeUnit.toSeconds(3);
        BACKOFF_UNIT = timeUnit;
    }

    Uploader(TaskManager taskManager2, ConfigProvider configProvider2) {
        this.taskManager = taskManager2;
        this.configProvider = configProvider2;
    }

    /* access modifiers changed from: private */
    public void doUpload(Request request, int i10) {
        if (i10 != 0) {
            this.taskManager.schedule(new UploadTask(this, request, i10), (long) (Math.pow((double) (3 - i10), 2.0d) * ((double) BACKOFF_MULTIPLIER)), BACKOFF_UNIT);
        }
    }

    private Request makeRequest(List<MobileEventJson> list) throws IOException {
        Sift.Config config;
        if (list == null || list.isEmpty() || (config = this.configProvider.getConfig()) == null || !config.isValid()) {
            return null;
        }
        URL url = new URL(String.format(config.serverUrlFormat, new Object[]{config.accountId}));
        String encodeToString = Base64.encodeToString(config.beaconKey.getBytes(US_ASCII), 2);
        HashMap hashMap = new HashMap();
        hashMap.put("Authorization", "Basic " + encodeToString);
        hashMap.put("Accept", "application/json");
        hashMap.put("Content-Encoding", "gzip");
        hashMap.put(HttpHeaders.CONTENT_TYPE, "application/json");
        ListRequestJson withData = new ListRequestJson().withData(Collections.unmodifiableList(list));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new GZIPOutputStream(byteArrayOutputStream), UTF8);
        Sift.GSON.y(withData, outputStreamWriter);
        outputStreamWriter.close();
        String.format("Built HTTP request for batch of size %d", new Object[]{Integer.valueOf(list.size())});
        return new Request.Builder().withMethod(FirebasePerformance.HttpMethod.PUT).withUrl(url).withHeaders(hashMap).withBody(byteArrayOutputStream.toByteArray()).build();
    }

    /* access modifiers changed from: private */
    public String readInputStreamAsString(InputStream inputStream, int i10) throws IOException {
        byte[] bArr = new byte[i10];
        int i11 = 0;
        while (i11 < i10) {
            int read = inputStream.read(bArr, 0, i10 - i11);
            if (read < 0) {
                break;
            }
            i11 += read;
        }
        return new String(bArr, 0, i11, UTF8);
    }

    public void upload(List<MobileEventJson> list) {
        try {
            Request makeRequest = makeRequest(list);
            if (makeRequest != null) {
                String.format("Uploading batch of size %d", new Object[]{Integer.valueOf(list.size())});
                doUpload(makeRequest, 3);
            }
        } catch (IOException unused) {
        }
    }
}
