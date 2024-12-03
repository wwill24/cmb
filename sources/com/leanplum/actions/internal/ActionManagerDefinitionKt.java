package com.leanplum.actions.internal;

import com.leanplum.internal.ActionManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a8\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00032\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003H\u0002\u001a\n\u0010\u0007\u001a\u00020\u0001*\u00020\b\u001a\u0012\u0010\t\u001a\u00020\n*\u00020\b2\u0006\u0010\u000b\u001a\u00020\f\u001a$\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003*\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u001a\u0018\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003*\u00020\b\u001a\"\u0010\u0010\u001a\u00020\n*\u00020\b2\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003¨\u0006\u0012"}, d2 = {"areActionDefinitionsEqual", "", "a", "", "", "", "b", "areLocalAndServerDefinitionsEqual", "Lcom/leanplum/internal/ActionManager;", "defineAction", "", "definition", "Lcom/leanplum/actions/internal/ActionDefinition;", "getActionDefinitionMap", "actionName", "getActionDefinitionMaps", "setDevModeActionDefinitionsFromServer", "serverDefs", "AndroidSDKCore_release"}, k = 2, mv = {1, 4, 2})
public final class ActionManagerDefinitionKt {
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x009e, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final boolean areActionDefinitionsEqual(java.util.Map<java.lang.String, ? extends java.lang.Object> r11, java.util.Map<java.lang.String, ? extends java.lang.Object> r12) {
        /*
            r0 = 0
            if (r11 == 0) goto L_0x00a9
            if (r12 == 0) goto L_0x00a9
            int r1 = r11.size()
            int r2 = r12.size()
            if (r1 == r2) goto L_0x0011
            goto L_0x00a9
        L_0x0011:
            java.util.Set r11 = r11.entrySet()
            java.util.Iterator r11 = r11.iterator()
        L_0x0019:
            boolean r1 = r11.hasNext()
            r2 = 1
            if (r1 == 0) goto L_0x00a8
            java.lang.Object r1 = r11.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r3 = r1.getKey()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r1 = r1.getValue()
            if (r1 == 0) goto L_0x00a7
            java.lang.Object r4 = r12.get(r3)
            if (r4 != 0) goto L_0x003a
            goto L_0x00a7
        L_0x003a:
            java.util.Map r1 = (java.util.Map) r1
            java.lang.Object r3 = r12.get(r3)
            if (r3 == 0) goto L_0x009f
            java.util.Map r3 = (java.util.Map) r3
            java.lang.String r4 = "kind"
            java.lang.Object r5 = r1.get(r4)
            java.lang.String r6 = "values"
            java.lang.Object r7 = r1.get(r6)
            java.lang.String r8 = "kinds"
            java.lang.Object r9 = r1.get(r8)
            java.lang.String r10 = "options"
            java.lang.Object r1 = r1.get(r10)
            if (r5 == 0) goto L_0x0069
            java.lang.Object r4 = r3.get(r4)
            boolean r4 = kotlin.jvm.internal.j.b(r5, r4)
            r4 = r4 ^ r2
            if (r4 != 0) goto L_0x009e
        L_0x0069:
            if (r7 == 0) goto L_0x0076
            java.lang.Object r4 = r3.get(r6)
            boolean r4 = kotlin.jvm.internal.j.b(r7, r4)
            r4 = r4 ^ r2
            if (r4 != 0) goto L_0x009e
        L_0x0076:
            if (r9 == 0) goto L_0x0083
            java.lang.Object r4 = r3.get(r8)
            boolean r4 = kotlin.jvm.internal.j.b(r9, r4)
            r4 = r4 ^ r2
            if (r4 != 0) goto L_0x009e
        L_0x0083:
            if (r1 != 0) goto L_0x0087
            r4 = r2
            goto L_0x0088
        L_0x0087:
            r4 = r0
        L_0x0088:
            java.lang.Object r5 = r3.get(r10)
            if (r5 != 0) goto L_0x008f
            goto L_0x0090
        L_0x008f:
            r2 = r0
        L_0x0090:
            if (r4 != r2) goto L_0x009e
            if (r1 == 0) goto L_0x0019
            java.lang.Object r2 = r3.get(r10)
            boolean r1 = kotlin.jvm.internal.j.b(r1, r2)
            if (r1 == 0) goto L_0x0019
        L_0x009e:
            return r0
        L_0x009f:
            java.lang.NullPointerException r11 = new java.lang.NullPointerException
            java.lang.String r12 = "null cannot be cast to non-null type kotlin.collections.Map<*, *>"
            r11.<init>(r12)
            throw r11
        L_0x00a7:
            return r0
        L_0x00a8:
            return r2
        L_0x00a9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.leanplum.actions.internal.ActionManagerDefinitionKt.areActionDefinitionsEqual(java.util.Map, java.util.Map):boolean");
    }

    public static final boolean areLocalAndServerDefinitionsEqual(ActionManager actionManager) {
        j.g(actionManager, "$this$areLocalAndServerDefinitionsEqual");
        return areActionDefinitionsEqual(getActionDefinitionMaps(actionManager), actionManager.getDefinitions().getDevModeActionDefinitionsFromServer());
    }

    public static final void defineAction(ActionManager actionManager, ActionDefinition actionDefinition) {
        T t10;
        j.g(actionManager, "$this$defineAction");
        j.g(actionDefinition, "definition");
        List<ActionDefinition> actionDefinitions = actionManager.getDefinitions().getActionDefinitions();
        Iterator<T> it = actionDefinitions.iterator();
        while (true) {
            if (!it.hasNext()) {
                t10 = null;
                break;
            }
            t10 = it.next();
            if (j.b(((ActionDefinition) t10).getName(), actionDefinition.getName())) {
                break;
            }
        }
        ActionDefinition actionDefinition2 = (ActionDefinition) t10;
        if (actionDefinition2 != null) {
            actionDefinitions.remove(actionDefinition2);
        }
        actionDefinitions.add(actionDefinition);
    }

    public static final Map<String, Object> getActionDefinitionMap(ActionManager actionManager, String str) {
        j.g(actionManager, "$this$getActionDefinitionMap");
        ActionDefinition findDefinition = actionManager.getDefinitions().findDefinition(str);
        if (findDefinition != null) {
            return findDefinition.getDefinitionMap();
        }
        return null;
    }

    public static final Map<String, Object> getActionDefinitionMaps(ActionManager actionManager) {
        j.g(actionManager, "$this$getActionDefinitionMaps");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (ActionDefinition actionDefinition : actionManager.getDefinitions().getActionDefinitions()) {
            linkedHashMap.put(actionDefinition.getName(), actionDefinition.getDefinitionMap());
        }
        return linkedHashMap;
    }

    public static final void setDevModeActionDefinitionsFromServer(ActionManager actionManager, Map<String, ? extends Object> map) {
        j.g(actionManager, "$this$setDevModeActionDefinitionsFromServer");
        actionManager.getDefinitions().setDevModeActionDefinitionsFromServer(map);
    }
}
