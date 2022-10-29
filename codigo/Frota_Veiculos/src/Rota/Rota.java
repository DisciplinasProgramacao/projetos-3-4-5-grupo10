package Rota;

import java.util.Date;

public class Rota {
    private Date date;
    private int distance;

    public Rota(Date date, int distance) {
        this.date = date;
        this.distance = distance;
    }

    public Date getDate() {
        return date;
    }

    public int getDistance() {
        return distance;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
