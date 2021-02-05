package exceptionhander;

import javax.faces.FacesException;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

import controller.util.JSFUtil;
import model.servico.exception.NegocioException;

public class MyExceptionHandler extends ExceptionHandlerWrapper {

	public MyExceptionHandler(ExceptionHandler wrapped) {
		super(wrapped);
	}

	@Override
	public void handle() throws FacesException {
		Iterable<ExceptionQueuedEvent> events = super.getUnhandledExceptionQueuedEvents();
		for (ExceptionQueuedEvent eventVar : events) {
			ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) eventVar.getSource();
			Throwable exception = buscarRootCause(context.getException());
			if (exception instanceof NegocioException) {
				NegocioException negocioEx = (NegocioException) exception;
				JSFUtil.addNegocioMessage(negocioEx);
			} else {
				String mensagemIndefinida = exception.getMessage();
				JSFUtil.addErrorMessage(mensagemIndefinida);
			}
		}
	}

	private Throwable buscarRootCause(Throwable throwable) {
		Throwable erro = throwable;
		Throwable anteriorErro = null;
		while (erro.getCause() != null && !erro.equals(anteriorErro)) {
			anteriorErro = erro;
			erro = erro.getCause();
		}
		return erro;
	}

}
