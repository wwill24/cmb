package com.google.android.recaptcha.internal;

import android.net.TrafficStats;
import android.webkit.URLUtil;
import com.facebook.stetho.server.http.HttpHeaders;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import kotlin.jvm.internal.j;

public final class zzaq implements zzap {
    private final String zza;

    public zzaq(String str) {
        this.zza = str;
    }

    private static final void zzb(byte[] bArr) {
        for (zzkx zzkx : zzla.zzi(bArr).zzj()) {
            if (!q.m("INIT_TOTAL", "EXECUTE_TOTAL").contains(zzkx.zzj().name()) || !zzkx.zzS()) {
                zzkx.zzH();
                zzkx.zzI();
                zzkx.zzj().name();
                zzkx.zzT();
            } else {
                zzkx.zzH();
                zzkx.zzI();
                zzkx.zzj().name();
                zzkx.zzg().zzk();
                zzkx.zzg().zzf();
                zzkx.zzT();
            }
        }
    }

    public final boolean zza(byte[] bArr) {
        HttpURLConnection httpURLConnection;
        try {
            TrafficStats.setThreadStatsTag((int) Thread.currentThread().getId());
            zzb(bArr);
            if (URLUtil.isHttpUrl(this.zza)) {
                URLConnection openConnection = new URL(this.zza).openConnection();
                j.e(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
                httpURLConnection = (HttpURLConnection) openConnection;
            } else if (URLUtil.isHttpsUrl(this.zza)) {
                URLConnection openConnection2 = new URL(this.zza).openConnection();
                j.e(openConnection2, "null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
                httpURLConnection = (HttpsURLConnection) openConnection2;
            } else {
                throw new MalformedURLException("Recaptcha server url only allows using Http or Https.");
            }
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/x-protobuffer");
            httpURLConnection.connect();
            httpURLConnection.getOutputStream().write(bArr);
            if (httpURLConnection.getResponseCode() == 200) {
                return true;
            }
            return false;
        } catch (Exception e10) {
            e10.getMessage();
            return false;
        }
    }
}
