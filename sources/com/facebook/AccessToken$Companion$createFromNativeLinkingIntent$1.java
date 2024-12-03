package com.facebook;

import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.internal.Utility;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import org.json.b;

@Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\t"}, d2 = {"com/facebook/AccessToken$Companion$createFromNativeLinkingIntent$1", "Lcom/facebook/internal/Utility$GraphMeRequestWithCacheCallback;", "Lorg/json/b;", "userInfo", "", "onSuccess", "Lcom/facebook/FacebookException;", "error", "onFailure", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class AccessToken$Companion$createFromNativeLinkingIntent$1 implements Utility.GraphMeRequestWithCacheCallback {
    final /* synthetic */ AccessToken.AccessTokenCreationCallback $accessTokenCallback;
    final /* synthetic */ String $applicationId;
    final /* synthetic */ Bundle $extras;

    AccessToken$Companion$createFromNativeLinkingIntent$1(Bundle bundle, AccessToken.AccessTokenCreationCallback accessTokenCreationCallback, String str) {
        this.$extras = bundle;
        this.$accessTokenCallback = accessTokenCreationCallback;
        this.$applicationId = str;
    }

    public void onFailure(FacebookException facebookException) {
        this.$accessTokenCallback.onError(facebookException);
    }

    public void onSuccess(b bVar) {
        String str;
        if (bVar == null) {
            str = null;
        } else {
            try {
                str = bVar.getString("id");
            } catch (Exception unused) {
                this.$accessTokenCallback.onError(new FacebookException("Unable to generate access token due to missing user id"));
                return;
            }
        }
        if (str != null) {
            this.$extras.putString("user_id", str);
            this.$accessTokenCallback.onSuccess(AccessToken.Companion.createFromBundle((List<String>) null, this.$extras, AccessTokenSource.FACEBOOK_APPLICATION_WEB, new Date(), this.$applicationId));
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }
}
