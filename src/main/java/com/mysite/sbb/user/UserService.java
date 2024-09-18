package com.mysite.sbb.user;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysite.sbb.answer.AnswerRepository;
import com.mysite.sbb.question.QuestionRepository;

import lombok.RequiredArgsConstructor;

// @RequiredArgsConstructor을 통해 필요한 의존성을 자동으로 주입
@RequiredArgsConstructor
@Service
public class UserService {
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    // 새 유저를 생성하여 DB에 저장함. PW는 암호화되어 저장된다.
    public SiteUser create(String username, String email, String password) {
        SiteUser user = new SiteUser();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        this.userRepository.save(user);
        return user;
    }

    // username을 바탕으로 사용자 조회
    public SiteUser getUser(String username) {
        Optional<SiteUser> siteUser =  this.userRepository.findByUsername(username);
        if(siteUser.isPresent()) {
            System.out.println("User found: " + siteUser.get().getUsername());
        } else {
            System.out.println("User not found with username: " + username);
        }
        return siteUser.orElse(null);  // 사용자 정보를 찾지 못하면 null을 반환
    }

    public SiteUser findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found: " + username));
    }

    public List<SiteUser> getAllUsers() {
        return userRepository.findAll();
    }

    // 유저의 정보 수정(siteUser의 username, email 항목 수정)
    public void modify(SiteUser siteUser, String username, String email) {
        siteUser.setUsername(username);
        siteUser.setEmail(email);
        this.userRepository.save(siteUser);
    }

    // 삭제 시 작성했던 질문과 답변 또한 함께 삭제됨
    // 트랜잭션 보장이란, 여러 데이터베이스 작업을 하나의 논리적 단위로 처리하여 모든 작업이 성공적으로 완료되거나,
    // 하나라도 실패할 경우 모든 작업이 취소되는 것을 의미
    @Transactional
    public void delete(SiteUser siteUser) {
        // 사용자가 작성한 질문 삭제
        questionRepository.deleteByAuthor(siteUser);
        // 사용자가 작성한 답변 삭제
        answerRepository.deleteByAuthor(siteUser);
        // 최종적으로 사용자 삭제
        this.userRepository.delete(siteUser);
    }
}
