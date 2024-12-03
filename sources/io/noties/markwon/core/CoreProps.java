package io.noties.markwon.core;

import ij.o;

public abstract class CoreProps {

    /* renamed from: a  reason: collision with root package name */
    public static final o<ListItemType> f30053a = o.b("list-item-type");

    /* renamed from: b  reason: collision with root package name */
    public static final o<Integer> f30054b = o.b("bullet-list-item-level");

    /* renamed from: c  reason: collision with root package name */
    public static final o<Integer> f30055c = o.b("ordered-list-item-number");

    /* renamed from: d  reason: collision with root package name */
    public static final o<Integer> f30056d = o.b("heading-level");

    /* renamed from: e  reason: collision with root package name */
    public static final o<String> f30057e = o.b("link-destination");

    /* renamed from: f  reason: collision with root package name */
    public static final o<Boolean> f30058f = o.b("paragraph-is-in-tight-list");

    /* renamed from: g  reason: collision with root package name */
    public static final o<String> f30059g = o.b("code-block-info");

    public enum ListItemType {
        BULLET,
        ORDERED
    }
}
