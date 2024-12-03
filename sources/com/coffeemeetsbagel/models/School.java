package com.coffeemeetsbagel.models;

import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class School {
    private final String name;

    public School(String str) {
        j.g(str, "name");
        this.name = str;
    }

    public static /* synthetic */ School copy$default(School school, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = school.name;
        }
        return school.copy(str);
    }

    public final String component1() {
        return this.name;
    }

    public final School copy(String str) {
        j.g(str, "name");
        return new School(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof School) && j.b(this.name, ((School) obj).name);
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public String toString() {
        return "School(name=" + this.name + PropertyUtils.MAPPED_DELIM2;
    }
}
