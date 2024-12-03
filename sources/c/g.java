package c;

import android.content.Context;
import android.content.Intent;
import c.a;
import com.mparticle.identity.IdentityHttpResponse;
import gk.h;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class g extends a<String[], Map<String, Boolean>> {

    /* renamed from: a  reason: collision with root package name */
    public static final a f7905a = new a((DefaultConstructorMarker) null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(String[] strArr) {
            j.g(strArr, "input");
            Intent putExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr);
            j.f(putExtra, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
            return putExtra;
        }
    }

    /* renamed from: a */
    public Intent createIntent(Context context, String[] strArr) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(strArr, "input");
        return f7905a.a(strArr);
    }

    /* renamed from: b */
    public a.C0091a<Map<String, Boolean>> getSynchronousResult(Context context, String[] strArr) {
        boolean z10;
        boolean z11;
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(strArr, "input");
        boolean z12 = true;
        if (strArr.length == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return new a.C0091a<>(h0.i());
        }
        int length = strArr.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                break;
            }
            if (androidx.core.content.a.checkSelfPermission(context, strArr[i10]) == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                z12 = false;
                break;
            }
            i10++;
        }
        if (!z12) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(j.c(g0.e(strArr.length), 16));
        for (String a10 : strArr) {
            Pair a11 = h.a(a10, Boolean.TRUE);
            linkedHashMap.put(a11.c(), a11.d());
        }
        return new a.C0091a<>(linkedHashMap);
    }

    /* renamed from: c */
    public Map<String, Boolean> parseResult(int i10, Intent intent) {
        boolean z10;
        if (i10 != -1) {
            return h0.i();
        }
        if (intent == null) {
            return h0.i();
        }
        String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
        int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
        if (intArrayExtra == null || stringArrayExtra == null) {
            return h0.i();
        }
        ArrayList arrayList = new ArrayList(intArrayExtra.length);
        for (int i11 : intArrayExtra) {
            if (i11 == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            arrayList.add(Boolean.valueOf(z10));
        }
        return h0.s(CollectionsKt___CollectionsKt.E0(l.y(stringArrayExtra), arrayList));
    }
}
