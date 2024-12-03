package com.leanplum.actions.internal;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.leanplum.ActionContext;
import com.leanplum.internal.ActionManager;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\b\u0018\u0000 \u00172\u00020\u0001:\u0002\u0016\u0017B\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0006\u0010\u0013\u001a\u00020\u000fJ\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/leanplum/actions/internal/Action;", "", "actionType", "Lcom/leanplum/actions/internal/Action$ActionType;", "context", "Lcom/leanplum/ActionContext;", "(Lcom/leanplum/actions/internal/Action$ActionType;Lcom/leanplum/ActionContext;)V", "getActionType", "()Lcom/leanplum/actions/internal/Action$ActionType;", "getContext", "()Lcom/leanplum/ActionContext;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "isNotification", "toString", "", "ActionType", "Companion", "AndroidSDKCore_release"}, k = 1, mv = {1, 4, 2})
public final class Action {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final ActionType actionType;
    private final ActionContext context;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/leanplum/actions/internal/Action$ActionType;", "", "(Ljava/lang/String;I)V", "SINGLE", "CHAINED", "EMBEDDED", "AndroidSDKCore_release"}, k = 1, mv = {1, 4, 2})
    public enum ActionType {
        SINGLE,
        CHAINED,
        EMBEDDED
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/leanplum/actions/internal/Action$Companion;", "", "()V", "create", "Lcom/leanplum/actions/internal/Action;", "context", "Lcom/leanplum/ActionContext;", "AndroidSDKCore_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Action create(ActionContext actionContext) {
            j.g(actionContext, IdentityHttpResponse.CONTEXT);
            if (actionContext.getParentContext() != null && !actionContext.isChainedMessage()) {
                return new Action(ActionType.EMBEDDED, actionContext);
            }
            if (actionContext.isChainedMessage()) {
                return new Action(ActionType.CHAINED, actionContext);
            }
            return new Action((ActionType) null, actionContext, 1, (DefaultConstructorMarker) null);
        }
    }

    public Action(ActionType actionType2, ActionContext actionContext) {
        j.g(actionType2, SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE);
        j.g(actionContext, IdentityHttpResponse.CONTEXT);
        this.actionType = actionType2;
        this.context = actionContext;
    }

    public static /* synthetic */ Action copy$default(Action action, ActionType actionType2, ActionContext actionContext, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            actionType2 = action.actionType;
        }
        if ((i10 & 2) != 0) {
            actionContext = action.context;
        }
        return action.copy(actionType2, actionContext);
    }

    public static final Action create(ActionContext actionContext) {
        return Companion.create(actionContext);
    }

    public final ActionType component1() {
        return this.actionType;
    }

    public final ActionContext component2() {
        return this.context;
    }

    public final Action copy(ActionType actionType2, ActionContext actionContext) {
        j.g(actionType2, SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE);
        j.g(actionContext, IdentityHttpResponse.CONTEXT);
        return new Action(actionType2, actionContext);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Action)) {
            return false;
        }
        Action action = (Action) obj;
        return j.b(this.actionType, action.actionType) && j.b(this.context, action.context);
    }

    public final ActionType getActionType() {
        return this.actionType;
    }

    public final ActionContext getContext() {
        return this.context;
    }

    public int hashCode() {
        ActionType actionType2 = this.actionType;
        int i10 = 0;
        int hashCode = (actionType2 != null ? actionType2.hashCode() : 0) * 31;
        ActionContext actionContext = this.context;
        if (actionContext != null) {
            i10 = actionContext.hashCode();
        }
        return hashCode + i10;
    }

    public final boolean isNotification() {
        ActionContext parentContext = this.context.getParentContext();
        return j.b(parentContext != null ? parentContext.actionName() : null, ActionManager.PUSH_NOTIFICATION_ACTION_NAME);
    }

    public String toString() {
        return "Action(actionType=" + this.actionType + ", context=" + this.context + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Action(ActionType actionType2, ActionContext actionContext, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? ActionType.SINGLE : actionType2, actionContext);
    }
}
