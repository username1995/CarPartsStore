package server;

public abstract class Builder {


protected Faktura faktura;



 public void newFaktura(){
faktura = new Faktura();
}

public Faktura getFaktura(){
return faktura;
}


/*
public abstract void buildMonitor();
public abstract void buildProcesor();
public abstract void buildGrafika();
public abstract void buildRam();
public abstract void buildHdd();*/

}
