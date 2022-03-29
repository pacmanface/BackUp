package FooApp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@NoArgsConstructor
@Repository
public class FooDAO {

    private Map<Integer, Foo> fooMap = new ConcurrentHashMap();

}
