package com.riding.todoback.model.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown=true)
@Data
public class KakaoProfile {

    public Long id;
    public String connected_at;
    public KakaoAccount kakao_account;


    @JsonIgnoreProperties(ignoreUnknown=true)
    @Data
    public static class KakaoAccount {

        public Profile profile;
        public String email;

        @JsonIgnoreProperties(ignoreUnknown=true)
        @Data
        public static class Profile {
            public String nickname;
        }
    }
}
