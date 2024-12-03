package fd;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import com.google.android.datatransport.runtime.backends.TransportBackendDiscovery;
import com.mparticle.kits.AppsFlyerKit;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class i implements d {

    /* renamed from: a  reason: collision with root package name */
    private final a f40809a;

    /* renamed from: b  reason: collision with root package name */
    private final g f40810b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, k> f40811c;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        private final Context f40812a;

        /* renamed from: b  reason: collision with root package name */
        private Map<String, String> f40813b = null;

        a(Context context) {
            this.f40812a = context;
        }

        private Map<String, String> a(Context context) {
            Bundle d10 = d(context);
            if (d10 == null) {
                return Collections.emptyMap();
            }
            HashMap hashMap = new HashMap();
            for (String next : d10.keySet()) {
                Object obj = d10.get(next);
                if ((obj instanceof String) && next.startsWith("backend:")) {
                    for (String trim : ((String) obj).split(AppsFlyerKit.COMMA, -1)) {
                        String trim2 = trim.trim();
                        if (!trim2.isEmpty()) {
                            hashMap.put(trim2, next.substring(8));
                        }
                    }
                }
            }
            return hashMap;
        }

        private Map<String, String> c() {
            if (this.f40813b == null) {
                this.f40813b = a(this.f40812a);
            }
            return this.f40813b;
        }

        private static Bundle d(Context context) {
            ServiceInfo serviceInfo;
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null || (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, TransportBackendDiscovery.class), 128)) == null) {
                    return null;
                }
                return serviceInfo.metaData;
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        /* access modifiers changed from: package-private */
        public c b(String str) {
            String str2 = c().get(str);
            if (str2 == null) {
                return null;
            }
            try {
                return (c) Class.forName(str2).asSubclass(c.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException unused) {
                String.format("Class %s is not found.", new Object[]{str2});
                return null;
            } catch (IllegalAccessException unused2) {
                String.format("Could not instantiate %s.", new Object[]{str2});
                return null;
            } catch (InstantiationException unused3) {
                String.format("Could not instantiate %s.", new Object[]{str2});
                return null;
            } catch (NoSuchMethodException unused4) {
                String.format("Could not instantiate %s", new Object[]{str2});
                return null;
            } catch (InvocationTargetException unused5) {
                String.format("Could not instantiate %s", new Object[]{str2});
                return null;
            }
        }
    }

    i(Context context, g gVar) {
        this(new a(context), gVar);
    }

    public synchronized k get(String str) {
        if (this.f40811c.containsKey(str)) {
            return this.f40811c.get(str);
        }
        c b10 = this.f40809a.b(str);
        if (b10 == null) {
            return null;
        }
        k create = b10.create(this.f40810b.a(str));
        this.f40811c.put(str, create);
        return create;
    }

    i(a aVar, g gVar) {
        this.f40811c = new HashMap();
        this.f40809a = aVar;
        this.f40810b = gVar;
    }
}
