package com.leanplum.actions.internal;

import com.leanplum.internal.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR*\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/leanplum/actions/internal/Definitions;", "", "actionDefinitions", "", "Lcom/leanplum/actions/internal/ActionDefinition;", "devModeActionDefinitionsFromServer", "", "", "(Ljava/util/List;Ljava/util/Map;)V", "getActionDefinitions", "()Ljava/util/List;", "getDevModeActionDefinitionsFromServer", "()Ljava/util/Map;", "setDevModeActionDefinitionsFromServer", "(Ljava/util/Map;)V", "component1", "component2", "copy", "equals", "", "other", "findDefinition", "definitionName", "hashCode", "", "toString", "AndroidSDKCore_release"}, k = 1, mv = {1, 4, 2})
public final class Definitions {
    private final List<ActionDefinition> actionDefinitions;
    private Map<String, ? extends Object> devModeActionDefinitionsFromServer;

    public Definitions() {
        this((List) null, (Map) null, 3, (DefaultConstructorMarker) null);
    }

    public Definitions(List<ActionDefinition> list, Map<String, ? extends Object> map) {
        j.g(list, Constants.Params.ACTION_DEFINITIONS);
        this.actionDefinitions = list;
        this.devModeActionDefinitionsFromServer = map;
    }

    public static /* synthetic */ Definitions copy$default(Definitions definitions, List<ActionDefinition> list, Map<String, ? extends Object> map, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = definitions.actionDefinitions;
        }
        if ((i10 & 2) != 0) {
            map = definitions.devModeActionDefinitionsFromServer;
        }
        return definitions.copy(list, map);
    }

    public final List<ActionDefinition> component1() {
        return this.actionDefinitions;
    }

    public final Map<String, Object> component2() {
        return this.devModeActionDefinitionsFromServer;
    }

    public final Definitions copy(List<ActionDefinition> list, Map<String, ? extends Object> map) {
        j.g(list, Constants.Params.ACTION_DEFINITIONS);
        return new Definitions(list, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Definitions)) {
            return false;
        }
        Definitions definitions = (Definitions) obj;
        return j.b(this.actionDefinitions, definitions.actionDefinitions) && j.b(this.devModeActionDefinitionsFromServer, definitions.devModeActionDefinitionsFromServer);
    }

    public final ActionDefinition findDefinition(String str) {
        T t10;
        Iterator<T> it = this.actionDefinitions.iterator();
        while (true) {
            if (!it.hasNext()) {
                t10 = null;
                break;
            }
            t10 = it.next();
            if (j.b(((ActionDefinition) t10).getName(), str)) {
                break;
            }
        }
        return (ActionDefinition) t10;
    }

    public final List<ActionDefinition> getActionDefinitions() {
        return this.actionDefinitions;
    }

    public final Map<String, Object> getDevModeActionDefinitionsFromServer() {
        return this.devModeActionDefinitionsFromServer;
    }

    public int hashCode() {
        List<ActionDefinition> list = this.actionDefinitions;
        int i10 = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        Map<String, ? extends Object> map = this.devModeActionDefinitionsFromServer;
        if (map != null) {
            i10 = map.hashCode();
        }
        return hashCode + i10;
    }

    public final void setDevModeActionDefinitionsFromServer(Map<String, ? extends Object> map) {
        this.devModeActionDefinitionsFromServer = map;
    }

    public String toString() {
        return "Definitions(actionDefinitions=" + this.actionDefinitions + ", devModeActionDefinitionsFromServer=" + this.devModeActionDefinitionsFromServer + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Definitions(List list, Map map, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? new ArrayList() : list, (i10 & 2) != 0 ? null : map);
    }
}
