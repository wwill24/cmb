package h5;

import android.os.Bundle;
import android.text.TextUtils;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.models.responses.ResponseFbAlbum;
import com.coffeemeetsbagel.models.responses.ResponseFbAlbums;
import com.coffeemeetsbagel.models.util.DateUtils;
import com.coffeemeetsbagel.models.util.FacebookParse;
import com.coffeemeetsbagel.transport.SuccessStatus;
import com.facebook.AccessToken;
import com.facebook.AuthenticationTokenClaims;
import com.facebook.CallbackManager;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import h8.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import jc.b;

public class l implements a {

    /* renamed from: a  reason: collision with root package name */
    private static String f15367a = Bakery.w().M().q();

    /* renamed from: b  reason: collision with root package name */
    private static String f15368b = Bakery.w().M().r("TOKEN_EXPIRATION");

    /* renamed from: c  reason: collision with root package name */
    private static String f15369c = Bakery.w().M().r("facebook_id");

    /* renamed from: d  reason: collision with root package name */
    private static final CallbackManager f15370d = CallbackManager.Factory.create();

    /* renamed from: e  reason: collision with root package name */
    private static final tj.a f15371e = new tj.a();

    public static void e() {
        Bakery.w().M().o();
        Bakery.w().M().e("TOKEN_EXPIRATION");
        Bakery.w().M().e("facebook_id");
    }

    public static void f(b<ResponseFbAlbum> bVar, String str, String str2, String str3) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("albumId=");
        sb2.append(str);
        sb2.append(", url=");
        sb2.append(str2);
        sb2.append(", after=");
        sb2.append(str3);
        if (FacebookParse.FB_PARAM_TAGGED_ID.equals(str)) {
            str = "me";
        }
        String str4 = str + "/photos";
        Bundle bundle = new Bundle();
        bundle.putString(FacebookParse.FB_PARAM_FIELD_LIMIT, String.valueOf(FacebookParse.FB_NO_LIMIT));
        bundle.putString("fields", "id,source,picture");
        if (!TextUtils.isEmpty(str3)) {
            bundle.putString("after", str3);
        }
        new GraphRequest(AccessToken.getCurrentAccessToken(), str4, bundle, HttpMethod.GET, new k(bVar)).executeAsync();
    }

    public static void g(b<ResponseFbAlbums> bVar) {
        Bundle bundle = new Bundle();
        bundle.putString("fields", "albums.limit(5000){id,name,count,picture.limit(1)},photos.limit(5000).fields(id,picture)");
        new GraphRequest(AccessToken.getCurrentAccessToken(), "me", bundle, HttpMethod.GET, new j(bVar, Bakery.w().getResources().getString(R.string.title_tagged_album))).executeAsync();
    }

    public static CallbackManager h() {
        return f15370d;
    }

    public static List<String> i() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(AuthenticationTokenClaims.JSON_KEY_USER_BIRTHDAY);
        arrayList.add("email");
        arrayList.add("user_photos");
        return arrayList;
    }

    public static String j() {
        return f15367a;
    }

    public static String k() {
        return f15368b;
    }

    public static boolean l(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("permission=");
        sb2.append(str);
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        if (currentAccessToken == null) {
            return true;
        }
        Set<String> permissions = currentAccessToken.getPermissions();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("permissions=");
        sb3.append(permissions);
        return permissions.contains(str);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void m(b bVar, GraphResponse graphResponse) {
        if (graphResponse.getError() != null) {
            bVar.b(new CmbErrorCode(graphResponse.getError().getErrorMessage(), graphResponse.getError().getErrorCode()));
            return;
        }
        bVar.a(new ResponseFbAlbum(graphResponse.getJSONObject()), new SuccessStatus("Got fb albums successfully"));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void n(b bVar, String str, GraphResponse graphResponse) {
        if (graphResponse.getError() != null) {
            bVar.b(new CmbErrorCode(graphResponse.getError().getErrorMessage(), graphResponse.getError().getErrorCode()));
            return;
        }
        bVar.a(new ResponseFbAlbums(graphResponse.getJSONObject(), str), new SuccessStatus("Got fb albums successfully"));
    }

    public String a() {
        return f15369c;
    }

    public void b(AccessToken accessToken) {
        f15367a = accessToken.getToken();
        f15368b = DateUtils.getFormattedUtcDate(accessToken.getExpires(), DateUtils.DATE_WITH_TIME_PATTERN);
        f15369c = accessToken.getUserId();
        Bakery.w().M().h(f15367a);
        Bakery.w().M().w("TOKEN_EXPIRATION", f15368b);
        Bakery.w().M().w("facebook_id", f15369c);
    }

    public void clear() {
        f15367a = null;
        f15368b = null;
        f15369c = null;
        f15371e.dispose();
    }
}
