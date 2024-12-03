package com.google.android.gms.internal.p003firebaseauthapi;

import com.facebook.stetho.server.http.HttpHeaders;
import com.google.android.gms.common.internal.p;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import org.json.JSONException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafh  reason: invalid package */
public final class zzafh {
    public static void zza(String str, zzafe zzafe, Type type, zzaen zzaen) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(60000);
            zzaen.zza(httpURLConnection);
            zzc(httpURLConnection, zzafe, type);
        } catch (SocketTimeoutException unused) {
            zzafe.zza("TIMEOUT");
        } catch (UnknownHostException unused2) {
            zzafe.zza("<<Network Error>>");
        } catch (IOException e10) {
            zzafe.zza(e10.getMessage());
        }
    }

    public static void zzb(String str, zzaej zzaej, zzafe zzafe, Type type, zzaen zzaen) {
        BufferedOutputStream bufferedOutputStream;
        try {
            p.k(zzaej);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoOutput(true);
            byte[] bytes = zzaej.zza().getBytes(Charset.defaultCharset());
            int length = bytes.length;
            httpURLConnection.setFixedLengthStreamingMode(length);
            httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json");
            httpURLConnection.setConnectTimeout(60000);
            zzaen.zza(httpURLConnection);
            bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream(), length);
            bufferedOutputStream.write(bytes, 0, length);
            bufferedOutputStream.close();
            zzc(httpURLConnection, zzafe, type);
            return;
        } catch (SocketTimeoutException unused) {
            zzafe.zza("TIMEOUT");
            return;
        } catch (UnknownHostException unused2) {
            zzafe.zza("<<Network Error>>");
            return;
        } catch (IOException | NullPointerException | JSONException e10) {
            zzafe.zza(e10.getMessage());
            return;
        } catch (Throwable th2) {
            zzafg.zza(th, th2);
        }
        throw th;
    }

    private static void zzc(HttpURLConnection httpURLConnection, zzafe zzafe, Type type) {
        InputStream inputStream;
        BufferedReader bufferedReader;
        try {
            int responseCode = httpURLConnection.getResponseCode();
            if (zzd(responseCode)) {
                inputStream = httpURLConnection.getInputStream();
            } else {
                inputStream = httpURLConnection.getErrorStream();
            }
            StringBuilder sb2 = new StringBuilder();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb2.append(readLine);
            }
            bufferedReader.close();
            String sb3 = sb2.toString();
            if (!zzd(responseCode)) {
                zzafe.zza((String) zzaei.zza(sb3, String.class));
            } else {
                zzafe.zzb((zzaek) zzaei.zza(sb3, type));
            }
            httpURLConnection.disconnect();
            return;
        } catch (SocketTimeoutException unused) {
            zzafe.zza("TIMEOUT");
            httpURLConnection.disconnect();
            return;
        } catch (zzaca | IOException e10) {
            try {
                zzafe.zza(e10.getMessage());
                return;
            } finally {
                httpURLConnection.disconnect();
            }
        } catch (Throwable th2) {
            zzafg.zza(th, th2);
        }
        throw th;
    }

    private static final boolean zzd(int i10) {
        return i10 >= 200 && i10 < 300;
    }
}
