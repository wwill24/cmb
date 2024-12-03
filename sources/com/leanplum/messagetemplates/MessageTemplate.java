package com.leanplum.messagetemplates;

import android.content.Context;
import androidx.annotation.NonNull;
import com.leanplum.ActionArgs;
import com.leanplum.ActionContext;

public interface MessageTemplate {
    @NonNull
    ActionArgs createActionArgs(@NonNull Context context);

    boolean dismiss(@NonNull ActionContext actionContext);

    @NonNull
    String getName();

    boolean present(@NonNull ActionContext actionContext);
}
