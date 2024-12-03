package p9;

import com.coffeemeetsbagel.models.responses.ResponseSocialMedia;

public interface c {

    public interface a {
        void a(ResponseSocialMedia responseSocialMedia);

        void onFailure();
    }

    void a(a aVar);

    void b(a aVar);
}
