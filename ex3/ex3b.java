import java.io.*;
import java.util.Date;

abstract class vehicle
{
	Date purchase;
	String owner_name,reg_no,engine_type,fuel_type,colour,model,maker;
	int no_of_wheels,no_of_gears;
	float price,tank_capacity;

	abstract void mileageCalculation() throws IOException;
	abstract void vehicleAgeCalculation() throws IOException;
	abstract void vehicleExpenditure() throws IOException;
	abstract void getData() throws IOException;
	abstract void makerSearch(String maker);
	abstract void cityVehicleSearch(String code);
	abstract void display();
}

class bike extends vehicle
{
	static int no_of_bikes;

	bike()
	{
		no_of_bikes++;
	}
	
	static int getNo()
	{
		return no_of_bikes;
	}
		
	void getData() throws IOException
	{
		DataInputStream d = new DataInputStream(System.in);

		System.out.print("\nEnter the reg. no. of the bike : ");
		reg_no = d.readLine();
		System.out.print("Enter the model of the bike : ");
		model = d.readLine();
		System.out.print("Enter the maker : ");
		maker = d.readLine();
		System.out.print("Enter the date of purchase:(dd/mm/yyyy)");
		purchase = new Date(d.readLine());
		System.out.print("Enter the owner name : ");
		owner_name = d.readLine();
		System.out.print("Enter the engine type : ");
		engine_type = d.readLine(); 
		System.out.print("Enter the fuel type : ");
		fuel_type = d.readLine();
		System.out.print("Enter the colour : ");
		colour = d.readLine();
		no_of_wheels = 2;
		System.out.print("Enter the no. of gears : ");
		no_of_gears = Integer.parseInt(d.readLine());
		System.out.print("Enter the price of the bike : ");
		price = Float.parseFloat(d.readLine());
		System.out.print("Enter the tank capacity of the bike : ");
		tank_capacity = Float.parseFloat(d.readLine());
	}

	void mileageCalculation() throws IOException
	{
		DataInputStream d = new DataInputStream(System.in);		
		System.out.println("\n\t\tMILEAGE CALCULATION :");
		System.out.print("\nEnter the initial reading :");
		int init_reading = Integer.parseInt(d.readLine());
		System.out.print("Enter the final reading :");
		int final_reading = Integer.parseInt(d.readLine());
		int dist = final_reading - init_reading;
		float mileage = dist/tank_capacity;
		System.out.println("Mileage of the bike: "+mileage);
	}
	
	void vehicleAgeCalculation()
	{
		System.out.println("\n\t\tAGE CALCULATION :");
		Date sysdate = new Date();
		int year = sysdate.getYear();
		int purchase_year = purchase.getYear();
		System.out.println("\nAge of the bike : "+(year-purchase_year)); 
	}
	
	void vehicleExpenditure() throws IOException
	{
		DataInputStream d = new DataInputStream(System.in);
		System.out.println("\n\t\tVEHICLE EXPENDITURE :");
		System.out.print("\nEnter the amount spent for fuel : ");
		float fuel_consumption = Float.parseFloat(d.readLine());
		System.out.print("Enter the repair charges : ");
		float repair_charges = Float.parseFloat(d.readLine());
		System.out.print("Enter the service charges : ");
		float service_charges = Float.parseFloat(d.readLine());
		System.out.println("\nThe first two services are free!!");
		System.out.print("Total expenditure for the bike : "+(service_charges));
	}

	void makerSearch(String maker)
	{
		if(maker.equals(this.maker))
		{
			System.out.print("\n\nMaker : "+this.maker);
			System.out.print("\nOwner : "+this.owner_name);
			System.out.println("\nBike registration no. : "+this.reg_no);
		}
	}	

	void cityVehicleSearch(String code)
	{
		if(code.charAt(0)==this.reg_no.charAt(2) && code.charAt(1)==this.reg_no.charAt(3))
		{
			System.out.print("\n\nOwner : "+this.owner_name);
			System.out.println("\nBike registration no. : "+this.reg_no);
		}
	}

