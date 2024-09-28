package tek.tdd.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class AccountResponse {
    private int id;
    private String email;
    private String firstName;
    private String lastName;
    private String title;
    private Gender gender;
    private MaritalStatus maritalStatus;
    private String employmentStatus;
    @JsonIgnore
    private String dateOfBirth;//yyy/mm/dd
}
