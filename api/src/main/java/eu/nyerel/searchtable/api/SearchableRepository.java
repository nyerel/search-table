package eu.nyerel.searchtable.api;

import eu.nyerel.searchtable.api.model.PagedResult;
import eu.nyerel.searchtable.api.model.query.Query;

/**
 * @author Rastislav Papp (rastislav.papp@gmail.com)
 */
public interface SearchableRepository<T> {

    PagedResult<T> search(Query query);

}
