package com.coffeemeetsbagel.models.enums;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.DefaultConstructorMarker;

public enum MatchAction {
    NONE(0),
    LIKE(1),
    PASS(2),
    CHECK(3);
    
    public static final Companion Companion = null;
    /* access modifiers changed from: private */
    public static final Map<Integer, MatchAction> map = null;

    /* renamed from: id  reason: collision with root package name */
    private final int f34728id;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MatchAction fromId(int i10) {
            try {
                return (MatchAction) h0.j(MatchAction.map, Integer.valueOf(i10));
            } catch (NoSuchElementException unused) {
                return MatchAction.NONE;
            }
        }
    }

    static {
        int i10;
        Companion = new Companion((DefaultConstructorMarker) null);
        MatchAction[] values = values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(j.c(g0.e(values.length), 16));
        for (MatchAction matchAction : values) {
            linkedHashMap.put(Integer.valueOf(matchAction.f34728id), matchAction);
        }
        map = linkedHashMap;
    }

    private MatchAction(int i10) {
        this.f34728id = i10;
    }

    public final int getId() {
        return this.f34728id;
    }
}
