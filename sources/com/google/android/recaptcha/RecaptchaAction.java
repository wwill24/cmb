package com.google.android.recaptcha;

import androidx.annotation.NonNull;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class RecaptchaAction {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final RecaptchaAction LOGIN = new RecaptchaAction(FirebaseAnalytics.Event.LOGIN);
    public static final RecaptchaAction SIGNUP = new RecaptchaAction("signup");
    private final String action;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(@NonNull DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RecaptchaAction custom(@NonNull String str) {
            return new RecaptchaAction(str, (DefaultConstructorMarker) null);
        }
    }

    private RecaptchaAction(String str) {
        this.action = str;
    }

    public /* synthetic */ RecaptchaAction(@NonNull String str, @NonNull DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    @NonNull
    public static /* synthetic */ RecaptchaAction copy$default(@NonNull RecaptchaAction recaptchaAction, @NonNull String str, int i10, @NonNull Object obj) {
        if ((i10 & 1) != 0) {
            str = recaptchaAction.action;
        }
        return recaptchaAction.copy(str);
    }

    public static final RecaptchaAction custom(@NonNull String str) {
        return Companion.custom(str);
    }

    public final String component1() {
        return this.action;
    }

    public final RecaptchaAction copy(@NonNull String str) {
        return new RecaptchaAction(str);
    }

    public boolean equals(@NonNull Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RecaptchaAction) && j.b(this.action, ((RecaptchaAction) obj).action);
    }

    public final String getAction() {
        return this.action;
    }

    public int hashCode() {
        return this.action.hashCode();
    }

    public String toString() {
        String str = this.action;
        return "RecaptchaAction(action=" + str + ")";
    }
}
