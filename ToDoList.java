package to_do_list;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;


public class ToDoList {
	private String[] menu = {
			"New Note",
			"Delete Note",
			"Show All Notes",
			"Clear All Notes",
			"Exit"
	};
	
	private String path = "D:\\Coding\\JAVA\\to_do_list\\src\\to_do_list\\data.txt";
	
	public ToDoList(String path) {
		this.path = path;
	}
	
	public ToDoList() {}
	
	// Вывод меню
	public void showMenu() {
		cls();
		for(int i = 0; i < menu.length; i++) {
			System.out.println((i+1) + " - " + menu[i]);
		}
	}
	
	// Очистка консоли
	private void cls() {
		System.out.print("\033[H\033[2J");
	}
	
	// Запись заметки в файл
	public void newNote(String text)  {
		cls();
		try {				
			FileWriter writer = new FileWriter(path, true);
			BufferedWriter bWriter = new BufferedWriter(writer);
			bWriter.write(text + "\n");
			bWriter.close();
			
			System.out.println("Note was written successfully!\n");
		}
		catch(IOException e) {
			System.out.println("Write error!\n");
		}
	}
	
	// Удаление заметки
	public void deleteNote(int index) {
		cls();
		showAllNotes();
		File file = new File(path);
		
		try {
			FileWriter writer = new FileWriter(path, true);
			BufferedWriter bWriter = new BufferedWriter(writer);
			
			// Получение всех заметок с файла
			Scanner scanner = new Scanner(file);
			
			String full_stroke = scanner.next();
			String[] strokes = full_stroke.split("\n");
			
			// Очистка файла
			PrintWriter writer2 = new PrintWriter(path);
			writer2.println();
			
			// Перезапись 
			for(int i = 0; i < strokes.length; i++) {
				if(i != index-1) {
					bWriter.write(strokes[i] + "\n");
				}
			}
			bWriter.close();			
			System.out.println("File was deleted succesfully!\n");
		}
		catch(IOException | NoSuchElementException e) {}
		
		System.out.println();
	}
	
	// Показывет все сущесвтующие заметки
	public void showAllNotes() {
		cls();
		System.out.println();
		
		File file = new File(path);
		
		try {
			Scanner scanner = new Scanner(file);
			int i = 1;
			while(scanner.hasNextLine()) {
				System.out.println(i + ") " + scanner.nextLine());
				i++;
			}
		}
		catch(IOException e) {
			System.out.println("error: File was not found!\n");
		}
		System.out.println();		
	}

	// Очищает все заметки
	public void clearAll() {
		cls();
		try {
			PrintWriter writer = new PrintWriter(path);
			writer.println();
			System.out.println("File was cleared successfully!\n");
		}
		catch(IOException e) {
			System.out.println("We have error!\n");
		}
	}
}
