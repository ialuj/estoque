package controller.listener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class LogPhaseListener implements PhaseListener {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5586922311439620324L;

	@Override
	public void afterPhase(PhaseEvent event) {
		System.out.println("Fase "+event.getPhaseId()+" executada com sucesso");
	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}
