package com.google.android.datatransport.cct;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.stetho.server.http.HttpHeaders;
import com.google.android.datatransport.cct.internal.ClientInfo;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;
import com.google.android.datatransport.cct.internal.QosTier;
import com.google.android.datatransport.cct.internal.i;
import com.google.android.datatransport.cct.internal.j;
import com.google.android.datatransport.cct.internal.k;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.EncodingException;
import com.leanplum.internal.Constants;
import ed.h;
import fd.e;
import fd.k;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.jivesoftware.smackx.json.packet.JsonPacketExtension;

final class d implements k {

    /* renamed from: a  reason: collision with root package name */
    private final DataEncoder f37969a;

    /* renamed from: b  reason: collision with root package name */
    private final ConnectivityManager f37970b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f37971c;

    /* renamed from: d  reason: collision with root package name */
    final URL f37972d;

    /* renamed from: e  reason: collision with root package name */
    private final od.a f37973e;

    /* renamed from: f  reason: collision with root package name */
    private final od.a f37974f;

    /* renamed from: g  reason: collision with root package name */
    private final int f37975g;

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        final URL f37976a;

        /* renamed from: b  reason: collision with root package name */
        final i f37977b;

        /* renamed from: c  reason: collision with root package name */
        final String f37978c;

        a(URL url, i iVar, String str) {
            this.f37976a = url;
            this.f37977b = iVar;
            this.f37978c = str;
        }

