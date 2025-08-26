package com.example.barber.utils.bean;



public class PreFormBarberBean{



    private int idBarber;
    private String barberName;
    private String barberAddress;
    //da capire se possiamo usare
    //private List<ServiceModel> serviceModel;

    //Getter
    public int getIdBarber() {
        return idBarber;
    }

    public String getBarberName() {
        return barberName;
    }

    public String getBarberAddress() {
        return barberAddress;
    }

    //Setter
    public void setIdBarber(int idBarber) {
        this.idBarber = idBarber;
    }

    public void setBarberName(String barberName) {
        this.barberName = barberName;
    }

    public void setBarberAddress(String barberAddress) {
        this.barberAddress = barberAddress;
    }



    @Override
    public String toString() {
        return "PreFormBarberBean{" +
                "idBarber=" + idBarber +
                ", barberName='" + barberName + '\'' +
                ", barberAddress='" + barberAddress + '\'' +
                '}';
    }
}
