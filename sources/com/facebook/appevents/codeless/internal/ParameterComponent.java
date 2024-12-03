package com.facebook.appevents.codeless.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.json.a;
import org.json.b;

@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/facebook/appevents/codeless/internal/ParameterComponent;", "", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "value", "getValue", "", "Lcom/facebook/appevents/codeless/internal/PathComponent;", "path", "Ljava/util/List;", "getPath", "()Ljava/util/List;", "pathType", "getPathType", "Lorg/json/b;", "component", "<init>", "(Lorg/json/b;)V", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class ParameterComponent {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String PARAMETER_NAME_KEY = "name";
    private static final String PARAMETER_PATH_KEY = "path";
    private static final String PARAMETER_VALUE_KEY = "value";
    private final String name;
    private final List<PathComponent> path;
    private final String pathType;
    private final String value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/facebook/appevents/codeless/internal/ParameterComponent$Companion;", "", "()V", "PARAMETER_NAME_KEY", "", "PARAMETER_PATH_KEY", "PARAMETER_VALUE_KEY", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ParameterComponent(b bVar) {
        j.g(bVar, "component");
        String string = bVar.getString("name");
        j.f(string, "component.getString(PARAMETER_NAME_KEY)");
        this.name = string;
        String optString = bVar.optString("value");
        j.f(optString, "component.optString(PARAMETER_VALUE_KEY)");
        this.value = optString;
        String optString2 = bVar.optString(Constants.EVENT_MAPPING_PATH_TYPE_KEY, Constants.PATH_TYPE_ABSOLUTE);
        j.f(optString2, "component.optString(Constants.EVENT_MAPPING_PATH_TYPE_KEY, Constants.PATH_TYPE_ABSOLUTE)");
        this.pathType = optString2;
        ArrayList arrayList = new ArrayList();
        a optJSONArray = bVar.optJSONArray(PARAMETER_PATH_KEY);
        if (optJSONArray != null) {
            int i10 = 0;
            int o10 = optJSONArray.o();
            if (o10 > 0) {
                while (true) {
                    int i11 = i10 + 1;
                    b j10 = optJSONArray.j(i10);
                    j.f(j10, "jsonPathArray.getJSONObject(i)");
                    arrayList.add(new PathComponent(j10));
                    if (i11 >= o10) {
                        break;
                    }
                    i10 = i11;
                }
            }
        }
        this.path = arrayList;
    }

    public final String getName() {
        return this.name;
    }

    public final List<PathComponent> getPath() {
        return this.path;
    }

    public final String getPathType() {
        return this.pathType;
    }

    public final String getValue() {
        return this.value;
    }
}
