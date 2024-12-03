package com.google.android.gms.internal.gtm;

import com.google.android.gms.tagmanager.zzdh;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

final class zzsc implements zzsd {
    private HttpURLConnection zza;
    private InputStream zzb = null;

    zzsc() {
    }

    public final InputStream zza(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setReadTimeout(20000);
        httpURLConnection.setConnectTimeout(20000);
        this.zza = httpURLConnection;
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == 200) {
            InputStream inputStream = httpURLConnection.getInputStream();
            this.zzb = inputStream;
            return inputStream;
        }
        StringBuilder sb2 = new StringBuilder(25);
        sb2.append("Bad response: ");
        sb2.append(responseCode);
        String sb3 = sb2.toString();
        if (responseCode == 404) {
            throw new FileNotFoundException(sb3);
        } else if (responseCode == 503) {
            throw new zzsf(sb3);
        } else {
            throw new IOException(sb3);
        }
    }

    public final void zzb() {
        String str;
        HttpURLConnection httpURLConnection = this.zza;
        try {
            InputStream inputStream = this.zzb;
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException e10) {
            String valueOf = String.valueOf(e10.getMessage());
            if (valueOf.length() != 0) {
                str = "HttpUrlConnectionNetworkClient: Error when closing http input stream: ".concat(valueOf);
            } else {
                str = new String("HttpUrlConnectionNetworkClient: Error when closing http input stream: ");
            }
            zzdh.zzb(str, e10);
        }
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }
}
