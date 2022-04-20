package jpawebpratice.jpapratice.domain.cotroller;

import jpawebpratice.jpapratice.domain.Gender;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;


@Getter
@Setter
public class MemberForm {

    @NotEmpty(message = "회원 이름은 필수 입니다.")
    private String nickName;

    @NotEmpty(message = "비밀번호는 필수 입니다.")
    private String password;

    @NotEmpty(message = "핸드폰 번호는 필수 입니다.")
    private String phoneNumber;

    @NotEmpty(message = "에미일은 필수 입니다.")
    private String mail;

//    @NotEmpty(message = "성별은 필수 입니다.")
//    private Gender gender;

}