	void display()
	{
		System.out.print(reg_no+"\t"+model+"\t"+maker+"\t\t"+purchase.getDate()+"/"+purchase.getMonth()+"/"+purchase.getYear()+"\t\t"+owner_name+"\t"+engine_type+"\t\t"+price+"\t\t"+fuel_type+"\t\t"+tank_capacity+"\t\t"+colour+"\t"+no_of_wheels+"\t"+no_of_gears+"\n");

	}
	
}

class car extends vehicle
{
	static int no_of_cars;		

	car()
	{
		no_of_cars++;
	}
	
	static int getNo()
	{
		return no_of_cars;
	}

	void getData() throws IOException
	{
		DataInputStream d = new DataInputStream(System.in);
		
		System.out.print("\nEnter the reg. no. of the car : ");
		reg_no = d.readLine();
		System.out.print("Enter the model of the car : ");
		model = d.readLine();	
		System.out.print("Enter the maker : ");
		maker = d.readLine();
		System.out.print("Enter the date of purchase:(dd/mm/yyyy)");
		purchase = new Date(d.readLine());
		System.out.print("Enter the owner name : ");
		owner_name = d.readLine();
		System.out.print("Enter the engine type : ");
		engine_type = d.readLine(); 
		System.out.print("Enter the fuel type : ");
		fuel_type = d.readLine();
		System.out.print("Enter the colour : ");
		colour = d.readLine();
		no_of_wheels = 4;
		System.out.print("Enter the no. of gears : ");
		no_of_gears = Integer.parseInt(d.readLine());
		System.out.print("Enter the price of the car : ");
		price = Float.parseFloat(d.readLine());
		System.out.print("Enter the tank capacity of the car : ");
		tank_capacity = Float.parseFloat(d.readLine());
	}

	void mileageCalculation() throws IOException
	{
		DataInputStream d = new DataInputStream(System.in);
		System.out.println("\n\t\tMILEAGE CALCULATION :");
		System.out.print("\nEnter the initial reading :");
		int init_reading = Integer.parseInt(d.readLine());
		System.out.print("Enter the final reading :");
		int final_reading = Integer.parseInt(d.readLine());
		int dist = final_reading - init_reading;
		float mileage = dist/tank_capacity;
		System.out.println("\nMileage of the car : "+mileage);
	}
	
	void vehicleAgeCalculation()
	{
		System.out.println("\n\t\tAGE CALCULATION :");
		Date sysdate = new Date();
		int year = sysdate.getYear();
		int purchase_year = purchase.getYear();
		System.out.println("\nAge of the car : "+(year - purchase_year)); 
	}
	
	void vehicleExpenditure() throws IOException
	{
		DataInputStream d = new DataInputStream(System.in);
		System.out.println("\n\t\tVEHICLE EXPENDITURE :");
		System.out.print("\nEnter the amount spent for fuel : ");
		float fuel_consumption = Float.parseFloat(d.readLine());
		System.out.print("Enter the repair charges : ");
		float repair_charges = Float.parseFloat(d.readLine());
		System.out.print("Enter the service charges : ");
		float service_charges = Float.parseFloat(d.readLine());
		System.out.print("Enter the amount spent for accessories : ");
		float accessories = Float.parseFloat(d.readLine());
		System.out.print("Enter the amount spent for gas/battery : ");
		float battery_or_gas = Float.parseFloat(d.readLine());
		System.out.println("\nThe first three services are free!!");
		System.out.print("Total expenditure for the car : "+(accessories + battery_or_gas));
	}

	void makerSearch(String maker)
	{
		if(maker.equals(this.maker))
		{
			System.out.print("\n\nMaker : "+this.maker);
			System.out.print("\nOwner : "+this.owner_name);
			System.out.println("\nCar registration no. : "+this.reg_no);
		}
	}
	
