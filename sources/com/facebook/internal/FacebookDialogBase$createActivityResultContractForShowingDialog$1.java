package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import c.a;
import com.facebook.CallbackManager;
import com.facebook.FacebookException;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\r"}, d2 = {"com/facebook/internal/FacebookDialogBase$createActivityResultContractForShowingDialog$1", "Lc/a;", "Lcom/facebook/CallbackManager$ActivityResultParameters;", "Landroid/content/Context;", "context", "content", "Landroid/content/Intent;", "createIntent", "(Landroid/content/Context;Ljava/lang/Object;)Landroid/content/Intent;", "", "resultCode", "intent", "parseResult", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
public final class FacebookDialogBase$createActivityResultContractForShowingDialog$1 extends a<CONTENT, CallbackManager.ActivityResultParameters> {
    final /* synthetic */ CallbackManager $callbackManager;
    final /* synthetic */ Object $mode;
    final /* synthetic */ FacebookDialogBase<CONTENT, RESULT> this$0;

    FacebookDialogBase$createActivityResultContractForShowingDialog$1(FacebookDialogBase<CONTENT, RESULT> facebookDialogBase, Object obj, CallbackManager callbackManager) {
        this.this$0 = facebookDialogBase;
        this.$mode = obj;
        this.$callbackManager = callbackManager;
    }

    public Intent createIntent(Context context, CONTENT content) {
        Intent intent;
        j.g(context, IdentityHttpResponse.CONTEXT);
        AppCall access$createAppCallForMode = this.this$0.createAppCallForMode(content, this.$mode);
        if (access$createAppCallForMode == null) {
            intent = null;
        } else {
            intent = access$createAppCallForMode.getRequestIntent();
        }
        if (intent != null) {
            access$createAppCallForMode.setPending();
            return intent;
        }
        throw new FacebookException("Content " + content + " is not supported");
    }

    public CallbackManager.ActivityResultParameters parseResult(int i10, Intent intent) {
        CallbackManager callbackManager = this.$callbackManager;
        if (callbackManager != null) {
            callbackManager.onActivityResult(this.this$0.getRequestCode(), i10, intent);
        }
        return new CallbackManager.ActivityResultParameters(this.this$0.getRequestCode(), i10, intent);
    }
}
