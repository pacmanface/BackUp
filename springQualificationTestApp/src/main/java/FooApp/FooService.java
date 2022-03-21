package FooApp;

import java.util.List;

interface FooService {

    Foo save(Foo foo);

    Foo findById(int id);

    Foo update(int id, String name, String description);

    void deleteById(int id);

    List<Foo> findAll();

}