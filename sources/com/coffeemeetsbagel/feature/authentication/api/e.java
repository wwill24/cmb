package com.coffeemeetsbagel.feature.authentication.api;

import com.coffeemeetsbagel.feature.authentication.api.models.AuthenticateBody;
import com.coffeemeetsbagel.feature.authentication.api.models.AuthenticateResponse;
import com.coffeemeetsbagel.feature.authentication.api.models.LoginBody;
import com.coffeemeetsbagel.models.responses.ResponseLogin;
import qj.w;
import retrofit2.b;
import retrofit2.r;
import vn.a;
import vn.o;

public interface e {
    @o("/login")
    w<r<ResponseLogin>> a(@a LoginBody loginBody);

    @o("/authenticate")
    b<AuthenticateResponse> b(@a AuthenticateBody authenticateBody);
}
