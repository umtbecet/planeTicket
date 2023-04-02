import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        int distance,age, tripType;
        double totalCost,totalCostWithDiscount=0,discountUnder12=0.5,discountBetween12to24=0.1,discountAbove65=0.3,discountTripType2=0.2;
        double perKMCost = 0.1;
        boolean isError = false;

        Scanner input = new Scanner(System.in);

        System.out.print("Lütfen yaşınızı giriniz : ");
        age = input.nextInt();

        System.out.print("Lütfen yolculuk mesafesini giriniz (KM) : ");
        distance = input.nextInt();

        System.out.print("Yolculuk tipi giriniz ( Tek Yön : 1) ( Gidiş-Dönüş : 2) : ");
        tripType = input.nextInt();

        if ((age>0 && distance>0)&& (tripType==1 || tripType==2)){
            totalCost = perKMCost*distance;

            if(age<=12 && tripType == 2){
                totalCostWithDiscount = totalCost*(1-discountUnder12)*(1-discountTripType2)*2;

            }else if (age<=12 && tripType == 1){
                totalCostWithDiscount =totalCost*(1-discountUnder12);

            }
            if (12<age && age<=24 && tripType == 2){
                totalCostWithDiscount = totalCost*(1-discountBetween12to24)*(1-discountTripType2)*2;

            }else if (12<age && age<=24 && tripType == 1){
                totalCostWithDiscount =totalCost*(1-discountBetween12to24);

            }if (24<age && age<65 && tripType == 2){
                totalCostWithDiscount = totalCost*(1-discountTripType2)*2;

            }else if (24<age && age<65 && tripType == 1){
                totalCostWithDiscount =totalCost;
            }
            if(65<=age  && tripType == 2){
                totalCostWithDiscount = totalCost*(1-discountAbove65)*(1-discountTripType2)*2;
            }else if(65<=age  && tripType == 2){
                totalCostWithDiscount =totalCost*(1-discountAbove65);
            }

        }else {
            isError= true;
        }


        if(isError){
            System.out.println("Hatalı Giriş Yaptınız Tekrar Deneyiniz");
        }else {
            System.out.println("Toplam Tutar :" + totalCostWithDiscount);
        }

    }
}
































