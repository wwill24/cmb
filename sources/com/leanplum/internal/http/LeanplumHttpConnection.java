package com.leanplum.internal.http;

import android.content.Context;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.leanplum.Leanplum;
import com.leanplum.internal.APIConfig;
import com.leanplum.internal.Constants;
import com.leanplum.internal.Util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import net.bytebuddy.jar.asm.Opcodes;
import org.json.JSONException;
import org.json.b;
import org.json.h;

public abstract class LeanplumHttpConnection {
    protected HttpURLConnection urlConnection;

    private String createUserAgent() {
        String createUserAgentString = createUserAgentString();
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < createUserAgentString.length(); i10++) {
            char charAt = createUserAgentString.charAt(i10);
            if (charAt == 9 || (' ' <= charAt && charAt <= '~')) {
                sb2.append(charAt);
            }
        }
        return sb2.toString();
    }

    private String createUserAgentString() {
        Context context = Leanplum.getContext();
        return Util.getApplicationName(context) + RemoteSettings.FORWARD_SLASH_STRING + Util.getVersionName() + RemoteSettings.FORWARD_SLASH_STRING + APIConfig.getInstance().appId() + RemoteSettings.FORWARD_SLASH_STRING + Constants.CLIENT + RemoteSettings.FORWARD_SLASH_STRING + Constants.LEANPLUM_VERSION + RemoteSettings.FORWARD_SLASH_STRING + Util.getSystemName() + RemoteSettings.FORWARD_SLASH_STRING + Util.getSystemVersion() + RemoteSettings.FORWARD_SLASH_STRING + Constants.LEANPLUM_SUPPORTED_ENCODING + RemoteSettings.FORWARD_SLASH_STRING + "s";
    }

    private boolean isGzipCompressed() {
        String headerField = this.urlConnection.getHeaderField("content-encoding");
        if (headerField != null) {
            return headerField.trim().equalsIgnoreCase(Constants.LEANPLUM_SUPPORTED_ENCODING);
        }
        return false;
    }

    public void connect() throws IOException {
        this.urlConnection.connect();
    }

    public void disconnect() {
        this.urlConnection.disconnect();
    }

    public b getJsonResponse() throws JSONException, IOException {
        return new b(new h(getResponse()));
    }

    public String getResponse() throws IOException {
        GZIPInputStream gZIPInputStream;
        if (this.urlConnection.getResponseCode() < 400) {
            gZIPInputStream = this.urlConnection.getInputStream();
        } else {
            gZIPInputStream = this.urlConnection.getErrorStream();
        }
        if (isGzipCompressed()) {
            gZIPInputStream = new GZIPInputStream(gZIPInputStream);
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(gZIPInputStream, "UTF-8"));
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb2.append(readLine);
                sb2.append("\n");
            } else {
                try {
                    break;
                } catch (Exception unused) {
                }
            }
        }
        gZIPInputStream.close();
        bufferedReader.close();
        return sb2.toString();
    }

    public int getResponseCode() throws IOException {
        return this.urlConnection.getResponseCode();
    }

    public URL getURL() {
        return this.urlConnection.getURL();
    }

    /* access modifiers changed from: protected */
    public void initConnection(String str, String str2, String str3, boolean z10, int i10) throws IOException {
        if (str2 == null || !str2.startsWith("http")) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(z10 ? "https://" : "http://");
            sb2.append(str);
            sb2.append(RemoteSettings.FORWARD_SLASH_STRING);
            sb2.append(str2);
            str2 = sb2.toString();
        }
        initConnection(str2, str3, z10, i10);
    }

    public void saveResponse(OutputStream outputStream) throws IOException {
        InputStream inputStream = this.urlConnection.getInputStream();
        if (isGzipCompressed()) {
            inputStream = new GZIPInputStream(inputStream);
        }
        byte[] bArr = new byte[Opcodes.ACC_SYNTHETIC];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                outputStream.close();
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void initConnection(String str, String str2, boolean z10, int i10) throws IOException {
        this.urlConnection = (HttpURLConnection) new URL(str).openConnection();
        if (z10) {
            ((HttpsURLConnection) this.urlConnection).setSSLSocketFactory((SSLSocketFactory) SSLSocketFactory.getDefault());
        }
        int i11 = i10 * 1000;
        this.urlConnection.setReadTimeout(i11);
        this.urlConnection.setConnectTimeout(i11);
        this.urlConnection.setRequestMethod(str2);
        this.urlConnection.setDoOutput("POST".equals(str2));
        this.urlConnection.setDoInput(true);
        this.urlConnection.setUseCaches(false);
        this.urlConnection.setInstanceFollowRedirects(true);
        this.urlConnection.setRequestProperty("User-Agent", createUserAgent());
        this.urlConnection.setRequestProperty("Accept-Encoding", Constants.LEANPLUM_SUPPORTED_ENCODING);
    }
}
