package p9;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.models.enums.RewardType;
import com.coffeemeetsbagel.models.responses.ResponseSocialMedia;
import com.coffeemeetsbagel.util.RequestCode;
import p9.c;
import p9.d;

public class a implements d {

    /* renamed from: a  reason: collision with root package name */
    private final c f17061a;

    /* renamed from: p9.a$a  reason: collision with other inner class name */
    class C0189a implements c.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d.a f17062a;

        C0189a(d.a aVar) {
            this.f17062a = aVar;
        }

        public void a(ResponseSocialMedia responseSocialMedia) {
            responseSocialMedia.setBeanRewardTypeType(RewardType.TWEET);
            this.f17062a.a(responseSocialMedia);
        }

        public void onFailure() {
            this.f17062a.onFailure();
        }
    }

    class b implements c.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d.a f17064a;

        b(d.a aVar) {
            this.f17064a = aVar;
        }

        public void a(ResponseSocialMedia responseSocialMedia) {
            responseSocialMedia.setBeanRewardTypeType(RewardType.FOLLOW_TWITTER);
            this.f17064a.a(responseSocialMedia);
        }

        public void onFailure() {
            this.f17064a.onFailure();
        }
    }

    public a(c cVar) {
        this.f17061a = cVar;
    }

    private void e(String str, Activity activity) {
        activity.startActivityForResult(new Intent("android.intent.action.VIEW", Uri.parse(str)), RequestCode.FOLLOW);
    }

    private void f(String str, Activity activity) {
        activity.startActivityForResult(new Intent("android.intent.action.VIEW", Uri.parse(str)), RequestCode.TWEET);
    }

    private void g(String str, Activity activity) {
        f("https://twitter.com/intent/tweet?text=" + str, activity);
    }

    public void a(Activity activity) {
        g(activity.getString(R.string.tweet_default), activity);
    }

    public void b(d.a aVar) {
        this.f17061a.b(new C0189a(aVar));
    }

    public void c(Activity activity) {
        e("https://twitter.com/intent/follow?screen_name=CoffeeMBagel", activity);
    }

    public void d(d.a aVar) {
        this.f17061a.a(new b(aVar));
    }
}
