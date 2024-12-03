package com.leanplum.internal;

import java.util.Map;

public abstract class BaseActionContext {
    protected Map<String, Object> args;
    private boolean isPreview = false;
    protected boolean isRooted = true;
    protected String messageId;
    protected String originalMessageId;
    protected int priority;

    public BaseActionContext(String str, String str2) {
        this.messageId = str;
        this.originalMessageId = str2;
    }

    public Map<String, Object> getArgs() {
        return this.args;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public String getOriginalMessageId() {
        return this.originalMessageId;
    }

    public int getPriority() {
        return this.priority;
    }

    /* access modifiers changed from: package-private */
    public boolean isPreview() {
        return this.isPreview;
    }

    /* access modifiers changed from: package-private */
    public void setIsPreview(boolean z10) {
        this.isPreview = z10;
    }

    /* access modifiers changed from: package-private */
    public void setIsRooted(boolean z10) {
        this.isRooted = z10;
    }
}
