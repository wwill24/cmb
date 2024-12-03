package com.coffeemeetsbagel.dialogs;

import com.coffeemeetsbagel.dialogs.b;
import com.coffeemeetsbagel.models.dto.Option;
import kotlin.jvm.internal.j;
import org.jivesoftware.smackx.xdata.FormField;

public final class k implements b.a {

    /* renamed from: a  reason: collision with root package name */
    private final Option f12117a;

    public k(Option option) {
        j.g(option, FormField.Option.ELEMENT);
        this.f12117a = option;
    }

    public String a() {
        return this.f12117a.getTitle();
    }

    public final String b() {
        return this.f12117a.getId();
    }
}
