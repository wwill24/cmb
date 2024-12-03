package org.apache.commons.validator;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ValidatorResults implements Serializable {
    private static final long serialVersionUID = -2709911078904924839L;
    protected Map<String, ValidatorResult> hResults = new HashMap();

    public void add(Field field, String str, boolean z10) {
        add(field, str, z10, (Object) null);
    }

    public void clear() {
        this.hResults.clear();
    }

    public Set<String> getPropertyNames() {
        return Collections.unmodifiableSet(this.hResults.keySet());
    }

    public Map<String, Object> getResultValueMap() {
        HashMap hashMap = new HashMap();
        for (String next : this.hResults.keySet()) {
            ValidatorResult validatorResult = getValidatorResult(next);
            Iterator<String> actions = validatorResult.getActions();
            while (actions.hasNext()) {
                Object result = validatorResult.getResult(actions.next());
                if (result != null && !(result instanceof Boolean)) {
                    hashMap.put(next, result);
                }
            }
        }
        return hashMap;
    }

    public ValidatorResult getValidatorResult(String str) {
        return this.hResults.get(str);
    }

    public boolean isEmpty() {
        return this.hResults.isEmpty();
    }

    public void merge(ValidatorResults validatorResults) {
        this.hResults.putAll(validatorResults.hResults);
    }

    public void add(Field field, String str, boolean z10, Object obj) {
        ValidatorResult validatorResult = getValidatorResult(field.getKey());
        if (validatorResult == null) {
            validatorResult = new ValidatorResult(field);
            this.hResults.put(field.getKey(), validatorResult);
        }
        validatorResult.add(str, z10, obj);
    }
}
