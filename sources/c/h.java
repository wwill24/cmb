package c;

import android.content.Context;
import android.content.Intent;
import c.a;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.jvm.internal.j;

public final class h extends a<String, Boolean> {
    /* renamed from: a */
    public Intent createIntent(Context context, String str) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(str, "input");
        return g.f7905a.a(new String[]{str});
    }

    /* renamed from: b */
    public a.C0091a<Boolean> getSynchronousResult(Context context, String str) {
        boolean z10;
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(str, "input");
        if (androidx.core.content.a.checkSelfPermission(context, str) == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return new a.C0091a<>(Boolean.TRUE);
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
        if (r5 == true) goto L_0x0027;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Boolean parseResult(int r5, android.content.Intent r6) {
        /*
            r4 = this;
            if (r6 == 0) goto L_0x002c
            r0 = -1
            if (r5 == r0) goto L_0x0006
            goto L_0x002c
        L_0x0006:
            java.lang.String r5 = "androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS"
            int[] r5 = r6.getIntArrayExtra(r5)
            r6 = 1
            r0 = 0
            if (r5 == 0) goto L_0x0026
            int r1 = r5.length
            r2 = r0
        L_0x0012:
            if (r2 >= r1) goto L_0x0022
            r3 = r5[r2]
            if (r3 != 0) goto L_0x001a
            r3 = r6
            goto L_0x001b
        L_0x001a:
            r3 = r0
        L_0x001b:
            if (r3 == 0) goto L_0x001f
            r5 = r6
            goto L_0x0023
        L_0x001f:
            int r2 = r2 + 1
            goto L_0x0012
        L_0x0022:
            r5 = r0
        L_0x0023:
            if (r5 != r6) goto L_0x0026
            goto L_0x0027
        L_0x0026:
            r6 = r0
        L_0x0027:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r6)
            return r5
        L_0x002c:
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: c.h.parseResult(int, android.content.Intent):java.lang.Boolean");
    }
}
