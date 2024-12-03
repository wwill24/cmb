package org.bouncycastle.jcajce.util;

import java.security.PrivateKey;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AnnotatedPrivateKey implements PrivateKey {
    public static final String LABEL = "label";
    private final Map<String, Object> annotations;
    private final PrivateKey key;

    AnnotatedPrivateKey(PrivateKey privateKey, String str) {
        this.key = privateKey;
        this.annotations = Collections.singletonMap("label", str);
    }

    AnnotatedPrivateKey(PrivateKey privateKey, Map<String, Object> map) {
        this.key = privateKey;
        this.annotations = map;
    }

    public AnnotatedPrivateKey addAnnotation(String str, Object obj) {
        HashMap hashMap = new HashMap(this.annotations);
        hashMap.put(str, obj);
        return new AnnotatedPrivateKey(this.key, (Map<String, Object>) Collections.unmodifiableMap(hashMap));
    }

    public boolean equals(Object obj) {
        PrivateKey privateKey;
        if (obj instanceof AnnotatedPrivateKey) {
            privateKey = this.key;
            obj = ((AnnotatedPrivateKey) obj).key;
        } else {
            privateKey = this.key;
        }
        return privateKey.equals(obj);
    }

    public String getAlgorithm() {
        return this.key.getAlgorithm();
    }

    public Object getAnnotation(String str) {
        return this.annotations.get(str);
    }

    public Map<String, Object> getAnnotations() {
        return this.annotations;
    }

    public byte[] getEncoded() {
        return this.key.getEncoded();
    }

    public String getFormat() {
        return this.key.getFormat();
    }

    public PrivateKey getKey() {
        return this.key;
    }

    public int hashCode() {
        return this.key.hashCode();
    }

    public AnnotatedPrivateKey removeAnnotation(String str) {
        HashMap hashMap = new HashMap(this.annotations);
        hashMap.remove(str);
        return new AnnotatedPrivateKey(this.key, (Map<String, Object>) Collections.unmodifiableMap(hashMap));
    }

    public String toString() {
        return (this.annotations.containsKey("label") ? this.annotations.get("label") : this.key).toString();
    }
}
