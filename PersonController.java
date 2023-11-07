package jdbc_person;

import java.util.Scanner;

public class PersonController {

	public static void main(String[] args) throws Exception {
		
		Scanner scanner=new Scanner(System.in);
		PersonCRUD crud=new PersonCRUD();
		System.out.println("Enter choice:-\n1.Insert Data\n2.Read Data\n3.Update Data\n4.Delete Data1");
		int choice=scanner.nextInt();
		switch (choice) {
		
		//Insert Data
		case 1:
		{
			System.out.println("Enter id:-");
			int id=scanner.nextInt();
			
			System.out.println("Enter name:-");
			String name=scanner.next();
			
			System.out.println("Enter age:-");
			int age=scanner.nextInt();
			
			System.out.println("Enter phone:-");
			long phone=scanner.nextLong();
			
			System.out.println("Enter address:-");
			String address=scanner.next();
			
			crud.savePerson(id, name, age, phone, address);
			break;
		}
		
		//Read Data
			case 2:
			{
				System.out.println("Enter Id to fetch Data:-");
				int id=scanner.nextInt();
				crud.readData(id);
				break;
			}
			
			//Update Data
			case 3:
			{
				System.out.println("Enter Id To Update Data:-");
				int id=scanner.nextInt();
				
				System.out.println("Enter name to update");
				String name=scanner.next();
				
				System.out.println("Enter age to Update");
				int age=scanner.nextInt();
				
				System.out.println("Enter phone to Update");
				long phone=scanner.nextLong();
				
				System.out.println("Enter Address to Update");
				String address=scanner.next();
				
				crud.updateData(name, age, phone, address,id);
				break;
			}
			//Delete Data
			case 4:
			{
				System.out.println("Enter id to Delete Data:-");
				int id =scanner.nextInt();
				
				crud.deleteData(id);
				break;
			}
		default:
			break;
		}
	}
}
