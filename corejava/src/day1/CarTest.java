package day1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {
	
	@Test
	void testClone() throws Exception{
		Car car = new Car("Honda","City","VX",2024,7);
		Car car1 = (Car)car.clone();
		assertEquals(car,car1);
		assertNotSame(car,car1);
	}
	@Test
	void testToString() {
		Car car = new Car("Honda","City","VX",2024, 7);
		assertEquals("Honda City VX 2024 Version: 7",car.toString());
		car.setYear(2025);
		assertEquals("Honda City VX 2025 Version: 7",car.toString());
		car.setVariant("ZX");
		assertEquals("Honda City ZX 2025 Version: 7",car.toString());

	}
	
	@Test
	void testHashCode() {
		
		Car car = new Car("Honda","City","VX",2024, 7);
		int hash = car.hashCode();
		assertEquals(hash,car.hashCode());
//		car.setYear(2025);
		assertEquals(hash,new Car("Honda","City","VX",2024, 7).hashCode());
//		car.setVariant("ZX");
//		assertEquals("Honda City ZX 2025 Version: 7",car.toString());
		System.out.println(car + " " +car.hashCode());
		car.setVariant("ZX");
		System.out.println(car + " "+ car.hashCode());

	}

}
