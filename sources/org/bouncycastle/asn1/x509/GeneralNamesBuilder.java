package org.bouncycastle.asn1.x509;

import java.util.Vector;

public class GeneralNamesBuilder {
    private Vector names = new Vector();

    public GeneralNamesBuilder addName(GeneralName generalName) {
        this.names.addElement(generalName);
        return this;
    }

    public GeneralNamesBuilder addNames(GeneralNames generalNames) {
        GeneralName[] names2 = generalNames.getNames();
        for (int i10 = 0; i10 != names2.length; i10++) {
            this.names.addElement(names2[i10]);
        }
        return this;
    }

    public GeneralNames build() {
        int size = this.names.size();
        GeneralName[] generalNameArr = new GeneralName[size];
        for (int i10 = 0; i10 != size; i10++) {
            generalNameArr[i10] = (GeneralName) this.names.elementAt(i10);
        }
        return new GeneralNames(generalNameArr);
    }
}
