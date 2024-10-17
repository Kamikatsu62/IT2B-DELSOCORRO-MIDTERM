
package it2b.delsocorro.midterm;

import java.util.Scanner;


public class IT2BDELSOCORROMIDTERM {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String resp;
        do{

            System.out.println("1. ADD");
            System.out.println("2. VIEW");
            System.out.println("3. UPDATE");
            System.out.println("4. DELETE");
            System.out.println("5. EXIT");

            System.out.print("Enter Action: ");
            int action = sc.nextInt();
            IT2BDELSOCORROMIDTERM test = new IT2BDELSOCORROMIDTERM  ();
            switch(action){
                case 1:
                    test.addDoctor();
                break;
                case 2:
                    test.viewDoctor();
                break;
                case 3:
                    test.viewDoctor();
                    test.updateDoctor();
                break;
                case 4:
                    test.viewDoctor();
                    test.deleteDoctor();
                    test.viewDoctor();
                break;
            }
            
            System.out.print("Continue? ");
            resp = sc.next();

        }while(resp.equalsIgnoreCase("yes"));
            System.out.println("Thank You!");

    }
    
    public void addDoctor(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print("Doctor First Name: ");
        String fname = sc.nextLine();
        System.out.print("Doctor Last Name: ");
        String lname = sc.nextLine();
        System.out.print("Specialazation: ");
        String specs = sc.nextLine();
        System.out.print("Contact number: ");
        String number = sc.nextLine();
        System.out.print("Years of Experience: ");
        int YOE = sc.nextInt();

        String sql = "INSERT INTO tbl_Doctors (first_name, last_name, specialization, contact_number, years_of_experience) VALUES (?, ?, ?, ?, ?)";


        conf.addDoctor(sql, fname, lname, specs, number, YOE);
    }
    
    private void viewDoctor() {
        
        String qry = "SELECT * FROM tbl_Doctors";
        String[] hdrs = {"ID", "1", "Last Name", "Specialazation", "Contact number" , "Years of Experience"};
        String[] clms = {"doctor_id", "first_name", "last_name", "specialization", "contact_number", "years_of_experience"};

        config conf = new config();
        conf.viewDoctor(qry, hdrs, clms);
    }
    
    private void updateDoctor(){
    
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the ID to Update: ");
        int id = sc.nextInt();
        
        System.out.print("Enter new First Name: ");
        String nfname = sc.next();
        System.out.print("Enter new Last Name: ");
        String nlname = sc.next();
        System.out.print("Enter Specialazation: ");
        String nspecs = sc.next();
        System.out.print("Enter new Contact number: ");
        String nnumber = sc.next();
        System.out.print("Enter Years of Experience: ");
        int nYOE = sc.nextInt();
        
        String qry = "UPDATE tbl_Doctors SET first_name = ?, last_name = ?, specialization = ?, contact_number = ?, years_of_experience = ? WHERE doctor_id = ?";
        
        config conf = new config();
        conf.updateDoctor(qry, nfname, nlname, nspecs, nnumber,nYOE, id);
        
    }
    
    private void deleteDoctor(){
        
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the ID to Delete: ");
        int id = sc.nextInt();
        
        String qry = "DELETE FROM tbl_Doctors WHERE doctor_id = ?";
        
        config conf = new config();
        conf.deleteDoctor(qry, id);
    
    }
    
    
}

