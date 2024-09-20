package hieu.nv.jpa.random;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class RandomStringServiceImpl implements RandomStringService {
	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	private static final SecureRandom RANDOM = new SecureRandom();

	@Override
	public String generateRandomString(int length) {
		StringBuilder result = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			int index = RANDOM.nextInt(CHARACTERS.length());
			result.append(CHARACTERS.charAt(index));
		}
		return result.toString();
	}
}
