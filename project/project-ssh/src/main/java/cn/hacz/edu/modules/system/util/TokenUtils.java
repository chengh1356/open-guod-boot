package cn.hacz.edu.modules.system.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

@Component
public class TokenUtils {

    @Value("${token.secret}")
    private String secret;

    @Value("${token.expiration}")
    private Long expiration;

    @Value("${token.header}")
    private String header;


    public void main(String[] args) {
        String addAuthentication = addAuthentication("123", "测试站点");
        System.out.println(addAuthentication);
        System.out.println(addAuthentication.length());
        System.out.println(getAuthentication(addAuthentication));
    }

    // JWT生成方法
    public String addAuthentication(String userId, String userSystemId) {
        LocalDateTime plusDays = LocalDateTime.now().plusDays(30L);

        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = plusDays;
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        Date date = Date.from(zdt.toInstant());

        // 生成JWT
        String JWT = Jwts.builder()
                // 保存权限（角色）
                .claim("authorities", userSystemId)
                // 用户名写入标题
                .setSubject(userId)
                // 有效期设置
                .setExpiration(date)
                // 签名设置
                .signWith(SignatureAlgorithm.HS512, secret).compact();

        return JWT;
    }

    // JWT验证方法
    public String getAuthentication(String token) {
        if (token == null) {
            return null;
        }
        // 解析 Token
        Claims claims = Jwts.parser()
                // 验签
                .setSigningKey(secret)
                // 去掉 Bearer
                .parseClaimsJws(token.replaceFirst(header, "")).getBody();

        // 拿用户名
        String user = claims.getSubject();
        return user + "," + claims.get("authorities");
    }
}