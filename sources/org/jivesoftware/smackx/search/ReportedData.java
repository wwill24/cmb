package org.jivesoftware.smackx.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.packet.DataForm;

public class ReportedData {
    private final List<Column> columns = new ArrayList();
    private final List<Row> rows = new ArrayList();
    private String title = "";

    public static class Column {
        private final String label;
        private final FormField.Type type;
        private final String variable;

        public Column(String str, String str2, FormField.Type type2) {
            this.label = str;
            this.variable = str2;
            this.type = type2;
        }

        public String getLabel() {
            return this.label;
        }

        public FormField.Type getType() {
            return this.type;
        }

        public String getVariable() {
            return this.variable;
        }
    }

    public static class Field {
        private final List<? extends CharSequence> values;
        private final String variable;

        public Field(String str, List<? extends CharSequence> list) {
            this.variable = str;
            this.values = list;
        }

        public List<CharSequence> getValues() {
            return Collections.unmodifiableList(this.values);
        }

        public String getVariable() {
            return this.variable;
        }
    }

    public static class Row {
        private List<Field> fields;

        public Row(List<Field> list) {
            new ArrayList();
            this.fields = list;
        }

        private List<Field> getFields() {
            return Collections.unmodifiableList(new ArrayList(this.fields));
        }

        public List<CharSequence> getValues(String str) {
            for (Field next : getFields()) {
                if (str.equalsIgnoreCase(next.getVariable())) {
                    return next.getValues();
                }
            }
            return null;
        }
    }

    private ReportedData(DataForm dataForm) {
        for (FormField formField : dataForm.getReportedData().getFields()) {
            this.columns.add(new Column(formField.getLabel(), formField.getFieldName(), formField.getType()));
        }
        for (DataForm.Item fields : dataForm.getItems()) {
            ArrayList arrayList = new ArrayList(this.columns.size());
            for (FormField formField2 : fields.getFields()) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(formField2.getValues());
                arrayList.add(new Field(formField2.getFieldName(), arrayList2));
            }
            this.rows.add(new Row(arrayList));
        }
        this.title = dataForm.getTitle();
    }

    public static ReportedData getReportedDataFrom(Stanza stanza) {
        DataForm from = DataForm.from(stanza);
        if (from == null || from.getReportedData() == null) {
            return null;
        }
        return new ReportedData(from);
    }

    public void addColumn(Column column) {
        this.columns.add(column);
    }

    public void addRow(Row row) {
        this.rows.add(row);
    }

    public List<Column> getColumns() {
        return Collections.unmodifiableList(new ArrayList(this.columns));
    }

    public List<Row> getRows() {
        return Collections.unmodifiableList(new ArrayList(this.rows));
    }

    public String getTitle() {
        return this.title;
    }

    public ReportedData() {
    }
}
