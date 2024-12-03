package io.sentry;

import io.sentry.protocol.q;
import io.sentry.protocol.v;
import net.bytebuddy.ClassFileVersion;
import org.jivesoftware.smack.util.SystemUtil;

final class y3 implements t {

    /* renamed from: a  reason: collision with root package name */
    private final String f31807a;

    /* renamed from: b  reason: collision with root package name */
    private final String f31808b;

    public y3(String str, String str2) {
        this.f31807a = str;
        this.f31808b = str2;
    }

    private <T extends p2> T c(T t10) {
        if (t10.C().d() == null) {
            t10.C().m(new q());
        }
        q d10 = t10.C().d();
        if (d10 != null && d10.d() == null && d10.e() == null) {
            d10.f(this.f31808b);
            d10.h(this.f31807a);
        }
        return t10;
    }

    public p3 a(p3 p3Var, w wVar) {
        return (p3) c(p3Var);
    }

    public v b(v vVar, w wVar) {
        return (v) c(vVar);
    }

    public y3() {
        this(System.getProperty(ClassFileVersion.VersionLocator.JAVA_VERSION), System.getProperty(SystemUtil.PROPERTY_JAVA_VENDOR));
    }
}
