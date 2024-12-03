package qa;

import com.coffeemeetsbagel.models.VerifyCodeBody;
import com.coffeemeetsbagel.models.VerifyPhoneNumberBody;
import com.coffeemeetsbagel.phone_login.api.models.VerifyCodeResponse;
import com.coffeemeetsbagel.phone_login.api.models.VerifyPhoneNumberResponse;
import qj.w;
import retrofit2.r;
import vn.a;
import vn.o;

public interface b {
    @o("/authenticate/phone")
    w<r<VerifyCodeResponse>> a(@a VerifyCodeBody verifyCodeBody);

    @o("/authenticate/phone/verify")
    w<r<VerifyPhoneNumberResponse>> b(@a VerifyPhoneNumberBody verifyPhoneNumberBody);
}
