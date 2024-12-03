package org.apache.commons.beanutils;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResultSetIterator implements DynaBean, Iterator<DynaBean> {
    protected boolean current = false;
    protected ResultSetDynaClass dynaClass;
    protected boolean eof = false;

    ResultSetIterator(ResultSetDynaClass resultSetDynaClass) {
        this.dynaClass = resultSetDynaClass;
    }

    /* access modifiers changed from: protected */
    public void advance() throws SQLException {
        if (!this.current && !this.eof) {
            if (this.dynaClass.getResultSet().next()) {
                this.current = true;
                this.eof = false;
                return;
            }
            this.current = false;
            this.eof = true;
        }
    }

    public boolean contains(String str, String str2) {
        throw new UnsupportedOperationException("FIXME - mapped properties not currently supported");
    }

    public Object get(String str) {
        if (this.dynaClass.getDynaProperty(str) != null) {
            try {
                return this.dynaClass.getObjectFromResultSet(str);
            } catch (SQLException e10) {
                throw new RuntimeException("get(" + str + "): SQLException: " + e10);
            }
        } else {
            throw new IllegalArgumentException(str);
        }
    }

    public DynaClass getDynaClass() {
        return this.dynaClass;
    }

    public boolean hasNext() {
        try {
            advance();
            return !this.eof;
        } catch (SQLException e10) {
            throw new RuntimeException("hasNext():  SQLException:  " + e10);
        }
    }

    public void remove(String str, String str2) {
        throw new UnsupportedOperationException("FIXME - mapped operations not currently supported");
    }

    public void set(String str, Object obj) {
        if (this.dynaClass.getDynaProperty(str) != null) {
            try {
                this.dynaClass.getResultSet().updateObject(str, obj);
            } catch (SQLException e10) {
                throw new RuntimeException("set(" + str + "): SQLException: " + e10);
            }
        } else {
            throw new IllegalArgumentException(str);
        }
    }

    public DynaBean next() {
        try {
            advance();
            if (!this.eof) {
                this.current = false;
                return this;
            }
            throw new NoSuchElementException();
        } catch (SQLException e10) {
            throw new RuntimeException("next():  SQLException:  " + e10);
        }
    }

    public void remove() {
        throw new UnsupportedOperationException("remove()");
    }

    public Object get(String str, int i10) {
        throw new UnsupportedOperationException("FIXME - indexed properties not currently supported");
    }

    public void set(String str, int i10, Object obj) {
        throw new UnsupportedOperationException("FIXME - indexed properties not currently supported");
    }

    public Object get(String str, String str2) {
        throw new UnsupportedOperationException("FIXME - mapped properties not currently supported");
    }

    public void set(String str, String str2, Object obj) {
        throw new UnsupportedOperationException("FIXME - mapped properties not currently supported");
    }
}
