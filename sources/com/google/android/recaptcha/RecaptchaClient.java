package com.google.android.recaptcha;

import androidx.annotation.NonNull;
import kotlin.Result;
import kotlin.coroutines.c;

public interface RecaptchaClient {
    @NonNull
    /* renamed from: execute-gIAlu-s  reason: not valid java name */
    Object m1executegIAlus(@NonNull RecaptchaAction recaptchaAction, @NonNull c<? super Result<String>> cVar);
}
