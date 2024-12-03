package com.coffeemeetsbagel.country;

import com.google.firebase.sessions.settings.RemoteSettings;
import com.mparticle.kits.AppsFlyerKit;
import gk.f;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.cli.HelpFormatter;

public final class CmbCountry {

    /* renamed from: g  reason: collision with root package name */
    public static final a f11576g = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final String f11577a;

    /* renamed from: b  reason: collision with root package name */
    private final String f11578b;

    /* renamed from: c  reason: collision with root package name */
    private final String f11579c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final String f11580d;

    /* renamed from: e  reason: collision with root package name */
    private final String f11581e;

    /* renamed from: f  reason: collision with root package name */
    private final f f11582f = b.b(new CmbCountry$flag$2(this));

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CmbCountry(String str, String str2, String str3) {
        j.g(str, "displayName");
        j.g(str2, "code");
        j.g(str3, "callingCode");
        this.f11577a = str;
        this.f11578b = str2;
        this.f11579c = str3;
        this.f11580d = StringsKt__StringsKt.W0((String) StringsKt__StringsKt.C0(str2, new String[]{RemoteSettings.FORWARD_SLASH_STRING}, false, 0, 6, (Object) null).get(0)).toString();
        this.f11581e = SignatureVisitor.EXTENDS + ((String) StringsKt__StringsKt.C0((CharSequence) StringsKt__StringsKt.C0(str3, new String[]{AppsFlyerKit.COMMA}, false, 0, 6, (Object) null).get(0), new String[]{HelpFormatter.DEFAULT_OPT_PREFIX}, false, 0, 6, (Object) null).get(0));
    }

    public final List<String> b() {
        if (StringsKt__StringsKt.O(this.f11579c, AppsFlyerKit.COMMA, false, 2, (Object) null)) {
            return StringsKt__StringsKt.C0(r.D(this.f11579c, HelpFormatter.DEFAULT_OPT_PREFIX, "", false, 4, (Object) null), new String[]{AppsFlyerKit.COMMA}, false, 0, 6, (Object) null);
        }
        if (StringsKt__StringsKt.O(this.f11579c, HelpFormatter.DEFAULT_OPT_PREFIX, false, 2, (Object) null)) {
            return p.e(r.D(this.f11579c, HelpFormatter.DEFAULT_OPT_PREFIX, "", false, 4, (Object) null));
        }
        return q.j();
    }

    public final String c() {
        return this.f11578b;
    }

    public final String d() {
        return this.f11581e;
    }

    public final String e() {
        return this.f11577a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CmbCountry)) {
            return false;
        }
        CmbCountry cmbCountry = (CmbCountry) obj;
        return j.b(this.f11577a, cmbCountry.f11577a) && j.b(this.f11578b, cmbCountry.f11578b) && j.b(this.f11579c, cmbCountry.f11579c);
    }

    public final String f() {
        return (String) this.f11582f.getValue();
    }

    public int hashCode() {
        return (((this.f11577a.hashCode() * 31) + this.f11578b.hashCode()) * 31) + this.f11579c.hashCode();
    }

    public String toString() {
        return "CmbCountry(displayName=" + this.f11577a + ", code=" + this.f11578b + ", callingCode=" + this.f11579c + PropertyUtils.MAPPED_DELIM2;
    }
}
