import java.util.*;

public class DataStore {
    
    private Map<String, Person> personMap = new HashMap<>();

    private static DataStore instance = new DataStore();
    
    public static DataStore getInstance(){
        return instance;
    }

    private DataStore(){
        personMap.put("Ada",new Person("Ada", "Ada Lovelace was the first programmer.", 1815));
        personMap.put("Kevin",new Person("Kevin", "Kevin is the author of HappyCoding.io", 1985));
        personMap.put("Stanly",new Person("Stanly", "Stanly is Kevin's cat.", 2007));
    }

    public Person getPerson(String name){
        return personMap.get(name);
    }

    public void putPerson(Person person){
        personMap.put(person.getName(), person);
    }
}
