package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double pocetna, krajnja;
    private boolean pripadaPocetna, pripadaKrajnja;
    Interval(double pocetna, double krajnja, boolean pripadaPocetna, boolean pripadaKrajnja) throws IllegalArgumentException{
        if(pocetna > krajnja) throw new IllegalArgumentException();
        this.pocetna = pocetna;
        this.krajnja = krajnja;
        this.pripadaKrajnja = pripadaKrajnja;
        this.pripadaPocetna = pripadaPocetna;
    }
    Interval(){
        pocetna = krajnja = 0;
        pripadaPocetna = pripadaKrajnja = false;
    }
    public boolean isNull(){
        if(pocetna == 0 && krajnja == 0 && pripadaPocetna == false && pripadaKrajnja == false) return true;
        return false;
    }
    public boolean isIn(double tacka){
        if(tacka < pocetna || tacka > krajnja) return false;
        if(tacka > pocetna && tacka < krajnja) return true;
        if(pripadaPocetna == true && tacka == pocetna) return true;
        if(pripadaKrajnja == true && tacka == krajnja) return true;
        return false;
    }
    public Interval intersect(Interval a){
        Interval presjek = new Interval();
        if(krajnja < a.pocetna || a.krajnja < pocetna) return presjek;
        else if(pocetna < a.pocetna && krajnja < a.krajnja) {
            presjek.pocetna = a.pocetna; presjek.krajnja = krajnja;
            presjek.pripadaPocetna = a.pripadaPocetna; presjek.pripadaKrajnja = pripadaKrajnja;
        }
        else if(a.pocetna < pocetna && a.krajnja < krajnja) {
            presjek.pocetna = pocetna; presjek.krajnja = a.krajnja;
            presjek.pripadaPocetna = pripadaPocetna; presjek.pripadaKrajnja = a.pripadaKrajnja;
        }
        else if(a.pocetna >= pocetna && a.krajnja <= krajnja) {
            presjek.pocetna = a.pocetna; presjek.krajnja = a.krajnja;
            presjek.pripadaPocetna = a.pripadaPocetna; presjek.pripadaKrajnja = a.pripadaKrajnja;
        }
        else if(pocetna >= a.pocetna && krajnja <= a.krajnja) {
            presjek.pocetna = pocetna; presjek.krajnja = krajnja;
            presjek.pripadaPocetna = pripadaPocetna; presjek.pripadaKrajnja = pripadaKrajnja;
        }
        return presjek;
    }
    public static Interval intersect(Interval a, Interval b) {
        Interval presjek = new Interval();
        if(b.krajnja < a.pocetna || a.krajnja < b.pocetna) return presjek;
        else if(b.pocetna < a.pocetna && b.krajnja < a.krajnja) {
            presjek.pocetna = a.pocetna; presjek.krajnja = b.krajnja;
            presjek.pripadaPocetna = a.pripadaPocetna; presjek.pripadaKrajnja = b.pripadaKrajnja;
        }
        else if(a.pocetna < b.pocetna && a.krajnja < b.krajnja) {
            presjek.pocetna = b.pocetna; presjek.krajnja = a.krajnja;
            presjek.pripadaPocetna = b.pripadaPocetna; presjek.pripadaKrajnja = a.pripadaKrajnja;
        }
        else if(a.pocetna >= b.pocetna && a.krajnja <= b.krajnja) {
            presjek.pocetna = a.pocetna; presjek.krajnja = a.krajnja;
            presjek.pripadaPocetna = a.pripadaPocetna; presjek.pripadaKrajnja = a.pripadaKrajnja;
        }
        else if(b.pocetna >= a.pocetna && b.krajnja <= a.krajnja) {
            presjek.pocetna = b.pocetna; presjek.krajnja = b.krajnja;
            presjek.pripadaPocetna = b.pripadaPocetna; presjek.pripadaKrajnja = b.pripadaKrajnja;
        }
        return presjek;
    }

    @Override
    public String toString(){
        String s = new String ();
        if(this.isNull()) return "()";
        if(pripadaPocetna == true) s += "[";
        else s += "(";
        s += pocetna + "," + krajnja;
        if(pripadaKrajnja) s += "]";
        else s += ")";
        return s;
    }

    @Override
    public boolean equals(Object o){
        Interval a = (Interval) o;
        if(pocetna == a.pocetna && krajnja == a.krajnja && pripadaPocetna == a.pripadaPocetna && pripadaKrajnja == a.pripadaKrajnja) return true;
        return false;
    }
}