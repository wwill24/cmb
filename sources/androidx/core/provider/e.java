package androidx.core.provider;

import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.core.util.h;
import java.util.List;
import org.apache.commons.cli.HelpFormatter;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final String f4654a;

    /* renamed from: b  reason: collision with root package name */
    private final String f4655b;

    /* renamed from: c  reason: collision with root package name */
    private final String f4656c;

    /* renamed from: d  reason: collision with root package name */
    private final List<List<byte[]>> f4657d;

    /* renamed from: e  reason: collision with root package name */
    private final int f4658e = 0;

    /* renamed from: f  reason: collision with root package name */
    private final String f4659f;

    public e(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull List<List<byte[]>> list) {
        this.f4654a = (String) h.g(str);
        this.f4655b = (String) h.g(str2);
        this.f4656c = (String) h.g(str3);
        this.f4657d = (List) h.g(list);
        this.f4659f = a(str, str2, str3);
    }

    private String a(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        return str + HelpFormatter.DEFAULT_OPT_PREFIX + str2 + HelpFormatter.DEFAULT_OPT_PREFIX + str3;
    }

    public List<List<byte[]>> b() {
        return this.f4657d;
    }

    public int c() {
        return this.f4658e;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public String d() {
        return this.f4659f;
    }

    @NonNull
    public String e() {
        return this.f4654a;
    }

    @NonNull
    public String f() {
        return this.f4655b;
    }

    @NonNull
    public String g() {
        return this.f4656c;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("FontRequest {mProviderAuthority: " + this.f4654a + ", mProviderPackage: " + this.f4655b + ", mQuery: " + this.f4656c + ", mCertificates:");
        for (int i10 = 0; i10 < this.f4657d.size(); i10++) {
            sb2.append(" [");
            List list = this.f4657d.get(i10);
            for (int i11 = 0; i11 < list.size(); i11++) {
                sb2.append(" \"");
                sb2.append(Base64.encodeToString((byte[]) list.get(i11), 0));
                sb2.append("\"");
            }
            sb2.append(" ]");
        }
        sb2.append("}");
        sb2.append("mCertificatesArray: " + this.f4658e);
        return sb2.toString();
    }
}
