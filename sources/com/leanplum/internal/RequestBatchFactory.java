package com.leanplum.internal;

import androidx.annotation.NonNull;
import com.leanplum.internal.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestBatchFactory {
    static final int MAX_EVENTS_PER_API_CALL = 10000;
    private final RequestUuidHelper uuidHelper = new RequestUuidHelper();

    public RequestBatch createErrorBatch(List<Map<String, Object>> list) {
        ArrayList arrayList = new ArrayList();
        this.uuidHelper.attachNewUuid(list);
        return new RequestBatch(arrayList, arrayList, jsonEncodeRequests(arrayList));
    }

    public RequestBatch createNextBatch() {
        return createNextBatch(1.0d);
    }

    public void deleteFinishedBatch(@NonNull RequestBatch requestBatch) {
        int eventsCount = requestBatch.getEventsCount();
        if (eventsCount != 0) {
            LeanplumEventDataManager.sharedInstance().deleteEvents(eventsCount);
        }
    }

    public List<Map<String, Object>> getUnsentRequests(double d10) {
        List<Map<String, Object>> events = LeanplumEventDataManager.sharedInstance().getEvents((int) (((double) MAX_EVENTS_PER_API_CALL) * d10));
        this.uuidHelper.deleteUuid();
        if (d10 < 1.0d) {
            this.uuidHelper.attachNewUuid(events);
        }
        return events;
    }

    /* access modifiers changed from: protected */
    public String jsonEncodeRequests(List<Map<String, Object>> list) {
        HashMap hashMap = new HashMap();
        hashMap.put("data", list);
        return JsonConverter.toJson(hashMap);
    }

    /* access modifiers changed from: protected */
    public List<Map<String, Object>> removeIrrelevantBackgroundStartRequests(List<Map<String, Object>> list) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        if (size > 0) {
            for (int i10 = 0; i10 < size; i10++) {
                Map map = list.get(i10);
                if (i10 >= size - 1 || !"start".equals(list.get(i10 + 1).get("action")) || !"start".equals(map.get("action")) || !Boolean.TRUE.toString().equals(map.get(Constants.Params.BACKGROUND))) {
                    arrayList.add(map);
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public RequestBatch createNextBatch(double d10) {
        List list;
        List list2;
        if (d10 < 0.01d) {
            try {
                list2 = new ArrayList(0);
                list = new ArrayList(0);
            } catch (OutOfMemoryError unused) {
                return createNextBatch(d10 * 0.5d);
            }
        } else {
            list2 = getUnsentRequests(d10);
            list = removeIrrelevantBackgroundStartRequests(list2);
        }
        return new RequestBatch(list2, list, jsonEncodeRequests(list));
    }
}
