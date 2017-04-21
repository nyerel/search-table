package eu.nyerel.searchtable.api.model.query.simple;

import eu.nyerel.searchtable.api.model.query.Query;
import eu.nyerel.searchtable.api.model.query.Condition;

import java.util.List;

/**
 * @author Rastislav Papp (rastislav.papp@gmail.com)
 */
public class SimpleQuery implements Query {

    private List<Condition> conditions;

    public List<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

}
