package FooApp;

import org.springframework.data.repository.PagingAndSortingRepository;

interface FooJpaRepository extends PagingAndSortingRepository<Foo,Integer> {

}
