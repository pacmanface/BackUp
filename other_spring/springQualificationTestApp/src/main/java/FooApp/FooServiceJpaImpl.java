package FooApp;

import java.util.Date;
import java.util.List;

public class FooServiceJpaImpl implements FooService{

    private FooJpaRepository repository;

    @Override
    public Foo save(Foo foo) {
        return repository.save(foo);
    }

    @Override
    public Foo findById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public Foo update(int id, String name, String description) {
        Foo foo = repository.findById(id).get();
        foo.setName(name);
        foo.setDescription(description);
        foo.setLastMod(new Date());
        return foo;
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<Foo> findAll() {

        return null;
    }
}
