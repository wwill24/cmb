package m2;

import android.net.Uri;
import coil.request.k;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\n"}, d2 = {"Lm2/c;", "Lm2/b;", "Landroid/net/Uri;", "data", "Lcoil/request/k;", "options", "", "b", "<init>", "()V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class c implements b<Uri> {
    /* renamed from: b */
    public String a(Uri uri, k kVar) {
        if (!j.b(uri.getScheme(), "android.resource")) {
            return uri.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(uri);
        sb2.append(SignatureVisitor.SUPER);
        sb2.append(coil.util.j.l(kVar.g().getResources().getConfiguration()));
        return sb2.toString();
    }
}
