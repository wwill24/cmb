package com.google.firebase.database.core;

import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ValidationPath {
    public static final int MAX_PATH_DEPTH = 32;
    public static final int MAX_PATH_LENGTH_BYTES = 768;
    private int byteLength;
    private final List<String> parts = new ArrayList();

    private ValidationPath(Path path) throws DatabaseException {
        this.byteLength = 0;
        Iterator<ChildKey> it = path.iterator();
        while (it.hasNext()) {
            this.parts.add(it.next().asString());
        }
        this.byteLength = Math.max(1, this.parts.size());
        for (int i10 = 0; i10 < this.parts.size(); i10++) {
            this.byteLength += utf8Bytes(this.parts.get(i10));
        }
        checkValid();
    }

    private void checkValid() throws DatabaseException {
        if (this.byteLength > 768) {
            throw new DatabaseException("Data has a key path longer than 768 bytes (" + this.byteLength + ").");
        } else if (this.parts.size() > 32) {
            throw new DatabaseException("Path specified exceeds the maximum depth that can be written (32) or object contains a cycle " + toErrorString());
        }
    }

    private static String joinStringList(String str, List<String> list) {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (i10 > 0) {
                sb2.append(str);
            }
            sb2.append(list.get(i10));
        }
        return sb2.toString();
    }

    private String pop() {
        List<String> list = this.parts;
        String remove = list.remove(list.size() - 1);
        this.byteLength -= utf8Bytes(remove);
        if (this.parts.size() > 0) {
            this.byteLength--;
        }
        return remove;
    }

    private void push(String str) throws DatabaseException {
        if (this.parts.size() > 0) {
            this.byteLength++;
        }
        this.parts.add(str);
        this.byteLength += utf8Bytes(str);
        checkValid();
    }

    private String toErrorString() {
        if (this.parts.size() == 0) {
            return "";
        }
        return "in path '" + joinStringList(RemoteSettings.FORWARD_SLASH_STRING, this.parts) + "'";
    }

    private static int utf8Bytes(CharSequence charSequence) {
        int length = charSequence.length();
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            char charAt = charSequence.charAt(i10);
            if (charAt <= 127) {
                i11++;
            } else if (charAt <= 2047) {
                i11 += 2;
            } else if (Character.isHighSurrogate(charAt)) {
                i11 += 4;
                i10++;
            } else {
                i11 += 3;
            }
            i10++;
        }
        return i11;
    }

    public static void validateWithObject(Path path, Object obj) throws DatabaseException {
        new ValidationPath(path).withObject(obj);
    }

    private void withObject(Object obj) throws DatabaseException {
        if (obj instanceof Map) {
            Map map = (Map) obj;
            for (String str : map.keySet()) {
                if (!str.startsWith(".")) {
                    push(str);
                    withObject(map.get(str));
                    pop();
                }
            }
        } else if (obj instanceof List) {
            List list = (List) obj;
            for (int i10 = 0; i10 < list.size(); i10++) {
                push(Integer.toString(i10));
                withObject(list.get(i10));
                pop();
            }
        }
    }
}
