package com.leanplum.messagetemplates;

import android.content.Context;
import androidx.annotation.NonNull;
import com.leanplum.ActionContext;
import com.leanplum.actions.internal.ActionDefinition;
import com.leanplum.actions.internal.ActionManagerDefinitionKt;
import com.leanplum.callbacks.ActionCallback;
import com.leanplum.internal.ActionManager;
import com.leanplum.messagetemplates.actions.AlertMessage;
import com.leanplum.messagetemplates.actions.CenterPopupMessage;
import com.leanplum.messagetemplates.actions.ConfirmMessage;
import com.leanplum.messagetemplates.actions.InterstitialMessage;
import com.leanplum.messagetemplates.actions.OpenUrlAction;
import com.leanplum.messagetemplates.actions.RichHtmlMessage;
import com.leanplum.messagetemplates.actions.WebInterstitialMessage;
import java.util.Map;

public class MessageTemplates {
    private static DialogCustomizer customizer = null;
    private static boolean registered = false;

    public static DialogCustomizer getCustomizer() {
        return customizer;
    }

    private static void register(@NonNull final MessageTemplate messageTemplate, @NonNull Context context, int i10) {
        ActionManagerDefinitionKt.defineAction(ActionManager.getInstance(), new ActionDefinition(messageTemplate.getName(), i10, messageTemplate.createActionArgs(context), (Map<String, ? extends Object>) null, new ActionCallback() {
            public boolean onResponse(ActionContext actionContext) {
                return MessageTemplate.this.present(actionContext);
            }
        }, new ActionCallback() {
            public boolean onResponse(ActionContext actionContext) {
                return MessageTemplate.this.dismiss(actionContext);
            }
        }));
    }

    public static void registerAction(@NonNull MessageTemplate messageTemplate, @NonNull Context context) {
        register(messageTemplate, context, 2);
    }

    public static void registerTemplate(@NonNull MessageTemplate messageTemplate, @NonNull Context context) {
        register(messageTemplate, context, 3);
    }

    public static void setCustomizer(DialogCustomizer dialogCustomizer) {
        customizer = dialogCustomizer;
    }

    public static synchronized void register(Context context) {
        synchronized (MessageTemplates.class) {
            if (!registered) {
                registered = true;
                registerAction(new OpenUrlAction(), context);
                registerTemplate(new AlertMessage(), context);
                registerTemplate(new ConfirmMessage(), context);
                registerTemplate(new CenterPopupMessage(), context);
                registerTemplate(new InterstitialMessage(), context);
                registerTemplate(new WebInterstitialMessage(), context);
                registerTemplate(new RichHtmlMessage(), context);
            }
        }
    }
}
