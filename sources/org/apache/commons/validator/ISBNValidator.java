package org.apache.commons.validator;

public class ISBNValidator {
    public boolean isValid(String str) {
        return org.apache.commons.validator.routines.ISBNValidator.getInstance().isValidISBN10(str);
    }
}
