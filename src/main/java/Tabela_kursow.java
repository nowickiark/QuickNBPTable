import java.util.ArrayList;

public class Tabela_kursow {
 private String numer_tabeli;
 private String data_publikacji;
 ArrayList < Object > pozycja = new ArrayList < Object > ();
 private String _typ;
 private String _uid;


 // Getter Methods 

 public String getNumer_tabeli() {
  return numer_tabeli;
 }

 public String getData_publikacji() {
  return data_publikacji;
 }

 public String get_typ() {
  return _typ;
 }

 public String get_uid() {
  return _uid;
 }

 // Setter Methods 

 public void setNumer_tabeli(String numer_tabeli) {
  this.numer_tabeli = numer_tabeli;
 }

 public void setData_publikacji(String data_publikacji) {
  this.data_publikacji = data_publikacji;
 }

 public void set_typ(String _typ) {
  this._typ = _typ;
 }

 public void set_uid(String _uid) {
  this._uid = _uid;
 }
}