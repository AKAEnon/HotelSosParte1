package hotelSos;

import java.util.Scanner;

public class PrincipalHotel {
    public static void main(String[] args) {
    	 Hotel hotel = new Hotel();
         Scanner scanner = new Scanner(System.in);
         int op;
         do {
        	 System.out.println("\n");
             System.out.println("--- Menu do Hotel ---");
             System.out.println("1. Cadastrar Quarto");
             System.out.println("2. Fazer Reserva");
             System.out.println("3. Realizar Check-in");
             System.out.println("4. Realizar Check-out");
             System.out.println("5. Relatório de Ocupação");
             System.out.println("6. Relatório de Reservas");
             System.out.println("0. Sair");
             System.out.print("Escolha uma opção: ");
             op = scanner.nextInt();
             scanner.nextLine();

             switch (op) {
                 case 1:
                     System.out.print("Número do quarto: ");
                     int numero = scanner.nextInt();
                     scanner.nextLine();

                     System.out.println("Digite 1 para solteiro, 2 para casal, 3 para suíte: ");
                     int tipoQuarto = scanner.nextInt();
                     scanner.nextLine();
                     String tipo;

                     switch (tipoQuarto) {
                         case 1:
                             tipo = "solteiro";
                             break;
                         case 2:
                             tipo = "casal";
                             break;
                         case 3:
                             tipo = "suite";
                             break;
                         default:
                             System.out.println("Opção inválida! Tipo de quarto será 'solteiro' por padrão.");
                             tipo = "solteiro";
                     }

                     System.out.print("Preço diário: ");
                     double precoDiario = scanner.nextDouble();

                     Quarto novoQuarto = new Quarto(numero, tipo, precoDiario);
                     hotel.cadastrarQuarto(novoQuarto);
                     System.out.println("Quarto cadastrado com sucesso!");
                     break;

                 case 2:
                     System.out.print("Nome do hóspede: ");
                     String nomeHospede = scanner.nextLine();

                     System.out.print("Data de check-in (dia/mês/ano): ");
                     String dataCheckIn = scanner.nextLine();

                     System.out.print("Data de check-out (dia/mês/ano): ");
                     String dataCheckOut = scanner.nextLine();

                     System.out.print("Número de quartos reservados: ");
                     int numeroQuartosReservados = scanner.nextInt();
                     scanner.nextLine();

                     System.out.println("Digite 1 para solteiro, 2 para casal, 3 para suíte: ");
                     int tipoQuartoReservado = scanner.nextInt();
                     scanner.nextLine();
                     String tipoQuartoSelecionado;

                     switch (tipoQuartoReservado) {
                         case 1:
                             tipoQuartoSelecionado = "solteiro";
                             break;
                         case 2:
                             tipoQuartoSelecionado = "casal";
                             break;
                         case 3:
                             tipoQuartoSelecionado = "suite";
                             break;
                         default:
                             System.out.println("Opção inválida! Tipo de quarto será 'solteiro' por padrão.");
                             tipoQuartoSelecionado = "solteiro";
                     }

                     Reserva novaReserva = new Reserva(nomeHospede, dataCheckIn, dataCheckOut, numeroQuartosReservados, tipoQuartoSelecionado);
                     hotel.cadastrarReserva(novaReserva);
                     break;

                 case 3:
                     System.out.print("Número do quarto para check-in: ");
                     int numeroQuartoCheckIn = scanner.nextInt();
                     hotel.realizarCheckIn(numeroQuartoCheckIn);
                     break;

                 case 4:
                     System.out.print("Número do quarto para check-out: ");
                     int numeroQuartoCheckOut = scanner.nextInt();
                     hotel.realizarCheckOut(numeroQuartoCheckOut);
                     break;

                 case 5:
                     hotel.gerarRelatorioOcupacao();
                     break;

                 case 6:
                     hotel.gerarRelatorioReservas();
                     break;

                 case 0:
                     System.out.println("Obrigado por usar o sistema!");
                     break;

                 default:
                     System.out.println("Opção inválida! Tente novamente.");
             }
         } while (op != 0);

         scanner.close();
     }
 }