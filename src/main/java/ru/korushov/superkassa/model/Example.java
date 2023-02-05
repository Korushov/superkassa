package ru.korushov.superkassa.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.web.bind.annotation.RequestBody;
import ru.korushov.superkassa.util.MyJson;

/**
 * @author Vitaly Korushov
 */

@Entity
@Table(name = "sk_example_table")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Example {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "obj", nullable = false)
    @JdbcTypeCode(SqlTypes.JSON)
    private MyJson obj;

    public Example() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MyJson getObj() {
        return obj;
    }

    public void setObj(MyJson obj) {
        this.obj = obj;
    }
}
