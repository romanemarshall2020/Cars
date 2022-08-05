package database.dealership.demo;

import database.dealership.demo.entity.Car;
import database.dealership.demo.entity.Customer;
import database.dealership.demo.repo.CarRepository;
import database.dealership.demo.repo.CustomerRepository;
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


//	@Bean
//	public CommandLineRunner init(CustomerRepository customerRepository, CarRepository carRepository) {
////		return (args) -> {
////			if(customerRepository.count() == 0 && populatedDB) {
////				customerRepository.save(new Customer("Romane", "Marshall", "579 Ridgewood Court, Atlanta, GA, 38776", "07-05-1993", 29192873 ));
////
////				for(Customer buyer : customerRepository.findAll()){
////					System.out.println(buyer);
////				}
////			}
////			if(carRepository.count() == 0 && populatedDB) {
////				carRepository.save(new Car("Acura", "ILX", 2016, "67909", "Red"));
////				carRepository.save(new Car("Honda", "Accord", 2021, "30213", "Green"));
////				carRepository.save(new Car("Lexus", "ES 300H", 2021, "65876", "Blue"));
////				carRepository.save(new Car("Acura", "ILX", 2019, "78433", "Black"));
////
////				for (Car sedan : carRepository.findAll()) {
////					System.out.println(sedan);
////				}
////			}
////		};
//	}
}
