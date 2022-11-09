package exercise;

import lombok.*;

// BEGIN

@Getter
@NoArgsConstructor
@AllArgsConstructor
// END
class User {
    int id;
    String firstName;
    String lastName;
    int age;
}
