package com.leanplum.actions.internal;

import com.leanplum.ActionContext;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J3\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/leanplum/actions/internal/ActionsTrigger;", "", "eventName", "", "condition", "", "contextualValues", "Lcom/leanplum/ActionContext$ContextualValues;", "(Ljava/lang/String;Ljava/util/List;Lcom/leanplum/ActionContext$ContextualValues;)V", "getCondition", "()Ljava/util/List;", "getContextualValues", "()Lcom/leanplum/ActionContext$ContextualValues;", "getEventName", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "AndroidSDKCore_release"}, k = 1, mv = {1, 4, 2})
public final class ActionsTrigger {
    private final List<String> condition;
    private final ActionContext.ContextualValues contextualValues;
    private final String eventName;

    public ActionsTrigger(String str, List<String> list, ActionContext.ContextualValues contextualValues2) {
        this.eventName = str;
        this.condition = list;
        this.contextualValues = contextualValues2;
    }

    public static /* synthetic */ ActionsTrigger copy$default(ActionsTrigger actionsTrigger, String str, List<String> list, ActionContext.ContextualValues contextualValues2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = actionsTrigger.eventName;
        }
        if ((i10 & 2) != 0) {
            list = actionsTrigger.condition;
        }
        if ((i10 & 4) != 0) {
            contextualValues2 = actionsTrigger.contextualValues;
        }
        return actionsTrigger.copy(str, list, contextualValues2);
    }

    public final String component1() {
        return this.eventName;
    }

    public final List<String> component2() {
        return this.condition;
    }

    public final ActionContext.ContextualValues component3() {
        return this.contextualValues;
    }

    public final ActionsTrigger copy(String str, List<String> list, ActionContext.ContextualValues contextualValues2) {
        return new ActionsTrigger(str, list, contextualValues2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActionsTrigger)) {
            return false;
        }
        ActionsTrigger actionsTrigger = (ActionsTrigger) obj;
        return j.b(this.eventName, actionsTrigger.eventName) && j.b(this.condition, actionsTrigger.condition) && j.b(this.contextualValues, actionsTrigger.contextualValues);
    }

    public final List<String> getCondition() {
        return this.condition;
    }

    public final ActionContext.ContextualValues getContextualValues() {
        return this.contextualValues;
    }

    public final String getEventName() {
        return this.eventName;
    }

    public int hashCode() {
        String str = this.eventName;
        int i10 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<String> list = this.condition;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        ActionContext.ContextualValues contextualValues2 = this.contextualValues;
        if (contextualValues2 != null) {
            i10 = contextualValues2.hashCode();
        }
        return hashCode2 + i10;
    }

    public String toString() {
        return "ActionsTrigger(eventName=" + this.eventName + ", condition=" + this.condition + ", contextualValues=" + this.contextualValues + ")";
    }
}
