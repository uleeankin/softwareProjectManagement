package ru.rsreu.sokolova0316;

import java.util.Locale;
import com.prutzkow.resourcer.Resourcer;

/**
 * 
 * @author Sokolova Yuliya
 *
 */
public class ApplicationRunner {
	
	public static final int INDEX = 4;
	public static final int ADDING_VALUE = 0;
	
	private ApplicationRunner() {
		
	}
	
	public static void main(String[] args) {
		
		ArrayItemRemover arrayItemRemover = new ArrayItemRemover(1, 2, 3, 4, 5, 6);
		
		Locale.setDefault(Locale.US);
		
		StringBuilder result = new StringBuilder();
		result.append(Resourcer.getString("message.origin"))
				.append(arrayItemRemover)
				.append(Resourcer.getString("message.nextline"));
				
		try {
			result.append(Resourcer.getString("message.array.with.deleted.item"))
					.append(ApplicationRunner.INDEX)
					.append(Resourcer.getString("message.nextline"))
					.append(arrayItemRemover.removeArrayElement());
		} catch (ArrayIndexOutOfBoundsException exception) {
			result.append(Resourcer.getString("message.exception"));
		}
		System.out.println(result);
	}

}
