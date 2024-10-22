package hotelSos;

public class Reserva {
    private String nomeHospede;
    private String dataCheckIn;
    private String dataCheckOut;
    private int numeroQuartosReservados;
    private String tipoQuarto;

    public Reserva(String nomeHospede, String dataCheckIn, String dataCheckOut, int numeroQuartosReservados, String tipoQuarto) {
        this.nomeHospede = nomeHospede;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.numeroQuartosReservados = numeroQuartosReservados;
        this.tipoQuarto = tipoQuarto;
    }

    public String getNomeHospede() {
        return nomeHospede;
    }

    public String getDataCheckIn() {
        return dataCheckIn;
    }

    public String getDataCheckOut() {
        return dataCheckOut;
    }

    public int getNumeroQuartosReservados() {
        return numeroQuartosReservados;
    }

    public String getTipoQuarto() {
        return tipoQuarto;
    }

    @Override
    public String toString() {
        return "Reserva de " + nomeHospede + ": " + numeroQuartosReservados + " quarto(s) do tipo " + tipoQuarto + 
               " de " + dataCheckIn + " até " + dataCheckOut;
    }
}
