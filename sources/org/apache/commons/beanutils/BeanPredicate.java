package org.apache.commons.beanutils;

import java.lang.reflect.InvocationTargetException;
import org.apache.commons.collections.Predicate;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BeanPredicate implements Predicate {
    private final Log log = LogFactory.getLog(getClass());
    private Predicate predicate;
    private String propertyName;

    public BeanPredicate(String str, Predicate predicate2) {
        this.propertyName = str;
        this.predicate = predicate2;
    }

    public boolean evaluate(Object obj) {
        try {
            return this.predicate.evaluate(PropertyUtils.getProperty(obj, this.propertyName));
        } catch (IllegalArgumentException e10) {
            this.log.error("ERROR: Problem during evaluation.", e10);
            throw e10;
        } catch (IllegalAccessException e11) {
            this.log.error("Unable to access the property provided.", e11);
            throw new IllegalArgumentException("Unable to access the property provided.");
        } catch (InvocationTargetException e12) {
            this.log.error("Exception occurred in property's getter", e12);
            throw new IllegalArgumentException("Exception occurred in property's getter");
        } catch (NoSuchMethodException e13) {
            this.log.error("Property not found.", e13);
            throw new IllegalArgumentException("Property not found.");
        }
    }

    public Predicate getPredicate() {
        return this.predicate;
    }

    public String getPropertyName() {
        return this.propertyName;
    }

    public void setPredicate(Predicate predicate2) {
        this.predicate = predicate2;
    }

    public void setPropertyName(String str) {
        this.propertyName = str;
    }
}
