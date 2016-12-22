package controller;

public class SecondThread extends Thread{
	
	private BatailleController controller;

	
	public SecondThread(BatailleController controller){
		this.controller = controller;
	}
	
	public BatailleController getController() {
		return controller;
	}

	public void setController(BatailleController controller) {
		this.controller = controller;
	}

	public void run(){
		controller.attendreTirAdverse();
		
	}
	

}
