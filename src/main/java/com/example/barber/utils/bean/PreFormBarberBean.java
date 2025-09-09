package com.example.barber.utils.bean;



import java.util.List;

//Potrei cambiare quest'ultimo in BarberBean

public class PreFormBarberBean{

    private int idBarber;
    private String barberName;
    private String barberAddress;
    private List<String> serviceList;

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

    public List<String> getServiceList() {
        return serviceList;
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

    public void setServiceList(List<String> serviceList) {
       this.serviceList = serviceList;
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
