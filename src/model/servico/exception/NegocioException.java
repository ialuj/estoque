package model.servico.exception;

import javax.ejb.ApplicationException;

@ApplicationException
public class NegocioException extends RuntimeException {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3236901514352782994L;

	public NegocioException(String message) {
		super(message);
	}

}
