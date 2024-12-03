package org.apache.commons.validator;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ValidatorResult implements Serializable {
    private static final long serialVersionUID = -3713364681647250531L;
    protected Field field;
    protected Map<String, ResultStatus> hAction = new HashMap();

    public ValidatorResult(Field field2) {
        this.field = field2;
    }

    public void add(String str, boolean z10) {
        add(str, z10, (Object) null);
    }

    public boolean containsAction(String str) {
        return this.hAction.containsKey(str);
    }

    public Map<String, ResultStatus> getActionMap() {
        return Collections.unmodifiableMap(this.hAction);
    }

    public Iterator<String> getActions() {
        return Collections.unmodifiableMap(this.hAction).keySet().iterator();
    }

    public Field getField() {
        return this.field;
    }

    public Object getResult(String str) {
        ResultStatus resultStatus = this.hAction.get(str);
        if (resultStatus == null) {
            return null;
        }
        return resultStatus.getResult();
    }

    public boolean isValid(String str) {
        ResultStatus resultStatus = this.hAction.get(str);
        if (resultStatus == null) {
            return false;
        }
        return resultStatus.isValid();
    }

    public void add(String str, boolean z10, Object obj) {
        this.hAction.put(str, new ResultStatus(z10, obj));
    }

    protected static class ResultStatus implements Serializable {
        private static final long serialVersionUID = 4076665918535320007L;
        private Object result;
        private boolean valid;

        public ResultStatus(boolean z10, Object obj) {
            this.valid = z10;
            this.result = obj;
        }

        public Object getResult() {
            return this.result;
        }

        public boolean isValid() {
            return this.valid;
        }

        public void setResult(Object obj) {
            this.result = obj;
        }

        public void setValid(boolean z10) {
            this.valid = z10;
        }

        public ResultStatus(ValidatorResult validatorResult, boolean z10, Object obj) {
            this(z10, obj);
        }
    }
}
