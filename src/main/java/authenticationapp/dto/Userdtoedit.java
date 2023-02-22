package authenticationapp.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Userdtoedit {

    private Long Id;
    private String email;
    private String phoneNumber;


}
