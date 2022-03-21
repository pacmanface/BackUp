package FooApp;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@NonNull
@NoArgsConstructor
@Entity
public class Foo {

    public static volatile int count=0;

    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Id int id;
    private String name;
    private String description;
    private Date lastMod;

    public Foo(String name, String description) {
        this.id = count++;
        this.name = name;
        this.description = description;
        this.lastMod = new Date();
    }

}
