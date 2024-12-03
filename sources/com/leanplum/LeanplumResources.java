package com.leanplum;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import com.leanplum.internal.CollectionUtil;
import com.leanplum.internal.FileManager;
import com.leanplum.internal.Log;
import com.leanplum.internal.ResourceQualifiers;
import com.leanplum.internal.VarCache;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeanplumResources extends Resources {
    public LeanplumResources(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
    }

    public Drawable getDrawable(int i10) throws Resources.NotFoundException {
        Drawable createFromStream;
        try {
            Var overrideResource = getOverrideResource(i10);
            if (overrideResource != null) {
                int overrideResId = overrideResource.overrideResId();
                if (overrideResId != 0) {
                    return super.getDrawable(overrideResId);
                }
                if (!overrideResource.stringValue.equals(overrideResource.defaultValue()) && (createFromStream = Drawable.createFromStream(overrideResource.stream(), overrideResource.fileValue())) != null) {
                    return createFromStream;
                }
            }
        } catch (Throwable th2) {
            Log.exception(th2);
        }
        return super.getDrawable(i10);
    }

    /* access modifiers changed from: package-private */
    public <T> Var<T> getOverrideResource(int i10) {
        try {
            String resourceEntryName = getResourceEntryName(i10);
            String resourceTypeName = getResourceTypeName(i10);
            Var<HashMap<String, Object>> var = FileManager.resources;
            if (var == null) {
                return null;
            }
            HashMap hashMap = (HashMap) CollectionUtil.uncheckedCast(var.objectForKeyPath(new Object[0]));
            HashMap hashMap2 = new HashMap();
            synchronized (VarCache.valuesFromClient) {
                for (String str : hashMap.keySet()) {
                    if (str.toLowerCase().startsWith(resourceTypeName)) {
                        String str2 = null;
                        for (String str3 : ((HashMap) CollectionUtil.uncheckedCast(hashMap.get(str))).keySet()) {
                            String replace = str3.replace("\\.", ".");
                            int lastIndexOf = replace.lastIndexOf(46);
                            if (lastIndexOf >= 0) {
                                replace = replace.substring(0, lastIndexOf);
                            }
                            if (replace.equals(resourceEntryName)) {
                                str2 = str3;
                            }
                        }
                        if (str2 != null) {
                            hashMap2.put(str, str2);
                        }
                    }
                }
            }
            HashMap hashMap3 = new HashMap();
            for (String str4 : hashMap2.keySet()) {
                hashMap3.put(str4, ResourceQualifiers.fromFolder(str4));
            }
            Configuration configuration = getConfiguration();
            DisplayMetrics displayMetrics = getDisplayMetrics();
            Set<String> hashSet = new HashSet<>();
            for (String str5 : hashMap2.keySet()) {
                ResourceQualifiers resourceQualifiers = (ResourceQualifiers) hashMap3.get(str5);
                for (ResourceQualifiers.Qualifier next : resourceQualifiers.qualifiers.keySet()) {
                    if (next.getFilter().isMatch(resourceQualifiers.qualifiers.get(next), configuration, displayMetrics)) {
                        hashSet.add(str5);
                    }
                }
            }
            for (ResourceQualifiers.Qualifier qualifier : ResourceQualifiers.Qualifier.values()) {
                HashMap hashMap4 = new HashMap();
                for (String next2 : hashSet) {
                    Object obj = ((ResourceQualifiers) hashMap3.get(next2)).qualifiers.get(qualifier);
                    if (obj != null) {
                        hashMap4.put(next2, obj);
                    }
                }
                Map<String, Object> bestMatch = qualifier.getFilter().bestMatch(hashMap4, configuration, displayMetrics);
                if (!bestMatch.isEmpty()) {
                    hashSet = bestMatch.keySet();
                }
            }
            if (!hashMap2.isEmpty()) {
                String str6 = (String) ((Map.Entry) hashMap2.entrySet().iterator().next()).getValue();
                return VarCache.getVariable("__Android Resources." + str6 + "." + ((String) hashMap2.get(str6)));
            }
            return null;
        } catch (Exception e10) {
            Log.e("Error getting resource", (Throwable) e10);
        }
    }
}
