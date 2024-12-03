package com.facebook;

import android.net.Uri;
import com.facebook.internal.Utility;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import org.json.b;

@Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\t"}, d2 = {"com/facebook/Profile$Companion$fetchProfileForCurrentAccessToken$1", "Lcom/facebook/internal/Utility$GraphMeRequestWithCacheCallback;", "Lorg/json/b;", "userInfo", "", "onSuccess", "Lcom/facebook/FacebookException;", "error", "onFailure", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class Profile$Companion$fetchProfileForCurrentAccessToken$1 implements Utility.GraphMeRequestWithCacheCallback {
    Profile$Companion$fetchProfileForCurrentAccessToken$1() {
    }

    public void onFailure(FacebookException facebookException) {
        String unused = Profile.TAG;
        j.p("Got unexpected exception: ", facebookException);
    }

    public void onSuccess(b bVar) {
        String str;
        Uri uri;
        Uri uri2 = null;
        if (bVar == null) {
            str = null;
        } else {
            str = bVar.optString("id");
        }
        if (str == null) {
            String unused = Profile.TAG;
            return;
        }
        String optString = bVar.optString("link");
        String optString2 = bVar.optString("profile_picture", (String) null);
        String optString3 = bVar.optString("first_name");
        String optString4 = bVar.optString(AuthenticationTokenClaims.JSON_KEY_MIDDLE_NAME);
        String optString5 = bVar.optString("last_name");
        String optString6 = bVar.optString("name");
        if (optString != null) {
            uri = Uri.parse(optString);
        } else {
            uri = null;
        }
        if (optString2 != null) {
            uri2 = Uri.parse(optString2);
        }
        Profile.Companion.setCurrentProfile(new Profile(str, optString3, optString4, optString5, optString6, uri, uri2));
    }
}
