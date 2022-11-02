package Runner;
import Logic.*;
import java.util.Arrays;
import java.util.Scanner;
public class Runner {
    public static void main(String[] args) {
new Runner().menu();
    }
    public static void menu(){
        ServiceCard serviceCard=new ServiceCard();
        int op=0,op1,op2,op3;
        String num;
        boolean condition=false;
        do {


            Scanner sc = new Scanner(System.in);
            System.out.println(">>>>>>menú<<<<<<<" +
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
                    System.out.println("<<<<tipo de tarjeta>>>\n" +
                                    "1.nacional" +
                            "\n2.internacional");
                    op1=sc.nextInt();
                    if (op==1){
                        CardNational cardNational=new CardNational(num,null);
                        System.out.println("digite el operador" +
                                "1.Claro" +
                                "2.Tigo" +
                                "3.Etb" +
                                "4.Virgin" +
                                "5.Wom" +
                                "6.Movistar");
                        op2= sc.nextInt();
                        switch (op2)
                        {
                            case 1:
                               cardNational.setOperator(Operator.CLARO);
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
                        float discount=sc.nextFloat();
                        Card cardInternational=new CardInternational(num,discount);
                        serviceCard.addCard(cardInternational);
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
                    if (serviceCard.findCard(num)==null)
                    {
                        System.out.println("numero no existe");
                        break;
                    }
                    System.out.println(serviceCard.findCard(num).toString());

                case 7:
                    System.out.println("matanene");
                    condition=true;

                    break;
                default:
                    System.out.println("Opción no valida");
                    break;
            }
        }while(condition);
    }
}
