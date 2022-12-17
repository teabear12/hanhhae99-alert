package hanghae99.alert.member.controller;

import hanghae99.alert.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    //나는 오호진
    private final MemberService memberService;

}
