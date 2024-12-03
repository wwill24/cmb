package com.facebook.login;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import c.a;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\u00030\u0001J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J&\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\u00032\u0006\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\f"}, d2 = {"com/facebook/login/LoginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$1", "Lc/a;", "Landroid/content/Intent;", "Landroid/util/Pair;", "", "Landroid/content/Context;", "context", "input", "createIntent", "resultCode", "intent", "parseResult", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
public final class LoginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$1 extends a<Intent, Pair<Integer, Intent>> {
    LoginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$1() {
    }

    public Intent createIntent(Context context, Intent intent) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(intent, "input");
        return intent;
    }

    public Pair<Integer, Intent> parseResult(int i10, Intent intent) {
        Pair<Integer, Intent> create = Pair.create(Integer.valueOf(i10), intent);
        j.f(create, "create(resultCode, intent)");
        return create;
    }
}
