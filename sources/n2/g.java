package n2;

import android.net.Uri;
import coil.request.k;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"Ln2/g;", "Ln2/d;", "", "Landroid/net/Uri;", "data", "Lcoil/request/k;", "options", "b", "<init>", "()V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class g implements d<String, Uri> {
    /* renamed from: b */
    public Uri a(String str, k kVar) {
        Uri parse = Uri.parse(str);
        j.f(parse, "parse(this)");
        return parse;
    }
}
