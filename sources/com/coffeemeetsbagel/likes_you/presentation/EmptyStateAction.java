package com.coffeemeetsbagel.likes_you.presentation;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public enum EmptyStateAction {
    DISCOVER("DISCOVER"),
    PREFERENCES("EDIT_PREFERENCES"),
    UPSELL("SEE_SUBSCRIBER_BENEFITS");
    

    /* renamed from: a  reason: collision with root package name */
    public static final a f34259a = null;
    private final String emptyStateActionString;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final EmptyStateAction a(String str) {
            j.g(str, "string");
            for (EmptyStateAction emptyStateAction : EmptyStateAction.values()) {
                if (j.b(emptyStateAction.b(), str)) {
                    return emptyStateAction;
                }
            }
            return null;
        }
    }

    static {
        f34259a = new a((DefaultConstructorMarker) null);
    }

    private EmptyStateAction(String str) {
        this.emptyStateActionString = str;
    }

    public final String b() {
        return this.emptyStateActionString;
    }
}
