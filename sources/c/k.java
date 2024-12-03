package c;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import c.a;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.jvm.internal.j;

public class k extends a<Uri, Boolean> {
    /* renamed from: a */
    public Intent createIntent(Context context, Uri uri) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(uri, "input");
        Intent putExtra = new Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", uri);
        j.f(putExtra, "Intent(MediaStore.ACTION…tore.EXTRA_OUTPUT, input)");
        return putExtra;
    }

    /* renamed from: b */
    public final a.C0091a<Boolean> getSynchronousResult(Context context, Uri uri) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(uri, "input");
        return null;
    }

    /* renamed from: c */
    public final Boolean parseResult(int i10, Intent intent) {
        return Boolean.valueOf(i10 == -1);
    }
}
