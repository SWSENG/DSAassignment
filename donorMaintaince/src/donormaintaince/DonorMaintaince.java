/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donormaintaince;

import java.util.Iterator;
import java.util.Scanner;
/**
 *
 * @author HP
 */
public class DonorMaintaince {
    public static SortedLinkedListInterface<Donor> donorList = new SortedLinkedList<>();

    public static void main(String[] args) {
        DonorMaintaince donationApp = new DonorMaintaince();
        
        Donor donor1 = new Donor("Tan Ah Kao", 'M', 321.40, 05, 05, 2021);
        Donor donor2 = new Donor("Wong Ah Ming", 'M', 43.40, 07, 12, 2021);
        Donor donor3 = new Donor("Kim Chi", 'F', 642, 30, 12, 2020);
        Donor donor4 = new Donor("Shu Shi", 'F', 40.40, 07, 06, 2020);
        donorList.add(donor1);
        donorList.add(donor2);
        donorList.add(donor3);       
        donorList.add(donor4);
        donationApp.mainPage();
    }
    
    private void mainPage(){
        Scanner in = new Scanner(System.in);
        int choice;
        
        do {
            do {
                System.out.println();
                System.out.println("Donor maintainance") ;       
                System.out.println("------------------") ;
                System.out.println("1. Add") ;
                System.out.println("2. Remove") ;
                System.out.println("3. Modify") ;
                System.out.println("4. Search") ;
                System.out.println("5. Display all record") ;
                System.out.println("6. Report") ;
                System.out.println("7. Exit") ;
                System.out.print("Please enter your choice:");
                try {
                    choice = Integer.parseInt(in.nextLine());
                    if (choice >= 0 && choice <= 7) {
                        break;
                    }
                } catch (Exception e) {
                }
            } while (true);

            switch (choice) {
                case 1:    //Add donor done
                    addDonor();
                    break;
                case 2:    //Remove donor done
                    removeDonor();
                    break;
                case 3:    //Modify donor done
                    modifyDonor();
                    break;
                case 4:    //Display donor done
                    searchDonor();
                    break;
                case 5:   //Report done
                    displayAll();
                    break;    
                case 6:   //Report done
                    donorReport();
                    break;
                case 7:   //Exit
                    return;    
                default: 
                    break;
            }
        } while (true);        
    }
    
    private void addDonor(){
        String donorNameTxt;
        char donorGenderTxt;
        double donateAmountTxt;
        int dayTxt, monthTxt, yearTxt;
        
        Scanner userInput = new Scanner(System.in);    
        
                
        System.out.print("Enter donor name: ");
        donorNameTxt = userInput.nextLine();
        do{
            if(donorNameTxt.isEmpty()){
                System.out.println("Please enter again.");
                System.out.print("Enter donor name: ");
                donorNameTxt = userInput.nextLine();                          
                }
        }while(donorNameTxt.isEmpty());
        
        System.out.print("Enter donor gender(M/F): ");
        donorGenderTxt = userInput.next().charAt(0);
        do{
            if(donorGenderTxt != 'M' && donorGenderTxt != 'm' && donorGenderTxt != 'F' && donorGenderTxt != 'f'){
                System.out.println("Please enter again.");
                System.out.print("Enter donor gender(M/F): ");
                donorGenderTxt = userInput.next().charAt(0);                            
            }
        }while(donorGenderTxt != 'M' && donorGenderTxt != 'm' && donorGenderTxt != 'F' && donorGenderTxt != 'f');
        
        System.out.print("Enter donate amount(XXXX.XX): RM");
        donateAmountTxt = userInput.nextDouble();
        System.out.print("Enter donor day(DD): ");
        dayTxt = userInput.nextInt();
        do{
            if(dayTxt <=0 || dayTxt >=32){
            System.out.println("Please enter again.");
            System.out.print("Enter donor day(DD): ");
            dayTxt = userInput.nextInt();
            } 
        }while(dayTxt <=0 || dayTxt >=32);
        
        System.out.print("Enter donor month(MM): ");
        monthTxt = userInput.nextInt();
        do{
            if(monthTxt <=0 || monthTxt >=13){
                System.out.println("Please enter again.");
                System.out.print("Enter donor month(MM): ");
                monthTxt = userInput.nextInt();
            }   
        }while(monthTxt <=0 || monthTxt >=13);
        
        System.out.print("Enter donate year(YYYY): ");
        yearTxt = userInput.nextInt();
        do{
            if(yearTxt <=2000 || yearTxt >=2022){
                System.out.println("Please enter again.");
                System.out.print("Enter donate year(YYYY): ");
                yearTxt = userInput.nextInt(); 
            } 
        }while(yearTxt <=2000 || yearTxt >=2022);
        
        Donor newDonor = new Donor(donorNameTxt, donorGenderTxt, donateAmountTxt, dayTxt, monthTxt, yearTxt);
        donorList.add(newDonor);
        System.out.println("Successful added.\n");    
    }
    
