package org.apache.commons.beanutils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RowSetDynaClass extends JDBCDynaClass {
    protected int limit;
    protected List<DynaBean> rows;

    public RowSetDynaClass(ResultSet resultSet) throws SQLException {
        this(resultSet, true, -1);
    }

    /* access modifiers changed from: protected */
    public void copy(ResultSet resultSet) throws SQLException {
        int i10 = 0;
        while (resultSet.next()) {
            int i11 = this.limit;
            if (i11 >= 0) {
                int i12 = i10 + 1;
                if (i10 < i11) {
                    i10 = i12;
                } else {
                    return;
                }
            }
            DynaBean createDynaBean = createDynaBean();
            int i13 = 0;
            while (true) {
                DynaProperty[] dynaPropertyArr = this.properties;
                if (i13 >= dynaPropertyArr.length) {
                    break;
                }
                String name = dynaPropertyArr[i13].getName();
                createDynaBean.set(name, getObject(resultSet, name));
                i13++;
            }
            this.rows.add(createDynaBean);
        }
    }

    /* access modifiers changed from: protected */
    public DynaBean createDynaBean() {
        return new BasicDynaBean(this);
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

    public List<DynaBean> getRows() {
        return this.rows;
    }

    public /* bridge */ /* synthetic */ DynaBean newInstance() throws IllegalAccessException, InstantiationException {
        return super.newInstance();
    }

    public /* bridge */ /* synthetic */ void setUseColumnLabel(boolean z10) {
        super.setUseColumnLabel(z10);
    }

    public RowSetDynaClass(ResultSet resultSet, int i10) throws SQLException {
        this(resultSet, true, i10);
    }

    public RowSetDynaClass(ResultSet resultSet, boolean z10) throws SQLException {
        this(resultSet, z10, -1);
    }

    public RowSetDynaClass(ResultSet resultSet, boolean z10, int i10) throws SQLException {
        this(resultSet, z10, i10, false);
    }

    public RowSetDynaClass(ResultSet resultSet, boolean z10, boolean z11) throws SQLException {
        this(resultSet, z10, -1, z11);
    }

    public RowSetDynaClass(ResultSet resultSet, boolean z10, int i10, boolean z11) throws SQLException {
        this.limit = -1;
        this.rows = new ArrayList();
        resultSet.getClass();
        this.lowerCase = z10;
        this.limit = i10;
        setUseColumnLabel(z11);
        introspect(resultSet);
        copy(resultSet);
    }
}
