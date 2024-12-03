package io.sentry.protocol;

import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import io.sentry.a1;
import io.sentry.c1;
import io.sentry.h0;
import io.sentry.j4;
import io.sentry.protocol.Device;
import io.sentry.protocol.a;
import io.sentry.protocol.b;
import io.sentry.protocol.e;
import io.sentry.protocol.i;
import io.sentry.protocol.k;
import io.sentry.protocol.q;
import io.sentry.s0;
import io.sentry.util.l;
import io.sentry.vendor.gson.stream.JsonToken;
import io.sentry.y0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jivesoftware.smackx.softwareinfo.form.SoftwareInfoForm;

public final class Contexts extends ConcurrentHashMap<String, Object> implements c1 {
    private static final long serialVersionUID = 252445813254943011L;

    public static final class a implements s0<Contexts> {
        /* renamed from: b */
        public Contexts a(y0 y0Var, h0 h0Var) throws Exception {
            Contexts contexts = new Contexts();
            y0Var.b();
            while (y0Var.J() == JsonToken.NAME) {
                String y10 = y0Var.y();
                y10.hashCode();
                char c10 = 65535;
                switch (y10.hashCode()) {
                    case -1335157162:
                        if (y10.equals(DeviceRequestsHelper.DEVICE_INFO_DEVICE)) {
                            c10 = 0;
                            break;
                        }
                        break;
                    case -340323263:
                        if (y10.equals("response")) {
                            c10 = 1;
                            break;
                        }
                        break;
                    case 3556:
                        if (y10.equals(SoftwareInfoForm.OS)) {
                            c10 = 2;
                            break;
                        }
                        break;
                    case 96801:
                        if (y10.equals("app")) {
                            c10 = 3;
                            break;
                        }
                        break;
                    case 102572:
                        if (y10.equals("gpu")) {
                            c10 = 4;
                            break;
                        }
                        break;
                    case 110620997:
                        if (y10.equals("trace")) {
                            c10 = 5;
                            break;
                        }
                        break;
                    case 150940456:
                        if (y10.equals("browser")) {
                            c10 = 6;
                            break;
                        }
                        break;
                    case 1550962648:
                        if (y10.equals("runtime")) {
                            c10 = 7;
                            break;
                        }
                        break;
                }
                switch (c10) {
                    case 0:
                        contexts.h(new Device.a().a(y0Var, h0Var));
                        break;
                    case 1:
                        contexts.l(new k.a().a(y0Var, h0Var));
                        break;
                    case 2:
                        contexts.k(new i.a().a(y0Var, h0Var));
                        break;
                    case 3:
                        contexts.f(new a.C0361a().a(y0Var, h0Var));
                        break;
                    case 4:
                        contexts.j(new e.a().a(y0Var, h0Var));
                        break;
                    case 5:
                        contexts.n(new j4.a().a(y0Var, h0Var));
                        break;
                    case 6:
                        contexts.g(new b.a().a(y0Var, h0Var));
                        break;
                    case 7:
                        contexts.m(new q.a().a(y0Var, h0Var));
                        break;
                    default:
                        Object B0 = y0Var.B0();
                        if (B0 == null) {
                            break;
                        } else {
                            contexts.put(y10, B0);
                            break;
                        }
                }
            }
            y0Var.h();
            return contexts;
        }
    }

    public Contexts() {
    }

    private <T> T o(String str, Class<T> cls) {
        Object obj = get(str);
        if (cls.isInstance(obj)) {
            return cls.cast(obj);
        }
        return null;
    }

    public a a() {
        return (a) o("app", a.class);
    }

    public Device b() {
        return (Device) o(DeviceRequestsHelper.DEVICE_INFO_DEVICE, Device.class);
    }

    public i c() {
        return (i) o(SoftwareInfoForm.OS, i.class);
    }

    public q d() {
        return (q) o("runtime", q.class);
    }

    public j4 e() {
        return (j4) o("trace", j4.class);
    }

    public void f(a aVar) {
        put("app", aVar);
    }

    public void g(b bVar) {
        put("browser", bVar);
    }

    public void h(Device device) {
        put(DeviceRequestsHelper.DEVICE_INFO_DEVICE, device);
    }

    public void j(e eVar) {
        put("gpu", eVar);
    }

    public void k(i iVar) {
        put(SoftwareInfoForm.OS, iVar);
    }

    public void l(k kVar) {
        put("response", kVar);
    }

    public void m(q qVar) {
        put("runtime", qVar);
    }

    public void n(j4 j4Var) {
        l.c(j4Var, "traceContext is required");
        put("trace", j4Var);
    }

    public void serialize(a1 a1Var, h0 h0Var) throws IOException {
        a1Var.e();
        ArrayList<String> list = Collections.list(keys());
        Collections.sort(list);
        for (String str : list) {
            Object obj = get(str);
            if (obj != null) {
                a1Var.N(str).O(h0Var, obj);
            }
        }
        a1Var.h();
    }

    public Contexts(Contexts contexts) {
        for (Map.Entry entry : contexts.entrySet()) {
            if (entry != null) {
                Object value = entry.getValue();
                if ("app".equals(entry.getKey()) && (value instanceof a)) {
                    f(new a((a) value));
                } else if ("browser".equals(entry.getKey()) && (value instanceof b)) {
                    g(new b((b) value));
                } else if (DeviceRequestsHelper.DEVICE_INFO_DEVICE.equals(entry.getKey()) && (value instanceof Device)) {
                    h(new Device((Device) value));
                } else if (SoftwareInfoForm.OS.equals(entry.getKey()) && (value instanceof i)) {
                    k(new i((i) value));
                } else if ("runtime".equals(entry.getKey()) && (value instanceof q)) {
                    m(new q((q) value));
                } else if ("gpu".equals(entry.getKey()) && (value instanceof e)) {
                    j(new e((e) value));
                } else if ("trace".equals(entry.getKey()) && (value instanceof j4)) {
                    n(new j4((j4) value));
                } else if (!"response".equals(entry.getKey()) || !(value instanceof k)) {
                    put((String) entry.getKey(), value);
                } else {
                    l(new k((k) value));
                }
            }
        }
    }
}
