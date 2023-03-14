package seunghee.studyspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import seunghee.studyspring.repository.JdbcTemplateMemberRepository;
import seunghee.studyspring.repository.JdbcTemplateMemberRepository;
import seunghee.studyspring.repository.MemberRepository;
import seunghee.studyspring.repository.MemoryMemberRepository;
import seunghee.studyspring.service.MemberService;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
        return new JdbcTemplateMemberRepository(dataSource);
    }

}