    private void removeDonor(){
        Iterator<Donor> it = donorList.getIterator();
        int removeDonor;
        char choice;
        Scanner userInput = new Scanner(System.in);   
        
        System.out.print("Enter Donor id to remove :");
        removeDonor = userInput.nextInt();

        while(it.hasNext()){
            Donor donor = it.next();
            if(removeDonor == donor.getId()){
                System.out.println("\nID:" + donor.getId() + "\nName:" + donor.getName() + 
                        "\nGender:" + donor.getGender() + "\nDonate Amount:" + donor.getDonateAmount() + 
                        "\nDonate Date:" + donor.getDay() + "-" + donor.getMonth() + "-" + donor.getYear());
                System.out.print("Do you want to remove this:");
                choice = userInput.next().charAt(0);
                if(choice == 'Y' || choice == 'y'){
                    donorList.remove(donor);
                    System.out.println("Successful remove.");
                }
            }
        }
    }

    public void modifyDonor(){
        int donorID;
        char choice;
        
        String tempNameTxt;
        char tempGenderTxt;
        double tempdonateAmountTxt;
        int tempDayTxt, tempMonthTxt, tempYearTxt;
        
        Scanner userInput = new Scanner(System.in);   
        Iterator<Donor> it = donorList.getIterator();
        
        System.out.print("Enter Donor id to modify :");
        donorID = userInput.nextInt();
        
        while(it.hasNext()){
            Donor donor = it.next();
            if(donorID== donor.getId()){
                System.out.println("\nID:" + donor.getId() + "\nName:" + donor.getName() + 
                        "\nGender:" + donor.getGender() + "\nDonate Amount:" + donor.getDonateAmount() + 
                        "\nDonate Date:" + donor.getDay() + "-" + donor.getMonth() + "-" + donor.getYear());
                
                System.out.print("Do you want to modify this data:");
                choice = userInput.next().charAt(0);
                if(choice == 'Y' || choice == 'y'){
     
                System.out.print("Enter name: ");
                tempNameTxt = userInput.nextLine();
                do{
                    if(tempNameTxt.isEmpty()){
                        System.out.println("Please enter again.");
                        System.out.print("Enter donor name: ");
                        tempNameTxt = userInput.nextLine();                          
                    }
                }while(tempNameTxt.isEmpty());
        
                System.out.print("Enter donor gender(M/F): ");
                tempGenderTxt = userInput.next().charAt(0);
                do{
                    if(tempGenderTxt != 'M' && tempGenderTxt != 'm' && tempGenderTxt != 'F' && tempGenderTxt != 'f'){
                        System.out.println("Please enter again.");
                        System.out.print("Enter donor gender(M/F): ");
                        tempGenderTxt = userInput.next().charAt(0);                            
                    }
                }while(tempGenderTxt != 'M' && tempGenderTxt != 'm' && tempGenderTxt != 'F' && tempGenderTxt != 'f');
        
                System.out.print("Enter donate amount(XXXX.XX): RM");
                tempdonateAmountTxt = userInput.nextDouble();
        
                System.out.print("Enter donor day(DD): ");
                tempDayTxt = userInput.nextInt();
                do{
                    if(tempDayTxt <=0 || tempDayTxt >=32){
                        System.out.println("Please enter again.");
                        System.out.print("Enter donor day(DD): ");
                        tempDayTxt = userInput.nextInt();
                    } 
                        }while(tempDayTxt <=0 || tempDayTxt >=32);
        
                System.out.print("Enter donor month(MM): ");
                tempMonthTxt = userInput.nextInt();
                do{
                    if(tempMonthTxt <=0 || tempMonthTxt >=13){
                        System.out.println("Please enter again.");
                        System.out.print("Enter donor month(MM): ");
                        tempMonthTxt = userInput.nextInt();
                    }      
                }while(tempMonthTxt <=0 || tempMonthTxt >=13);
        
                System.out.print("Enter donate year(YYYY): ");
                tempYearTxt = userInput.nextInt();
                do{
                    if(tempYearTxt <=2000 || tempYearTxt >=2022){
                        System.out.println("Please enter again.");
                        System.out.print("Enter donate year(YYYY): ");
                        tempYearTxt = userInput.nextInt(); 
                    } 
                }while(tempYearTxt <=2000 || tempYearTxt >=2022);
                donor.setName(tempNameTxt);
                donor.setGender(tempGenderTxt);
                donor.setDonateAmount(tempdonateAmountTxt);
                donor.setDonateDate(tempDayTxt, tempMonthTxt, tempYearTxt);
                System.out.println("\nID:" + donor.getId() + "\nName:" + donor.getName() + 
                        "\nGender:" + donor.getGender() + "\nDonate Amount:" + donor.getDonateAmount() + 
                        "\nDonate Date:" + donor.getDay() + "-" + donor.getMonth() + "-" + donor.getYear());
                System.out.println("Successful modify");    
                }
            }
        }
    }
    
