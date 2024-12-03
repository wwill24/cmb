package com.facebook.appevents.codeless.internal;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.json.JSONException;
import org.json.a;
import org.json.b;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 \"2\u00020\u0001:\u0003!\"#BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\n\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003¢\u0006\u0002\u0010\u0011R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\n8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8F¢\u0006\u0006\u001a\u0004\b \u0010\u001e¨\u0006$"}, d2 = {"Lcom/facebook/appevents/codeless/internal/EventBinding;", "", "eventName", "", "method", "Lcom/facebook/appevents/codeless/internal/EventBinding$MappingMethod;", "type", "Lcom/facebook/appevents/codeless/internal/EventBinding$ActionType;", "appVersion", "path", "", "Lcom/facebook/appevents/codeless/internal/PathComponent;", "parameters", "Lcom/facebook/appevents/codeless/internal/ParameterComponent;", "componentId", "pathType", "activityName", "(Ljava/lang/String;Lcom/facebook/appevents/codeless/internal/EventBinding$MappingMethod;Lcom/facebook/appevents/codeless/internal/EventBinding$ActionType;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActivityName", "()Ljava/lang/String;", "getAppVersion", "getComponentId", "getEventName", "getMethod", "()Lcom/facebook/appevents/codeless/internal/EventBinding$MappingMethod;", "getPathType", "getType", "()Lcom/facebook/appevents/codeless/internal/EventBinding$ActionType;", "viewParameters", "getViewParameters", "()Ljava/util/List;", "viewPath", "getViewPath", "ActionType", "Companion", "MappingMethod", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class EventBinding {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String activityName;
    private final String appVersion;
    private final String componentId;
    private final String eventName;
    private final MappingMethod method;
    private final List<ParameterComponent> parameters;
    private final List<PathComponent> path;
    private final String pathType;
    private final ActionType type;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/facebook/appevents/codeless/internal/EventBinding$ActionType;", "", "(Ljava/lang/String;I)V", "CLICK", "SELECTED", "TEXT_CHANGED", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum ActionType {
        CLICK,
        SELECTED,
        TEXT_CHANGED
    }

    @Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0007¨\u0006\f"}, d2 = {"Lcom/facebook/appevents/codeless/internal/EventBinding$Companion;", "", "Lorg/json/a;", "array", "", "Lcom/facebook/appevents/codeless/internal/EventBinding;", "parseArray", "Lorg/json/b;", "mapping", "getInstanceFromJson", "<init>", "()V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final EventBinding getInstanceFromJson(b bVar) throws JSONException, IllegalArgumentException {
            int o10;
            j.g(bVar, "mapping");
            String string = bVar.getString("event_name");
            String string2 = bVar.getString(FirebaseAnalytics.Param.METHOD);
            j.f(string2, "mapping.getString(\"method\")");
            Locale locale = Locale.ENGLISH;
            j.f(locale, ViewHierarchyConstants.ENGLISH);
            String upperCase = string2.toUpperCase(locale);
            j.f(upperCase, "(this as java.lang.String).toUpperCase(locale)");
            MappingMethod valueOf = MappingMethod.valueOf(upperCase);
            String string3 = bVar.getString("event_type");
            j.f(string3, "mapping.getString(\"event_type\")");
            j.f(locale, ViewHierarchyConstants.ENGLISH);
            String upperCase2 = string3.toUpperCase(locale);
            j.f(upperCase2, "(this as java.lang.String).toUpperCase(locale)");
            ActionType valueOf2 = ActionType.valueOf(upperCase2);
            String string4 = bVar.getString("app_version");
            a jSONArray = bVar.getJSONArray("path");
            ArrayList arrayList = new ArrayList();
            int o11 = jSONArray.o();
            int i10 = 0;
            if (o11 > 0) {
                int i11 = 0;
                while (true) {
                    int i12 = i11 + 1;
                    b j10 = jSONArray.j(i11);
                    j.f(j10, "jsonPath");
                    arrayList.add(new PathComponent(j10));
                    if (i12 >= o11) {
                        break;
                    }
                    i11 = i12;
                }
            }
            String optString = bVar.optString(Constants.EVENT_MAPPING_PATH_TYPE_KEY, Constants.PATH_TYPE_ABSOLUTE);
            a optJSONArray = bVar.optJSONArray("parameters");
            ArrayList arrayList2 = new ArrayList();
            if (optJSONArray != null && (o10 = optJSONArray.o()) > 0) {
                while (true) {
                    int i13 = i10 + 1;
                    b j11 = optJSONArray.j(i10);
                    j.f(j11, "jsonParameter");
                    arrayList2.add(new ParameterComponent(j11));
                    if (i13 >= o10) {
                        break;
                    }
                    i10 = i13;
                }
            }
            String optString2 = bVar.optString("component_id");
            String optString3 = bVar.optString("activity_name");
            j.f(string, "eventName");
            j.f(string4, RemoteConfigConstants.RequestFieldKey.APP_VERSION);
            j.f(optString2, "componentId");
            j.f(optString, "pathType");
            j.f(optString3, "activityName");
            return new EventBinding(string, valueOf, valueOf2, string4, arrayList, arrayList2, optString2, optString, optString3);
        }

        public final List<EventBinding> parseArray(a aVar) {
            ArrayList arrayList = new ArrayList();
            if (aVar != null) {
                int i10 = 0;
                try {
                    int o10 = aVar.o();
                    if (o10 > 0) {
                        while (true) {
                            int i11 = i10 + 1;
                            b j10 = aVar.j(i10);
                            j.f(j10, "array.getJSONObject(i)");
                            arrayList.add(getInstanceFromJson(j10));
                            if (i11 >= o10) {
                                break;
                            }
                            i10 = i11;
                        }
                    }
                } catch (IllegalArgumentException | JSONException unused) {
                }
            }
            return arrayList;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/facebook/appevents/codeless/internal/EventBinding$MappingMethod;", "", "(Ljava/lang/String;I)V", "MANUAL", "INFERENCE", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum MappingMethod {
        MANUAL,
        INFERENCE
    }

    public EventBinding(String str, MappingMethod mappingMethod, ActionType actionType, String str2, List<PathComponent> list, List<ParameterComponent> list2, String str3, String str4, String str5) {
        j.g(str, "eventName");
        j.g(mappingMethod, FirebaseAnalytics.Param.METHOD);
        j.g(actionType, "type");
        j.g(str2, RemoteConfigConstants.RequestFieldKey.APP_VERSION);
        j.g(list, "path");
        j.g(list2, "parameters");
        j.g(str3, "componentId");
        j.g(str4, "pathType");
        j.g(str5, "activityName");
        this.eventName = str;
        this.method = mappingMethod;
        this.type = actionType;
        this.appVersion = str2;
        this.path = list;
        this.parameters = list2;
        this.componentId = str3;
        this.pathType = str4;
        this.activityName = str5;
    }

    public static final EventBinding getInstanceFromJson(b bVar) throws JSONException, IllegalArgumentException {
        return Companion.getInstanceFromJson(bVar);
    }

    public static final List<EventBinding> parseArray(a aVar) {
        return Companion.parseArray(aVar);
    }

    public final String getActivityName() {
        return this.activityName;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final String getComponentId() {
        return this.componentId;
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final MappingMethod getMethod() {
        return this.method;
    }

    public final String getPathType() {
        return this.pathType;
    }

    public final ActionType getType() {
        return this.type;
    }

    public final List<ParameterComponent> getViewParameters() {
        List<ParameterComponent> unmodifiableList = Collections.unmodifiableList(this.parameters);
        j.f(unmodifiableList, "unmodifiableList(parameters)");
        return unmodifiableList;
    }

    public final List<PathComponent> getViewPath() {
        List<PathComponent> unmodifiableList = Collections.unmodifiableList(this.path);
        j.f(unmodifiableList, "unmodifiableList(path)");
        return unmodifiableList;
    }
}
