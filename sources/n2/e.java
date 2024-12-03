package n2;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import coil.request.k;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, d2 = {"Ln2/e;", "Ln2/d;", "", "Landroid/net/Uri;", "data", "Landroid/content/Context;", "context", "", "b", "Lcoil/request/k;", "options", "c", "<init>", "()V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class e implements d<Integer, Uri> {
    private final boolean b(int i10, Context context) {
        try {
            return context.getResources().getResourceEntryName(i10) != null;
        } catch (Resources.NotFoundException unused) {
            return false;
        }
    }

    public /* bridge */ /* synthetic */ Object a(Object obj, k kVar) {
        return c(((Number) obj).intValue(), kVar);
    }

    public Uri c(int i10, k kVar) {
        if (!b(i10, kVar.g())) {
            return null;
        }
        Uri parse = Uri.parse("android.resource://" + kVar.g().getPackageName() + '/' + i10);
        j.f(parse, "parse(this)");
        return parse;
    }
}
