
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
				
				if(lightS.sampleLight()<=40){
					fahren(0.0001, 0.5, 0.5);
					
				}else if (lightS.sampleLight()>=40){ 
					searchblack();
				}else if(lightS.sampleLight()>=90){
					Helfer.delayProgramm(2);
					break;
				}
			}
		}
		
		public void searchblack(){
			
			int suchwinkel = 15;
			
			
			while(lightS.sampleLight()>=35){	
			winkelsearch("rechts", suchwinkel, 0.3);
				if(lightS.sampleLight()<=35){
					break;
				}else if(lightS.sampleLight()>=95){
					break;
				}
			winkelsearch("rechts", suchwinkel, -0.3);
			if(lightS.sampleLight()<=35){
				break;
			}else if(lightS.sampleLight()>=95){
				break;
			}
			
			winkelsearch("links", suchwinkel, 0.3);
			if(lightS.sampleLight()<=35){
				break;
			}else if(lightS.sampleLight()>=95){
				break;
			}
			winkelsearch("links", suchwinkel, -0.3);
			if(lightS.sampleLight()<=35){
				break;
			}else if(lightS.sampleLight()>=95){
				break;
			}
			
				if(lightS.sampleLight()<=95){
					if (suchwinkel <= 100){
						suchwinkel += 10;
					}else{
						suchwinkel = suchwinkel - 20;
					}
				}else{
					break;
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
								if(lightS.sampleLight()<=40)
									break;
							}else if(richtung.equals("links")){
								links(streckenteil, speed);
								if(lightS.sampleLight()<=40)
									break;
							}else{
								continue;
								
						}	
					}
				}
		//Lichtsensor Schwarz zählen
		
		public void lichtsensorZählen(){
			int zählen = 0;	
				
			int i = 0;
			
			do{
				motB.start(this.speed);
				motC.start(this.speed);
				if(lightS.sampleLight()<=35){
					zählen++;
					i = 0;
					System.out.println(zählen);
					while(lightS.sampleLight()<=35){
						Helfer.delayProgramm(0.001);
					}
				}else{
					i++;
				}
			}while(i<=1500);
			
			motB.stop();
			motC.stop();
				
			System.out.println(zählen);
			Helfer.delayProgramm(10);
		}
}


