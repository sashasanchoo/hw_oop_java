package org.itstep.task05;

public class Money {
    private long hryvnia;
    private byte kopecks;

    public long getHryvnia() {
        return hryvnia;
    }

    public void setHryvnia(long hryvnia) {
        this.hryvnia = hryvnia;
    }

    public byte getKopecks() {
        return kopecks;
    }

    public void setKopecks(byte kopecks) {
        this.kopecks = kopecks;
    }

    public Money(long hryvnia, byte kopecks) {
        this.kopecks = kopecks;
        this.hryvnia = hryvnia;
    }

    public Money(long hryvnia) {
        this.hryvnia = hryvnia;
    }

    public Money() {
    }
    public Money addition(Money money){
        Money result = new Money();
        result.setHryvnia(this.hryvnia + money.hryvnia);
        result.setKopecks((byte)(this.kopecks + money.kopecks));
        return result;
    }
    public Money subtraction(Money money){
        Money result = new Money();
        result.setHryvnia(this.hryvnia - money.hryvnia);
        result.setKopecks((byte)(this.kopecks - money.kopecks));
        return result;
    }
    public Money multiply(double digit){
        Money result = new Money();
        result.setHryvnia((long)(this.hryvnia * digit));
        result.setKopecks((byte)(this.kopecks * digit));
        return result;
    }
    public Money division(double digit){
        Money result = new Money();
        result.setHryvnia((long)(this.hryvnia / digit));
        result.setKopecks((byte)(this.kopecks / digit));
        return result;
    }
    public boolean equals(Money money){
        if(this.hryvnia == money.hryvnia && this.kopecks == money.kopecks){
            return true;
        }
        return false;
    }
}
