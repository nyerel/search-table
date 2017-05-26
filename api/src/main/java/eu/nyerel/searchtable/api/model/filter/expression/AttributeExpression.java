package eu.nyerel.searchtable.api.model.filter.expression;

import eu.nyerel.searchtable.api.model.filter.Operator;

/**
 * @author Rastislav Papp (rastislav.papp@gmail.com)
 */
public class AttributeExpression implements Expression {

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
