package az.edu.ada.wm2.lmsapp.service.utils;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

@AllArgsConstructor
public class PagedAndSortedGetAll<T, S> {
    private final PagingAndSortingRepository<T, S> repository;
    private final Integer defaultPageSize;

    public Page<T> getAll(int page) {
        return repository.findAll(PageRequest.of(page - 1, defaultPageSize));
    }

    public Page<T> getAll(int page, int pageSize) {
        return repository.findAll(PageRequest.of(page - 1, pageSize));
    }

    public Page<T> getAll(int page, int pageSize, String sortBy) {
        Sort sort;

        if (sortBy == null)
            return repository.findAll(PageRequest.of(page - 1, pageSize));

        System.out.println(sortBy);
        sort = sortBy.charAt(0) == '-' ? Sort.by(sortBy.substring(1)).descending() : Sort.by(sortBy);
        System.out.println(sort);

        return repository.findAll(PageRequest.of(page - 1, pageSize, sort));
    }
}