	void cityVehicleSearch(String code)
	{
		if(code.charAt(0)==this.reg_no.charAt(2) && code.charAt(1)==this.reg_no.charAt(3))
		{
			System.out.print("\nOwner : "+this.owner_name);
			System.out.println("Car registration no. : "+this.reg_no);
		}
	}

	void display()
	{
		System.out.print(reg_no+"\t"+model+"\t"+maker+"\t\t"+purchase.getDate()+"/"+purchase.getMonth()+"/"+purchase.getYear()+"\t\t"+owner_name+"\t"+engine_type+"\t\t"+price+"\t\t"+fuel_type+"\t\t"+tank_capacity+"\t\t"+colour+"\t"+no_of_wheels+"\t"+no_of_gears+"\n");

	}
	
}

class ex3b
{
	public static void main(String args[]) throws IOException
	{

		DataInputStream d = new DataInputStream(System.in);
		int i;
		vehicle []b = new bike[10];
		vehicle []c = new car[10];

		while(true)
		{
			System.out.print("\n\n\n--------MENU--------\n");
			System.out.print("1.Display all vehicles\n2.Enter a new bike\n3.Enter a new car\n4.No. of vehicles\n5.No. of bikes\n6.No. of cars\n7.List of vehicles of a particular maker\n8.List of vehicles in a city\n9.Exit\n\n");
			System.out.print("Enter your choice:");
			int choice = Integer.parseInt(d.readLine());
		
			switch(choice)
			{
				case 1:
					System.out.println("\n------BIKES-----");
					System.out.println("Reg No.\t\tModel\tMaker\tDate of purchase\tOwner Name\tEngine Type\tPrice     \tFuel Type\tTank Capacity\tColour\tWheels\tGears");
					for(i=0;i<bike.getNo();i++)
						b[i].display();
	
					System.out.println("\n------CARS------");
					System.out.println("Reg No.\t\tModel\tMaker\tDate of purchase\tOwner Name\tEngineType\tPrice      \tFuel Type\tTank Capacity\tColour\tWheels\tGears");
					for(i=0;i<car.getNo();i++)
						c[i].display();

					break;
				
				case 2:
					b[bike.getNo()] = new bike();
					b[bike.getNo()-1].getData();
					b[bike.getNo()-1].mileageCalculation();
					b[bike.getNo()-1].vehicleAgeCalculation();
					b[bike.getNo()-1].vehicleExpenditure();
					break;
	
				case 3:
					c[car.getNo()] = new car();
					c[car.getNo()-1].getData();
					c[car.getNo()-1].mileageCalculation();
					c[car.getNo()-1].vehicleAgeCalculation();
					c[car.getNo()-1].vehicleExpenditure();
					break;

				case 4:
					System.out.println("\nNo.of vehicles : "+(bike.getNo() + car.getNo()));
					break;

				case 5:
					System.out.println("\nNo.of bikes : "+bike.getNo());
					break;

				case 6:
					System.out.println("\nNo.of cars : "+car.getNo());
					break;

				case 7:
					System.out.print("\nEnter the maker : ");
					String maker = d.readLine();

					System.out.println("Bikes:");
					for(i=0;i<bike.getNo();i++)
						b[i].makerSearch(maker);
					
					System.out.println("Cars:");
					for(i=0;i<car.getNo();i++)
						c[i].makerSearch(maker);
					
					break;

				case 8:
					System.out.print("\nEnter the city code : ");
					String code = d.readLine();
					
					System.out.println("Bikes:");
					for(i=0;i<bike.getNo();i++)
						b[i].cityVehicleSearch(code);

					System.out.println("Cars:");
					for(i=0;i<car.getNo();i++)
						c[i].cityVehicleSearch(code);
	
					break;

				case 9:
					System.out.println("\nProgram terminating!!");
					System.exit(0);
			}//switch
		}//while
	}//main
}

