// package user;

// import java.io.File;
// import java.io.IOException;
// import java.util.ArrayList;
// import java.util.Locale.Category;
// import java.util.Map;
// import java.util.Scanner;

// import javax.imageio.IIOException;

// public class AuthenticateUser {
//     private static final String JSON_FILE_PATH = "/folder/users.json";

//     private String user;
//     private String pass;

//     public AuthenticateUser() {
//         // constructor
//         printLogin();
//         user = null;
//         pass = null;
//     }

//     // methods
//     private void printLogin() {
//         System.out.println("Welcome to the program!");

//         try {
//             Scanner username = new Scanner(System.in);
//             System.out.println("Username: ");
//             user = username.nextLine();
//             username.close();
//         } catch (IllegalArgumentException e) {
//             System.out.println("Invalid username");
//         }

//         try {
//             Scanner password = new Scanner(System.in);
//             System.out.println("Password: ");
//             pass = password.nextLine();
//             password.close();
//         } catch (IllegalArgumentException e) {
//             System.out.println("Invalid password");
//         }

//         if (user != null && pass != null)
//             authenticate(user, pass);

//     }

//     // method
//     private void authenticate(String user, String pass) {
//         // search through json
        
//     }


