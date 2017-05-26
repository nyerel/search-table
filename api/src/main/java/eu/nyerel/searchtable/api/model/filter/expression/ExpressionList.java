package eu.nyerel.searchtable.api.model.filter.expression;

import eu.nyerel.searchtable.api.model.filter.LogicalOperator;

import java.util.List;

/**
 * @author Rastislav Papp (rastislav.papp@gmail.com)
 */
public class ExpressionList implements Expression {

    private List<Expression> expressions;
    private LogicalOperator logicalOperator;

    public List<Expression> getExpressions() {
        return expressions;
    }

    public void setExpressions(List<Expression> expressions) {
        this.expressions = expressions;
    }

    public LogicalOperator getLogicalOperator() {
        return logicalOperator;
    }

    public void setLogicalOperator(LogicalOperator logicalOperator) {
        this.logicalOperator = logicalOperator;
    }

}
