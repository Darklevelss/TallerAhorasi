package Runner;
import Logic.*;
import java.util.Arrays;
import java.util.Scanner;
public class Runner {
    /***
     *
     * @param args
     */
    public static void main(String[] args) {
new Runner().menu();
    }

    /***
     * menu
     */
    public static void menu(){
        ServiceCard serviceCard=new ServiceCard();
        int op=0,op1,op2,op3;
        String num=null;
        float discount=0;
        boolean condition=false;
        Scanner sc = new Scanner(System.in);
        do {



            System.out.println(">>>>>>menú<<<<<<<\n" +
                    "1.añadir tarjetas \n" +
                    "2.hacer llamadas \n" +
                    "3.borrar tarjeta \n" +
                    "4.recargar tarjeta\n" +
                    "5.ver tarjetas\n" +
                    "6.hallar una tarjeta\n" +
                    "7.salir");

            op = sc.nextInt();
            switch (op) {

                case 1:

                    System.out.println("inserte el numero");
                    num=sc.nextLine();
                    num=sc.nextLine();
                    System.out.println("<<<<tipo de tarjeta>>>\n" +
                                    "1.nacional" +
                            "\n2.internacional");
                    op1=sc.nextInt();
                    if (op1==1){
                        CardNational cardNational=new CardNational(num,null);
                        System.out.println("digite el operador" +
                                "\n1.Claro" +
                                "\n2.Tigo" +
                                "\n3.Etb" +
                                "\n4.Virgin" +
                                "\n5.Wom" +
                                "\n6.Movistar");
                        op2= sc.nextInt();
                        switch (op2)
                        {
                            case 1:
                               cardNational.setOperator(Operator.CLARO);
                                break;
                            case 2:
                                cardNational.setOperator(Operator.TIGO);
                                break;
                            case 3:
                                cardNational.setOperator(Operator.ETB);
                                break;
                            case 4:
                                cardNational.setOperator(Operator.VIRGIN);
                                break;
                            case 5:
                                cardNational.setOperator(Operator.WOM);
                                break;
                            case 6:
                                cardNational.setOperator(Operator.MOVISTAR);
                                break;
                            default:
                                System.out.println("opcion no valida");
                                break;
                        }
                        serviceCard.addCard(cardNational);
                    } else if (op1==2) {
                        System.out.println("digite el valor de descuento que quiere tener");
                        discount=sc.nextFloat();
                        if (discount<=100){
                        Card cardInternational=new CardInternational(num,discount/100);
                        serviceCard.addCard(cardInternational);}else {
                            System.out.println("valor no valido");
                            break;
                        }
                    }else{
                        System.out.println("opción no valida");
                        break;
                    }
                   break;
                case 2:
                    System.out.println("digite el numero al cual quiere llamar");
                    num=sc.nextLine();
                    System.out.println("digite el numero de minutos de la llamada");
                    short min=sc.nextShort();
                    serviceCard.call(num,min);
                    if (!serviceCard.call(num,min)){
                        System.out.println("paila");
                        break;
                    }
                    System.out.println(serviceCard.findCard(num).toString());

                    break;
                case 3:
                    System.out.println("ingrese el numero de la tarjeta a borrar");
                    num= sc.nextLine();
                    serviceCard.deleteCard(num);
                    if(serviceCard.deleteCard(num)==null){
                        System.out.println("tarjeta no encontrada");
                    }
                    break;
                case 4:
                    System.out.println("ingrese el numero al cual quiere hacer la recarga");
                    num=sc.nextLine();
                    System.out.println("ingrese la cantidad de saldo en pesos");
                    double balance=sc.nextDouble();
                    if (serviceCard.recharge(num, balance)!=null) {
                        System.out.println(serviceCard.recharge(num, balance).toString());
                    }else{
                        System.out.println("no se pudo hacer la recarga");
                    }
                    break;
                case 5:
                    System.out.println(Arrays.toString(serviceCard.getCards()));
                    break;
                case 6:
                    System.out.println("ingrese el numero de una tarjeta");
                    num=sc.nextLine();
                    num=sc.nextLine();
                    if (serviceCard.findCard(num)==null)
                    {
                        System.out.println("numero no existe");
                        break;
                    }
                    System.out.println(serviceCard.findCard(num).toString());
                    break;
                case 7:
                    System.out.println("matanene");
                    condition=true;


                default:
                    System.out.println("Opción no valida");
                    break;
            }
        }while(condition=false);
    }
}
