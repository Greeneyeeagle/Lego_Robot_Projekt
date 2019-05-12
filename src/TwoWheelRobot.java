import lejos.hardware.port.Port;

public class TwoWheelRobot {

	//Deklaration
	EV3Brick baustein;
	Port portB;
	Port portC;
	Motor motB;
	Motor motC;
	protected double speed;
	
	
	//Konstruktor
		
	TwoWheelRobot(int speed){
		
		assemble();
		setSpeed(speed);
	}
	
	//assemble
	void assemble(){
		
		baustein = new EV3Brick();
		motB = new Motor();
		portB = baustein.getPort("B");
		motB.connect(portB);
		motC = new Motor();
		portC = baustein.getPort("C");
		motC.connect(portC);
		
		
	}
	
	//speedygonzales
	void setSpeed(int speed){
		
		if(speed>3){
			this.speed = 1;	
			
		}else if(speed<-3){
			this.speed = -1;
			
		}else{
			this.speed = speed;
	}
}	
	
	//getspeed
	double getSpeed(){
		
		return this.speed;
	}	
	
	//fahren start
	void fahrenstart(double speedb, double speedc){
		motB.start(speedb);
		motC.start(speedc);
	}
	
	
	//fahren stop
	void fahrenstop(){
		motB.stop();
		motC.stop();
	}
	
	//geradeaus fahren
	void fahren(double time, double speedb, double speedc){
		
	fahrenstart(speedb, speedc);
	Helfer.delayProgramm(time);
	fahrenstop();
	
		}
	//rechts fahren
	void rechts(double time, double speedb){
	
	motB.start(speedb);
	Helfer.delayProgramm(time);
	motB.stop();
	}
	
	//links fahren
	void links(double time, double speedc){
		
		motC.start(speedc);
		Helfer.delayProgramm(time);
		motC.stop();
		}
	
	//rückwärts fahren
	void rückwärts(double time){
	motB.start(-speed);
	motC.start(-speed);
	Helfer.delayProgramm(time);
	motB.stop();
	motC.stop();	
	}
	
	/*Quadrat
	void quadrat(double time){
			
			setSpeed(2);
		for(int i = 0; i<=3;i++){
				fahren(2);
				Helfer.delayProgramm(time);
				rechts(1.12);
			}
		}
	
		//Schlangenlinien
	void snake(double time){
					
					setSpeed(2);
				for(int i = 0; i<=2;i++){
						fahren(time);
						rechts(1.15);
						fahren(time);
						links(1.15);
				}
				}
				*/
	
		//Winkel Fahren
	void winkel(String richtung, double winkel, double speed){
					
					
					
					double kreisB = ((winkel/360)*Helfer.SPURWEITE * 2 * Math.PI); 
					double strecke = Helfer.getUmdrehungen(kreisB);
					
					if(richtung.equals("rechts")){
						rechts(strecke, speed);
					
						}else{
					
					if(richtung.equals("links")){
							links(strecke, speed);	
						}
								
							
						}
					
					
	
					
		//Winkel mit beiden Rädern fahren
/*	void kurven(double winkel, double radius){
					
					double kreisB = ((winkel/360)*Helfer.SPURWEITE * 2 * Math.PI);
					double kreisA = ((winkel/360)* (2* radius)* Math.PI); 
					
					double zeit1 = Helfer.getUmdrehungen(kreisB)/speed;
					double zeit2 = Helfer.getUmdrehungen(kreisA)/speed;
					
					double zeit = (zeit1 >= zeit2) ? zeit1 : zeit2;
					
					
					if (zeit1 >= zeit2) {
						zeit = zeit1;
					} else {
						zeit = zeit2;
					}
					
					
					double geschw1 = kreisB / zeit;
					double geschw2 = kreisA / zeit;
					
					motB.start(Helfer.getUmdrehungen(geschw1)/zeit);
					motC.start(Helfer.getUmdrehungen(geschw2)/zeit);
					Helfer.delayProgramm(zeit);
					motB.stop();
					motC.stop();/					
					*/
	
	
	}
}