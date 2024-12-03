package com.leanplum.actions.internal;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.leanplum.ActionArgs;
import com.leanplum.callbacks.ActionCallback;
import com.leanplum.internal.ActionArg;
import com.leanplum.internal.Constants;
import com.leanplum.internal.VarCache;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\rJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\u0017\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u000bHÆ\u0003JW\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0005HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001f\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001f\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b\u001e\u0010\u0017¨\u0006+"}, d2 = {"Lcom/leanplum/actions/internal/ActionDefinition;", "", "name", "", "kind", "", "args", "Lcom/leanplum/ActionArgs;", "options", "", "presentHandler", "Lcom/leanplum/callbacks/ActionCallback;", "dismissHandler", "(Ljava/lang/String;ILcom/leanplum/ActionArgs;Ljava/util/Map;Lcom/leanplum/callbacks/ActionCallback;Lcom/leanplum/callbacks/ActionCallback;)V", "getArgs", "()Lcom/leanplum/ActionArgs;", "definitionMap", "", "getDefinitionMap", "()Ljava/util/Map;", "getDismissHandler", "()Lcom/leanplum/callbacks/ActionCallback;", "setDismissHandler", "(Lcom/leanplum/callbacks/ActionCallback;)V", "getKind", "()I", "getName", "()Ljava/lang/String;", "getOptions", "getPresentHandler", "setPresentHandler", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "AndroidSDKCore_release"}, k = 1, mv = {1, 4, 2})
public final class ActionDefinition {
    private final ActionArgs args;
    private final Map<String, Object> definitionMap;
    private ActionCallback dismissHandler;
    private final int kind;
    private final String name;
    private final Map<String, Object> options;
    private ActionCallback presentHandler;

    public ActionDefinition(String str, int i10, ActionArgs actionArgs, Map<String, ? extends Object> map, ActionCallback actionCallback, ActionCallback actionCallback2) {
        j.g(str, "name");
        j.g(actionArgs, "args");
        this.name = str;
        this.kind = i10;
        this.args = actionArgs;
        this.options = map;
        this.presentHandler = actionCallback;
        this.dismissHandler = actionCallback2;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (ActionArg next : actionArgs.getValue()) {
            VarCache.updateValues(next.name(), VarCache.getNameComponents(next.name()), next.defaultValue(), next.kind(), hashMap, hashMap2);
            String name2 = next.name();
            j.f(name2, "arg.name()");
            arrayList.add(name2);
        }
        HashMap hashMap3 = new HashMap();
        this.definitionMap = hashMap3;
        hashMap3.put("kind", Integer.valueOf(this.kind));
        hashMap3.put("values", hashMap);
        hashMap3.put(Constants.Params.KINDS, hashMap2);
        hashMap3.put("order", arrayList);
        hashMap3.put(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, this.options);
    }

    public static /* synthetic */ ActionDefinition copy$default(ActionDefinition actionDefinition, String str, int i10, ActionArgs actionArgs, Map<String, Object> map, ActionCallback actionCallback, ActionCallback actionCallback2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = actionDefinition.name;
        }
        if ((i11 & 2) != 0) {
            i10 = actionDefinition.kind;
        }
        int i12 = i10;
        if ((i11 & 4) != 0) {
            actionArgs = actionDefinition.args;
        }
        ActionArgs actionArgs2 = actionArgs;
        if ((i11 & 8) != 0) {
            map = actionDefinition.options;
        }
        Map<String, Object> map2 = map;
        if ((i11 & 16) != 0) {
            actionCallback = actionDefinition.presentHandler;
        }
        ActionCallback actionCallback3 = actionCallback;
        if ((i11 & 32) != 0) {
            actionCallback2 = actionDefinition.dismissHandler;
        }
        return actionDefinition.copy(str, i12, actionArgs2, map2, actionCallback3, actionCallback2);
    }

    public final String component1() {
        return this.name;
    }

    public final int component2() {
        return this.kind;
    }

    public final ActionArgs component3() {
        return this.args;
    }

    public final Map<String, Object> component4() {
        return this.options;
    }

    public final ActionCallback component5() {
        return this.presentHandler;
    }

    public final ActionCallback component6() {
        return this.dismissHandler;
    }

    public final ActionDefinition copy(String str, int i10, ActionArgs actionArgs, Map<String, ? extends Object> map, ActionCallback actionCallback, ActionCallback actionCallback2) {
        j.g(str, "name");
        j.g(actionArgs, "args");
        return new ActionDefinition(str, i10, actionArgs, map, actionCallback, actionCallback2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActionDefinition)) {
            return false;
        }
        ActionDefinition actionDefinition = (ActionDefinition) obj;
        return j.b(this.name, actionDefinition.name) && this.kind == actionDefinition.kind && j.b(this.args, actionDefinition.args) && j.b(this.options, actionDefinition.options) && j.b(this.presentHandler, actionDefinition.presentHandler) && j.b(this.dismissHandler, actionDefinition.dismissHandler);
    }

    public final ActionArgs getArgs() {
        return this.args;
    }

    public final Map<String, Object> getDefinitionMap() {
        return this.definitionMap;
    }

    public final ActionCallback getDismissHandler() {
        return this.dismissHandler;
    }

    public final int getKind() {
        return this.kind;
    }

    public final String getName() {
        return this.name;
    }

    public final Map<String, Object> getOptions() {
        return this.options;
    }

    public final ActionCallback getPresentHandler() {
        return this.presentHandler;
    }

    public int hashCode() {
        String str = this.name;
        int i10 = 0;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.kind) * 31;
        ActionArgs actionArgs = this.args;
        int hashCode2 = (hashCode + (actionArgs != null ? actionArgs.hashCode() : 0)) * 31;
        Map<String, Object> map = this.options;
        int hashCode3 = (hashCode2 + (map != null ? map.hashCode() : 0)) * 31;
        ActionCallback actionCallback = this.presentHandler;
        int hashCode4 = (hashCode3 + (actionCallback != null ? actionCallback.hashCode() : 0)) * 31;
        ActionCallback actionCallback2 = this.dismissHandler;
        if (actionCallback2 != null) {
            i10 = actionCallback2.hashCode();
        }
        return hashCode4 + i10;
    }

    public final void setDismissHandler(ActionCallback actionCallback) {
        this.dismissHandler = actionCallback;
    }

    public final void setPresentHandler(ActionCallback actionCallback) {
        this.presentHandler = actionCallback;
    }

    public String toString() {
        return "ActionDefinition(name=" + this.name + ", kind=" + this.kind + ", args=" + this.args + ", options=" + this.options + ", presentHandler=" + this.presentHandler + ", dismissHandler=" + this.dismissHandler + ")";
    }
}
