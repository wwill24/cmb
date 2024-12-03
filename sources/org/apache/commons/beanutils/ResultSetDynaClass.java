package org.apache.commons.beanutils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

public class ResultSetDynaClass extends JDBCDynaClass {
    protected ResultSet resultSet;

    public ResultSetDynaClass(ResultSet resultSet2) throws SQLException {
        this(resultSet2, true);
    }

    public /* bridge */ /* synthetic */ DynaProperty[] getDynaProperties() {
        return super.getDynaProperties();
    }

    public /* bridge */ /* synthetic */ DynaProperty getDynaProperty(String str) {
        return super.getDynaProperty(str);
    }

    public /* bridge */ /* synthetic */ String getName() {
        return super.getName();
    }

    public Object getObjectFromResultSet(String str) throws SQLException {
        return getObject(getResultSet(), str);
    }

    /* access modifiers changed from: package-private */
    public ResultSet getResultSet() {
        return this.resultSet;
    }

    public Iterator<DynaBean> iterator() {
        return new ResultSetIterator(this);
    }

    /* access modifiers changed from: protected */
    public Class<?> loadClass(String str) throws SQLException {
        try {
            return getClass().getClassLoader().loadClass(str);
        } catch (Exception e10) {
            throw new SQLException("Cannot load column class '" + str + "': " + e10);
        }
    }

    public /* bridge */ /* synthetic */ DynaBean newInstance() throws IllegalAccessException, InstantiationException {
        return super.newInstance();
    }

    public /* bridge */ /* synthetic */ void setUseColumnLabel(boolean z10) {
        super.setUseColumnLabel(z10);
    }

    public ResultSetDynaClass(ResultSet resultSet2, boolean z10) throws SQLException {
        this(resultSet2, z10, false);
    }

    public ResultSetDynaClass(ResultSet resultSet2, boolean z10, boolean z11) throws SQLException {
        this.resultSet = null;
        resultSet2.getClass();
        this.resultSet = resultSet2;
        this.lowerCase = z10;
        setUseColumnLabel(z11);
        introspect(resultSet2);
    }
}
