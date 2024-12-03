package p9;

import android.app.Activity;
import com.coffeemeetsbagel.models.responses.ResponseSocialMedia;

public interface d {

    public interface a {
        void a(ResponseSocialMedia responseSocialMedia);

        void onFailure();
    }

    void a(Activity activity);

    void b(a aVar);

    void c(Activity activity);

    void d(a aVar);
}
