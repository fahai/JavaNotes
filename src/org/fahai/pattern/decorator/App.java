package org.fahai.pattern.decorator;

/**
 * 描述：
 * 
 * @author 449631
 * @since 1.0
 */
public class App {

	public static void main(String[] args) {
		Source source = new Source();
		Decorator decorator = new Decorator(source);
		decorator.method();
	}

}
