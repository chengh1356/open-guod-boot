package cn.hacz.edu.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class TokenUtils {

	static final long EXPIRATIONTIME = 20 * 24 * 60 * 60 * 1000; // 5天
	static final String SECRET = "makainb"; // JWT密码
	static final String TOKEN_PREFIX = "Bearer"; // Token前缀
	static final String HEADER_STRING = "Authorization";// 存放Token的Header Key
	
	public static void main(String[] args) {
		String addAuthentication = addAuthentication("123" , "测试站点");
		System.out.println(addAuthentication.length());
		getAuthentication(addAuthentication);
	}
	
	// JWT生成方法
	public static String addAuthentication(String userId, String userSystemId) {
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
				.signWith(SignatureAlgorithm.HS512, SECRET).compact();

		return JWT;
	}

	// JWT验证方法
	public static String getAuthentication(String token) {

		if (token == null) {
			return null;
		}
		// 解析 Token
		Claims claims = Jwts.parser()
				// 验签
				.setSigningKey(SECRET)
				// 去掉 Bearer
				.parseClaimsJws(token.replaceFirst(TOKEN_PREFIX, "")).getBody();
		
		// 拿用户名
		String user = claims.getSubject();
		return user + "," + claims.get("authorities");

	}

}
