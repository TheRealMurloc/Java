package ppj.zad06;

class Wiadomosc{
    int dzien,miesiac,rok;
    String godzina,user,ip,tekst;
    public Wiadomosc(int dzien, int miesiac, int rok, String godzina, String user, String ip, String tekst) {
        this.dzien = dzien;
        this.miesiac = miesiac;
        this.rok = rok;
        this.godzina = godzina;
        this.user = user;
        this.ip = ip;
        this.tekst = tekst;
    }
   
    public int getDzien() {
        return dzien;
    }
 
    public void setDzien(int dzien) {
        this.dzien = dzien;
    }
 
    public int getMiesiac() {
        return miesiac;
    }
 
    public void setMiesiac(int miesiac) {
        this.miesiac = miesiac;
    }
 
    public String getIp() {
        return ip;
    }
 
    public void setIp(String ip) {
        this.ip = ip;
    }
 
    public String toString() {
        return "Wiadomosc [dzien=" + dzien + ", miesiac=" + miesiac + ", rok=" + rok + ", godzina=" + godzina
                + ", user=" + user + ", ip=" + ip + ", tekst=" + tekst + "]";
    }
}