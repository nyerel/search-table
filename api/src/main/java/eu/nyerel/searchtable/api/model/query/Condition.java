package eu.nyerel.searchtable.api.model.query;

import java.io.Serializable;

/**
 * @author Rastislav Papp (rastislav.papp@gmail.com)
 */
public class Condition implements Serializable {

    private String property;
    private Operator operator;
    private String value;

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
