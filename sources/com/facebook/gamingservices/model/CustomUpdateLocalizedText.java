package com.facebook.gamingservices.model;

import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;
import org.json.b;

@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u0017\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006HÆ\u0003J+\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00042\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006HÆ\u0001J\t\u0010\u000b\u001a\u00020\u0004HÖ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R%\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/facebook/gamingservices/model/CustomUpdateLocalizedText;", "", "Lorg/json/b;", "toJSONObject", "", "component1", "Ljava/util/HashMap;", "component2", "default", "localizations", "copy", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getDefault", "()Ljava/lang/String;", "Ljava/util/HashMap;", "getLocalizations", "()Ljava/util/HashMap;", "<init>", "(Ljava/lang/String;Ljava/util/HashMap;)V", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1})
public final class CustomUpdateLocalizedText {

    /* renamed from: default  reason: not valid java name */
    private final String f3default;
    private final HashMap<String, String> localizations;

    public CustomUpdateLocalizedText(String str, HashMap<String, String> hashMap) {
        j.g(str, "default");
        this.f3default = str;
        this.localizations = hashMap;
    }

    public static /* synthetic */ CustomUpdateLocalizedText copy$default(CustomUpdateLocalizedText customUpdateLocalizedText, String str, HashMap<String, String> hashMap, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = customUpdateLocalizedText.f3default;
        }
        if ((i10 & 2) != 0) {
            hashMap = customUpdateLocalizedText.localizations;
        }
        return customUpdateLocalizedText.copy(str, hashMap);
    }

    public final String component1() {
        return this.f3default;
    }

    public final HashMap<String, String> component2() {
        return this.localizations;
    }

    public final CustomUpdateLocalizedText copy(String str, HashMap<String, String> hashMap) {
        j.g(str, "default");
        return new CustomUpdateLocalizedText(str, hashMap);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomUpdateLocalizedText)) {
            return false;
        }
        CustomUpdateLocalizedText customUpdateLocalizedText = (CustomUpdateLocalizedText) obj;
        return j.b(this.f3default, customUpdateLocalizedText.f3default) && j.b(this.localizations, customUpdateLocalizedText.localizations);
    }

    public final String getDefault() {
        return this.f3default;
    }

    public final HashMap<String, String> getLocalizations() {
        return this.localizations;
    }

    public int hashCode() {
        int hashCode = this.f3default.hashCode() * 31;
        HashMap<String, String> hashMap = this.localizations;
        return hashCode + (hashMap == null ? 0 : hashMap.hashCode());
    }

    public final b toJSONObject() {
        b bVar = new b();
        bVar.put("default", (Object) this.f3default);
        HashMap<String, String> hashMap = this.localizations;
        if (hashMap != null) {
            b bVar2 = new b();
            for (Map.Entry next : hashMap.entrySet()) {
                bVar2.put((String) next.getKey(), (Object) (String) next.getValue());
            }
            bVar.put("localizations", (Object) bVar2);
        }
        return bVar;
    }

    public String toString() {
        return "CustomUpdateLocalizedText(default=" + this.f3default + ", localizations=" + this.localizations + PropertyUtils.MAPPED_DELIM2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CustomUpdateLocalizedText(String str, HashMap hashMap, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i10 & 2) != 0 ? null : hashMap);
    }
}
