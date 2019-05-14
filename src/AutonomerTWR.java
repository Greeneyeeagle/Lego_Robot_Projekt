
public class AutonomerTWR extends TwoWheelRobot{

	LichtSensor lightS;
	
	AutonomerTWR(int speed) {
		
	super(speed);
		lightS = new LichtSensor("S1");
	}
		//Lichtsensor
		public void drivetilblack(){
			boolean i = true;
			
			 while(i == true){
				 	
				if (lightS.sampleLight() >= 20){
					motB.start(getSpeed());
					motC.start(getSpeed());
			}else{ 
				 i = false;		
			}
		}			
	}
		
		/* public void howmuchblack(){
			
			//int blackorwhite = lightS.sampleLight();
			
			int streifenanzahl = 0;
			
			motB.start(speed);
			motC.start(speed);
			
		for(int i;i<=100;i++){	
			Helfer.delayProgramm(0.1);
			
			if(lightS.sampleLight()<= 20){
				
				streifenanzahl++;
			if(lightS.sampleLight()>=40){
				continue;
				
			}
				
				
			}	
		}
			//System.out.print(i);
			//Helfer.delayProgramm(3);
			motB.stop();
			motC.stop();
			
	}*/
		 
		public void followblack(){
	
			
			
			while(lightS.sampleLight()<=90){
				
				if(lightS.sampleLight()<=35){
					fahren(0.0001, 0.5, 0.5);
					
				}else if (lightS.sampleLight()>=35){ 
					searchblack();
					
				}
			}
		}
		
		public void searchblack(){
			
			int suchwinkel = 15;
			
			
			while(lightS.sampleLight()>=35){	
			winkelsearch("rechts", suchwinkel, 0.3);
				if(lightS.sampleLight()<=35){
					break;
				}
			winkelsearch("rechts", suchwinkel, -0.3);
			if(lightS.sampleLight()<=35){
				break;
			}
			
			winkelsearch("links", suchwinkel, 0.3);
			if(lightS.sampleLight()<=35){
				break;
			}
			winkelsearch("links", suchwinkel, -0.3);
			if(lightS.sampleLight()<=35){
				break;
			}
			
				if (suchwinkel <= 100){
					suchwinkel += 10;
				}else{
					suchwinkel = suchwinkel - 20;
				}
				
			}
				
			
			
			
		}
		//Winkelsearch
		void winkelsearch(String richtung, double winkel, double speed){
						
						
						
						double kreisB = ((winkel/360)*Helfer.SPURWEITE * 2 * Math.PI); 
						double strecke = Helfer.getUmdrehungen(kreisB);
						double streckenteil = strecke/50;
						
						for(int i = 0;i<=50;i++){
						
						if(richtung.equals("rechts")){
							rechts(streckenteil, speed);
								if(lightS.sampleLight()<=35)
									break;
							}else if(richtung.equals("links")){
								links(streckenteil, speed);
								if(lightS.sampleLight()<=35)
									break;
							}else{
								continue;
								
						}	
					}
				}
		
}


