package FooApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FooServiceDaoImpl implements FooService {

    @Autowired
    private FooDAO fooDAO;

    public Foo save(Foo foo){
        return fooDAO.getFooMap().put(foo.getId(), foo);
    }

    public Foo findById(int id){
        return fooDAO.getFooMap().get(id);
    }

    public Foo update(int id, String name, String description){
        Foo foo = findById(id);
        foo.setName(name);
        foo.setDescription(description);
        foo.setLastMod(new Date());
        return fooDAO.getFooMap().put(id,foo);
    }

    public void deleteById(int id){
        fooDAO.getFooMap().remove(id);
    }

    public List<Foo> findAll(){
        List<Foo> foos = new ArrayList<>();
        HashMap<Integer, Foo> localMap = new HashMap<>(fooDAO.getFooMap());
        localMap.forEach((k,v)->foos.add(v));
        Collections.sort(foos, (o1, o2) -> o2.getLastMod().compareTo(o1.getLastMod()));
        return foos;
    }
}
