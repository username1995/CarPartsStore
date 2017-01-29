package server;

import java.util.ArrayList;
public class KompozytCzescZlozona extends KomponentCzesci {

    ArrayList<KomponentCzesci> components = new ArrayList<KomponentCzesci>();

    public KompozytCzescZlozona(String name) {
        this.name = name;
    }

    @Override
    public void add(KomponentCzesci component) {
        components.add(component);
    }

    @Override
    public void remove(KomponentCzesci component) {
        components.remove(component);
    }

    @Override
    public KomponentCzesci getComponent(int index) {
        return components.get(index);
    }

    @Override
    public String getNazwa() {
        return name;
    }

    @Override
    public void wyswietlNazwa() {
        System.out.println(getNazwa());
        for (KomponentCzesci component : components) {
            component.wyswietlNazwa();
            
            
          //
        }
    }
    public ArrayList<KomponentCzesci> zwroc() {
        return components;
        }
    }

