package ce;

import com.facebook.stetho.server.http.HttpHeaders;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.internal.u;
import com.google.android.gms.common.internal.p;
import he.a;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public final class d implements Runnable {

    /* renamed from: c  reason: collision with root package name */
    private static final a f34055c = new a("RevokeAccessOperation", new String[0]);

    /* renamed from: a  reason: collision with root package name */
    private final String f34056a;

    /* renamed from: b  reason: collision with root package name */
    private final u f34057b = new u((com.google.android.gms.common.api.d) null);

    public d(String str) {
        this.f34056a = p.g(str);
    }

    public static f a(String str) {
        if (str == null) {
            return g.a(new Status(4), (com.google.android.gms.common.api.d) null);
        }
        d dVar = new d(str);
        new Thread(dVar).start();
        return dVar.f34057b;
    }

    public final void run() {
        Status status = Status.f38502j;
        try {
            String str = this.f34056a;
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://accounts.google.com/o/oauth2/revoke?token=" + str).openConnection();
            httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                status = Status.f38500g;
            } else {
                f34055c.c("Unable to revoke access!", new Object[0]);
            }
            a aVar = f34055c;
            aVar.a("Response Code: " + responseCode, new Object[0]);
        } catch (IOException e10) {
            f34055c.c("IOException when revoking access: ".concat(String.valueOf(e10.toString())), new Object[0]);
        } catch (Exception e11) {
            f34055c.c("Exception when revoking access: ".concat(String.valueOf(e11.toString())), new Object[0]);
        }
        this.f34057b.setResult(status);
    }
}
