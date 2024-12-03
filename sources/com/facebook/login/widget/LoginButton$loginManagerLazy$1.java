package com.facebook.login.widget;

import com.facebook.login.LoginManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/facebook/login/LoginManager;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class LoginButton$loginManagerLazy$1 extends Lambda implements Function0<LoginManager> {
    public static final LoginButton$loginManagerLazy$1 INSTANCE = new LoginButton$loginManagerLazy$1();

    LoginButton$loginManagerLazy$1() {
        super(0);
    }

    public final LoginManager invoke() {
        return LoginManager.Companion.getInstance();
    }
}
