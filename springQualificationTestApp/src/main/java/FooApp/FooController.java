package FooApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/foo")
public class FooController {

    @Autowired
    //@Qualifier("fooDaoServiceImpl")
    private FooService fooService;

    @GetMapping
    List<Foo> foos() {
        return (List<Foo>) fooService.findAll();
    }

    @GetMapping("/{id}")
    Foo getById(@PathVariable int id) throws NoSuchElementException {
        return fooService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Foo create(@RequestParam String name, @RequestParam String description) {
        Foo foo = new Foo(name,description);
        return fooService.save(foo);
    }

    @PutMapping("/{id}")
    Foo update(@PathVariable int id,
               @RequestParam String name,
               @RequestParam String description) throws NoSuchElementException {
        return fooService.update(id, name, description);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable int id) {
        fooService.deleteById(id);
    }
}
