package com.facebook.internal;

import android.os.Bundle;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import org.jivesoftware.smackx.json.packet.JsonPacketExtension;
import org.json.JSONException;
import org.json.a;
import org.json.b;

@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0007R$\u0010\u000b\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00020\n0\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/facebook/internal/BundleJSONConverter;", "", "Landroid/os/Bundle;", "bundle", "Lorg/json/b;", "convertToJSON", "jsonObject", "convertToBundle", "", "Ljava/lang/Class;", "Lcom/facebook/internal/BundleJSONConverter$Setter;", "SETTERS", "Ljava/util/Map;", "<init>", "()V", "Setter", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class BundleJSONConverter {
    public static final BundleJSONConverter INSTANCE = new BundleJSONConverter();
    private static final Map<Class<?>, Setter> SETTERS;

    @Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0001H&J \u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0001H&¨\u0006\f"}, d2 = {"Lcom/facebook/internal/BundleJSONConverter$Setter;", "", "Landroid/os/Bundle;", "bundle", "", "key", "value", "", "setOnBundle", "Lorg/json/b;", "json", "setOnJSON", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public interface Setter {
        void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException;

        void setOnJSON(b bVar, String str, Object obj) throws JSONException;
    }

    static {
        HashMap hashMap = new HashMap();
        SETTERS = hashMap;
        hashMap.put(Boolean.class, new Setter() {
            public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
                j.g(bundle, "bundle");
                j.g(str, SDKConstants.PARAM_KEY);
                j.g(obj, "value");
                bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            }

            public void setOnJSON(b bVar, String str, Object obj) throws JSONException {
                j.g(bVar, JsonPacketExtension.ELEMENT);
                j.g(str, SDKConstants.PARAM_KEY);
                j.g(obj, "value");
                bVar.put(str, obj);
            }
        });
        hashMap.put(Integer.class, new Setter() {
            public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
                j.g(bundle, "bundle");
                j.g(str, SDKConstants.PARAM_KEY);
                j.g(obj, "value");
                bundle.putInt(str, ((Integer) obj).intValue());
            }

            public void setOnJSON(b bVar, String str, Object obj) throws JSONException {
                j.g(bVar, JsonPacketExtension.ELEMENT);
                j.g(str, SDKConstants.PARAM_KEY);
                j.g(obj, "value");
                bVar.put(str, obj);
            }
        });
        hashMap.put(Long.class, new Setter() {
            public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
                j.g(bundle, "bundle");
                j.g(str, SDKConstants.PARAM_KEY);
                j.g(obj, "value");
                bundle.putLong(str, ((Long) obj).longValue());
            }

            public void setOnJSON(b bVar, String str, Object obj) throws JSONException {
                j.g(bVar, JsonPacketExtension.ELEMENT);
                j.g(str, SDKConstants.PARAM_KEY);
                j.g(obj, "value");
                bVar.put(str, obj);
            }
        });
        hashMap.put(Double.class, new Setter() {
            public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
                j.g(bundle, "bundle");
                j.g(str, SDKConstants.PARAM_KEY);
                j.g(obj, "value");
                bundle.putDouble(str, ((Double) obj).doubleValue());
            }

            public void setOnJSON(b bVar, String str, Object obj) throws JSONException {
                j.g(bVar, JsonPacketExtension.ELEMENT);
                j.g(str, SDKConstants.PARAM_KEY);
                j.g(obj, "value");
                bVar.put(str, obj);
            }
        });
        hashMap.put(String.class, new Setter() {
            public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
                j.g(bundle, "bundle");
                j.g(str, SDKConstants.PARAM_KEY);
                j.g(obj, "value");
                bundle.putString(str, (String) obj);
            }

            public void setOnJSON(b bVar, String str, Object obj) throws JSONException {
                j.g(bVar, JsonPacketExtension.ELEMENT);
                j.g(str, SDKConstants.PARAM_KEY);
                j.g(obj, "value");
                bVar.put(str, obj);
            }
        });
        hashMap.put(String[].class, new Setter() {
            public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
                j.g(bundle, "bundle");
                j.g(str, SDKConstants.PARAM_KEY);
                j.g(obj, "value");
                throw new IllegalArgumentException("Unexpected type from JSON");
            }

            public void setOnJSON(b bVar, String str, Object obj) throws JSONException {
                j.g(bVar, JsonPacketExtension.ELEMENT);
                j.g(str, SDKConstants.PARAM_KEY);
                j.g(obj, "value");
                a aVar = new a();
                String[] strArr = (String[]) obj;
                int length = strArr.length;
                int i10 = 0;
                while (i10 < length) {
                    String str2 = strArr[i10];
                    i10++;
                    aVar.E(str2);
                }
                bVar.put(str, (Object) aVar);
            }
        });
        hashMap.put(a.class, new Setter() {
            public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
                j.g(bundle, "bundle");
                j.g(str, SDKConstants.PARAM_KEY);
                j.g(obj, "value");
                a aVar = (a) obj;
                ArrayList arrayList = new ArrayList();
                if (aVar.o() == 0) {
                    bundle.putStringArrayList(str, arrayList);
                    return;
                }
                int i10 = 0;
                int o10 = aVar.o();
                if (o10 > 0) {
                    while (true) {
                        int i11 = i10 + 1;
                        Object obj2 = aVar.get(i10);
                        if (obj2 instanceof String) {
                            arrayList.add(obj2);
                            if (i11 >= o10) {
                                break;
                            }
                            i10 = i11;
                        } else {
                            throw new IllegalArgumentException(j.p("Unexpected type in an array: ", obj2.getClass()));
                        }
                    }
                }
                bundle.putStringArrayList(str, arrayList);
            }

            public void setOnJSON(b bVar, String str, Object obj) throws JSONException {
                j.g(bVar, JsonPacketExtension.ELEMENT);
                j.g(str, SDKConstants.PARAM_KEY);
                j.g(obj, "value");
                throw new IllegalArgumentException("JSONArray's are not supported in bundles.");
            }
        });
    }

    private BundleJSONConverter() {
    }

    public static final Bundle convertToBundle(b bVar) throws JSONException {
        j.g(bVar, "jsonObject");
        Bundle bundle = new Bundle();
        Iterator<String> keys = bVar.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = bVar.get(next);
            if (obj != b.NULL) {
                if (obj instanceof b) {
                    bundle.putBundle(next, convertToBundle((b) obj));
                } else {
                    Setter setter = SETTERS.get(obj.getClass());
                    if (setter != null) {
                        j.f(next, SDKConstants.PARAM_KEY);
                        j.f(obj, "value");
                        setter.setOnBundle(bundle, next, obj);
                    } else {
                        throw new IllegalArgumentException(j.p("Unsupported type: ", obj.getClass()));
                    }
                }
            }
        }
        return bundle;
    }

    public static final b convertToJSON(Bundle bundle) throws JSONException {
        j.g(bundle, "bundle");
        b bVar = new b();
        for (String next : bundle.keySet()) {
            Object obj = bundle.get(next);
            if (obj != null) {
                if (obj instanceof List) {
                    a aVar = new a();
                    for (String E : (List) obj) {
                        aVar.E(E);
                    }
                    bVar.put(next, (Object) aVar);
                } else if (obj instanceof Bundle) {
                    bVar.put(next, (Object) convertToJSON((Bundle) obj));
                } else {
                    Setter setter = SETTERS.get(obj.getClass());
                    if (setter != null) {
                        j.f(next, SDKConstants.PARAM_KEY);
                        setter.setOnJSON(bVar, next, obj);
                    } else {
                        throw new IllegalArgumentException(j.p("Unsupported type: ", obj.getClass()));
                    }
                }
            }
        }
        return bVar;
    }
}
