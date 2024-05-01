package kr.co.doby.web.controller.api;

import kr.co.doby.web.entity.Member;
import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.exception.NurigoMessageNotReceivedException;
import net.nurigo.sdk.message.model.Balance;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.model.StorageType;
import net.nurigo.sdk.message.request.MessageListRequest;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.response.MessageListResponse;
import net.nurigo.sdk.message.response.MultipleDetailMessageSentResponse;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

@RestController
public class ExampleController {

    final DefaultMessageService messageService;

    public ExampleController() {
        // 반드시 계정 내 등록된 유효한 API 키, API Secret Key를 입력해주셔야 합니다!
        this.messageService = NurigoApp.INSTANCE.initialize("NCSEISRQU4SJAQGK", "TMYGJSDOXSAD4RWN4XKAQOVKCBZONWAU", "https://api.coolsms.co.kr");
    }


    /**
     * 단일 메시지 발송 예제
     */
    @PostMapping("member/profile/sendSMS")
    public SingleMessageSentResponse sendOne(Member member) {

        Random rand = new Random();
        String numStr = "";

        for(int i = 0; i < 6; i++){
            String ran = Integer.toString(rand.nextInt(10));
            numStr += ran;
        }

        System.out.println(numStr);

        Message message = new Message();
        // 발신번호 및 수신번호는 반드시 01012345678 형태로 입력되어야 합니다.
        message.setFrom("01056978647");
        message.setTo(member.getPhone());
        message.setText("[DOBY!] 인증번호는 [" + numStr + "] 입니다." );

        SingleMessageSentResponse response = this.messageService.sendOne(new SingleMessageSendingRequest(message));
        System.out.println(response);

        return response;
    }


}
