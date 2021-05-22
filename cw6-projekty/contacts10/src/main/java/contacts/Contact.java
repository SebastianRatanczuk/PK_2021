package contacts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @NotNull
    @Size(min = 1, max = 30)
    @Column(name="first_name")
    private String firstName;

    @NotNull
    @Size(min = 3, max = 30)
    @Column(name="last_name")
    private String lastName;

    @NotNull
    @Size(min = 5, max = 60)
    @Pattern(regexp = "\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b")
    @Column(name="email")
    private String email;

    @Column(name="phone")
    private String phone;
}
