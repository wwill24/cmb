package com.leanplum.internal;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.leanplum.Leanplum;
import com.leanplum.internal.Constants;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class RequestUuidHelper {
    public void attachNewUuid(@NonNull List<Map<String, Object>> list) {
        String uuid = UUID.randomUUID().toString();
        for (Map<String, Object> put : list) {
            put.put(Constants.Params.UUID, uuid);
        }
    }

    public boolean attachUuid(@NonNull Map<String, Object> map) {
        Context context = Leanplum.getContext();
        if (context == null) {
            return false;
        }
        long eventsCount = LeanplumEventDataManager.sharedInstance().getEventsCount();
        String loadUuid = loadUuid();
        if (loadUuid == null || eventsCount % ((long) RequestBatchFactory.MAX_EVENTS_PER_API_CALL) == 0) {
            loadUuid = saveNewUuid(context);
        }
        map.put(Constants.Params.UUID, loadUuid);
        return true;
    }

    public void deleteUuid() {
        Context context = Leanplum.getContext();
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences(Constants.Defaults.LEANPLUM, 0).edit();
            edit.remove(Constants.Defaults.UUID_KEY);
            edit.apply();
        }
    }

    public String loadUuid() {
        Context context = Leanplum.getContext();
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences(Constants.Defaults.LEANPLUM, 0).getString(Constants.Defaults.UUID_KEY, (String) null);
    }

    @NonNull
    public String saveNewUuid(Context context) {
        String uuid = UUID.randomUUID().toString();
        SharedPreferences.Editor edit = context.getSharedPreferences(Constants.Defaults.LEANPLUM, 0).edit();
        edit.putString(Constants.Defaults.UUID_KEY, uuid);
        edit.apply();
        return uuid;
    }
}
