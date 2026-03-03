package br.com.literalura.literalura.utils;

import br.com.literalura.literalura.application.Application;

import java.util.Scanner;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);

    private static void exibeMenu() {
        var menu = """
                    1 - Buscar livro pelo titulo
                    2 - Listar livros cadastrados
                    3 - Listar autores cadastrados
                    4 - Listar autores vivos em um determinado ano
                    5 - Listar livros em um determinado idioma
              
                    0 - Sair                                 
                    """;

        System.out.println(menu);
    }

    public static void menu(Application app) {
        var resp = 0;
        do{
            exibeMenu();
            resp = scanner.nextInt();
            scanner.nextLine();
            switch (resp){
                case 1:
                    app.searchBookByTittle(scanner);
                    break;
                case 2:
                    app.findAllBooks();
                    break;
                case 3:
                    app.findAllAuthors();
                    break;
                case 4:
                    app.findLivingAuthorsByYear(scanner);
                    break;
                case 5:
                    app.findBooksByLanguage(scanner);
                    break;
            };
        }while (resp != 0);
    }


}
