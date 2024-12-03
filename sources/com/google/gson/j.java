package com.google.gson;

import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.StringWriter;

public abstract class j {
    public g b() {
        if (g()) {
            return (g) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public l d() {
        if (j()) {
            return (l) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public m f() {
        if (m()) {
            return (m) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public boolean g() {
        return this instanceof g;
    }

    public boolean i() {
        return this instanceof k;
    }

    public boolean j() {
        return this instanceof l;
    }

    public boolean m() {
        return this instanceof m;
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            JsonWriter jsonWriter = new JsonWriter(stringWriter);
            jsonWriter.setLenient(true);
            com.google.gson.internal.j.b(this, jsonWriter);
            return stringWriter.toString();
        } catch (IOException e10) {
            throw new AssertionError(e10);
        }
    }
}