        /* access modifiers changed from: package-private */
        public a a(URL url) {
            return new a(url, this.f37977b, this.f37978c);
        }
    }

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        final int f37979a;

        /* renamed from: b  reason: collision with root package name */
        final URL f37980b;

        /* renamed from: c  reason: collision with root package name */
        final long f37981c;

        b(int i10, URL url, long j10) {
            this.f37979a = i10;
            this.f37980b = url;
            this.f37981c = j10;
        }
    }

    d(Context context, od.a aVar, od.a aVar2, int i10) {
        this.f37969a = i.b();
        this.f37971c = context;
        this.f37970b = (ConnectivityManager) context.getSystemService("connectivity");
        this.f37972d = n(a.f37960c);
        this.f37973e = aVar2;
        this.f37974f = aVar;
        this.f37975g = i10;
    }

    /* access modifiers changed from: private */
    public b e(a aVar) throws IOException {
        GZIPOutputStream gZIPOutputStream;
        InputStream m10;
        id.a.f("CctTransportBackend", "Making request to: %s", aVar.f37976a);
        HttpURLConnection httpURLConnection = (HttpURLConnection) aVar.f37976a.openConnection();
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(this.f37975g);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("User-Agent", String.format("datatransport/%s android/", new Object[]{"3.1.9"}));
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json");
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String str = aVar.f37978c;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                gZIPOutputStream = new GZIPOutputStream(outputStream);
                this.f37969a.encode(aVar.f37977b, new BufferedWriter(new OutputStreamWriter(gZIPOutputStream)));
                gZIPOutputStream.close();
                if (outputStream != null) {
                    outputStream.close();
                }
                int responseCode = httpURLConnection.getResponseCode();
                id.a.f("CctTransportBackend", "Status Code: %d", Integer.valueOf(responseCode));
                id.a.b("CctTransportBackend", "Content-Type: %s", httpURLConnection.getHeaderField(HttpHeaders.CONTENT_TYPE));
                id.a.b("CctTransportBackend", "Content-Encoding: %s", httpURLConnection.getHeaderField("Content-Encoding"));
                if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                    return new b(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0);
                }
                if (responseCode != 200) {
                    return new b(responseCode, (URL) null, 0);
                }
                InputStream inputStream = httpURLConnection.getInputStream();
                try {
                    m10 = m(inputStream, httpURLConnection.getHeaderField("Content-Encoding"));
                    b bVar = new b(responseCode, (URL) null, dd.b.b(new BufferedReader(new InputStreamReader(m10))).c());
                    if (m10 != null) {
                        m10.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    return bVar;
                } catch (Throwable th2) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
                throw th;
                throw th;
            } catch (Throwable th4) {
                if (outputStream != null) {
                    outputStream.close();
                }
                throw th4;
            }
        } catch (ConnectException | UnknownHostException e10) {
            id.a.d("CctTransportBackend", "Couldn't open connection, returning with 500", e10);
            return new b(500, (URL) null, 0);
        } catch (EncodingException | IOException e11) {
            id.a.d("CctTransportBackend", "Couldn't encode request, returning with 400", e11);
            return new b(400, (URL) null, 0);
        } catch (Throwable th5) {
            th4.addSuppressed(th5);
        }
    }

    private static int f(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return NetworkConnectionInfo.MobileSubtype.UNKNOWN_MOBILE_SUBTYPE.b();
        }
        int subtype = networkInfo.getSubtype();
        if (subtype == -1) {
            return NetworkConnectionInfo.MobileSubtype.COMBINED.b();
        }
        if (NetworkConnectionInfo.MobileSubtype.a(subtype) != null) {
            return subtype;
        }
        return 0;
    }

    private static int g(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return NetworkConnectionInfo.NetworkType.NONE.b();
        }
        return networkInfo.getType();
    }

    private static int h(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e10) {
            id.a.d("CctTransportBackend", "Unable to find version code for package", e10);
            return -1;
        }
    }

    private i i(e eVar) {
        j.a aVar;
        HashMap hashMap = new HashMap();
        for (ed.i next : eVar.b()) {
            String j10 = next.j();
            if (!hashMap.containsKey(j10)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(next);
                hashMap.put(j10, arrayList);
            } else {
                ((List) hashMap.get(j10)).add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            ed.i iVar = (ed.i) ((List) entry.getValue()).get(0);
            k.a b10 = com.google.android.datatransport.cct.internal.k.a().f(QosTier.DEFAULT).g(this.f37974f.a()).h(this.f37973e.a()).b(ClientInfo.a().c(ClientInfo.ClientType.ANDROID_FIREBASE).b(com.google.android.datatransport.cct.internal.a.a().m(Integer.valueOf(iVar.g("sdk-version"))).j(iVar.b(DeviceRequestsHelper.DEVICE_INFO_MODEL)).f(iVar.b("hardware")).d(iVar.b(DeviceRequestsHelper.DEVICE_INFO_DEVICE)).l(iVar.b("product")).k(iVar.b("os-uild")).h(iVar.b("manufacturer")).e(iVar.b("fingerprint")).c(iVar.b("country")).g(iVar.b(Constants.Keys.LOCALE)).i(iVar.b("mcc_mnc")).b(iVar.b("application_build")).a()).a());
            try {
                b10.i(Integer.parseInt((String) entry.getKey()));
            } catch (NumberFormatException unused) {
                b10.j((String) entry.getKey());
            }
            ArrayList arrayList3 = new ArrayList();
            for (ed.i iVar2 : (List) entry.getValue()) {
                h e10 = iVar2.e();
                cd.b b11 = e10.b();
                if (b11.equals(cd.b.b("proto"))) {
                    aVar = j.j(e10.a());
                } else if (b11.equals(cd.b.b(JsonPacketExtension.ELEMENT))) {
                    aVar = j.i(new String(e10.a(), Charset.forName("UTF-8")));
                } else {
                    id.a.g("CctTransportBackend", "Received event of unsupported encoding %s. Skipping...", b11);
                }
                aVar.c(iVar2.f()).d(iVar2.k()).h(iVar2.h("tz-offset")).e(NetworkConnectionInfo.a().c(NetworkConnectionInfo.NetworkType.a(iVar2.g("net-type"))).b(NetworkConnectionInfo.MobileSubtype.a(iVar2.g("mobile-subtype"))).a());
                if (iVar2.d() != null) {
                    aVar.b(iVar2.d());
                }
                arrayList3.add(aVar.a());
            }
            b10.c(arrayList3);
            arrayList2.add(b10.a());
        }
        return i.a(arrayList2);
    }

    private static TelephonyManager j(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    static long k() {
        Calendar.getInstance();
        return (long) (TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ a l(a aVar, b bVar) {
        URL url = bVar.f37980b;
        if (url == null) {
            return null;
        }
        id.a.b("CctTransportBackend", "Following redirect to: %s", url);
        return aVar.a(bVar.f37980b);
    }

    private static InputStream m(InputStream inputStream, String str) throws IOException {
        if ("gzip".equals(str)) {
            return new GZIPInputStream(inputStream);
        }
        return inputStream;
    }

    private static URL n(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e10) {
            throw new IllegalArgumentException("Invalid url: " + str, e10);
        }
    }

    public ed.i a(ed.i iVar) {
        NetworkInfo activeNetworkInfo = this.f37970b.getActiveNetworkInfo();
        return iVar.l().a("sdk-version", Build.VERSION.SDK_INT).c(DeviceRequestsHelper.DEVICE_INFO_MODEL, Build.MODEL).c("hardware", Build.HARDWARE).c(DeviceRequestsHelper.DEVICE_INFO_DEVICE, Build.DEVICE).c("product", Build.PRODUCT).c("os-uild", Build.ID).c("manufacturer", Build.MANUFACTURER).c("fingerprint", Build.FINGERPRINT).b("tz-offset", k()).a("net-type", g(activeNetworkInfo)).a("mobile-subtype", f(activeNetworkInfo)).c("country", Locale.getDefault().getCountry()).c(Constants.Keys.LOCALE, Locale.getDefault().getLanguage()).c("mcc_mnc", j(this.f37971c).getSimOperator()).c("application_build", Integer.toString(h(this.f37971c))).d();
    }

    public BackendResponse b(e eVar) {
        i i10 = i(eVar);
        URL url = this.f37972d;
        String str = null;
        if (eVar.c() != null) {
            try {
                a c10 = a.c(eVar.c());
                if (c10.d() != null) {
                    str = c10.d();
                }
                if (c10.e() != null) {
                    url = n(c10.e());
                }
            } catch (IllegalArgumentException unused) {
                return BackendResponse.a();
            }
        }
        try {
            b bVar = (b) jd.b.a(5, new a(url, i10, str), new b(this), new c());
            int i11 = bVar.f37979a;
            if (i11 == 200) {
                return BackendResponse.e(bVar.f37981c);
            }
            if (i11 < 500) {
                if (i11 != 404) {
                    if (i11 == 400) {
                        return BackendResponse.d();
                    }
                    return BackendResponse.a();
                }
            }
            return BackendResponse.f();
        } catch (IOException e10) {
            id.a.d("CctTransportBackend", "Could not make request to the backend", e10);
            return BackendResponse.f();
        }
    }

    d(Context context, od.a aVar, od.a aVar2) {
        this(context, aVar, aVar2, 130000);
    }
}
