package c;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import c.a;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.jvm.internal.j;

public class c extends a<String[], Uri> {
    /* renamed from: a */
    public Intent createIntent(Context context, String[] strArr) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(strArr, "input");
        Intent type = new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", strArr).setType("*/*");
        j.f(type, "Intent(Intent.ACTION_OPE…          .setType(\"*/*\")");
        return type;
    }

    /* renamed from: b */
    public final a.C0091a<Uri> getSynchronousResult(Context context, String[] strArr) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(strArr, "input");
        return null;
    }

    /* renamed from: c */
    public final Uri parseResult(int i10, Intent intent) {
        if (!(i10 == -1)) {
            intent = null;
        }
        if (intent != null) {
            return intent.getData();
        }
        return null;
    }
}
