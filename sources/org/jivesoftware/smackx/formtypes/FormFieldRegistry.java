package org.jivesoftware.smackx.formtypes;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlUtil;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.TextSingleFormField;
import org.jivesoftware.smackx.xdata.packet.DataForm;

public class FormFieldRegistry {
    private static final Map<String, FormField.Type> CLARK_NOTATION_FIELD_REGISTRY = new ConcurrentHashMap();
    private static final Logger LOGGER = Logger.getLogger(FormFieldRegistry.class.getName());
    private static final Map<String, FormField.Type> LOOKASIDE_FIELD_REGISTRY = new ConcurrentHashMap();
    private static final Map<String, Map<String, FormField.Type>> REGISTRY = new HashMap();

    public static void addLookasideFieldRegistryEntry(String str, FormField.Type type) {
        LOOKASIDE_FIELD_REGISTRY.put(str, type);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0030, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.jivesoftware.smackx.xdata.FormField.Type lookup(java.lang.String r1, java.lang.String r2) {
        /*
            if (r1 != 0) goto L_0x001a
            boolean r1 = org.jivesoftware.smack.util.XmlUtil.isClarkNotation(r2)
            if (r1 == 0) goto L_0x0011
            java.util.Map<java.lang.String, org.jivesoftware.smackx.xdata.FormField$Type> r1 = CLARK_NOTATION_FIELD_REGISTRY
            java.lang.Object r1 = r1.get(r2)
            org.jivesoftware.smackx.xdata.FormField$Type r1 = (org.jivesoftware.smackx.xdata.FormField.Type) r1
            return r1
        L_0x0011:
            java.util.Map<java.lang.String, org.jivesoftware.smackx.xdata.FormField$Type> r1 = LOOKASIDE_FIELD_REGISTRY
            java.lang.Object r1 = r1.get(r2)
            org.jivesoftware.smackx.xdata.FormField$Type r1 = (org.jivesoftware.smackx.xdata.FormField.Type) r1
            return r1
        L_0x001a:
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, org.jivesoftware.smackx.xdata.FormField$Type>> r0 = REGISTRY
            monitor-enter(r0)
            java.lang.Object r1 = r0.get(r1)     // Catch:{ all -> 0x0032 }
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ all -> 0x0032 }
            if (r1 == 0) goto L_0x002f
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x0032 }
            org.jivesoftware.smackx.xdata.FormField$Type r1 = (org.jivesoftware.smackx.xdata.FormField.Type) r1     // Catch:{ all -> 0x0032 }
            if (r1 == 0) goto L_0x002f
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            return r1
        L_0x002f:
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            r1 = 0
            return r1
        L_0x0032:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.formtypes.FormFieldRegistry.lookup(java.lang.String, java.lang.String):org.jivesoftware.smackx.xdata.FormField$Type");
    }

    public static void register(DataForm dataForm) {
        FormField.Type type;
        if (dataForm.getType() == DataForm.Type.form) {
            String str = null;
            TextSingleFormField hiddenFormTypeField = dataForm.getHiddenFormTypeField();
            if (hiddenFormTypeField != null) {
                str = hiddenFormTypeField.getValue();
            }
            for (FormField next : dataForm.getFields()) {
                if (!(next == hiddenFormTypeField || (type = next.getType()) == FormField.Type.fixed)) {
                    register(str, next.getFieldName(), type);
                }
            }
            return;
        }
        throw new IllegalArgumentException();
    }

    public static synchronized FormField.Type lookup(String str) {
        FormField.Type lookup;
        synchronized (FormFieldRegistry.class) {
            lookup = lookup((String) null, str);
        }
        return lookup;
    }

    public static void register(String str, FormField.Type type, String... strArr) {
        for (String register : strArr) {
            register(str, register, type);
        }
    }

    public static void register(String str, String str2, FormField.Type type) {
        FormField.Type type2;
        StringUtils.requireNotNullNorEmpty(str2, "fieldName must be provided");
        Objects.requireNonNull(type);
        if (str != null) {
            Map<String, Map<String, FormField.Type>> map = REGISTRY;
            synchronized (map) {
                Map map2 = map.get(str);
                if (map2 == null) {
                    map2 = new HashMap();
                    map.put(str, map2);
                } else {
                    FormField.Type type3 = (FormField.Type) map2.get(str2);
                    if (type3 != null) {
                        if (type3 != type) {
                            throw new IllegalArgumentException();
                        }
                    }
                }
                type2 = (FormField.Type) map2.put(str2, type);
            }
            if (type2 != null && type != type2) {
                Logger logger = LOGGER;
                logger.warning("Form field registry inconsitency detected: Registered field '" + str2 + "' of type " + type + " but previous type was " + type2);
            }
        } else if (XmlUtil.isClarkNotation(str2)) {
            CLARK_NOTATION_FIELD_REGISTRY.put(str2, type);
        }
    }
}
