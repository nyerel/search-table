package eu.nyerel.searchtable.core.repository;

import eu.nyerel.searchtable.api.SearchableRepository;
import eu.nyerel.searchtable.api.model.PagedResult;
import eu.nyerel.searchtable.api.model.SearchRequest;
import eu.nyerel.searchtable.api.model.Sort;
import eu.nyerel.searchtable.api.model.filter.expression.Expression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * @author Rastislav Papp (rastislav.papp@gmail.com)
 */
public abstract class JpaSearchableRepository<T, ID extends Serializable> implements SearchableRepository<T> {

    private final JpaSpecificationExecutor<T> executor;

    @Autowired
    private SortConverter sortConverter;
    @Autowired
    private SpecificationCreator specificationCreator;

    public JpaSearchableRepository(JpaSpecificationExecutor<T> executor) {
        this.executor = executor;
    }

    public void setSortConverter(SortConverter sortConverter) {
        this.sortConverter = sortConverter;
    }

    public void setSpecificationCreator(SpecificationCreator specificationCreator) {
        this.specificationCreator = specificationCreator;
    }

    @Override
    public PagedResult<T> search(SearchRequest request) {
        Specification<T> spec = constructSpecification(request.getFilter());
        Page<T> page = executor.findAll(spec, constructPageable(request));
        return convertPage(page);
    }

    private PagedResult<T> convertPage(Page<T> page) {
        PagedResult<T> pagedResult = new PagedResult<>();
        pagedResult.setItems(page.getContent());
        pagedResult.setTotalItems(page.getTotalElements());
        pagedResult.setTotalPages(page.getTotalPages());
        return pagedResult;
    }

    private Specification<T> constructSpecification(Expression expression) {
        if (expression == null) {
            return null;
        } else {

        }
    }

    private Pageable constructPageable(SearchRequest request) {
        return new PageRequest(request.getPage(), request.getItemsPerPage(), constructSort(request.getSort()));
    }

    private org.springframework.data.domain.Sort constructSort(Sort sort) {
        return sortConverter.convert(sort);
    }

}
