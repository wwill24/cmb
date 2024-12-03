package com.coffeemeetsbagel.models.util;

import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CollectionUtils {
    public static boolean isEmpty(List list) {
        return list == null || list.size() == 0;
    }

    public static boolean isEmpty(Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }

    public static boolean isEmpty(Queue queue) {
        return queue == null || queue.size() == 0;
    }

    public static boolean isEmpty(Map<String, String> map) {
        return map == null || map.size() == 0;
    }
}
