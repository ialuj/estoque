package exceptionhander;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

public class MyExceptionHandlerFactory extends ExceptionHandlerFactory {

	private ExceptionHandlerFactory parent;

	public MyExceptionHandlerFactory(ExceptionHandlerFactory parent) {
		super(parent);
		this.parent = parent;
	}

	@Override
	public ExceptionHandler getExceptionHandler() {
		return new MyExceptionHandler(parent.getExceptionHandler());
	}

}
