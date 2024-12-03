package com.facebook.share.internal;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.share.model.CameraEffectArguments;
import gk.h;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import org.json.JSONException;
import org.json.a;
import org.json.b;

@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0007R8\u0010\f\u001a&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00020\n0\bj\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00020\n`\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/facebook/share/internal/CameraEffectJSONUtility;", "", "Lcom/facebook/share/model/CameraEffectArguments;", "arguments", "Lorg/json/b;", "convertToJSON", "jsonObject", "convertToCameraEffectArguments", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Lcom/facebook/share/internal/CameraEffectJSONUtility$Setter;", "Lkotlin/collections/HashMap;", "SETTERS", "Ljava/util/HashMap;", "<init>", "()V", "Setter", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
public final class CameraEffectJSONUtility {
    public static final CameraEffectJSONUtility INSTANCE = new CameraEffectJSONUtility();
    private static final HashMap<Class<?>, Setter> SETTERS = h0.k(h.a(String.class, new CameraEffectJSONUtility$SETTERS$1()), h.a(String[].class, new CameraEffectJSONUtility$SETTERS$2()), h.a(a.class, new CameraEffectJSONUtility$SETTERS$3()));

    @Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bb\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H&J\"\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H&¨\u0006\f"}, d2 = {"Lcom/facebook/share/internal/CameraEffectJSONUtility$Setter;", "", "Lcom/facebook/share/model/CameraEffectArguments$Builder;", "builder", "", "key", "value", "", "setOnArgumentsBuilder", "Lorg/json/b;", "json", "setOnJSON", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
    private interface Setter {
        void setOnArgumentsBuilder(CameraEffectArguments.Builder builder, String str, Object obj) throws JSONException;

        void setOnJSON(b bVar, String str, Object obj) throws JSONException;
    }

    private CameraEffectJSONUtility() {
    }

    public static final CameraEffectArguments convertToCameraEffectArguments(b bVar) throws JSONException {
        if (bVar == null) {
            return null;
        }
        CameraEffectArguments.Builder builder = new CameraEffectArguments.Builder();
        Iterator<String> keys = bVar.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = bVar.get(next);
            if (obj != b.NULL) {
                Setter setter = SETTERS.get(obj.getClass());
                if (setter != null) {
                    j.f(next, SDKConstants.PARAM_KEY);
                    setter.setOnArgumentsBuilder(builder, next, obj);
                } else {
                    throw new IllegalArgumentException(j.p("Unsupported type: ", obj.getClass()));
                }
            }
        }
        return builder.build();
    }

    public static final b convertToJSON(CameraEffectArguments cameraEffectArguments) throws JSONException {
        if (cameraEffectArguments == null) {
            return null;
        }
        b bVar = new b();
        for (String next : cameraEffectArguments.keySet()) {
            Object obj = cameraEffectArguments.get(next);
            if (obj != null) {
                Setter setter = SETTERS.get(obj.getClass());
                if (setter != null) {
                    setter.setOnJSON(bVar, next, obj);
                } else {
                    throw new IllegalArgumentException(j.p("Unsupported type: ", obj.getClass()));
                }
            }
        }
        return bVar;
    }
}
