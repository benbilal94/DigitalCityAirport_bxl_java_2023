package be.digitalcity.spring.airport.models.form;

import be.digitalcity.spring.airport.models.entity.FidelityStatus;
import be.digitalcity.spring.airport.models.entity.Person;
import be.digitalcity.spring.airport.validation.constraint.StartsWithMaj;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PersonForm {

    @NotBlank
    @StartsWithMaj(message = "firstname must have 5 capitals to start", numberCapital = 5)
    @Size(min = 5)
    private String firstname;
    @NotBlank
    @StartsWithMaj
    private String lastname;
    private FidelityStatus fidelity;

    public Person toEntity(){

        Person p = new Person();
        p.setFirstname(firstname);
        p.setLastname(lastname);
        return p;

    }

}
