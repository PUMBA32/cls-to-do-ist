package to_do_list;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ToDoList to_do = new ToDoList();
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			to_do.showMenu();
			
			System.out.print("\n>>> ");
			String str_choice = scanner.nextLine();
			int choice;
			
			try {
				choice = Integer.parseInt(str_choice);
			} 
			catch(NumberFormatException e) {
				System.out.println("error: You should enter the NUMBER!");
				continue;
			}
			
			if(choice >= 5) break;
			
			switch(choice) {
			case 1:
				System.out.print("Enter new note: ");
				String note = scanner.nextLine();
				to_do.newNote(note);
				break;
			case 2:
				System.out.print("Enter number of note, that you want to delete: ");
				String number = scanner.nextLine();
				
				try {
					int index = Integer.parseInt(number);
					to_do.deleteNote(index);
				}
				catch(NumberFormatException e) {
					System.out.println("error: You should enter the NUMBER!");
				}
				break;
			case 3:
				to_do.showAllNotes();
				break;
			case 4:
				to_do.clearAll();
				break;
			}
		}		
	}
}
