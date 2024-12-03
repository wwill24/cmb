package com.coffeemeetsbagel.shop.main;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public enum MainShopTabs {
    SHOP("shop"),
    WALLET("wallet");
    

    /* renamed from: a  reason: collision with root package name */
    public static final a f36429a = null;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, MainShopTabs> f36430b = null;
    private final String tag;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MainShopTabs a(String str) {
            j.g(str, "tag");
            if (!MainShopTabs.f36430b.containsKey(str)) {
                return MainShopTabs.SHOP;
            }
            Object obj = MainShopTabs.f36430b.get(str);
            j.d(obj);
            return (MainShopTabs) obj;
        }
    }

    static {
        int i10;
        f36429a = new a((DefaultConstructorMarker) null);
        MainShopTabs[] values = values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(j.c(g0.e(values.length), 16));
        for (MainShopTabs mainShopTabs : values) {
            linkedHashMap.put(mainShopTabs.tag, mainShopTabs);
        }
        f36430b = linkedHashMap;
    }

    private MainShopTabs(String str) {
        this.tag = str;
    }
}