    private void searchDonor(){
        Iterator<Donor> it = donorList.getIterator();
        int donorSearch;
 
        Scanner userInput = new Scanner(System.in);        
        
        System.out.print("Enter Donor id to search :");
        donorSearch = userInput.nextInt();

        while(it.hasNext()){
            Donor donor = it.next();
            if(donorSearch == donor.getId()){
                donorList.contains(donor);
                System.out.println("is found :" + donorList.contains(donor));
                System.out.println("ID:" + donor.getId() + "\nName:" + donor.getName() + 
                        "\nGender:" + donor.getGender() + "\nDonate Amount:" + donor.getDonateAmount() + 
                        "\nDonate Date:" + donor.getDay() + "-" + donor.getMonth() + "-" + donor.getYear());
                
                System.out.println("\nPress enter to exit...");
                try{        
                    System.in.read();}
                catch(Exception e){	
                    e.printStackTrace();
                }
            }
        }
        /*System.out.print("Donor ID:");
        id = userInput.nextLine();
        Donor donor = new Donor(id);
        System.out.println(id + "is found :" + donorList.contains(donor));*/
    }
    
    private void donorReport(){ 
        double totalDonation = 0;
        int choice, whichMonth, whichYear, count = 0;
        
        Iterator<Donor> it = donorList.getIterator();
        Scanner userInput = new Scanner(System.in);        
        
        System.out.println("1. Monthly Report");
        System.out.println("2. Yearly Report");
        System.out.print("Enter your choice:");
        choice = userInput.nextInt();
        
        switch (choice) {
            case 1:
                System.out.print("\nWhich month: ");
                whichMonth = userInput.nextInt();
                System.out.print("Which year: ");
                whichYear = userInput.nextInt();
                
                while(it.hasNext()){
                Donor donor = it.next();
                    if(whichMonth == donor.getMonth() && whichYear == donor.getYear()){
                        System.out.println(donor);
                        totalDonation += donor.getDonateAmount();
                        count++;
                    }
                }
                System.out.printf("\nMonth %d for Year %d has %d record" ,whichMonth, whichYear, count);
                System.out.printf("\nTotal donation amount : RM %.2f\n\n" ,totalDonation);
                System.out.println("Press enter to exit...");
                try{        
                    System.in.read();
                }
                catch(Exception e){	
                    e.printStackTrace();
                }
                break;
            case 2:
                System.out.print("Which year: ");
                whichYear = userInput.nextInt();
                
                while(it.hasNext()){
                Donor donor = it.next();
                    if(whichYear==donor.getYear()){
                        System.out.println(donor);
                        totalDonation += donor.getDonateAmount();
                        count++;
                    }
                }
                System.out.printf("\nYear %d has %d record" , whichYear, count);
                System.out.printf("\nTotal donation amount : RM %.2f\n\n" ,totalDonation);
                System.out.println("\nPress enter to exit...");
                try{        
                    System.in.read();
                }
                catch(Exception e){	
                    e.printStackTrace();
                }
                break;
        }
    }

    private void displayAll() {
        System.out.println("There are " + donorList.getNumberOfEntries() + "record");
        System.out.println("" + donorList.toString());
        System.out.println("\nPress enter to exit...");
        try{        
            System.in.read();
            }
        catch(Exception e){	
            e.printStackTrace();
            }
    }
}
