package tm;

import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import zm.f;

public class c extends a {

    /* renamed from: d  reason: collision with root package name */
    public static final d f33879d = new c();

    protected c() {
        super(c.class.getSimpleName(), 1000);
    }

    public List<String> L() {
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class});
            ArrayList arrayList = new ArrayList(5);
            String[] strArr = {"net.dns1", "net.dns2", "net.dns3", "net.dns4"};
            for (int i10 = 0; i10 < 4; i10++) {
                String str = (String) method.invoke((Object) null, new Object[]{strArr[i10]});
                if (str != null) {
                    if (str.length() != 0) {
                        if (!arrayList.contains(str)) {
                            InetAddress byName = InetAddress.getByName(str);
                            if (byName != null) {
                                String hostAddress = byName.getHostAddress();
                                if (hostAddress != null) {
                                    if (hostAddress.length() != 0) {
                                        if (!arrayList.contains(hostAddress)) {
                                            arrayList.add(hostAddress);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (arrayList.size() > 0) {
                return arrayList;
            }
            return null;
        } catch (Exception e10) {
            a.f33875c.log(Level.WARNING, "Exception in findDNSByReflection", e10);
        }
    }

    public boolean isAvailable() {
        return f.a();
    }
}
