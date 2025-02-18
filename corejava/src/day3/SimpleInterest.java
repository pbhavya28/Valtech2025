package day3;

public interface SimpleInterest {

	public default double computeInterest (double principle, double rateOfInterest
			,double duration) {
		return principle * rateOfInterest * duration / 100;
	}
}
