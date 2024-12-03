package com.leanplum.messagetemplates.options;

import com.leanplum.ActionArgs;
import com.leanplum.ActionContext;
import com.leanplum.messagetemplates.MessageTemplateConstants;

public class WebInterstitialOptions {
    private ActionContext actionContext;
    private String closeUrl;
    private boolean hasDismissButton;
    private String url;

    public WebInterstitialOptions(ActionContext actionContext2) {
        setUrl(actionContext2.stringNamed(MessageTemplateConstants.Args.URL));
        setHasDismissButton(actionContext2.booleanNamed(MessageTemplateConstants.Args.HAS_DISMISS_BUTTON));
        setCloseUrl(actionContext2.stringNamed(MessageTemplateConstants.Args.CLOSE_URL));
        this.actionContext = actionContext2;
    }

    private void setCloseUrl(String str) {
        this.closeUrl = str;
    }

    private void setHasDismissButton(boolean z10) {
        this.hasDismissButton = z10;
    }

    private void setUrl(String str) {
        this.url = str;
    }

    public static ActionArgs toArgs() {
        return new ActionArgs().with(MessageTemplateConstants.Args.URL, MessageTemplateConstants.Values.DEFAULT_URL).with(MessageTemplateConstants.Args.CLOSE_URL, MessageTemplateConstants.Values.DEFAULT_CLOSE_URL).with(MessageTemplateConstants.Args.HAS_DISMISS_BUTTON, Boolean.TRUE);
    }

    public void dismiss() {
        this.actionContext.runActionNamed(MessageTemplateConstants.Args.DISMISS_ACTION);
    }

    public String getCloseUrl() {
        return this.closeUrl;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean hasDismissButton() {
        return this.hasDismissButton;
    }
}
