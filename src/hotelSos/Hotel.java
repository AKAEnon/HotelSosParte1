package hotelSos;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Quarto> quartos;
    private List<Reserva> reservas;

    public Hotel() {
        this.quartos = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public void cadastrarQuarto(Quarto quarto) {
        quartos.add(quarto);
    }

    public void cadastrarReserva(Reserva reserva) {
        if (verificarDisponibilidadeQuartosPorTipo(reserva.getTipoQuarto(), reserva.getNumeroQuartosReservados())) {
            for (Quarto quarto : quartos) {
                if (quarto.getTipo().equals(reserva.getTipoQuarto()) && quarto.isDisponivel()) {
                    quarto.setDisponivel(false);
                    reservas.add(reserva);
                    System.out.println("Reserva cadastrada com sucesso!");
                    return;
                }
            }
        }
        System.out.println("Não há quartos disponíveis do tipo " + reserva.getTipoQuarto() + " ou todos os quartos já estão ocupados.");
    }

    public void realizarCheckIn(int numeroQuarto) {
        for (Quarto quarto : quartos) {
            if (quarto.getNumero() == numeroQuarto) {
                if (quarto.isDisponivel()) {
                    quarto.setDisponivel(false);
                    System.out.println("Check-in realizado no quarto " + numeroQuarto);
                } else {
                    System.out.println("O quarto " + numeroQuarto + " já está ocupado.");
                }
                return;
            }
        }
        System.out.println("Quarto não encontrado.");
    }

    public void realizarCheckOut(int numeroQuarto) {
        for (Quarto quarto : quartos) {
            if (quarto.getNumero() == numeroQuarto) {
                if (!quarto.isDisponivel()) {
                    quarto.setDisponivel(true);
                    System.out.println("Check-out realizado no quarto " + numeroQuarto);
                } else {
                    System.out.println("O quarto " + numeroQuarto + " já está disponível.");
                }
                return;
            }
        }
        System.out.println("Quarto não encontrado.");
    }

    public void gerarRelatorioOcupacao() {
        System.out.println("Relatório de Ocupação de Quartos:");
        for (Quarto quarto : quartos) {
            System.out.println(quarto);
        }
    }

    public void gerarRelatorioReservas() {
        System.out.println("Histórico de Reservas:");
        for (Reserva reserva : reservas) {
            System.out.println(reserva);
        }
    }

    private boolean verificarDisponibilidadeQuartosPorTipo(String tipo, int quantidade) {
        int count = 0;
        for (Quarto quarto : quartos) {
            if (quarto.getTipo().equals(tipo) && quarto.isDisponivel()) {
                count++;
            }
        }
        return count >= quantidade;
    }
}