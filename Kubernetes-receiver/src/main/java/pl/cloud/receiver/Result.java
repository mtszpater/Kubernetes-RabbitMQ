package pl.cloud.receiver;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "RESULTS")
public class Result {
    @Id
    @GeneratedValue
    private Long id;

    private Integer result;

    public void setResult(Integer result) {
        this.result = result;
    }

    public Long getId() {
        return id;
    }
}
