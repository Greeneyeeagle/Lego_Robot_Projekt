import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.SensorMode;


public class LichtSensor {
	private EV3Brick baustein;
	private Port port;
	private EV3ColorSensor sensor;
	private SensorMode mode;
	
	public LichtSensor(String portName) {
		baustein = new EV3Brick();
		port = baustein.getPort(portName);
		sensor = new EV3ColorSensor(port);
		mode = sensor.getRedMode();
		sensor.setFloodlight(true);	
	}
	
		
	public int sampleLight() {
		float[] sample = new float[1];
		mode.fetchSample(sample, 0);
		return (int)(sample[0]*100);
	}
	
	public void closeLight() {
		sensor.close();
	}	
}
