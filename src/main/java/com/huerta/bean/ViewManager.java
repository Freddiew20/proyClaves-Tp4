package com.huerta.bean;
import com.huerta.model.Elemento;
import java.io.Serializable;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashMap;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="obj")
@SessionScoped
public class ViewManager implements Serializable{
  private String key;
  private String value;
  private String last;
  private boolean good;
  private List<Elemento> listClaves;
  private Set<String> set;
  private Map<String, String> datos;

  public ViewManager() {
     good=false;
     datos = new HashMap<String, String>();
  }
  public String getLast() {
    return last;
  }
  public List<Elemento> getListClaves() {
    return listClaves;
  }
  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }
  public boolean isGood() {
    return good;
  }
  public String getValue() {
    return value;
  }

  public void setLast(String last) {
    this.last = last;
  }

  public void setValue(String value) {
    this.value = value;
  }
  
  public String add() {
    System.out.println("=" + this.key + "=" + this.value + "=");
    if(!datos.containsKey(this.key)) {
      datos.put(this.key,this.value);
      this.last=this.key;
      this.good=true;
    }else{
      this.good=false;
    }
    this.setKey("");
    this.setValue("");
    return null;
  }

  public void mostrar(){
    if(good==false){
      listClaves = new ArrayList<Elemento>();
      for(Map.Entry<String,String> entry : datos.entrySet()) {
      listClaves.add(new Elemento(entry.getKey(),entry.getValue()));
      this.good = true;
    }
  } else {
      listClaves = new ArrayList<Elemento>();
      this.good = false;
    }
  }
  
}
