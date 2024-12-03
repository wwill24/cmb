package com.google.android.recaptcha;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;

public interface RecaptchaTasksClient {
    Task<String> executeTask(@NonNull RecaptchaAction recaptchaAction);
}
