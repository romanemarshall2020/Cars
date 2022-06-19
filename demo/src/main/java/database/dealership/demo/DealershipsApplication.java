package database.dealership.demo;

import database.dealership.demo.entity.Car;
import database.dealership.demo.repo.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DealershipsApplication {
	private static final boolean populatedDB = true;

	public static void main(String[] args) {
//		populatedDB = args != null && args.length >= 1 && "populate".equals(args[0]);
		SpringApplication.run(DealershipsApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(CarRepository carRepository) {
		return (args) -> {
			if(carRepository.count() == 0 && populatedDB) {
				carRepository.save(new Car("Acura", "ILX", 2016, 67909, "Red"));
				carRepository.save(new Car("Honda", "Accord", 2021, 30213, "Green"));
				carRepository.save(new Car("Lexus", "ES 300H", 2021, 65876, "Blue"));
				carRepository.save(new Car("Acura", "ILX", 2019, 78433, "Black"));

				for (Car sedan : carRepository.findAll()) {
					System.out.println(sedan);
				}
//				System.out.println("");
			}
		};
	}

}
