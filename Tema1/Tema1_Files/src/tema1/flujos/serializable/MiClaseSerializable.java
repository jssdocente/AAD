package tema1.flujos.serializable;

import java.io.Serializable;

public class MiClaseSerializable implements Serializable {
    String campo1;
    int campo2;
    double campo3;

    public MiClaseSerializable(String campo1, int campo2, double campo3) {
        this.campo1 = campo1;
        this.campo2 = campo2;
        this.campo3 = campo3;
    }

    public String getCampo1() {
        return campo1;
    }

    public void setCampo1(String campo1) {
        this.campo1 = campo1;
    }

    public int getCampo2() {
        return campo2;
    }

    public void setCampo2(int campo2) {
        this.campo2 = campo2;
    }

    public double getCampo3() {
        return campo3;
    }

    public void setCampo3(double campo3) {
        this.campo3 = campo3;
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%s",campo1,campo2,campo3);
    }
}
