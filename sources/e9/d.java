package e9;

import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.metrics.HttpMetric;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import okhttp3.a0;
import okhttp3.u;
import okhttp3.y;

public class d implements u {
    private URL a(URL url) {
        try {
            return new URI(url.getProtocol(), url.getHost(), url.getPath(), (String) null).toURL();
        } catch (Exception unused) {
            return null;
        }
    }

    public a0 intercept(u.a aVar) throws IOException {
        long j10;
        y g10 = aVar.g();
        URL a10 = a(g10.j().u());
        if (g10.a() == null) {
            j10 = 0;
        } else {
            j10 = g10.a().a();
        }
        HttpMetric newHttpMetric = FirebasePerformance.getInstance().newHttpMetric(a10, g10.g());
        newHttpMetric.setRequestPayloadSize(j10);
        newHttpMetric.start();
        a0 a11 = aVar.a(aVar.g());
        newHttpMetric.setHttpResponseCode(a11.f());
        newHttpMetric.stop();
        return a11;
    }
}
