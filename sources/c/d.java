package c;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import c.a;
import com.mparticle.identity.IdentityHttpResponse;
import java.util.List;
import kotlin.jvm.internal.j;

public class d extends a<String[], List<Uri>> {
    /* renamed from: a */
    public Intent createIntent(Context context, String[] strArr) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(strArr, "input");
        Intent type = new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", strArr).putExtra("android.intent.extra.ALLOW_MULTIPLE", true).setType("*/*");
        j.f(type, "Intent(Intent.ACTION_OPE…          .setType(\"*/*\")");
        return type;
    }

    /* renamed from: b */
    public final a.C0091a<List<Uri>> getSynchronousResult(Context context, String[] strArr) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(strArr, "input");
        return null;
    }

    /* renamed from: c */
    public final List<Uri> parseResult(int i10, Intent intent) {
        List<Uri> a10;
        if (!(i10 == -1)) {
            intent = null;
        }
        return (intent == null || (a10 = b.f7897a.a(intent)) == null) ? q.j() : a10;
    }
}
