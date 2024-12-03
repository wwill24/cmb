package um;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.RouteInfo;
import java.util.ArrayList;
import java.util.List;

public class a extends tm.a {

    /* renamed from: d  reason: collision with root package name */
    private final ConnectivityManager f33894d;

    public a(Context context) {
        super(a.class.getSimpleName(), 998);
        this.f33894d = (ConnectivityManager) context.getSystemService("connectivity");
    }

    @TargetApi(23)
    private List<String> c() {
        LinkProperties linkProperties;
        Network activeNetwork = this.f33894d.getActiveNetwork();
        if (activeNetwork == null || (linkProperties = this.f33894d.getLinkProperties(activeNetwork)) == null) {
            return null;
        }
        return tm.a.b(linkProperties.getDnsServers());
    }

    @TargetApi(21)
    private static boolean d(LinkProperties linkProperties) {
        for (RouteInfo isDefaultRoute : linkProperties.getRoutes()) {
            if (isDefaultRoute.isDefaultRoute()) {
                return true;
            }
        }
        return false;
    }

    public static a e(Context context) {
        a aVar = new a(context);
        org.minidns.a.q(aVar);
        return aVar;
    }

    @TargetApi(21)
    public List<String> L() {
        List<String> c10 = c();
        if (c10 != null) {
            return c10;
        }
        Network[] allNetworks = this.f33894d.getAllNetworks();
        if (allNetworks == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(allNetworks.length * 2);
        for (Network linkProperties : allNetworks) {
            LinkProperties linkProperties2 = this.f33894d.getLinkProperties(linkProperties);
            if (linkProperties2 != null) {
                if (d(linkProperties2)) {
                    arrayList.addAll(0, tm.a.b(linkProperties2.getDnsServers()));
                } else {
                    arrayList.addAll(tm.a.b(linkProperties2.getDnsServers()));
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    public boolean isAvailable() {
        return true;
    }
}
