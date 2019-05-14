
public class robot_controller {

	public static void main(String[] args) {
		
		//Deklaration & Initialisierung
		AutonomerTWR r2d2 = new AutonomerTWR(1);
		
		//Fahren

		r2d2.followblack();
		Helfer.delayProgramm(2);
		r2d2.lichtsensorZählen();
		
	}
}
