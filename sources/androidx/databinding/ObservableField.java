package androidx.databinding;

import java.io.Serializable;

public class ObservableField<T> extends b implements Serializable {
    static final long serialVersionUID = 1;
    private T mValue;

    public ObservableField(T t10) {
        this.mValue = t10;
    }

    public T c() {
        return this.mValue;
    }

    public ObservableField() {
    }
}
