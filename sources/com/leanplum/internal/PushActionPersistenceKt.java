package com.leanplum.internal;

import android.content.Context;
import com.leanplum.Leanplum;
import com.leanplum.internal.Constants;
import gk.f;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0005\u001a\u0014\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\u0002\u001a\u001c\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\u0002\u001a\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0001\u001a\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0001\"\u0014\u0010\u000b\u001a\u00020\u00018\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\f\"'\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"", "", "", "load", "records", "", "save", "occurrenceId", "recordOpenAction", "", "isOpened", "PREF_KEY", "Ljava/lang/String;", "", "records$delegate", "Lgk/f;", "getRecords", "()Ljava/util/Map;", "AndroidSDKPush_release"}, k = 2, mv = {1, 4, 2})
public final class PushActionPersistenceKt {
    private static final String PREF_KEY = "__leanplum_push_open_actions";
    private static final f records$delegate = b.b(PushActionPersistenceKt$records$2.INSTANCE);

    private static final Map<String, Long> getRecords() {
        return (Map) records$delegate.getValue();
    }

    public static final boolean isOpened(String str) {
        j.g(str, Constants.Keys.PUSH_METRIC_OCCURRENCE_ID);
        return getRecords().containsKey(str);
    }

    /* access modifiers changed from: private */
    public static final Map<String, Long> load() {
        Context context = Leanplum.getContext();
        if (context == null) {
            return new LinkedHashMap();
        }
        j.f(context, "Leanplum.getContext() ?: return mutableMapOf()");
        Object uncheckedCast = CollectionUtil.uncheckedCast(JsonConverter.fromJson(context.getSharedPreferences(Constants.Defaults.MESSAGING_PREF_NAME, 0).getString(PREF_KEY, "{}")));
        j.f(uncheckedCast, "CollectionUtil.unchecked…ter.fromJson(savedValue))");
        return (Map) uncheckedCast;
    }

    public static final void recordOpenAction(String str) {
        j.g(str, Constants.Keys.PUSH_METRIC_OCCURRENCE_ID);
        getRecords().put(str, Long.valueOf(Clock.getInstance().currentTimeMillis()));
        save(getRecords());
    }

    /* access modifiers changed from: private */
    public static final void save(Map<String, Long> map) {
        Context context = Leanplum.getContext();
        if (context != null) {
            j.f(context, "Leanplum.getContext() ?: return");
            context.getSharedPreferences(Constants.Defaults.MESSAGING_PREF_NAME, 0).edit().putString(PREF_KEY, JsonConverter.toJson(map)).apply();
        }
    }
}
